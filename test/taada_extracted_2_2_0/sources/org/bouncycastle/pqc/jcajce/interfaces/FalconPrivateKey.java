package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes2.dex */
public interface FalconPrivateKey extends PrivateKey, FalconKey {
    FalconPublicKey getPublicKey();
}
