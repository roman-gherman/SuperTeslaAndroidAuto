package x5;

import org.objenesis.instantiator.ObjectInstantiator;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ObjectInstantiator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Unsafe f5127a = y5.a.f5158a;
    public final Class b;

    public a(Class cls) {
        this.b = cls;
    }

    @Override // org.objenesis.instantiator.ObjectInstantiator
    public final Object newInstance() {
        try {
            Class cls = this.b;
            return cls.cast(this.f5127a.allocateInstance(cls));
        } catch (InstantiationException e) {
            throw new r5.a(e);
        }
    }
}
