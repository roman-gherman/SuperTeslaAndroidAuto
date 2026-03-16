package androidx.constraintlayout.core.state;

/* JADX INFO: loaded from: classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i, int i3);

    void onNewMotionScene(String str);

    void onProgress(float f6);

    void setDrawDebug(int i);

    void setLayoutInformationMode(int i);
}
