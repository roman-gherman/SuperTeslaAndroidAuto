package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends AbstractC0611l implements ProtoBuf$PackageOrBuilder {
    public int d;
    public List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b0 f426h;
    public j0 i;

    public static C d() {
        C c = new C();
        List list = Collections.EMPTY_LIST;
        c.e = list;
        c.f424f = list;
        c.f425g = list;
        c.f426h = b0.f536g;
        c.i = j0.e;
        return c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((D) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        D dC = c();
        if (dC.isInitialized()) {
            return dC;
        }
        throw new C0.x();
    }

    public final D c() {
        D d = new D(this);
        int i = this.d;
        if ((i & 1) == 1) {
            this.e = Collections.unmodifiableList(this.e);
            this.d &= -2;
        }
        d.d = this.e;
        if ((this.d & 2) == 2) {
            this.f424f = Collections.unmodifiableList(this.f424f);
            this.d &= -3;
        }
        d.e = this.f424f;
        if ((this.d & 4) == 4) {
            this.f425g = Collections.unmodifiableList(this.f425g);
            this.d &= -5;
        }
        d.f429f = this.f425g;
        int i3 = (i & 8) != 8 ? 0 : 1;
        d.f430g = this.f426h;
        if ((i & 16) == 16) {
            i3 |= 2;
        }
        d.f431h = this.i;
        d.c = i3;
        return d;
    }

    public final Object clone() {
        C cD = d();
        cD.e(c());
        return cD;
    }

    public final void e(D d) {
        j0 j0Var;
        b0 b0Var;
        if (d == D.f427k) {
            return;
        }
        if (!d.d.isEmpty()) {
            if (this.e.isEmpty()) {
                this.e = d.d;
                this.d &= -2;
            } else {
                if ((this.d & 1) != 1) {
                    this.e = new ArrayList(this.e);
                    this.d |= 1;
                }
                this.e.addAll(d.d);
            }
        }
        if (!d.e.isEmpty()) {
            if (this.f424f.isEmpty()) {
                this.f424f = d.e;
                this.d &= -3;
            } else {
                if ((this.d & 2) != 2) {
                    this.f424f = new ArrayList(this.f424f);
                    this.d |= 2;
                }
                this.f424f.addAll(d.e);
            }
        }
        if (!d.f429f.isEmpty()) {
            if (this.f425g.isEmpty()) {
                this.f425g = d.f429f;
                this.d &= -5;
            } else {
                if ((this.d & 4) != 4) {
                    this.f425g = new ArrayList(this.f425g);
                    this.d |= 4;
                }
                this.f425g.addAll(d.f429f);
            }
        }
        if ((d.c & 1) == 1) {
            b0 b0Var2 = d.f430g;
            if ((this.d & 8) != 8 || (b0Var = this.f426h) == b0.f536g) {
                this.f426h = b0Var2;
            } else {
                a0 a0VarC = b0.c(b0Var);
                a0VarC.d(b0Var2);
                this.f426h = a0VarC.b();
            }
            this.d |= 8;
        }
        if ((d.c & 2) == 2) {
            j0 j0Var2 = d.f431h;
            if ((this.d & 16) != 16 || (j0Var = this.i) == j0.e) {
                this.i = j0Var2;
            } else {
                i0 i0Var = new i0();
                i0Var.c = Collections.EMPTY_LIST;
                i0Var.c(j0Var);
                i0Var.c(j0Var2);
                this.i = i0Var.b();
            }
            this.d |= 16;
        }
        b(d);
        this.f3870a = this.f3870a.b(d.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return D.f427k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        for (int i = 0; i < this.e.size(); i++) {
            if (!((C0125z) this.e.get(i)).isInitialized()) {
                return false;
            }
        }
        for (int i3 = 0; i3 < this.f424f.size(); i3++) {
            if (!((H) this.f424f.get(i3)).isInitialized()) {
                return false;
            }
        }
        for (int i4 = 0; i4 < this.f425g.size(); i4++) {
            if (!((W) this.f425g.get(i4)).isInitialized()) {
                return false;
            }
        }
        return ((this.d & 8) != 8 || this.f426h.isInitialized()) && this.b.e();
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
            G2.a r1 = G2.D.f428l     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.D r1 = new G2.D     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.D r4 = (G2.D) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.C.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
