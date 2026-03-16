package kotlin.reflect;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3820a;
    public static final b b;
    public static final b c;
    public static final /* synthetic */ b[] d;

    static {
        b bVar = new b("INSTANCE", 0);
        f3820a = bVar;
        b bVar2 = new b("EXTENSION_RECEIVER", 1);
        b = bVar2;
        b bVar3 = new b("VALUE", 2);
        c = bVar3;
        d = new b[]{bVar, bVar2, bVar3};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) d.clone();
    }
}
