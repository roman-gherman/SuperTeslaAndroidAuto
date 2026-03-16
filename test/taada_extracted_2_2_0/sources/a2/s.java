package A2;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import com.android.multidex.ClassPathElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f65a;
    public final /* synthetic */ t b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(t tVar, int i) {
        super(0);
        this.f65a = i;
        this.b = tVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f65a) {
            case 0:
                t tVar = this.b;
                List<String> listFindPackageParts = tVar.f68h.f5204a.f5190l.findPackageParts(tVar.e.b());
                ArrayList arrayList = new ArrayList();
                for (String str : listFindPackageParts) {
                    KotlinJvmBinaryClass kotlinJvmBinaryClassU = AbstractC0132a.u(tVar.f68h.f5204a.c, L2.b.j(new L2.c(S2.a.d(str).f1283a.replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH))), tVar.i);
                    N1.e eVar = kotlinJvmBinaryClassU != null ? new N1.e(str, kotlinJvmBinaryClassU) : null;
                    if (eVar != null) {
                        arrayList.add(eVar);
                    }
                }
                return kotlin.collections.A.L(arrayList);
            case 1:
                HashMap map = new HashMap();
                t tVar2 = this.b;
                tVar2.getClass();
                for (Map.Entry entry : ((Map) AbstractC0246d.T(tVar2.f69j, t.f66o[0])).entrySet()) {
                    String str2 = (String) entry.getKey();
                    KotlinJvmBinaryClass kotlinJvmBinaryClass = (KotlinJvmBinaryClass) entry.getValue();
                    S2.a aVarD = S2.a.d(str2);
                    F2.b classHeader = kotlinJvmBinaryClass.getClassHeader();
                    int iOrdinal = classHeader.f352a.ordinal();
                    if (iOrdinal == 2) {
                        map.put(aVarD, aVarD);
                    } else if (iOrdinal == 5) {
                        String str3 = classHeader.f352a == F2.a.MULTIFILE_CLASS_PART ? classHeader.f353f : null;
                        if (str3 != null) {
                            map.put(aVarD, S2.a.d(str3));
                        }
                    }
                }
                return map;
            default:
                Collection<JavaPackage> subPackages = this.b.f67g.getSubPackages();
                ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(subPackages));
                Iterator<T> it = subPackages.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((JavaPackage) it.next()).getFqName());
                }
                return arrayList2;
        }
    }
}
