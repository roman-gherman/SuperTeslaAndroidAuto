package net.bytebuddy.implementation.bind.annotation;

import com.google.protobuf.a;
import java.io.Serializable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Collections;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.ExceptionMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldProxy {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Binder extends TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFieldBinding<FieldProxy> {
        private static final MethodDescription.InDefinedShape DECLARING_TYPE;
        private static final MethodDescription.InDefinedShape FIELD_NAME;
        private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY;
        private final FieldResolver.Factory fieldResolverFactory;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public static class AccessorProxy extends StackManipulation.AbstractBase implements AuxiliaryType {
            protected static final String FIELD_NAME = "instance";
            private final Assigner assigner;
            private final FieldDescription fieldDescription;
            private final FieldResolver fieldResolver;
            private final TypeDescription instrumentedType;
            private final boolean serializableProxy;

            public AccessorProxy(FieldDescription fieldDescription, TypeDescription typeDescription, FieldResolver fieldResolver, Assigner assigner, boolean z6) {
                this.fieldDescription = fieldDescription;
                this.instrumentedType = typeDescription;
                this.fieldResolver = fieldResolver;
                this.assigner = assigner;
                this.serializableProxy = z6;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                TypeDescription typeDescriptionRegister = context.register(this);
                return new StackManipulation.Compound(TypeCreation.of(typeDescriptionRegister), Duplication.SINGLE, this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), MethodInvocation.invoke((MethodDescription.InDefinedShape) typeDescriptionRegister.getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly())).apply(methodVisitor, context);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                AccessorProxy accessorProxy = (AccessorProxy) obj;
                return this.serializableProxy == accessorProxy.serializableProxy && this.fieldDescription.equals(accessorProxy.fieldDescription) && this.instrumentedType.equals(accessorProxy.instrumentedType) && this.fieldResolver.equals(accessorProxy.fieldResolver) && this.assigner.equals(accessorProxy.assigner);
            }

            @Override // net.bytebuddy.implementation.auxiliary.AuxiliaryType
            public String getSuffix() {
                StringBuilder sb = new StringBuilder();
                sb.append(RandomString.hashOf(this.fieldDescription.hashCode()));
                sb.append(this.serializableProxy ? "S" : "0");
                return sb.toString();
            }

            public int hashCode() {
                return ((this.assigner.hashCode() + ((this.fieldResolver.hashCode() + a.i(this.instrumentedType, (this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31, 31)) * 31)) * 31) + (this.serializableProxy ? 1 : 0);
            }

            @Override // net.bytebuddy.implementation.auxiliary.AuxiliaryType
            public DynamicType make(String str, ClassFileVersion classFileVersion, MethodAccessorFactory methodAccessorFactory) {
                return this.fieldResolver.apply(new ByteBuddy(classFileVersion).with(TypeValidation.DISABLED).subclass(this.fieldResolver.getProxyType(), ConstructorStrategy.Default.NO_CONSTRUCTORS).name(str).modifiers(AuxiliaryType.DEFAULT_TYPE_MODIFIER).implement(this.serializableProxy ? new Class[]{Serializable.class} : new Class[0]).defineConstructor(new ModifierContributor.ForMethod[0]).withParameters((Collection<? extends TypeDefinition>) (this.fieldDescription.isStatic() ? Collections.EMPTY_LIST : Collections.singletonList(this.instrumentedType))).intercept(this.fieldDescription.isStatic() ? StaticFieldConstructor.INSTANCE : new InstanceFieldConstructor(this.instrumentedType)), this.fieldDescription, this.assigner, methodAccessorFactory).make();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class FieldGetter implements Implementation {
            private final Assigner assigner;
            private final FieldDescription fieldDescription;
            private final MethodAccessorFactory methodAccessorFactory;

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class Appender implements ByteCodeAppender {
                private final TypeDescription typeDescription;

                public Appender(Implementation.Target target) {
                    this.typeDescription = target.getInstrumentedType();
                }

                @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                    MethodDescription.InDefinedShape inDefinedShapeRegisterGetterFor = FieldGetter.this.methodAccessorFactory.registerGetterFor(FieldGetter.this.fieldDescription, MethodAccessorFactory.AccessType.DEFAULT);
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(FieldGetter.this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : new StackManipulation.Compound(MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape) this.typeDescription.getDeclaredFields().filter(ElementMatchers.named("instance")).getOnly()).read()), MethodInvocation.invoke((MethodDescription) inDefinedShapeRegisterGetterFor), FieldGetter.this.assigner.assign(inDefinedShapeRegisterGetterFor.getReturnType(), methodDescription.getReturnType(), Assigner.Typing.DYNAMIC), MethodReturn.of(methodDescription.getReturnType().asErasure())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Appender appender = (Appender) obj;
                    return this.typeDescription.equals(appender.typeDescription) && FieldGetter.this.equals(FieldGetter.this);
                }

                public int hashCode() {
                    return FieldGetter.this.hashCode() + a.i(this.typeDescription, getClass().hashCode() * 31, 31);
                }
            }

            public FieldGetter(FieldDescription fieldDescription, Assigner assigner, MethodAccessorFactory methodAccessorFactory) {
                this.fieldDescription = fieldDescription;
                this.assigner = assigner;
                this.methodAccessorFactory = methodAccessorFactory;
            }

            @Override // net.bytebuddy.implementation.Implementation
            public ByteCodeAppender appender(Implementation.Target target) {
                return new Appender(target);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                FieldGetter fieldGetter = (FieldGetter) obj;
                return this.fieldDescription.equals(fieldGetter.fieldDescription) && this.assigner.equals(fieldGetter.assigner) && this.methodAccessorFactory.equals(fieldGetter.methodAccessorFactory);
            }

            public int hashCode() {
                return this.methodAccessorFactory.hashCode() + ((this.assigner.hashCode() + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        public interface FieldResolver {

            public interface Factory {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Duplex implements Factory {
                    private final MethodDescription.InDefinedShape getterMethod;
                    private final TypeDescription proxyType;
                    private final MethodDescription.InDefinedShape setterMethod;

                    public Duplex(TypeDescription typeDescription, MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2) {
                        this.proxyType = typeDescription;
                        this.getterMethod = inDefinedShape;
                        this.setterMethod = inDefinedShape2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Duplex duplex = (Duplex) obj;
                        return this.proxyType.equals(duplex.proxyType) && this.getterMethod.equals(duplex.getterMethod) && this.setterMethod.equals(duplex.setterMethod);
                    }

                    public int hashCode() {
                        return this.setterMethod.hashCode() + ((this.getterMethod.hashCode() + a.i(this.proxyType, getClass().hashCode() * 31, 31)) * 31);
                    }

                    @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver.Factory
                    public FieldResolver resolve(TypeDescription typeDescription, FieldDescription fieldDescription) {
                        if (typeDescription.equals(this.proxyType)) {
                            return new ForGetterSetterPair(this.proxyType, this.getterMethod, this.setterMethod);
                        }
                        throw new IllegalStateException("Cannot use @FieldProxy on a non-installed type");
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simplex implements Factory {
                    private final MethodDescription.InDefinedShape getterMethod;
                    private final MethodDescription.InDefinedShape setterMethod;

                    public Simplex(MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2) {
                        this.getterMethod = inDefinedShape;
                        this.setterMethod = inDefinedShape2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simplex simplex = (Simplex) obj;
                        return this.getterMethod.equals(simplex.getterMethod) && this.setterMethod.equals(simplex.setterMethod);
                    }

                    public int hashCode() {
                        return this.setterMethod.hashCode() + ((this.getterMethod.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver.Factory
                    public FieldResolver resolve(TypeDescription typeDescription, FieldDescription fieldDescription) {
                        if (typeDescription.equals(this.getterMethod.getDeclaringType())) {
                            return new ForGetter(this.getterMethod);
                        }
                        if (typeDescription.equals(this.setterMethod.getDeclaringType())) {
                            return fieldDescription.isFinal() ? Unresolved.INSTANCE : new ForSetter(this.setterMethod);
                        }
                        throw new IllegalStateException("Cannot use @FieldProxy on a non-installed type");
                    }
                }

                FieldResolver resolve(TypeDescription typeDescription, FieldDescription fieldDescription);
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForGetter implements FieldResolver {
                private final MethodDescription.InDefinedShape getterMethod;

                public ForGetter(MethodDescription.InDefinedShape inDefinedShape) {
                    this.getterMethod = inDefinedShape;
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, FieldDescription fieldDescription, Assigner assigner, MethodAccessorFactory methodAccessorFactory) {
                    return builder.method(ElementMatchers.definedMethod(ElementMatchers.is(this.getterMethod))).intercept(new FieldGetter(fieldDescription, assigner, methodAccessorFactory));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.getterMethod.equals(((ForGetter) obj).getterMethod);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public TypeDescription getProxyType() {
                    return this.getterMethod.getDeclaringType();
                }

                public int hashCode() {
                    return this.getterMethod.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public boolean isResolved() {
                    return true;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForGetterSetterPair implements FieldResolver {
                private final MethodDescription.InDefinedShape getterMethod;
                private final TypeDescription proxyType;
                private final MethodDescription.InDefinedShape setterMethod;

                public ForGetterSetterPair(TypeDescription typeDescription, MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2) {
                    this.proxyType = typeDescription;
                    this.getterMethod = inDefinedShape;
                    this.setterMethod = inDefinedShape2;
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, FieldDescription fieldDescription, Assigner assigner, MethodAccessorFactory methodAccessorFactory) {
                    Implementation fieldSetter;
                    DynamicType.Builder.MethodDefinition.ImplementationDefinition<?> implementationDefinitionMethod = builder.method(ElementMatchers.is(this.getterMethod)).intercept(new FieldGetter(fieldDescription, assigner, methodAccessorFactory)).method(ElementMatchers.is(this.setterMethod));
                    if (fieldDescription.isFinal()) {
                        fieldSetter = ExceptionMethod.throwing((Class<? extends Throwable>) UnsupportedOperationException.class, "Cannot set final field " + fieldDescription);
                    } else {
                        fieldSetter = new FieldSetter(fieldDescription, assigner, methodAccessorFactory);
                    }
                    return implementationDefinitionMethod.intercept(fieldSetter);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForGetterSetterPair forGetterSetterPair = (ForGetterSetterPair) obj;
                    return this.proxyType.equals(forGetterSetterPair.proxyType) && this.getterMethod.equals(forGetterSetterPair.getterMethod) && this.setterMethod.equals(forGetterSetterPair.setterMethod);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public TypeDescription getProxyType() {
                    return this.proxyType;
                }

                public int hashCode() {
                    return this.setterMethod.hashCode() + ((this.getterMethod.hashCode() + a.i(this.proxyType, getClass().hashCode() * 31, 31)) * 31);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public boolean isResolved() {
                    return true;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForSetter implements FieldResolver {
                private final MethodDescription.InDefinedShape setterMethod;

                public ForSetter(MethodDescription.InDefinedShape inDefinedShape) {
                    this.setterMethod = inDefinedShape;
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, FieldDescription fieldDescription, Assigner assigner, MethodAccessorFactory methodAccessorFactory) {
                    return builder.method(ElementMatchers.is(this.setterMethod)).intercept(new FieldSetter(fieldDescription, assigner, methodAccessorFactory));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.setterMethod.equals(((ForSetter) obj).setterMethod);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public TypeDescription getProxyType() {
                    return this.setterMethod.getDeclaringType();
                }

                public int hashCode() {
                    return this.setterMethod.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public boolean isResolved() {
                    return true;
                }
            }

            public enum Unresolved implements FieldResolver {
                INSTANCE;

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, FieldDescription fieldDescription, Assigner assigner, MethodAccessorFactory methodAccessorFactory) {
                    throw new IllegalStateException("Cannot apply unresolved field resolver");
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public TypeDescription getProxyType() {
                    throw new IllegalStateException("Cannot read type for unresolved field resolver");
                }

                @Override // net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver
                public boolean isResolved() {
                    return false;
                }
            }

            DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, FieldDescription fieldDescription, Assigner assigner, MethodAccessorFactory methodAccessorFactory);

            TypeDescription getProxyType();

            boolean isResolved();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class FieldSetter implements Implementation {
            private final Assigner assigner;
            private final FieldDescription fieldDescription;
            private final MethodAccessorFactory methodAccessorFactory;

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class Appender implements ByteCodeAppender {
                private final TypeDescription typeDescription;

                public Appender(Implementation.Target target) {
                    this.typeDescription = target.getInstrumentedType();
                }

                @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                    TypeDescription.Generic type = ((ParameterDescription) methodDescription.getParameters().get(0)).getType();
                    MethodDescription.InDefinedShape inDefinedShapeRegisterSetterFor = FieldSetter.this.methodAccessorFactory.registerSetterFor(FieldSetter.this.fieldDescription, MethodAccessorFactory.AccessType.DEFAULT);
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(FieldSetter.this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : new StackManipulation.Compound(MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape) this.typeDescription.getDeclaredFields().filter(ElementMatchers.named("instance")).getOnly()).read()), MethodVariableAccess.of(type).loadFrom(1), FieldSetter.this.assigner.assign(type, ((ParameterDescription) inDefinedShapeRegisterSetterFor.getParameters().get(0)).getType(), Assigner.Typing.DYNAMIC), MethodInvocation.invoke((MethodDescription) inDefinedShapeRegisterSetterFor), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Appender appender = (Appender) obj;
                    return this.typeDescription.equals(appender.typeDescription) && FieldSetter.this.equals(FieldSetter.this);
                }

                public int hashCode() {
                    return FieldSetter.this.hashCode() + a.i(this.typeDescription, getClass().hashCode() * 31, 31);
                }
            }

            public FieldSetter(FieldDescription fieldDescription, Assigner assigner, MethodAccessorFactory methodAccessorFactory) {
                this.fieldDescription = fieldDescription;
                this.assigner = assigner;
                this.methodAccessorFactory = methodAccessorFactory;
            }

            @Override // net.bytebuddy.implementation.Implementation
            public ByteCodeAppender appender(Implementation.Target target) {
                return new Appender(target);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                FieldSetter fieldSetter = (FieldSetter) obj;
                return this.fieldDescription.equals(fieldSetter.fieldDescription) && this.assigner.equals(fieldSetter.assigner) && this.methodAccessorFactory.equals(fieldSetter.methodAccessorFactory);
            }

            public int hashCode() {
                return this.methodAccessorFactory.hashCode() + ((this.assigner.hashCode() + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class InstanceFieldConstructor implements Implementation {
            private final TypeDescription instrumentedType;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Appender implements ByteCodeAppender {
                private final FieldDescription fieldDescription;

                public Appender(Implementation.Target target) {
                    this.fieldDescription = (FieldDescription) target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.named("instance")).getOnly();
                }

                @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(StaticFieldConstructor.INSTANCE.objectTypeDefaultConstructor), MethodVariableAccess.allArgumentsOf(methodDescription.asDefined()).prependThisReference(), FieldAccess.forField(this.fieldDescription).write(), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Appender) obj).fieldDescription);
                }

                public int hashCode() {
                    return this.fieldDescription.hashCode() + (getClass().hashCode() * 31);
                }
            }

            public InstanceFieldConstructor(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            @Override // net.bytebuddy.implementation.Implementation
            public ByteCodeAppender appender(Implementation.Target target) {
                return new Appender(target);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((InstanceFieldConstructor) obj).instrumentedType);
            }

            public int hashCode() {
                return this.instrumentedType.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType.withField(new FieldDescription.Token("instance", 18, this.instrumentedType.asGenericType()));
            }
        }

        public enum StaticFieldConstructor implements Implementation {
            INSTANCE;

            private final MethodDescription objectTypeDefaultConstructor = (MethodDescription) TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly();

            StaticFieldConstructor() {
            }

            @Override // net.bytebuddy.implementation.Implementation
            public ByteCodeAppender appender(Implementation.Target target) {
                return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), MethodInvocation.invoke(this.objectTypeDefaultConstructor), MethodReturn.VOID);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldProxy.class).getDeclaredMethods();
            DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("declaringType")).getOnly();
            FIELD_NAME = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
            SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("serializableProxy")).getOnly();
        }

        public Binder(MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2) {
            this(new FieldResolver.Factory.Simplex(inDefinedShape, inDefinedShape2));
        }

        public static TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldProxy> install(Class<?> cls) {
            return install(TypeDescription.ForLoadedType.of(cls));
        }

        private static MethodDescription.InDefinedShape onlyMethod(TypeDescription typeDescription) {
            if (!typeDescription.isInterface()) {
                throw new IllegalArgumentException(a.o(typeDescription, " is not an interface"));
            }
            if (!typeDescription.getInterfaces().isEmpty()) {
                throw new IllegalArgumentException(a.o(typeDescription, " must not extend other interfaces"));
            }
            if (!typeDescription.isPublic()) {
                throw new IllegalArgumentException(a.o(typeDescription, " is not public"));
            }
            MethodList methodListFilter = typeDescription.getDeclaredMethods().filter(ElementMatchers.isAbstract());
            if (methodListFilter.size() == 1) {
                return (MethodDescription.InDefinedShape) methodListFilter.getOnly();
            }
            throw new IllegalArgumentException(a.o(typeDescription, " must declare exactly one abstract method"));
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFieldBinding
        public MethodDelegationBinder.ParameterBinding<?> bind(FieldDescription fieldDescription, AnnotationDescription.Loadable<FieldProxy> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner) {
            FieldResolver fieldResolverResolve = this.fieldResolverFactory.resolve(parameterDescription.getType().asErasure(), fieldDescription);
            return fieldResolverResolve.isResolved() ? new MethodDelegationBinder.ParameterBinding.Anonymous(new AccessorProxy(fieldDescription, target.getInstrumentedType(), fieldResolverResolve, assigner, ((Boolean) loadable.getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue())) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFieldBinding
        public TypeDescription declaringType(AnnotationDescription.Loadable<FieldProxy> loadable) {
            return (TypeDescription) loadable.getValue(DECLARING_TYPE).resolve(TypeDescription.class);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.fieldResolverFactory.equals(((Binder) obj).fieldResolverFactory);
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFieldBinding
        public String fieldName(AnnotationDescription.Loadable<FieldProxy> loadable) {
            return (String) loadable.getValue(FIELD_NAME).resolve(String.class);
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<FieldProxy> getHandledType() {
            return FieldProxy.class;
        }

        public int hashCode() {
            return this.fieldResolverFactory.hashCode() + (getClass().hashCode() * 31);
        }

        public Binder(TypeDescription typeDescription, MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2) {
            this(new FieldResolver.Factory.Duplex(typeDescription, inDefinedShape, inDefinedShape2));
        }

        public static TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldProxy> install(TypeDescription typeDescription) {
            if (!typeDescription.isInterface()) {
                throw new IllegalArgumentException(a.o(typeDescription, " is not an interface"));
            }
            if (!typeDescription.getInterfaces().isEmpty()) {
                throw new IllegalArgumentException(a.o(typeDescription, " must not extend other interfaces"));
            }
            if (!typeDescription.isPublic()) {
                throw new IllegalArgumentException(a.o(typeDescription, " is not public"));
            }
            MethodList methodListFilter = typeDescription.getDeclaredMethods().filter(ElementMatchers.isAbstract());
            if (methodListFilter.size() != 2) {
                throw new IllegalArgumentException(a.o(typeDescription, " does not declare exactly two non-abstract methods"));
            }
            MethodList methodListFilter2 = methodListFilter.filter(ElementMatchers.isGetter((Class<?>) Object.class));
            if (methodListFilter2.size() != 1) {
                throw new IllegalArgumentException(a.o(typeDescription, " does not declare a getter with an Object type"));
            }
            MethodList methodListFilter3 = methodListFilter.filter(ElementMatchers.isSetter((Class<?>) Object.class));
            if (methodListFilter3.size() == 1) {
                return new Binder(typeDescription, (MethodDescription.InDefinedShape) methodListFilter2.getOnly(), (MethodDescription.InDefinedShape) methodListFilter3.getOnly());
            }
            throw new IllegalArgumentException(a.o(typeDescription, " does not declare a setter with an Object type"));
        }

        public Binder(FieldResolver.Factory factory) {
            this.fieldResolverFactory = factory;
        }

        public static TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldProxy> install(Class<?> cls, Class<?> cls2) {
            return install(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2));
        }

        public static TargetMethodAnnotationDrivenBinder.ParameterBinder<FieldProxy> install(TypeDescription typeDescription, TypeDescription typeDescription2) {
            MethodDescription.InDefinedShape inDefinedShapeOnlyMethod = onlyMethod(typeDescription);
            if (inDefinedShapeOnlyMethod.getReturnType().asErasure().represents(Object.class)) {
                if (inDefinedShapeOnlyMethod.getParameters().size() == 0) {
                    MethodDescription.InDefinedShape inDefinedShapeOnlyMethod2 = onlyMethod(typeDescription2);
                    if (inDefinedShapeOnlyMethod2.getReturnType().asErasure().represents(Void.TYPE)) {
                        if (inDefinedShapeOnlyMethod2.getParameters().size() == 1 && inDefinedShapeOnlyMethod2.getParameters().get(0).getType().asErasure().represents(Object.class)) {
                            return new Binder(inDefinedShapeOnlyMethod, inDefinedShapeOnlyMethod2);
                        }
                        throw new IllegalArgumentException(inDefinedShapeOnlyMethod2 + " must declare a single Object-typed parameters");
                    }
                    throw new IllegalArgumentException(inDefinedShapeOnlyMethod2 + " must return void");
                }
                throw new IllegalArgumentException(inDefinedShapeOnlyMethod + " must not declare parameters");
            }
            throw new IllegalArgumentException(inDefinedShapeOnlyMethod + " must take a single Object-typed parameter");
        }
    }

    Class<?> declaringType() default void.class;

    boolean serializableProxy() default false;

    String value() default "";
}
