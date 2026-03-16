package net.bytebuddy.asm;

import B2.b;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public abstract class MemberAttributeExtension<T> {
    protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
    protected final T attributeAppenderFactory;

    public static class ForField extends MemberAttributeExtension<FieldAttributeAppender.Factory> implements AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper {

        public static class FieldAttributeVisitor extends FieldVisitor {
            private final AnnotationValueFilter annotationValueFilter;
            private final FieldAttributeAppender fieldAttributeAppender;
            private final FieldDescription fieldDescription;

            @Override // net.bytebuddy.jar.asm.FieldVisitor
            public void visitEnd() {
                this.fieldAttributeAppender.apply(this.fv, this.fieldDescription, this.annotationValueFilter);
                super.visitEnd();
            }

            private FieldAttributeVisitor(FieldVisitor fieldVisitor, FieldDescription fieldDescription, FieldAttributeAppender fieldAttributeAppender, AnnotationValueFilter annotationValueFilter) {
                super(OpenedClassReader.ASM_API, fieldVisitor);
                this.fieldDescription = fieldDescription;
                this.fieldAttributeAppender = fieldAttributeAppender;
                this.annotationValueFilter = annotationValueFilter;
            }
        }

        public ForField() {
            this(AnnotationValueFilter.Default.APPEND_DEFAULTS);
        }

        public ForField annotate(Annotation... annotationArr) {
            return annotate(Arrays.asList(annotationArr));
        }

        public ForField attribute(FieldAttributeAppender.Factory factory) {
            return new ForField(this.annotationValueFilterFactory, new FieldAttributeAppender.Factory.Compound((FieldAttributeAppender.Factory) this.attributeAppenderFactory, factory));
        }

        public AsmVisitorWrapper on(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
            return new AsmVisitorWrapper.ForDeclaredFields().field(elementMatcher, this);
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredFields.FieldVisitorWrapper
        public FieldVisitor wrap(TypeDescription typeDescription, FieldDescription.InDefinedShape inDefinedShape, FieldVisitor fieldVisitor) {
            return new FieldAttributeVisitor(fieldVisitor, inDefinedShape, ((FieldAttributeAppender.Factory) this.attributeAppenderFactory).make(typeDescription), this.annotationValueFilterFactory.on(inDefinedShape));
        }

        public ForField(AnnotationValueFilter.Factory factory) {
            this(factory, FieldAttributeAppender.NoOp.INSTANCE);
        }

        public ForField annotate(List<? extends Annotation> list) {
            return annotate((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        public ForField(AnnotationValueFilter.Factory factory, FieldAttributeAppender.Factory factory2) {
            super(factory, factory2);
        }

        public ForField annotate(AnnotationDescription... annotationDescriptionArr) {
            return annotate((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForField annotate(Collection<? extends AnnotationDescription> collection) {
            return attribute(new FieldAttributeAppender.Explicit(new ArrayList(collection)));
        }
    }

    public static class ForMethod extends MemberAttributeExtension<MethodAttributeAppender.Factory> implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {

        public static class AttributeAppendingMethodVisitor extends MethodVisitor {
            private final AnnotationValueFilter annotationValueFilter;
            private boolean applicable;
            private final MethodAttributeAppender methodAttributeAppender;
            private final MethodDescription methodDescription;

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitCode() {
                if (this.applicable) {
                    this.methodAttributeAppender.apply(this.mv, this.methodDescription, this.annotationValueFilter);
                    this.applicable = false;
                }
                super.visitCode();
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitEnd() {
                if (this.applicable) {
                    this.methodAttributeAppender.apply(this.mv, this.methodDescription, this.annotationValueFilter);
                    this.applicable = false;
                }
                super.visitEnd();
            }

            private AttributeAppendingMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, AnnotationValueFilter annotationValueFilter) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.methodDescription = methodDescription;
                this.methodAttributeAppender = methodAttributeAppender;
                this.annotationValueFilter = annotationValueFilter;
                this.applicable = true;
            }
        }

        public ForMethod() {
            this(AnnotationValueFilter.Default.APPEND_DEFAULTS);
        }

        public ForMethod annotateMethod(Annotation... annotationArr) {
            return annotateMethod(Arrays.asList(annotationArr));
        }

        public ForMethod annotateParameter(int i, Annotation... annotationArr) {
            return annotateParameter(i, Arrays.asList(annotationArr));
        }

        public ForMethod attribute(MethodAttributeAppender.Factory factory) {
            return new ForMethod(this.annotationValueFilterFactory, new MethodAttributeAppender.Factory.Compound((MethodAttributeAppender.Factory) this.attributeAppenderFactory, factory));
        }

        public AsmVisitorWrapper on(ElementMatcher<? super MethodDescription> elementMatcher) {
            return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
        public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i, int i3) {
            return new AttributeAppendingMethodVisitor(methodVisitor, methodDescription, ((MethodAttributeAppender.Factory) this.attributeAppenderFactory).make(typeDescription), this.annotationValueFilterFactory.on(methodDescription));
        }

        public ForMethod(AnnotationValueFilter.Factory factory) {
            this(factory, MethodAttributeAppender.NoOp.INSTANCE);
        }

        public ForMethod annotateMethod(List<? extends Annotation> list) {
            return annotateMethod((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        public ForMethod annotateParameter(int i, List<? extends Annotation> list) {
            return annotateParameter(i, (Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
        }

        public ForMethod(AnnotationValueFilter.Factory factory, MethodAttributeAppender.Factory factory2) {
            super(factory, factory2);
        }

        public ForMethod annotateMethod(AnnotationDescription... annotationDescriptionArr) {
            return annotateMethod((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForMethod annotateParameter(int i, AnnotationDescription... annotationDescriptionArr) {
            return annotateParameter(i, (Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
        }

        public ForMethod annotateMethod(Collection<? extends AnnotationDescription> collection) {
            return attribute(new MethodAttributeAppender.Explicit(new ArrayList(collection)));
        }

        public ForMethod annotateParameter(int i, Collection<? extends AnnotationDescription> collection) {
            if (i >= 0) {
                return attribute(new MethodAttributeAppender.Explicit(i, new ArrayList(collection)));
            }
            throw new IllegalArgumentException(b.c(i, "Parameter index cannot be negative: "));
        }
    }

    public MemberAttributeExtension(AnnotationValueFilter.Factory factory, T t6) {
        this.annotationValueFilterFactory = factory;
        this.attributeAppenderFactory = t6;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MemberAttributeExtension memberAttributeExtension = (MemberAttributeExtension) obj;
        return this.annotationValueFilterFactory.equals(memberAttributeExtension.annotationValueFilterFactory) && this.attributeAppenderFactory.equals(memberAttributeExtension.attributeAppenderFactory);
    }

    public int hashCode() {
        return this.attributeAppenderFactory.hashCode() + ((this.annotationValueFilterFactory.hashCode() + (getClass().hashCode() * 31)) * 31);
    }
}
