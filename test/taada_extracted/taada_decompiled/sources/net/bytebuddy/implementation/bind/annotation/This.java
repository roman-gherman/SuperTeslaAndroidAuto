package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.matcher.ElementMatchers;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface This {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<This> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape OPTIONAL = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(This.class).getDeclaredMethods().filter(ElementMatchers.named("optional")).getOnly();

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<This> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            if (parameterDescription.getType().isPrimitive()) {
                throw new IllegalStateException(parameterDescription + " uses a primitive type with a @This annotation");
            }
            if (parameterDescription.getType().isArray()) {
                throw new IllegalStateException(parameterDescription + " uses an array type with a @This annotation");
            }
            if (!methodDescription.isStatic() || ((Boolean) loadable.getValue(OPTIONAL).resolve(Boolean.class)).booleanValue()) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(methodDescription.isStatic() ? NullConstant.INSTANCE : new StackManipulation.Compound(MethodVariableAccess.loadThis(), assigner.assign(target.getInstrumentedType().asGenericType(), parameterDescription.getType(), typing)));
            }
            return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<This> getHandledType() {
            return This.class;
        }
    }

    boolean optional() default false;
}
