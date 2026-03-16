package h2;

import a.AbstractC0132a;
import com.android.multidex.ClassPathElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import m2.C0659k;
import net.bytebuddy.pool.TypePool;
import s2.C0813c;
import t2.AbstractC0823e;

/* JADX INFO: loaded from: classes2.dex */
public final class O extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3377a;
    public final /* synthetic */ P b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ O(P p5, int i) {
        super(0);
        this.f3377a = i;
        this.b = p5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Iterable] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        F2.b bVar;
        String[] strArr;
        String[] strArr2;
        ?? P5;
        switch (this.f3377a) {
            case 0:
                P p5 = this.b;
                p5.getClass();
                KProperty kProperty = P.f3378h[0];
                s2.e eVar = (s2.e) p5.c.invoke();
                if (eVar == null || (strArr = (bVar = eVar.b).c) == null || (strArr2 = bVar.e) == null) {
                    return null;
                }
                N1.e eVarH = K2.h.h(strArr, strArr2);
                return new N1.k((K2.g) eVarH.f1121a, (G2.D) eVarH.b, bVar.b);
            default:
                P p6 = this.b;
                p6.getClass();
                KProperty kProperty2 = P.f3378h[0];
                s2.e eVar2 = (s2.e) p6.c.invoke();
                if (eVar2 == null) {
                    return U2.m.f1338a;
                }
                KProperty kProperty3 = AbstractC0496A.b[0];
                Object objInvoke = p6.f3362a.invoke();
                kotlin.jvm.internal.h.e(objInvoke, "<get-moduleData>(...)");
                B2.d dVar = ((s2.h) objInvoke).b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) dVar.d;
                Class cls = eVar2.f4769a;
                L2.b bVarA = AbstractC0823e.a(cls);
                Object obj = concurrentHashMap.get(bVarA);
                if (obj == null) {
                    L2.c cVarG = AbstractC0823e.a(cls).g();
                    kotlin.jvm.internal.h.e(cVarG, "fileClass.classId.packageFqName");
                    F2.b bVar2 = eVar2.b;
                    F2.a aVar = F2.a.MULTIFILE_CLASS;
                    E2.e eVar3 = (E2.e) dVar.b;
                    F2.a aVar2 = bVar2.f352a;
                    if (aVar2 == aVar) {
                        String[] strArr3 = aVar2 == aVar ? bVar2.c : null;
                        List listT = strArr3 != null ? kotlin.collections.j.t(strArr3) : null;
                        if (listT == null) {
                            listT = kotlin.collections.u.f3805a;
                        }
                        P5 = new ArrayList();
                        Iterator it = listT.iterator();
                        while (it.hasNext()) {
                            KotlinJvmBinaryClass kotlinJvmBinaryClassU = AbstractC0132a.u((C0813c) dVar.c, L2.b.j(new L2.c(S2.a.d((String) it.next()).f1283a.replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH))), j3.p.g(eVar3.c().c));
                            if (kotlinJvmBinaryClassU != null) {
                                P5.add(kotlinJvmBinaryClassU);
                            }
                        }
                    } else {
                        P5 = io.ktor.utils.io.Z.p(eVar2);
                    }
                    C0659k c0659k = new C0659k(eVar3.c().b, cVarG, 1);
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = P5.iterator();
                    while (it2.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m mVarA = eVar3.a(c0659k, (KotlinJvmBinaryClass) it2.next());
                        if (mVarA != null) {
                            arrayList.add(mVarA);
                        }
                    }
                    MemberScope memberScopeR = E1.k.r("package " + cVarG + " (" + eVar2 + ')', kotlin.collections.m.o0(arrayList));
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(bVarA, memberScopeR);
                    obj = objPutIfAbsent == null ? memberScopeR : objPutIfAbsent;
                }
                kotlin.jvm.internal.h.e(obj, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
                return (MemberScope) obj;
        }
    }
}
