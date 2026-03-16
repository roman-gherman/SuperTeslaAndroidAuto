package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$AnnotationOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0107g extends AbstractC0610k implements ProtoBuf$AnnotationOrBuilder {
    public int b;
    public int c;
    public List d;

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        c((C0108h) pVar);
        return this;
    }

    public final C0108h b() {
        C0108h c0108h = new C0108h(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        c0108h.c = this.c;
        if ((i & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
            this.b &= -3;
        }
        c0108h.d = this.d;
        c0108h.b = i3;
        return c0108h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0108h c0108hB = b();
        if (c0108hB.isInitialized()) {
            return c0108hB;
        }
        throw new C0.x();
    }

    public final void c(C0108h c0108h) {
        if (c0108h == C0108h.f588g) {
            return;
        }
        if ((c0108h.b & 1) == 1) {
            int i = c0108h.c;
            this.b = 1 | this.b;
            this.c = i;
        }
        if (!c0108h.d.isEmpty()) {
            if (this.d.isEmpty()) {
                this.d = c0108h.d;
                this.b &= -3;
            } else {
                if ((this.b & 2) != 2) {
                    this.d = new ArrayList(this.d);
                    this.b |= 2;
                }
                this.d.addAll(c0108h.d);
            }
        }
        this.f3870a = this.f3870a.b(c0108h.f590a);
    }

    public final Object clone() {
        C0107g c0107g = new C0107g();
        c0107g.d = Collections.EMPTY_LIST;
        c0107g.c(b());
        return c0107g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0108h.f588g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if ((this.b & 1) != 1) {
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (!((C0106f) this.d.get(i)).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.C0605f r3, kotlin.reflect.jvm.internal.impl.protobuf.C0608i r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            G2.a r1 = G2.C0108h.f589h     // Catch: java.lang.Throwable -> Ld kotlin.reflect.jvm.internal.impl.protobuf.r -> Lf
            java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Ld kotlin.reflect.jvm.internal.impl.protobuf.r -> Lf
            G2.h r3 = (G2.C0108h) r3     // Catch: java.lang.Throwable -> Ld kotlin.reflect.jvm.internal.impl.protobuf.r -> Lf
            r2.c(r3)
            return r2
        Ld:
            r3 = move-exception
            goto L17
        Lf:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Ld
            G2.h r4 = (G2.C0108h) r4     // Catch: java.lang.Throwable -> Ld
            throw r3     // Catch: java.lang.Throwable -> L15
        L15:
            r3 = move-exception
            r0 = r4
        L17:
            if (r0 == 0) goto L1c
            r2.c(r0)
        L1c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.C0107g.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
