package Z3;

import java.security.PrivilegedAction;
import java.security.Provider;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1504a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ c d;

    public a(c cVar, String str, String str2, String str3) {
        this.d = cVar;
        this.f1504a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        c cVar = this.d;
        Provider.Service service = super/*java.security.Provider*/.getService(this.f1504a, this.b);
        if (service == null || service.getClassName() == null) {
            return null;
        }
        cVar.f1513a.put(this.c, service);
        cVar.remove(service.getType() + "." + service.getAlgorithm());
        cVar.putService(service);
        return service;
    }
}
