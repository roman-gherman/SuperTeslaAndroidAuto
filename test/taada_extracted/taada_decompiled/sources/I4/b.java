package I4;

import C0.t;
import H3.d;
import J4.r;
import J4.w;
import a.AbstractC0132a;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import o4.C0749b;
import o4.f;
import o4.j;
import o4.k;
import o4.o;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.internal.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.slhdsa.g;
import q4.C0789a;
import q4.C0791c;
import r4.C0806b;
import s4.C0814a;
import t4.C0829a;
import u4.C0844a;
import v4.C0858a;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0896n;
import w4.C0910c;
import x4.C0926a;
import y4.C0938b;
import z4.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f795a;

    static {
        HashMap map = new HashMap();
        f795a = map;
        map.put(PQCObjectIdentifiers.qTESLA_p_I, new a(15));
        map.put(PQCObjectIdentifiers.qTESLA_p_III, new a(15));
        map.put(PQCObjectIdentifiers.sphincs256, new a(20));
        map.put(PQCObjectIdentifiers.newHope, new a(11));
        map.put(PQCObjectIdentifiers.xmss, new a(23));
        map.put(PQCObjectIdentifiers.xmss_mt, new a(24));
        map.put(IsaraObjectIdentifiers.id_alg_xmss, new a(23));
        map.put(IsaraObjectIdentifiers.id_alg_xmssmt, new a(24));
        map.put(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new a(6));
        map.put(PQCObjectIdentifiers.mcElieceCca2, new a(10));
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_128s_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_128f_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_128s_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_128f_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_128s_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_128f_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_192s_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_192f_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_192s_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_192f_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_192s_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_192f_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_256s_r3);
        map.put(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3, new a(21));
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_256s_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_256f_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_256s_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_256f_r3);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_128s_r3_simple);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_128f_r3_simple);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_192s_r3_simple);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_192f_r3_simple);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_256s_r3_simple);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_haraka_256f_r3_simple);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_128s);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_128f);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_128s);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_128f);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_192s);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_192f);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_192s);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_192f);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_256s);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_sha2_256f);
        B2.b.u(map, BCObjectIdentifiers.sphincsPlus_shake_256s);
        map.put(BCObjectIdentifiers.sphincsPlus_shake_256f, new a(21));
        B2.b.u(map, new C0896n("1.3.9999.6.4.10"));
        map.put(BCObjectIdentifiers.mceliece348864_r3, new a(1));
        map.put(BCObjectIdentifiers.mceliece348864f_r3, new a(1));
        HashMap map2 = f795a;
        map2.put(BCObjectIdentifiers.mceliece460896_r3, new a(1));
        map2.put(BCObjectIdentifiers.mceliece460896f_r3, new a(1));
        map2.put(BCObjectIdentifiers.mceliece6688128_r3, new a(1));
        map2.put(BCObjectIdentifiers.mceliece6688128f_r3, new a(1));
        map2.put(BCObjectIdentifiers.mceliece6960119_r3, new a(1));
        map2.put(BCObjectIdentifiers.mceliece6960119f_r3, new a(1));
        map2.put(BCObjectIdentifiers.mceliece8192128_r3, new a(1));
        map2.put(BCObjectIdentifiers.mceliece8192128f_r3, new a(1));
        map2.put(BCObjectIdentifiers.frodokem640aes, new a(4));
        map2.put(BCObjectIdentifiers.frodokem640shake, new a(4));
        map2.put(BCObjectIdentifiers.frodokem976aes, new a(4));
        map2.put(BCObjectIdentifiers.frodokem976shake, new a(4));
        map2.put(BCObjectIdentifiers.frodokem1344aes, new a(4));
        map2.put(BCObjectIdentifiers.frodokem1344shake, new a(4));
        map2.put(BCObjectIdentifiers.lightsaberkem128r3, new a(17));
        map2.put(BCObjectIdentifiers.saberkem128r3, new a(17));
        map2.put(BCObjectIdentifiers.firesaberkem128r3, new a(17));
        map2.put(BCObjectIdentifiers.lightsaberkem192r3, new a(17));
        map2.put(BCObjectIdentifiers.saberkem192r3, new a(17));
        map2.put(BCObjectIdentifiers.firesaberkem192r3, new a(17));
        map2.put(BCObjectIdentifiers.lightsaberkem256r3, new a(17));
        map2.put(BCObjectIdentifiers.saberkem256r3, new a(17));
        map2.put(BCObjectIdentifiers.firesaberkem256r3, new a(17));
        map2.put(BCObjectIdentifiers.ulightsaberkemr3, new a(17));
        map2.put(BCObjectIdentifiers.usaberkemr3, new a(17));
        map2.put(BCObjectIdentifiers.ufiresaberkemr3, new a(17));
        map2.put(BCObjectIdentifiers.lightsaberkem90sr3, new a(17));
        map2.put(BCObjectIdentifiers.saberkem90sr3, new a(17));
        map2.put(BCObjectIdentifiers.firesaberkem90sr3, new a(17));
        map2.put(BCObjectIdentifiers.ulightsaberkem90sr3, new a(17));
        map2.put(BCObjectIdentifiers.usaberkem90sr3, new a(17));
        map2.put(BCObjectIdentifiers.ufiresaberkem90sr3, new a(17));
        map2.put(BCObjectIdentifiers.picnicl1fs, new a(14));
        map2.put(BCObjectIdentifiers.picnicl1ur, new a(14));
        map2.put(BCObjectIdentifiers.picnicl3fs, new a(14));
        map2.put(BCObjectIdentifiers.picnicl3ur, new a(14));
        map2.put(BCObjectIdentifiers.picnicl5fs, new a(14));
        map2.put(BCObjectIdentifiers.picnicl5ur, new a(14));
        map2.put(BCObjectIdentifiers.picnic3l1, new a(14));
        map2.put(BCObjectIdentifiers.picnic3l3, new a(14));
        map2.put(BCObjectIdentifiers.picnic3l5, new a(14));
        map2.put(BCObjectIdentifiers.picnicl1full, new a(14));
        map2.put(BCObjectIdentifiers.picnicl3full, new a(14));
        map2.put(BCObjectIdentifiers.picnicl5full, new a(14));
        map2.put(BCObjectIdentifiers.ntruhps2048509, new a(13));
        map2.put(BCObjectIdentifiers.ntruhps2048677, new a(13));
        map2.put(BCObjectIdentifiers.ntruhps4096821, new a(13));
        map2.put(BCObjectIdentifiers.ntruhps40961229, new a(13));
        map2.put(BCObjectIdentifiers.ntruhrss701, new a(13));
        HashMap map3 = f795a;
        map3.put(BCObjectIdentifiers.ntruhrss1373, new a(13));
        map3.put(BCObjectIdentifiers.falcon_512, new a(3));
        map3.put(BCObjectIdentifiers.falcon_1024, new a(3));
        map3.put(NISTObjectIdentifiers.id_alg_ml_kem_512, new a(8));
        map3.put(NISTObjectIdentifiers.id_alg_ml_kem_768, new a(8));
        map3.put(NISTObjectIdentifiers.id_alg_ml_kem_1024, new a(8));
        map3.put(BCObjectIdentifiers.kyber512_aes, new a(8));
        map3.put(BCObjectIdentifiers.kyber768_aes, new a(8));
        map3.put(BCObjectIdentifiers.kyber1024_aes, new a(8));
        map3.put(BCObjectIdentifiers.ntrulpr653, new a(12));
        map3.put(BCObjectIdentifiers.ntrulpr761, new a(12));
        map3.put(BCObjectIdentifiers.ntrulpr857, new a(12));
        map3.put(BCObjectIdentifiers.ntrulpr953, new a(12));
        map3.put(BCObjectIdentifiers.ntrulpr1013, new a(12));
        map3.put(BCObjectIdentifiers.ntrulpr1277, new a(12));
        map3.put(BCObjectIdentifiers.sntrup653, new a(19));
        map3.put(BCObjectIdentifiers.sntrup761, new a(19));
        map3.put(BCObjectIdentifiers.sntrup857, new a(19));
        map3.put(BCObjectIdentifiers.sntrup953, new a(19));
        map3.put(BCObjectIdentifiers.sntrup1013, new a(19));
        map3.put(BCObjectIdentifiers.sntrup1277, new a(19));
        map3.put(NISTObjectIdentifiers.id_ml_dsa_44, new a(7));
        map3.put(NISTObjectIdentifiers.id_ml_dsa_65, new a(7));
        map3.put(NISTObjectIdentifiers.id_ml_dsa_87, new a(7));
        map3.put(NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512, new a(7));
        map3.put(NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512, new a(7));
        map3.put(NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512, new a(7));
        map3.put(BCObjectIdentifiers.dilithium2, new a(2));
        map3.put(BCObjectIdentifiers.dilithium3, new a(2));
        map3.put(BCObjectIdentifiers.dilithium5, new a(2));
        map3.put(BCObjectIdentifiers.dilithium2_aes, new a(2));
        map3.put(BCObjectIdentifiers.dilithium3_aes, new a(2));
        map3.put(BCObjectIdentifiers.dilithium5_aes, new a(2));
        map3.put(BCObjectIdentifiers.bike128, new a(0));
        map3.put(BCObjectIdentifiers.bike192, new a(0));
        map3.put(BCObjectIdentifiers.bike256, new a(0));
        map3.put(BCObjectIdentifiers.hqc128, new a(5));
        map3.put(BCObjectIdentifiers.hqc192, new a(5));
        map3.put(BCObjectIdentifiers.hqc256, new a(5));
        map3.put(BCObjectIdentifiers.rainbow_III_classic, new a(16));
        map3.put(BCObjectIdentifiers.rainbow_III_circumzenithal, new a(16));
        map3.put(BCObjectIdentifiers.rainbow_III_compressed, new a(16));
        map3.put(BCObjectIdentifiers.rainbow_V_classic, new a(16));
        map3.put(BCObjectIdentifiers.rainbow_V_circumzenithal, new a(16));
        map3.put(BCObjectIdentifiers.rainbow_V_compressed, new a(16));
        B2.b.s(map3, NISTObjectIdentifiers.id_slh_dsa_sha2_128s);
        B2.b.s(map3, NISTObjectIdentifiers.id_slh_dsa_sha2_128f);
        B2.b.s(map3, NISTObjectIdentifiers.id_slh_dsa_sha2_192s);
        B2.b.s(map3, NISTObjectIdentifiers.id_slh_dsa_sha2_192f);
        HashMap map4 = f795a;
        B2.b.s(map4, NISTObjectIdentifiers.id_slh_dsa_sha2_256s);
        B2.b.s(map4, NISTObjectIdentifiers.id_slh_dsa_sha2_256f);
        map4.put(NISTObjectIdentifiers.id_slh_dsa_shake_128s, new a(18));
        B2.b.s(map4, NISTObjectIdentifiers.id_slh_dsa_shake_128f);
        B2.b.s(map4, NISTObjectIdentifiers.id_slh_dsa_shake_192s);
        B2.b.s(map4, NISTObjectIdentifiers.id_slh_dsa_shake_192f);
        B2.b.s(map4, NISTObjectIdentifiers.id_slh_dsa_shake_256s);
        B2.b.s(map4, NISTObjectIdentifiers.id_slh_dsa_shake_256f);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256);
        B2.b.s(map4, NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256);
        map4.put(BCObjectIdentifiers.mayo1, new a(9));
        map4.put(BCObjectIdentifiers.mayo2, new a(9));
        map4.put(BCObjectIdentifiers.mayo3, new a(9));
        map4.put(BCObjectIdentifiers.mayo5, new a(9));
        B2.b.v(map4, BCObjectIdentifiers.snova_24_5_4_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_24_5_4_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_24_5_4_shake_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_24_5_4_shake_ssk);
        map4.put(BCObjectIdentifiers.snova_24_5_5_esk, new a(22));
        B2.b.v(map4, BCObjectIdentifiers.snova_24_5_5_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_24_5_5_shake_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_24_5_5_shake_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_25_8_3_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_25_8_3_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_25_8_3_shake_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_25_8_3_shake_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_29_6_5_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_29_6_5_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_29_6_5_shake_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_29_6_5_shake_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_37_8_4_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_37_8_4_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_37_8_4_shake_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_37_8_4_shake_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_37_17_2_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_37_17_2_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_37_17_2_shake_esk);
        B2.b.v(map4, BCObjectIdentifiers.snova_37_17_2_shake_ssk);
        B2.b.v(map4, BCObjectIdentifiers.snova_49_11_3_esk);
        HashMap map5 = f795a;
        B2.b.v(map5, BCObjectIdentifiers.snova_49_11_3_ssk);
        B2.b.v(map5, BCObjectIdentifiers.snova_49_11_3_shake_esk);
        B2.b.v(map5, BCObjectIdentifiers.snova_49_11_3_shake_ssk);
        B2.b.v(map5, BCObjectIdentifiers.snova_56_25_2_esk);
        map5.put(BCObjectIdentifiers.snova_56_25_2_ssk, new a(22));
        B2.b.v(map5, BCObjectIdentifiers.snova_56_25_2_shake_esk);
        B2.b.v(map5, BCObjectIdentifiers.snova_56_25_2_shake_ssk);
        B2.b.v(map5, BCObjectIdentifiers.snova_60_10_4_esk);
        B2.b.v(map5, BCObjectIdentifiers.snova_60_10_4_ssk);
        B2.b.v(map5, BCObjectIdentifiers.snova_60_10_4_shake_esk);
        B2.b.v(map5, BCObjectIdentifiers.snova_60_10_4_shake_ssk);
        B2.b.v(map5, BCObjectIdentifiers.snova_66_15_3_esk);
        B2.b.v(map5, BCObjectIdentifiers.snova_66_15_3_ssk);
        B2.b.v(map5, BCObjectIdentifiers.snova_66_15_3_shake_esk);
        B2.b.v(map5, BCObjectIdentifiers.snova_66_15_3_shake_ssk);
        B2.b.v(map5, BCObjectIdentifiers.snova_75_33_2_esk);
        B2.b.v(map5, BCObjectIdentifiers.snova_75_33_2_ssk);
        B2.b.v(map5, BCObjectIdentifiers.snova_75_33_2_shake_esk);
        B2.b.v(map5, BCObjectIdentifiers.snova_75_33_2_shake_ssk);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v93, types: [Q3.a] */
    /* JADX WARN: Type inference failed for: r1v15, types: [v4.c] */
    /* JADX WARN: Type inference failed for: r1v21, types: [r4.d] */
    /* JADX WARN: Type inference failed for: r1v27, types: [q4.c] */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.bouncycastle.pqc.crypto.slhdsa.g] */
    /* JADX WARN: Type inference failed for: r1v34, types: [t4.c] */
    /* JADX WARN: Type inference failed for: r1v36, types: [B4.a, u4.c] */
    /* JADX WARN: Type inference failed for: r1v39, types: [z4.e] */
    /* JADX WARN: Type inference failed for: r1v41, types: [x4.c] */
    /* JADX WARN: Type inference failed for: r1v46, types: [C4.c] */
    /* JADX WARN: Type inference failed for: r1v51, types: [B4.d] */
    /* JADX WARN: Type inference failed for: r1v53, types: [B4.d] */
    /* JADX WARN: Type inference failed for: r1v58, types: [D4.c] */
    /* JADX WARN: Type inference failed for: r1v65, types: [B4.a, E4.e] */
    /* JADX WARN: Type inference failed for: r1v68, types: [F4.c] */
    /* JADX WARN: Type inference failed for: r1v70, types: [C4.f] */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v75, types: [G4.c] */
    /* JADX WARN: Type inference failed for: r1v9, types: [org.bouncycastle.pqc.crypto.sphincsplus.g] */
    public static Q3.a a(d dVar) throws IOException {
        ?? gVar;
        Q3.a gVar2;
        int i;
        Q3.a aVarA;
        if (dVar == null) {
            throw new IllegalArgumentException("keyInfo argument null");
        }
        HashMap map = f795a;
        H3.a aVar = dVar.f748a;
        a aVar2 = (a) map.get(aVar.f747a);
        if (aVar2 == null) {
            throw new IOException("algorithm identifier in public key not recognised: " + aVar.f747a);
        }
        switch (aVar2.f794a) {
            case 0:
                try {
                    gVar2 = new C0791c((C0789a) c.E.get(dVar.f748a.f747a), AbstractC0897o.j(dVar.c()).f5066a);
                    return gVar2;
                } catch (Exception unused) {
                    gVar = new C0791c((C0789a) c.E.get(dVar.f748a.f747a), dVar.b.n());
                }
                break;
            case 1:
                try {
                    gVar2 = new r4.d((C0806b) c.q.get(dVar.f748a.f747a), g5.c.c(C0749b.b(dVar.c()).f4361a));
                    return gVar2;
                } catch (Exception unused2) {
                    gVar = new r4.d((C0806b) c.q.get(dVar.f748a.f747a), dVar.b.n());
                }
                break;
            case 2:
                return a.a((C0814a) c.C.get(dVar.f748a.f747a), dVar.b);
            case 3:
                byte[] bArrN = dVar.b.n();
                gVar = new t4.c((C0829a) c.f823w.get(dVar.f748a.f747a), g5.c.h(bArrN, 1, bArrN.length));
                return gVar;
            case 4:
                byte[] bArr = AbstractC0897o.j(dVar.c()).f5066a;
                gVar = new u4.c((C0844a) c.f815m.get(dVar.f748a.f747a), false);
                gVar.c = g5.c.c(bArr);
                return gVar;
            case 5:
                try {
                    gVar2 = new v4.c((C0858a) c.f800G.get(dVar.f748a.f747a), AbstractC0897o.j(dVar.c()).f5066a);
                    return gVar2;
                } catch (Exception unused3) {
                    gVar = new v4.c((C0858a) c.f800G.get(dVar.f748a.f747a), dVar.b.n());
                }
                break;
            case 6:
                byte[] bArrN2 = dVar.b.n();
                AbstractC0897o abstractC0897o = (AbstractC0897o) c.e(bArrN2);
                aVarA = abstractC0897o != null ? C0910c.a(abstractC0897o.f5066a) : C0910c.a(bArrN2);
                return aVarA;
            case 7:
                return a.b((C0938b) c.f803M.get(dVar.f748a.f747a), dVar.b);
            case 8:
                gVar = new e((z4.c) c.f801K.get(dVar.f748a.f747a), dVar.b.n());
                return gVar;
            case 9:
                gVar = new x4.c((C0926a) c.f807Q.get(dVar.f748a.f747a), AbstractC0897o.j(dVar.c()).f5066a);
                return gVar;
            case 10:
                AbstractC0899q abstractC0899qC = dVar.c();
                f fVar = abstractC0899qC != null ? new f(AbstractC0902u.l(abstractC0899qC)) : null;
                int i3 = fVar.f4366a;
                d5.b bVar = new d5.b(false, c.c(fVar.d.f747a));
                bVar.c = i3;
                bVar.d = fVar.b;
                f5.a aVar3 = new f5.a();
                f5.a aVar4 = fVar.c;
                aVar3.b = aVar4.b;
                aVar3.f3253a = aVar4.f3253a;
                aVar3.d = aVar4.d;
                int[][] iArr = aVar4.c;
                aVar3.c = new int[iArr.length][];
                int i4 = 0;
                while (true) {
                    int[][] iArr2 = aVar3.c;
                    if (i4 >= iArr2.length) {
                        bVar.e = aVar3;
                        aVarA = bVar;
                        return aVarA;
                    }
                    int[] iArr3 = iArr[i4];
                    int[] iArr4 = new int[iArr3.length];
                    System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
                    iArr2[i4] = iArr4;
                    i4++;
                }
                break;
            case 11:
                return new A4.b(dVar.b.k());
            case 12:
                gVar = new C4.c((C4.a) c.y.get(dVar.f748a.f747a), AbstractC0897o.j(dVar.c()).f5066a);
                return gVar;
            case 13:
                byte[] bArrN3 = dVar.b.n();
                AbstractC0897o abstractC0897oJ = (c.d(bArrN3) || bArrN3[0] != 4) ? null : AbstractC0897o.j(bArrN3);
                gVar = abstractC0897oJ != null ? new B4.d((B4.b) c.u.get(dVar.f748a.f747a), abstractC0897oJ.f5066a) : new B4.d((B4.b) c.u.get(dVar.f748a.f747a), bArrN3);
                return gVar;
            case 14:
                gVar = new D4.c((D4.a) c.f813k.get(dVar.f748a.f747a), AbstractC0897o.j(dVar.c()).f5066a);
                return gVar;
            case 15:
                int iIntValue = ((Integer) c.i.get(dVar.f748a.f747a)).intValue();
                byte[] bArrN4 = dVar.b.n();
                e5.b bVar2 = new e5.b(false);
                int length = bArrN4.length;
                if (iIntValue == 5) {
                    i = 14880;
                } else {
                    if (iIntValue != 6) {
                        throw new IllegalArgumentException(B2.b.c(iIntValue, "unknown security category: "));
                    }
                    i = 38432;
                }
                if (length != i) {
                    throw new IllegalArgumentException("invalid key size for security category");
                }
                bVar2.b = iIntValue;
                bVar2.c = g5.c.c(bArrN4);
                return bVar2;
            case 16:
                byte[] bArr2 = AbstractC0897o.j(dVar.c()).f5066a;
                E4.c cVar = (E4.c) c.I.get(dVar.f748a.f747a);
                gVar = new E4.e(false, cVar);
                int i5 = cVar.f329g;
                Class cls = Short.TYPE;
                if (i5 == 1) {
                    int i6 = cVar.d;
                    int[] iArr5 = {i, i6, i6};
                    int i7 = cVar.e;
                    gVar.c = (short[][][]) Array.newInstance((Class<?>) cls, iArr5);
                    int i8 = 0;
                    for (int i9 = 0; i9 < i6; i9++) {
                        for (int i10 = 0; i10 < i6; i10++) {
                            for (int i11 = 0; i11 < i7; i11++) {
                                short[][][] sArr = gVar.c;
                                if (i9 > i10) {
                                    sArr[i11][i9][i10] = 0;
                                } else {
                                    sArr[i11][i9][i10] = (short) (bArr2[i8] & 255);
                                    i8++;
                                }
                            }
                        }
                    }
                } else {
                    gVar.d = g5.c.h(bArr2, 0, 32);
                    int i12 = cVar.c;
                    int[] iArr6 = {i, cVar.f327a, i12};
                    int i13 = cVar.b;
                    short[][][] sArr2 = (short[][][]) Array.newInstance((Class<?>) cls, iArr6);
                    gVar.e = sArr2;
                    short[][][] sArr3 = (short[][][]) Array.newInstance((Class<?>) cls, i13, i13, i13);
                    gVar.f340f = sArr3;
                    short[][][] sArr4 = (short[][][]) Array.newInstance((Class<?>) cls, i13, i13, i12);
                    gVar.f341g = sArr4;
                    short[][][] sArr5 = (short[][][]) Array.newInstance((Class<?>) cls, i13, i12, i12);
                    gVar.f342h = sArr5;
                    short[][][] sArr6 = (short[][][]) Array.newInstance((Class<?>) cls, i12, i12, i12);
                    gVar.i = sArr6;
                    int iP = AbstractC0132a.P(sArr2, bArr2, 32, false) + 32;
                    int iP2 = AbstractC0132a.P(sArr3, bArr2, iP, true) + iP;
                    int iP3 = AbstractC0132a.P(sArr4, bArr2, iP2, false) + iP2;
                    int iP4 = AbstractC0132a.P(sArr5, bArr2, iP3, true) + iP3;
                    if (AbstractC0132a.P(sArr6, bArr2, iP4, true) + iP4 != bArr2.length) {
                        throw new IllegalArgumentException("unparsed data in key encoding");
                    }
                }
                return gVar;
            case 17:
                gVar = new F4.c((F4.a) c.f817o.get(dVar.f748a.f747a), AbstractC0897o.j(AbstractC0902u.l(dVar.c()).m(0)).f5066a);
                return gVar;
            case 18:
                try {
                    byte[] bArr3 = AbstractC0897o.j(dVar.c()).f5066a;
                    gVar2 = new g((org.bouncycastle.pqc.crypto.slhdsa.e) c.f805O.get(dVar.f748a.f747a), g5.c.h(bArr3, 4, bArr3.length));
                    return gVar2;
                } catch (Exception unused4) {
                    gVar = new g((org.bouncycastle.pqc.crypto.slhdsa.e) c.f805O.get(dVar.f748a.f747a), dVar.b.n());
                }
                break;
            case 19:
                gVar = new C4.f((C4.d) c.f796A.get(dVar.f748a.f747a), AbstractC0897o.j(dVar.c()).f5066a);
                return gVar;
            case 20:
                return new H4.c(c.h(o4.g.b(dVar.f748a.b)), dVar.b.k());
            case 21:
                try {
                    byte[] bArr4 = AbstractC0897o.j(dVar.c()).f5066a;
                    gVar2 = new org.bouncycastle.pqc.crypto.sphincsplus.g((org.bouncycastle.pqc.crypto.sphincsplus.e) c.f820s.get(dVar.f748a.f747a), g5.c.h(bArr4, 4, bArr4.length));
                    return gVar2;
                } catch (Exception unused5) {
                    gVar = new org.bouncycastle.pqc.crypto.sphincsplus.g((org.bouncycastle.pqc.crypto.sphincsplus.e) c.f820s.get(dVar.f748a.f747a), dVar.b.n());
                }
                break;
            case 22:
                gVar = new G4.c((G4.a) c.S.get(dVar.f748a.f747a), AbstractC0897o.j(dVar.c()).f5066a);
                return gVar;
            case 23:
                j jVarB = j.b(dVar.f748a.b);
                if (jVarB == null) {
                    byte[] bArr5 = AbstractC0897o.j(dVar.c()).f5066a;
                    t tVar = new t((J4.t) J4.t.i.get(Integer.valueOf(g5.c.b(0, bArr5))), 5);
                    tVar.e = C5.f.j(bArr5);
                    aVarA = new w(tVar);
                    return aVarA;
                }
                C0896n c0896n = jVarB.c.f747a;
                AbstractC0899q abstractC0899qC2 = dVar.c();
                o oVar = abstractC0899qC2 != null ? new o(AbstractC0902u.l(abstractC0899qC2)) : null;
                t tVar2 = new t(new J4.t(jVarB.b, c.b(c0896n)), 5);
                tVar2.d = C5.f.j(g5.c.c(oVar.f4381a));
                tVar2.c = C5.f.j(g5.c.c(oVar.b));
                return new w(tVar2);
            default:
                k kVarB = k.b(dVar.f748a.b);
                if (kVarB == null) {
                    byte[] bArr6 = AbstractC0897o.j(dVar.c()).f5066a;
                    t tVar3 = new t((J4.o) J4.o.e.get(Integer.valueOf(g5.c.b(0, bArr6))), 4);
                    tVar3.e = C5.f.j(bArr6);
                    aVarA = new r(tVar3);
                    return aVarA;
                }
                C0896n c0896n2 = kVarB.d.f747a;
                AbstractC0899q abstractC0899qC3 = dVar.c();
                o oVar2 = abstractC0899qC3 != null ? new o(AbstractC0902u.l(abstractC0899qC3)) : null;
                t tVar4 = new t(new J4.o(kVarB.b, kVarB.c, c.b(c0896n2)), 4);
                tVar4.d = C5.f.j(g5.c.c(oVar2.f4381a));
                tVar4.c = C5.f.j(g5.c.c(oVar2.b));
                return new r(tVar4);
        }
    }
}
