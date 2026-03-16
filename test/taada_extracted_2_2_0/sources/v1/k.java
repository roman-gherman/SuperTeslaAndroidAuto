package v1;

import u1.t;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ k[] f4932a;

    /* JADX INFO: Fake field, exist only in values array */
    k EF7;

    static {
        t tVar = t.c;
        f4932a = new k[]{new k("OK", 0), new k("NOT_MODIFIED", 1), new k("PRECONDITION_FAILED", 2)};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f4932a.clone();
    }
}
