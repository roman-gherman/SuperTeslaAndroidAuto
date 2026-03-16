package kotlin.reflect;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f3824a;
    public static final e b;
    public static final e c;
    public static final /* synthetic */ e[] d;

    static {
        e eVar = new e("INVARIANT", 0);
        f3824a = eVar;
        e eVar2 = new e("IN", 1);
        b = eVar2;
        e eVar3 = new e("OUT", 2);
        c = eVar3;
        d = new e[]{eVar, eVar2, eVar3};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) d.clone();
    }
}
