package fr.sd.taada.helpers;

import fr.sd.taada.helpers.MemoryTestRunner;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3280a;
    public final /* synthetic */ MemoryTestRunner.TestCallback b;

    public /* synthetic */ f(MemoryTestRunner.TestCallback testCallback, int i) {
        this.f3280a = i;
        this.b = testCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3280a) {
            case 0:
                MemoryTestRunner.lambda$runMemoryDiagnostic$1(this.b);
                break;
            case 1:
                MemoryTestRunner.lambda$runMemoryCleanup$10(this.b);
                break;
            case 2:
                MemoryTestRunner.lambda$runMemoryDiagnostic$2(this.b);
                break;
            case 3:
                MemoryTestRunner.lambda$runMemoryStressTest$5(this.b);
                break;
            case 4:
                MemoryTestRunner.lambda$runMemoryStressTest$6(this.b);
                break;
            case 5:
                MemoryTestRunner.lambda$runMemoryCleanup$8(this.b);
                break;
            case 6:
                MemoryTestRunner.lambda$runMemoryStressTest$4(this.b);
                break;
            default:
                MemoryTestRunner.lambda$runMemoryDiagnostic$0(this.b);
                break;
        }
    }
}
