package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class T extends AbstractC0611l implements ProtoBuf$TypeOrBuilder {
    public int d;
    public List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public U f483h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f486l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f487m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public U f488n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f489o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public U f490p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f491r;

    public static T d() {
        T t6 = new T();
        t6.e = Collections.EMPTY_LIST;
        U u = U.f492t;
        t6.f483h = u;
        t6.f488n = u;
        t6.f490p = u;
        return t6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((U) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        U uC = c();
        if (uC.isInitialized()) {
            return uC;
        }
        throw new C0.x();
    }

    public final U c() {
        U u = new U(this);
        int i = this.d;
        if ((i & 1) == 1) {
            this.e = Collections.unmodifiableList(this.e);
            this.d &= -2;
        }
        u.d = this.e;
        int i3 = (i & 2) != 2 ? 0 : 1;
        u.e = this.f481f;
        if ((i & 4) == 4) {
            i3 |= 2;
        }
        u.f493f = this.f482g;
        if ((i & 8) == 8) {
            i3 |= 4;
        }
        u.f494g = this.f483h;
        if ((i & 16) == 16) {
            i3 |= 8;
        }
        u.f495h = this.i;
        if ((i & 32) == 32) {
            i3 |= 16;
        }
        u.i = this.f484j;
        if ((i & 64) == 64) {
            i3 |= 32;
        }
        u.f496j = this.f485k;
        if ((i & 128) == 128) {
            i3 |= 64;
        }
        u.f497k = this.f486l;
        if ((i & 256) == 256) {
            i3 |= 128;
        }
        u.f498l = this.f487m;
        if ((i & 512) == 512) {
            i3 |= 256;
        }
        u.f499m = this.f488n;
        if ((i & 1024) == 1024) {
            i3 |= 512;
        }
        u.f500n = this.f489o;
        if ((i & 2048) == 2048) {
            i3 |= 1024;
        }
        u.f501o = this.f490p;
        if ((i & 4096) == 4096) {
            i3 |= 2048;
        }
        u.f502p = this.q;
        if ((i & 8192) == 8192) {
            i3 |= 4096;
        }
        u.q = this.f491r;
        u.c = i3;
        return u;
    }

    public final Object clone() {
        T tD = d();
        tD.e(c());
        return tD;
    }

    public final T e(U u) {
        U u2;
        U u6;
        U u7;
        U u8 = U.f492t;
        if (u == u8) {
            return this;
        }
        if (!u.d.isEmpty()) {
            if (this.e.isEmpty()) {
                this.e = u.d;
                this.d &= -2;
            } else {
                if ((this.d & 1) != 1) {
                    this.e = new ArrayList(this.e);
                    this.d |= 1;
                }
                this.e.addAll(u.d);
            }
        }
        int i = u.c;
        if ((i & 1) == 1) {
            boolean z6 = u.e;
            this.d |= 2;
            this.f481f = z6;
        }
        if ((i & 2) == 2) {
            int i3 = u.f493f;
            this.d |= 4;
            this.f482g = i3;
        }
        if ((i & 4) == 4) {
            U u9 = u.f494g;
            if ((this.d & 8) != 8 || (u7 = this.f483h) == u8) {
                this.f483h = u9;
            } else {
                T tK = U.k(u7);
                tK.e(u9);
                this.f483h = tK.c();
            }
            this.d |= 8;
        }
        if ((u.c & 8) == 8) {
            int i4 = u.f495h;
            this.d |= 16;
            this.i = i4;
        }
        if (u.i()) {
            int i5 = u.i;
            this.d |= 32;
            this.f484j = i5;
        }
        int i6 = u.c;
        if ((i6 & 32) == 32) {
            int i7 = u.f496j;
            this.d |= 64;
            this.f485k = i7;
        }
        if ((i6 & 64) == 64) {
            int i8 = u.f497k;
            this.d |= 128;
            this.f486l = i8;
        }
        if ((i6 & 128) == 128) {
            int i9 = u.f498l;
            this.d |= 256;
            this.f487m = i9;
        }
        if ((i6 & 256) == 256) {
            U u10 = u.f499m;
            if ((this.d & 512) != 512 || (u6 = this.f488n) == u8) {
                this.f488n = u10;
            } else {
                T tK2 = U.k(u6);
                tK2.e(u10);
                this.f488n = tK2.c();
            }
            this.d |= 512;
        }
        int i10 = u.c;
        if ((i10 & 512) == 512) {
            int i11 = u.f500n;
            this.d |= 1024;
            this.f489o = i11;
        }
        if ((i10 & 1024) == 1024) {
            U u11 = u.f501o;
            if ((this.d & 2048) != 2048 || (u2 = this.f490p) == u8) {
                this.f490p = u11;
            } else {
                T tK3 = U.k(u2);
                tK3.e(u11);
                this.f490p = tK3.c();
            }
            this.d |= 2048;
        }
        int i12 = u.c;
        if ((i12 & 2048) == 2048) {
            int i13 = u.f502p;
            this.d |= 4096;
            this.q = i13;
        }
        if ((i12 & 4096) == 4096) {
            int i14 = u.q;
            this.d |= 8192;
            this.f491r = i14;
        }
        b(u);
        this.f3870a = this.f3870a.b(u.b);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return U.f492t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        for (int i = 0; i < this.e.size(); i++) {
            if (!((S) this.e.get(i)).isInitialized()) {
                return false;
            }
        }
        if ((this.d & 8) == 8 && !this.f483h.isInitialized()) {
            return false;
        }
        if ((this.d & 512) != 512 || this.f488n.isInitialized()) {
            return ((this.d & 2048) != 2048 || this.f490p.isInitialized()) && this.b.e();
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
            G2.a r1 = G2.U.u     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.U r1 = new G2.U     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.U r4 = (G2.U) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.T.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
