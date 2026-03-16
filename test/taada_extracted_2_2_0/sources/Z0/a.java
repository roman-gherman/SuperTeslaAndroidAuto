package Z0;

import android.os.Handler;
import android.os.HandlerThread;
import com.tenjin.android.utils.threading.IThreading;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends HandlerThread implements IThreading {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f1495a;

    @Override // com.tenjin.android.utils.threading.IThreading
    public final void post(Runnable runnable) {
        if (this.f1495a == null) {
            this.f1495a = new Handler(getLooper());
        }
        this.f1495a.post(runnable);
    }
}
