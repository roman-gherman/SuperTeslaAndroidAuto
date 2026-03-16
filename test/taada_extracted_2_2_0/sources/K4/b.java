package K4;

import java.security.PrivilegedAction;
import java.security.Security;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f944a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(String str, int i) {
        this.f944a = i;
        this.b = str;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f944a) {
            case 0:
                try {
                    return Class.forName(this.b);
                } catch (Exception unused) {
                    return null;
                }
            case 1:
                return Security.getProperty(this.b);
            case 2:
                return System.getProperty(this.b);
            default:
                try {
                    return ClassLoader.getSystemClassLoader().loadClass(this.b);
                } catch (Exception unused2) {
                    return null;
                }
        }
    }
}
