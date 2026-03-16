package L3;

import java.security.SecureRandom;
import org.bouncycastle.crypto.SecureRandomProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements SecureRandomProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f984a = new ThreadLocal();

    @Override // org.bouncycastle.crypto.SecureRandomProvider
    public final SecureRandom get() {
        ThreadLocal threadLocal = this.f984a;
        if (threadLocal.get() == null) {
            threadLocal.set(new SecureRandom());
        }
        return (SecureRandom) threadLocal.get();
    }
}
