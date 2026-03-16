package androidx.test.internal.platform.content;

/* JADX INFO: loaded from: classes.dex */
public interface PermissionGranter {
    void addPermissions(String... strArr);

    void requestPermissions();
}
