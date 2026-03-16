package org.bouncycastle.jcajce.interfaces;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes2.dex */
public interface MLKEMPrivateKey extends PrivateKey, MLKEMKey {
    byte[] getPrivateData();

    MLKEMPrivateKey getPrivateKey(boolean z6);

    MLKEMPublicKey getPublicKey();

    byte[] getSeed();
}
