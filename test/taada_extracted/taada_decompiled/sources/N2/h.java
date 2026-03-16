package N2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f1137a;
    public static final h b;
    public static final h c;
    public static final /* synthetic */ h[] d;

    static {
        h hVar = new h("OVERRIDABLE", 0);
        f1137a = hVar;
        h hVar2 = new h("CONFLICT", 1);
        h hVar3 = new h("INCOMPATIBLE", 2);
        b = hVar3;
        h hVar4 = new h("UNKNOWN", 3);
        c = hVar4;
        d = new h[]{hVar, hVar2, hVar3, hVar4};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) d.clone();
    }
}
