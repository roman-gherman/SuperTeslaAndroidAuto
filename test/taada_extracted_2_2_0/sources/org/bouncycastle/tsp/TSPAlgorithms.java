package org.bouncycastle.tsp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public interface TSPAlgorithms {
    public static final Set ALLOWED;
    public static final C0896n GOST3411;
    public static final C0896n GOST3411_2012_256;
    public static final C0896n GOST3411_2012_512;
    public static final C0896n MD5;
    public static final C0896n RIPEMD128;
    public static final C0896n RIPEMD160;
    public static final C0896n RIPEMD256;
    public static final C0896n SHA1;
    public static final C0896n SHA224;
    public static final C0896n SHA256;
    public static final C0896n SHA384;
    public static final C0896n SHA3_224;
    public static final C0896n SHA3_256;
    public static final C0896n SHA3_384;
    public static final C0896n SHA3_512;
    public static final C0896n SHA512;
    public static final C0896n SM3;

    static {
        C0896n c0896n = PKCSObjectIdentifiers.md5;
        MD5 = c0896n;
        C0896n c0896n2 = OIWObjectIdentifiers.idSHA1;
        SHA1 = c0896n2;
        C0896n c0896n3 = NISTObjectIdentifiers.id_sha224;
        SHA224 = c0896n3;
        C0896n c0896n4 = NISTObjectIdentifiers.id_sha256;
        SHA256 = c0896n4;
        C0896n c0896n5 = NISTObjectIdentifiers.id_sha384;
        SHA384 = c0896n5;
        C0896n c0896n6 = NISTObjectIdentifiers.id_sha512;
        SHA512 = c0896n6;
        C0896n c0896n7 = NISTObjectIdentifiers.id_sha3_224;
        SHA3_224 = c0896n7;
        C0896n c0896n8 = NISTObjectIdentifiers.id_sha3_256;
        SHA3_256 = c0896n8;
        C0896n c0896n9 = NISTObjectIdentifiers.id_sha3_384;
        SHA3_384 = c0896n9;
        C0896n c0896n10 = NISTObjectIdentifiers.id_sha3_512;
        SHA3_512 = c0896n10;
        C0896n c0896n11 = TeleTrusTObjectIdentifiers.ripemd128;
        RIPEMD128 = c0896n11;
        C0896n c0896n12 = TeleTrusTObjectIdentifiers.ripemd160;
        RIPEMD160 = c0896n12;
        C0896n c0896n13 = TeleTrusTObjectIdentifiers.ripemd256;
        RIPEMD256 = c0896n13;
        C0896n c0896n14 = CryptoProObjectIdentifiers.gostR3411;
        GOST3411 = c0896n14;
        C0896n c0896n15 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256;
        GOST3411_2012_256 = c0896n15;
        C0896n c0896n16 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512;
        GOST3411_2012_512 = c0896n16;
        C0896n c0896n17 = GMObjectIdentifiers.sm3;
        SM3 = c0896n17;
        ALLOWED = new HashSet(Arrays.asList(c0896n17, c0896n14, c0896n15, c0896n16, c0896n, c0896n2, c0896n3, c0896n4, c0896n5, c0896n6, c0896n7, c0896n8, c0896n9, c0896n10, c0896n11, c0896n12, c0896n13));
    }
}
