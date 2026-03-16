package org.bouncycastle.jcajce;

import U3.a;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes2.dex */
public interface PKIXCertRevocationChecker {
    void check(Certificate certificate);

    void initialize(a aVar);

    void setParameter(String str, Object obj);
}
