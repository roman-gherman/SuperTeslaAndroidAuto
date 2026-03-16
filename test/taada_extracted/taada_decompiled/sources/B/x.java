package B;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class x extends r {
    public final w b;
    public final com.google.android.gms.tasks.c c;
    public final n0.d d;

    public x(w wVar, com.google.android.gms.tasks.c cVar, n0.d dVar) {
        super(2);
        this.c = cVar;
        this.b = wVar;
        this.d = dVar;
        if (wVar.b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // B.z
    public final void a(Status status) {
        this.c.a(this.d.getException(status));
    }

    @Override // B.z
    public final void b(RuntimeException runtimeException) {
        this.c.a(runtimeException);
    }

    @Override // B.z
    public final void c(m mVar) throws DeadObjectException {
        com.google.android.gms.tasks.c cVar = this.c;
        try {
            w wVar = this.b;
            ((g) ((g) wVar.d).b).accept(mVar.b, cVar);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e6) {
            a(z.e(e6));
        } catch (RuntimeException e7) {
            cVar.a(e7);
        }
    }

    @Override // B.z
    public final void d(h hVar, boolean z6) {
        Boolean boolValueOf = Boolean.valueOf(z6);
        Map map = (Map) hVar.c;
        com.google.android.gms.tasks.c cVar = this.c;
        map.put(cVar, boolValueOf);
        cVar.f2174a.a(new h(0, hVar, cVar));
    }

    @Override // B.r
    public final boolean f(m mVar) {
        return this.b.b;
    }

    @Override // B.r
    public final Feature[] g(m mVar) {
        return (Feature[]) this.b.c;
    }
}
