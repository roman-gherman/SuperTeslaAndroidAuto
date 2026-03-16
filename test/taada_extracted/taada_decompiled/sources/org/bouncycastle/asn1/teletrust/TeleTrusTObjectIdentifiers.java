package org.bouncycastle.asn1.teletrust;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface TeleTrusTObjectIdentifiers {
    public static final C0896n brainpoolP160r1;
    public static final C0896n brainpoolP160t1;
    public static final C0896n brainpoolP192r1;
    public static final C0896n brainpoolP192t1;
    public static final C0896n brainpoolP224r1;
    public static final C0896n brainpoolP224t1;
    public static final C0896n brainpoolP256r1;
    public static final C0896n brainpoolP256t1;
    public static final C0896n brainpoolP320r1;
    public static final C0896n brainpoolP320t1;
    public static final C0896n brainpoolP384r1;
    public static final C0896n brainpoolP384t1;
    public static final C0896n brainpoolP512r1;
    public static final C0896n brainpoolP512t1;
    public static final C0896n ecSign;
    public static final C0896n ecSignWithRipemd160;
    public static final C0896n ecSignWithSha1;
    public static final C0896n ecc_brainpool;
    public static final C0896n ellipticCurve;
    public static final C0896n ripemd128;
    public static final C0896n ripemd160;
    public static final C0896n ripemd256;
    public static final C0896n rsaSignatureWithripemd128;
    public static final C0896n rsaSignatureWithripemd160;
    public static final C0896n rsaSignatureWithripemd256;
    public static final C0896n teleTrusTAlgorithm;
    public static final C0896n teleTrusTRSAsignatureAlgorithm;
    public static final C0896n versionOne;

    static {
        C0896n c0896n = new C0896n("1.3.36.3");
        teleTrusTAlgorithm = c0896n;
        ripemd160 = c0896n.j("2.1");
        ripemd128 = c0896n.j("2.2");
        ripemd256 = c0896n.j("2.3");
        C0896n c0896nJ = c0896n.j("3.1");
        teleTrusTRSAsignatureAlgorithm = c0896nJ;
        rsaSignatureWithripemd160 = c0896nJ.j("2");
        rsaSignatureWithripemd128 = c0896nJ.j("3");
        rsaSignatureWithripemd256 = c0896nJ.j("4");
        C0896n c0896nJ2 = c0896n.j("3.2");
        ecSign = c0896nJ2;
        ecSignWithSha1 = c0896nJ2.j("1");
        ecSignWithRipemd160 = c0896nJ2.j("2");
        C0896n c0896nJ3 = c0896n.j("3.2.8");
        ecc_brainpool = c0896nJ3;
        C0896n c0896nJ4 = c0896nJ3.j("1");
        ellipticCurve = c0896nJ4;
        C0896n c0896nJ5 = c0896nJ4.j("1");
        versionOne = c0896nJ5;
        brainpoolP160r1 = c0896nJ5.j("1");
        brainpoolP160t1 = c0896nJ5.j("2");
        brainpoolP192r1 = c0896nJ5.j("3");
        brainpoolP192t1 = c0896nJ5.j("4");
        brainpoolP224r1 = c0896nJ5.j("5");
        brainpoolP224t1 = c0896nJ5.j("6");
        brainpoolP256r1 = c0896nJ5.j("7");
        brainpoolP256t1 = c0896nJ5.j("8");
        brainpoolP320r1 = c0896nJ5.j("9");
        brainpoolP320t1 = c0896nJ5.j("10");
        brainpoolP384r1 = c0896nJ5.j("11");
        brainpoolP384t1 = c0896nJ5.j("12");
        brainpoolP512r1 = c0896nJ5.j("13");
        brainpoolP512t1 = c0896nJ5.j("14");
    }
}
