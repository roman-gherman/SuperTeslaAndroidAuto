package V2;

import L2.f;
import a3.AbstractC0162z;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import q2.AbstractC0778o;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a implements ImplicitContextReceiver {
    public final /* synthetic */ int d = 1;
    public final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DeclarationDescriptorNonRoot f1372f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(CallableDescriptor callableDescriptor, AbstractC0162z receiverType, f fVar, ReceiverValue receiverValue) {
        super(receiverType, receiverValue);
        h.f(receiverType, "receiverType");
        this.f1372f = (AbstractC0778o) callableDescriptor;
        this.e = fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver
    public final f getCustomLabelName() {
        switch (this.d) {
        }
        return this.e;
    }

    @Override // V2.a
    public final String toString() {
        switch (this.d) {
            case 0:
                return getType() + ": Ctx { " + ((ClassDescriptor) this.f1372f) + " }";
            default:
                return "Cxt { " + ((AbstractC0778o) this.f1372f) + " }";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ClassDescriptor classDescriptor, AbstractC0162z receiverType, f fVar) {
        super(receiverType, (ReceiverValue) null);
        h.f(receiverType, "receiverType");
        this.f1372f = classDescriptor;
        this.e = fVar;
    }
}
