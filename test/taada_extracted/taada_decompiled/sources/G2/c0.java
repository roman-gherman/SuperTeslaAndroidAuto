package G2;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameterOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends AbstractC0611l implements ProtoBuf$ValueParameterOrBuilder {
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public U f548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f549h;
    public U i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f550j;

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        d((d0) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        d0 d0VarC = c();
        if (d0VarC.isInitialized()) {
            return d0VarC;
        }
        throw new C0.x();
    }

    public final d0 c() {
        d0 d0Var = new d0(this);
        int i = this.d;
        int i3 = (i & 1) != 1 ? 0 : 1;
        d0Var.d = this.e;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        d0Var.e = this.f547f;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        d0Var.f563f = this.f548g;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        d0Var.f564g = this.f549h;
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        d0Var.f565h = this.i;
        if ((i & 32) == 32) {
            i3 |= 32;
        }
        d0Var.i = this.f550j;
        d0Var.c = i3;
        return d0Var;
    }

    public final Object clone() {
        c0 c0Var = new c0();
        U u = U.f492t;
        c0Var.f548g = u;
        c0Var.i = u;
        c0Var.d(c());
        return c0Var;
    }

    public final void d(d0 d0Var) {
        U u;
        U u2;
        if (d0Var == d0.f561l) {
            return;
        }
        int i = d0Var.c;
        if ((i & 1) == 1) {
            int i3 = d0Var.d;
            this.d = 1 | this.d;
            this.e = i3;
        }
        if ((i & 2) == 2) {
            int i4 = d0Var.e;
            this.d = 2 | this.d;
            this.f547f = i4;
        }
        if ((i & 4) == 4) {
            U u6 = d0Var.f563f;
            if ((this.d & 4) != 4 || (u2 = this.f548g) == U.f492t) {
                this.f548g = u6;
            } else {
                T tK = U.k(u2);
                tK.e(u6);
                this.f548g = tK.c();
            }
            this.d |= 4;
        }
        int i5 = d0Var.c;
        if ((i5 & 8) == 8) {
            int i6 = d0Var.f564g;
            this.d = 8 | this.d;
            this.f549h = i6;
        }
        if ((i5 & 16) == 16) {
            U u7 = d0Var.f565h;
            if ((this.d & 16) != 16 || (u = this.i) == U.f492t) {
                this.i = u7;
            } else {
                T tK2 = U.k(u);
                tK2.e(u7);
                this.i = tK2.c();
            }
            this.d |= 16;
        }
        if ((d0Var.c & 32) == 32) {
            int i7 = d0Var.i;
            this.d = 32 | this.d;
            this.f550j = i7;
        }
        b(d0Var);
        this.f3869a = this.f3869a.b(d0Var.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return d0.f561l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        int i = this.d;
        if ((i & 2) != 2) {
            return false;
        }
        if ((i & 4) != 4 || this.f548g.isInitialized()) {
            return ((this.d & 16) != 16 || this.i.isInitialized()) && this.b.e();
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
            G2.a r1 = G2.d0.f562m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.d0 r1 = new G2.d0     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.d(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.d0 r4 = (G2.d0) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.d(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.c0.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
