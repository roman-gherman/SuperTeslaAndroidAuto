package net.bytebuddy.implementation.attribute;

import B2.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface MethodAttributeAppender {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements MethodAttributeAppender {
        private final List<MethodAttributeAppender> methodAttributeAppenders;

        public Compound(MethodAttributeAppender... methodAttributeAppenderArr) {
            this((List<? extends MethodAttributeAppender>) Arrays.asList(methodAttributeAppenderArr));
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            Iterator<MethodAttributeAppender> it = this.methodAttributeAppenders.iterator();
            while (it.hasNext()) {
                it.next().apply(methodVisitor, methodDescription, annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.methodAttributeAppenders.equals(((Compound) obj).methodAttributeAppenders);
        }

        public int hashCode() {
            return this.methodAttributeAppenders.hashCode() + (getClass().hashCode() * 31);
        }

        public Compound(List<? extends MethodAttributeAppender> list) {
            this.methodAttributeAppenders = new ArrayList();
            for (MethodAttributeAppender methodAttributeAppender : list) {
                if (methodAttributeAppender instanceof Compound) {
                    this.methodAttributeAppenders.addAll(((Compound) methodAttributeAppender).methodAttributeAppenders);
                } else if (!(methodAttributeAppender instanceof NoOp)) {
                    this.methodAttributeAppenders.add(methodAttributeAppender);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Explicit implements MethodAttributeAppender, Factory {
        private final List<? extends AnnotationDescription> annotations;
        private final Target target;

        public interface Target {

            public enum OnMethod implements Target {
                INSTANCE;

                @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Explicit.Target
                public AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription) {
                    return new AnnotationAppender.Target.OnMethod(methodVisitor);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class OnMethodParameter implements Target {
                private final int parameterIndex;

                public OnMethodParameter(int i) {
                    this.parameterIndex = i;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parameterIndex == ((OnMethodParameter) obj).parameterIndex;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.parameterIndex;
                }

                @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Explicit.Target
                public AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription) {
                    if (this.parameterIndex < methodDescription.getParameters().size()) {
                        return new AnnotationAppender.Target.OnMethodParameter(methodVisitor, this.parameterIndex);
                    }
                    StringBuilder sb = new StringBuilder("Method ");
                    sb.append(methodDescription);
                    sb.append(" has less then ");
                    throw new IllegalArgumentException(b.g(sb, " parameters", this.parameterIndex));
                }
            }

            AnnotationAppender.Target make(MethodVisitor methodVisitor, MethodDescription methodDescription);
        }

        public Explicit(int i, List<? extends AnnotationDescription> list) {
            this(new Target.OnMethodParameter(i), list);
        }

        public static Factory of(MethodDescription methodDescription) {
            return new Factory.Compound(ofMethodAnnotations(methodDescription), ofParameterAnnotations(methodDescription));
        }

        public static Factory ofMethodAnnotations(MethodDescription methodDescription) {
            return new Explicit(methodDescription.getDeclaredAnnotations());
        }

        public static Factory ofParameterAnnotations(MethodDescription methodDescription) {
            ParameterList<?> parameters = methodDescription.getParameters();
            ArrayList arrayList = new ArrayList(parameters.size());
            Iterator<?> it = parameters.iterator();
            while (it.hasNext()) {
                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                arrayList.add(new Explicit(parameterDescription.getIndex(), parameterDescription.getDeclaredAnnotations()));
            }
            return new Factory.Compound(arrayList);
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppenderAppend = new AnnotationAppender.Default(this.target.make(methodVisitor, methodDescription));
            Iterator<? extends AnnotationDescription> it = this.annotations.iterator();
            while (it.hasNext()) {
                annotationAppenderAppend = annotationAppenderAppend.append(it.next(), annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Explicit explicit = (Explicit) obj;
            return this.target.equals(explicit.target) && this.annotations.equals(explicit.annotations);
        }

        public int hashCode() {
            return this.annotations.hashCode() + ((this.target.hashCode() + (getClass().hashCode() * 31)) * 31);
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }

        public Explicit(List<? extends AnnotationDescription> list) {
            this(Target.OnMethod.INSTANCE, list);
        }

        public Explicit(Target target, List<? extends AnnotationDescription> list) {
            this.target = target;
            this.annotations = list;
        }
    }

    public interface Factory {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements Factory {
            private final List<Factory> factories;

            public Compound(Factory... factoryArr) {
                this((List<? extends Factory>) Arrays.asList(factoryArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
            }

            public int hashCode() {
                return this.factories.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
            public MethodAttributeAppender make(TypeDescription typeDescription) {
                ArrayList arrayList = new ArrayList(this.factories.size());
                Iterator<Factory> it = this.factories.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().make(typeDescription));
                }
                return new Compound(arrayList);
            }

            public Compound(List<? extends Factory> list) {
                this.factories = new ArrayList();
                for (Factory factory : list) {
                    if (factory instanceof Compound) {
                        this.factories.addAll(((Compound) factory).factories);
                    } else if (!(factory instanceof NoOp)) {
                        this.factories.add(factory);
                    }
                }
            }
        }

        MethodAttributeAppender make(TypeDescription typeDescription);
    }

    public enum ForInstrumentedMethod implements MethodAttributeAppender, Factory {
        EXCLUDING_RECEIVER { // from class: net.bytebuddy.implementation.attribute.MethodAttributeAppender.ForInstrumentedMethod.1
            @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.ForInstrumentedMethod
            public AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription) {
                return annotationAppender;
            }
        },
        INCLUDING_RECEIVER { // from class: net.bytebuddy.implementation.attribute.MethodAttributeAppender.ForInstrumentedMethod.2
            @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.ForInstrumentedMethod
            public AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription) {
                TypeDescription.Generic receiverType = methodDescription.getReceiverType();
                return receiverType == null ? annotationAppender : (AnnotationAppender) receiverType.accept(AnnotationAppender.ForTypeAnnotations.ofReceiverType(annotationAppender, annotationValueFilter));
            }
        };

        public abstract AnnotationAppender appendReceiver(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, MethodDescription methodDescription);

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            int i = 0;
            AnnotationAppender annotationAppenderOfTypeVariable = AnnotationAppender.ForTypeAnnotations.ofTypeVariable((AnnotationAppender) methodDescription.getReturnType().accept(AnnotationAppender.ForTypeAnnotations.ofMethodReturnType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethod(methodVisitor)), annotationValueFilter)), annotationValueFilter, false, methodDescription.getTypeVariables());
            Iterator<AnnotationDescription> it = methodDescription.getDeclaredAnnotations().filter(ElementMatchers.not(ElementMatchers.annotationType(ElementMatchers.nameStartsWith("jdk.internal.")))).iterator();
            while (it.hasNext()) {
                annotationAppenderOfTypeVariable = annotationAppenderOfTypeVariable.append(it.next(), annotationValueFilter);
            }
            Iterator<?> it2 = methodDescription.getParameters().iterator();
            while (it2.hasNext()) {
                ParameterDescription parameterDescription = (ParameterDescription) it2.next();
                AnnotationAppender annotationAppenderAppend = (AnnotationAppender) parameterDescription.getType().accept(AnnotationAppender.ForTypeAnnotations.ofMethodParameterType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethodParameter(methodVisitor, parameterDescription.getIndex())), annotationValueFilter, parameterDescription.getIndex()));
                Iterator<AnnotationDescription> it3 = parameterDescription.getDeclaredAnnotations().iterator();
                while (it3.hasNext()) {
                    annotationAppenderAppend = annotationAppenderAppend.append(it3.next(), annotationValueFilter);
                }
            }
            AnnotationAppender annotationAppenderAppendReceiver = appendReceiver(annotationAppenderOfTypeVariable, annotationValueFilter, methodDescription);
            Iterator<TypeDescription.Generic> it4 = methodDescription.getExceptionTypes().iterator();
            while (it4.hasNext()) {
                annotationAppenderAppendReceiver = (AnnotationAppender) it4.next().accept(AnnotationAppender.ForTypeAnnotations.ofExceptionType(annotationAppenderAppendReceiver, annotationValueFilter, i));
                i++;
            }
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForReceiverType implements MethodAttributeAppender, Factory {
        private final TypeDescription.Generic receiverType;

        public ForReceiverType(TypeDescription.Generic generic) {
            this.receiverType = generic;
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            this.receiverType.accept(AnnotationAppender.ForTypeAnnotations.ofReceiverType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnMethod(methodVisitor)), annotationValueFilter));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.receiverType.equals(((ForReceiverType) obj).receiverType);
        }

        public int hashCode() {
            return this.receiverType.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    public enum NoOp implements MethodAttributeAppender, Factory {
        INSTANCE;

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter);
}
