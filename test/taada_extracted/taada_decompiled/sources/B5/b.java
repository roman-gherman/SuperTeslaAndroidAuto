package B5;

/* JADX INFO: loaded from: classes.dex */
public enum b {
    ERROR("ERROR"),
    WARN("WARN"),
    INFO("INFO"),
    DEBUG("DEBUG"),
    TRACE("TRACE");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f134a;

    b(String str) {
        this.f134a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f134a;
    }
}
