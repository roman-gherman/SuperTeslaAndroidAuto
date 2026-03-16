package n;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class h implements BackendRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B.h f4162a;
    public final g b;
    public final HashMap c;

    public h(Context context, g gVar) {
        B.h hVar = new B.h(context);
        this.c = new HashMap();
        this.f4162a = hVar;
        this.b = gVar;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRegistry
    public final synchronized TransportBackend get(String str) {
        if (this.c.containsKey(str)) {
            return (TransportBackend) this.c.get(str);
        }
        BackendFactory backendFactoryF = this.f4162a.f(str);
        if (backendFactoryF == null) {
            return null;
        }
        g gVar = this.b;
        TransportBackend transportBackendCreate = backendFactoryF.create(new c(gVar.f4161a, gVar.b, gVar.c, str));
        this.c.put(str, transportBackendCreate);
        return transportBackendCreate;
    }
}
