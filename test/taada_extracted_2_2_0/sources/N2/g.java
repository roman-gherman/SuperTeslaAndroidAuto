package N2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f1136a;
    public static final g b;
    public static final g c;
    public static final /* synthetic */ g[] d;

    static {
        g gVar = new g("CONFLICTS_ONLY", 0);
        f1136a = gVar;
        g gVar2 = new g("SUCCESS_ONLY", 1);
        b = gVar2;
        g gVar3 = new g("BOTH", 2);
        c = gVar3;
        d = new g[]{gVar, gVar2, gVar3};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) d.clone();
    }
}
