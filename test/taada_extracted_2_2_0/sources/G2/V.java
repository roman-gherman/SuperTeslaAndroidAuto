package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAliasOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0611l;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes2.dex */
public final class V extends AbstractC0611l implements ProtoBuf$TypeAliasOrBuilder {
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public U f507h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public U f508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f511m;

    public static V d() {
        V v6 = new V();
        v6.e = 6;
        List list = Collections.EMPTY_LIST;
        v6.f506g = list;
        U u = U.f492t;
        v6.f507h = u;
        v6.f508j = u;
        v6.f510l = list;
        v6.f511m = list;
        return v6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        e((W) pVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        W wC = c();
        if (wC.isInitialized()) {
            return wC;
        }
        throw new C0.x();
    }

    public final W c() {
        W w5 = new W(this);
        int i = this.d;
        int i3 = (i & 1) != 1 ? 0 : 1;
        w5.d = this.e;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        w5.e = this.f505f;
        if ((i & 4) == 4) {
            this.f506g = Collections.unmodifiableList(this.f506g);
            this.d &= -5;
        }
        w5.f514f = this.f506g;
        if ((i & 8) == 8) {
            i3 |= 4;
        }
        w5.f515g = this.f507h;
        if ((i & 16) == 16) {
            i3 |= 8;
        }
        w5.f516h = this.i;
        if ((i & 32) == 32) {
            i3 |= 16;
        }
        w5.i = this.f508j;
        if ((i & 64) == 64) {
            i3 |= 32;
        }
        w5.f517j = this.f509k;
        if ((this.d & 128) == 128) {
            this.f510l = Collections.unmodifiableList(this.f510l);
            this.d &= -129;
        }
        w5.f518k = this.f510l;
        if ((this.d & 256) == 256) {
            this.f511m = Collections.unmodifiableList(this.f511m);
            this.d &= -257;
        }
        w5.f519l = this.f511m;
        w5.c = i3;
        return w5;
    }

    public final Object clone() {
        V vD = d();
        vD.e(c());
        return vD;
    }

    public final void e(W w5) {
        U u;
        U u2;
        if (w5 == W.f512o) {
            return;
        }
        int i = w5.c;
        if ((i & 1) == 1) {
            int i3 = w5.d;
            this.d = 1 | this.d;
            this.e = i3;
        }
        if ((i & 2) == 2) {
            int i4 = w5.e;
            this.d = 2 | this.d;
            this.f505f = i4;
        }
        if (!w5.f514f.isEmpty()) {
            if (this.f506g.isEmpty()) {
                this.f506g = w5.f514f;
                this.d &= -5;
            } else {
                if ((this.d & 4) != 4) {
                    this.f506g = new ArrayList(this.f506g);
                    this.d |= 4;
                }
                this.f506g.addAll(w5.f514f);
            }
        }
        if ((w5.c & 4) == 4) {
            U u6 = w5.f515g;
            if ((this.d & 8) != 8 || (u2 = this.f507h) == U.f492t) {
                this.f507h = u6;
            } else {
                T tK = U.k(u2);
                tK.e(u6);
                this.f507h = tK.c();
            }
            this.d |= 8;
        }
        int i5 = w5.c;
        if ((i5 & 8) == 8) {
            int i6 = w5.f516h;
            this.d |= 16;
            this.i = i6;
        }
        if ((i5 & 16) == 16) {
            U u7 = w5.i;
            if ((this.d & 32) != 32 || (u = this.f508j) == U.f492t) {
                this.f508j = u7;
            } else {
                T tK2 = U.k(u);
                tK2.e(u7);
                this.f508j = tK2.c();
            }
            this.d |= 32;
        }
        if ((w5.c & 32) == 32) {
            int i7 = w5.f517j;
            this.d |= 64;
            this.f509k = i7;
        }
        if (!w5.f518k.isEmpty()) {
            if (this.f510l.isEmpty()) {
                this.f510l = w5.f518k;
                this.d &= -129;
            } else {
                if ((this.d & 128) != 128) {
                    this.f510l = new ArrayList(this.f510l);
                    this.d |= 128;
                }
                this.f510l.addAll(w5.f518k);
            }
        }
        if (!w5.f519l.isEmpty()) {
            if (this.f511m.isEmpty()) {
                this.f511m = w5.f519l;
                this.d &= -257;
            } else {
                if ((this.d & 256) != 256) {
                    this.f511m = new ArrayList(this.f511m);
                    this.d |= 256;
                }
                this.f511m.addAll(w5.f519l);
            }
        }
        b(w5);
        this.f3870a = this.f3870a.b(w5.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return W.f512o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if ((this.d & 2) != 2) {
            return false;
        }
        for (int i = 0; i < this.f506g.size(); i++) {
            if (!((Z) this.f506g.get(i)).isInitialized()) {
                return false;
            }
        }
        if ((this.d & 8) == 8 && !this.f507h.isInitialized()) {
            return false;
        }
        if ((this.d & 32) == 32 && !this.f508j.isInitialized()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f510l.size(); i3++) {
            if (!((C0108h) this.f510l.get(i3)).isInitialized()) {
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
            G2.a r1 = G2.W.f513p     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.W r1 = new G2.W     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.e(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            G2.W r4 = (G2.W) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.V.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
