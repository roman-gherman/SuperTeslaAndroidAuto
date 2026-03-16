package s5;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.objenesis.instantiator.ObjectInstantiator;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ObjectInstantiator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4778a;
    public final Method b;
    public final Serializable c;

    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Serializable, java.lang.Object[]] */
    public a(Class cls, int i) {
        this.f4778a = i;
        switch (i) {
            case 1:
                ?? r42 = {null, Boolean.FALSE};
                this.c = r42;
                r42[0] = cls;
                try {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, Class.class, Boolean.TYPE);
                    this.b = declaredMethod;
                    declaredMethod.setAccessible(true);
                    return;
                } catch (NoSuchMethodException | RuntimeException e) {
                    throw new r5.a(e);
                }
            default:
                this.c = cls;
                try {
                    Method declaredMethod2 = ObjectInputStream.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, Class.class, Class.class);
                    declaredMethod2.setAccessible(true);
                    this.b = declaredMethod2;
                    return;
                } catch (NoSuchMethodException | RuntimeException e6) {
                    throw new r5.a(e6);
                }
        }
    }

    @Override // org.objenesis.instantiator.ObjectInstantiator
    public final Object newInstance() {
        switch (this.f4778a) {
            case 0:
                try {
                    Class cls = (Class) this.c;
                    return cls.cast(this.b.invoke(null, cls, Object.class));
                } catch (Exception e) {
                    throw new r5.a(e);
                }
            default:
                try {
                    return this.b.invoke(null, (Object[]) this.c);
                } catch (Exception e6) {
                    throw new r5.a(e6);
                }
        }
    }
}
