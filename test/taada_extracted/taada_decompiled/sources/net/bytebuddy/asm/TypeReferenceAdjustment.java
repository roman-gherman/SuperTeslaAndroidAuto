package net.bytebuddy.asm;

import com.android.multidex.ClassPathElement;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class TypeReferenceAdjustment extends AsmVisitorWrapper.AbstractBase {
    private final ElementMatcher.Junction<? super TypeDescription> filter;
    private final boolean strict;

    public TypeReferenceAdjustment(boolean z6, ElementMatcher.Junction<? super TypeDescription> junction) {
        this.strict = z6;
        this.filter = junction;
    }

    public static TypeReferenceAdjustment relaxed() {
        return new TypeReferenceAdjustment(false, ElementMatchers.none());
    }

    public static TypeReferenceAdjustment strict() {
        return new TypeReferenceAdjustment(true, ElementMatchers.none());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TypeReferenceAdjustment typeReferenceAdjustment = (TypeReferenceAdjustment) obj;
        return this.strict == typeReferenceAdjustment.strict && this.filter.equals(typeReferenceAdjustment.filter);
    }

    public TypeReferenceAdjustment filter(ElementMatcher<? super TypeDescription> elementMatcher) {
        return new TypeReferenceAdjustment(this.strict, this.filter.or(elementMatcher));
    }

    public int hashCode() {
        return this.filter.hashCode() + (((getClass().hashCode() * 31) + (this.strict ? 1 : 0)) * 31);
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper
    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i3) {
        return new TypeReferenceClassVisitor(classVisitor, this.strict, this.filter, typePool);
    }

    public static class TypeReferenceClassVisitor extends ClassVisitor {

        @AlwaysNull
        private static final AnnotationVisitor IGNORE_ANNOTATION = null;

        @AlwaysNull
        private static final FieldVisitor IGNORE_FIELD = null;

        @AlwaysNull
        private static final MethodVisitor IGNORE_METHOD = null;
        private final ElementMatcher<? super TypeDescription> filter;
        private final Set<String> observedTypes;
        private final boolean strict;
        private final TypePool typePool;
        private final Set<String> visitedInnerTypes;

        public class TypeReferenceAnnotationVisitor extends AnnotationVisitor {
            public TypeReferenceAnnotationVisitor(AnnotationVisitor annotationVisitor) {
                super(OpenedClassReader.ASM_API, annotationVisitor);
            }

            @Override // net.bytebuddy.jar.asm.AnnotationVisitor
            public void visit(String str, Object obj) {
                TypeReferenceClassVisitor.this.resolve(obj);
                super.visit(str, obj);
            }

            @Override // net.bytebuddy.jar.asm.AnnotationVisitor
            @MaybeNull
            public AnnotationVisitor visitAnnotation(String str, String str2) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str2).getInternalName());
                AnnotationVisitor annotationVisitorVisitAnnotation = super.visitAnnotation(str, str2);
                return annotationVisitorVisitAnnotation != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitAnnotation) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.AnnotationVisitor
            @MaybeNull
            public AnnotationVisitor visitArray(String str) {
                AnnotationVisitor annotationVisitorVisitArray = super.visitArray(str);
                return annotationVisitorVisitArray != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitArray) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.AnnotationVisitor
            public void visitEnum(String str, String str2, String str3) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str2).getInternalName());
                super.visitEnum(str, str2, str3);
            }
        }

        public class TypeReferenceFieldVisitor extends FieldVisitor {
            public TypeReferenceFieldVisitor(FieldVisitor fieldVisitor) {
                super(OpenedClassReader.ASM_API, fieldVisitor);
            }

            @Override // net.bytebuddy.jar.asm.FieldVisitor
            @MaybeNull
            public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor annotationVisitorVisitAnnotation = super.visitAnnotation(str, z6);
                return annotationVisitorVisitAnnotation != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitAnnotation) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }
        }

        public class TypeReferenceMethodVisitor extends MethodVisitor {
            public TypeReferenceMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            @MaybeNull
            public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor annotationVisitorVisitAnnotation = super.visitAnnotation(str, z6);
                return annotationVisitorVisitAnnotation != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitAnnotation) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            @MaybeNull
            public AnnotationVisitor visitAnnotationDefault() {
                AnnotationVisitor annotationVisitorVisitAnnotationDefault = super.visitAnnotationDefault();
                return annotationVisitorVisitAnnotationDefault != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitAnnotationDefault) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitFieldInsn(int i, String str, String str2, String str3) {
                TypeReferenceClassVisitor.this.observeInternalName(str);
                TypeReferenceClassVisitor.this.resolve(Type.getType(str3));
                super.visitFieldInsn(i, str, str2, str3);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            @MaybeNull
            public AnnotationVisitor visitInsnAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor annotationVisitorVisitInsnAnnotation = super.visitInsnAnnotation(i, typePath, str, z6);
                return annotationVisitorVisitInsnAnnotation != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitInsnAnnotation) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
                TypeReferenceClassVisitor.this.resolve(Type.getType(str2));
                TypeReferenceClassVisitor.this.resolve(handle);
                for (Object obj : objArr) {
                    TypeReferenceClassVisitor.this.resolve(obj);
                }
                super.visitInvokeDynamicInsn(str, str2, handle, objArr);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitLdcInsn(Object obj) {
                TypeReferenceClassVisitor.this.resolve(obj);
                super.visitLdcInsn(obj);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            @MaybeNull
            public AnnotationVisitor visitLocalVariableAnnotation(int i, @MaybeNull TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z6) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor annotationVisitorVisitLocalVariableAnnotation = super.visitLocalVariableAnnotation(i, typePath, labelArr, labelArr2, iArr, str, z6);
                return annotationVisitorVisitLocalVariableAnnotation != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitLocalVariableAnnotation) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitMethodInsn(int i, String str, String str2, String str3, boolean z6) {
                TypeReferenceClassVisitor.this.observeInternalName(str);
                TypeReferenceClassVisitor.this.resolve(Type.getType(str3));
                super.visitMethodInsn(i, str, str2, str3, z6);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitMultiANewArrayInsn(String str, int i) {
                TypeReferenceClassVisitor.this.resolve(Type.getType(str));
                super.visitMultiANewArrayInsn(str, i);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            @MaybeNull
            public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z6) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor annotationVisitorVisitParameterAnnotation = super.visitParameterAnnotation(i, str, z6);
                return annotationVisitorVisitParameterAnnotation != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitParameterAnnotation) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            @MaybeNull
            public AnnotationVisitor visitTryCatchAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor annotationVisitorVisitTryCatchAnnotation = super.visitTryCatchAnnotation(i, typePath, str, z6);
                return annotationVisitorVisitTryCatchAnnotation != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitTryCatchAnnotation) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitTryCatchBlock(Label label, Label label2, Label label3, @MaybeNull String str) {
                if (str != null) {
                    TypeReferenceClassVisitor.this.observedTypes.add(str);
                }
                super.visitTryCatchBlock(label, label2, label3, str);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            @MaybeNull
            public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor annotationVisitorVisitTypeAnnotation = super.visitTypeAnnotation(i, typePath, str, z6);
                return annotationVisitorVisitTypeAnnotation != null ? TypeReferenceClassVisitor.this.new TypeReferenceAnnotationVisitor(annotationVisitorVisitTypeAnnotation) : TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitTypeInsn(int i, String str) {
                TypeReferenceClassVisitor.this.observeInternalName(str);
                super.visitTypeInsn(i, str);
            }
        }

        public TypeReferenceClassVisitor(ClassVisitor classVisitor, boolean z6, ElementMatcher<? super TypeDescription> elementMatcher, TypePool typePool) {
            super(OpenedClassReader.ASM_API, classVisitor);
            this.typePool = typePool;
            this.strict = z6;
            this.filter = elementMatcher;
            this.observedTypes = new HashSet();
            this.visitedInnerTypes = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeInternalName(String str) {
            int iLastIndexOf = str.lastIndexOf(91);
            if (iLastIndexOf != -1) {
                str = str.substring(iLastIndexOf + 2, str.length() - 1);
            }
            this.observedTypes.add(str);
        }

        public void resolve(Type type) {
            if (type.getSort() != 11) {
                while (type.getSort() == 9) {
                    type = type.getElementType();
                }
                if (type.getSort() == 10) {
                    this.observedTypes.add(type.getInternalName());
                    return;
                }
                return;
            }
            resolve(type.getReturnType());
            for (Type type2 : type.getArgumentTypes()) {
                resolve(type2);
            }
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        public void visit(int i, int i3, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
            if (str3 != null) {
                this.observedTypes.add(str3);
            }
            if (strArr != null) {
                this.observedTypes.addAll(Arrays.asList(strArr));
            }
            super.visit(i, i3, str, str2, str3, strArr);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public AnnotationVisitor visitAnnotation(String str, boolean z6) {
            this.observedTypes.add(Type.getType(str).getInternalName());
            AnnotationVisitor annotationVisitorVisitAnnotation = super.visitAnnotation(str, z6);
            return annotationVisitorVisitAnnotation != null ? new TypeReferenceAnnotationVisitor(annotationVisitorVisitAnnotation) : IGNORE_ANNOTATION;
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public void visitEnd() {
            for (String str : this.observedTypes) {
                if (this.visitedInnerTypes.add(str)) {
                    TypePool.Resolution resolutionDescribe = this.typePool.describe(str.replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
                    if (resolutionDescribe.isResolved()) {
                        TypeDescription typeDescriptionResolve = resolutionDescribe.resolve();
                        if (this.filter.matches(typeDescriptionResolve)) {
                            continue;
                        } else {
                            while (typeDescriptionResolve != null && typeDescriptionResolve.isNestedClass()) {
                                super.visitInnerClass(typeDescriptionResolve.getInternalName(), typeDescriptionResolve.isMemberType() ? typeDescriptionResolve.getDeclaringType().getInternalName() : null, typeDescriptionResolve.isAnonymousType() ? null : typeDescriptionResolve.getSimpleName(), typeDescriptionResolve.getModifiers());
                                do {
                                    try {
                                        typeDescriptionResolve = typeDescriptionResolve.getEnclosingType();
                                        if (typeDescriptionResolve != null) {
                                        }
                                    } catch (RuntimeException e) {
                                        if (this.strict) {
                                            throw e;
                                        }
                                    }
                                } while (!this.visitedInnerTypes.add(typeDescriptionResolve.getInternalName()));
                            }
                        }
                    } else if (this.strict) {
                        throw new IllegalStateException("Could not locate type for: " + str.replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
                    }
                }
            }
            super.visitEnd();
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public FieldVisitor visitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
            FieldVisitor fieldVisitorVisitField = super.visitField(i, str, str2, str3, obj);
            if (fieldVisitorVisitField == null) {
                return IGNORE_FIELD;
            }
            resolve(Type.getType(str2));
            return new TypeReferenceFieldVisitor(fieldVisitorVisitField);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        public void visitInnerClass(String str, String str2, String str3, int i) {
            this.visitedInnerTypes.add(str);
            super.visitInnerClass(str, str2, str3, i);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
            MethodVisitor methodVisitorVisitMethod = super.visitMethod(i, str, str2, str3, strArr);
            if (methodVisitorVisitMethod == null) {
                return IGNORE_METHOD;
            }
            resolve(Type.getType(str2));
            if (strArr != null) {
                this.observedTypes.addAll(Arrays.asList(strArr));
            }
            return new TypeReferenceMethodVisitor(methodVisitorVisitMethod);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        public void visitNestHost(String str) {
            this.observedTypes.add(str);
            super.visitNestHost(str);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        public void visitNestMember(String str) {
            this.observedTypes.add(str);
            super.visitNestMember(str);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        public void visitOuterClass(String str, String str2, String str3) {
            this.observedTypes.add(str);
            super.visitOuterClass(str, str2, str3);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public RecordComponentVisitor visitRecordComponent(String str, String str2, @MaybeNull String str3) {
            this.observedTypes.add(Type.getType(str2).getInternalName());
            return super.visitRecordComponent(str, str2, str3);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
            this.observedTypes.add(Type.getType(str).getInternalName());
            AnnotationVisitor annotationVisitorVisitTypeAnnotation = super.visitTypeAnnotation(i, typePath, str, z6);
            return annotationVisitorVisitTypeAnnotation != null ? new TypeReferenceAnnotationVisitor(annotationVisitorVisitTypeAnnotation) : IGNORE_ANNOTATION;
        }

        public void resolve(Handle handle) {
            this.observedTypes.add(handle.getOwner());
            Type type = Type.getType(handle.getDesc());
            resolve(type.getReturnType());
            for (Type type2 : type.getArgumentTypes()) {
                resolve(type2);
            }
        }

        public void resolve(ConstantDynamic constantDynamic) {
            Type type = Type.getType(constantDynamic.getDescriptor());
            resolve(type.getReturnType());
            for (Type type2 : type.getArgumentTypes()) {
                resolve(type2);
            }
            resolve(constantDynamic.getBootstrapMethod());
            for (int i = 0; i < constantDynamic.getBootstrapMethodArgumentCount(); i++) {
                resolve(constantDynamic.getBootstrapMethodArgument(i));
            }
        }

        public void resolve(Object obj) {
            if (obj instanceof Type) {
                resolve((Type) obj);
            } else if (obj instanceof Handle) {
                resolve((Handle) obj);
            } else if (obj instanceof ConstantDynamic) {
                resolve((ConstantDynamic) obj);
            }
        }
    }
}
