package a2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: a2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0135a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnumC0135a[] f1527a = {new EnumC0135a("CONTINUE", 0), new EnumC0135a("SKIP_SUBTREE", 1), new EnumC0135a("TERMINATE", 2)};

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0135a EF5;

    public static EnumC0135a valueOf(String str) {
        return (EnumC0135a) Enum.valueOf(EnumC0135a.class, str);
    }

    public static EnumC0135a[] values() {
        return (EnumC0135a[]) f1527a.clone();
    }
}
