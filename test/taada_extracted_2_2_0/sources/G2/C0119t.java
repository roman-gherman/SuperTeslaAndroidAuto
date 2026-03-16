package G2;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntryOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0119t extends AbstractC0611l implements ProtoBuf$EnumEntryOrBuilder {
    public int d;
    public int e;

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        c((C0120u) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0120u c0120u = new C0120u(this);
        int i = (this.d & 1) != 1 ? 0 : 1;
        c0120u.d = this.e;
        c0120u.c = i;
        if (c0120u.isInitialized()) {
            return c0120u;
        }
        throw new C0.x();
    }

    public final void c(C0120u c0120u) {
        if (c0120u == C0120u.f661g) {
            return;
        }
        if ((c0120u.c & 1) == 1) {
            int i = c0120u.d;
            this.d = 1 | this.d;
            this.e = i;
        }
        b(c0120u);
        this.f3870a = this.f3870a.b(c0120u.b);
    }

    public final Object clone() {
        C0119t c0119t = new C0119t();
        C0120u c0120u = new C0120u(this);
        int i = (this.d & 1) != 1 ? 0 : 1;
        c0120u.d = this.e;
        c0120u.c = i;
        c0119t.c(c0120u);
        return c0119t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0120u.f661g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return this.b.e();
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
            G2.a r1 = G2.C0120u.f662h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.u r1 = new G2.u     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.c(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.u r4 = (G2.C0120u) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.C0119t.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
