package y5;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f5157a;

    static {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            try {
                f5157a = (Unsafe) declaredField.get(null);
            } catch (IllegalAccessException e) {
                throw new r5.a(e);
            }
        } catch (NoSuchFieldException e6) {
            throw new r5.a(e6);
        }
    }
}
