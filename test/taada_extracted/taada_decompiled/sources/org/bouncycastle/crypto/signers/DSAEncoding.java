package org.bouncycastle.crypto.signers;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public interface DSAEncoding {
    BigInteger[] decode(BigInteger bigInteger, byte[] bArr);

    byte[] encode(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3);
}
