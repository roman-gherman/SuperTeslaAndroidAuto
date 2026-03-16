package J2;

import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignatureOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends AbstractC0610k implements JvmProtoBuf$JvmMethodSignatureOrBuilder {
    public int b;
    public int c;
    public int d;

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(p pVar) {
        c((d) pVar);
        return this;
    }

    public final d b() {
        d dVar = new d(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        dVar.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        dVar.d = this.d;
        dVar.b = i3;
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        d dVarB = b();
        dVarB.isInitialized();
        return dVarB;
    }

    public final void c(d dVar) {
        if (dVar == d.f835g) {
            return;
        }
        int i = dVar.b;
        if ((i & 1) == 1) {
            int i3 = dVar.c;
            this.b = 1 | this.b;
            this.c = i3;
        }
        if ((i & 2) == 2) {
            int i4 = dVar.d;
            this.b = 2 | this.b;
            this.d = i4;
        }
        this.f3870a = this.f3870a.b(dVar.f837a);
    }

    public final Object clone() {
        c cVar = new c();
        cVar.c(b());
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return d.f835g;
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
            G2.a r0 = J2.d.f836h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            J2.d r0 = new J2.d     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.c(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.f3875a     // Catch: java.lang.Throwable -> Lf
            J2.d r0 = (J2.d) r0     // Catch: java.lang.Throwable -> Lf
            throw r2     // Catch: java.lang.Throwable -> L17
        L17:
            r2 = move-exception
            r3 = r0
        L19:
            if (r3 == 0) goto L1e
            r1.c(r3)
        L1e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: J2.c.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
