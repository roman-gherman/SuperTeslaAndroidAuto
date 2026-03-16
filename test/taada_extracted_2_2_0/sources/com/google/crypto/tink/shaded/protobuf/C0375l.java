package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0375l implements ByteString$ByteArrayCopier, MutabilityOracle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2886a;

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString$ByteArrayCopier
    public byte[] copyFrom(byte[] bArr, int i, int i3) {
        switch (this.f2886a) {
            case 0:
                return Arrays.copyOfRange(bArr, i, i3 + i);
            default:
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return bArr2;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MutabilityOracle
    public void ensureMutable() {
        throw new UnsupportedOperationException();
    }
}
