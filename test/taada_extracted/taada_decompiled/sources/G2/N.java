package G2;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class N extends AbstractC0610k implements ProtoBuf$StringTableOrBuilder {
    public int b;
    public LazyStringList c;

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        c((O) pVar);
        return this;
    }

    public final O b() {
        O o6 = new O(this);
        if ((this.b & 1) == 1) {
            this.c = this.c.getUnmodifiableView();
            this.b &= -2;
        }
        o6.b = this.c;
        return o6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        O oB = b();
        oB.isInitialized();
        return oB;
    }

    public final void c(O o6) {
        if (o6 == O.e) {
            return;
        }
        if (!o6.b.isEmpty()) {
            if (this.c.isEmpty()) {
                this.c = o6.b;
                this.b &= -2;
            } else {
                if ((this.b & 1) != 1) {
                    this.c = new kotlin.reflect.jvm.internal.impl.protobuf.s(this.c);
                    this.b |= 1;
                }
                this.c.addAll(o6.b);
            }
        }
        this.f3869a = this.f3869a.b(o6.f474a);
    }

    public final Object clone() {
        N n6 = new N();
        n6.c = kotlin.reflect.jvm.internal.impl.protobuf.s.b;
        n6.c(b());
        return n6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return O.e;
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
            G2.a r0 = G2.O.f473f     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.O r0 = new G2.O     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.c(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.O r0 = (G2.O) r0     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.N.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
