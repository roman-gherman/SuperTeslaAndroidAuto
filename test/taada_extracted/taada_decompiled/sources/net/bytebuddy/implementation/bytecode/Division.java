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
public final class Division implements StackManipulation {
    private static final /* synthetic */ Division[] $VALUES;
    public static final Division DOUBLE;
    public static final Division FLOAT;
    public static final Division INTEGER;
    public static final Division LONG;
    private final int opcode;
    private final StackSize stackSize;

    static {
        StackSize stackSize = StackSize.SINGLE;
        Division division = new Division("INTEGER", 0, 108, stackSize);
        INTEGER = division;
        StackSize stackSize2 = StackSize.DOUBLE;
        Division division2 = new Division("LONG", 1, 109, stackSize2);
        LONG = division2;
        Division division3 = new Division("FLOAT", 2, 110, stackSize);
        FLOAT = division3;
        Division division4 = new Division("DOUBLE", 3, 111, stackSize2);
        DOUBLE = division4;
        $VALUES = new Division[]{division, division2, division3, division4};
    }

    private Division(String str, int i, int i3, StackSize stackSize) {
        this.opcode = i3;
        this.stackSize = stackSize;
    }

    public static Division valueOf(String str) {
        return (Division) Enum.valueOf(Division.class, str);
    }

    public static Division[] values() {
        return (Division[]) $VALUES.clone();
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
