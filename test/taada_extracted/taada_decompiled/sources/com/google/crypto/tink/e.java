package com.google.crypto.tink;

import C0.y;
import G0.A1;
import G0.C0043c1;
import G0.C0049e1;
import G0.C0058h1;
import G0.C0067k1;
import G0.C0070l1;
import G0.C0073m1;
import G0.C0076n1;
import G0.C0084r0;
import G0.EnumC0046d1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.D;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.V;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Registry$KeyDeriverContainer, KeysetReader {
    public static final e c;
    public static final e d;
    public static final e e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2794a;
    public final Object b;

    static {
        int i = 0;
        c = new e("ENABLED", i);
        d = new e("DISABLED", i);
        e = new e("DESTROYED", i);
    }

    public /* synthetic */ e(Object obj, int i) {
        this.f2794a = i;
        this.b = obj;
    }

    public synchronized void a(C0058h1 c0058h1) {
        C0073m1 c0073m1B;
        synchronized (this) {
            c0073m1B = b(m.e(c0058h1), c0058h1.getOutputPrefixType());
        }
        C0067k1 c0067k1 = (C0067k1) this.b;
        c0067k1.p();
        C0076n1.u((C0076n1) c0067k1.b, c0073m1B);
    }

    public synchronized C0073m1 b(C0049e1 c0049e1, A1 a12) {
        C0070l1 c0070l1X;
        int iD = d();
        if (a12 == A1.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        c0070l1X = C0073m1.x();
        c0070l1X.p();
        C0073m1.t((C0073m1) c0070l1X.b, c0049e1);
        c0070l1X.p();
        C0073m1.w((C0073m1) c0070l1X.b, iD);
        c0070l1X.p();
        C0073m1.v((C0073m1) c0070l1X.b);
        c0070l1X.p();
        C0073m1.u((C0073m1) c0070l1X.b, a12);
        return (C0073m1) c0070l1X.build();
    }

    public synchronized B2.d c() {
        return B2.d.i((C0076n1) ((C0067k1) this.b).build());
    }

    public synchronized int d() {
        int iA;
        boolean z6;
        iA = y.a();
        while (true) {
            synchronized (this) {
                try {
                    Iterator it = ((C0067k1) this.b).getKeyList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z6 = false;
                            break;
                        }
                        if (((C0073m1) it.next()).getKeyId() == iA) {
                            z6 = true;
                            break;
                        }
                    }
                } finally {
                }
            }
            return iA;
            iA = y.a();
        }
        if (!z6) {
            return iA;
        }
        iA = y.a();
    }

    @Override // com.google.crypto.tink.Registry$KeyDeriverContainer
    public C0049e1 deriveKey(AbstractC0381o abstractC0381o, InputStream inputStream) throws GeneralSecurityException {
        C0.e eVar = (C0.e) this.b;
        C0.d dVarD = eVar.d();
        try {
            MessageLite messageLiteI = dVarD.i(abstractC0381o);
            dVarD.k(messageLiteI);
            MessageLite messageLiteC = dVarD.c(messageLiteI, inputStream);
            C0043c1 c0043c1X = C0049e1.x();
            String strB = eVar.b();
            c0043c1X.p();
            C0049e1.t((C0049e1) c0043c1X.b, strB);
            AbstractC0381o byteString = messageLiteC.toByteString();
            c0043c1X.p();
            C0049e1.u((C0049e1) c0043c1X.b, byteString);
            EnumC0046d1 enumC0046d1E = eVar.e();
            c0043c1X.p();
            C0049e1.v((C0049e1) c0043c1X.b, enumC0046d1E);
            return (C0049e1) c0043c1X.build();
        } catch (V e6) {
            throw new GeneralSecurityException("parsing key format failed in deriveKey", e6);
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public C0076n1 read() throws IOException {
        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) this.b;
        try {
            return C0076n1.w(byteArrayInputStream, D.a());
        } finally {
            byteArrayInputStream.close();
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public C0084r0 readEncrypted() {
        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) this.b;
        try {
            return C0084r0.w(byteArrayInputStream, D.a());
        } finally {
            byteArrayInputStream.close();
        }
    }

    public String toString() {
        switch (this.f2794a) {
            case 0:
                return (String) this.b;
            default:
                return super.toString();
        }
    }
}
