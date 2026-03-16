package org.bouncycastle.eac.operator;

import java.io.OutputStream;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface EACSigner {
    OutputStream getOutputStream();

    byte[] getSignature();

    C0896n getUsageIdentifier();
}
