package K4;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f943a = 1;

    public /* synthetic */ a() {
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        Class<?> clsLoadClass;
        switch (this.f943a) {
            case 0:
                int i = 0;
                while (true) {
                    String[] strArr = c.b;
                    if (i == strArr.length) {
                        return null;
                    }
                    String strH = B2.b.h(new StringBuilder("org.bouncycastle.pqc.jcajce.provider."), strArr[i], "$Mappings");
                    try {
                        ClassLoader classLoader = c.class.getClassLoader();
                        clsLoadClass = classLoader != null ? classLoader.loadClass(strH) : (Class) AccessController.doPrivileged(new b(strH, 0));
                    } catch (ClassNotFoundException unused) {
                        clsLoadClass = null;
                    }
                    if (clsLoadClass != null) {
                        try {
                            if (clsLoadClass.newInstance() == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        } catch (Exception e) {
                            throw new InternalError("cannot create instance of org.bouncycastle.pqc.jcajce.provider." + strArr[i] + "$Mappings : " + e);
                        }
                    }
                    i++;
                }
                break;
            default:
                return System.getProperty("line.separator");
        }
    }

    public a(c cVar) {
    }
}
