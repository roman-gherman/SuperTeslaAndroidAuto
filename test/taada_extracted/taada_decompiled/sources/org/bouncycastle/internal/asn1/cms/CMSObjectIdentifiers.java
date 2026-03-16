package org.bouncycastle.internal.asn1.cms;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface CMSObjectIdentifiers {
    public static final C0896n id_RSASSA_PSS_SHAKE128;
    public static final C0896n id_RSASSA_PSS_SHAKE256;
    public static final C0896n id_alg;
    public static final C0896n id_ecdsa_with_shake128;
    public static final C0896n id_ecdsa_with_shake256;
    public static final C0896n id_ri;
    public static final C0896n id_ri_ocsp_response;
    public static final C0896n id_ri_scvp;
    public static final C0896n data = PKCSObjectIdentifiers.data;
    public static final C0896n signedData = PKCSObjectIdentifiers.signedData;
    public static final C0896n envelopedData = PKCSObjectIdentifiers.envelopedData;
    public static final C0896n signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
    public static final C0896n digestedData = PKCSObjectIdentifiers.digestedData;
    public static final C0896n encryptedData = PKCSObjectIdentifiers.encryptedData;
    public static final C0896n authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
    public static final C0896n compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
    public static final C0896n authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
    public static final C0896n timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;

    static {
        C0896n c0896n = new C0896n("1.3.6.1.5.5.7.16");
        id_ri = c0896n;
        id_ri_ocsp_response = c0896n.j("2");
        id_ri_scvp = c0896n.j("4");
        C0896n c0896n2 = new C0896n("1.3.6.1.5.5.7.6");
        id_alg = c0896n2;
        id_RSASSA_PSS_SHAKE128 = c0896n2.j("30");
        id_RSASSA_PSS_SHAKE256 = c0896n2.j("31");
        id_ecdsa_with_shake128 = c0896n2.j("32");
        id_ecdsa_with_shake256 = c0896n2.j("33");
    }
}
