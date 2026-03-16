package net.bytebuddy.implementation.bytecode.assign.primitive;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class PrimitiveTypeAwareAssigner implements Assigner {
    private final Assigner referenceTypeAwareAssigner;

    public PrimitiveTypeAwareAssigner(Assigner assigner) {
        this.referenceTypeAwareAssigner = assigner;
    }

    @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
    public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
        return (generic.isPrimitive() && generic2.isPrimitive()) ? PrimitiveWideningDelegate.forPrimitive(generic).widenTo(generic2) : generic.isPrimitive() ? PrimitiveBoxingDelegate.forPrimitive(generic).assignBoxedTo(generic2, this.referenceTypeAwareAssigner, typing) : generic2.isPrimitive() ? PrimitiveUnboxingDelegate.forReferenceType(generic).assignUnboxedTo(generic2, this.referenceTypeAwareAssigner, typing) : this.referenceTypeAwareAssigner.assign(generic, generic2, typing);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.referenceTypeAwareAssigner.equals(((PrimitiveTypeAwareAssigner) obj).referenceTypeAwareAssigner);
    }

    public int hashCode() {
        return this.referenceTypeAwareAssigner.hashCode() + (getClass().hashCode() * 31);
    }
}
