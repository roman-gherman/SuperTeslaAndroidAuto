package net.bytebuddy.implementation.bind.annotation;

import B2.b;
import com.google.protobuf.a;
import java.io.Serializable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
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
public @interface Pipe {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe> {
        private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Pipe.class).getDeclaredMethods().filter(ElementMatchers.named("serializableProxy")).getOnly();
        private final MethodDescription forwardingMethod;

        @HashCodeAndEqualsPlugin.Enhance
        public static class RedirectionProxy extends StackManipulation.AbstractBase implements AuxiliaryType {
            private static final String FIELD_NAME_PREFIX = "argument";
            private final Assigner assigner;
            private final TypeDescription forwardingType;
            private final boolean serializableProxy;
            private final MethodDescription sourceMethod;

            public enum ConstructorCall implements Implementation {
                INSTANCE;

                private final transient MethodDescription.InDefinedShape objectTypeDefaultConstructor = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly();

                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private final TypeDescription instrumentedType;

                    @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        FieldList<FieldDescription.InDefinedShape> declaredFields = this.instrumentedType.getDeclaredFields();
                        StackManipulation[] stackManipulationArr = new StackManipulation[declaredFields.size()];
                        Iterator<FieldDescription.InDefinedShape> it = declaredFields.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            stackManipulationArr[i] = new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodVariableAccess.load((ParameterDescription) methodDescription.getParameters().get(i)), FieldAccess.forField((FieldDescription) it.next()).write());
                            i++;
                        }
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(ConstructorCall.INSTANCE.objectTypeDefaultConstructor), new StackManipulation.Compound(stackManipulationArr), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType);
                    }

                    public int hashCode() {
                        return this.instrumentedType.hashCode() + (getClass().hashCode() * 31);
                    }

                    private Appender(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }
                }

                ConstructorCall() {
                }

                @Override // net.bytebuddy.implementation.Implementation
                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.getInstrumentedType());
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class MethodCall implements Implementation {
                private final Assigner assigner;
                private final MethodDescription redirectedMethod;

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Appender implements ByteCodeAppender {
                    private final TypeDescription instrumentedType;

                    @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        FieldList<FieldDescription.InDefinedShape> declaredFields = this.instrumentedType.getDeclaredFields();
                        StackManipulation[] stackManipulationArr = new StackManipulation[declaredFields.size()];
                        Iterator<FieldDescription.InDefinedShape> it = declaredFields.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            stackManipulationArr[i] = new StackManipulation.Compound(MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription) it.next()).read());
                            i++;
                        }
                        StackManipulation stackManipulationLoadFrom = MethodVariableAccess.REFERENCE.loadFrom(1);
                        Assigner assigner = MethodCall.this.assigner;
                        TypeDescription.Generic genericOf = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
                        TypeDescription.Generic genericAsGenericType = MethodCall.this.redirectedMethod.getDeclaringType().asGenericType();
                        Assigner.Typing typing = Assigner.Typing.DYNAMIC;
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationLoadFrom, assigner.assign(genericOf, genericAsGenericType, typing), new StackManipulation.Compound(stackManipulationArr), MethodInvocation.invoke(MethodCall.this.redirectedMethod), MethodCall.this.assigner.assign(MethodCall.this.redirectedMethod.getReturnType(), methodDescription.getReturnType(), typing), MethodReturn.REFERENCE).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Appender appender = (Appender) obj;
                        return this.instrumentedType.equals(appender.instrumentedType) && MethodCall.this.equals(MethodCall.this);
                    }

                    public int hashCode() {
                        return MethodCall.this.hashCode() + a.i(this.instrumentedType, getClass().hashCode() * 31, 31);
                    }

                    private Appender(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }
                }

                @Override // net.bytebuddy.implementation.Implementation
                public ByteCodeAppender appender(Implementation.Target target) {
                    if (this.redirectedMethod.isAccessibleTo(target.getInstrumentedType())) {
                        return new Appender(target.getInstrumentedType());
                    }
                    throw new IllegalStateException("Cannot invoke " + this.redirectedMethod + " from outside of class via @Pipe proxy");
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    MethodCall methodCall = (MethodCall) obj;
                    return this.redirectedMethod.equals(methodCall.redirectedMethod) && this.assigner.equals(methodCall.assigner);
                }

                public int hashCode() {
                    return this.assigner.hashCode() + a.f(this.redirectedMethod, getClass().hashCode() * 31, 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                private MethodCall(MethodDescription methodDescription, Assigner assigner) {
                    this.redirectedMethod = methodDescription;
                    this.assigner = assigner;
                }
            }

            public RedirectionProxy(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, boolean z6) {
                this.forwardingType = typeDescription;
                this.sourceMethod = methodDescription;
                this.assigner = assigner;
                this.serializableProxy = z6;
            }

            private static LinkedHashMap<String, TypeDescription> extractFields(MethodDescription methodDescription) {
                TypeList typeListAsErasures = methodDescription.getParameters().asTypeList().asErasures();
                LinkedHashMap<String, TypeDescription> linkedHashMap = new LinkedHashMap<>();
                Iterator<TypeDescription> it = typeListAsErasures.iterator();
                int i = 0;
                while (it.hasNext()) {
                    linkedHashMap.put(fieldName(i), it.next());
                    i++;
                }
                return linkedHashMap;
            }

            private static String fieldName(int i) {
                return b.c(i, FIELD_NAME_PREFIX);
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                TypeDescription typeDescriptionRegister = context.register(this);
                return new StackManipulation.Compound(TypeCreation.of(typeDescriptionRegister), Duplication.SINGLE, MethodVariableAccess.allArgumentsOf(this.sourceMethod), MethodInvocation.invoke((MethodDescription.InDefinedShape) typeDescriptionRegister.getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly())).apply(methodVisitor, context);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                RedirectionProxy redirectionProxy = (RedirectionProxy) obj;
                return this.serializableProxy == redirectionProxy.serializableProxy && this.forwardingType.equals(redirectionProxy.forwardingType) && this.sourceMethod.equals(redirectionProxy.sourceMethod) && this.assigner.equals(redirectionProxy.assigner);
            }

            @Override // net.bytebuddy.implementation.auxiliary.AuxiliaryType
            public String getSuffix() {
                StringBuilder sb = new StringBuilder();
                sb.append(RandomString.hashOf(this.forwardingType.hashCode()));
                sb.append(RandomString.hashOf(this.sourceMethod.hashCode()));
                sb.append(this.serializableProxy ? "S" : "0");
                return sb.toString();
            }

            public int hashCode() {
                return ((this.assigner.hashCode() + a.f(this.sourceMethod, a.i(this.forwardingType, getClass().hashCode() * 31, 31), 31)) * 31) + (this.serializableProxy ? 1 : 0);
            }

            @Override // net.bytebuddy.implementation.auxiliary.AuxiliaryType
            public DynamicType make(String str, ClassFileVersion classFileVersion, MethodAccessorFactory methodAccessorFactory) {
                LinkedHashMap<String, TypeDescription> linkedHashMapExtractFields = extractFields(this.sourceMethod);
                DynamicType.Builder builderIntercept = new ByteBuddy(classFileVersion).with(TypeValidation.DISABLED).subclass(this.forwardingType, ConstructorStrategy.Default.NO_CONSTRUCTORS).name(str).modifiers(AuxiliaryType.DEFAULT_TYPE_MODIFIER).implement(this.serializableProxy ? new Class[]{Serializable.class} : new Class[0]).method(ElementMatchers.isAbstract().and(ElementMatchers.isDeclaredBy(this.forwardingType))).intercept(new MethodCall(this.sourceMethod, this.assigner)).defineConstructor(new ModifierContributor.ForMethod[0]).withParameters(linkedHashMapExtractFields.values()).intercept(ConstructorCall.INSTANCE);
                for (Map.Entry<String, TypeDescription> entry : linkedHashMapExtractFields.entrySet()) {
                    builderIntercept = builderIntercept.defineField(entry.getKey(), entry.getValue(), Visibility.PRIVATE);
                }
                return builderIntercept.make();
            }
        }

        public Binder(MethodDescription methodDescription) {
            this.forwardingMethod = methodDescription;
        }

        public static TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe> install(Class<?> cls) {
            return install(TypeDescription.ForLoadedType.of(cls));
        }

        private static MethodDescription onlyMethod(TypeDescription typeDescription) {
            if (!typeDescription.isInterface()) {
                throw new IllegalArgumentException(a.o(typeDescription, " is not an interface"));
            }
            if (!typeDescription.getInterfaces().isEmpty()) {
                throw new IllegalArgumentException(a.o(typeDescription, " must not extend other interfaces"));
            }
            if (!typeDescription.isPublic()) {
                throw new IllegalArgumentException(a.o(typeDescription, " is mot public"));
            }
            MethodList methodListFilter = typeDescription.getDeclaredMethods().filter(ElementMatchers.isAbstract());
            if (methodListFilter.size() != 1) {
                throw new IllegalArgumentException(a.o(typeDescription, " must declare exactly one abstract method"));
            }
            MethodDescription methodDescription = (MethodDescription) methodListFilter.getOnly();
            if (!methodDescription.getReturnType().asErasure().represents(Object.class)) {
                throw new IllegalArgumentException(methodDescription + " does not return an Object-type");
            }
            if (methodDescription.getParameters().size() == 1 && ((ParameterDescription) methodDescription.getParameters().getOnly()).getType().asErasure().represents(Object.class)) {
                return methodDescription;
            }
            throw new IllegalArgumentException(methodDescription + " does not take a single Object-typed argument");
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Pipe> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            if (parameterDescription.getType().asErasure().equals(this.forwardingMethod.getDeclaringType())) {
                return methodDescription.isStatic() ? MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE : new MethodDelegationBinder.ParameterBinding.Anonymous(new RedirectionProxy(this.forwardingMethod.getDeclaringType().asErasure(), methodDescription, assigner, ((Boolean) loadable.getValue(SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue()));
            }
            throw new IllegalStateException("Illegal use of @Pipe for " + parameterDescription + " which was installed for " + this.forwardingMethod.getDeclaringType());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.forwardingMethod.equals(((Binder) obj).forwardingMethod);
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<Pipe> getHandledType() {
            return Pipe.class;
        }

        public int hashCode() {
            return this.forwardingMethod.hashCode() + (getClass().hashCode() * 31);
        }

        public static TargetMethodAnnotationDrivenBinder.ParameterBinder<Pipe> install(TypeDescription typeDescription) {
            return new Binder(onlyMethod(typeDescription));
        }
    }

    boolean serializableProxy() default false;
}
