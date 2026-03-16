package G2;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends AbstractC0610k implements ProtoBuf$VersionRequirementOrBuilder {
    public int b;
    public int c;
    public int d;
    public f0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g0 f581h;

    public static e0 c() {
        e0 e0Var = new e0();
        e0Var.e = f0.ERROR;
        e0Var.f581h = g0.LANGUAGE_VERSION;
        return e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        d((h0) pVar);
        return this;
    }

    public final h0 b() {
        h0 h0Var = new h0(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        h0Var.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        h0Var.d = this.d;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        h0Var.e = this.e;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        h0Var.f595f = this.f579f;
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        h0Var.f596g = this.f580g;
        if ((i & 32) == 32) {
            i3 |= 32;
        }
        h0Var.f597h = this.f581h;
        h0Var.b = i3;
        return h0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        h0 h0VarB = b();
        h0VarB.isInitialized();
        return h0VarB;
    }

    public final Object clone() {
        e0 e0VarC = c();
        e0VarC.d(b());
        return e0VarC;
    }

    public final void d(h0 h0Var) {
        if (h0Var == h0.f592k) {
            return;
        }
        int i = h0Var.b;
        if ((i & 1) == 1) {
            int i3 = h0Var.c;
            this.b = 1 | this.b;
            this.c = i3;
        }
        if ((i & 2) == 2) {
            int i4 = h0Var.d;
            this.b = 2 | this.b;
            this.d = i4;
        }
        if ((i & 4) == 4) {
            f0 f0Var = h0Var.e;
            f0Var.getClass();
            this.b = 4 | this.b;
            this.e = f0Var;
        }
        int i5 = h0Var.b;
        if ((i5 & 8) == 8) {
            int i6 = h0Var.f595f;
            this.b = 8 | this.b;
            this.f579f = i6;
        }
        if ((i5 & 16) == 16) {
            int i7 = h0Var.f596g;
            this.b = 16 | this.b;
            this.f580g = i7;
        }
        if ((i5 & 32) == 32) {
            g0 g0Var = h0Var.f597h;
            g0Var.getClass();
            this.b = 32 | this.b;
            this.f581h = g0Var;
        }
        this.f3869a = this.f3869a.b(h0Var.f594a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return h0.f592k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
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
            G2.a r0 = G2.h0.f593l     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.h0 r0 = new G2.h0     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.d(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.h0 r0 = (G2.h0) r0     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.e0.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
