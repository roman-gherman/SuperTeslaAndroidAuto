package org.bouncycastle.operator;

import H3.a;
import java.io.OutputStream;
import m4.AbstractC0693b;

/* JADX INFO: loaded from: classes2.dex */
public interface MacCalculator {
    a getAlgorithmIdentifier();

    AbstractC0693b getKey();

    byte[] getMac();

    OutputStream getOutputStream();
}
