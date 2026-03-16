package org.bouncycastle.operator;

import H3.a;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface ContentSigner {
    a getAlgorithmIdentifier();

    OutputStream getOutputStream();

    byte[] getSignature();
}
