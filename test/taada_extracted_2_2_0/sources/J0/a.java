package J0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f825a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final /* synthetic */ a[] e;

    static {
        a aVar = new a("PUBLIC", 0);
        f825a = aVar;
        a aVar2 = new a("PROTECTED", 1);
        a aVar3 = new a("PRIVATE", 2);
        b = aVar3;
        a aVar4 = new a("ABSTRACT", 3);
        a aVar5 = new a("DEFAULT", 4);
        a aVar6 = new a("STATIC", 5);
        c = aVar6;
        a aVar7 = new a("FINAL", 6);
        d = aVar7;
        e = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new a("TRANSIENT", 7), new a("VOLATILE", 8), new a("SYNCHRONIZED", 9), new a("NATIVE", 10), new a("STRICTFP", 11)};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) e.clone();
    }
}
