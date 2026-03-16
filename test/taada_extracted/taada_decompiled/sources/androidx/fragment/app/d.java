package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1637a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ d(Object obj, View view, Object obj2, int i) {
        this.f1637a = i;
        this.b = obj;
        this.c = view;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1637a) {
            case 0:
                DefaultSpecialEffectsController.AnonymousClass3.onAnimationEnd$lambda$0((DefaultSpecialEffectsController) this.b, (View) this.c, (DefaultSpecialEffectsController.AnimationInfo) this.d);
                break;
            case 1:
                DefaultSpecialEffectsController.executeOperations$lambda$2((ArrayList) this.c, (SpecialEffectsController.Operation) this.d, (DefaultSpecialEffectsController) this.b);
                break;
            default:
                DefaultSpecialEffectsController.startTransitions$lambda$10((FragmentTransitionImpl) this.b, (View) this.c, (Rect) this.d);
                break;
        }
    }

    public /* synthetic */ d(ArrayList arrayList, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController) {
        this.f1637a = 1;
        this.c = arrayList;
        this.d = operation;
        this.b = defaultSpecialEffectsController;
    }
}
