package r2;

import P1.e;
import kotlin.jvm.internal.h;
import n2.AbstractC0707J;
import n2.AbstractC0708K;
import n2.C0699B;
import n2.C0702E;
import n2.C0703F;
import n2.C0704G;

/* JADX INFO: renamed from: r2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0795b extends AbstractC0708K {
    public static final C0795b c = new C0795b("protected_and_package", true);

    @Override // n2.AbstractC0708K
    public final Integer a(AbstractC0708K visibility) {
        h.f(visibility, "visibility");
        if (equals(visibility)) {
            return 0;
        }
        if (visibility == C0699B.c) {
            return null;
        }
        e eVar = AbstractC0707J.f4225a;
        return visibility == C0702E.c || visibility == C0703F.c ? 1 : -1;
    }

    @Override // n2.AbstractC0708K
    public final String b() {
        return "protected/*protected and package*/";
    }

    @Override // n2.AbstractC0708K
    public final AbstractC0708K c() {
        return C0704G.c;
    }
}
