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
                synchronized (((h) this.c).f4786f) {
                    try {
                        if (((h) this.c).f4790k.get() > 0 && ((h) this.c).f4790k.decrementAndGet() > 0) {
                            ((h) this.c).b.a("Leaving the connection open for other ongoing calls.", new Object[0]);
                            return;
                        }
                        h hVar = (h) this.c;
                        if (hVar.f4792m != null) {
                            hVar.b.a("Unbind from service.", new Object[0]);
                            h hVar2 = (h) this.c;
                            hVar2.f4785a.unbindService(hVar2.f4791l);
                            h hVar3 = (h) this.c;
                            hVar3.f4787g = false;
                            hVar3.f4792m = null;
                            hVar3.f4791l = null;
                        }
                        ((h) this.c).c();
                        return;
                    } finally {
                    }
                }
            default:
                h hVar4 = (h) ((C) this.c).b;
                hVar4.b.a("unlinkToDeath", new Object[0]);
                hVar4.f4792m.asBinder().unlinkToDeath(hVar4.f4789j, 0);
                hVar4.f4792m = null;
                hVar4.f4787g = false;
                return;
        }
    }
}
