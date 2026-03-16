package B;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class y extends r {
    public final com.google.android.gms.tasks.c b;

    public y(com.google.android.gms.tasks.c cVar) {
        super(4);
        this.b = cVar;
    }

    @Override // B.z
    public final void a(Status status) {
        this.b.a(new A.a(status));
    }

    @Override // B.z
    public final void b(RuntimeException runtimeException) {
        this.b.a(runtimeException);
    }

    @Override // B.z
    public final void c(m mVar) throws DeadObjectException {
        try {
            h(mVar);
        } catch (DeadObjectException e) {
            a(z.e(e));
            throw e;
        } catch (RemoteException e6) {
            a(z.e(e6));
        } catch (RuntimeException e7) {
            this.b.a(e7);
        }
    }

    @Override // B.z
    public final /* bridge */ /* synthetic */ void d(h hVar, boolean z6) {
    }

    @Override // B.r
    public final boolean f(m mVar) {
        if (mVar.f103f.get(null) == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // B.r
    public final Feature[] g(m mVar) {
        if (mVar.f103f.get(null) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    public final void h(m mVar) {
        if (mVar.f103f.remove(null) != null) {
            throw new ClassCastException();
        }
        this.b.b(Boolean.FALSE);
    }
}
