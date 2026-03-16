package v;

import B2.b;
import android.util.SparseArray;
import java.util.HashMap;
import k.d;

/* JADX INFO: renamed from: v.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0846a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f4893a = new SparseArray();
    public static final HashMap b;

    static {
        HashMap map = new HashMap();
        b = map;
        map.put(d.f3677a, 0);
        map.put(d.b, 1);
        map.put(d.c, 2);
        for (d dVar : map.keySet()) {
            f4893a.append(((Integer) b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i) {
        d dVar = (d) f4893a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(b.c(i, "Unknown Priority for value "));
    }
}
