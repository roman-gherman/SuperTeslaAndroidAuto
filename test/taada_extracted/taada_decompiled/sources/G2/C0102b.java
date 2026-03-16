package G2;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$ArgumentOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0102b extends AbstractC0610k implements ProtoBuf$Annotation$ArgumentOrBuilder {
    public int b;
    public int c;
    public C0105e d;

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        c((C0106f) pVar);
        return this;
    }

    public final C0106f b() {
        C0106f c0106f = new C0106f(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        c0106f.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        c0106f.d = this.d;
        c0106f.b = i3;
        return c0106f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0106f c0106fB = b();
        if (c0106fB.isInitialized()) {
            return c0106fB;
        }
        throw new C0.x();
    }

    public final void c(C0106f c0106f) {
        C0105e c0105e;
        if (c0106f == C0106f.f582g) {
            return;
        }
        int i = c0106f.b;
        if ((i & 1) == 1) {
            int i3 = c0106f.c;
            this.b = 1 | this.b;
            this.c = i3;
        }
        if ((i & 2) == 2) {
            C0105e c0105e2 = c0106f.d;
            if ((this.b & 2) != 2 || (c0105e = this.d) == C0105e.f568p) {
                this.d = c0105e2;
            } else {
                C0103c c0103cC = C0103c.c();
                c0103cC.d(c0105e);
                c0103cC.d(c0105e2);
                this.d = c0103cC.b();
            }
            this.b |= 2;
        }
        this.f3869a = this.f3869a.b(c0106f.f584a);
    }

    public final Object clone() {
        C0102b c0102b = new C0102b();
        c0102b.d = C0105e.f568p;
        c0102b.c(b());
        return c0102b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0106f.f582g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        int i = this.b;
        return (i & 1) == 1 && (i & 2) == 2 && this.d.isInitialized();
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
            G2.a r1 = G2.C0106f.f583h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.f r1 = new G2.f     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.c(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.f r4 = (G2.C0106f) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.c(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.C0102b.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
