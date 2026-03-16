package I2;

import C0.x;
import G2.T;
import G2.U;
import G2.b0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f790a;

    public f(b0 typeTable) {
        h.f(typeTable, "typeTable");
        List list = typeTable.c;
        if ((typeTable.b & 1) == 1) {
            int i = typeTable.d;
            h.e(list, "typeTable.typeList");
            ArrayList arrayList = new ArrayList(o.D(list));
            int i3 = 0;
            for (Object obj : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    n.C();
                    throw null;
                }
                U uC = (U) obj;
                if (i3 >= i) {
                    uC.getClass();
                    T tK = U.k(uC);
                    tK.d |= 2;
                    tK.f481f = true;
                    uC = tK.c();
                    if (!uC.isInitialized()) {
                        throw new x();
                    }
                }
                arrayList.add(uC);
                i3 = i4;
            }
            list = arrayList;
        }
        h.e(list, "run {\n        val origin… else originalTypes\n    }");
        this.f790a = list;
    }

    public final U a(int i) {
        return (U) this.f790a.get(i);
    }
}
