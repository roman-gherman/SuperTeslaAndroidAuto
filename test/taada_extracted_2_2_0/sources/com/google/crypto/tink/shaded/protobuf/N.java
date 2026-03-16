package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class N implements MessageInfoFactory {
    public static final N b = new N(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2840a;

    public /* synthetic */ N(int i) {
        this.f2840a = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
    public final boolean isSupported(Class cls) {
        switch (this.f2840a) {
            case 0:
                return Q.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
    public final MessageInfo messageInfoFor(Class cls) {
        switch (this.f2840a) {
            case 0:
                if (!Q.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (MessageInfo) Q.f(cls.asSubclass(Q.class)).e(3);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }
}
