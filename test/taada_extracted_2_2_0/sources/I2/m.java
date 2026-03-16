package i2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends r {
    public final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3473f;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ m(Method method, boolean z6, int i) {
        z6 = (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z6;
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        kotlin.jvm.internal.h.e(genericParameterTypes, "method.genericParameterTypes");
        this(method, z6, genericParameterTypes);
    }

    @Override // i2.r
    public void a(Object[] objArr) {
        switch (this.e) {
            case 0:
                kotlin.reflect.l.f(this, objArr);
                if (this.f3473f && kotlin.collections.j.H(objArr) == null) {
                    throw new IllegalArgumentException("null is not allowed as a value for this property.");
                }
                return;
            default:
                super.a(objArr);
                return;
        }
    }

    public Object c(Object obj, Object[] args) {
        kotlin.jvm.internal.h.f(args, "args");
        return this.f3473f ? N1.m.f1129a : ((Method) this.f3477a).invoke(obj, Arrays.copyOf(args, args.length));
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] args) throws IllegalAccessException {
        kotlin.jvm.internal.h.f(args, "args");
        a(args);
        ((Field) this.f3477a).set(this.c != null ? kotlin.collections.j.A(args) : null, kotlin.collections.j.H(args));
        return N1.m.f1129a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m(Method method, boolean z6, Type[] typeArr) {
        Type genericReturnType = method.getGenericReturnType();
        kotlin.jvm.internal.h.e(genericReturnType, "method.genericReturnType");
        super(method, genericReturnType, z6 ? method.getDeclaringClass() : null, typeArr);
        this.f3473f = genericReturnType.equals(Void.TYPE);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m(Field field, boolean z6, boolean z7) {
        Class TYPE = Void.TYPE;
        kotlin.jvm.internal.h.e(TYPE, "TYPE");
        Class<?> declaringClass = z7 ? field.getDeclaringClass() : null;
        Type genericType = field.getGenericType();
        kotlin.jvm.internal.h.e(genericType, "field.genericType");
        super(field, TYPE, declaringClass, new Type[]{genericType});
        this.f3473f = z6;
    }
}
