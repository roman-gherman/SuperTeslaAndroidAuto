package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragmentOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends AbstractC0611l implements ProtoBuf$PackageFragmentOrBuilder {
    public int d;
    public O e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public M f433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public D f434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f435h;

    public static E d() {
        E e = new E();
        e.e = O.e;
        e.f433f = M.e;
        e.f434g = D.f427k;
        e.f435h = Collections.EMPTY_LIST;
        return e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((F) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        F fC = c();
        if (fC.isInitialized()) {
            return fC;
        }
        throw new C0.x();
    }

    public final F c() {
        F f6 = new F(this);
        int i = this.d;
        int i3 = (i & 1) != 1 ? 0 : 1;
        f6.d = this.e;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        f6.e = this.f433f;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        f6.f438f = this.f434g;
        if ((i & 8) == 8) {
            this.f435h = Collections.unmodifiableList(this.f435h);
            this.d &= -9;
        }
        f6.f439g = this.f435h;
        f6.c = i3;
        return f6;
    }

    public final Object clone() {
        E eD = d();
        eD.e(c());
        return eD;
    }

    public final void e(F f6) {
        D d;
        M m6;
        O o6;
        if (f6 == F.f436j) {
            return;
        }
        if ((f6.c & 1) == 1) {
            O o7 = f6.d;
            if ((this.d & 1) != 1 || (o6 = this.e) == O.e) {
                this.e = o7;
            } else {
                N n6 = new N();
                n6.c = kotlin.reflect.jvm.internal.impl.protobuf.s.b;
                n6.c(o6);
                n6.c(o7);
                this.e = n6.b();
            }
            this.d |= 1;
        }
        if ((f6.c & 2) == 2) {
            M m7 = f6.e;
            if ((this.d & 2) != 2 || (m6 = this.f433f) == M.e) {
                this.f433f = m7;
            } else {
                I i = new I();
                i.c = Collections.EMPTY_LIST;
                i.c(m6);
                i.c(m7);
                this.f433f = i.b();
            }
            this.d |= 2;
        }
        if ((f6.c & 4) == 4) {
            D d6 = f6.f438f;
            if ((this.d & 4) != 4 || (d = this.f434g) == D.f427k) {
                this.f434g = d6;
            } else {
                C cD = C.d();
                cD.e(d);
                cD.e(d6);
                this.f434g = cD.c();
            }
            this.d |= 4;
        }
        if (!f6.f439g.isEmpty()) {
            if (this.f435h.isEmpty()) {
                this.f435h = f6.f439g;
                this.d &= -9;
            } else {
                if ((this.d & 8) != 8) {
                    this.f435h = new ArrayList(this.f435h);
                    this.d |= 8;
                }
                this.f435h.addAll(f6.f439g);
            }
        }
        b(f6);
        this.f3869a = this.f3869a.b(f6.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return F.f436j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if ((this.d & 2) == 2 && !this.f433f.isInitialized()) {
            return false;
        }
        if ((this.d & 4) == 4 && !this.f434g.isInitialized()) {
            return false;
        }
        for (int i = 0; i < this.f435h.size(); i++) {
            if (!((C0111k) this.f435h.get(i)).isInitialized()) {
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
            G2.a r1 = G2.F.f437k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.F r1 = new G2.F     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.F r4 = (G2.F) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.E.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
