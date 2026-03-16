package fr.sd.taada.helpers;

import android.content.Context;
import android.os.Handler;
import fr.sd.taada.helpers.MemoryTestRunner;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3280a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Handler c;
    public final /* synthetic */ MemoryTestRunner.TestCallback d;

    public /* synthetic */ g(Context context, Handler handler, MemoryTestRunner.TestCallback testCallback, int i) {
        this.f3280a = i;
        this.b = context;
        this.c = handler;
        this.d = testCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3280a) {
            case 0:
                MemoryTestRunner.lambda$runMemoryStressTest$7(this.b, this.c, this.d);
                break;
            default:
                MemoryTestRunner.lambda$runMemoryDiagnostic$3(this.b, this.c, this.d);
                break;
        }
    }
}
