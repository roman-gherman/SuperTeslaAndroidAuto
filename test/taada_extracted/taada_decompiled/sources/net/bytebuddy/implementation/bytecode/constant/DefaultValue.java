package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* JADX INFO: loaded from: classes2.dex */
public enum DefaultValue implements StackManipulation {
    INTEGER(IntegerConstant.ZERO),
    LONG(LongConstant.ZERO),
    FLOAT(FloatConstant.ZERO),
    DOUBLE(DoubleConstant.ZERO),
    VOID(StackManipulation.Trivial.INSTANCE),
    REFERENCE(NullConstant.INSTANCE);

    private final StackManipulation stackManipulation;

    DefaultValue(StackManipulation stackManipulation) {
        this.stackManipulation = stackManipulation;
    }

    public static StackManipulation of(TypeDefinition typeDefinition) {
        return typeDefinition.isPrimitive() ? typeDefinition.represents(Long.TYPE) ? LONG : typeDefinition.represents(Double.TYPE) ? DOUBLE : typeDefinition.represents(Float.TYPE) ? FLOAT : typeDefinition.represents(Void.TYPE) ? VOID : INTEGER : REFERENCE;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        return this.stackManipulation.apply(methodVisitor, context);
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return this.stackManipulation.isValid();
    }
}
