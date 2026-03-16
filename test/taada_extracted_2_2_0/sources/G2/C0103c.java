package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$ValueOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0103c extends AbstractC0610k implements ProtoBuf$Annotation$Argument$ValueOrBuilder {
    public int b;
    public EnumC0104d c;
    public long d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f542h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C0108h f543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f545l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f546m;

    public static C0103c c() {
        C0103c c0103c = new C0103c();
        c0103c.c = EnumC0104d.BYTE;
        c0103c.f543j = C0108h.f588g;
        c0103c.f544k = Collections.EMPTY_LIST;
        return c0103c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        d((C0105e) pVar);
        return this;
    }

    public final C0105e b() {
        C0105e c0105e = new C0105e(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        c0105e.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        c0105e.d = this.d;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        c0105e.e = this.e;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        c0105e.f570f = this.f540f;
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        c0105e.f571g = this.f541g;
        if ((i & 32) == 32) {
            i3 |= 32;
        }
        c0105e.f572h = this.f542h;
        if ((i & 64) == 64) {
            i3 |= 64;
        }
        c0105e.i = this.i;
        if ((i & 128) == 128) {
            i3 |= 128;
        }
        c0105e.f573j = this.f543j;
        if ((i & 256) == 256) {
            this.f544k = Collections.unmodifiableList(this.f544k);
            this.b &= -257;
        }
        c0105e.f574k = this.f544k;
        if ((i & 512) == 512) {
            i3 |= 256;
        }
        c0105e.f575l = this.f545l;
        if ((i & 1024) == 1024) {
            i3 |= 512;
        }
        c0105e.f576m = this.f546m;
        c0105e.b = i3;
        return c0105e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0105e c0105eB = b();
        if (c0105eB.isInitialized()) {
            return c0105eB;
        }
        throw new C0.x();
    }

    public final Object clone() {
        C0103c c0103cC = c();
        c0103cC.d(b());
        return c0103cC;
    }

    public final void d(C0105e c0105e) {
        C0108h c0108h;
        if (c0105e == C0105e.f568p) {
            return;
        }
        if ((c0105e.b & 1) == 1) {
            EnumC0104d enumC0104d = c0105e.c;
            enumC0104d.getClass();
            this.b = 1 | this.b;
            this.c = enumC0104d;
        }
        int i = c0105e.b;
        if ((i & 2) == 2) {
            long j6 = c0105e.d;
            this.b |= 2;
            this.d = j6;
        }
        if ((i & 4) == 4) {
            float f6 = c0105e.e;
            this.b = 4 | this.b;
            this.e = f6;
        }
        if ((i & 8) == 8) {
            double d = c0105e.f570f;
            this.b |= 8;
            this.f540f = d;
        }
        if ((i & 16) == 16) {
            int i3 = c0105e.f571g;
            this.b = 16 | this.b;
            this.f541g = i3;
        }
        if ((i & 32) == 32) {
            int i4 = c0105e.f572h;
            this.b = 32 | this.b;
            this.f542h = i4;
        }
        if ((i & 64) == 64) {
            int i5 = c0105e.i;
            this.b = 64 | this.b;
            this.i = i5;
        }
        if ((i & 128) == 128) {
            C0108h c0108h2 = c0105e.f573j;
            if ((this.b & 128) != 128 || (c0108h = this.f543j) == C0108h.f588g) {
                this.f543j = c0108h2;
            } else {
                C0107g c0107g = new C0107g();
                c0107g.d = Collections.EMPTY_LIST;
                c0107g.c(c0108h);
                c0107g.c(c0108h2);
                this.f543j = c0107g.b();
            }
            this.b |= 128;
        }
        if (!c0105e.f574k.isEmpty()) {
            if (this.f544k.isEmpty()) {
                this.f544k = c0105e.f574k;
                this.b &= -257;
            } else {
                if ((this.b & 256) != 256) {
                    this.f544k = new ArrayList(this.f544k);
                    this.b |= 256;
                }
                this.f544k.addAll(c0105e.f574k);
            }
        }
        int i6 = c0105e.b;
        if ((i6 & 256) == 256) {
            int i7 = c0105e.f575l;
            this.b |= 512;
            this.f545l = i7;
        }
        if ((i6 & 512) == 512) {
            int i8 = c0105e.f576m;
            this.b |= 1024;
            this.f546m = i8;
        }
        this.f3870a = this.f3870a.b(c0105e.f569a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0105e.f568p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if ((this.b & 128) == 128 && !this.f543j.isInitialized()) {
            return false;
        }
        for (int i = 0; i < this.f544k.size(); i++) {
            if (!((C0105e) this.f544k.get(i)).isInitialized()) {
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
            G2.a r1 = G2.C0105e.q     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.e r1 = new G2.e     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.d(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.e r4 = (G2.C0105e) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.C0103c.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
