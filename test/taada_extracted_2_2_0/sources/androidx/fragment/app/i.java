package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1642a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ SpecialEffectsController.Operation c;

    public /* synthetic */ i(Object obj, SpecialEffectsController.Operation operation, int i) {
        this.f1642a = i;
        this.b = obj;
        this.c = operation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1642a) {
            case 0:
                SpecialEffectsController.enqueue$lambda$4$lambda$2((SpecialEffectsController) this.b, (SpecialEffectsController.FragmentStateManagerOperation) this.c);
                break;
            case 1:
                SpecialEffectsController.enqueue$lambda$4$lambda$3((SpecialEffectsController) this.b, (SpecialEffectsController.FragmentStateManagerOperation) this.c);
                break;
            default:
                DefaultSpecialEffectsController.startTransitions$lambda$14$lambda$13((DefaultSpecialEffectsController.TransitionInfo) this.b, this.c);
                break;
        }
    }
}
