package M2;

/* JADX INFO: renamed from: M2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC0126a {
    NO_ARGUMENTS(3),
    /* JADX INFO: Fake field, exist only in values array */
    UNLESS_EMPTY(2),
    /* JADX INFO: Fake field, exist only in values array */
    ALWAYS_PARENTHESIZED(true, true);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1047a;
    public final boolean b;

    /* synthetic */ EnumC0126a(int i) {
        this((i & 1) == 0, false);
    }

    EnumC0126a(boolean z6, boolean z7) {
        this.f1047a = z6;
        this.b = z7;
    }
}
