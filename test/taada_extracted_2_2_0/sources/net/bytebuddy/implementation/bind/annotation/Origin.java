package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Origin {

    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Origin> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape CACHE;
        private static final MethodDescription.InDefinedShape PRIVILEGED;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Origin.class).getDeclaredMethods();
            CACHE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("cache")).getOnly();
            PRIVILEGED = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("privileged")).getOnly();
        }

        private static StackManipulation methodConstant(AnnotationDescription.Loadable<Origin> loadable, MethodDescription.InDefinedShape inDefinedShape) {
            MethodConstant.CanCache canCacheOfPrivileged = ((Boolean) loadable.getValue(PRIVILEGED).resolve(Boolean.class)).booleanValue() ? MethodConstant.ofPrivileged(inDefinedShape) : MethodConstant.of(inDefinedShape);
            return ((Boolean) loadable.getValue(CACHE).resolve(Boolean.class)).booleanValue() ? canCacheOfPrivileged.cached() : canCacheOfPrivileged;
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Origin> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            TypeDescription typeDescriptionAsErasure = parameterDescription.getType().asErasure();
            if (typeDescriptionAsErasure.represents(Class.class)) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(ClassConstant.of(target.getOriginType().asErasure()));
            }
            if (typeDescriptionAsErasure.represents(Method.class)) {
                return methodDescription.isMethod() ? new MethodDelegationBinder.ParameterBinding.Anonymous(methodConstant(loadable, methodDescription.asDefined())) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
            if (typeDescriptionAsErasure.represents(Constructor.class)) {
                return methodDescription.isConstructor() ? new MethodDelegationBinder.ParameterBinding.Anonymous(methodConstant(loadable, methodDescription.asDefined())) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
            if (JavaType.EXECUTABLE.getTypeStub().equals(typeDescriptionAsErasure)) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(methodConstant(loadable, methodDescription.asDefined()));
            }
            if (typeDescriptionAsErasure.represents(String.class)) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new TextConstant(methodDescription.toString()));
            }
            if (typeDescriptionAsErasure.represents(Integer.TYPE)) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(IntegerConstant.forValue(methodDescription.getModifiers()));
            }
            if (typeDescriptionAsErasure.equals(JavaType.METHOD_HANDLE.getTypeStub())) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new JavaConstantValue(JavaConstant.MethodHandle.of(methodDescription.asDefined())));
            }
            if (typeDescriptionAsErasure.equals(JavaType.METHOD_TYPE.getTypeStub())) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new JavaConstantValue(JavaConstant.MethodType.of(methodDescription.asDefined())));
            }
            throw new IllegalStateException("The " + parameterDescription + " method's " + parameterDescription.getIndex() + " parameter is annotated with a Origin annotation with an argument not representing a Class, Method, Constructor, String, int, MethodType or MethodHandle type");
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<Origin> getHandledType() {
            return Origin.class;
        }
    }

    boolean cache() default true;

    boolean privileged() default false;
}
