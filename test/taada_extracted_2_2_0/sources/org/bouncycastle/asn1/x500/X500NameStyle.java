package org.bouncycastle.asn1.x500;

import G3.a;
import G3.b;
import org.bouncycastle.asn1.ASN1Encodable;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface X500NameStyle {
    boolean areEqual(b bVar, b bVar2);

    C0896n attrNameToOID(String str);

    int calculateHashCode(b bVar);

    a[] fromString(String str);

    String[] oidToAttrNames(C0896n c0896n);

    String oidToDisplayName(C0896n c0896n);

    ASN1Encodable stringToValue(C0896n c0896n, String str);

    String toString(b bVar);
}
