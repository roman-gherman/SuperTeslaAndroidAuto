package net.bytebuddy.implementation.bind.annotation;

import com.google.protobuf.a;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Super> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape PROXY_TYPE;
        private static final MethodDescription.InDefinedShape STRATEGY;

        public interface TypeLocator {

            public enum ForInstrumentedType implements TypeLocator {
                INSTANCE;

                @Override // net.bytebuddy.implementation.bind.annotation.Super.Binder.TypeLocator
                public TypeDescription resolve(TypeDescription typeDescription, TypeDescription.Generic generic) {
                    return typeDescription;
                }
            }

            public enum ForParameterType implements TypeLocator {
                INSTANCE;

                @Override // net.bytebuddy.implementation.bind.annotation.Super.Binder.TypeLocator
                public TypeDescription resolve(TypeDescription typeDescription, TypeDescription.Generic generic) {
                    TypeDescription typeDescriptionAsErasure = generic.asErasure();
                    return typeDescriptionAsErasure.equals(typeDescription) ? typeDescription : typeDescriptionAsErasure;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForType implements TypeLocator {
                private final TypeDescription typeDescription;

                public ForType(TypeDescription typeDescription) {
                    this.typeDescription = typeDescription;
                }

                public static TypeLocator of(TypeDescription typeDescription) {
                    if (typeDescription.represents(Void.TYPE)) {
                        return ForParameterType.INSTANCE;
                    }
                    if (typeDescription.represents(TargetType.class)) {
                        return ForInstrumentedType.INSTANCE;
                    }
                    if (typeDescription.isPrimitive() || typeDescription.isArray()) {
                        throw new IllegalStateException(a.m("Cannot assign proxy to ", typeDescription));
                    }
                    return new ForType(typeDescription);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForType) obj).typeDescription);
                }

                public int hashCode() {
                    return this.typeDescription.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.Super.Binder.TypeLocator
                public TypeDescription resolve(TypeDescription typeDescription, TypeDescription.Generic generic) {
                    if (this.typeDescription.isAssignableTo(generic.asErasure())) {
                        return this.typeDescription;
                    }
                    throw new IllegalStateException("Impossible to assign " + this.typeDescription + " to parameter of type " + generic);
                }
            }

            TypeDescription resolve(TypeDescription typeDescription, TypeDescription.Generic generic);
        }

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Super.class).getDeclaredMethods();
            STRATEGY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("strategy")).getOnly();
            PROXY_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("proxyType")).getOnly();
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Super> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            if (parameterDescription.getType().isPrimitive() || parameterDescription.getType().isArray()) {
                throw new IllegalStateException(parameterDescription + " uses the @Super annotation on an invalid type");
            }
            TypeDescription typeDescriptionResolve = TypeLocator.ForType.of((TypeDescription) loadable.getValue(PROXY_TYPE).resolve(TypeDescription.class)).resolve(target.getInstrumentedType(), parameterDescription.getType());
            if (typeDescriptionResolve.isFinal()) {
                throw new IllegalStateException(a.m("Cannot extend final type as @Super proxy: ", typeDescriptionResolve));
            }
            return (methodDescription.isStatic() || !target.getInstrumentedType().isAssignableTo(typeDescriptionResolve)) ? MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE : new MethodDelegationBinder.ParameterBinding.Anonymous(((Instantiation) ((EnumerationDescription) loadable.getValue(STRATEGY).resolve(EnumerationDescription.class)).load(Instantiation.class)).proxyFor(typeDescriptionResolve, target, loadable));
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<Super> getHandledType() {
            return Super.class;
        }
    }

    public enum Instantiation {
        CONSTRUCTOR { // from class: net.bytebuddy.implementation.bind.annotation.Super.Instantiation.1
            @Override // net.bytebuddy.implementation.bind.annotation.Super.Instantiation
            public StackManipulation proxyFor(TypeDescription typeDescription, Implementation.Target target, AnnotationDescription.Loadable<Super> loadable) {
                return new TypeProxy.ForSuperMethodByConstructor(typeDescription, target, Arrays.asList((Object[]) loadable.getValue(Instantiation.CONSTRUCTOR_PARAMETERS).resolve(TypeDescription[].class)), ((Boolean) loadable.getValue(Instantiation.IGNORE_FINALIZER).resolve(Boolean.class)).booleanValue(), ((Boolean) loadable.getValue(Instantiation.SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue());
            }
        },
        UNSAFE { // from class: net.bytebuddy.implementation.bind.annotation.Super.Instantiation.2
            @Override // net.bytebuddy.implementation.bind.annotation.Super.Instantiation
            public StackManipulation proxyFor(TypeDescription typeDescription, Implementation.Target target, AnnotationDescription.Loadable<Super> loadable) {
                return new TypeProxy.ForSuperMethodByReflectionFactory(typeDescription, target, ((Boolean) loadable.getValue(Instantiation.IGNORE_FINALIZER).resolve(Boolean.class)).booleanValue(), ((Boolean) loadable.getValue(Instantiation.SERIALIZABLE_PROXY).resolve(Boolean.class)).booleanValue());
            }
        };

        private static final MethodDescription.InDefinedShape CONSTRUCTOR_PARAMETERS;
        private static final MethodDescription.InDefinedShape IGNORE_FINALIZER;
        private static final MethodDescription.InDefinedShape SERIALIZABLE_PROXY;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Super.class).getDeclaredMethods();
            IGNORE_FINALIZER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("ignoreFinalizer")).getOnly();
            SERIALIZABLE_PROXY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("serializableProxy")).getOnly();
            CONSTRUCTOR_PARAMETERS = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("constructorParameters")).getOnly();
        }

        public abstract StackManipulation proxyFor(TypeDescription typeDescription, Implementation.Target target, AnnotationDescription.Loadable<Super> loadable);
    }

    Class<?>[] constructorParameters() default {};

    boolean ignoreFinalizer() default true;

    Class<?> proxyType() default void.class;

    boolean serializableProxy() default false;

    Instantiation strategy() default Instantiation.CONSTRUCTOR;
}
