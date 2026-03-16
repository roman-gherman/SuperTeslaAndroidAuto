package com.google.crypto.tink.shaded.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0377m extends C0379n {
    private static final long serialVersionUID = 1;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2898f;

    public C0377m(byte[] bArr, int i, int i3) {
        super(bArr);
        AbstractC0381o.b(i, i + i3, bArr.length);
        this.e = i;
        this.f2898f = i3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0379n, com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final byte a(int i) {
        int i3 = this.f2898f;
        if (((i3 - (i + 1)) | i) >= 0) {
            return this.d[this.e + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(B2.b.c(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("Index > length: ", i, ", ", i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0379n, com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final void e(int i, byte[] bArr) {
        System.arraycopy(this.d, this.e, bArr, 0, i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0379n, com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final byte f(int i) {
        return this.d[this.e + i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0379n
    public final int n() {
        return this.e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0379n, com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final int size() {
        return this.f2898f;
    }

    public Object writeReplace() {
        return new C0379n(k());
    }
}
