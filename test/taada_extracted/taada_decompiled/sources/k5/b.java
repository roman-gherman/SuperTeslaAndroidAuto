package k5;

import java.security.cert.CertSelector;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements CertSelector, Selector {
    @Override // java.security.cert.CertSelector, org.bouncycastle.util.Selector
    public abstract Object clone();
}
