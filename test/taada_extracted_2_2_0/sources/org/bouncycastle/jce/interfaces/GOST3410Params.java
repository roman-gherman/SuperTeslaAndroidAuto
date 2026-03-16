package org.bouncycastle.jce.interfaces;

import a4.c;

/* JADX INFO: loaded from: classes2.dex */
public interface GOST3410Params {
    String getDigestParamSetOID();

    String getEncryptionParamSetOID();

    String getPublicKeyParamSetOID();

    c getPublicKeyParameters();
}
