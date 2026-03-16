package org.bouncycastle.x509;

import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.X509Extension;
import java.util.Date;
import k5.a;
import k5.b;
import k5.c;

/* JADX INFO: loaded from: classes2.dex */
public interface X509AttributeCertificate extends X509Extension {
    void checkValidity();

    void checkValidity(Date date);

    c[] getAttributes();

    c[] getAttributes(String str);

    byte[] getEncoded();

    a getHolder();

    b getIssuer();

    boolean[] getIssuerUniqueID();

    Date getNotAfter();

    Date getNotBefore();

    BigInteger getSerialNumber();

    byte[] getSignature();

    int getVersion();

    void verify(PublicKey publicKey, String str);
}
