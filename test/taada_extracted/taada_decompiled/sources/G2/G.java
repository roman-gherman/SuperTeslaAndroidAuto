package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PropertyOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends AbstractC0611l implements ProtoBuf$PropertyOrBuilder {
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public U f443h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public U f445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d0 f449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f450p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f451r;

    public static G d() {
        G g6 = new G();
        g6.e = 518;
        g6.f441f = 2054;
        U u = U.f492t;
        g6.f443h = u;
        List list = Collections.EMPTY_LIST;
        g6.f444j = list;
        g6.f445k = u;
        g6.f447m = list;
        g6.f448n = list;
        g6.f449o = d0.f561l;
        g6.f451r = list;
        return g6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((H) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        H hC = c();
        if (hC.isInitialized()) {
            return hC;
        }
        throw new C0.x();
    }

    public final H c() {
        H h3 = new H(this);
        int i = this.d;
        int i3 = (i & 1) != 1 ? 0 : 1;
        h3.d = this.e;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        h3.e = this.f441f;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        h3.f453f = this.f442g;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        h3.f454g = this.f443h;
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        h3.f455h = this.i;
        if ((i & 32) == 32) {
            this.f444j = Collections.unmodifiableList(this.f444j);
            this.d &= -33;
        }
        h3.i = this.f444j;
        if ((i & 64) == 64) {
            i3 |= 32;
        }
        h3.f456j = this.f445k;
        if ((i & 128) == 128) {
            i3 |= 64;
        }
        h3.f457k = this.f446l;
        if ((this.d & 256) == 256) {
            this.f447m = Collections.unmodifiableList(this.f447m);
            this.d &= -257;
        }
        h3.f458l = this.f447m;
        if ((this.d & 512) == 512) {
            this.f448n = Collections.unmodifiableList(this.f448n);
            this.d &= -513;
        }
        h3.f459m = this.f448n;
        if ((i & 1024) == 1024) {
            i3 |= 128;
        }
        h3.f461o = this.f449o;
        if ((i & 2048) == 2048) {
            i3 |= 256;
        }
        h3.f462p = this.f450p;
        if ((i & 4096) == 4096) {
            i3 |= 512;
        }
        h3.q = this.q;
        if ((this.d & 8192) == 8192) {
            this.f451r = Collections.unmodifiableList(this.f451r);
            this.d &= -8193;
        }
        h3.f463r = this.f451r;
        h3.c = i3;
        return h3;
    }

    public final Object clone() {
        G gD = d();
        gD.e(c());
        return gD;
    }

    public final void e(H h3) {
        d0 d0Var;
        U u;
        U u2;
        if (h3 == H.u) {
            return;
        }
        int i = h3.c;
        if ((i & 1) == 1) {
            int i3 = h3.d;
            this.d = 1 | this.d;
            this.e = i3;
        }
        if ((i & 2) == 2) {
            int i4 = h3.e;
            this.d = 2 | this.d;
            this.f441f = i4;
        }
        if ((i & 4) == 4) {
            int i5 = h3.f453f;
            this.d = 4 | this.d;
            this.f442g = i5;
        }
        if ((i & 8) == 8) {
            U u6 = h3.f454g;
            if ((this.d & 8) != 8 || (u2 = this.f443h) == U.f492t) {
                this.f443h = u6;
            } else {
                T tK = U.k(u2);
                tK.e(u6);
                this.f443h = tK.c();
            }
            this.d |= 8;
        }
        if ((h3.c & 16) == 16) {
            int i6 = h3.f455h;
            this.d = 16 | this.d;
            this.i = i6;
        }
        if (!h3.i.isEmpty()) {
            if (this.f444j.isEmpty()) {
                this.f444j = h3.i;
                this.d &= -33;
            } else {
                if ((this.d & 32) != 32) {
                    this.f444j = new ArrayList(this.f444j);
                    this.d |= 32;
                }
                this.f444j.addAll(h3.i);
            }
        }
        if ((h3.c & 32) == 32) {
            U u7 = h3.f456j;
            if ((this.d & 64) != 64 || (u = this.f445k) == U.f492t) {
                this.f445k = u7;
            } else {
                T tK2 = U.k(u);
                tK2.e(u7);
                this.f445k = tK2.c();
            }
            this.d |= 64;
        }
        if ((h3.c & 64) == 64) {
            int i7 = h3.f457k;
            this.d |= 128;
            this.f446l = i7;
        }
        if (!h3.f458l.isEmpty()) {
            if (this.f447m.isEmpty()) {
                this.f447m = h3.f458l;
                this.d &= -257;
            } else {
                if ((this.d & 256) != 256) {
                    this.f447m = new ArrayList(this.f447m);
                    this.d |= 256;
                }
                this.f447m.addAll(h3.f458l);
            }
        }
        if (!h3.f459m.isEmpty()) {
            if (this.f448n.isEmpty()) {
                this.f448n = h3.f459m;
                this.d &= -513;
            } else {
                if ((this.d & 512) != 512) {
                    this.f448n = new ArrayList(this.f448n);
                    this.d |= 512;
                }
                this.f448n.addAll(h3.f459m);
            }
        }
        if ((h3.c & 128) == 128) {
            d0 d0Var2 = h3.f461o;
            if ((this.d & 1024) != 1024 || (d0Var = this.f449o) == d0.f561l) {
                this.f449o = d0Var2;
            } else {
                c0 c0Var = new c0();
                U u8 = U.f492t;
                c0Var.f548g = u8;
                c0Var.i = u8;
                c0Var.d(d0Var);
                c0Var.d(d0Var2);
                this.f449o = c0Var.c();
            }
            this.d |= 1024;
        }
        int i8 = h3.c;
        if ((i8 & 256) == 256) {
            int i9 = h3.f462p;
            this.d |= 2048;
            this.f450p = i9;
        }
        if ((i8 & 512) == 512) {
            int i10 = h3.q;
            this.d |= 4096;
            this.q = i10;
        }
        if (!h3.f463r.isEmpty()) {
            if (this.f451r.isEmpty()) {
                this.f451r = h3.f463r;
                this.d &= -8193;
            } else {
                if ((this.d & 8192) != 8192) {
                    this.f451r = new ArrayList(this.f451r);
                    this.d |= 8192;
                }
                this.f451r.addAll(h3.f463r);
            }
        }
        b(h3);
        this.f3869a = this.f3869a.b(h3.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return H.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        int i = this.d;
        if ((i & 4) != 4) {
            return false;
        }
        if ((i & 8) == 8 && !this.f443h.isInitialized()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f444j.size(); i3++) {
            if (!((Z) this.f444j.get(i3)).isInitialized()) {
                return false;
            }
        }
        if ((this.d & 64) == 64 && !this.f445k.isInitialized()) {
            return false;
        }
        for (int i4 = 0; i4 < this.f447m.size(); i4++) {
            if (!((U) this.f447m.get(i4)).isInitialized()) {
                return false;
            }
        }
        return ((this.d & 1024) != 1024 || this.f449o.isInitialized()) && this.b.e();
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
            G2.a r1 = G2.H.f452v     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.H r1 = new G2.H     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.H r4 = (G2.H) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.G.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
