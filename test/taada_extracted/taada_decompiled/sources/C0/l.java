package C0;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final l b = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f147a = new AtomicReference(new w(new t(0)));

    public final com.google.crypto.tink.b a(r rVar) {
        com.google.crypto.tink.n nVar = com.google.crypto.tink.n.f2805a;
        AtomicReference atomicReference = this.f147a;
        w wVar = (w) atomicReference.get();
        wVar.getClass();
        I0.a aVar = rVar.b;
        if (!wVar.b.containsKey(new u(r.class, aVar))) {
            try {
                f fVar = new f();
                rVar.d.ordinal();
                return fVar;
            } catch (GeneralSecurityException e) {
                throw new x("Creating a LegacyProtoKey failed", e);
            }
        }
        w wVar2 = (w) atomicReference.get();
        wVar2.getClass();
        u uVar = new u(r.class, aVar);
        HashMap map = wVar2.b;
        if (map.containsKey(uVar)) {
            return ((a) map.get(uVar)).b.parseKey(rVar, nVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + uVar + " available");
    }

    public final synchronized void b(a aVar) {
        t tVar = new t((w) this.f147a.get());
        tVar.l(aVar);
        this.f147a.set(new w(tVar));
    }

    public final synchronized void c(b bVar) {
        t tVar = new t((w) this.f147a.get());
        tVar.m(bVar);
        this.f147a.set(new w(tVar));
    }

    public final synchronized void d(m mVar) {
        t tVar = new t((w) this.f147a.get());
        tVar.n(mVar);
        this.f147a.set(new w(tVar));
    }

    public final synchronized void e(n nVar) {
        t tVar = new t((w) this.f147a.get());
        tVar.o(nVar);
        this.f147a.set(new w(tVar));
    }
}
