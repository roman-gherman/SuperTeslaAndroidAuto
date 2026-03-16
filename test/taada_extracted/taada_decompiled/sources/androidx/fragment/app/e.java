package androidx.fragment.app;

import android.os.Bundle;
import android.view.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1638a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e(Object obj, int i) {
        this.f1638a = i;
        this.b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.f1638a) {
            case 0:
                return ((FragmentActivity) this.b).lambda$init$0();
            default:
                return ((FragmentManager) this.b).lambda$attachController$4();
        }
    }
}
