package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$FunctionOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0124y extends AbstractC0611l implements ProtoBuf$FunctionOrBuilder {
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public U f678h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public U f680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f683n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f684o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b0 f685p;
    public List q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C0115o f686r;

    public static C0124y d() {
        C0124y c0124y = new C0124y();
        c0124y.e = 6;
        c0124y.f676f = 6;
        U u = U.f492t;
        c0124y.f678h = u;
        List list = Collections.EMPTY_LIST;
        c0124y.f679j = list;
        c0124y.f680k = u;
        c0124y.f682m = list;
        c0124y.f683n = list;
        c0124y.f684o = list;
        c0124y.f685p = b0.f536g;
        c0124y.q = list;
        c0124y.f686r = C0115o.e;
        return c0124y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((C0125z) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0125z c0125zC = c();
        if (c0125zC.isInitialized()) {
            return c0125zC;
        }
        throw new C0.x();
    }

    public final C0125z c() {
        C0125z c0125z = new C0125z(this);
        int i = this.d;
        int i3 = (i & 1) != 1 ? 0 : 1;
        c0125z.d = this.e;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        c0125z.e = this.f676f;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        c0125z.f688f = this.f677g;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        c0125z.f689g = this.f678h;
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        c0125z.f690h = this.i;
        if ((i & 32) == 32) {
            this.f679j = Collections.unmodifiableList(this.f679j);
            this.d &= -33;
        }
        c0125z.i = this.f679j;
        if ((i & 64) == 64) {
            i3 |= 32;
        }
        c0125z.f691j = this.f680k;
        if ((i & 128) == 128) {
            i3 |= 64;
        }
        c0125z.f692k = this.f681l;
        if ((this.d & 256) == 256) {
            this.f682m = Collections.unmodifiableList(this.f682m);
            this.d &= -257;
        }
        c0125z.f693l = this.f682m;
        if ((this.d & 512) == 512) {
            this.f683n = Collections.unmodifiableList(this.f683n);
            this.d &= -513;
        }
        c0125z.f694m = this.f683n;
        if ((this.d & 1024) == 1024) {
            this.f684o = Collections.unmodifiableList(this.f684o);
            this.d &= -1025;
        }
        c0125z.f696o = this.f684o;
        if ((i & 2048) == 2048) {
            i3 |= 128;
        }
        c0125z.f697p = this.f685p;
        if ((this.d & 4096) == 4096) {
            this.q = Collections.unmodifiableList(this.q);
            this.d &= -4097;
        }
        c0125z.q = this.q;
        if ((i & 8192) == 8192) {
            i3 |= 256;
        }
        c0125z.f698r = this.f686r;
        c0125z.c = i3;
        return c0125z;
    }

    public final Object clone() {
        C0124y c0124yD = d();
        c0124yD.e(c());
        return c0124yD;
    }

    public final void e(C0125z c0125z) {
        C0115o c0115o;
        b0 b0Var;
        U u;
        U u2;
        if (c0125z == C0125z.u) {
            return;
        }
        int i = c0125z.c;
        if ((i & 1) == 1) {
            int i3 = c0125z.d;
            this.d = 1 | this.d;
            this.e = i3;
        }
        if ((i & 2) == 2) {
            int i4 = c0125z.e;
            this.d = 2 | this.d;
            this.f676f = i4;
        }
        if ((i & 4) == 4) {
            int i5 = c0125z.f688f;
            this.d = 4 | this.d;
            this.f677g = i5;
        }
        if ((i & 8) == 8) {
            U u6 = c0125z.f689g;
            if ((this.d & 8) != 8 || (u2 = this.f678h) == U.f492t) {
                this.f678h = u6;
            } else {
                T tK = U.k(u2);
                tK.e(u6);
                this.f678h = tK.c();
            }
            this.d |= 8;
        }
        if ((c0125z.c & 16) == 16) {
            int i6 = c0125z.f690h;
            this.d = 16 | this.d;
            this.i = i6;
        }
        if (!c0125z.i.isEmpty()) {
            if (this.f679j.isEmpty()) {
                this.f679j = c0125z.i;
                this.d &= -33;
            } else {
                if ((this.d & 32) != 32) {
                    this.f679j = new ArrayList(this.f679j);
                    this.d |= 32;
                }
                this.f679j.addAll(c0125z.i);
            }
        }
        if ((c0125z.c & 32) == 32) {
            U u7 = c0125z.f691j;
            if ((this.d & 64) != 64 || (u = this.f680k) == U.f492t) {
                this.f680k = u7;
            } else {
                T tK2 = U.k(u);
                tK2.e(u7);
                this.f680k = tK2.c();
            }
            this.d |= 64;
        }
        if ((c0125z.c & 64) == 64) {
            int i7 = c0125z.f692k;
            this.d |= 128;
            this.f681l = i7;
        }
        if (!c0125z.f693l.isEmpty()) {
            if (this.f682m.isEmpty()) {
                this.f682m = c0125z.f693l;
                this.d &= -257;
            } else {
                if ((this.d & 256) != 256) {
                    this.f682m = new ArrayList(this.f682m);
                    this.d |= 256;
                }
                this.f682m.addAll(c0125z.f693l);
            }
        }
        if (!c0125z.f694m.isEmpty()) {
            if (this.f683n.isEmpty()) {
                this.f683n = c0125z.f694m;
                this.d &= -513;
            } else {
                if ((this.d & 512) != 512) {
                    this.f683n = new ArrayList(this.f683n);
                    this.d |= 512;
                }
                this.f683n.addAll(c0125z.f694m);
            }
        }
        if (!c0125z.f696o.isEmpty()) {
            if (this.f684o.isEmpty()) {
                this.f684o = c0125z.f696o;
                this.d &= -1025;
            } else {
                if ((this.d & 1024) != 1024) {
                    this.f684o = new ArrayList(this.f684o);
                    this.d |= 1024;
                }
                this.f684o.addAll(c0125z.f696o);
            }
        }
        if ((c0125z.c & 128) == 128) {
            b0 b0Var2 = c0125z.f697p;
            if ((this.d & 2048) != 2048 || (b0Var = this.f685p) == b0.f536g) {
                this.f685p = b0Var2;
            } else {
                a0 a0VarC = b0.c(b0Var);
                a0VarC.d(b0Var2);
                this.f685p = a0VarC.b();
            }
            this.d |= 2048;
        }
        if (!c0125z.q.isEmpty()) {
            if (this.q.isEmpty()) {
                this.q = c0125z.q;
                this.d &= -4097;
            } else {
                if ((this.d & 4096) != 4096) {
                    this.q = new ArrayList(this.q);
                    this.d |= 4096;
                }
                this.q.addAll(c0125z.q);
            }
        }
        if ((c0125z.c & 256) == 256) {
            C0115o c0115o2 = c0125z.f698r;
            if ((this.d & 8192) != 8192 || (c0115o = this.f686r) == C0115o.e) {
                this.f686r = c0115o2;
            } else {
                C0114n c0114n = new C0114n();
                c0114n.c = Collections.EMPTY_LIST;
                c0114n.c(c0115o);
                c0114n.c(c0115o2);
                this.f686r = c0114n.b();
            }
            this.d |= 8192;
        }
        b(c0125z);
        this.f3869a = this.f3869a.b(c0125z.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0125z.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        int i = this.d;
        if ((i & 4) != 4) {
            return false;
        }
        if ((i & 8) == 8 && !this.f678h.isInitialized()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f679j.size(); i3++) {
            if (!((Z) this.f679j.get(i3)).isInitialized()) {
                return false;
            }
        }
        if ((this.d & 64) == 64 && !this.f680k.isInitialized()) {
            return false;
        }
        for (int i4 = 0; i4 < this.f682m.size(); i4++) {
            if (!((U) this.f682m.get(i4)).isInitialized()) {
                return false;
            }
        }
        for (int i5 = 0; i5 < this.f684o.size(); i5++) {
            if (!((d0) this.f684o.get(i5)).isInitialized()) {
                return false;
            }
        }
        if ((this.d & 2048) != 2048 || this.f685p.isInitialized()) {
            return ((this.d & 8192) != 8192 || this.f686r.isInitialized()) && this.b.e();
        }
        return false;
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
            G2.a r1 = G2.C0125z.f687v     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.z r1 = new G2.z     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.z r4 = (G2.C0125z) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.C0124y.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
