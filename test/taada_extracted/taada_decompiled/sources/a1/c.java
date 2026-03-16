package a1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ c[] f1526a = {new c("GET", 0), new c("PUT", 1), new c("POST", 2), new c("DELETE", 3), new c("HEAD", 4), new c("OPTIONS", 5), new c("TRACE", 6), new c("CONNECT", 7), new c("PATCH", 8), new c("PROPFIND", 9), new c("PROPPATCH", 10), new c("MKCOL", 11), new c("MOVE", 12), new c("COPY", 13), new c("LOCK", 14), new c("UNLOCK", 15)};

    /* JADX INFO: Fake field, exist only in values array */
    c EF5;

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f1526a.clone();
    }
}
