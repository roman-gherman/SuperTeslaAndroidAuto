package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends AbstractC0610k implements ProtoBuf$TypeTableOrBuilder {
    public int b;
    public List c;
    public int d;

    public static a0 c() {
        a0 a0Var = new a0();
        a0Var.c = Collections.EMPTY_LIST;
        a0Var.d = -1;
        return a0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        d((b0) pVar);
        return this;
    }

    public final b0 b() {
        b0 b0Var = new b0(this);
        int i = this.b;
        if ((i & 1) == 1) {
            this.c = Collections.unmodifiableList(this.c);
            this.b &= -2;
        }
        b0Var.c = this.c;
        int i3 = (i & 2) != 2 ? 0 : 1;
        b0Var.d = this.d;
        b0Var.b = i3;
        return b0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        b0 b0VarB = b();
        if (b0VarB.isInitialized()) {
            return b0VarB;
        }
        throw new C0.x();
    }

    public final Object clone() {
        a0 a0VarC = c();
        a0VarC.d(b());
        return a0VarC;
    }

    public final void d(b0 b0Var) {
        if (b0Var == b0.f536g) {
            return;
        }
        if (!b0Var.c.isEmpty()) {
            if (this.c.isEmpty()) {
                this.c = b0Var.c;
                this.b &= -2;
            } else {
                if ((this.b & 1) != 1) {
                    this.c = new ArrayList(this.c);
                    this.b |= 1;
                }
                this.c.addAll(b0Var.c);
            }
        }
        if ((b0Var.b & 1) == 1) {
            int i = b0Var.d;
            this.b |= 2;
            this.d = i;
        }
        this.f3869a = this.f3869a.b(b0Var.f538a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return b0.f536g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        for (int i = 0; i < this.c.size(); i++) {
            if (!((U) this.c.get(i)).isInitialized()) {
                return false;
            }
        }
        return true;
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
            G2.a r1 = G2.b0.f537h     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.b0 r1 = new G2.b0     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.d(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.b0 r4 = (G2.b0) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.a0.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
