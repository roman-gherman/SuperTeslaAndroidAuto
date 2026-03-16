package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface CMSObjectIdentifiers {
    public static final C0896n id_RSASSA_PSS_SHAKE128;
    public static final C0896n id_RSASSA_PSS_SHAKE256;
    public static final C0896n id_alg;
    public static final C0896n id_alg_cek_hkdf_sha256;
    public static final C0896n id_ecdsa_with_shake128;
    public static final C0896n id_ecdsa_with_shake256;
    public static final C0896n id_ori;
    public static final C0896n id_ori_kem;
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
    public static final C0896n zlibCompress = PKCSObjectIdentifiers.id_alg_zlibCompress;

    static {
        C0896n c0896nJ = X509ObjectIdentifiers.id_pkix.j("16");
        id_ri = c0896nJ;
        id_ri_ocsp_response = c0896nJ.j("2");
        id_ri_scvp = c0896nJ.j("4");
        id_alg = X509ObjectIdentifiers.pkix_algorithms;
        id_RSASSA_PSS_SHAKE128 = X509ObjectIdentifiers.id_rsassa_pss_shake128;
        id_RSASSA_PSS_SHAKE256 = X509ObjectIdentifiers.id_rsassa_pss_shake256;
        id_ecdsa_with_shake128 = X509ObjectIdentifiers.id_ecdsa_with_shake128;
        id_ecdsa_with_shake256 = X509ObjectIdentifiers.id_ecdsa_with_shake256;
        C0896n c0896nJ2 = PKCSObjectIdentifiers.id_smime.j("13");
        id_ori = c0896nJ2;
        id_ori_kem = c0896nJ2.j("3");
        id_alg_cek_hkdf_sha256 = PKCSObjectIdentifiers.smime_alg.j("31");
    }
}
