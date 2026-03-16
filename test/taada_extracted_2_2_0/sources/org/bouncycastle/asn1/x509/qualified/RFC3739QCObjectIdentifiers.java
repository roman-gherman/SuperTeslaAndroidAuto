package org.bouncycastle.asn1.x509.qualified;

import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface RFC3739QCObjectIdentifiers {
    public static final C0896n id_qcs;
    public static final C0896n id_qcs_pkixQCSyntax_v1;
    public static final C0896n id_qcs_pkixQCSyntax_v2;

    static {
        C0896n c0896nJ = X509ObjectIdentifiers.id_pkix.j("11");
        id_qcs = c0896nJ;
        id_qcs_pkixQCSyntax_v1 = c0896nJ.j("1");
        id_qcs_pkixQCSyntax_v2 = c0896nJ.j("2");
    }
}
