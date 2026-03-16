package org.bouncycastle.jce.interfaces;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface PKCS12BagAttributeCarrier {
    ASN1Encodable getBagAttribute(C0896n c0896n);

    Enumeration getBagAttributeKeys();

    boolean hasFriendlyName();

    void setBagAttribute(C0896n c0896n, ASN1Encodable aSN1Encodable);

    void setFriendlyName(String str);
}
