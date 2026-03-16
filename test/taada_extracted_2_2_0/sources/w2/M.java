package w2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public class M {
    public static final M b;
    public static final M c;
    public static final M d;
    public static final L e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ M[] f4992f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4993a;

    static {
        M m6 = new M("NULL", 0, null);
        b = m6;
        M m7 = new M("INDEX", 1, -1);
        c = m7;
        M m8 = new M("FALSE", 2, Boolean.FALSE);
        d = m8;
        L l6 = new L("MAP_GET_OR_DEFAULT", 3, null);
        e = l6;
        f4992f = new M[]{m6, m7, m8, l6};
    }

    public M(String str, int i, Object obj) {
        this.f4993a = obj;
    }

    public static M valueOf(String str) {
        return (M) Enum.valueOf(M.class, str);
    }

    public static M[] values() {
        return (M[]) f4992f.clone();
    }
}
