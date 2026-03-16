package net.bytebuddy.implementation.bytecode.constant;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.auxiliary.PrivilegedMemberLookupAction;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MethodConstant extends StackManipulation.AbstractBase {

    @MaybeNull
    protected static final MethodDescription.InDefinedShape DO_PRIVILEGED = doPrivileged();
    protected final MethodDescription.InDefinedShape methodDescription;

    public static class CachedConstructor implements StackManipulation {
        private static final TypeDescription CONSTRUCTOR_TYPE = TypeDescription.ForLoadedType.of(Constructor.class);
        private final StackManipulation constructorConstant;

        public CachedConstructor(StackManipulation stackManipulation) {
            this.constructorConstant = stackManipulation;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return FieldAccess.forField(context.cache(this.constructorConstant, CONSTRUCTOR_TYPE)).read().apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.constructorConstant.equals(((CachedConstructor) obj).constructorConstant);
        }

        public int hashCode() {
            return this.constructorConstant.hashCode();
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return this.constructorConstant.isValid();
        }
    }

    public static class CachedMethod implements StackManipulation {
        private static final TypeDescription METHOD_TYPE = TypeDescription.ForLoadedType.of(Method.class);
        private final StackManipulation methodConstant;

        public CachedMethod(StackManipulation stackManipulation) {
            this.methodConstant = stackManipulation;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return FieldAccess.forField(context.cache(this.methodConstant, METHOD_TYPE)).read().apply(methodVisitor, context);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.methodConstant.equals(((CachedMethod) obj).methodConstant);
        }

        public int hashCode() {
            return this.methodConstant.hashCode();
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return this.methodConstant.isValid();
        }
    }

    public interface CanCache extends StackManipulation {
        StackManipulation cached();
    }

    public enum CanCacheIllegal implements CanCache {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return StackManipulation.Illegal.INSTANCE.apply(methodVisitor, context);
        }

        @Override // net.bytebuddy.implementation.bytecode.constant.MethodConstant.CanCache
        public StackManipulation cached() {
            return StackManipulation.Illegal.INSTANCE;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return false;
        }
    }

    public static class ForConstructor extends MethodConstant implements CanCache {
        private static final MethodDescription.InDefinedShape GET_CONSTRUCTOR;
        private static final MethodDescription.InDefinedShape GET_DECLARED_CONSTRUCTOR;

        static {
            try {
                GET_CONSTRUCTOR = new MethodDescription.ForLoadedMethod(Class.class.getMethod("getConstructor", Class[].class));
                GET_DECLARED_CONSTRUCTOR = new MethodDescription.ForLoadedMethod(Class.class.getMethod(TypeProxy.SilentConstruction.Appender.GET_DECLARED_CONSTRUCTOR_METHOD_NAME, Class[].class));
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException("Could not locate Class::getDeclaredConstructor", e);
            }
        }

        public ForConstructor(MethodDescription.InDefinedShape inDefinedShape) {
            super(inDefinedShape);
        }

        @Override // net.bytebuddy.implementation.bytecode.constant.MethodConstant
        public MethodDescription.InDefinedShape accessorMethod() {
            return this.methodDescription.isPublic() ? GET_CONSTRUCTOR : GET_DECLARED_CONSTRUCTOR;
        }

        @Override // net.bytebuddy.implementation.bytecode.constant.MethodConstant.CanCache
        public StackManipulation cached() {
            return new CachedConstructor(this);
        }

        @Override // net.bytebuddy.implementation.bytecode.constant.MethodConstant
        public StackManipulation methodName() {
            return StackManipulation.Trivial.INSTANCE;
        }
    }

    public static class ForMethod extends MethodConstant implements CanCache {
        private static final MethodDescription.InDefinedShape GET_DECLARED_METHOD;
        private static final MethodDescription.InDefinedShape GET_METHOD;

        static {
            try {
                GET_METHOD = new MethodDescription.ForLoadedMethod(Class.class.getMethod("getMethod", String.class, Class[].class));
                GET_DECLARED_METHOD = new MethodDescription.ForLoadedMethod(Class.class.getMethod("getDeclaredMethod", String.class, Class[].class));
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException("Could not locate method lookup", e);
            }
        }

        public ForMethod(MethodDescription.InDefinedShape inDefinedShape) {
            super(inDefinedShape);
        }

        @Override // net.bytebuddy.implementation.bytecode.constant.MethodConstant
        public MethodDescription.InDefinedShape accessorMethod() {
            return this.methodDescription.isPublic() ? GET_METHOD : GET_DECLARED_METHOD;
        }

        @Override // net.bytebuddy.implementation.bytecode.constant.MethodConstant.CanCache
        public StackManipulation cached() {
            return new CachedMethod(this);
        }

        @Override // net.bytebuddy.implementation.bytecode.constant.MethodConstant
        public StackManipulation methodName() {
            return new TextConstant(this.methodDescription.getInternalName());
        }
    }

    public static class PrivilegedLookup implements StackManipulation, CanCache {
        private final MethodDescription.InDefinedShape methodDescription;
        private final StackManipulation methodName;

        public PrivilegedLookup(MethodDescription.InDefinedShape inDefinedShape, StackManipulation stackManipulation) {
            this.methodDescription = inDefinedShape;
            this.methodName = stackManipulation;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            MethodDescription.InDefinedShape inDefinedShape = MethodConstant.DO_PRIVILEGED;
            if (inDefinedShape == null) {
                throw new IllegalStateException("Privileged method invocation is not supported on the current VM");
            }
            TypeDescription typeDescriptionRegister = context.register(PrivilegedMemberLookupAction.of(this.methodDescription));
            return new StackManipulation.Compound(TypeCreation.of(typeDescriptionRegister), Duplication.SINGLE, ClassConstant.of(this.methodDescription.getDeclaringType()), this.methodName, ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class)).withValues(MethodConstant.typeConstantsFor(this.methodDescription.getParameters().asTypeList().asErasures())), MethodInvocation.invoke((MethodDescription.InDefinedShape) typeDescriptionRegister.getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly()), MethodInvocation.invoke(inDefinedShape), TypeCasting.to(TypeDescription.ForLoadedType.of(this.methodDescription.isConstructor() ? Constructor.class : Method.class))).apply(methodVisitor, context);
        }

        @Override // net.bytebuddy.implementation.bytecode.constant.MethodConstant.CanCache
        public StackManipulation cached() {
            return this.methodDescription.isConstructor() ? new CachedConstructor(this) : new CachedMethod(this);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.methodDescription.equals(((PrivilegedLookup) obj).methodDescription);
        }

        public int hashCode() {
            return this.methodDescription.hashCode();
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return this.methodName.isValid();
        }
    }

    public MethodConstant(MethodDescription.InDefinedShape inDefinedShape) {
        this.methodDescription = inDefinedShape;
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
    @MaybeNull
    private static MethodDescription.InDefinedShape doPrivileged() {
        try {
            MethodDescription.ForLoadedMethod forLoadedMethod = new MethodDescription.ForLoadedMethod(Class.forName("java.security.AccessController").getMethod("doPrivileged", PrivilegedExceptionAction.class));
            try {
                if (!Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"))) {
                    return null;
                }
            } catch (SecurityException unused) {
            }
            return forLoadedMethod;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static CanCache of(MethodDescription.InDefinedShape inDefinedShape) {
        return inDefinedShape.isTypeInitializer() ? CanCacheIllegal.INSTANCE : inDefinedShape.isConstructor() ? new ForConstructor(inDefinedShape) : new ForMethod(inDefinedShape);
    }

    public static CanCache ofPrivileged(MethodDescription.InDefinedShape inDefinedShape) {
        return DO_PRIVILEGED == null ? of(inDefinedShape) : inDefinedShape.isTypeInitializer() ? CanCacheIllegal.INSTANCE : inDefinedShape.isConstructor() ? new ForConstructor(inDefinedShape).withPrivilegedLookup() : new ForMethod(inDefinedShape).withPrivilegedLookup();
    }

    public static List<StackManipulation> typeConstantsFor(List<TypeDescription> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<TypeDescription> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ClassConstant.of(it.next()));
        }
        return arrayList;
    }

    public abstract MethodDescription.InDefinedShape accessorMethod();

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        return new StackManipulation.Compound(ClassConstant.of(this.methodDescription.getDeclaringType()), methodName(), ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Class.class)).withValues(typeConstantsFor(this.methodDescription.getParameters().asTypeList().asErasures())), MethodInvocation.invoke(accessorMethod())).apply(methodVisitor, context);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.methodDescription.equals(((MethodConstant) obj).methodDescription);
    }

    public int hashCode() {
        return this.methodDescription.hashCode();
    }

    public abstract StackManipulation methodName();

    public CanCache withPrivilegedLookup() {
        return new PrivilegedLookup(this.methodDescription, methodName());
    }
}
