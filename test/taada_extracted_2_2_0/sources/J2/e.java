package J2;

import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignatureOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends AbstractC0610k implements JvmProtoBuf$JvmPropertySignatureOrBuilder {
    public int b;
    public b c;
    public d d;
    public d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f840g;

    public static e c() {
        e eVar = new e();
        eVar.c = b.f831g;
        d dVar = d.f835g;
        eVar.d = dVar;
        eVar.e = dVar;
        eVar.f839f = dVar;
        eVar.f840g = dVar;
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0610k
    public final /* bridge */ /* synthetic */ AbstractC0610k a(p pVar) {
        d((f) pVar);
        return this;
    }

    public final f b() {
        f fVar = new f(this);
        int i = this.b;
        int i3 = (i & 1) != 1 ? 0 : 1;
        fVar.c = this.c;
        if ((i & 2) == 2) {
            i3 |= 2;
        }
        fVar.d = this.d;
        if ((i & 4) == 4) {
            i3 |= 4;
        }
        fVar.e = this.e;
        if ((i & 8) == 8) {
            i3 |= 8;
        }
        fVar.f844f = this.f839f;
        if ((i & 16) == 16) {
            i3 |= 16;
        }
        fVar.f845g = this.f840g;
        fVar.b = i3;
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
    public final MessageLite build() {
        f fVarB = b();
        fVarB.isInitialized();
        return fVarB;
    }

    public final Object clone() {
        e eVarC = c();
        eVarC.d(b());
        return eVarC;
    }

    public final void d(f fVar) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        b bVar;
        if (fVar == f.f841j) {
            return;
        }
        if ((fVar.b & 1) == 1) {
            b bVar2 = fVar.c;
            if ((this.b & 1) != 1 || (bVar = this.c) == b.f831g) {
                this.c = bVar2;
            } else {
                a aVar = new a();
                aVar.c(bVar);
                aVar.c(bVar2);
                this.c = aVar.b();
            }
            this.b |= 1;
        }
        if ((fVar.b & 2) == 2) {
            d dVar5 = fVar.d;
            if ((this.b & 2) != 2 || (dVar4 = this.d) == d.f835g) {
                this.d = dVar5;
            } else {
                c cVarC = d.c(dVar4);
                cVarC.c(dVar5);
                this.d = cVarC.b();
            }
            this.b |= 2;
        }
        if ((fVar.b & 4) == 4) {
            d dVar6 = fVar.e;
            if ((this.b & 4) != 4 || (dVar3 = this.e) == d.f835g) {
                this.e = dVar6;
            } else {
                c cVarC2 = d.c(dVar3);
                cVarC2.c(dVar6);
                this.e = cVarC2.b();
            }
            this.b |= 4;
        }
        if ((fVar.b & 8) == 8) {
            d dVar7 = fVar.f844f;
            if ((this.b & 8) != 8 || (dVar2 = this.f839f) == d.f835g) {
                this.f839f = dVar7;
            } else {
                c cVarC3 = d.c(dVar2);
                cVarC3.c(dVar7);
                this.f839f = cVarC3.b();
            }
            this.b |= 8;
        }
        if ((fVar.b & 16) == 16) {
            d dVar8 = fVar.f845g;
            if ((this.b & 16) != 16 || (dVar = this.f840g) == d.f835g) {
                this.f840g = dVar8;
            } else {
                c cVarC4 = d.c(dVar);
                cVarC4.c(dVar8);
                this.f840g = cVarC4.b();
            }
            this.b |= 16;
        }
        this.f3870a = this.f3870a.b(fVar.f843a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f.f841j;
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
    public final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.C0605f r3, kotlin.reflect.jvm.internal.impl.protobuf.C0608i r4) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            G2.a r1 = J2.f.f842k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.getClass()     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            J2.f r1 = new J2.f     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.r -> L11
            r2.d(r1)
            return r2
        Lf:
            r3 = move-exception
            goto L19
        L11:
            r3 = move-exception
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.f3875a     // Catch: java.lang.Throwable -> Lf
            J2.f r4 = (J2.f) r4     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: J2.e.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder");
    }
}
