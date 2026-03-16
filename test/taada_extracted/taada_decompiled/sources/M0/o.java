package M0;

import com.google.gson.E;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class o extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1014a;

    public o(LinkedHashMap linkedHashMap) {
        this.f1014a = linkedHashMap;
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        if (bVar.w() == 9) {
            bVar.s();
            return null;
        }
        Object objC = c();
        try {
            bVar.b();
            while (bVar.j()) {
                n nVar = (n) this.f1014a.get(bVar.q());
                if (nVar == null || !nVar.e) {
                    bVar.C();
                } else {
                    e(objC, bVar, nVar);
                }
            }
            bVar.f();
            return d(objC);
        } catch (IllegalAccessException e) {
            E1.k kVar = O0.c.f1177a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        } catch (IllegalStateException e6) {
            throw new com.google.gson.w(e6);
        }
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.i();
            return;
        }
        cVar.c();
        try {
            Iterator it = this.f1014a.values().iterator();
            while (it.hasNext()) {
                ((n) it.next()).a(cVar, obj);
            }
            cVar.f();
        } catch (IllegalAccessException e) {
            E1.k kVar = O0.c.f1177a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
        }
    }

    public abstract Object c();

    public abstract Object d(Object obj);

    public abstract void e(Object obj, com.google.gson.stream.b bVar, n nVar);
}
