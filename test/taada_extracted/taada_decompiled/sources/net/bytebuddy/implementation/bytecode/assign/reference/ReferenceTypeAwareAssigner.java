package net.bytebuddy.implementation.bytecode.assign.reference;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

/* JADX INFO: loaded from: classes2.dex */
public enum ReferenceTypeAwareAssigner implements Assigner {
    INSTANCE;

    @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
    public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
        return (generic.isPrimitive() || generic2.isPrimitive()) ? generic.equals(generic2) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE : generic.asErasure().isAssignableTo(generic2.asErasure()) ? StackManipulation.Trivial.INSTANCE : typing.isDynamic() ? TypeCasting.to(generic2) : StackManipulation.Illegal.INSTANCE;
    }
}
