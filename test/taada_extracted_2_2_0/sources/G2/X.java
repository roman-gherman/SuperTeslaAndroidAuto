package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameterOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class X extends AbstractC0611l implements ProtoBuf$TypeParameterOrBuilder {
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Y f524h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f525j;

    public static X d() {
        X x = new X();
        x.f524h = Y.INV;
        List list = Collections.EMPTY_LIST;
        x.i = list;
        x.f525j = list;
        return x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((Z) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        Z zC = c();
        if (zC.isInitialized()) {
            return zC;
        }
        throw new C0.x();
    }

    public final Z c() {
        Z z6 = new Z(this);
        int i = this.d;
        int i3 = (i & 1) != 1 ? 0 : 1;
        z6.d = this.e;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        z6.e = this.f522f;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        z6.f529f = this.f523g;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        z6.f530g = this.f524h;
        if ((i & 16) == 16) {
            this.i = Collections.unmodifiableList(this.i);
            this.d &= -17;
        }
        z6.f531h = this.i;
        if ((this.d & 32) == 32) {
            this.f525j = Collections.unmodifiableList(this.f525j);
            this.d &= -33;
        }
        z6.i = this.f525j;
        z6.c = i3;
        return z6;
    }

    public final Object clone() {
        X xD = d();
        xD.e(c());
        return xD;
    }

    public final void e(Z z6) {
        if (z6 == Z.f527m) {
            return;
        }
        int i = z6.c;
        if ((i & 1) == 1) {
            int i3 = z6.d;
            this.d = 1 | this.d;
            this.e = i3;
        }
        if ((i & 2) == 2) {
            int i4 = z6.e;
            this.d = 2 | this.d;
            this.f522f = i4;
        }
        if ((i & 4) == 4) {
            boolean z7 = z6.f529f;
            this.d = 4 | this.d;
            this.f523g = z7;
        }
        if ((i & 8) == 8) {
            Y y = z6.f530g;
            y.getClass();
            this.d = 8 | this.d;
            this.f524h = y;
        }
        if (!z6.f531h.isEmpty()) {
            if (this.i.isEmpty()) {
                this.i = z6.f531h;
                this.d &= -17;
            } else {
                if ((this.d & 16) != 16) {
                    this.i = new ArrayList(this.i);
                    this.d |= 16;
                }
                this.i.addAll(z6.f531h);
            }
        }
        if (!z6.i.isEmpty()) {
            if (this.f525j.isEmpty()) {
                this.f525j = z6.i;
                this.d &= -33;
            } else {
                if ((this.d & 32) != 32) {
                    this.f525j = new ArrayList(this.f525j);
                    this.d |= 32;
                }
                this.f525j.addAll(z6.i);
            }
        }
        b(z6);
        this.f3870a = this.f3870a.b(z6.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return Z.f527m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        int i = this.d;
        if ((i & 1) != 1 || (i & 2) != 2) {
            return false;
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (!((U) this.i.get(i3)).isInitialized()) {
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
            G2.a r1 = G2.Z.f528n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.Z r1 = new G2.Z     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.Z r4 = (G2.Z) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.X.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
