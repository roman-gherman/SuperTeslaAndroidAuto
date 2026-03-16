package I1;

import fr.sd.taada.proto.KeyCode;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Appendable, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectPool f753a;
    public J1.b b;
    public J1.b c;
    public ByteBuffer d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f756h;

    public c() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = J1.b.f826h;
        e pool = b.f752a;
        h.f(pool, "pool");
        this.f753a = pool;
        this.d = G1.b.f421a;
    }

    public final void a() {
        J1.b bVar = this.c;
        if (bVar != null) {
            this.e = bVar.c;
        }
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            append("null", 0, 4);
            return this;
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final c append(CharSequence charSequence, int i, int i3) {
        if (charSequence == null) {
            return append("null", i, i3);
        }
        Charset charset = kotlin.text.a.f3943a;
        h.f(charset, "charset");
        J1.b bVarF = J1.c.f(this, 1, null);
        int i4 = i;
        while (true) {
            try {
                CharSequence charSequence2 = charSequence;
                int i5 = i3;
                int iB = J1.c.b(bVarF.f750a, charSequence2, i4, i5, bVarF.c, bVarF.e);
                int i6 = ((short) (iB >>> 16)) & 65535;
                i4 += i6;
                bVarF.a(((short) (iB & 65535)) & 65535);
                int i7 = (i6 != 0 || i4 >= i5) ? i4 < i5 ? 1 : 0 : 8;
                if (i7 <= 0) {
                    return this;
                }
                bVarF = J1.c.f(this, i7, bVarF);
                charSequence = charSequence2;
                i3 = i5;
            } finally {
                a();
            }
        }
    }

    public final d c() {
        int i = (this.e - this.f755g) + this.f756h;
        J1.b bVarE = e();
        if (bVarE != null) {
            return new d(bVarE, i, this.f753a);
        }
        d dVar = d.f757h;
        return d.f757h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ObjectPool pool = this.f753a;
        J1.b bVarE = e();
        if (bVarE == null) {
            return;
        }
        J1.b bVarH = bVarE;
        do {
            try {
                ByteBuffer source = bVarH.f750a;
                h.f(source, "source");
                bVarH = bVarH.h();
            } finally {
                h.f(pool, "pool");
                while (bVarE != null) {
                    J1.b bVarG = bVarE.g();
                    bVarE.j(pool);
                    bVarE = bVarG;
                }
            }
        } while (bVarH != null);
    }

    public final J1.b d(int i) {
        J1.b bVar;
        int i3 = this.f754f;
        int i4 = this.e;
        if (i3 - i4 >= i && (bVar = this.c) != null) {
            bVar.b(i4);
            return bVar;
        }
        J1.b bVar2 = (J1.b) this.f753a.borrow();
        bVar2.e();
        if (bVar2.h() != null) {
            throw new IllegalStateException("It should be a single buffer chunk.");
        }
        J1.b bVar3 = this.c;
        if (bVar3 == null) {
            this.b = bVar2;
            this.f756h = 0;
        } else {
            bVar3.l(bVar2);
            int i5 = this.e;
            bVar3.b(i5);
            this.f756h = (i5 - this.f755g) + this.f756h;
        }
        this.c = bVar2;
        this.f756h = this.f756h;
        this.d = bVar2.f750a;
        this.e = bVar2.c;
        this.f755g = bVar2.b;
        this.f754f = bVar2.e;
        return bVar2;
    }

    public final J1.b e() {
        J1.b bVar = this.b;
        if (bVar == null) {
            return null;
        }
        J1.b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.b(this.e);
        }
        this.b = null;
        this.c = null;
        this.e = 0;
        this.f754f = 0;
        this.f755g = 0;
        this.f756h = 0;
        this.d = G1.b.f421a;
        return bVar;
    }

    public final String toString() {
        return "BytePacketBuilder[0x" + hashCode() + ']';
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        int i = this.e;
        int i3 = 3;
        if (this.f754f - i >= 3) {
            ByteBuffer byteBuffer = this.d;
            if (c >= 0 && c < 128) {
                byteBuffer.put(i, (byte) c);
                i3 = 1;
            } else if (128 <= c && c < 2048) {
                byteBuffer.put(i, (byte) (((c >> 6) & 31) | 192));
                byteBuffer.put(i + 1, (byte) ((c & '?') | 128));
                i3 = 2;
            } else if (2048 <= c && c < 0) {
                byteBuffer.put(i, (byte) (((c >> '\f') & 15) | 224));
                byteBuffer.put(i + 1, (byte) (((c >> 6) & 63) | 128));
                byteBuffer.put(i + 2, (byte) ((c & '?') | 128));
            } else {
                if (0 > c || c >= 0) {
                    J1.c.c(c);
                    throw null;
                }
                byteBuffer.put(i, (byte) (((c >> 18) & 7) | KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE));
                byteBuffer.put(i + 1, (byte) (((c >> '\f') & 63) | 128));
                byteBuffer.put(i + 2, (byte) (((c >> 6) & 63) | 128));
                byteBuffer.put(i + 3, (byte) ((c & '?') | 128));
                i3 = 4;
            }
            this.e = i + i3;
            return this;
        }
        J1.b bVarD = d(3);
        try {
            ByteBuffer byteBuffer2 = bVarD.f750a;
            int i4 = bVarD.c;
            if (c >= 0 && c < 128) {
                byteBuffer2.put(i4, (byte) c);
                i3 = 1;
            } else if (128 <= c && c < 2048) {
                byteBuffer2.put(i4, (byte) (((c >> 6) & 31) | 192));
                byteBuffer2.put(i4 + 1, (byte) ((c & '?') | 128));
                i3 = 2;
            } else if (2048 <= c && c < 0) {
                byteBuffer2.put(i4, (byte) (((c >> '\f') & 15) | 224));
                byteBuffer2.put(i4 + 1, (byte) (((c >> 6) & 63) | 128));
                byteBuffer2.put(i4 + 2, (byte) ((c & '?') | 128));
            } else {
                if (0 > c || c >= 0) {
                    J1.c.c(c);
                    throw null;
                }
                byteBuffer2.put(i4, (byte) (((c >> 18) & 7) | KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE));
                byteBuffer2.put(i4 + 1, (byte) (((c >> '\f') & 63) | 128));
                byteBuffer2.put(i4 + 2, (byte) (((c >> 6) & 63) | 128));
                byteBuffer2.put(i4 + 3, (byte) ((c & '?') | 128));
                i3 = 4;
            }
            bVarD.a(i3);
            if (i3 >= 0) {
                a();
                return this;
            }
            throw new IllegalStateException("The returned value shouldn't be negative");
        } catch (Throwable th) {
            a();
            throw th;
        }
    }
}
