package M2;

import a3.AbstractC0162z;
import a3.d0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1061a;
    public final /* synthetic */ s b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(s sVar, int i) {
        super(1);
        this.f1061a = i;
        this.b = sVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f1061a) {
            case 0:
                TypeProjection it = (TypeProjection) obj;
                kotlin.jvm.internal.h.f(it, "it");
                if (it.isStarProjection()) {
                    return Marker.ANY_MARKER;
                }
                AbstractC0162z type = it.getType();
                kotlin.jvm.internal.h.e(type, "it.type");
                String strM = this.b.M(type);
                if (it.getProjectionKind() == d0.INVARIANT) {
                    return strM;
                }
                return it.getProjectionKind() + ' ' + strM;
            case 1:
                P2.g it2 = (P2.g) obj;
                kotlin.jvm.internal.h.f(it2, "it");
                return this.b.p(it2);
            default:
                AbstractC0162z it3 = (AbstractC0162z) obj;
                kotlin.jvm.internal.h.e(it3, "it");
                return this.b.M(it3);
        }
    }
}
