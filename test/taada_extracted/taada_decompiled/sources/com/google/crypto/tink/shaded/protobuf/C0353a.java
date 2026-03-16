package com.google.crypto.tink.shaded.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0353a extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2864a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0353a(InputStream inputStream, int i, int i3) {
        super(inputStream);
        this.f2864a = i3;
        this.b = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        switch (this.f2864a) {
        }
        return Math.min(super.available(), this.b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        switch (this.f2864a) {
            case 0:
                if (this.b <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i < 0) {
                    return i;
                }
                this.b--;
                return i;
            default:
                if (this.b <= 0) {
                    return -1;
                }
                int i3 = super.read();
                if (i3 < 0) {
                    return i3;
                }
                this.b--;
                return i3;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j6) throws IOException {
        switch (this.f2864a) {
            case 0:
                int iSkip = (int) super.skip(Math.min(j6, this.b));
                if (iSkip >= 0) {
                    this.b -= iSkip;
                }
                return iSkip;
            default:
                long jSkip = super.skip(Math.min(j6, this.b));
                if (jSkip >= 0) {
                    this.b = (int) (((long) this.b) - jSkip);
                }
                return jSkip;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) throws IOException {
        switch (this.f2864a) {
            case 0:
                int i4 = this.b;
                if (i4 <= 0) {
                    return -1;
                }
                int i5 = super.read(bArr, i, Math.min(i3, i4));
                if (i5 < 0) {
                    return i5;
                }
                this.b -= i5;
                return i5;
            default:
                int i6 = this.b;
                if (i6 <= 0) {
                    return -1;
                }
                int i7 = super.read(bArr, i, Math.min(i3, i6));
                if (i7 < 0) {
                    return i7;
                }
                this.b -= i7;
                return i7;
        }
    }
}
