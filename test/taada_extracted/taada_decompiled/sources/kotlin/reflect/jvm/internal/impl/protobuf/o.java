package kotlin.reflect.jvm.internal.impl.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0612m f3872a;
    public final Object b;
    public final p c;
    public final C0613n d;
    public final Method e;

    public o(AbstractC0612m abstractC0612m, Object obj, p pVar, C0613n c0613n, Class cls) {
        if (abstractC0612m == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (c0613n.b == M.f3848f && pVar == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.f3872a = abstractC0612m;
        this.b = obj;
        this.c = pVar;
        this.d = c0613n;
        if (!Internal$EnumLite.class.isAssignableFrom(cls)) {
            this.e = null;
            return;
        }
        try {
            this.e = cls.getMethod("valueOf", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            String name = cls.getName();
            StringBuilder sb = new StringBuilder(name.length() + 52);
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"valueOf\".");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final Object a(Object obj) {
        if (this.d.b.f3851a != N.ENUM) {
            return obj;
        }
        try {
            return this.e.invoke(null, (Integer) obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public final Object b(Object obj) {
        return this.d.b.f3851a == N.ENUM ? Integer.valueOf(((Internal$EnumLite) obj).getNumber()) : obj;
    }
}
