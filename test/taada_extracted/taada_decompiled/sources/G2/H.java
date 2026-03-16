package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PropertyOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends AbstractC0612m implements ProtoBuf$PropertyOrBuilder {
    public static final H u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final C0101a f452v = new C0101a(12);
    public final AbstractC0604e b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public U f454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f455h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public U f456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f458l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d0 f461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f462p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f463r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte f464s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f465t;

    static {
        H h3 = new H();
        u = h3;
        h3.i();
    }

    public H(G g6) {
        super(g6);
        this.f460n = -1;
        this.f464s = (byte) -1;
        this.f465t = -1;
        this.b = g6.f3869a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f452v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f465t;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 2) == 2 ? C0606g.b(1, this.e) : 0;
        if ((this.c & 4) == 4) {
            iB += C0606g.b(2, this.f453f);
        }
        if ((this.c & 8) == 8) {
            iB += C0606g.d(3, this.f454g);
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            iB += C0606g.d(4, (MessageLite) this.i.get(i3));
        }
        if ((this.c & 32) == 32) {
            iB += C0606g.d(5, this.f456j);
        }
        if ((this.c & 128) == 128) {
            iB += C0606g.d(6, this.f461o);
        }
        if ((this.c & 256) == 256) {
            iB += C0606g.b(7, this.f462p);
        }
        if ((this.c & 512) == 512) {
            iB += C0606g.b(8, this.q);
        }
        if ((this.c & 16) == 16) {
            iB += C0606g.b(9, this.f455h);
        }
        if ((this.c & 64) == 64) {
            iB += C0606g.b(10, this.f457k);
        }
        if ((this.c & 1) == 1) {
            iB += C0606g.b(11, this.d);
        }
        for (int i4 = 0; i4 < this.f458l.size(); i4++) {
            iB += C0606g.d(12, (MessageLite) this.f458l.get(i4));
        }
        int iC = 0;
        for (int i5 = 0; i5 < this.f459m.size(); i5++) {
            iC += C0606g.c(((Integer) this.f459m.get(i5)).intValue());
        }
        int iC2 = iB + iC;
        if (!this.f459m.isEmpty()) {
            iC2 = iC2 + 1 + C0606g.c(iC);
        }
        this.f460n = iC;
        int iC3 = 0;
        for (int i6 = 0; i6 < this.f463r.size(); i6++) {
            iC3 += C0606g.c(((Integer) this.f463r.get(i6)).intValue());
        }
        int size = this.b.size() + c() + (this.f463r.size() * 2) + iC2 + iC3;
        this.f465t = size;
        return size;
    }

    public final void i() {
        this.d = 518;
        this.e = 2054;
        this.f453f = 0;
        U u2 = U.f492t;
        this.f454g = u2;
        this.f455h = 0;
        List list = Collections.EMPTY_LIST;
        this.i = list;
        this.f456j = u2;
        this.f457k = 0;
        this.f458l = list;
        this.f459m = list;
        this.f461o = d0.f561l;
        this.f462p = 0;
        this.q = 0;
        this.f463r = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f464s;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        int i = this.c;
        if ((i & 4) != 4) {
            this.f464s = (byte) 0;
            return false;
        }
        if ((i & 8) == 8 && !this.f454g.isInitialized()) {
            this.f464s = (byte) 0;
            return false;
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (!((Z) this.i.get(i3)).isInitialized()) {
                this.f464s = (byte) 0;
                return false;
            }
        }
        if ((this.c & 32) == 32 && !this.f456j.isInitialized()) {
            this.f464s = (byte) 0;
            return false;
        }
        for (int i4 = 0; i4 < this.f458l.size(); i4++) {
            if (!((U) this.f458l.get(i4)).isInitialized()) {
                this.f464s = (byte) 0;
                return false;
            }
        }
        if ((this.c & 128) == 128 && !this.f461o.isInitialized()) {
            this.f464s = (byte) 0;
            return false;
        }
        if (this.f3870a.e()) {
            this.f464s = (byte) 1;
            return true;
        }
        this.f464s = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return G.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        G gD = G.d();
        gD.e(this);
        return gD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 2) == 2) {
            c0606g.m(1, this.e);
        }
        if ((this.c & 4) == 4) {
            c0606g.m(2, this.f453f);
        }
        if ((this.c & 8) == 8) {
            c0606g.o(3, this.f454g);
        }
        for (int i = 0; i < this.i.size(); i++) {
            c0606g.o(4, (MessageLite) this.i.get(i));
        }
        if ((this.c & 32) == 32) {
            c0606g.o(5, this.f456j);
        }
        if ((this.c & 128) == 128) {
            c0606g.o(6, this.f461o);
        }
        if ((this.c & 256) == 256) {
            c0606g.m(7, this.f462p);
        }
        if ((this.c & 512) == 512) {
            c0606g.m(8, this.q);
        }
        if ((this.c & 16) == 16) {
            c0606g.m(9, this.f455h);
        }
        if ((this.c & 64) == 64) {
            c0606g.m(10, this.f457k);
        }
        if ((this.c & 1) == 1) {
            c0606g.m(11, this.d);
        }
        for (int i3 = 0; i3 < this.f458l.size(); i3++) {
            c0606g.o(12, (MessageLite) this.f458l.get(i3));
        }
        if (this.f459m.size() > 0) {
            c0606g.v(106);
            c0606g.v(this.f460n);
        }
        for (int i4 = 0; i4 < this.f459m.size(); i4++) {
            c0606g.n(((Integer) this.f459m.get(i4)).intValue());
        }
        for (int i5 = 0; i5 < this.f463r.size(); i5++) {
            c0606g.m(31, ((Integer) this.f463r.get(i5)).intValue());
        }
        hVar.q(19000, c0606g);
        c0606g.r(this.b);
    }

    public H() {
        this.f460n = -1;
        this.f464s = (byte) -1;
        this.f465t = -1;
        this.b = AbstractC0604e.f3860a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public H(C0605f c0605f, C0608i c0608i) {
        this.f460n = -1;
        this.f464s = (byte) -1;
        this.f465t = -1;
        i();
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        int i = 0;
        while (true) {
            ?? G5 = 256;
            if (!z6) {
                try {
                    try {
                        try {
                            int iN = c0605f.n();
                            T tK = null;
                            c0 c0Var = null;
                            T tK2 = null;
                            switch (iN) {
                                case 0:
                                    z6 = true;
                                    break;
                                case 8:
                                    this.c |= 2;
                                    this.e = c0605f.k();
                                    break;
                                case 16:
                                    this.c |= 4;
                                    this.f453f = c0605f.k();
                                    break;
                                case 26:
                                    if ((this.c & 8) == 8) {
                                        U u2 = this.f454g;
                                        u2.getClass();
                                        tK = U.k(u2);
                                    }
                                    U u6 = (U) c0605f.g(U.u, c0608i);
                                    this.f454g = u6;
                                    if (tK != null) {
                                        tK.e(u6);
                                        this.f454g = tK.c();
                                    }
                                    this.c |= 8;
                                    break;
                                case 34:
                                    int i3 = (i == true ? 1 : 0) & 32;
                                    i = i;
                                    if (i3 != 32) {
                                        this.i = new ArrayList();
                                        i = (i == true ? 1 : 0) | 32;
                                    }
                                    this.i.add(c0605f.g(Z.f528n, c0608i));
                                    break;
                                case 42:
                                    if ((this.c & 32) == 32) {
                                        U u7 = this.f456j;
                                        u7.getClass();
                                        tK2 = U.k(u7);
                                    }
                                    U u8 = (U) c0605f.g(U.u, c0608i);
                                    this.f456j = u8;
                                    if (tK2 != null) {
                                        tK2.e(u8);
                                        this.f456j = tK2.c();
                                    }
                                    this.c |= 32;
                                    break;
                                case 50:
                                    if ((this.c & 128) == 128) {
                                        d0 d0Var = this.f461o;
                                        d0Var.getClass();
                                        c0Var = new c0();
                                        U u9 = U.f492t;
                                        c0Var.f548g = u9;
                                        c0Var.i = u9;
                                        c0Var.d(d0Var);
                                    }
                                    d0 d0Var2 = (d0) c0605f.g(d0.f562m, c0608i);
                                    this.f461o = d0Var2;
                                    if (c0Var != null) {
                                        c0Var.d(d0Var2);
                                        this.f461o = c0Var.c();
                                    }
                                    this.c |= 128;
                                    break;
                                case 56:
                                    this.c |= 256;
                                    this.f462p = c0605f.k();
                                    break;
                                case 64:
                                    this.c |= 512;
                                    this.q = c0605f.k();
                                    break;
                                case 72:
                                    this.c |= 16;
                                    this.f455h = c0605f.k();
                                    break;
                                case 80:
                                    this.c |= 64;
                                    this.f457k = c0605f.k();
                                    break;
                                case 88:
                                    this.c |= 1;
                                    this.d = c0605f.k();
                                    break;
                                case 98:
                                    int i4 = (i == true ? 1 : 0) & 256;
                                    i = i;
                                    if (i4 != 256) {
                                        this.f458l = new ArrayList();
                                        i = (i == true ? 1 : 0) | 256;
                                    }
                                    this.f458l.add(c0605f.g(U.u, c0608i));
                                    break;
                                case 104:
                                    int i5 = (i == true ? 1 : 0) & 512;
                                    i = i;
                                    if (i5 != 512) {
                                        this.f459m = new ArrayList();
                                        i = (i == true ? 1 : 0) | 512;
                                    }
                                    this.f459m.add(Integer.valueOf(c0605f.k()));
                                    break;
                                case 106:
                                    int iD = c0605f.d(c0605f.k());
                                    int i6 = (i == true ? 1 : 0) & 512;
                                    i = i;
                                    if (i6 != 512) {
                                        i = i;
                                        if (c0605f.b() > 0) {
                                            this.f459m = new ArrayList();
                                            i = (i == true ? 1 : 0) | 512;
                                        }
                                    }
                                    while (c0605f.b() > 0) {
                                        this.f459m.add(Integer.valueOf(c0605f.k()));
                                    }
                                    c0605f.c(iD);
                                    break;
                                case KEYCODE_TV_INPUT_COMPOSITE_2_VALUE:
                                    int i7 = (i == true ? 1 : 0) & 8192;
                                    i = i;
                                    if (i7 != 8192) {
                                        this.f463r = new ArrayList();
                                        i = (i == true ? 1 : 0) | 8192;
                                    }
                                    this.f463r.add(Integer.valueOf(c0605f.k()));
                                    break;
                                case 250:
                                    int iD2 = c0605f.d(c0605f.k());
                                    int i8 = (i == true ? 1 : 0) & 8192;
                                    i = i;
                                    if (i8 != 8192) {
                                        i = i;
                                        if (c0605f.b() > 0) {
                                            this.f463r = new ArrayList();
                                            i = (i == true ? 1 : 0) | 8192;
                                        }
                                    }
                                    while (c0605f.b() > 0) {
                                        this.f463r.add(Integer.valueOf(c0605f.k()));
                                    }
                                    c0605f.c(iD2);
                                    break;
                                default:
                                    G5 = g(c0605f, c0606gJ, c0608i, iN);
                                    if (G5 == 0) {
                                        z6 = true;
                                    }
                                    break;
                            }
                        } catch (IOException e) {
                            kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e.getMessage());
                            rVar.f3874a = this;
                            throw rVar;
                        }
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e6) {
                        e6.f3874a = this;
                        throw e6;
                    }
                } catch (Throwable th) {
                    if (((i == true ? 1 : 0) & 32) == 32) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if (((i == true ? 1 : 0) & 256) == G5) {
                        this.f458l = Collections.unmodifiableList(this.f458l);
                    }
                    if (((i == true ? 1 : 0) & 512) == 512) {
                        this.f459m = Collections.unmodifiableList(this.f459m);
                    }
                    if (((i == true ? 1 : 0) & 8192) == 8192) {
                        this.f463r = Collections.unmodifiableList(this.f463r);
                    }
                    try {
                        c0606gJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = c0603d.c();
                        throw th2;
                    }
                    this.b = c0603d.c();
                    f();
                    throw th;
                }
            } else {
                if (((i == true ? 1 : 0) & 32) == 32) {
                    this.i = Collections.unmodifiableList(this.i);
                }
                if (((i == true ? 1 : 0) & 256) == 256) {
                    this.f458l = Collections.unmodifiableList(this.f458l);
                }
                if (((i == true ? 1 : 0) & 512) == 512) {
                    this.f459m = Collections.unmodifiableList(this.f459m);
                }
                if (((i == true ? 1 : 0) & 8192) == 8192) {
                    this.f463r = Collections.unmodifiableList(this.f463r);
                }
                try {
                    c0606gJ.i();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.b = c0603d.c();
                    throw th3;
                }
                this.b = c0603d.c();
                f();
                return;
            }
        }
    }
}
