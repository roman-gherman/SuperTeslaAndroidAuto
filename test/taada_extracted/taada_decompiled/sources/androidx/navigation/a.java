package androidx.navigation;

import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleOwner;
import android.view.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1649a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1649a = i;
        this.b = obj;
    }

    @Override // android.view.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f1649a) {
            case 0:
                NavController.lifecycleObserver$lambda$2((NavController) this.b, lifecycleOwner, event);
                break;
            default:
                SavedStateRegistry.performAttach$lambda$4((SavedStateRegistry) this.b, lifecycleOwner, event);
                break;
        }
    }
}
