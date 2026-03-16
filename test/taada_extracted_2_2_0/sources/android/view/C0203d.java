package android.view;

import android.view.Lifecycle;
import kotlinx.coroutines.channels.ProducerScope;
import p3.z;

/* JADX INFO: renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0203d implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1646a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0203d(Object obj, int i) {
        this.f1646a = i;
        this.b = obj;
    }

    @Override // android.view.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f1646a) {
            case 0:
                ((ProducerScope) this.b).mo106trySendJP2dKIU(event);
                break;
            default:
                Lifecycle._get_currentStateFlow_$lambda$0((z) this.b, lifecycleOwner, event);
                break;
        }
    }
}
