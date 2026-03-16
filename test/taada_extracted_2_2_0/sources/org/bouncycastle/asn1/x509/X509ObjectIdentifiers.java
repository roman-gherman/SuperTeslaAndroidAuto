package org.bouncycastle.asn1.x509;

import org.bouncycastle.internal.asn1.misc.MiscObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface X509ObjectIdentifiers {
    public static final C0896n attributeType;
    public static final C0896n commonName;
    public static final C0896n countryName;
    public static final C0896n crlAccessMethod;
    public static final C0896n id_PasswordBasedMac;
    public static final C0896n id_SHA1;
    public static final C0896n id_ad;
    public static final C0896n id_ad_caIssuers;
    public static final C0896n id_ad_ocsp;
    public static final C0896n id_alg_noSignature;
    public static final C0896n id_at_name;
    public static final C0896n id_at_organizationIdentifier;
    public static final C0896n id_at_telephoneNumber;
    public static final C0896n id_ce;
    public static final C0896n id_ea_rsa;
    public static final C0896n id_ecdsa_with_shake128;
    public static final C0896n id_ecdsa_with_shake256;
    public static final C0896n id_pda;
    public static final C0896n id_pe;
    public static final C0896n id_pkix;
    public static final C0896n id_rsassa_pss_shake128;
    public static final C0896n id_rsassa_pss_shake256;
    public static final C0896n localityName;
    public static final C0896n ocspAccessMethod;
    public static final C0896n organization;
    public static final C0896n organizationalUnitName;
    public static final C0896n pkix_algorithms;
    public static final C0896n ripemd160;
    public static final C0896n ripemd160WithRSAEncryption;
    public static final C0896n stateOrProvinceName;

    static {
        C0896n c0896nN = new C0896n("2.5.4").n();
        attributeType = c0896nN;
        commonName = c0896nN.j("3").n();
        countryName = c0896nN.j("6").n();
        localityName = c0896nN.j("7").n();
        stateOrProvinceName = c0896nN.j("8").n();
        organization = c0896nN.j("10").n();
        organizationalUnitName = c0896nN.j("11").n();
        id_at_telephoneNumber = c0896nN.j("20").n();
        id_at_name = c0896nN.j("41").n();
        id_at_organizationIdentifier = c0896nN.j("97").n();
        id_SHA1 = new C0896n("1.3.14.3.2.26").n();
        ripemd160 = new C0896n("1.3.36.3.2.1").n();
        ripemd160WithRSAEncryption = new C0896n("1.3.36.3.3.1.2").n();
        id_ea_rsa = new C0896n("2.5.8.1.1").n();
        C0896n c0896n = new C0896n("1.3.6.1.5.5.7");
        id_pkix = c0896n;
        id_pe = c0896n.j("1");
        C0896n c0896nJ = c0896n.j("6");
        pkix_algorithms = c0896nJ;
        id_rsassa_pss_shake128 = c0896nJ.j("30");
        id_rsassa_pss_shake256 = c0896nJ.j("31");
        id_ecdsa_with_shake128 = c0896nJ.j("32");
        id_ecdsa_with_shake256 = c0896nJ.j("33");
        id_alg_noSignature = c0896nJ.j("2");
        id_pda = c0896n.j("9");
        C0896n c0896nJ2 = c0896n.j("48");
        id_ad = c0896nJ2;
        C0896n c0896nN2 = c0896nJ2.j("2").n();
        id_ad_caIssuers = c0896nN2;
        C0896n c0896nN3 = c0896nJ2.j("1").n();
        id_ad_ocsp = c0896nN3;
        ocspAccessMethod = c0896nN3;
        crlAccessMethod = c0896nN2;
        id_ce = new C0896n("2.5.29");
        id_PasswordBasedMac = MiscObjectIdentifiers.entrust.j("66.13");
    }
}
