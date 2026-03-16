package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ConstructorOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0112l extends AbstractC0611l implements ProtoBuf$ConstructorOrBuilder {
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f646g;

    public static C0112l d() {
        C0112l c0112l = new C0112l();
        c0112l.e = 6;
        List list = Collections.EMPTY_LIST;
        c0112l.f645f = list;
        c0112l.f646g = list;
        return c0112l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((C0113m) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0113m c0113mC = c();
        if (c0113mC.isInitialized()) {
            return c0113mC;
        }
        throw new C0.x();
    }

    public final C0113m c() {
        C0113m c0113m = new C0113m(this);
        int i = this.d;
        int i3 = (i & 1) != 1 ? 0 : 1;
        c0113m.d = this.e;
        if ((i & 2) == 2) {
            this.f645f = Collections.unmodifiableList(this.f645f);
            this.d &= -3;
        }
        c0113m.e = this.f645f;
        if ((this.d & 4) == 4) {
            this.f646g = Collections.unmodifiableList(this.f646g);
            this.d &= -5;
        }
        c0113m.f648f = this.f646g;
        c0113m.c = i3;
        return c0113m;
    }

    public final Object clone() {
        C0112l c0112lD = d();
        c0112lD.e(c());
        return c0112lD;
    }

    public final void e(C0113m c0113m) {
        if (c0113m == C0113m.i) {
            return;
        }
        if ((c0113m.c & 1) == 1) {
            int i = c0113m.d;
            this.d = 1 | this.d;
            this.e = i;
        }
        if (!c0113m.e.isEmpty()) {
            if (this.f645f.isEmpty()) {
                this.f645f = c0113m.e;
                this.d &= -3;
            } else {
                if ((this.d & 2) != 2) {
                    this.f645f = new ArrayList(this.f645f);
                    this.d |= 2;
                }
                this.f645f.addAll(c0113m.e);
            }
        }
        if (!c0113m.f648f.isEmpty()) {
            if (this.f646g.isEmpty()) {
                this.f646g = c0113m.f648f;
                this.d &= -5;
            } else {
                if ((this.d & 4) != 4) {
                    this.f646g = new ArrayList(this.f646g);
                    this.d |= 4;
                }
                this.f646g.addAll(c0113m.f648f);
            }
        }
        b(c0113m);
        this.f3869a = this.f3869a.b(c0113m.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0113m.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        for (int i = 0; i < this.f645f.size(); i++) {
            if (!((d0) this.f645f.get(i)).isInitialized()) {
                return false;
            }
        }
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
            G2.a r1 = G2.C0113m.f647j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.m r1 = new G2.m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.m r4 = (G2.C0113m) r4     // Catch: java.lang.Throwable -> Lf
            throw r3     // Catch: java.lang.Throwable -> L17
        L17:
            r3 = move-exception
            r0 = r4
        L19:
            if (r0 == 0) goto L1e
            r2.e(r0)
        L1e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.C0112l.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
