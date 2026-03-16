package a3;

/* JADX INFO: loaded from: classes2.dex */
public enum d0 {
    INVARIANT("", true),
    IN_VARIANCE("in", false),
    OUT_VARIANCE("out", true);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1547a;
    public final boolean b;

    d0(String str, boolean z6) {
        this.f1547a = str;
        this.b = z6;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f1547a;
    }
}
