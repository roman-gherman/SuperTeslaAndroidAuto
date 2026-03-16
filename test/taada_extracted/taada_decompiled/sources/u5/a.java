package u5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.objenesis.instantiator.ObjectInstantiator;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ObjectInstantiator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4888a = 0;
    public Constructor b;

    public /* synthetic */ a() {
    }

    @Override // org.objenesis.instantiator.ObjectInstantiator
    public final Object newInstance() {
        switch (this.f4888a) {
            case 0:
                try {
                    return this.b.newInstance(null);
                } catch (Exception e) {
                    throw new r5.a(e);
                }
            default:
                try {
                    return this.b.newInstance(null);
                } catch (Exception e6) {
                    throw new r5.a(e6);
                }
        }
    }

    public a(Class cls) {
        try {
            Constructor constructor = Object.class.getConstructor(null);
            try {
                Class<?> cls2 = Class.forName("sun.reflect.ReflectionFactory");
                try {
                    try {
                        try {
                            Constructor constructor2 = (Constructor) cls2.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_CONSTRUCTOR_FOR_SERIALIZATION_METHOD_NAME, Class.class, Constructor.class).invoke(cls2.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.GET_REFLECTION_FACTORY_METHOD_NAME, new Class[0]).invoke(null, new Object[0]), cls, constructor);
                            this.b = constructor2;
                            constructor2.setAccessible(true);
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            throw new r5.a(e);
                        }
                    } catch (NoSuchMethodException e6) {
                        throw new r5.a(e6);
                    }
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e7) {
                    throw new r5.a(e7);
                }
            } catch (ClassNotFoundException e8) {
                throw new r5.a(e8);
            }
        } catch (NoSuchMethodException e9) {
            throw new r5.a(e9);
        }
    }
}
