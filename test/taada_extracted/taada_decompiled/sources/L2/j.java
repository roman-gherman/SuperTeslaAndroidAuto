package L2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.B;
import kotlin.collections.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    static {
        new c("java.lang").c(f.e("annotation"));
    }

    public static final b a(String str) {
        c cVar = i.f967a;
        return new b(i.f967a, f.e(str));
    }

    public static final b b(String str) {
        c cVar = i.f967a;
        return new b(i.c, f.e(str));
    }

    public static final LinkedHashMap c(LinkedHashMap linkedHashMap) {
        Set<Map.Entry> setEntrySet = linkedHashMap.entrySet();
        int iF = B.F(o.D(setEntrySet));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iF);
        for (Map.Entry entry : setEntrySet) {
            linkedHashMap2.put(entry.getValue(), entry.getKey());
        }
        return linkedHashMap2;
    }

    public static final b d(f fVar) {
        c cVar = i.f967a;
        b bVar = i.f970h;
        return new b(bVar.g(), f.e(fVar.c().concat(bVar.i().c())));
    }

    public static final b e(String str) {
        c cVar = i.f967a;
        return new b(i.b, f.e(str));
    }

    public static final b f(b bVar) {
        c cVar = i.f967a;
        return new b(i.f967a, f.e("U".concat(bVar.i().c())));
    }
}
