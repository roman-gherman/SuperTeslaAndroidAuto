package J2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$RecordOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends AbstractC0610k implements JvmProtoBuf$StringTableTypes$RecordOrBuilder {
    public int b;
    public int c;
    public int d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f849h;

    public static h c() {
        h hVar = new h();
        hVar.c = 1;
        hVar.e = "";
        hVar.f847f = i.NONE;
        List list = Collections.EMPTY_LIST;
        hVar.f848g = list;
        hVar.f849h = list;
        return hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(p pVar) {
        d((j) pVar);
        return this;
    }

    public final j b() {
        j jVar = new j(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        jVar.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        jVar.d = this.d;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        jVar.e = this.e;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        jVar.f854f = this.f847f;
        if ((i & 16) == 16) {
            this.f848g = Collections.unmodifiableList(this.f848g);
            this.b &= -17;
        }
        jVar.f855g = this.f848g;
        if ((this.b & 32) == 32) {
            this.f849h = Collections.unmodifiableList(this.f849h);
            this.b &= -33;
        }
        jVar.i = this.f849h;
        jVar.b = i3;
        return jVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        j jVarB = b();
        jVarB.isInitialized();
        return jVarB;
    }

    public final Object clone() {
        h hVarC = c();
        hVarC.d(b());
        return hVarC;
    }

    public final void d(j jVar) {
        if (jVar == j.f851m) {
            return;
        }
        int i = jVar.b;
        if ((i & 1) == 1) {
            int i3 = jVar.c;
            this.b = 1 | this.b;
            this.c = i3;
        }
        if ((i & 2) == 2) {
            int i4 = jVar.d;
            this.b = 2 | this.b;
            this.d = i4;
        }
        if ((i & 4) == 4) {
            this.b |= 4;
            this.e = jVar.e;
        }
        if ((i & 8) == 8) {
            i iVar = jVar.f854f;
            iVar.getClass();
            this.b = 8 | this.b;
            this.f847f = iVar;
        }
        if (!jVar.f855g.isEmpty()) {
            if (this.f848g.isEmpty()) {
                this.f848g = jVar.f855g;
                this.b &= -17;
            } else {
                if ((this.b & 16) != 16) {
                    this.f848g = new ArrayList(this.f848g);
                    this.b |= 16;
                }
                this.f848g.addAll(jVar.f855g);
            }
        }
        if (!jVar.i.isEmpty()) {
            if (this.f849h.isEmpty()) {
                this.f849h = jVar.i;
                this.b &= -33;
            } else {
                if ((this.b & 32) != 32) {
                    this.f849h = new ArrayList(this.f849h);
                    this.b |= 32;
                }
                this.f849h.addAll(jVar.i);
            }
        }
        this.f3870a = this.f3870a.b(jVar.f853a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return j.f851m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.C0605f r2, kotlin.reflect.jvm.internal.impl.protobuf.C0608i r3) throws java.lang.Throwable {
        /*
            r1 = this;
            r3 = 0
            G2.a r0 = J2.j.f852n     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            J2.j r0 = new J2.j     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.d(r0)
            return r1
        Lf:
            r2 = move-exception
            goto L19
        L11:
            r2 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.f3875a     // Catch: java.lang.Throwable -> Lf
            J2.j r0 = (J2.j) r0     // Catch: java.lang.Throwable -> Lf
            throw r2     // Catch: java.lang.Throwable -> L17
        L17:
            r2 = move-exception
            r3 = r0
        L19:
            if (r3 == 0) goto L1e
            r1.d(r3)
        L1e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: J2.h.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
