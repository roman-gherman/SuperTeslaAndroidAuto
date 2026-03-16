package J2;

import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignatureOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AbstractC0610k implements JvmProtoBuf$JvmFieldSignatureOrBuilder {
    public int b;
    public int c;
    public int d;

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(p pVar) {
        c((b) pVar);
        return this;
    }

    public final b b() {
        b bVar = new b(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        bVar.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        bVar.d = this.d;
        bVar.b = i3;
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        b bVarB = b();
        bVarB.isInitialized();
        return bVarB;
    }

    public final void c(b bVar) {
        if (bVar == b.f831g) {
            return;
        }
        int i = bVar.b;
        if ((i & 1) == 1) {
            int i3 = bVar.c;
            this.b = 1 | this.b;
            this.c = i3;
        }
        if ((i & 2) == 2) {
            int i4 = bVar.d;
            this.b = 2 | this.b;
            this.d = i4;
        }
        this.f3870a = this.f3870a.b(bVar.f833a);
    }

    public final Object clone() {
        a aVar = new a();
        aVar.c(b());
        return aVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return b.f831g;
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
            G2.a r0 = J2.b.f832h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            J2.b r0 = new J2.b     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.c(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.f3875a     // Catch: java.lang.Throwable -> Lf
            J2.b r0 = (J2.b) r0     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: J2.a.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
