package s5;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.objenesis.instantiator.ObjectInstantiator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ObjectInstantiator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4778a;
    public final Class b;
    public final Method c;
    public final Number d;

    public b(Class cls, int i) {
        this.f4778a = i;
        switch (i) {
            case 1:
                this.b = cls;
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, Class.class, Long.TYPE);
                    declaredMethod.setAccessible(true);
                    this.c = declaredMethod;
                    try {
                        Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                        declaredMethod2.setAccessible(true);
                        this.d = (Long) declaredMethod2.invoke(null, Object.class);
                        return;
                    } catch (IllegalAccessException | NoSuchMethodException | RuntimeException | InvocationTargetException e) {
                        throw new r5.a(e);
                    }
                } catch (NoSuchMethodException | RuntimeException e6) {
                    throw new r5.a(e6);
                }
            default:
                this.b = cls;
                try {
                    Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, Class.class, Integer.TYPE);
                    declaredMethod3.setAccessible(true);
                    this.c = declaredMethod3;
                    try {
                        Method declaredMethod4 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                        declaredMethod4.setAccessible(true);
                        this.d = (Integer) declaredMethod4.invoke(null, Object.class);
                        return;
                    } catch (IllegalAccessException | NoSuchMethodException | RuntimeException | InvocationTargetException e7) {
                        throw new r5.a(e7);
                    }
                } catch (NoSuchMethodException | RuntimeException e8) {
                    throw new r5.a(e8);
                }
        }
    }

    @Override // org.objenesis.instantiator.ObjectInstantiator
    public final Object newInstance() {
        switch (this.f4778a) {
            case 0:
                try {
                    Class cls = this.b;
                    return cls.cast(this.c.invoke(null, cls, (Integer) this.d));
                } catch (Exception e) {
                    throw new r5.a(e);
                }
            default:
                try {
                    Class cls2 = this.b;
                    return cls2.cast(this.c.invoke(null, cls2, (Long) this.d));
                } catch (Exception e6) {
                    throw new r5.a(e6);
                }
        }
    }
}
