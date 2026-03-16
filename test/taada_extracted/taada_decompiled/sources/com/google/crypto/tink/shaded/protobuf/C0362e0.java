package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0362e0 implements MessageInfoFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageInfoFactory[] f2876a;

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
    public final boolean isSupported(Class cls) {
        for (MessageInfoFactory messageInfoFactory : this.f2876a) {
            if (messageInfoFactory.isSupported(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
    public final MessageInfo messageInfoFor(Class cls) {
        for (MessageInfoFactory messageInfoFactory : this.f2876a) {
            if (messageInfoFactory.isSupported(cls)) {
                return messageInfoFactory.messageInfoFor(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
