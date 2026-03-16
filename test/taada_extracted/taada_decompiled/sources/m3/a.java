package M3;

import C0.t;
import J1.b;
import L3.c;
import N3.g;
import io.ktor.utils.io.SuspendableReadSession;
import io.ktor.utils.io.U;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.InMemoryRepresentable;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServiceProperties;
import w3.AbstractC0882A;
import w3.C;
import w3.C0886d;
import w3.C0888f;
import w3.C0890h;
import w3.C0907z;
import w3.D;
import w3.E;
import w3.G;
import w3.H;
import w3.I;
import w3.O;
import w3.h0;
import w3.l0;
import w3.m0;
import w3.n0;
import w3.q0;
import z4.C0948a;
import z4.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements CryptoServiceProperties, SuspendableReadSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1114a;
    public int b;
    public Object c;
    public Object d;

    public a(int i) {
        this.f1114a = i;
        switch (i) {
            case 4:
                this.d = new WeakHashMap();
                this.c = new BigInteger[8];
                this.b = 0;
                break;
        }
    }

    public static void a(a aVar, a aVar2, a aVar3) {
        for (int i = 0; i < 64; i++) {
            int i3 = i * 4;
            short[] sArr = (short[]) aVar2.d;
            short s3 = sArr[i3];
            int i4 = i3 + 1;
            short s6 = sArr[i4];
            short[] sArr2 = (short[]) aVar3.d;
            short s7 = sArr2[i3];
            short s8 = sArr2[i4];
            short[] sArr3 = f.f5215a;
            int i5 = i + 64;
            f.a(aVar, i3, s3, s6, s7, s8, sArr3[i5]);
            int i6 = i3 + 2;
            short[] sArr4 = (short[]) aVar2.d;
            short s9 = sArr4[i6];
            int i7 = i3 + 3;
            short s10 = sArr4[i7];
            short[] sArr5 = (short[]) aVar3.d;
            f.a(aVar, i6, s9, s10, sArr5[i6], sArr5[i7], (short) (sArr3[i5] * (-1)));
        }
    }

    @Override // io.ktor.utils.io.SuspendableReadSession
    public Object await(int i, Continuation continuation) {
        b();
        return ((U) this.d).awaitAtLeast(i, continuation);
    }

    public void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f826h;
        c(b.f828k);
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public int bitsOfSecurity() {
        switch (this.f1114a) {
        }
        return this.b;
    }

    public void c(b bVar) {
        int i = this.b;
        b bVar2 = (b) this.c;
        int i3 = i - (bVar2.c - bVar2.b);
        if (i3 > 0) {
            ((U) this.d).consumed(i3);
        }
        this.c = bVar;
        this.b = bVar.c - bVar.b;
    }

    public void d(byte[] bArr, byte b) {
        int i = this.b;
        int i3 = (i * 256) / 4;
        byte[] bArr2 = new byte[i3];
        t tVar = (t) this.c;
        tVar.getClass();
        int length = bArr.length + 1;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = b;
        g gVar = (g) tVar.e;
        gVar.update(bArr3, 0, length);
        gVar.doFinal(bArr2, 0, i3);
        if (i != 3) {
            for (int i4 = 0; i4 < 32; i4++) {
                int i5 = i4 * 4;
                long j6 = ((long) (bArr2[i5] & 255)) | (((long) (bArr2[i5 + 1] & 255)) << 8) | (((long) (bArr2[i5 + 2] & 255)) << 16) | (((long) (bArr2[i5 + 3] & 255)) << 24);
                long j7 = (j6 & 1431655765) + ((j6 >> 1) & 1431655765);
                for (int i6 = 0; i6 < 8; i6++) {
                    int i7 = i6 * 4;
                    ((short[]) this.d)[(i4 * 8) + i6] = (short) (((short) ((j7 >> i7) & 3)) - ((short) ((j7 >> (i7 + i)) & 3)));
                }
            }
            return;
        }
        for (int i8 = 0; i8 < 64; i8++) {
            int i9 = i8 * 3;
            long j8 = ((long) (bArr2[i9] & 255)) | (((long) (bArr2[i9 + 1] & 255)) << 8) | (((long) (bArr2[i9 + 2] & 255)) << 16);
            long j9 = (j8 & 2396745) + ((j8 >> 1) & 2396745) + ((j8 >> 2) & 2396745);
            for (int i10 = 0; i10 < 4; i10++) {
                int i11 = i10 * 6;
                ((short[]) this.d)[(i8 * 4) + i10] = (short) (((short) ((j9 >> i11) & 7)) - ((short) ((j9 >> (i11 + 3)) & 7)));
            }
        }
    }

    @Override // io.ktor.utils.io.ReadSession
    public int discard(int i) {
        b();
        U u = (U) this.d;
        int iMin = Math.min(u.getAvailableForRead(), i);
        u.consumed(iMin);
        return iMin;
    }

    public ASN1Encodable e(int i) throws IOException {
        q0 q0Var = (q0) this.d;
        if (q0Var instanceof n0) {
            n0 n0Var = (n0) q0Var;
            n0Var.f5065f = false;
            n0Var.b();
        }
        int iG = C0890h.g(i, q0Var);
        boolean z6 = iG == 3 || iG == 4 || iG == 16 || iG == 17 || iG == 8;
        int i3 = this.b;
        int iE = C0890h.e(q0Var, i3, z6);
        byte[][] bArr = (byte[][]) this.c;
        if (iE < 0) {
            if ((i & 32) == 0) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            a aVar = new a(new n0(q0Var, i3), i3, bArr);
            int i4 = i & 192;
            return i4 != 0 ? new I(i4, iG, aVar) : aVar.h(iG);
        }
        m0 m0Var = new m0(q0Var, iE, i3);
        if ((i & 224) == 0) {
            return i(iG, m0Var);
        }
        a aVar2 = new a(m0Var, m0Var.b, bArr);
        int i5 = i & 192;
        if (i5 != 0) {
            return new l0(i5, iG, (i & 32) != 0, aVar2);
        }
        return aVar2.g(iG);
    }

    public H f(int i, int i3) throws IOException {
        C0886d c0886dM = m();
        int i4 = c0886dM.b;
        if (i4 == 1) {
            return new H(3, i, i3, c0886dM.b(0), 0);
        }
        D d = AbstractC0882A.f5027a;
        return new H(4, i, i3, i4 < 1 ? AbstractC0882A.f5027a : new D(c0886dM), 0);
    }

    public ASN1Encodable g(int i) throws C0888f {
        if (i == 3) {
            return new C0907z(this);
        }
        if (i == 4) {
            return new C(this);
        }
        if (i == 8) {
            return new O(this);
        }
        if (i == 16) {
            E e = new E(1);
            e.b = this;
            return e;
        }
        if (i != 17) {
            throw new C0888f(androidx.constraintlayout.core.motion.a.h(i, new StringBuilder("unknown DL object encountered: 0x")));
        }
        G g6 = new G(1);
        g6.b = this;
        return g6;
    }

    @Override // io.ktor.utils.io.ReadSession
    public int getAvailableForRead() {
        return ((U) this.d).getAvailableForRead();
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public Object getParams() {
        switch (this.f1114a) {
            case 0:
                return (CipherParameters) this.d;
            default:
                return null;
        }
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public c getPurpose() {
        switch (this.f1114a) {
        }
        return (c) this.c;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public String getServiceName() {
        switch (this.f1114a) {
            case 0:
                return "AES";
            default:
                return (String) this.d;
        }
    }

    public ASN1Encodable h(int i) throws C0888f {
        if (i == 3) {
            return new C0907z(this);
        }
        if (i == 4) {
            return new C(this);
        }
        if (i == 8) {
            return new O(this);
        }
        if (i == 16) {
            E e = new E(0);
            e.b = this;
            return e;
        }
        if (i != 17) {
            throw new C0888f(androidx.constraintlayout.core.motion.a.h(i, new StringBuilder("unknown BER object encountered: 0x")));
        }
        G g6 = new G(0);
        g6.b = this;
        return g6;
    }

    public ASN1Encodable i(int i, m0 m0Var) throws C0888f {
        if (i == 3) {
            return new h0(m0Var);
        }
        if (i == 4) {
            C c = new C();
            c.b = m0Var;
            return c;
        }
        if (i == 8) {
            throw new C0888f("externals must use constructed encoding (see X.690 8.18)");
        }
        if (i == 16) {
            throw new C0888f("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
        }
        if (i == 17) {
            throw new C0888f("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
        }
        try {
            return C0890h.b(i, m0Var, (byte[][]) this.c);
        } catch (IllegalArgumentException e) {
            throw new C0888f(e, "corrupted stream detected");
        }
    }

    public ASN1Encodable j(int i) throws IOException {
        if (i < 0 || i > 30) {
            throw new IllegalArgumentException(B2.b.c(i, "invalid universal tag number: "));
        }
        int i3 = ((q0) this.d).read();
        if (i3 < 0) {
            return null;
        }
        if ((i3 & (-33)) == i) {
            return e(i3);
        }
        throw new IOException(B2.b.c(i3, "unexpected identifier encountered: "));
    }

    public ASN1TaggedObjectParser k() throws IOException {
        int i = ((q0) this.d).read();
        if (i < 0) {
            return null;
        }
        if ((i & 192) != 0) {
            return (ASN1TaggedObjectParser) e(i);
        }
        throw new C0888f("no tagged object found");
    }

    public ASN1Encodable l() throws IOException {
        int i = ((q0) this.d).read();
        if (i < 0) {
            return null;
        }
        return e(i);
    }

    public C0886d m() throws IOException {
        q0 q0Var = (q0) this.d;
        int i = q0Var.read();
        if (i < 0) {
            return new C0886d(0);
        }
        C0886d c0886d = new C0886d();
        do {
            ASN1Encodable aSN1EncodableE = e(i);
            c0886d.a(aSN1EncodableE instanceof InMemoryRepresentable ? ((InMemoryRepresentable) aSN1EncodableE).getLoadedObject() : aSN1EncodableE.toASN1Primitive());
            i = q0Var.read();
        } while (i >= 0);
        return c0886d;
    }

    public void n() {
        for (int i = 0; i < 256; i++) {
            short[] sArr = (short[]) this.d;
            short s3 = sArr[i];
            sArr[i] = (short) (s3 - ((short) (((short) ((((short) 20159) * s3) >> 26)) * 3329)));
        }
    }

    @Override // io.ktor.utils.io.ReadSession
    public b request(int i) {
        ByteBuffer byteBufferRequest = ((U) this.d).request(0, i);
        if (byteBufferRequest == null) {
            return null;
        }
        b bVarB = l.b(byteBufferRequest);
        bVarB.d = 0;
        bVarB.b = 0;
        bVarB.c = bVarB.f751f;
        c(bVarB);
        return bVarB;
    }

    public String toString() {
        switch (this.f1114a) {
            case 7:
                StringBuffer stringBuffer = new StringBuffer("[");
                int i = 0;
                while (true) {
                    short[] sArr = (short[]) this.d;
                    if (i >= sArr.length) {
                        stringBuffer.append("]");
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((int) sArr[i]);
                    if (i != ((short[]) this.d).length - 1) {
                        stringBuffer.append(", ");
                    }
                    i++;
                }
                break;
            default:
                return super.toString();
        }
    }

    public a(int i, String str, c cVar) {
        this.f1114a = 1;
        this.b = i;
        this.d = str;
        this.c = cVar;
    }

    public a(int i, String str, ArrayList arrayList) {
        this.f1114a = 2;
        this.b = i;
        this.c = str;
        this.d = arrayList;
    }

    public a(int i, CipherParameters cipherParameters, c cVar) {
        this.f1114a = 0;
        this.b = i;
        this.d = cipherParameters;
        if (cipherParameters instanceof c) {
            throw new IllegalArgumentException("params should not be CryptoServicePurpose");
        }
        this.c = cVar;
    }

    public a(q0 q0Var, int i, byte[][] bArr) {
        this.f1114a = 6;
        this.d = q0Var;
        this.b = i;
        this.c = bArr;
    }

    public a(C0948a c0948a) {
        this.f1114a = 7;
        this.d = new short[256];
        c0948a.getClass();
        this.b = c0948a.d;
        this.c = c0948a.f5208h;
    }

    public a(U channel) {
        this.f1114a = 5;
        h.f(channel, "channel");
        this.d = channel;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f826h;
        this.c = b.f828k;
    }
}
