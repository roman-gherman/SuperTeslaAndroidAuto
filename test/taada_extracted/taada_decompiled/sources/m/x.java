package m;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f4018a;
    public static final /* synthetic */ x[] b;

    static {
        x xVar = new x("DEFAULT", 0);
        f4018a = xVar;
        x xVar2 = new x("UNMETERED_ONLY", 1);
        x xVar3 = new x("UNMETERED_OR_DAILY", 2);
        x xVar4 = new x("FAST_IF_RADIO_AWAKE", 3);
        x xVar5 = new x("NEVER", 4);
        x xVar6 = new x("UNRECOGNIZED", 5);
        b = new x[]{xVar, xVar2, xVar3, xVar4, xVar5, xVar6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, xVar);
        sparseArray.put(1, xVar2);
        sparseArray.put(2, xVar3);
        sparseArray.put(3, xVar4);
        sparseArray.put(4, xVar5);
        sparseArray.put(-1, xVar6);
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) b.clone();
    }
}
