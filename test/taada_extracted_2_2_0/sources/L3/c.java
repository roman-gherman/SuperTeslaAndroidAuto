package L3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f981a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final /* synthetic */ c[] e;

    /* JADX INFO: Fake field, exist only in values array */
    c EF0;

    static {
        c cVar = new c("AGREEMENT", 0);
        c cVar2 = new c("ENCRYPTION", 1);
        f981a = cVar2;
        c cVar3 = new c("DECRYPTION", 2);
        b = cVar3;
        c cVar4 = new c("KEYGEN", 3);
        c cVar5 = new c("SIGNING", 4);
        c cVar6 = new c("VERIFYING", 5);
        c cVar7 = new c("AUTHENTICATION", 6);
        c cVar8 = new c("VERIFICATION", 7);
        c cVar9 = new c("PRF", 8);
        c = cVar9;
        c cVar10 = new c("ANY", 9);
        d = cVar10;
        e = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9, cVar10};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) e.clone();
    }
}
