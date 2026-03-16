package X0;

import C0.t;
import androidx.room.QueryInterceptorDatabase;
import androidx.work.WorkRequest;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.m;
import com.tenjin.android.store.QueueEventDao;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1409a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ g(Object obj, Object obj2, Object obj3, int i) {
        this.f1409a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1409a) {
            case 0:
                t tVar = (t) this.b;
                Map map = (Map) this.c;
                ((R0.d) this.d).onEventsLoaded(((QueueEventDao) tVar.b).getEventsFromParams(map == null ? null : new m().h(map)));
                break;
            case 1:
                QueryInterceptorDatabase.query$lambda$7((QueryInterceptorDatabase) this.b, (String) this.c, (Object[]) this.d);
                break;
            case 2:
                QueryInterceptorDatabase.execSQL$lambda$12((QueryInterceptorDatabase) this.b, (String) this.c, (P1.b) this.d);
                break;
            case 3:
                ((Processor) this.b).lambda$startWork$1((ListenableFuture) this.c, (WorkerWrapper) this.d);
                break;
            default:
                WorkerUpdater.updateWorkImpl$lambda$3((SettableFuture) this.b, (WorkManagerImpl) this.c, (WorkRequest) this.d);
                break;
        }
    }
}
