package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ExpressionOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0121v extends AbstractC0610k implements ProtoBuf$ExpressionOrBuilder {
    public int b;
    public int c;
    public int d;
    public EnumC0122w e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public U f664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f666h;
    public List i;

    public static C0121v c() {
        C0121v c0121v = new C0121v();
        c0121v.e = EnumC0122w.TRUE;
        c0121v.f664f = U.f492t;
        List list = Collections.EMPTY_LIST;
        c0121v.f666h = list;
        c0121v.i = list;
        return c0121v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        d((C0123x) pVar);
        return this;
    }

    public final C0123x b() {
        C0123x c0123x = new C0123x(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        c0123x.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        c0123x.d = this.d;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        c0123x.e = this.e;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        c0123x.f671f = this.f664f;
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        c0123x.f672g = this.f665g;
        if ((i & 32) == 32) {
            this.f666h = Collections.unmodifiableList(this.f666h);
            this.b &= -33;
        }
        c0123x.f673h = this.f666h;
        if ((this.b & 64) == 64) {
            this.i = Collections.unmodifiableList(this.i);
            this.b &= -65;
        }
        c0123x.i = this.i;
        c0123x.b = i3;
        return c0123x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0123x c0123xB = b();
        if (c0123xB.isInitialized()) {
            return c0123xB;
        }
        throw new C0.x();
    }

    public final Object clone() {
        C0121v c0121vC = c();
        c0121vC.d(b());
        return c0121vC;
    }

    public final void d(C0123x c0123x) {
        U u;
        if (c0123x == C0123x.f668l) {
            return;
        }
        int i = c0123x.b;
        if ((i & 1) == 1) {
            int i3 = c0123x.c;
            this.b = 1 | this.b;
            this.c = i3;
        }
        if ((i & 2) == 2) {
            int i4 = c0123x.d;
            this.b = 2 | this.b;
            this.d = i4;
        }
        if ((i & 4) == 4) {
            EnumC0122w enumC0122w = c0123x.e;
            enumC0122w.getClass();
            this.b = 4 | this.b;
            this.e = enumC0122w;
        }
        if ((c0123x.b & 8) == 8) {
            U u2 = c0123x.f671f;
            if ((this.b & 8) != 8 || (u = this.f664f) == U.f492t) {
                this.f664f = u2;
            } else {
                T tK = U.k(u);
                tK.e(u2);
                this.f664f = tK.c();
            }
            this.b |= 8;
        }
        if ((c0123x.b & 16) == 16) {
            int i5 = c0123x.f672g;
            this.b = 16 | this.b;
            this.f665g = i5;
        }
        if (!c0123x.f673h.isEmpty()) {
            if (this.f666h.isEmpty()) {
                this.f666h = c0123x.f673h;
                this.b &= -33;
            } else {
                if ((this.b & 32) != 32) {
                    this.f666h = new ArrayList(this.f666h);
                    this.b |= 32;
                }
                this.f666h.addAll(c0123x.f673h);
            }
        }
        if (!c0123x.i.isEmpty()) {
            if (this.i.isEmpty()) {
                this.i = c0123x.i;
                this.b &= -65;
            } else {
                if ((this.b & 64) != 64) {
                    this.i = new ArrayList(this.i);
                    this.b |= 64;
                }
                this.i.addAll(c0123x.i);
            }
        }
        this.f3870a = this.f3870a.b(c0123x.f670a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0123x.f668l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if ((this.b & 8) == 8 && !this.f664f.isInitialized()) {
            return false;
        }
        for (int i = 0; i < this.f666h.size(); i++) {
            if (!((C0123x) this.f666h.get(i)).isInitialized()) {
                return false;
            }
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (!((C0123x) this.i.get(i3)).isInitialized()) {
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
            G2.a r1 = G2.C0123x.f669m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.x r1 = new G2.x     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.d(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.x r4 = (G2.C0123x) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.C0121v.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
