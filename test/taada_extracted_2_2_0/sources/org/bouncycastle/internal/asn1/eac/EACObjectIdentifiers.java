package org.bouncycastle.internal.asn1.eac;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface EACObjectIdentifiers {
    public static final C0896n bsi_de;
    public static final C0896n id_CA;
    public static final C0896n id_CA_DH;
    public static final C0896n id_CA_DH_3DES_CBC_CBC;
    public static final C0896n id_CA_ECDH;
    public static final C0896n id_CA_ECDH_3DES_CBC_CBC;
    public static final C0896n id_EAC_ePassport;
    public static final C0896n id_PK;
    public static final C0896n id_PK_DH;
    public static final C0896n id_PK_ECDH;
    public static final C0896n id_TA;
    public static final C0896n id_TA_ECDSA;
    public static final C0896n id_TA_ECDSA_SHA_1;
    public static final C0896n id_TA_ECDSA_SHA_224;
    public static final C0896n id_TA_ECDSA_SHA_256;
    public static final C0896n id_TA_ECDSA_SHA_384;
    public static final C0896n id_TA_ECDSA_SHA_512;
    public static final C0896n id_TA_RSA;
    public static final C0896n id_TA_RSA_PSS_SHA_1;
    public static final C0896n id_TA_RSA_PSS_SHA_256;
    public static final C0896n id_TA_RSA_PSS_SHA_512;
    public static final C0896n id_TA_RSA_v1_5_SHA_1;
    public static final C0896n id_TA_RSA_v1_5_SHA_256;
    public static final C0896n id_TA_RSA_v1_5_SHA_512;

    static {
        C0896n c0896n = new C0896n("0.4.0.127.0.7");
        bsi_de = c0896n;
        C0896n c0896nJ = c0896n.j("2.2.1");
        id_PK = c0896nJ;
        id_PK_DH = c0896nJ.j("1");
        id_PK_ECDH = c0896nJ.j("2");
        C0896n c0896nJ2 = c0896n.j("2.2.3");
        id_CA = c0896nJ2;
        C0896n c0896nJ3 = c0896nJ2.j("1");
        id_CA_DH = c0896nJ3;
        id_CA_DH_3DES_CBC_CBC = c0896nJ3.j("1");
        C0896n c0896nJ4 = c0896nJ2.j("2");
        id_CA_ECDH = c0896nJ4;
        id_CA_ECDH_3DES_CBC_CBC = c0896nJ4.j("1");
        C0896n c0896nJ5 = c0896n.j("2.2.2");
        id_TA = c0896nJ5;
        C0896n c0896nJ6 = c0896nJ5.j("1");
        id_TA_RSA = c0896nJ6;
        id_TA_RSA_v1_5_SHA_1 = c0896nJ6.j("1");
        id_TA_RSA_v1_5_SHA_256 = c0896nJ6.j("2");
        id_TA_RSA_PSS_SHA_1 = c0896nJ6.j("3");
        id_TA_RSA_PSS_SHA_256 = c0896nJ6.j("4");
        id_TA_RSA_v1_5_SHA_512 = c0896nJ6.j("5");
        id_TA_RSA_PSS_SHA_512 = c0896nJ6.j("6");
        C0896n c0896nJ7 = c0896nJ5.j("2");
        id_TA_ECDSA = c0896nJ7;
        id_TA_ECDSA_SHA_1 = c0896nJ7.j("1");
        id_TA_ECDSA_SHA_224 = c0896nJ7.j("2");
        id_TA_ECDSA_SHA_256 = c0896nJ7.j("3");
        id_TA_ECDSA_SHA_384 = c0896nJ7.j("4");
        id_TA_ECDSA_SHA_512 = c0896nJ7.j("5");
        id_EAC_ePassport = c0896n.j("3.1.2.1");
    }
}
