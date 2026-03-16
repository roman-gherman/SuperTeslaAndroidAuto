package net.bytebuddy.implementation.attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeAttributeAppender {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements TypeAttributeAppender {
        private final List<TypeAttributeAppender> typeAttributeAppenders;

        public Compound(TypeAttributeAppender... typeAttributeAppenderArr) {
            this((List<? extends TypeAttributeAppender>) Arrays.asList(typeAttributeAppenderArr));
        }

        @Override // net.bytebuddy.implementation.attribute.TypeAttributeAppender
        public void apply(ClassVisitor classVisitor, TypeDescription typeDescription, AnnotationValueFilter annotationValueFilter) {
            Iterator<TypeAttributeAppender> it = this.typeAttributeAppenders.iterator();
            while (it.hasNext()) {
                it.next().apply(classVisitor, typeDescription, annotationValueFilter);
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.typeAttributeAppenders.equals(((Compound) obj).typeAttributeAppenders);
        }

        public int hashCode() {
            return this.typeAttributeAppenders.hashCode() + (getClass().hashCode() * 31);
        }

        public Compound(List<? extends TypeAttributeAppender> list) {
            this.typeAttributeAppenders = new ArrayList();
            for (TypeAttributeAppender typeAttributeAppender : list) {
                if (typeAttributeAppender instanceof Compound) {
                    this.typeAttributeAppenders.addAll(((Compound) typeAttributeAppender).typeAttributeAppenders);
                } else if (!(typeAttributeAppender instanceof NoOp)) {
                    this.typeAttributeAppenders.add(typeAttributeAppender);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Explicit implements TypeAttributeAppender {
        private final List<? extends AnnotationDescription> annotations;

        public Explicit(List<? extends AnnotationDescription> list) {
            this.annotations = list;
        }

        @Override // net.bytebuddy.implementation.attribute.TypeAttributeAppender
        public void apply(ClassVisitor classVisitor, TypeDescription typeDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppenderAppend = new AnnotationAppender.Default(new AnnotationAppender.Target.OnType(classVisitor));
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
    }

    public enum ForInstrumentedType implements TypeAttributeAppender {
        INSTANCE;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Differentiating implements TypeAttributeAppender {
            private final int annotationIndex;
            private final int interfaceTypeIndex;
            private final int typeVariableIndex;

            public Differentiating(TypeDescription typeDescription) {
                this(typeDescription.getDeclaredAnnotations().size(), typeDescription.getTypeVariables().size(), typeDescription.getInterfaces().size());
            }

            @Override // net.bytebuddy.implementation.attribute.TypeAttributeAppender
            public void apply(ClassVisitor classVisitor, TypeDescription typeDescription, AnnotationValueFilter annotationValueFilter) {
                AnnotationAppender annotationAppenderAppend = new AnnotationAppender.Default(new AnnotationAppender.Target.OnType(classVisitor));
                AnnotationAppender.ForTypeAnnotations.ofTypeVariable(annotationAppenderAppend, annotationValueFilter, true, this.typeVariableIndex, typeDescription.getTypeVariables());
                TypeList.Generic interfaces = typeDescription.getInterfaces();
                int i = this.interfaceTypeIndex;
                Iterator<TypeDescription.Generic> it = interfaces.subList(i, interfaces.size()).iterator();
                while (it.hasNext()) {
                    annotationAppenderAppend = (AnnotationAppender) it.next().accept(AnnotationAppender.ForTypeAnnotations.ofInterfaceType(annotationAppenderAppend, annotationValueFilter, i));
                    i++;
                }
                AnnotationList declaredAnnotations = typeDescription.getDeclaredAnnotations();
                Iterator<AnnotationDescription> it2 = declaredAnnotations.subList(this.annotationIndex, declaredAnnotations.size()).iterator();
                while (it2.hasNext()) {
                    annotationAppenderAppend = annotationAppenderAppend.append(it2.next(), annotationValueFilter);
                }
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Differentiating differentiating = (Differentiating) obj;
                return this.annotationIndex == differentiating.annotationIndex && this.typeVariableIndex == differentiating.typeVariableIndex && this.interfaceTypeIndex == differentiating.interfaceTypeIndex;
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.annotationIndex) * 31) + this.typeVariableIndex) * 31) + this.interfaceTypeIndex;
            }

            public Differentiating(int i, int i3, int i4) {
                this.annotationIndex = i;
                this.typeVariableIndex = i3;
                this.interfaceTypeIndex = i4;
            }
        }

        @Override // net.bytebuddy.implementation.attribute.TypeAttributeAppender
        public void apply(ClassVisitor classVisitor, TypeDescription typeDescription, AnnotationValueFilter annotationValueFilter) {
            AnnotationAppender annotationAppenderOfTypeVariable = AnnotationAppender.ForTypeAnnotations.ofTypeVariable(new AnnotationAppender.Default(new AnnotationAppender.Target.OnType(classVisitor)), annotationValueFilter, true, typeDescription.getTypeVariables());
            TypeDescription.Generic superClass = typeDescription.getSuperClass();
            if (superClass != null) {
                annotationAppenderOfTypeVariable = (AnnotationAppender) superClass.accept(AnnotationAppender.ForTypeAnnotations.ofSuperClass(annotationAppenderOfTypeVariable, annotationValueFilter));
            }
            Iterator<TypeDescription.Generic> it = typeDescription.getInterfaces().iterator();
            int i = 0;
            while (it.hasNext()) {
                annotationAppenderOfTypeVariable = (AnnotationAppender) it.next().accept(AnnotationAppender.ForTypeAnnotations.ofInterfaceType(annotationAppenderOfTypeVariable, annotationValueFilter, i));
                i++;
            }
            Iterator<AnnotationDescription> it2 = typeDescription.getDeclaredAnnotations().iterator();
            while (it2.hasNext()) {
                annotationAppenderOfTypeVariable = annotationAppenderOfTypeVariable.append(it2.next(), annotationValueFilter);
            }
        }
    }

    public enum NoOp implements TypeAttributeAppender {
        INSTANCE;

        @Override // net.bytebuddy.implementation.attribute.TypeAttributeAppender
        public void apply(ClassVisitor classVisitor, TypeDescription typeDescription, AnnotationValueFilter annotationValueFilter) {
        }
    }

    void apply(ClassVisitor classVisitor, TypeDescription typeDescription, AnnotationValueFilter annotationValueFilter);
}
