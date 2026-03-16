package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1633a;
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader b;

    public /* synthetic */ d(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader, int i) {
        this.f1633a = i;
        this.b = fontRequestMetadataLoader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1633a) {
            case 0:
                this.b.createMetadata();
                break;
            default:
                this.b.loadInternal();
                break;
        }
    }
}
