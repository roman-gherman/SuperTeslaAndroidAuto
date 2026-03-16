package org.bouncycastle.its.operator;

import T3.a;
import java.io.OutputStream;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface ITSContentSigner {
    a getAssociatedCertificate();

    byte[] getAssociatedCertificateDigest();

    C0896n getCurveID();

    H3.a getDigestAlgorithm();

    OutputStream getOutputStream();

    byte[] getSignature();

    boolean isForSelfSigning();
}
