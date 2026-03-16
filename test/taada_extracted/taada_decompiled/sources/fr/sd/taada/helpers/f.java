package fr.sd.taada.helpers;

import fr.sd.taada.helpers.MemoryTestRunner;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3279a;
    public final /* synthetic */ MemoryTestRunner.TestCallback b;

    public /* synthetic */ f(MemoryTestRunner.TestCallback testCallback, int i) {
        this.f3279a = i;
        this.b = testCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3279a) {
            case 0:
                this.b.onTestComplete("✅ Diagnostic mémoire terminé");
                break;
            case 1:
                this.b.onTestError("❌ Test interrompu");
                break;
            case 2:
                this.b.onTestError("❌ Erreur lors du diagnostic");
                break;
            case 3:
                this.b.onTestComplete("✅ Stress test terminé");
                break;
            case 4:
                this.b.onTestError("❌ Erreur lors du stress test");
                break;
            case 5:
                this.b.onTestStart("🧹 Nettoyage mémoire...");
                break;
            case 6:
                this.b.onTestStart("⚡ Stress test mémoire en cours...");
                break;
            default:
                this.b.onTestStart("🔍 Diagnostic mémoire en cours...");
                break;
        }
    }
}
