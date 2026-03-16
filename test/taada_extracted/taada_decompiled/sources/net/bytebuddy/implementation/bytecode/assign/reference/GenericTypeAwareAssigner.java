package net.bytebuddy.implementation.bytecode.assign.reference;

import com.google.protobuf.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.utility.QueueFactory;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public enum GenericTypeAwareAssigner implements Assigner {
    INSTANCE;

    @HashCodeAndEqualsPlugin.Enhance
    public static class IsAssignableToVisitor implements TypeDescription.Generic.Visitor<Boolean> {
        private final boolean polymorphic;
        private final TypeDescription.Generic typeDescription;

        public static class OfGenericArray extends OfManifestType {
            public OfGenericArray(TypeDescription.Generic generic, boolean z6) {
                super(generic, z6);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                TypeDescription.Generic componentType = this.typeDescription.getComponentType();
                TypeDescription.Generic componentType2 = generic.getComponentType();
                while (componentType.getSort().isGenericArray() && componentType2.getSort().isGenericArray()) {
                    componentType = componentType.getComponentType();
                    componentType2 = componentType2.getComponentType();
                }
                return Boolean.valueOf((componentType.getSort().isGenericArray() || componentType2.getSort().isGenericArray() || !((Boolean) componentType.accept(new IsAssignableToVisitor(componentType2))).booleanValue()) ? false : true);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                return Boolean.valueOf(this.polymorphic ? this.typeDescription.asErasure().isAssignableTo(generic.asErasure()) : this.typeDescription.asErasure().equals(generic.asErasure()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class OfManifestType implements TypeDescription.Generic.Visitor<Boolean> {
            protected final boolean polymorphic;
            protected final TypeDescription.Generic typeDescription;

            public OfManifestType(TypeDescription.Generic generic, boolean z6) {
                this.typeDescription = generic;
                this.polymorphic = z6;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                OfManifestType ofManifestType = (OfManifestType) obj;
                return this.polymorphic == ofManifestType.polymorphic && this.typeDescription.equals(ofManifestType.typeDescription);
            }

            public int hashCode() {
                return a.h(this.typeDescription, getClass().hashCode() * 31, 31) + (this.polymorphic ? 1 : 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onTypeVariable(TypeDescription.Generic generic) {
                if (generic.getTypeVariableSource().isInferrable()) {
                    throw new UnsupportedOperationException("Assignability checks for type variables declared by methods arel not currently supported");
                }
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onWildcard(TypeDescription.Generic generic) {
                Iterator<TypeDescription.Generic> it = generic.getUpperBounds().iterator();
                while (it.hasNext()) {
                    if (!((Boolean) this.typeDescription.accept(new IsAssignableToVisitor(it.next()))).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                Iterator<TypeDescription.Generic> it2 = generic.getLowerBounds().iterator();
                while (it2.hasNext()) {
                    if (!((Boolean) it2.next().accept(new IsAssignableToVisitor(this.typeDescription))).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
        }

        public static class OfNonGenericType extends OfSimpleType {
            public OfNonGenericType(TypeDescription.Generic generic, boolean z6) {
                super(generic, z6);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.valueOf(this.polymorphic ? this.typeDescription.asErasure().isAssignableTo(generic.asErasure()) : this.typeDescription.asErasure().equals(generic.asErasure()));
            }
        }

        public static class OfParameterizedType extends OfSimpleType {
            public OfParameterizedType(TypeDescription.Generic generic, boolean z6) {
                super(generic, z6);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }
        }

        public static abstract class OfSimpleType extends OfManifestType {
            public OfSimpleType(TypeDescription.Generic generic, boolean z6) {
                super(generic, z6);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                return Boolean.valueOf(this.polymorphic ? this.typeDescription.asErasure().isAssignableTo(generic.asErasure()) : this.typeDescription.asErasure().equals(generic.asErasure()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                Queue queueMake = QueueFactory.make(Collections.singleton(this.typeDescription));
                HashSet hashSet = new HashSet(Collections.singleton(this.typeDescription.asErasure()));
                do {
                    TypeDescription.Generic generic2 = (TypeDescription.Generic) queueMake.remove();
                    if (generic2.asErasure().equals(generic.asErasure())) {
                        if (generic2.getSort().isNonGeneric()) {
                            return Boolean.TRUE;
                        }
                        TypeList.Generic typeArguments = generic2.getTypeArguments();
                        TypeList.Generic typeArguments2 = generic.getTypeArguments();
                        int size = typeArguments2.size();
                        if (typeArguments.size() != size) {
                            return Boolean.FALSE;
                        }
                        for (int i = 0; i < size; i++) {
                            if (!((Boolean) typeArguments.get(i).accept(new IsAssignableToVisitor(typeArguments2.get(i), false))).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        TypeDescription.Generic ownerType = generic.getOwnerType();
                        return Boolean.valueOf(ownerType == null || ((Boolean) ownerType.accept(new IsAssignableToVisitor(ownerType))).booleanValue());
                    }
                    if (this.polymorphic) {
                        TypeDescription.Generic superClass = generic2.getSuperClass();
                        if (superClass != null && hashSet.add(superClass.asErasure())) {
                            queueMake.add(superClass);
                        }
                        for (TypeDescription.Generic generic3 : generic2.getInterfaces()) {
                            if (hashSet.add(generic3.asErasure())) {
                                queueMake.add(generic3);
                            }
                        }
                    }
                } while (!queueMake.isEmpty());
                return Boolean.FALSE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfWildcard implements TypeDescription.Generic.Visitor<Boolean> {
            private final TypeDescription.Generic wildcard;

            public OfWildcard(TypeDescription.Generic generic) {
                this.wildcard = generic;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.wildcard.equals(((OfWildcard) obj).wildcard);
            }

            public int hashCode() {
                return this.wildcard.hashCode() + (getClass().hashCode() * 31);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onTypeVariable(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onWildcard(TypeDescription.Generic generic) {
                boolean z6;
                boolean z7 = false;
                while (true) {
                    for (TypeDescription.Generic generic2 : generic.getUpperBounds()) {
                        Iterator<TypeDescription.Generic> it = this.wildcard.getUpperBounds().iterator();
                        while (it.hasNext()) {
                            if (!((Boolean) it.next().accept(new IsAssignableToVisitor(generic2))).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        z6 = z6 || !generic2.represents(Object.class);
                    }
                    boolean z8 = false;
                    for (TypeDescription.Generic generic3 : generic.getLowerBounds()) {
                        Iterator<TypeDescription.Generic> it2 = this.wildcard.getLowerBounds().iterator();
                        while (it2.hasNext()) {
                            if (!((Boolean) generic3.accept(new IsAssignableToVisitor(it2.next()))).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        z8 = true;
                    }
                    if (z6) {
                        return Boolean.valueOf(this.wildcard.getLowerBounds().isEmpty());
                    }
                    if (!z8) {
                        return Boolean.TRUE;
                    }
                    TypeList.Generic upperBounds = this.wildcard.getUpperBounds();
                    if (upperBounds.size() == 0 || (upperBounds.size() == 1 && upperBounds.getOnly().represents(Object.class))) {
                        z7 = true;
                    }
                    return Boolean.valueOf(z7);
                }
            }
        }

        public IsAssignableToVisitor(TypeDescription.Generic generic) {
            this(generic, true);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IsAssignableToVisitor isAssignableToVisitor = (IsAssignableToVisitor) obj;
            return this.polymorphic == isAssignableToVisitor.polymorphic && this.typeDescription.equals(isAssignableToVisitor.typeDescription);
        }

        public int hashCode() {
            return a.h(this.typeDescription, getClass().hashCode() * 31, 31) + (this.polymorphic ? 1 : 0);
        }

        public IsAssignableToVisitor(TypeDescription.Generic generic, boolean z6) {
            this.typeDescription = generic;
            this.polymorphic = z6;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onGenericArray(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfGenericArray(generic, this.polymorphic));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onNonGenericType(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfNonGenericType(generic, this.polymorphic));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onParameterizedType(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfParameterizedType(generic, this.polymorphic));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onTypeVariable(TypeDescription.Generic generic) {
            if (generic.getTypeVariableSource().isInferrable()) {
                throw new UnsupportedOperationException("Assignability checks for type variables declared by methods are not currently supported");
            }
            if (generic.equals(this.typeDescription)) {
                return Boolean.TRUE;
            }
            if (!this.polymorphic) {
                return Boolean.FALSE;
            }
            Queue queueMake = QueueFactory.make(generic.getUpperBounds());
            while (!queueMake.isEmpty()) {
                TypeDescription.Generic generic2 = (TypeDescription.Generic) queueMake.remove();
                if (((Boolean) generic2.accept(new IsAssignableToVisitor(this.typeDescription))).booleanValue()) {
                    return Boolean.TRUE;
                }
                if (generic2.getSort().isTypeVariable()) {
                    queueMake.addAll(generic2.getUpperBounds());
                }
            }
            return Boolean.FALSE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onWildcard(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfWildcard(generic));
        }
    }

    @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
    public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
        return (generic.isPrimitive() || generic2.isPrimitive()) ? generic.equals(generic2) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE : ((Boolean) generic.accept(new IsAssignableToVisitor(generic2))).booleanValue() ? StackManipulation.Trivial.INSTANCE : typing.isDynamic() ? generic.asErasure().isAssignableTo(generic2.asErasure()) ? StackManipulation.Trivial.INSTANCE : TypeCasting.to(generic2) : StackManipulation.Illegal.INSTANCE;
    }
}
