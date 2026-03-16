package net.bytebuddy.asm;

import com.android.multidex.ClassPathElement;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public enum TypeConstantAdjustment implements AsmVisitorWrapper {
    INSTANCE;

    public static class TypeConstantDissolvingClassVisitor extends ClassVisitor {
        private boolean supportsTypeConstants;

        public static class TypeConstantDissolvingMethodVisitor extends MethodVisitor {
            private static final String DESCRIPTOR = "(Ljava/lang/String;)Ljava/lang/Class;";
            private static final String FOR_NAME = "forName";
            private static final String JAVA_LANG_CLASS = "java/lang/Class";

            public TypeConstantDissolvingMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            @SuppressFBWarnings(justification = "Fall through to default case is intentional.", value = {"SF_SWITCH_NO_DEFAULT"})
            public void visitLdcInsn(Object obj) {
                Type type;
                int sort;
                if (!(obj instanceof Type) || ((sort = (type = (Type) obj).getSort()) != 9 && sort != 10)) {
                    super.visitLdcInsn(obj);
                } else {
                    super.visitLdcInsn(type.getInternalName().replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
                    super.visitMethodInsn(184, "java/lang/Class", FOR_NAME, DESCRIPTOR, false);
                }
            }
        }

        public TypeConstantDissolvingClassVisitor(ClassVisitor classVisitor) {
            super(OpenedClassReader.ASM_API, classVisitor);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        public void visit(int i, int i3, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
            this.supportsTypeConstants = ClassFileVersion.ofMinorMajor(i).isAtLeast(ClassFileVersion.JAVA_V5);
            super.visit(i, i3, str, str2, str3, strArr);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
            MethodVisitor methodVisitorVisitMethod = super.visitMethod(i, str, str2, str3, strArr);
            return (this.supportsTypeConstants || methodVisitorVisitMethod == null) ? methodVisitorVisitMethod : new TypeConstantDissolvingMethodVisitor(methodVisitorVisitMethod);
        }
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper
    public int mergeReader(int i) {
        return i;
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper
    public int mergeWriter(int i) {
        return i;
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper
    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i3) {
        return new TypeConstantDissolvingClassVisitor(classVisitor);
    }
}
