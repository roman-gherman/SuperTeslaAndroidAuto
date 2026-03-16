package B;

import com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener;

/* JADX INFO: loaded from: classes.dex */
public final class j implements BackgroundDetector$BackgroundStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f99a;

    public j(d dVar) {
        this.f99a = dVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z6) {
        O.e eVar = this.f99a.f95m;
        eVar.sendMessage(eVar.obtainMessage(1, Boolean.valueOf(z6)));
    }
}
