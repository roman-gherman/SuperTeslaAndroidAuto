package org.bouncycastle.jcajce.provider.util;

import C3.a;
import H3.d;
import java.security.PrivateKey;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes2.dex */
public interface AsymmetricKeyInfoConverter {
    PrivateKey generatePrivate(a aVar);

    PublicKey generatePublic(d dVar);
}
