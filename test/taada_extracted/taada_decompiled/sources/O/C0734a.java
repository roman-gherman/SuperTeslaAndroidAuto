package o;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: renamed from: o.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0734a implements Provider, Lazy {
    public static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Factory f4266a;
    public volatile Object b;

    public static Provider a(Factory factory) {
        if (factory instanceof C0734a) {
            return factory;
        }
        C0734a c0734a = new C0734a();
        c0734a.b = c;
        c0734a.f4266a = factory;
        return c0734a;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Object obj;
        Object obj2 = this.b;
        Object obj3 = c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.b;
                if (obj == obj3) {
                    obj = this.f4266a.get();
                    Object obj4 = this.b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.b = obj;
                    this.f4266a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
