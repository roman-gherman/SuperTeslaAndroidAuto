package W0;

import android.content.Context;
import c4.AbstractC0246d;
import com.android.installreferrer.api.InstallReferrerStateListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1385a;
    public final Object b;
    public boolean c;
    public Object d;
    public final Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f1387g;

    public a(Context context, int i) {
        this.f1385a = i;
        switch (i) {
            case 1:
                this.f1386f = 0;
                this.e = context.getApplicationContext();
                this.b = new Object();
                this.c = false;
                break;
            default:
                this.f1386f = 0;
                this.e = context;
                this.b = new Object();
                this.c = false;
                break;
        }
    }

    public static Object b(Context context) {
        try {
            Object objA0 = AbstractC0246d.A0("com.huawei.hms.ads.installreferrer.api.InstallReferrerClient", "newBuilder", new Class[]{Context.class}, context);
            if (objA0 == null) {
                return null;
            }
            objA0.getClass().getDeclaredMethod("setTest", Boolean.TYPE).invoke(objA0, Boolean.FALSE);
            return AbstractC0246d.z0(objA0, "build", null, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static b c(Object obj) {
        if (obj == null) {
            return null;
        }
        return new b((String) AbstractC0246d.z0(obj, "getInstallReferrer", null, new Object[0]), ((Long) AbstractC0246d.z0(obj, "getInstallBeginTimestampSeconds", null, new Object[0])).longValue(), ((Long) AbstractC0246d.z0(obj, "getReferrerClickTimestampSeconds", null, new Object[0])).longValue());
    }

    public static b d(Object obj) {
        if (obj == null) {
            return null;
        }
        return new b((String) AbstractC0246d.z0(obj, "getInstallReferrer", null, new Object[0]), ((Long) AbstractC0246d.z0(obj, "getInstallBeginTimestampSeconds", null, new Object[0])).longValue(), ((Long) AbstractC0246d.z0(obj, "getReferrerClickTimestampSeconds", null, new Object[0])).longValue());
    }

    public final void a() {
        switch (this.f1385a) {
            case 0:
                Object obj = this.d;
                if (obj != null) {
                    try {
                        AbstractC0246d.z0(obj, "endConnection", null, new Object[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.d = null;
                    break;
                }
                break;
            default:
                Object obj2 = this.d;
                if (obj2 != null) {
                    try {
                        AbstractC0246d.z0(obj2, "endConnection", null, new Object[0]);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    this.d = null;
                    break;
                }
                break;
        }
    }

    public void e() {
        synchronized (this.b) {
            try {
                if (this.c) {
                    return;
                }
                int i = this.f1386f + 1;
                this.f1386f = i;
                if (i > 3) {
                    return;
                }
                try {
                    Thread.sleep(1000L);
                    g();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() {
        synchronized (this.b) {
            try {
                if (this.c) {
                    return;
                }
                int i = this.f1386f + 1;
                this.f1386f = i;
                if (i > 3) {
                    return;
                }
                try {
                    Thread.sleep(1000L);
                    g();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public final boolean g() {
        Class<?> cls;
        Object objZ0;
        boolean z6 = true;
        Object objNewProxyInstance = null;
        switch (this.f1385a) {
            case 0:
                synchronized (this.b) {
                    try {
                        a();
                        if (this.c) {
                            return false;
                        }
                        Context context = this.e;
                        if (context == null) {
                            return false;
                        }
                        Object objB = b(context);
                        this.d = objB;
                        if (objB == null) {
                            return false;
                        }
                        try {
                            cls = Class.forName("com.huawei.hms.ads.installreferrer.api.InstallReferrerStateListener");
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            cls = null;
                        }
                        if (cls == null) {
                            return false;
                        }
                        try {
                            objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
                            break;
                        } catch (IllegalArgumentException | NullPointerException e6) {
                            e6.printStackTrace();
                        }
                        if (objNewProxyInstance == null) {
                            return false;
                        }
                        try {
                            AbstractC0246d.z0(this.d, "startConnection", new Class[]{cls}, objNewProxyInstance);
                            break;
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            z6 = false;
                        }
                        return z6;
                    } finally {
                    }
                }
            default:
                synchronized (this.b) {
                    try {
                        a();
                        if (this.c) {
                            return false;
                        }
                        Context context2 = this.e;
                        if (context2 == null) {
                            return false;
                        }
                        try {
                            objZ0 = AbstractC0246d.z0(AbstractC0246d.A0("com.android.installreferrer.api.InstallReferrerClient", "newBuilder", new Class[]{Context.class}, context2), "build", null, new Object[0]);
                            break;
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            objZ0 = null;
                        }
                        this.d = objZ0;
                        if (objZ0 == null) {
                            return false;
                        }
                        if (InstallReferrerStateListener.class == 0) {
                            return false;
                        }
                        try {
                            objNewProxyInstance = Proxy.newProxyInstance(InstallReferrerStateListener.class.getClassLoader(), new Class[]{InstallReferrerStateListener.class}, this);
                            break;
                        } catch (IllegalArgumentException | NullPointerException e9) {
                            e9.printStackTrace();
                        }
                        if (objNewProxyInstance == null) {
                            return false;
                        }
                        try {
                            AbstractC0246d.z0(this.d, "startConnection", new Class[]{InstallReferrerStateListener.class}, objNewProxyInstance);
                            break;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            z6 = false;
                        }
                        return z6;
                    } finally {
                    }
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0074 A[Catch: Exception -> 0x0085, TryCatch #5 {Exception -> 0x0085, blocks: (B:33:0x004e, B:41:0x0063, B:43:0x0074, B:44:0x0077, B:45:0x0079, B:48:0x007d, B:53:0x0084, B:40:0x005f, B:46:0x007a, B:47:0x007c, B:36:0x0054), top: B:123:0x004e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00fc  */
    @Override // java.lang.reflect.InvocationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(java.lang.Object r9, java.lang.reflect.Method r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.a.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }
}
