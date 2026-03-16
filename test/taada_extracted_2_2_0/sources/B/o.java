package B;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.tasks.OnCompleteListener;
import java.util.Set;
import kotlinx.coroutines.CancellableContinuation;
import m3.AbstractC0684s;
import m3.AbstractC0686u;
import m3.U;
import n3.C0729d;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f109a;
    public Object b;
    public final Object c;

    public /* synthetic */ o(int i, Object obj, Object obj2) {
        this.f109a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor iAccountAccessor;
        switch (this.f109a) {
            case 0:
                p pVar = (p) this.c;
                m mVar = (m) ((d) pVar.f111f).f92j.get((a) pVar.c);
                if (mVar == null) {
                    return;
                }
                ConnectionResult connectionResult = (ConnectionResult) this.b;
                if (!(connectionResult.b == 0)) {
                    mVar.l(connectionResult, null);
                    return;
                }
                pVar.f110a = true;
                Api$Client api$Client = (Api$Client) pVar.b;
                if (api$Client.requiresSignIn()) {
                    if (!pVar.f110a || (iAccountAccessor = (IAccountAccessor) pVar.d) == null) {
                        return;
                    }
                    api$Client.getRemoteService(iAccountAccessor, (Set) pVar.e);
                    return;
                }
                try {
                    api$Client.getRemoteService(null, api$Client.getScopesForConnectionlessNonSignIn());
                    return;
                } catch (SecurityException e) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                    api$Client.disconnect("Failed to get service from broker.");
                    mVar.l(new ConnectionResult(10), null);
                    return;
                }
            case 1:
                synchronized (((com.google.android.gms.tasks.e) this.c).b) {
                    try {
                        OnCompleteListener onCompleteListener = ((com.google.android.gms.tasks.e) this.c).c;
                        if (onCompleteListener != null) {
                            onCompleteListener.onComplete((com.google.android.gms.tasks.b) this.b);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            case 2:
                ((CancellableContinuation) this.c).resumeUndispatched((U) this.b, N1.m.f1129a);
                return;
            case 3:
                ((CancellableContinuation) this.b).resumeUndispatched((C0729d) this.c, N1.m.f1129a);
                return;
            default:
                int i = 0;
                while (true) {
                    try {
                        ((Runnable) this.b).run();
                    } catch (Throwable th2) {
                        AbstractC0686u.a(S1.g.f1282a, th2);
                    }
                    r3.i iVar = (r3.i) this.c;
                    Runnable runnableA = iVar.a();
                    if (runnableA == null) {
                        return;
                    }
                    this.b = runnableA;
                    i++;
                    if (i >= 16) {
                        AbstractC0684s abstractC0684s = iVar.f4712a;
                        if (abstractC0684s.isDispatchNeeded(iVar)) {
                            abstractC0684s.dispatch(iVar, this);
                            return;
                        }
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ o(Object obj, Object obj2, int i, boolean z6) {
        this.f109a = i;
        this.b = obj;
        this.c = obj2;
    }
}
