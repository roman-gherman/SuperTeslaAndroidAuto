package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0397w0 implements MessageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageLite f2924a;
    public final String b;
    public final Object[] c;
    public final int d;

    public C0397w0(MessageLite messageLite, String str, Object[] objArr) {
        this.f2924a = messageLite;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i3 = 1;
        int i4 = 13;
        while (true) {
            int i5 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i4);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i4;
                i4 += 13;
                i3 = i5;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public final MessageLite getDefaultInstance() {
        return this.f2924a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public final EnumC0391t0 getSyntax() {
        return (this.d & 1) == 1 ? EnumC0391t0.f2916a : EnumC0391t0.b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public final boolean isMessageSetWireFormat() {
        return (this.d & 2) == 2;
    }
}
