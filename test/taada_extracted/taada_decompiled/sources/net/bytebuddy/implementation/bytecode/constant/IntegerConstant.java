package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public enum IntegerConstant implements StackManipulation {
    MINUS_ONE(2),
    ZERO(3),
    ONE(4),
    TWO(5),
    THREE(6),
    FOUR(7),
    FIVE(8);

    private static final StackManipulation.Size SIZE = StackSize.SINGLE.toIncreasingSize();
    private final int opcode;

    @HashCodeAndEqualsPlugin.Enhance
    public static class ConstantPool extends StackManipulation.AbstractBase {
        private final int value;

        public ConstantPool(int i) {
            this.value = i;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitLdcInsn(Integer.valueOf(this.value));
            return IntegerConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ConstantPool) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class SingleBytePush extends StackManipulation.AbstractBase {
        private final byte value;

        public SingleBytePush(byte b) {
            this.value = b;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitIntInsn(16, this.value);
            return IntegerConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((SingleBytePush) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class TwoBytePush extends StackManipulation.AbstractBase {
        private final short value;

        public TwoBytePush(short s3) {
            this.value = s3;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitIntInsn(17, this.value);
            return IntegerConstant.SIZE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((TwoBytePush) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    IntegerConstant(int i) {
        this.opcode = i;
    }

    public static StackManipulation forValue(boolean z6) {
        return z6 ? ONE : ZERO;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    public static StackManipulation forValue(int i) {
        switch (i) {
            case -1:
                return MINUS_ONE;
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            default:
                return (i < -128 || i > 127) ? (i < -32768 || i > 32767) ? new ConstantPool(i) : new TwoBytePush((short) i) : new SingleBytePush((byte) i);
        }
    }
}
