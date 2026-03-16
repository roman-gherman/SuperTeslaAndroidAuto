package org.bouncycastle.internal.asn1.bsi;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface BSIObjectIdentifiers {
    public static final C0896n algorithm;
    public static final C0896n bsi_de;
    public static final C0896n ecdsa_plain_RIPEMD160;
    public static final C0896n ecdsa_plain_SHA1;
    public static final C0896n ecdsa_plain_SHA224;
    public static final C0896n ecdsa_plain_SHA256;
    public static final C0896n ecdsa_plain_SHA384;
    public static final C0896n ecdsa_plain_SHA3_224;
    public static final C0896n ecdsa_plain_SHA3_256;
    public static final C0896n ecdsa_plain_SHA3_384;
    public static final C0896n ecdsa_plain_SHA3_512;
    public static final C0896n ecdsa_plain_SHA512;
    public static final C0896n ecdsa_plain_signatures;
    public static final C0896n ecka_eg;
    public static final C0896n ecka_eg_SessionKDF;
    public static final C0896n ecka_eg_SessionKDF_3DES;
    public static final C0896n ecka_eg_SessionKDF_AES128;
    public static final C0896n ecka_eg_SessionKDF_AES192;
    public static final C0896n ecka_eg_SessionKDF_AES256;
    public static final C0896n ecka_eg_X963kdf;
    public static final C0896n ecka_eg_X963kdf_RIPEMD160;
    public static final C0896n ecka_eg_X963kdf_SHA1;
    public static final C0896n ecka_eg_X963kdf_SHA224;
    public static final C0896n ecka_eg_X963kdf_SHA256;
    public static final C0896n ecka_eg_X963kdf_SHA384;
    public static final C0896n ecka_eg_X963kdf_SHA512;
    public static final C0896n id_ecc;

    static {
        C0896n c0896n = new C0896n("0.4.0.127.0.7");
        bsi_de = c0896n;
        C0896n c0896nJ = c0896n.j("1.1");
        id_ecc = c0896nJ;
        C0896n c0896nJ2 = c0896nJ.j("4.1");
        ecdsa_plain_signatures = c0896nJ2;
        ecdsa_plain_SHA1 = c0896nJ2.j("1");
        ecdsa_plain_SHA224 = c0896nJ2.j("2");
        ecdsa_plain_SHA256 = c0896nJ2.j("3");
        ecdsa_plain_SHA384 = c0896nJ2.j("4");
        ecdsa_plain_SHA512 = c0896nJ2.j("5");
        ecdsa_plain_RIPEMD160 = c0896nJ2.j("6");
        ecdsa_plain_SHA3_224 = c0896nJ2.j("8");
        ecdsa_plain_SHA3_256 = c0896nJ2.j("9");
        ecdsa_plain_SHA3_384 = c0896nJ2.j("10");
        ecdsa_plain_SHA3_512 = c0896nJ2.j("11");
        algorithm = c0896n.j("1");
        C0896n c0896nJ3 = c0896nJ.j("5.1");
        ecka_eg = c0896nJ3;
        C0896n c0896nJ4 = c0896nJ3.j("1");
        ecka_eg_X963kdf = c0896nJ4;
        ecka_eg_X963kdf_SHA1 = c0896nJ4.j("1");
        ecka_eg_X963kdf_SHA224 = c0896nJ4.j("2");
        ecka_eg_X963kdf_SHA256 = c0896nJ4.j("3");
        ecka_eg_X963kdf_SHA384 = c0896nJ4.j("4");
        ecka_eg_X963kdf_SHA512 = c0896nJ4.j("5");
        ecka_eg_X963kdf_RIPEMD160 = c0896nJ4.j("6");
        C0896n c0896nJ5 = c0896nJ3.j("2");
        ecka_eg_SessionKDF = c0896nJ5;
        ecka_eg_SessionKDF_3DES = c0896nJ5.j("1");
        ecka_eg_SessionKDF_AES128 = c0896nJ5.j("2");
        ecka_eg_SessionKDF_AES192 = c0896nJ5.j("3");
        ecka_eg_SessionKDF_AES256 = c0896nJ5.j("4");
    }
}
