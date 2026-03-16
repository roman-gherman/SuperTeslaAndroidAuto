package kotlin.jvm.internal;

import h2.t0;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f3817a;
    public static final KClass[] b;

    static {
        x xVar = null;
        try {
            xVar = (x) t0.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (xVar == null) {
            xVar = new x();
        }
        f3817a = xVar;
        b = new KClass[0];
    }

    public static KType a(Class cls) {
        x xVar = f3817a;
        KClass kClassB = xVar.b(cls);
        List list = Collections.EMPTY_LIST;
        return xVar.i(kClassB);
    }
}
