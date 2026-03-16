package u5;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.instantiator.ObjectInstantiator;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ObjectInstantiator {
    public static Method c;
    public static v5.a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4892a;
    public final Object b;

    public c(Class cls, int i) {
        this.f4892a = i;
        switch (i) {
            case 1:
                this.b = cls;
                if (c == null) {
                    try {
                        Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newObject", Class.class, Class.class);
                        c = declaredMethod;
                        declaredMethod.setAccessible(true);
                        d = new v5.a();
                        return;
                    } catch (IOException | NoSuchMethodException | RuntimeException e) {
                        throw new r5.a(e);
                    }
                }
                return;
            default:
                if (!Serializable.class.isAssignableFrom(cls)) {
                    throw new r5.a(new NotSerializableException(cls + " not serializable"));
                }
                try {
                    this.b = new ObjectInputStream(new b(cls));
                    return;
                } catch (IOException e6) {
                    throw new Error("IOException: " + e6.getMessage());
                }
        }
    }

    @Override // org.objenesis.instantiator.ObjectInstantiator
    public final Object newInstance() {
        switch (this.f4892a) {
            case 0:
                try {
                    return ((ObjectInputStream) this.b).readObject();
                } catch (ClassNotFoundException e) {
                    throw new Error("ClassNotFoundException: " + e.getMessage());
                } catch (Exception e6) {
                    throw new r5.a(e6);
                }
            default:
                try {
                    Class cls = (Class) this.b;
                    return cls.cast(c.invoke(d, cls, Object.class));
                } catch (IllegalAccessException | RuntimeException | InvocationTargetException e7) {
                    throw new r5.a(e7);
                }
        }
    }
}
