package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0357c implements MessageLite {
    protected int memoizedHashCode;

    public abstract int a(Schema schema);

    public final String b(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final byte[] toByteArray() {
        try {
            int iA = ((Q) this).a(null);
            byte[] bArr = new byte[iA];
            Logger logger = AbstractC0398x.d;
            C0392u c0392u = new C0392u(bArr, iA);
            ((Q) this).writeTo(c0392u);
            if (c0392u.i0() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(b("byte array"), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final AbstractC0381o toByteString() {
        try {
            int iA = ((Q) this).a(null);
            C0379n c0379n = AbstractC0381o.b;
            byte[] bArr = new byte[iA];
            Logger logger = AbstractC0398x.d;
            C0392u c0392u = new C0392u(bArr, iA);
            ((Q) this).writeTo(c0392u);
            if (c0392u.i0() == 0) {
                return new C0379n(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(b("ByteString"), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final void writeDelimitedTo(OutputStream outputStream) {
        Q q = (Q) this;
        int iA = q.a(null);
        int I = AbstractC0398x.I(iA) + iA;
        if (I > 4096) {
            I = 4096;
        }
        C0396w c0396w = new C0396w(outputStream, I);
        c0396w.f0(iA);
        q.writeTo(c0396w);
        if (c0396w.f2923h > 0) {
            c0396w.n0();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final void writeTo(OutputStream outputStream) {
        Q q = (Q) this;
        int iA = q.a(null);
        Logger logger = AbstractC0398x.d;
        if (iA > 4096) {
            iA = 4096;
        }
        C0396w c0396w = new C0396w(outputStream, iA);
        q.writeTo(c0396w);
        if (c0396w.f2923h > 0) {
            c0396w.n0();
        }
    }
}
