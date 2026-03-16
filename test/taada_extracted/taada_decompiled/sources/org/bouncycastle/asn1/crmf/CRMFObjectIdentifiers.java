package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface CRMFObjectIdentifiers {
    public static final C0896n id_alg;
    public static final C0896n id_alg_dh_pop;
    public static final C0896n id_ct_encKeyWithID;
    public static final C0896n id_dh_sig_hmac_sha1;
    public static final C0896n id_pkip;
    public static final C0896n id_pkix;
    public static final C0896n id_regCtrl;
    public static final C0896n id_regCtrl_authenticator;
    public static final C0896n id_regCtrl_oldCertID;
    public static final C0896n id_regCtrl_pkiArchiveOptions;
    public static final C0896n id_regCtrl_pkiPublicationInfo;
    public static final C0896n id_regCtrl_protocolEncrKey;
    public static final C0896n id_regCtrl_regToken;
    public static final C0896n id_regInfo;
    public static final C0896n id_regInfo_certReq;
    public static final C0896n id_regInfo_utf8Pairs;
    public static final C0896n passwordBasedMac = MiscObjectIdentifiers.entrust.j("66.13");

    static {
        C0896n c0896n = X509ObjectIdentifiers.id_pkix;
        id_pkix = c0896n;
        C0896n c0896nJ = c0896n.j("5");
        id_pkip = c0896nJ;
        C0896n c0896nJ2 = c0896nJ.j("1");
        id_regCtrl = c0896nJ2;
        id_regCtrl_regToken = c0896nJ2.j("1");
        id_regCtrl_authenticator = c0896nJ2.j("2");
        id_regCtrl_pkiPublicationInfo = c0896nJ2.j("3");
        id_regCtrl_pkiArchiveOptions = c0896nJ2.j("4");
        id_regCtrl_oldCertID = c0896nJ2.j("5");
        id_regCtrl_protocolEncrKey = c0896nJ2.j("6");
        C0896n c0896nJ3 = c0896nJ.j("2");
        id_regInfo = c0896nJ3;
        id_regInfo_utf8Pairs = c0896nJ3.j("1");
        id_regInfo_certReq = c0896nJ3.j("2");
        id_ct_encKeyWithID = PKCSObjectIdentifiers.id_ct.j("21");
        C0896n c0896n2 = X509ObjectIdentifiers.pkix_algorithms;
        id_alg = c0896n2;
        id_dh_sig_hmac_sha1 = c0896n2.j("3");
        id_alg_dh_pop = c0896n2.j("4");
    }
}
