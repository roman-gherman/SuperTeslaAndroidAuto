package V2;

import a3.AbstractC0162z;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import net.bytebuddy.description.method.MethodDescription;
import q2.AbstractC0778o;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a implements ImplicitReceiver {
    public final AbstractC0778o d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(CallableDescriptor callableDescriptor, AbstractC0162z abstractC0162z, ReceiverValue receiverValue) {
        super(abstractC0162z, receiverValue);
        if (abstractC0162z == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "receiverType", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver", MethodDescription.CONSTRUCTOR_INTERNAL_NAME));
        }
        this.d = (AbstractC0778o) callableDescriptor;
    }

    @Override // V2.a
    public final String toString() {
        return getType() + ": Ext {" + this.d + "}";
    }
}
