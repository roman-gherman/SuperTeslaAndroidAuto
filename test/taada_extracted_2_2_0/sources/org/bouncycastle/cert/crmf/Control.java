package org.bouncycastle.cert.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface Control {
    C0896n getType();

    ASN1Encodable getValue();
}
