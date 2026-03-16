package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public enum ClassConstant implements StackManipulation {
    VOID(Void.class),
    BOOLEAN(Boolean.class),
    BYTE(Byte.class),
    SHORT(Short.class),
    CHARACTER(Character.class),
    INTEGER(Integer.class),
    LONG(Long.class),
    FLOAT(Float.class),
    DOUBLE(Double.class);

    private static final String CLASS_TYPE_INTERNAL_NAME = "Ljava/lang/Class;";
    private static final String PRIMITIVE_TYPE_FIELD = "TYPE";
    private static final StackManipulation.Size SIZE = StackSize.SINGLE.toIncreasingSize();
    private final String fieldOwnerInternalName;

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForReferenceType implements StackManipulation {
        private final TypeDescription typeDescription;

        public ForReferenceType(TypeDescription typeDescription) {
            this.typeDescription = typeDescription;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            if (context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V5) && this.typeDescription.isVisibleTo(context.getInstrumentedType())) {
                methodVisitor.visitLdcInsn(Type.getType(this.typeDescription.getDescriptor()));
            } else {
                methodVisitor.visitLdcInsn(this.typeDescription.getName());
                methodVisitor.visitMethodInsn(184, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME, "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false);
            }
            return ClassConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForReferenceType) obj).typeDescription);
        }

        public int hashCode() {
            return this.typeDescription.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }
    }

    ClassConstant(Class cls) {
        this.fieldOwnerInternalName = Type.getInternalName(cls);
    }

    public static StackManipulation of(TypeDescription typeDescription) {
        return !typeDescription.isPrimitive() ? new ForReferenceType(typeDescription) : typeDescription.represents(Boolean.TYPE) ? BOOLEAN : typeDescription.represents(Byte.TYPE) ? BYTE : typeDescription.represents(Short.TYPE) ? SHORT : typeDescription.represents(Character.TYPE) ? CHARACTER : typeDescription.represents(Integer.TYPE) ? INTEGER : typeDescription.represents(Long.TYPE) ? LONG : typeDescription.represents(Float.TYPE) ? FLOAT : typeDescription.represents(Double.TYPE) ? DOUBLE : VOID;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitFieldInsn(178, this.fieldOwnerInternalName, PRIMITIVE_TYPE_FIELD, CLASS_TYPE_INTERNAL_NAME);
        return SIZE;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }
}
