package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$FunctionOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0125z extends AbstractC0612m implements ProtoBuf$FunctionOrBuilder {
    public static final C0125z u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final C0101a f687v = new C0101a(9);
    public final AbstractC0604e b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public U f689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f690h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public U f691j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f692k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f693l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f694m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f695n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f696o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b0 f697p;
    public List q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C0115o f698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte f699s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f700t;

    static {
        C0125z c0125z = new C0125z();
        u = c0125z;
        c0125z.i();
    }

    public C0125z(C0124y c0124y) {
        super(c0124y);
        this.f695n = -1;
        this.f699s = (byte) -1;
        this.f700t = -1;
        this.b = c0124y.f3870a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f687v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f700t;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 2) == 2 ? C0606g.b(1, this.e) : 0;
        if ((this.c & 4) == 4) {
            iB += C0606g.b(2, this.f688f);
        }
        if ((this.c & 8) == 8) {
            iB += C0606g.d(3, this.f689g);
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            iB += C0606g.d(4, (MessageLite) this.i.get(i3));
        }
        if ((this.c & 32) == 32) {
            iB += C0606g.d(5, this.f691j);
        }
        for (int i4 = 0; i4 < this.f696o.size(); i4++) {
            iB += C0606g.d(6, (MessageLite) this.f696o.get(i4));
        }
        if ((this.c & 16) == 16) {
            iB += C0606g.b(7, this.f690h);
        }
        if ((this.c & 64) == 64) {
            iB += C0606g.b(8, this.f692k);
        }
        if ((this.c & 1) == 1) {
            iB += C0606g.b(9, this.d);
        }
        for (int i5 = 0; i5 < this.f693l.size(); i5++) {
            iB += C0606g.d(10, (MessageLite) this.f693l.get(i5));
        }
        int iC = 0;
        for (int i6 = 0; i6 < this.f694m.size(); i6++) {
            iC += C0606g.c(((Integer) this.f694m.get(i6)).intValue());
        }
        int iD = iB + iC;
        if (!this.f694m.isEmpty()) {
            iD = iD + 1 + C0606g.c(iC);
        }
        this.f695n = iC;
        if ((this.c & 128) == 128) {
            iD += C0606g.d(30, this.f697p);
        }
        int iC2 = 0;
        for (int i7 = 0; i7 < this.q.size(); i7++) {
            iC2 += C0606g.c(((Integer) this.q.get(i7)).intValue());
        }
        int size = (this.q.size() * 2) + iD + iC2;
        if ((this.c & 256) == 256) {
            size += C0606g.d(32, this.f698r);
        }
        int size2 = this.b.size() + c() + size;
        this.f700t = size2;
        return size2;
    }

    public final void i() {
        this.d = 6;
        this.e = 6;
        this.f688f = 0;
        U u2 = U.f492t;
        this.f689g = u2;
        this.f690h = 0;
        List list = Collections.EMPTY_LIST;
        this.i = list;
        this.f691j = u2;
        this.f692k = 0;
        this.f693l = list;
        this.f694m = list;
        this.f696o = list;
        this.f697p = b0.f536g;
        this.q = list;
        this.f698r = C0115o.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f699s;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        int i = this.c;
        if ((i & 4) != 4) {
            this.f699s = (byte) 0;
            return false;
        }
        if ((i & 8) == 8 && !this.f689g.isInitialized()) {
            this.f699s = (byte) 0;
            return false;
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (!((Z) this.i.get(i3)).isInitialized()) {
                this.f699s = (byte) 0;
                return false;
            }
        }
        if ((this.c & 32) == 32 && !this.f691j.isInitialized()) {
            this.f699s = (byte) 0;
            return false;
        }
        for (int i4 = 0; i4 < this.f693l.size(); i4++) {
            if (!((U) this.f693l.get(i4)).isInitialized()) {
                this.f699s = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < this.f696o.size(); i5++) {
            if (!((d0) this.f696o.get(i5)).isInitialized()) {
                this.f699s = (byte) 0;
                return false;
            }
        }
        if ((this.c & 128) == 128 && !this.f697p.isInitialized()) {
            this.f699s = (byte) 0;
            return false;
        }
        if ((this.c & 256) == 256 && !this.f698r.isInitialized()) {
            this.f699s = (byte) 0;
            return false;
        }
        if (this.f3871a.e()) {
            this.f699s = (byte) 1;
            return true;
        }
        this.f699s = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return C0124y.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0124y c0124yD = C0124y.d();
        c0124yD.e(this);
        return c0124yD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 2) == 2) {
            c0606g.m(1, this.e);
        }
        if ((this.c & 4) == 4) {
            c0606g.m(2, this.f688f);
        }
        if ((this.c & 8) == 8) {
            c0606g.o(3, this.f689g);
        }
        for (int i = 0; i < this.i.size(); i++) {
            c0606g.o(4, (MessageLite) this.i.get(i));
        }
        if ((this.c & 32) == 32) {
            c0606g.o(5, this.f691j);
        }
        for (int i3 = 0; i3 < this.f696o.size(); i3++) {
            c0606g.o(6, (MessageLite) this.f696o.get(i3));
        }
        if ((this.c & 16) == 16) {
            c0606g.m(7, this.f690h);
        }
        if ((this.c & 64) == 64) {
            c0606g.m(8, this.f692k);
        }
        if ((this.c & 1) == 1) {
            c0606g.m(9, this.d);
        }
        for (int i4 = 0; i4 < this.f693l.size(); i4++) {
            c0606g.o(10, (MessageLite) this.f693l.get(i4));
        }
        if (this.f694m.size() > 0) {
            c0606g.v(90);
            c0606g.v(this.f695n);
        }
        for (int i5 = 0; i5 < this.f694m.size(); i5++) {
            c0606g.n(((Integer) this.f694m.get(i5)).intValue());
        }
        if ((this.c & 128) == 128) {
            c0606g.o(30, this.f697p);
        }
        for (int i6 = 0; i6 < this.q.size(); i6++) {
            c0606g.m(31, ((Integer) this.q.get(i6)).intValue());
        }
        if ((this.c & 256) == 256) {
            c0606g.o(32, this.f698r);
        }
        hVar.q(19000, c0606g);
        c0606g.r(this.b);
    }

    public C0125z() {
        this.f695n = -1;
        this.f699s = (byte) -1;
        this.f700t = -1;
        this.b = AbstractC0604e.f3861a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public C0125z(C0605f c0605f, C0608i c0608i) {
        this.f695n = -1;
        this.f699s = (byte) -1;
        this.f700t = -1;
        i();
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        int i = 0;
        while (true) {
            ?? G5 = 1024;
            if (!z6) {
                try {
                    try {
                        int iN = c0605f.n();
                        T tK = null;
                        C0114n c0114n = null;
                        a0 a0VarC = null;
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
                                this.f688f = c0605f.k();
                                break;
                            case 26:
                                if ((this.c & 8) == 8) {
                                    U u2 = this.f689g;
                                    u2.getClass();
                                    tK = U.k(u2);
                                }
                                U u6 = (U) c0605f.g(U.u, c0608i);
                                this.f689g = u6;
                                if (tK != null) {
                                    tK.e(u6);
                                    this.f689g = tK.c();
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
                                    U u7 = this.f691j;
                                    u7.getClass();
                                    tK2 = U.k(u7);
                                }
                                U u8 = (U) c0605f.g(U.u, c0608i);
                                this.f691j = u8;
                                if (tK2 != null) {
                                    tK2.e(u8);
                                    this.f691j = tK2.c();
                                }
                                this.c |= 32;
                                break;
                            case 50:
                                int i4 = (i == true ? 1 : 0) & 1024;
                                i = i;
                                if (i4 != 1024) {
                                    this.f696o = new ArrayList();
                                    i = (i == true ? 1 : 0) | 1024;
                                }
                                this.f696o.add(c0605f.g(d0.f562m, c0608i));
                                break;
                            case 56:
                                this.c |= 16;
                                this.f690h = c0605f.k();
                                break;
                            case 64:
                                this.c |= 64;
                                this.f692k = c0605f.k();
                                break;
                            case 72:
                                this.c |= 1;
                                this.d = c0605f.k();
                                break;
                            case 82:
                                int i5 = (i == true ? 1 : 0) & 256;
                                i = i;
                                if (i5 != 256) {
                                    this.f693l = new ArrayList();
                                    i = (i == true ? 1 : 0) | 256;
                                }
                                this.f693l.add(c0605f.g(U.u, c0608i));
                                break;
                            case 88:
                                int i6 = (i == true ? 1 : 0) & 512;
                                i = i;
                                if (i6 != 512) {
                                    this.f694m = new ArrayList();
                                    i = (i == true ? 1 : 0) | 512;
                                }
                                this.f694m.add(Integer.valueOf(c0605f.k()));
                                break;
                            case 90:
                                int iD = c0605f.d(c0605f.k());
                                int i7 = (i == true ? 1 : 0) & 512;
                                i = i;
                                if (i7 != 512) {
                                    i = i;
                                    if (c0605f.b() > 0) {
                                        this.f694m = new ArrayList();
                                        i = (i == true ? 1 : 0) | 512;
                                    }
                                }
                                while (c0605f.b() > 0) {
                                    this.f694m.add(Integer.valueOf(c0605f.k()));
                                }
                                c0605f.c(iD);
                                break;
                            case KEYCODE_TV_ANTENNA_CABLE_VALUE:
                                if ((this.c & 128) == 128) {
                                    b0 b0Var = this.f697p;
                                    b0Var.getClass();
                                    a0VarC = b0.c(b0Var);
                                }
                                b0 b0Var2 = (b0) c0605f.g(b0.f537h, c0608i);
                                this.f697p = b0Var2;
                                if (a0VarC != null) {
                                    a0VarC.d(b0Var2);
                                    this.f697p = a0VarC.b();
                                }
                                this.c |= 128;
                                break;
                            case KEYCODE_TV_INPUT_COMPOSITE_2_VALUE:
                                int i8 = (i == true ? 1 : 0) & 4096;
                                i = i;
                                if (i8 != 4096) {
                                    this.q = new ArrayList();
                                    i = (i == true ? 1 : 0) | 4096;
                                }
                                this.q.add(Integer.valueOf(c0605f.k()));
                                break;
                            case 250:
                                int iD2 = c0605f.d(c0605f.k());
                                int i9 = (i == true ? 1 : 0) & 4096;
                                i = i;
                                if (i9 != 4096) {
                                    i = i;
                                    if (c0605f.b() > 0) {
                                        this.q = new ArrayList();
                                        i = (i == true ? 1 : 0) | 4096;
                                    }
                                }
                                while (c0605f.b() > 0) {
                                    this.q.add(Integer.valueOf(c0605f.k()));
                                }
                                c0605f.c(iD2);
                                break;
                            case KEYCODE_TV_TIMER_PROGRAMMING_VALUE:
                                if ((this.c & 256) == 256) {
                                    C0115o c0115o = this.f698r;
                                    c0115o.getClass();
                                    c0114n = new C0114n();
                                    c0114n.c = Collections.EMPTY_LIST;
                                    c0114n.c(c0115o);
                                }
                                C0115o c0115o2 = (C0115o) c0605f.g(C0115o.f651f, c0608i);
                                this.f698r = c0115o2;
                                if (c0114n != null) {
                                    c0114n.c(c0115o2);
                                    this.f698r = c0114n.b();
                                }
                                this.c |= 256;
                                break;
                            default:
                                G5 = g(c0605f, c0606gJ, c0608i, iN);
                                if (G5 == 0) {
                                    z6 = true;
                                }
                                break;
                        }
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                        e.f3875a = this;
                        throw e;
                    } catch (IOException e6) {
                        kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                        rVar.f3875a = this;
                        throw rVar;
                    }
                } catch (Throwable th) {
                    if (((i == true ? 1 : 0) & 32) == 32) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if (((i == true ? 1 : 0) & 1024) == G5) {
                        this.f696o = Collections.unmodifiableList(this.f696o);
                    }
                    if (((i == true ? 1 : 0) & 256) == 256) {
                        this.f693l = Collections.unmodifiableList(this.f693l);
                    }
                    if (((i == true ? 1 : 0) & 512) == 512) {
                        this.f694m = Collections.unmodifiableList(this.f694m);
                    }
                    if (((i == true ? 1 : 0) & 4096) == 4096) {
                        this.q = Collections.unmodifiableList(this.q);
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
                if (((i == true ? 1 : 0) & 1024) == 1024) {
                    this.f696o = Collections.unmodifiableList(this.f696o);
                }
                if (((i == true ? 1 : 0) & 256) == 256) {
                    this.f693l = Collections.unmodifiableList(this.f693l);
                }
                if (((i == true ? 1 : 0) & 512) == 512) {
                    this.f694m = Collections.unmodifiableList(this.f694m);
                }
                if (((i == true ? 1 : 0) & 4096) == 4096) {
                    this.q = Collections.unmodifiableList(this.q);
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
