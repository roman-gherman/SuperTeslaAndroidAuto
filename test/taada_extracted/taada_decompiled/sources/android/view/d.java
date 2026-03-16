package android.view;

import android.view.ComponentActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1569a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i) {
        this.f1569a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1569a) {
            case 0:
                ((ComponentActivity.ReportFullyDrawnExecutorApi16Impl) this.b).lambda$execute$0();
                break;
            case 1:
                ((ComponentActivity) this.b).invalidateMenu();
                break;
            case 2:
                ComponentDialog.onBackPressedDispatcher$lambda$1((ComponentDialog) this.b);
                break;
            default:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) this.b);
                break;
        }
    }
}
