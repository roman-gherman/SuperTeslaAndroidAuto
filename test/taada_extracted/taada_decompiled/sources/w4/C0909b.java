package w4;

import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner;
import w3.C0898p;

/* JADX INFO: renamed from: w4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0909b extends j implements LMSContextBasedSigner {
    public final int b;
    public final boolean c;
    public List d;
    public List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f5079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5080g;

    public C0909b(int i, ArrayList arrayList, ArrayList arrayList2, long j6, long j7, boolean z6) {
        super(true);
        this.f5080g = 0L;
        this.b = i;
        this.d = Collections.unmodifiableList(arrayList);
        this.e = Collections.unmodifiableList(arrayList2);
        this.f5080g = j6;
        this.f5079f = j7;
        this.c = z6;
    }

    public static C0909b a(Object obj) {
        Throwable th;
        if (obj instanceof C0909b) {
            return (C0909b) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("unknown version for hss private key");
            }
            int i = dataInputStream.readInt();
            long j6 = dataInputStream.readLong();
            long j7 = dataInputStream.readLong();
            boolean z6 = dataInputStream.readBoolean();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < i; i3++) {
                arrayList.add(l.e(obj));
            }
            for (int i4 = 0; i4 < i - 1; i4++) {
                arrayList2.add(n.a(obj));
            }
            return new C0909b(i, arrayList, arrayList2, j6, j7, z6);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(AbstractC0246d.k0((InputStream) obj));
            }
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "cannot parse "));
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                try {
                    C0909b c0909bA = a(dataInputStream3);
                    dataInputStream3.close();
                    return c0909bA;
                } catch (Exception unused) {
                    C0909b c0909b = new C0909b(l.e(obj), r4.d(), r4.e);
                    dataInputStream3.close();
                    return c0909b;
                }
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 == null) {
                    throw th;
                }
                dataInputStream2.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final synchronized List b() {
        return this.d;
    }

    public final void c(int i) {
        int i3;
        f fVar;
        byte[] bArr;
        byte[] bArr2;
        int i4 = i - 1;
        l lVar = (l) this.d.get(i4);
        synchronized (lVar) {
            i3 = lVar.f5097j;
            if (i3 >= lVar.e) {
                throw new com.google.android.gms.tasks.a("ots private keys expired", 7);
            }
            fVar = lVar.d;
            bArr = lVar.b;
            bArr2 = lVar.f5094f;
        }
        int i5 = fVar.b;
        q qVar = new q(bArr, bArr2, io.ktor.utils.io.jvm.javaio.q.f(i5, fVar.f5084f));
        qVar.d = i3;
        qVar.e = -2;
        byte[] bArr3 = new byte[i5];
        qVar.a(bArr3, 0, true);
        byte[] bArr4 = new byte[i5];
        qVar.a(bArr4, 0, false);
        byte[] bArr5 = new byte[16];
        System.arraycopy(bArr4, 0, bArr5, 0, 16);
        ArrayList arrayList = new ArrayList(this.d);
        l lVar2 = (l) this.d.get(i);
        arrayList.set(i, Z.j(lVar2.c, lVar2.d, 0, bArr5, bArr3));
        ArrayList arrayList2 = new ArrayList(this.e);
        l lVar3 = (l) arrayList.get(i4);
        byte[] byteArray = ((l) arrayList.get(i)).f().toByteArray();
        i iVarGenerateLMSContext = lVar3.generateLMSContext();
        iVarGenerateLMSContext.update(byteArray, 0, byteArray.length);
        arrayList2.set(i4, Z.k(iVarGenerateLMSContext));
        this.d = Collections.unmodifiableList(arrayList);
        this.e = Collections.unmodifiableList(arrayList2);
    }

    public final Object clone() {
        try {
            return a(getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00cc A[PHI: r16
      0x00cc: PHI (r16v3 boolean) = (r16v0 boolean), (r16v4 boolean) binds: [B:22:0x00de, B:18:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf A[PHI: r16
      0x00cf: PHI (r16v1 boolean) = (r16v0 boolean), (r16v4 boolean) binds: [B:22:0x00de, B:18:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.C0909b.d():void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0909b.class != obj.getClass()) {
            return false;
        }
        C0909b c0909b = (C0909b) obj;
        if (this.b == c0909b.b && this.c == c0909b.c && this.f5079f == c0909b.f5079f && this.f5080g == c0909b.f5080g && this.d.equals(c0909b.d)) {
            return this.e.equals(c0909b.e);
        }
        return false;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public final i generateLMSContext() {
        List listB;
        List list;
        int i = this.b;
        synchronized (this) {
            try {
                k1.j.l(this);
                listB = b();
                synchronized (this) {
                    list = this.e;
                }
                i iVarGenerateLMSContext = lVar.generateLMSContext();
                iVarGenerateLMSContext.f5089g = oVarArr;
                return iVarGenerateLMSContext;
            } catch (Throwable th) {
                throw th;
            }
        }
        int i3 = i - 1;
        l lVar = (l) b().get(i3);
        o[] oVarArr = new o[i3];
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i4 + 1;
            oVarArr[i4] = new o((n) list.get(i4), ((l) listB.get(i5)).f());
            i4 = i5;
        }
        synchronized (this) {
            this.f5080g++;
        }
        i iVarGenerateLMSContext2 = lVar.generateLMSContext();
        iVarGenerateLMSContext2.f5089g = oVarArr;
        return iVarGenerateLMSContext2;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public final byte[] generateSignature(i iVar) {
        try {
            int i = this.b - 1;
            o[] oVarArr = iVar.f5089g;
            n nVarK = Z.k(iVar);
            C0898p c0898p = new C0898p();
            c0898p.h(i);
            if (oVarArr != null) {
                for (o oVar : oVarArr) {
                    c0898p.a(oVar);
                }
            }
            c0898p.a(nVarK);
            return c0898p.f5068a.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.util.Encodable
    public final synchronized byte[] getEncoded() {
        C0898p c0898p;
        try {
            c0898p = new C0898p();
            c0898p.h(0);
            c0898p.h(this.b);
            long j6 = this.f5080g;
            c0898p.h((int) (j6 >>> 32));
            c0898p.h((int) j6);
            long j7 = this.f5079f;
            c0898p.h((int) (j7 >>> 32));
            c0898p.h((int) j7);
            c0898p.f5068a.write(this.c ? 1 : 0);
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                c0898p.a((l) it.next());
            }
            Iterator it2 = this.e.iterator();
            while (it2.hasNext()) {
                c0898p.a((n) it2.next());
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0898p.f5068a.toByteArray();
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public final long getUsagesRemaining() {
        long j6;
        synchronized (this) {
            j6 = this.f5080g;
        }
        return this.f5079f - j6;
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ((this.d.hashCode() + (((this.b * 31) + (this.c ? 1 : 0)) * 31)) * 31)) * 31;
        long j6 = this.f5079f;
        int i = (iHashCode + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.f5080g;
        return i + ((int) (j7 ^ (j7 >>> 32)));
    }

    public C0909b(l lVar, long j6, long j7) {
        super(true);
        this.f5080g = 0L;
        this.b = 1;
        this.d = Collections.singletonList(lVar);
        this.e = Collections.EMPTY_LIST;
        this.f5080g = j6;
        this.f5079f = j7;
        this.c = false;
        d();
    }
}
