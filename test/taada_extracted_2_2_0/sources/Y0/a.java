package Y0;

import android.content.Context;
import c4.AbstractC0246d;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1477a;
    public LinkedBlockingQueue b;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name;
        if (method != null && (name = method.getName()) != null) {
            if (objArr == null) {
                objArr = new Object[0];
            }
            if (name.equals("OnSupport") && (objArr[0] instanceof Boolean)) {
                Object objZ0 = AbstractC0246d.z0(objArr[1], "getOAID", null, new Object[0]);
                if (objZ0 == null) {
                    this.b.offer("");
                    return null;
                }
                objZ0.toString();
                this.b.offer((String) objZ0);
            }
        }
        return null;
    }
}
