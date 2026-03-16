package a3;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: renamed from: a3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0146i extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1552a;
    public final /* synthetic */ AbstractC0147j b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0146i(AbstractC0147j abstractC0147j, int i) {
        super(1);
        this.f1552a = i;
        this.b = abstractC0147j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f1552a) {
            case 0:
                TypeConstructor it = (TypeConstructor) obj;
                kotlin.jvm.internal.h.f(it, "it");
                this.b.getClass();
                AbstractC0147j abstractC0147j = it instanceof AbstractC0147j ? (AbstractC0147j) it : null;
                if (abstractC0147j == null) {
                    Collection<AbstractC0162z> supertypes = it.getSupertypes();
                    kotlin.jvm.internal.h.e(supertypes, "supertypes");
                }
                break;
            case 1:
                AbstractC0162z it2 = (AbstractC0162z) obj;
                kotlin.jvm.internal.h.f(it2, "it");
                this.b.h(it2);
                break;
            default:
                C0144g supertypes2 = (C0144g) obj;
                kotlin.jvm.internal.h.f(supertypes2, "supertypes");
                AbstractC0147j abstractC0147j2 = this.b;
                Collection<AbstractC0162z> collectionFindLoopsInSupertypesAndDisconnect = abstractC0147j2.d().findLoopsInSupertypesAndDisconnect(abstractC0147j2, supertypes2.f1550a, new C0146i(abstractC0147j2, 0), new C0146i(abstractC0147j2, 1));
                if (collectionFindLoopsInSupertypesAndDisconnect.isEmpty()) {
                    AbstractC0162z abstractC0162zB = abstractC0147j2.b();
                    collectionFindLoopsInSupertypesAndDisconnect = abstractC0162zB != null ? io.ktor.utils.io.Z.p(abstractC0162zB) : null;
                    if (collectionFindLoopsInSupertypesAndDisconnect == null) {
                        collectionFindLoopsInSupertypesAndDisconnect = kotlin.collections.u.f3804a;
                    }
                }
                List listO0 = collectionFindLoopsInSupertypesAndDisconnect instanceof List ? (List) collectionFindLoopsInSupertypesAndDisconnect : null;
                if (listO0 == null) {
                    listO0 = kotlin.collections.m.o0(collectionFindLoopsInSupertypesAndDisconnect);
                }
                List listG = abstractC0147j2.g(listO0);
                kotlin.jvm.internal.h.f(listG, "<set-?>");
                supertypes2.b = listG;
                break;
        }
        return N1.m.f1129a;
    }
}
