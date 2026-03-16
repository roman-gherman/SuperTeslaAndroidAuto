package org.bouncycastle.operator;

import H3.a;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface DigestCalculator {
    a getAlgorithmIdentifier();

    byte[] getDigest();

    OutputStream getOutputStream();
}
