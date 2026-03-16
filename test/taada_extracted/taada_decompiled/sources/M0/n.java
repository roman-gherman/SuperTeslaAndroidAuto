package M0;

import com.google.gson.E;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1006a;
    public final Field b;
    public final String c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f1007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Method f1008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f1009h;
    public final /* synthetic */ E i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ com.google.gson.m f1010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ com.google.gson.reflect.a f1011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f1012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f1013m;

    public n(String str, Field field, boolean z6, boolean z7, boolean z8, Method method, boolean z9, E e, com.google.gson.m mVar, com.google.gson.reflect.a aVar, boolean z10, boolean z11) {
        this.f1007f = z8;
        this.f1008g = method;
        this.f1009h = z9;
        this.i = e;
        this.f1010j = mVar;
        this.f1011k = aVar;
        this.f1012l = z10;
        this.f1013m = z11;
        this.f1006a = str;
        this.b = field;
        this.c = field.getName();
        this.d = z6;
        this.e = z7;
    }

    public final void a(com.google.gson.stream.c cVar, Object obj) throws IllegalAccessException {
        Object objInvoke;
        if (this.d) {
            Field field = this.b;
            boolean z6 = this.f1007f;
            Method method = this.f1008g;
            if (z6) {
                if (method == null) {
                    r.a(obj, field);
                } else {
                    r.a(obj, method);
                }
            }
            if (method != null) {
                try {
                    objInvoke = method.invoke(obj, new Object[0]);
                } catch (InvocationTargetException e) {
                    throw new com.google.gson.q(androidx.constraintlayout.core.motion.a.q("Accessor ", O0.c.d(method, false), " threw exception"), e.getCause());
                }
            } else {
                objInvoke = field.get(obj);
            }
            if (objInvoke == obj) {
                return;
            }
            cVar.g(this.f1006a);
            boolean z7 = this.f1009h;
            E kVar = this.i;
            if (!z7) {
                kVar = new k(this.f1010j, kVar, this.f1011k.b);
            }
            kVar.b(cVar, objInvoke);
        }
    }
}
