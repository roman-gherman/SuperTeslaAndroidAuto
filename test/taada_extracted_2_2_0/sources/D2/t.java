package D2;

import A2.C0022d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.B;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f264a;
    public final ArrayList b = new ArrayList();
    public N1.e c = new N1.e("V", null);

    public t(B.h hVar, String str) {
        this.f264a = str;
    }

    public final void a(String type, e... eVarArr) {
        v vVar;
        kotlin.jvm.internal.h.f(type, "type");
        ArrayList arrayList = this.b;
        if (eVarArr.length == 0) {
            vVar = null;
        } else {
            k3.q qVar = new k3.q(new C0022d(eVarArr, 23));
            int iF = B.F(kotlin.collections.o.D(qVar));
            if (iF < 16) {
                iF = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
            Iterator it = qVar.iterator();
            while (true) {
                k3.b bVar = (k3.b) it;
                if (!bVar.c.hasNext()) {
                    break;
                }
                kotlin.collections.x xVar = (kotlin.collections.x) bVar.next();
                linkedHashMap.put(Integer.valueOf(xVar.f3808a), (e) xVar.b);
            }
            vVar = new v(linkedHashMap);
        }
        arrayList.add(new N1.e(type, vVar));
    }

    public final void b(S2.b type) {
        kotlin.jvm.internal.h.f(type, "type");
        String strC = type.c();
        kotlin.jvm.internal.h.e(strC, "type.desc");
        this.c = new N1.e(strC, null);
    }

    public final void c(String type, e... eVarArr) {
        kotlin.jvm.internal.h.f(type, "type");
        k3.q qVar = new k3.q(new C0022d(eVarArr, 23));
        int iF = B.F(kotlin.collections.o.D(qVar));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        Iterator it = qVar.iterator();
        while (true) {
            k3.b bVar = (k3.b) it;
            if (!bVar.c.hasNext()) {
                this.c = new N1.e(type, new v(linkedHashMap));
                return;
            } else {
                kotlin.collections.x xVar = (kotlin.collections.x) bVar.next();
                linkedHashMap.put(Integer.valueOf(xVar.f3808a), (e) xVar.b);
            }
        }
    }
}
