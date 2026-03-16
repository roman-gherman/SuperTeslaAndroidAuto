package org.bouncycastle.asn1.iso;

import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface ISOIECObjectIdentifiers {
    public static final C0896n hash_algorithms;
    public static final C0896n id_ac_generic_hybrid;
    public static final C0896n id_kem_rsa;
    public static final C0896n is18033_2;
    public static final C0896n iso_encryption_algorithms;
    public static final C0896n ripemd128;
    public static final C0896n ripemd160;
    public static final C0896n whirlpool;

    static {
        C0896n c0896n = new C0896n("1.0.10118");
        iso_encryption_algorithms = c0896n;
        C0896n c0896nJ = c0896n.j("3.0");
        hash_algorithms = c0896nJ;
        ripemd160 = c0896nJ.j("49");
        ripemd128 = c0896nJ.j("50");
        whirlpool = c0896nJ.j("55");
        C0896n c0896n2 = new C0896n("1.0.18033.2");
        is18033_2 = c0896n2;
        id_ac_generic_hybrid = c0896n2.j("1.2");
        id_kem_rsa = c0896n2.j("2.4");
    }
}
