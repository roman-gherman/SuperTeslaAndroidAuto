package org.bouncycastle.eac.operator;

import java.io.OutputStream;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface EACSignatureVerifier {
    OutputStream getOutputStream();

    C0896n getUsageIdentifier();

    boolean verify(byte[] bArr);
}
