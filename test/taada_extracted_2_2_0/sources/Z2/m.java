package Z2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f1501a;
    public static final m b;
    public static final m c;
    public static final /* synthetic */ m[] d;

    static {
        m mVar = new m("NOT_COMPUTED", 0);
        f1501a = mVar;
        m mVar2 = new m("COMPUTING", 1);
        b = mVar2;
        m mVar3 = new m("RECURSION_WAS_DETECTED", 2);
        c = mVar3;
        d = new m[]{mVar, mVar2, mVar3};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) d.clone();
    }
}
