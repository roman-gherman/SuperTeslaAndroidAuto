package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ClassOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0109i extends AbstractC0611l implements ProtoBuf$ClassOrBuilder {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public List f599A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public j0 f600B;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f603h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f606l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f607m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f608n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f609o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f610p;
    public List q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f611r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f612s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f613t;
    public U u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f614v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List f615w;
    public List x;
    public List y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b0 f616z;

    public static C0109i d() {
        C0109i c0109i = new C0109i();
        c0109i.e = 6;
        List list = Collections.EMPTY_LIST;
        c0109i.f603h = list;
        c0109i.i = list;
        c0109i.f604j = list;
        c0109i.f605k = list;
        c0109i.f606l = list;
        c0109i.f607m = list;
        c0109i.f608n = list;
        c0109i.f609o = list;
        c0109i.f610p = list;
        c0109i.q = list;
        c0109i.f611r = list;
        c0109i.f612s = list;
        c0109i.u = U.f492t;
        c0109i.f615w = list;
        c0109i.x = list;
        c0109i.y = list;
        c0109i.f616z = b0.f536g;
        c0109i.f599A = list;
        c0109i.f600B = j0.e;
        return c0109i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((C0111k) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0111k c0111kC = c();
        if (c0111kC.isInitialized()) {
            return c0111kC;
        }
        throw new C0.x();
    }

    public final C0111k c() {
        C0111k c0111k = new C0111k(this);
        int i = this.d;
        int i3 = (i & 1) != 1 ? 0 : 1;
        c0111k.d = this.e;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        c0111k.e = this.f601f;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        c0111k.f628f = this.f602g;
        if ((i & 8) == 8) {
            this.f603h = Collections.unmodifiableList(this.f603h);
            this.d &= -9;
        }
        c0111k.f629g = this.f603h;
        if ((this.d & 16) == 16) {
            this.i = Collections.unmodifiableList(this.i);
            this.d &= -17;
        }
        c0111k.f630h = this.i;
        if ((this.d & 32) == 32) {
            this.f604j = Collections.unmodifiableList(this.f604j);
            this.d &= -33;
        }
        c0111k.i = this.f604j;
        if ((this.d & 64) == 64) {
            this.f605k = Collections.unmodifiableList(this.f605k);
            this.d &= -65;
        }
        c0111k.f632k = this.f605k;
        if ((this.d & 128) == 128) {
            this.f606l = Collections.unmodifiableList(this.f606l);
            this.d &= -129;
        }
        c0111k.f634m = this.f606l;
        if ((this.d & 256) == 256) {
            this.f607m = Collections.unmodifiableList(this.f607m);
            this.d &= -257;
        }
        c0111k.f635n = this.f607m;
        if ((this.d & 512) == 512) {
            this.f608n = Collections.unmodifiableList(this.f608n);
            this.d &= -513;
        }
        c0111k.f637p = this.f608n;
        if ((this.d & 1024) == 1024) {
            this.f609o = Collections.unmodifiableList(this.f609o);
            this.d &= -1025;
        }
        c0111k.q = this.f609o;
        if ((this.d & 2048) == 2048) {
            this.f610p = Collections.unmodifiableList(this.f610p);
            this.d &= -2049;
        }
        c0111k.f638r = this.f610p;
        if ((this.d & 4096) == 4096) {
            this.q = Collections.unmodifiableList(this.q);
            this.d &= -4097;
        }
        c0111k.f639s = this.q;
        if ((this.d & 8192) == 8192) {
            this.f611r = Collections.unmodifiableList(this.f611r);
            this.d &= -8193;
        }
        c0111k.f640t = this.f611r;
        if ((this.d & 16384) == 16384) {
            this.f612s = Collections.unmodifiableList(this.f612s);
            this.d &= -16385;
        }
        c0111k.u = this.f612s;
        if ((i & 32768) == 32768) {
            i3 |= 8;
        }
        c0111k.f642w = this.f613t;
        if ((i & 65536) == 65536) {
            i3 |= 16;
        }
        c0111k.x = this.u;
        if ((i & 131072) == 131072) {
            i3 |= 32;
        }
        c0111k.y = this.f614v;
        if ((this.d & 262144) == 262144) {
            this.f615w = Collections.unmodifiableList(this.f615w);
            this.d &= -262145;
        }
        c0111k.f643z = this.f615w;
        if ((this.d & 524288) == 524288) {
            this.x = Collections.unmodifiableList(this.x);
            this.d &= -524289;
        }
        c0111k.f624B = this.x;
        if ((this.d & 1048576) == 1048576) {
            this.y = Collections.unmodifiableList(this.y);
            this.d &= -1048577;
        }
        c0111k.C = this.y;
        if ((i & 2097152) == 2097152) {
            i3 |= 64;
        }
        c0111k.E = this.f616z;
        if ((this.d & 4194304) == 4194304) {
            this.f599A = Collections.unmodifiableList(this.f599A);
            this.d &= -4194305;
        }
        c0111k.f626F = this.f599A;
        if ((i & 8388608) == 8388608) {
            i3 |= 128;
        }
        c0111k.f627G = this.f600B;
        c0111k.c = i3;
        return c0111k;
    }

    public final Object clone() {
        C0109i c0109iD = d();
        c0109iD.e(c());
        return c0109iD;
    }

    public final void e(C0111k c0111k) {
        j0 j0Var;
        b0 b0Var;
        U u;
        if (c0111k == C0111k.J) {
            return;
        }
        int i = c0111k.c;
        if ((i & 1) == 1) {
            int i3 = c0111k.d;
            this.d = 1 | this.d;
            this.e = i3;
        }
        if ((i & 2) == 2) {
            int i4 = c0111k.e;
            this.d = 2 | this.d;
            this.f601f = i4;
        }
        if ((i & 4) == 4) {
            int i5 = c0111k.f628f;
            this.d = 4 | this.d;
            this.f602g = i5;
        }
        if (!c0111k.f629g.isEmpty()) {
            if (this.f603h.isEmpty()) {
                this.f603h = c0111k.f629g;
                this.d &= -9;
            } else {
                if ((this.d & 8) != 8) {
                    this.f603h = new ArrayList(this.f603h);
                    this.d |= 8;
                }
                this.f603h.addAll(c0111k.f629g);
            }
        }
        if (!c0111k.f630h.isEmpty()) {
            if (this.i.isEmpty()) {
                this.i = c0111k.f630h;
                this.d &= -17;
            } else {
                if ((this.d & 16) != 16) {
                    this.i = new ArrayList(this.i);
                    this.d |= 16;
                }
                this.i.addAll(c0111k.f630h);
            }
        }
        if (!c0111k.i.isEmpty()) {
            if (this.f604j.isEmpty()) {
                this.f604j = c0111k.i;
                this.d &= -33;
            } else {
                if ((this.d & 32) != 32) {
                    this.f604j = new ArrayList(this.f604j);
                    this.d |= 32;
                }
                this.f604j.addAll(c0111k.i);
            }
        }
        if (!c0111k.f632k.isEmpty()) {
            if (this.f605k.isEmpty()) {
                this.f605k = c0111k.f632k;
                this.d &= -65;
            } else {
                if ((this.d & 64) != 64) {
                    this.f605k = new ArrayList(this.f605k);
                    this.d |= 64;
                }
                this.f605k.addAll(c0111k.f632k);
            }
        }
        if (!c0111k.f634m.isEmpty()) {
            if (this.f606l.isEmpty()) {
                this.f606l = c0111k.f634m;
                this.d &= -129;
            } else {
                if ((this.d & 128) != 128) {
                    this.f606l = new ArrayList(this.f606l);
                    this.d |= 128;
                }
                this.f606l.addAll(c0111k.f634m);
            }
        }
        if (!c0111k.f635n.isEmpty()) {
            if (this.f607m.isEmpty()) {
                this.f607m = c0111k.f635n;
                this.d &= -257;
            } else {
                if ((this.d & 256) != 256) {
                    this.f607m = new ArrayList(this.f607m);
                    this.d |= 256;
                }
                this.f607m.addAll(c0111k.f635n);
            }
        }
        if (!c0111k.f637p.isEmpty()) {
            if (this.f608n.isEmpty()) {
                this.f608n = c0111k.f637p;
                this.d &= -513;
            } else {
                if ((this.d & 512) != 512) {
                    this.f608n = new ArrayList(this.f608n);
                    this.d |= 512;
                }
                this.f608n.addAll(c0111k.f637p);
            }
        }
        if (!c0111k.q.isEmpty()) {
            if (this.f609o.isEmpty()) {
                this.f609o = c0111k.q;
                this.d &= -1025;
            } else {
                if ((this.d & 1024) != 1024) {
                    this.f609o = new ArrayList(this.f609o);
                    this.d |= 1024;
                }
                this.f609o.addAll(c0111k.q);
            }
        }
        if (!c0111k.f638r.isEmpty()) {
            if (this.f610p.isEmpty()) {
                this.f610p = c0111k.f638r;
                this.d &= -2049;
            } else {
                if ((this.d & 2048) != 2048) {
                    this.f610p = new ArrayList(this.f610p);
                    this.d |= 2048;
                }
                this.f610p.addAll(c0111k.f638r);
            }
        }
        if (!c0111k.f639s.isEmpty()) {
            if (this.q.isEmpty()) {
                this.q = c0111k.f639s;
                this.d &= -4097;
            } else {
                if ((this.d & 4096) != 4096) {
                    this.q = new ArrayList(this.q);
                    this.d |= 4096;
                }
                this.q.addAll(c0111k.f639s);
            }
        }
        if (!c0111k.f640t.isEmpty()) {
            if (this.f611r.isEmpty()) {
                this.f611r = c0111k.f640t;
                this.d &= -8193;
            } else {
                if ((this.d & 8192) != 8192) {
                    this.f611r = new ArrayList(this.f611r);
                    this.d |= 8192;
                }
                this.f611r.addAll(c0111k.f640t);
            }
        }
        if (!c0111k.u.isEmpty()) {
            if (this.f612s.isEmpty()) {
                this.f612s = c0111k.u;
                this.d &= -16385;
            } else {
                if ((this.d & 16384) != 16384) {
                    this.f612s = new ArrayList(this.f612s);
                    this.d |= 16384;
                }
                this.f612s.addAll(c0111k.u);
            }
        }
        int i6 = c0111k.c;
        if ((i6 & 8) == 8) {
            int i7 = c0111k.f642w;
            this.d |= 32768;
            this.f613t = i7;
        }
        if ((i6 & 16) == 16) {
            U u2 = c0111k.x;
            if ((this.d & 65536) != 65536 || (u = this.u) == U.f492t) {
                this.u = u2;
            } else {
                T tK = U.k(u);
                tK.e(u2);
                this.u = tK.c();
            }
            this.d |= 65536;
        }
        if ((c0111k.c & 32) == 32) {
            int i8 = c0111k.y;
            this.d |= 131072;
            this.f614v = i8;
        }
        if (!c0111k.f643z.isEmpty()) {
            if (this.f615w.isEmpty()) {
                this.f615w = c0111k.f643z;
                this.d &= -262145;
            } else {
                if ((this.d & 262144) != 262144) {
                    this.f615w = new ArrayList(this.f615w);
                    this.d |= 262144;
                }
                this.f615w.addAll(c0111k.f643z);
            }
        }
        if (!c0111k.f624B.isEmpty()) {
            if (this.x.isEmpty()) {
                this.x = c0111k.f624B;
                this.d &= -524289;
            } else {
                if ((this.d & 524288) != 524288) {
                    this.x = new ArrayList(this.x);
                    this.d |= 524288;
                }
                this.x.addAll(c0111k.f624B);
            }
        }
        if (!c0111k.C.isEmpty()) {
            if (this.y.isEmpty()) {
                this.y = c0111k.C;
                this.d &= -1048577;
            } else {
                if ((this.d & 1048576) != 1048576) {
                    this.y = new ArrayList(this.y);
                    this.d |= 1048576;
                }
                this.y.addAll(c0111k.C);
            }
        }
        if ((c0111k.c & 64) == 64) {
            b0 b0Var2 = c0111k.E;
            if ((this.d & 2097152) != 2097152 || (b0Var = this.f616z) == b0.f536g) {
                this.f616z = b0Var2;
            } else {
                a0 a0VarC = b0.c(b0Var);
                a0VarC.d(b0Var2);
                this.f616z = a0VarC.b();
            }
            this.d |= 2097152;
        }
        if (!c0111k.f626F.isEmpty()) {
            if (this.f599A.isEmpty()) {
                this.f599A = c0111k.f626F;
                this.d &= -4194305;
            } else {
                if ((this.d & 4194304) != 4194304) {
                    this.f599A = new ArrayList(this.f599A);
                    this.d |= 4194304;
                }
                this.f599A.addAll(c0111k.f626F);
            }
        }
        if ((c0111k.c & 128) == 128) {
            j0 j0Var2 = c0111k.f627G;
            if ((this.d & 8388608) != 8388608 || (j0Var = this.f600B) == j0.e) {
                this.f600B = j0Var2;
            } else {
                i0 i0Var = new i0();
                i0Var.c = Collections.EMPTY_LIST;
                i0Var.c(j0Var);
                i0Var.c(j0Var2);
                this.f600B = i0Var.b();
            }
            this.d |= 8388608;
        }
        b(c0111k);
        this.f3869a = this.f3869a.b(c0111k.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0111k.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if ((this.d & 2) != 2) {
            return false;
        }
        for (int i = 0; i < this.f603h.size(); i++) {
            if (!((Z) this.f603h.get(i)).isInitialized()) {
                return false;
            }
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (!((U) this.i.get(i3)).isInitialized()) {
                return false;
            }
        }
        for (int i4 = 0; i4 < this.f606l.size(); i4++) {
            if (!((U) this.f606l.get(i4)).isInitialized()) {
                return false;
            }
        }
        for (int i5 = 0; i5 < this.f608n.size(); i5++) {
            if (!((C0113m) this.f608n.get(i5)).isInitialized()) {
                return false;
            }
        }
        for (int i6 = 0; i6 < this.f609o.size(); i6++) {
            if (!((C0125z) this.f609o.get(i6)).isInitialized()) {
                return false;
            }
        }
        for (int i7 = 0; i7 < this.f610p.size(); i7++) {
            if (!((H) this.f610p.get(i7)).isInitialized()) {
                return false;
            }
        }
        for (int i8 = 0; i8 < this.q.size(); i8++) {
            if (!((W) this.q.get(i8)).isInitialized()) {
                return false;
            }
        }
        for (int i9 = 0; i9 < this.f611r.size(); i9++) {
            if (!((C0120u) this.f611r.get(i9)).isInitialized()) {
                return false;
            }
        }
        if ((this.d & 65536) == 65536 && !this.u.isInitialized()) {
            return false;
        }
        for (int i10 = 0; i10 < this.x.size(); i10++) {
            if (!((U) this.x.get(i10)).isInitialized()) {
                return false;
            }
        }
        return ((this.d & 2097152) != 2097152 || this.f616z.isInitialized()) && this.b.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.C0605f r3, kotlin.reflect.jvm.internal.impl.protobuf.C0608i r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            G2.a r1 = G2.C0111k.f622K     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.k r1 = new G2.k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.k r4 = (G2.C0111k) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.e(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.C0109i.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
