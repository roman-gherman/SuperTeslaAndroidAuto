package D;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f219a;
    public final /* synthetic */ Object b;

    public /* synthetic */ s(Object obj, int i) {
        this.f219a = i;
        this.b = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f219a) {
            case 0:
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        return false;
                    }
                    synchronized (((t) this.b).f222a) {
                        try {
                            p pVar = (p) message.obj;
                            r rVar = (r) ((t) this.b).f222a.get(pVar);
                            if (rVar != null && rVar.b == 3) {
                                Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(pVar)), new Exception());
                                ComponentName componentName = rVar.f217f;
                                if (componentName == null) {
                                    pVar.getClass();
                                    componentName = null;
                                }
                                if (componentName == null) {
                                    String str = pVar.b;
                                    j.c(str);
                                    componentName = new ComponentName(str, EnvironmentCompat.MEDIA_UNKNOWN);
                                }
                                rVar.onServiceDisconnected(componentName);
                            }
                        } finally {
                        }
                        break;
                    }
                } else {
                    synchronized (((t) this.b).f222a) {
                        try {
                            p pVar2 = (p) message.obj;
                            r rVar2 = (r) ((t) this.b).f222a.get(pVar2);
                            if (rVar2 != null && rVar2.f216a.isEmpty()) {
                                if (rVar2.c) {
                                    rVar2.f218g.c.removeMessages(1, rVar2.e);
                                    t tVar = rVar2.f218g;
                                    tVar.d.a(tVar.b, rVar2);
                                    rVar2.c = false;
                                    rVar2.b = 2;
                                }
                                ((t) this.b).f222a.remove(pVar2);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return true;
            default:
                if (message.what != 0) {
                    return false;
                }
                com.google.android.material.snackbar.f fVar = (com.google.android.material.snackbar.f) this.b;
                if (message.obj != null) {
                    throw new ClassCastException();
                }
                synchronized (fVar.f2591a) {
                    throw null;
                }
        }
    }
}
