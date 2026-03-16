package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INTEGER' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class Multiplication implements StackManipulation {
    private static final /* synthetic */ Multiplication[] $VALUES;
    public static final Multiplication DOUBLE;
    public static final Multiplication FLOAT;
    public static final Multiplication INTEGER;
    public static final Multiplication LONG;
    private final int opcode;
    private final StackSize stackSize;

    static {
        StackSize stackSize = StackSize.SINGLE;
        Multiplication multiplication = new Multiplication("INTEGER", 0, 104, stackSize);
        INTEGER = multiplication;
        StackSize stackSize2 = StackSize.DOUBLE;
        Multiplication multiplication2 = new Multiplication("LONG", 1, 105, stackSize2);
        LONG = multiplication2;
        Multiplication multiplication3 = new Multiplication("FLOAT", 2, 106, stackSize);
        FLOAT = multiplication3;
        Multiplication multiplication4 = new Multiplication("DOUBLE", 3, 107, stackSize2);
        DOUBLE = multiplication4;
        $VALUES = new Multiplication[]{multiplication, multiplication2, multiplication3, multiplication4};
    }

    private Multiplication(String str, int i, int i3, StackSize stackSize) {
        this.opcode = i3;
        this.stackSize = stackSize;
    }

    public static Multiplication valueOf(String str) {
        return (Multiplication) Enum.valueOf(Multiplication.class, str);
    }

    public static Multiplication[] values() {
        return (Multiplication[]) $VALUES.clone();
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return this.stackSize.toDecreasingSize();
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }
}
