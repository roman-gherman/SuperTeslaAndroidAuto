package t0;

import com.android.billingclient.api.C;

/* JADX INFO: loaded from: classes.dex */
public final class g extends d {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ g(Object obj, int i) {
        this.b = i;
        this.c = obj;
    }

    @Override // t0.d
    public final void a() {
        switch (this.b) {
            case 0:
                synchronized (((h) this.c).f4785f) {
                    try {
                        if (((h) this.c).f4789k.get() > 0 && ((h) this.c).f4789k.decrementAndGet() > 0) {
                            ((h) this.c).b.a("Leaving the connection open for other ongoing calls.", new Object[0]);
                            return;
                        }
                        h hVar = (h) this.c;
                        if (hVar.f4791m != null) {
                            hVar.b.a("Unbind from service.", new Object[0]);
                            h hVar2 = (h) this.c;
                            hVar2.f4784a.unbindService(hVar2.f4790l);
                            h hVar3 = (h) this.c;
                            hVar3.f4786g = false;
                            hVar3.f4791m = null;
                            hVar3.f4790l = null;
                        }
                        ((h) this.c).c();
                        return;
                    } finally {
                    }
                }
            default:
                h hVar4 = (h) ((C) this.c).b;
                hVar4.b.a("unlinkToDeath", new Object[0]);
                hVar4.f4791m.asBinder().unlinkToDeath(hVar4.f4788j, 0);
                hVar4.f4791m = null;
                hVar4.f4786g = false;
                return;
        }
    }
}
