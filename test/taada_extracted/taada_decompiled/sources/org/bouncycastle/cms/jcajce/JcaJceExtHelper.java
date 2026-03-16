package org.bouncycastle.cms.jcajce;

import H3.a;
import java.security.PrivateKey;
import javax.crypto.SecretKey;
import m4.AbstractC0692a;
import m4.c;
import n4.AbstractC0732a;
import n4.AbstractC0733b;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes2.dex */
interface JcaJceExtHelper extends JcaJceHelper {
    AbstractC0732a createAsymmetricUnwrapper(a aVar, PrivateKey privateKey);

    AbstractC0733b createAsymmetricUnwrapper(a aVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2);

    AbstractC0692a createKEMUnwrapper(a aVar, PrivateKey privateKey);

    c createSymmetricUnwrapper(a aVar, SecretKey secretKey);
}
