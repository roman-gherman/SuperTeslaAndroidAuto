package org.bouncycastle.cert.crmf;

import H3.a;

/* JADX INFO: loaded from: classes2.dex */
public interface PKMACValuesCalculator {
    byte[] calculateDigest(byte[] bArr);

    byte[] calculateMac(byte[] bArr, byte[] bArr2);

    void setup(a aVar, a aVar2);
}
