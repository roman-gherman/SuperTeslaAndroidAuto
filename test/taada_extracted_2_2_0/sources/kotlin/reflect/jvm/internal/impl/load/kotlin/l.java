package kotlin.reflect.jvm.internal.impl.load.kotlin;

import C0.t;
import Z2.n;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import n2.AbstractC0718j;
import q2.C0763B;
import s2.C0813c;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends d {
    public final C0763B c;
    public final t d;
    public final B.h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public K2.f f3841f;

    public l(C0763B c0763b, t tVar, n nVar, C0813c c0813c) {
        super(nVar, c0813c);
        this.c = c0763b;
        this.d = tVar;
        this.e = new B.h(c0763b, tVar);
        this.f3841f = K2.f.f938g;
    }

    public static final P2.g j(l lVar, L2.f fVar, Object obj) {
        P2.g gVarB = P2.h.f1218a.b(obj, lVar.c);
        if (gVarB != null) {
            return gVarB;
        }
        String message = "Unsupported annotation argument: " + fVar;
        kotlin.jvm.internal.h.f(message, "message");
        return new P2.j(message);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f
    public final k f(L2.b bVar, SourceElement sourceElement, List result) {
        kotlin.jvm.internal.h.f(result, "result");
        return new k(this, AbstractC0718j.f(this.c, bVar, this.d), bVar, result, sourceElement);
    }
}
