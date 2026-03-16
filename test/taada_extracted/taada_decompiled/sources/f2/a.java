package F2;

import java.util.LinkedHashMap;
import kotlin.collections.B;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    UNKNOWN(0),
    CLASS(1),
    FILE_FACADE(2),
    SYNTHETIC_CLASS(3),
    MULTIFILE_CLASS(4),
    MULTIFILE_CLASS_PART(5);

    public static final LinkedHashMap b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f351a;

    static {
        a[] aVarArrValues = values();
        int iF = B.F(aVarArrValues.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF < 16 ? 16 : iF);
        for (a aVar : aVarArrValues) {
            linkedHashMap.put(Integer.valueOf(aVar.f351a), aVar);
        }
        b = linkedHashMap;
    }

    a(int i3) {
        this.f351a = i3;
    }
}
