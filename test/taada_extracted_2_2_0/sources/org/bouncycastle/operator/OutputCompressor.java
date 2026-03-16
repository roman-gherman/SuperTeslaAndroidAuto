package org.bouncycastle.operator;

import H3.a;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface OutputCompressor {
    a getAlgorithmIdentifier();

    OutputStream getOutputStream(OutputStream outputStream);
}
