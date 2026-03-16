package o2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f4293a;
    public static final k b;
    public static final k c;
    public static final /* synthetic */ k[] d;

    static {
        k kVar = new k("RUNTIME", 0);
        f4293a = kVar;
        k kVar2 = new k("BINARY", 1);
        b = kVar2;
        k kVar3 = new k("SOURCE", 2);
        c = kVar3;
        d = new k[]{kVar, kVar2, kVar3};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) d.clone();
    }
}
