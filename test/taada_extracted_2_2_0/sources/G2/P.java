package G2;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$ArgumentOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends AbstractC0610k implements ProtoBuf$Type$ArgumentOrBuilder {
    public int b;
    public Q c;
    public U d;
    public int e;

    public static P c() {
        P p5 = new P();
        p5.c = Q.INV;
        p5.d = U.f492t;
        return p5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        d((S) pVar);
        return this;
    }

    public final S b() {
        S s3 = new S(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        s3.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        s3.d = this.d;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        s3.e = this.e;
        s3.b = i3;
        return s3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        S sB = b();
        if (sB.isInitialized()) {
            return sB;
        }
        throw new C0.x();
    }

    public final Object clone() {
        P pC = c();
        pC.d(b());
        return pC;
    }

    public final void d(S s3) {
        U u;
        if (s3 == S.f477h) {
            return;
        }
        if ((s3.b & 1) == 1) {
            Q q = s3.c;
            q.getClass();
            this.b = 1 | this.b;
            this.c = q;
        }
        if ((s3.b & 2) == 2) {
            U u2 = s3.d;
            if ((this.b & 2) != 2 || (u = this.d) == U.f492t) {
                this.d = u2;
            } else {
                T tK = U.k(u);
                tK.e(u2);
                this.d = tK.c();
            }
            this.b |= 2;
        }
        if ((s3.b & 4) == 4) {
            int i = s3.e;
            this.b = 4 | this.b;
            this.e = i;
        }
        this.f3870a = this.f3870a.b(s3.f478a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return S.f477h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return (this.b & 2) != 2 || this.d.isInitialized();
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
            G2.a r1 = G2.S.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.S r1 = new G2.S     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.d(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.S r4 = (G2.S) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.P.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
