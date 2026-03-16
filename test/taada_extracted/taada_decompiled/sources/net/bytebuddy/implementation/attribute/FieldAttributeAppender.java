package net.bytebuddy.implementation.attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface FieldAttributeAppender {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements FieldAttributeAppender {
        private final List<FieldAttributeAppender> fieldAttributeAppenders;

        public Compound(FieldAttributeAppender... fieldAttributeAppenderArr) {
            this((List<? extends FieldAttributeAppender>) Arrays.asList(fieldAttributeAppenderArr));
        }

        @Override // net.bytebuddy.implementation.attribute.FieldAttributeAppender
        public void apply(FieldVisitor fieldVisitor, FieldDescription fieldDescription, AnnotationValueFilter annotationValueFilter) {
            Iterator<FieldAttributeAppender> it = this.fieldAttributeAppenders.iterator();
            while (it.hasNext()) {
                it.next().apply(fieldVisitor, fieldDescription, annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.fieldAttributeAppenders.equals(((Compound) obj).fieldAttributeAppenders);
        }

        public int hashCode() {
            return this.fieldAttributeAppenders.hashCode() + (getClass().hashCode() * 31);
        }

        public Compound(List<? extends FieldAttributeAppender> list) {
            this.fieldAttributeAppenders = new ArrayList();
            for (FieldAttributeAppender fieldAttributeAppender : list) {
                if (fieldAttributeAppender instanceof Compound) {
                    this.fieldAttributeAppenders.addAll(((Compound) fieldAttributeAppender).fieldAttributeAppenders);
                } else if (!(fieldAttributeAppender instanceof NoOp)) {
                    this.fieldAttributeAppenders.add(fieldAttributeAppender);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Explicit implements FieldAttributeAppender, Factory {
        private final List<? extends AnnotationDescription> annotations;

        public Explicit(List<? extends AnnotationDescription> list) {
            this.annotations = list;
        }

        @Override // net.bytebuddy.implementation.attribute.FieldAttributeAppender
        public void apply(FieldVisitor fieldVisitor, FieldDescription fieldDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppenderAppend = new AnnotationAppender.Default(new AnnotationAppender.Target.OnField(fieldVisitor));
            Iterator<? extends AnnotationDescription> it = this.annotations.iterator();
            while (it.hasNext()) {
                annotationAppenderAppend = annotationAppenderAppend.append(it.next(), annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.annotations.equals(((Explicit) obj).annotations);
        }

        public int hashCode() {
            return this.annotations.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.implementation.attribute.FieldAttributeAppender.Factory
        public FieldAttributeAppender make(TypeDescription typeDescription) {
            return this;
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

            @Override // net.bytebuddy.implementation.attribute.FieldAttributeAppender.Factory
            public FieldAttributeAppender make(TypeDescription typeDescription) {
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

        FieldAttributeAppender make(TypeDescription typeDescription);
    }

    public enum ForInstrumentedField implements FieldAttributeAppender, Factory {
        INSTANCE;

        @Override // net.bytebuddy.implementation.attribute.FieldAttributeAppender
        public void apply(FieldVisitor fieldVisitor, FieldDescription fieldDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppenderAppend = (AnnotationAppender) fieldDescription.getType().accept(AnnotationAppender.ForTypeAnnotations.ofFieldType(new AnnotationAppender.Default(new AnnotationAppender.Target.OnField(fieldVisitor)), annotationValueFilter));
            Iterator<AnnotationDescription> it = fieldDescription.getDeclaredAnnotations().iterator();
            while (it.hasNext()) {
                annotationAppenderAppend = annotationAppenderAppend.append(it.next(), annotationValueFilter);
            }
        }

        @Override // net.bytebuddy.implementation.attribute.FieldAttributeAppender.Factory
        public FieldAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    public enum NoOp implements FieldAttributeAppender, Factory {
        INSTANCE;

        @Override // net.bytebuddy.implementation.attribute.FieldAttributeAppender
        public void apply(FieldVisitor fieldVisitor, FieldDescription fieldDescription, AnnotationValueFilter annotationValueFilter) {
        }

        @Override // net.bytebuddy.implementation.attribute.FieldAttributeAppender.Factory
        public FieldAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    void apply(FieldVisitor fieldVisitor, FieldDescription fieldDescription, AnnotationValueFilter annotationValueFilter);
}
