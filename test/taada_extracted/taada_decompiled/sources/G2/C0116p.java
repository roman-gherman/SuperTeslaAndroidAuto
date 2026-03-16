package G2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EffectOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: G2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0116p extends AbstractC0610k implements ProtoBuf$EffectOrBuilder {
    public int b;
    public EnumC0117q c;
    public List d;
    public C0123x e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r f653f;

    public static C0116p c() {
        C0116p c0116p = new C0116p();
        c0116p.c = EnumC0117q.RETURNS_CONSTANT;
        c0116p.d = Collections.EMPTY_LIST;
        c0116p.e = C0123x.f668l;
        c0116p.f653f = r.AT_MOST_ONCE;
        return c0116p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(kotlin.reflect.jvm.internal.impl.protobuf.p pVar) {
        d((C0118s) pVar);
        return this;
    }

    public final C0118s b() {
        C0118s c0118s = new C0118s(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        c0118s.c = this.c;
        if ((i & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
            this.b &= -3;
        }
        c0118s.d = this.d;
        if ((i & 4) == 4) {
            i3 |= 2;
        }
        c0118s.e = this.e;
        if ((i & 8) == 8) {
            i3 |= 4;
        }
        c0118s.f658f = this.f653f;
        c0118s.b = i3;
        return c0118s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        C0118s c0118sB = b();
        if (c0118sB.isInitialized()) {
            return c0118sB;
        }
        throw new C0.x();
    }

    public final Object clone() {
        C0116p c0116pC = c();
        c0116pC.d(b());
        return c0116pC;
    }

    public final void d(C0118s c0118s) {
        C0123x c0123x;
        if (c0118s == C0118s.i) {
            return;
        }
        if ((c0118s.b & 1) == 1) {
            EnumC0117q enumC0117q = c0118s.c;
            enumC0117q.getClass();
            this.b |= 1;
            this.c = enumC0117q;
        }
        if (!c0118s.d.isEmpty()) {
            if (this.d.isEmpty()) {
                this.d = c0118s.d;
                this.b &= -3;
            } else {
                if ((this.b & 2) != 2) {
                    this.d = new ArrayList(this.d);
                    this.b |= 2;
                }
                this.d.addAll(c0118s.d);
            }
        }
        if ((c0118s.b & 2) == 2) {
            C0123x c0123x2 = c0118s.e;
            if ((this.b & 4) != 4 || (c0123x = this.e) == C0123x.f668l) {
                this.e = c0123x2;
            } else {
                C0121v c0121vC = C0121v.c();
                c0121vC.d(c0123x);
                c0121vC.d(c0123x2);
                this.e = c0121vC.b();
            }
            this.b |= 4;
        }
        if ((c0118s.b & 4) == 4) {
            r rVar = c0118s.f658f;
            rVar.getClass();
            this.b |= 8;
            this.f653f = rVar;
        }
        this.f3869a = this.f3869a.b(c0118s.f657a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return C0118s.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        for (int i = 0; i < this.d.size(); i++) {
            if (!((C0123x) this.d.get(i)).isInitialized()) {
                return false;
            }
        }
        return (this.b & 4) != 4 || this.e.isInitialized();
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
            G2.a r1 = G2.C0118s.f656j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            G2.s r1 = new G2.s     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.d(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3874a     // Catch: java.lang.Throwable -> Lf
            G2.s r4 = (G2.C0118s) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: G2.C0116p.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
