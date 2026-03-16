package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public interface DSAEncoder {
    BigInteger[] decode(byte[] bArr);

    byte[] encode(BigInteger bigInteger, BigInteger bigInteger2);
}
