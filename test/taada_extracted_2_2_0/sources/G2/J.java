package G2;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedNameOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends AbstractC0610k implements ProtoBuf$QualifiedNameTable$QualifiedNameOrBuilder {
    public int b;
    public int c;
    public int d;
    public K e;

    public static J c() {
        J j6 = new J();
        j6.c = -1;
        j6.e = K.PACKAGE;
        return j6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        d((L) pVar);
        return this;
    }

    public final L b() {
        L l6 = new L(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        l6.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        l6.d = this.d;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        l6.e = this.e;
        l6.b = i3;
        return l6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        L lB = b();
        if (lB.isInitialized()) {
            return lB;
        }
        throw new C0.x();
    }

    public final Object clone() {
        J jC = c();
        jC.d(b());
        return jC;
    }

    public final void d(L l6) {
        if (l6 == L.f467h) {
            return;
        }
        int i = l6.b;
        if ((i & 1) == 1) {
            int i3 = l6.c;
            this.b = 1 | this.b;
            this.c = i3;
        }
        if ((i & 2) == 2) {
            int i4 = l6.d;
            this.b = 2 | this.b;
            this.d = i4;
        }
        if ((i & 4) == 4) {
            K k6 = l6.e;
            k6.getClass();
            this.b = 4 | this.b;
            this.e = k6;
        }
        this.f3870a = this.f3870a.b(l6.f468a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return L.f467h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return (this.b & 2) == 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.C0605f r2, kotlin.reflect.jvm.internal.impl.protobuf.C0608i r3) throws java.lang.Throwable {
        /*
            r1 = this;
            r3 = 0
            G2.a r0 = G2.L.i     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.L r0 = new G2.L     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.d(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.L r0 = (G2.L) r0     // Catch: java.lang.Throwable -> Lf
            throw r2     // Catch: java.lang.Throwable -> L17
        L17:
            r2 = move-exception
            r3 = r0
        L19:
            if (r3 == 0) goto L1e
            r1.d(r3)
        L1e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.J.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
