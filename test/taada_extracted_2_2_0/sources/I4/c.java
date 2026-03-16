package I4;

import C4.d;
import N3.f;
import N3.g;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.internal.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.slhdsa.e;
import q4.C0789a;
import r4.C0806b;
import s4.C0814a;
import t4.C0829a;
import u4.C0844a;
import v4.C0858a;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0896n;
import w3.H;
import w3.U;
import x4.C0926a;
import y4.C0938b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final HashMap f796A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final HashMap f797B;
    public static final HashMap C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final HashMap f798D;
    public static final HashMap E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final HashMap f799F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final HashMap f800G;
    public static final HashMap H;
    public static final HashMap I;
    public static final HashMap J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final HashMap f801K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final HashMap f802L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final HashMap f803M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final HashMap f804N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final HashMap f805O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final HashMap f806P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final HashMap f807Q;
    public static final HashMap R;
    public static final HashMap S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H3.a f808a;
    public static final H3.a b;
    public static final H3.a c;
    public static final H3.a d;
    public static final H3.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final H3.a f809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final H3.a f810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final H3.a f811h;
    public static final HashMap i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap f814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashMap f815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap f816n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final HashMap f817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashMap f818p;
    public static final HashMap q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final HashMap f819r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final HashMap f820s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final HashMap f821t;
    public static final HashMap u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final HashMap f822v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final HashMap f823w;
    public static final HashMap x;
    public static final HashMap y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final HashMap f824z;

    static {
        C0896n c0896n = PQCObjectIdentifiers.qTESLA_p_I;
        f808a = new H3.a(c0896n);
        C0896n c0896n2 = PQCObjectIdentifiers.qTESLA_p_III;
        b = new H3.a(c0896n2);
        c = new H3.a(NISTObjectIdentifiers.id_sha3_256);
        d = new H3.a(NISTObjectIdentifiers.id_sha512_256);
        e = new H3.a(NISTObjectIdentifiers.id_sha256);
        f809f = new H3.a(NISTObjectIdentifiers.id_sha512);
        f810g = new H3.a(NISTObjectIdentifiers.id_shake128);
        f811h = new H3.a(NISTObjectIdentifiers.id_shake256);
        HashMap map = new HashMap();
        i = map;
        HashMap map2 = new HashMap();
        f812j = map2;
        HashMap map3 = new HashMap();
        f813k = map3;
        HashMap map4 = new HashMap();
        f814l = map4;
        HashMap map5 = new HashMap();
        f815m = map5;
        HashMap map6 = new HashMap();
        f816n = map6;
        HashMap map7 = new HashMap();
        f817o = map7;
        HashMap map8 = new HashMap();
        f818p = map8;
        HashMap map9 = new HashMap();
        q = map9;
        HashMap map10 = new HashMap();
        f819r = map10;
        HashMap map11 = new HashMap();
        f820s = map11;
        new HashMap();
        new HashMap();
        HashMap map12 = new HashMap();
        f821t = map12;
        HashMap map13 = new HashMap();
        u = map13;
        HashMap map14 = new HashMap();
        f822v = map14;
        HashMap map15 = new HashMap();
        f823w = map15;
        HashMap map16 = new HashMap();
        x = map16;
        HashMap map17 = new HashMap();
        y = map17;
        HashMap map18 = new HashMap();
        f824z = map18;
        HashMap map19 = new HashMap();
        f796A = map19;
        HashMap map20 = new HashMap();
        f797B = map20;
        HashMap map21 = new HashMap();
        C = map21;
        HashMap map22 = new HashMap();
        f798D = map22;
        HashMap map23 = new HashMap();
        E = map23;
        HashMap map24 = new HashMap();
        f799F = map24;
        HashMap map25 = new HashMap();
        f800G = map25;
        HashMap map26 = new HashMap();
        H = map26;
        HashMap map27 = new HashMap();
        I = map27;
        HashMap map28 = new HashMap();
        J = map28;
        HashMap map29 = new HashMap();
        f801K = map29;
        HashMap map30 = new HashMap();
        f802L = map30;
        HashMap map31 = new HashMap();
        f803M = map31;
        HashMap map32 = new HashMap();
        f804N = map32;
        HashMap map33 = new HashMap();
        f805O = map33;
        HashMap map34 = new HashMap();
        f806P = map34;
        HashMap map35 = new HashMap();
        f807Q = map35;
        HashMap map36 = new HashMap();
        R = map36;
        HashMap map37 = new HashMap();
        S = map37;
        map.put(c0896n, 5);
        map.put(c0896n2, 6);
        C0806b c0806b = C0806b.d;
        C0896n c0896n3 = BCObjectIdentifiers.mceliece348864_r3;
        map8.put(c0806b, c0896n3);
        C0806b c0806b2 = C0806b.e;
        C0896n c0896n4 = BCObjectIdentifiers.mceliece348864f_r3;
        map8.put(c0806b2, c0896n4);
        C0806b c0806b3 = C0806b.f4731f;
        C0896n c0896n5 = BCObjectIdentifiers.mceliece460896_r3;
        map8.put(c0806b3, c0896n5);
        C0806b c0806b4 = C0806b.f4732g;
        C0896n c0896n6 = BCObjectIdentifiers.mceliece460896f_r3;
        map8.put(c0806b4, c0896n6);
        C0806b c0806b5 = C0806b.f4733h;
        C0896n c0896n7 = BCObjectIdentifiers.mceliece6688128_r3;
        map8.put(c0806b5, c0896n7);
        C0806b c0806b6 = C0806b.i;
        C0896n c0896n8 = BCObjectIdentifiers.mceliece6688128f_r3;
        map8.put(c0806b6, c0896n8);
        C0806b c0806b7 = C0806b.f4734j;
        C0896n c0896n9 = BCObjectIdentifiers.mceliece6960119_r3;
        map8.put(c0806b7, c0896n9);
        C0806b c0806b8 = C0806b.f4735k;
        C0896n c0896n10 = BCObjectIdentifiers.mceliece6960119f_r3;
        map8.put(c0806b8, c0896n10);
        C0806b c0806b9 = C0806b.f4736l;
        C0896n c0896n11 = BCObjectIdentifiers.mceliece8192128_r3;
        map8.put(c0806b9, c0896n11);
        C0806b c0806b10 = C0806b.f4737m;
        C0896n c0896n12 = BCObjectIdentifiers.mceliece8192128f_r3;
        map8.put(c0806b10, c0896n12);
        map9.put(c0896n3, c0806b);
        map9.put(c0896n4, c0806b2);
        map9.put(c0896n5, c0806b3);
        map9.put(c0896n6, c0806b4);
        map9.put(c0896n7, c0806b5);
        map9.put(c0896n8, c0806b6);
        map9.put(c0896n9, c0806b7);
        map9.put(c0896n10, c0806b8);
        map9.put(c0896n11, c0806b9);
        map9.put(c0896n12, c0806b10);
        C0844a c0844a = C0844a.f4887a;
        C0896n c0896n13 = BCObjectIdentifiers.frodokem640aes;
        map4.put(c0844a, c0896n13);
        C0844a c0844a2 = C0844a.b;
        C0896n c0896n14 = BCObjectIdentifiers.frodokem640shake;
        map4.put(c0844a2, c0896n14);
        C0844a c0844a3 = C0844a.c;
        C0896n c0896n15 = BCObjectIdentifiers.frodokem976aes;
        map4.put(c0844a3, c0896n15);
        C0844a c0844a4 = C0844a.d;
        C0896n c0896n16 = BCObjectIdentifiers.frodokem976shake;
        map4.put(c0844a4, c0896n16);
        C0844a c0844a5 = C0844a.e;
        C0896n c0896n17 = BCObjectIdentifiers.frodokem1344aes;
        map4.put(c0844a5, c0896n17);
        C0844a c0844a6 = C0844a.f4888f;
        C0896n c0896n18 = BCObjectIdentifiers.frodokem1344shake;
        map4.put(c0844a6, c0896n18);
        map5.put(c0896n13, c0844a);
        map5.put(c0896n14, c0844a2);
        map5.put(c0896n15, c0844a3);
        map5.put(c0896n16, c0844a4);
        map5.put(c0896n17, c0844a5);
        map5.put(c0896n18, c0844a6);
        F4.a aVar = F4.a.f364a;
        C0896n c0896n19 = BCObjectIdentifiers.lightsaberkem128r3;
        map6.put(aVar, c0896n19);
        F4.a aVar2 = F4.a.b;
        C0896n c0896n20 = BCObjectIdentifiers.saberkem128r3;
        map6.put(aVar2, c0896n20);
        F4.a aVar3 = F4.a.c;
        C0896n c0896n21 = BCObjectIdentifiers.firesaberkem128r3;
        map6.put(aVar3, c0896n21);
        F4.a aVar4 = F4.a.d;
        C0896n c0896n22 = BCObjectIdentifiers.lightsaberkem192r3;
        map6.put(aVar4, c0896n22);
        F4.a aVar5 = F4.a.e;
        C0896n c0896n23 = BCObjectIdentifiers.saberkem192r3;
        map6.put(aVar5, c0896n23);
        F4.a aVar6 = F4.a.f365f;
        C0896n c0896n24 = BCObjectIdentifiers.firesaberkem192r3;
        map6.put(aVar6, c0896n24);
        F4.a aVar7 = F4.a.f366g;
        C0896n c0896n25 = BCObjectIdentifiers.lightsaberkem256r3;
        map6.put(aVar7, c0896n25);
        F4.a aVar8 = F4.a.f367h;
        C0896n c0896n26 = BCObjectIdentifiers.saberkem256r3;
        map6.put(aVar8, c0896n26);
        F4.a aVar9 = F4.a.i;
        C0896n c0896n27 = BCObjectIdentifiers.firesaberkem256r3;
        map6.put(aVar9, c0896n27);
        F4.a aVar10 = F4.a.f371m;
        C0896n c0896n28 = BCObjectIdentifiers.ulightsaberkemr3;
        map6.put(aVar10, c0896n28);
        F4.a aVar11 = F4.a.f372n;
        C0896n c0896n29 = BCObjectIdentifiers.usaberkemr3;
        map6.put(aVar11, c0896n29);
        F4.a aVar12 = F4.a.f373o;
        C0896n c0896n30 = BCObjectIdentifiers.ufiresaberkemr3;
        map6.put(aVar12, c0896n30);
        F4.a aVar13 = F4.a.f368j;
        C0896n c0896n31 = BCObjectIdentifiers.lightsaberkem90sr3;
        map6.put(aVar13, c0896n31);
        F4.a aVar14 = F4.a.f369k;
        C0896n c0896n32 = BCObjectIdentifiers.saberkem90sr3;
        map6.put(aVar14, c0896n32);
        F4.a aVar15 = F4.a.f370l;
        C0896n c0896n33 = BCObjectIdentifiers.firesaberkem90sr3;
        map6.put(aVar15, c0896n33);
        F4.a aVar16 = F4.a.f374p;
        C0896n c0896n34 = BCObjectIdentifiers.ulightsaberkem90sr3;
        map6.put(aVar16, c0896n34);
        F4.a aVar17 = F4.a.q;
        C0896n c0896n35 = BCObjectIdentifiers.usaberkem90sr3;
        map6.put(aVar17, c0896n35);
        F4.a aVar18 = F4.a.f375r;
        C0896n c0896n36 = BCObjectIdentifiers.ufiresaberkem90sr3;
        map6.put(aVar18, c0896n36);
        map7.put(c0896n19, aVar);
        map7.put(c0896n20, aVar2);
        map7.put(c0896n21, aVar3);
        map7.put(c0896n22, aVar4);
        map7.put(c0896n23, aVar5);
        map7.put(c0896n24, aVar6);
        map7.put(c0896n25, aVar7);
        map7.put(c0896n26, aVar8);
        map7.put(c0896n27, aVar9);
        map7.put(c0896n28, aVar10);
        map7.put(c0896n29, aVar11);
        map7.put(c0896n30, aVar12);
        map7.put(c0896n31, aVar13);
        map7.put(c0896n32, aVar14);
        map7.put(c0896n33, aVar15);
        map7.put(c0896n34, aVar16);
        map7.put(c0896n35, aVar17);
        map7.put(c0896n36, aVar18);
        D4.a aVar19 = D4.a.b;
        C0896n c0896n37 = BCObjectIdentifiers.picnicl1fs;
        map2.put(aVar19, c0896n37);
        D4.a aVar20 = D4.a.c;
        C0896n c0896n38 = BCObjectIdentifiers.picnicl1ur;
        map2.put(aVar20, c0896n38);
        D4.a aVar21 = D4.a.d;
        C0896n c0896n39 = BCObjectIdentifiers.picnicl3fs;
        map2.put(aVar21, c0896n39);
        D4.a aVar22 = D4.a.e;
        C0896n c0896n40 = BCObjectIdentifiers.picnicl3ur;
        map2.put(aVar22, c0896n40);
        D4.a aVar23 = D4.a.f270f;
        C0896n c0896n41 = BCObjectIdentifiers.picnicl5fs;
        map2.put(aVar23, c0896n41);
        D4.a aVar24 = D4.a.f271g;
        C0896n c0896n42 = BCObjectIdentifiers.picnicl5ur;
        map2.put(aVar24, c0896n42);
        D4.a aVar25 = D4.a.f272h;
        C0896n c0896n43 = BCObjectIdentifiers.picnic3l1;
        map2.put(aVar25, c0896n43);
        D4.a aVar26 = D4.a.i;
        C0896n c0896n44 = BCObjectIdentifiers.picnic3l3;
        map2.put(aVar26, c0896n44);
        D4.a aVar27 = D4.a.f273j;
        C0896n c0896n45 = BCObjectIdentifiers.picnic3l5;
        map2.put(aVar27, c0896n45);
        D4.a aVar28 = D4.a.f274k;
        C0896n c0896n46 = BCObjectIdentifiers.picnicl1full;
        map2.put(aVar28, c0896n46);
        D4.a aVar29 = D4.a.f275l;
        C0896n c0896n47 = BCObjectIdentifiers.picnicl3full;
        map2.put(aVar29, c0896n47);
        D4.a aVar30 = D4.a.f276m;
        C0896n c0896n48 = BCObjectIdentifiers.picnicl5full;
        map2.put(aVar30, c0896n48);
        map3.put(c0896n37, aVar19);
        map3.put(c0896n38, aVar20);
        map3.put(c0896n39, aVar21);
        map3.put(c0896n40, aVar22);
        map3.put(c0896n41, aVar23);
        map3.put(c0896n42, aVar24);
        map3.put(c0896n43, aVar25);
        map3.put(c0896n44, aVar26);
        map3.put(c0896n45, aVar27);
        map3.put(c0896n46, aVar28);
        map3.put(c0896n47, aVar29);
        map3.put(c0896n48, aVar30);
        B4.b bVar = B4.b.b;
        C0896n c0896n49 = BCObjectIdentifiers.ntruhps2048509;
        map12.put(bVar, c0896n49);
        B4.b bVar2 = B4.b.c;
        C0896n c0896n50 = BCObjectIdentifiers.ntruhps2048677;
        map12.put(bVar2, c0896n50);
        B4.b bVar3 = B4.b.d;
        C0896n c0896n51 = BCObjectIdentifiers.ntruhps4096821;
        map12.put(bVar3, c0896n51);
        B4.b bVar4 = B4.b.e;
        C0896n c0896n52 = BCObjectIdentifiers.ntruhps40961229;
        map12.put(bVar4, c0896n52);
        B4.b bVar5 = B4.b.f128f;
        C0896n c0896n53 = BCObjectIdentifiers.ntruhrss701;
        map12.put(bVar5, c0896n53);
        B4.b bVar6 = B4.b.f129g;
        C0896n c0896n54 = BCObjectIdentifiers.ntruhrss1373;
        map12.put(bVar6, c0896n54);
        map13.put(c0896n49, bVar);
        map13.put(c0896n50, bVar2);
        map13.put(c0896n51, bVar3);
        map13.put(c0896n52, bVar4);
        map13.put(c0896n53, bVar5);
        map13.put(c0896n54, bVar6);
        C0829a c0829a = C0829a.c;
        C0896n c0896n55 = BCObjectIdentifiers.falcon_512;
        map14.put(c0829a, c0896n55);
        C0829a c0829a2 = C0829a.d;
        C0896n c0896n56 = BCObjectIdentifiers.falcon_1024;
        map14.put(c0829a2, c0896n56);
        map15.put(c0896n55, c0829a);
        map15.put(c0896n56, c0829a2);
        z4.c cVar = z4.c.c;
        C0896n c0896n57 = NISTObjectIdentifiers.id_alg_ml_kem_512;
        map28.put(cVar, c0896n57);
        z4.c cVar2 = z4.c.d;
        C0896n c0896n58 = NISTObjectIdentifiers.id_alg_ml_kem_768;
        map28.put(cVar2, c0896n58);
        z4.c cVar3 = z4.c.e;
        C0896n c0896n59 = NISTObjectIdentifiers.id_alg_ml_kem_1024;
        map28.put(cVar3, c0896n59);
        map29.put(c0896n57, cVar);
        map29.put(c0896n58, cVar2);
        map29.put(c0896n59, cVar3);
        C4.a aVar31 = C4.a.b;
        C0896n c0896n60 = BCObjectIdentifiers.ntrulpr653;
        map16.put(aVar31, c0896n60);
        C4.a aVar32 = C4.a.c;
        C0896n c0896n61 = BCObjectIdentifiers.ntrulpr761;
        map16.put(aVar32, c0896n61);
        C4.a aVar33 = C4.a.d;
        C0896n c0896n62 = BCObjectIdentifiers.ntrulpr857;
        map16.put(aVar33, c0896n62);
        C4.a aVar34 = C4.a.e;
        C0896n c0896n63 = BCObjectIdentifiers.ntrulpr953;
        map16.put(aVar34, c0896n63);
        C4.a aVar35 = C4.a.f168f;
        C0896n c0896n64 = BCObjectIdentifiers.ntrulpr1013;
        map16.put(aVar35, c0896n64);
        C4.a aVar36 = C4.a.f169g;
        C0896n c0896n65 = BCObjectIdentifiers.ntrulpr1277;
        map16.put(aVar36, c0896n65);
        map17.put(c0896n60, aVar31);
        map17.put(c0896n61, aVar32);
        map17.put(c0896n62, aVar33);
        map17.put(c0896n63, aVar34);
        map17.put(c0896n64, aVar35);
        map17.put(c0896n65, aVar36);
        d dVar = d.f172a;
        C0896n c0896n66 = BCObjectIdentifiers.sntrup653;
        map18.put(dVar, c0896n66);
        d dVar2 = d.b;
        C0896n c0896n67 = BCObjectIdentifiers.sntrup761;
        map18.put(dVar2, c0896n67);
        d dVar3 = d.c;
        C0896n c0896n68 = BCObjectIdentifiers.sntrup857;
        map18.put(dVar3, c0896n68);
        d dVar4 = d.d;
        C0896n c0896n69 = BCObjectIdentifiers.sntrup953;
        map18.put(dVar4, c0896n69);
        d dVar5 = d.e;
        C0896n c0896n70 = BCObjectIdentifiers.sntrup1013;
        map18.put(dVar5, c0896n70);
        d dVar6 = d.f173f;
        C0896n c0896n71 = BCObjectIdentifiers.sntrup1277;
        map18.put(dVar6, c0896n71);
        map19.put(c0896n66, dVar);
        map19.put(c0896n67, dVar2);
        map19.put(c0896n68, dVar3);
        map19.put(c0896n69, dVar4);
        map19.put(c0896n70, dVar5);
        map19.put(c0896n71, dVar6);
        C0938b c0938b = C0938b.c;
        C0896n c0896n72 = NISTObjectIdentifiers.id_ml_dsa_44;
        map30.put(c0938b, c0896n72);
        C0938b c0938b2 = C0938b.d;
        C0896n c0896n73 = NISTObjectIdentifiers.id_ml_dsa_65;
        map30.put(c0938b2, c0896n73);
        C0938b c0938b3 = C0938b.e;
        C0896n c0896n74 = NISTObjectIdentifiers.id_ml_dsa_87;
        map30.put(c0938b3, c0896n74);
        C0938b c0938b4 = C0938b.f5147f;
        C0896n c0896n75 = NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512;
        map30.put(c0938b4, c0896n75);
        C0938b c0938b5 = C0938b.f5148g;
        C0896n c0896n76 = NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512;
        map30.put(c0938b5, c0896n76);
        C0938b c0938b6 = C0938b.f5149h;
        C0896n c0896n77 = NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512;
        map30.put(c0938b6, c0896n77);
        map31.put(c0896n72, c0938b);
        map31.put(c0896n73, c0938b2);
        map31.put(c0896n74, c0938b3);
        map31.put(c0896n75, c0938b4);
        map31.put(c0896n76, c0938b5);
        map31.put(c0896n77, c0938b6);
        C0814a c0814a = C0814a.c;
        C0896n c0896n78 = BCObjectIdentifiers.dilithium2;
        map20.put(c0814a, c0896n78);
        C0814a c0814a2 = C0814a.d;
        C0896n c0896n79 = BCObjectIdentifiers.dilithium3;
        map20.put(c0814a2, c0896n79);
        C0814a c0814a3 = C0814a.e;
        C0896n c0896n80 = BCObjectIdentifiers.dilithium5;
        map20.put(c0814a3, c0896n80);
        map21.put(c0896n78, c0814a);
        map21.put(c0896n79, c0814a2);
        map21.put(c0896n80, c0814a3);
        C0896n c0896n81 = BCObjectIdentifiers.bike128;
        C0789a c0789a = C0789a.c;
        map23.put(c0896n81, c0789a);
        C0896n c0896n82 = BCObjectIdentifiers.bike192;
        C0789a c0789a2 = C0789a.d;
        map23.put(c0896n82, c0789a2);
        C0896n c0896n83 = BCObjectIdentifiers.bike256;
        C0789a c0789a3 = C0789a.e;
        map23.put(c0896n83, c0789a3);
        map22.put(c0789a, c0896n81);
        map22.put(c0789a2, c0896n82);
        map22.put(c0789a3, c0896n83);
        C0896n c0896n84 = BCObjectIdentifiers.hqc128;
        C0858a c0858a = C0858a.b;
        map25.put(c0896n84, c0858a);
        C0896n c0896n85 = BCObjectIdentifiers.hqc192;
        C0858a c0858a2 = C0858a.c;
        map25.put(c0896n85, c0858a2);
        C0896n c0896n86 = BCObjectIdentifiers.hqc256;
        C0858a c0858a3 = C0858a.d;
        map25.put(c0896n86, c0858a3);
        map24.put(c0858a, c0896n84);
        map24.put(c0858a2, c0896n85);
        map24.put(c0858a3, c0896n86);
        C0896n c0896n87 = BCObjectIdentifiers.rainbow_III_classic;
        E4.c cVar4 = E4.c.f322h;
        map27.put(c0896n87, cVar4);
        C0896n c0896n88 = BCObjectIdentifiers.rainbow_III_circumzenithal;
        E4.c cVar5 = E4.c.i;
        map27.put(c0896n88, cVar5);
        C0896n c0896n89 = BCObjectIdentifiers.rainbow_III_compressed;
        E4.c cVar6 = E4.c.f323j;
        map27.put(c0896n89, cVar6);
        C0896n c0896n90 = BCObjectIdentifiers.rainbow_V_classic;
        E4.c cVar7 = E4.c.f324k;
        map27.put(c0896n90, cVar7);
        C0896n c0896n91 = BCObjectIdentifiers.rainbow_V_circumzenithal;
        E4.c cVar8 = E4.c.f325l;
        map27.put(c0896n91, cVar8);
        C0896n c0896n92 = BCObjectIdentifiers.rainbow_V_compressed;
        E4.c cVar9 = E4.c.f326m;
        map27.put(c0896n92, cVar9);
        map26.put(cVar4, c0896n87);
        map26.put(cVar5, c0896n88);
        map26.put(cVar6, c0896n89);
        map26.put(cVar7, c0896n90);
        map26.put(cVar8, c0896n91);
        map26.put(cVar9, c0896n92);
        e eVar = e.c;
        C0896n c0896n93 = NISTObjectIdentifiers.id_slh_dsa_sha2_128s;
        map32.put(eVar, c0896n93);
        e eVar2 = e.b;
        C0896n c0896n94 = NISTObjectIdentifiers.id_slh_dsa_sha2_128f;
        map32.put(eVar2, c0896n94);
        e eVar3 = e.e;
        C0896n c0896n95 = NISTObjectIdentifiers.id_slh_dsa_sha2_192s;
        map32.put(eVar3, c0896n95);
        e eVar4 = e.d;
        C0896n c0896n96 = NISTObjectIdentifiers.id_slh_dsa_sha2_192f;
        map32.put(eVar4, c0896n96);
        e eVar5 = e.f4391g;
        C0896n c0896n97 = NISTObjectIdentifiers.id_slh_dsa_sha2_256s;
        map32.put(eVar5, c0896n97);
        e eVar6 = e.f4390f;
        C0896n c0896n98 = NISTObjectIdentifiers.id_slh_dsa_sha2_256f;
        map32.put(eVar6, c0896n98);
        e eVar7 = e.i;
        C0896n c0896n99 = NISTObjectIdentifiers.id_slh_dsa_shake_128s;
        map32.put(eVar7, c0896n99);
        e eVar8 = e.f4392h;
        C0896n c0896n100 = NISTObjectIdentifiers.id_slh_dsa_shake_128f;
        map32.put(eVar8, c0896n100);
        e eVar9 = e.f4394k;
        C0896n c0896n101 = NISTObjectIdentifiers.id_slh_dsa_shake_192s;
        map32.put(eVar9, c0896n101);
        e eVar10 = e.f4393j;
        C0896n c0896n102 = NISTObjectIdentifiers.id_slh_dsa_shake_192f;
        map32.put(eVar10, c0896n102);
        e eVar11 = e.f4396m;
        C0896n c0896n103 = NISTObjectIdentifiers.id_slh_dsa_shake_256s;
        map32.put(eVar11, c0896n103);
        e eVar12 = e.f4395l;
        C0896n c0896n104 = NISTObjectIdentifiers.id_slh_dsa_shake_256f;
        map32.put(eVar12, c0896n104);
        e eVar13 = e.f4398o;
        C0896n c0896n105 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256;
        map32.put(eVar13, c0896n105);
        e eVar14 = e.f4397n;
        C0896n c0896n106 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256;
        map32.put(eVar14, c0896n106);
        e eVar15 = e.q;
        C0896n c0896n107 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512;
        map32.put(eVar15, c0896n107);
        e eVar16 = e.f4399p;
        C0896n c0896n108 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512;
        map32.put(eVar16, c0896n108);
        e eVar17 = e.f4401s;
        C0896n c0896n109 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512;
        map32.put(eVar17, c0896n109);
        e eVar18 = e.f4400r;
        C0896n c0896n110 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512;
        map32.put(eVar18, c0896n110);
        e eVar19 = e.u;
        C0896n c0896n111 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128;
        map32.put(eVar19, c0896n111);
        e eVar20 = e.f4402t;
        C0896n c0896n112 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128;
        map32.put(eVar20, c0896n112);
        e eVar21 = e.f4404w;
        C0896n c0896n113 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256;
        map32.put(eVar21, c0896n113);
        e eVar22 = e.f4403v;
        C0896n c0896n114 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256;
        map32.put(eVar22, c0896n114);
        e eVar23 = e.y;
        C0896n c0896n115 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256;
        map32.put(eVar23, c0896n115);
        e eVar24 = e.x;
        C0896n c0896n116 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256;
        map32.put(eVar24, c0896n116);
        map33.put(c0896n93, eVar);
        map33.put(c0896n94, eVar2);
        map33.put(c0896n95, eVar3);
        map33.put(c0896n96, eVar4);
        map33.put(c0896n97, eVar5);
        map33.put(c0896n98, eVar6);
        map33.put(c0896n99, eVar7);
        map33.put(c0896n100, eVar8);
        map33.put(c0896n101, eVar9);
        map33.put(c0896n102, eVar10);
        map33.put(c0896n103, eVar11);
        map33.put(c0896n104, eVar12);
        map33.put(c0896n105, eVar13);
        map33.put(c0896n106, eVar14);
        map33.put(c0896n107, eVar15);
        map33.put(c0896n108, eVar16);
        map33.put(c0896n109, eVar17);
        map33.put(c0896n110, eVar18);
        map33.put(c0896n111, eVar19);
        map33.put(c0896n112, eVar20);
        map33.put(c0896n113, eVar21);
        map33.put(c0896n114, eVar22);
        map33.put(c0896n115, eVar23);
        map33.put(c0896n116, eVar24);
        C0896n c0896n117 = BCObjectIdentifiers.sphincsPlus_sha2_128s;
        map10.put(eVar, c0896n117);
        C0896n c0896n118 = BCObjectIdentifiers.sphincsPlus_sha2_128f;
        map10.put(eVar2, c0896n118);
        C0896n c0896n119 = BCObjectIdentifiers.sphincsPlus_sha2_192s;
        map10.put(eVar3, c0896n119);
        C0896n c0896n120 = BCObjectIdentifiers.sphincsPlus_sha2_192f;
        map10.put(eVar4, c0896n120);
        C0896n c0896n121 = BCObjectIdentifiers.sphincsPlus_sha2_256s;
        map10.put(eVar5, c0896n121);
        C0896n c0896n122 = BCObjectIdentifiers.sphincsPlus_sha2_256f;
        map10.put(eVar6, c0896n122);
        C0896n c0896n123 = BCObjectIdentifiers.sphincsPlus_shake_128s;
        map10.put(eVar7, c0896n123);
        C0896n c0896n124 = BCObjectIdentifiers.sphincsPlus_shake_128f;
        map10.put(eVar8, c0896n124);
        C0896n c0896n125 = BCObjectIdentifiers.sphincsPlus_shake_192s;
        map10.put(eVar9, c0896n125);
        C0896n c0896n126 = BCObjectIdentifiers.sphincsPlus_shake_192f;
        map10.put(eVar10, c0896n126);
        C0896n c0896n127 = BCObjectIdentifiers.sphincsPlus_shake_256s;
        map10.put(eVar11, c0896n127);
        C0896n c0896n128 = BCObjectIdentifiers.sphincsPlus_shake_256f;
        map10.put(eVar12, c0896n128);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar25 = org.bouncycastle.pqc.crypto.sphincsplus.e.e;
        C0896n c0896n129 = BCObjectIdentifiers.sphincsPlus_sha2_128s_r3;
        map10.put(eVar25, c0896n129);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar26 = org.bouncycastle.pqc.crypto.sphincsplus.e.d;
        C0896n c0896n130 = BCObjectIdentifiers.sphincsPlus_sha2_128f_r3;
        map10.put(eVar26, c0896n130);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar27 = org.bouncycastle.pqc.crypto.sphincsplus.e.q;
        C0896n c0896n131 = BCObjectIdentifiers.sphincsPlus_shake_128s_r3;
        map10.put(eVar27, c0896n131);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar28 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4426p;
        C0896n c0896n132 = BCObjectIdentifiers.sphincsPlus_shake_128f_r3;
        map10.put(eVar28, c0896n132);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar29 = org.bouncycastle.pqc.crypto.sphincsplus.e.C;
        C0896n c0896n133 = BCObjectIdentifiers.sphincsPlus_haraka_128s_r3;
        map10.put(eVar29, c0896n133);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar30 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4409B;
        C0896n c0896n134 = BCObjectIdentifiers.sphincsPlus_haraka_128f_r3;
        map10.put(eVar30, c0896n134);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar31 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4418g;
        C0896n c0896n135 = BCObjectIdentifiers.sphincsPlus_sha2_192s_r3;
        map10.put(eVar31, c0896n135);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar32 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4417f;
        C0896n c0896n136 = BCObjectIdentifiers.sphincsPlus_sha2_192f_r3;
        map10.put(eVar32, c0896n136);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar33 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4428s;
        C0896n c0896n137 = BCObjectIdentifiers.sphincsPlus_shake_192s_r3;
        map10.put(eVar33, c0896n137);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar34 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4427r;
        C0896n c0896n138 = BCObjectIdentifiers.sphincsPlus_shake_192f_r3;
        map10.put(eVar34, c0896n138);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar35 = org.bouncycastle.pqc.crypto.sphincsplus.e.E;
        C0896n c0896n139 = BCObjectIdentifiers.sphincsPlus_haraka_192s_r3;
        map10.put(eVar35, c0896n139);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar36 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4410D;
        C0896n c0896n140 = BCObjectIdentifiers.sphincsPlus_haraka_192f_r3;
        map10.put(eVar36, c0896n140);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar37 = org.bouncycastle.pqc.crypto.sphincsplus.e.i;
        C0896n c0896n141 = BCObjectIdentifiers.sphincsPlus_sha2_256s_r3;
        map10.put(eVar37, c0896n141);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar38 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4419h;
        C0896n c0896n142 = BCObjectIdentifiers.sphincsPlus_sha2_256f_r3;
        map10.put(eVar38, c0896n142);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar39 = org.bouncycastle.pqc.crypto.sphincsplus.e.u;
        C0896n c0896n143 = BCObjectIdentifiers.sphincsPlus_shake_256s_r3;
        map10.put(eVar39, c0896n143);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar40 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4429t;
        C0896n c0896n144 = BCObjectIdentifiers.sphincsPlus_shake_256f_r3;
        map10.put(eVar40, c0896n144);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar41 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4412G;
        C0896n c0896n145 = BCObjectIdentifiers.sphincsPlus_haraka_256s_r3;
        map10.put(eVar41, c0896n145);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar42 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4411F;
        C0896n c0896n146 = BCObjectIdentifiers.sphincsPlus_haraka_256f_r3;
        map10.put(eVar42, c0896n146);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar43 = org.bouncycastle.pqc.crypto.sphincsplus.e.I;
        C0896n c0896n147 = BCObjectIdentifiers.sphincsPlus_haraka_128s_r3_simple;
        map10.put(eVar43, c0896n147);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar44 = org.bouncycastle.pqc.crypto.sphincsplus.e.H;
        C0896n c0896n148 = BCObjectIdentifiers.sphincsPlus_haraka_128f_r3_simple;
        map10.put(eVar44, c0896n148);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar45 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4413K;
        C0896n c0896n149 = BCObjectIdentifiers.sphincsPlus_haraka_192s_r3_simple;
        map10.put(eVar45, c0896n149);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar46 = org.bouncycastle.pqc.crypto.sphincsplus.e.J;
        C0896n c0896n150 = BCObjectIdentifiers.sphincsPlus_haraka_192f_r3_simple;
        map10.put(eVar46, c0896n150);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar47 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4415M;
        C0896n c0896n151 = BCObjectIdentifiers.sphincsPlus_haraka_256s_r3_simple;
        map10.put(eVar47, c0896n151);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar48 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4414L;
        C0896n c0896n152 = BCObjectIdentifiers.sphincsPlus_haraka_256f_r3_simple;
        map10.put(eVar48, c0896n152);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar49 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4421k;
        map10.put(eVar49, c0896n117);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar50 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4420j;
        map10.put(eVar50, c0896n118);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar51 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4423m;
        map10.put(eVar51, c0896n119);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar52 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4422l;
        map10.put(eVar52, c0896n120);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar53 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4425o;
        map10.put(eVar53, c0896n121);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar54 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4424n;
        map10.put(eVar54, c0896n122);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar55 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4431w;
        map10.put(eVar55, c0896n123);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar56 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4430v;
        map10.put(eVar56, c0896n124);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar57 = org.bouncycastle.pqc.crypto.sphincsplus.e.y;
        map10.put(eVar57, c0896n125);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar58 = org.bouncycastle.pqc.crypto.sphincsplus.e.x;
        map10.put(eVar58, c0896n126);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar59 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4408A;
        map10.put(eVar59, c0896n127);
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar60 = org.bouncycastle.pqc.crypto.sphincsplus.e.f4432z;
        map10.put(eVar60, c0896n128);
        map11.put(c0896n117, eVar49);
        map11.put(c0896n118, eVar50);
        map11.put(c0896n123, eVar55);
        map11.put(c0896n124, eVar56);
        map11.put(c0896n119, eVar51);
        map11.put(c0896n120, eVar52);
        map11.put(c0896n125, eVar57);
        map11.put(c0896n126, eVar58);
        map11.put(c0896n121, eVar53);
        map11.put(c0896n122, eVar54);
        map11.put(c0896n127, eVar59);
        map11.put(c0896n128, eVar60);
        map11.put(c0896n129, eVar25);
        map11.put(c0896n130, eVar26);
        map11.put(c0896n131, eVar27);
        map11.put(c0896n132, eVar28);
        map11.put(c0896n133, eVar29);
        map11.put(c0896n134, eVar30);
        map11.put(c0896n135, eVar31);
        map11.put(c0896n136, eVar32);
        map11.put(c0896n137, eVar33);
        map11.put(c0896n138, eVar34);
        map11.put(c0896n139, eVar35);
        map11.put(c0896n140, eVar36);
        map11.put(c0896n141, eVar37);
        map11.put(c0896n142, eVar38);
        map11.put(c0896n143, eVar39);
        map11.put(c0896n144, eVar40);
        map11.put(c0896n145, eVar41);
        map11.put(c0896n146, eVar42);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3_simple, eVar49);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3_simple, eVar50);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_128s_r3_simple, eVar55);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_128f_r3_simple, eVar56);
        map11.put(c0896n147, eVar43);
        map11.put(c0896n148, eVar44);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3_simple, eVar51);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3_simple, eVar52);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_192s_r3_simple, eVar57);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_192f_r3_simple, eVar58);
        map11.put(c0896n149, eVar45);
        map11.put(c0896n150, eVar46);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3_simple, eVar53);
        map11.put(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3_simple, eVar54);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_256s_r3_simple, eVar59);
        map11.put(BCObjectIdentifiers.sphincsPlus_shake_256f_r3_simple, eVar60);
        map11.put(c0896n151, eVar47);
        map11.put(c0896n152, eVar48);
        C0926a c0926a = C0926a.b;
        C0896n c0896n153 = BCObjectIdentifiers.mayo1;
        map34.put(c0926a, c0896n153);
        C0926a c0926a2 = C0926a.c;
        C0896n c0896n154 = BCObjectIdentifiers.mayo2;
        map34.put(c0926a2, c0896n154);
        C0926a c0926a3 = C0926a.d;
        C0896n c0896n155 = BCObjectIdentifiers.mayo3;
        map34.put(c0926a3, c0896n155);
        C0926a c0926a4 = C0926a.e;
        C0896n c0896n156 = BCObjectIdentifiers.mayo5;
        map34.put(c0926a4, c0896n156);
        map35.put(c0896n153, c0926a);
        map35.put(c0896n154, c0926a2);
        map35.put(c0896n155, c0926a3);
        map35.put(c0896n156, c0926a4);
        G4.a aVar37 = G4.a.b;
        C0896n c0896n157 = BCObjectIdentifiers.snova_24_5_4_ssk;
        map36.put(aVar37, c0896n157);
        G4.a aVar38 = G4.a.c;
        C0896n c0896n158 = BCObjectIdentifiers.snova_24_5_4_esk;
        map36.put(aVar38, c0896n158);
        G4.a aVar39 = G4.a.d;
        C0896n c0896n159 = BCObjectIdentifiers.snova_24_5_4_shake_ssk;
        map36.put(aVar39, c0896n159);
        G4.a aVar40 = G4.a.e;
        C0896n c0896n160 = BCObjectIdentifiers.snova_24_5_4_shake_esk;
        map36.put(aVar40, c0896n160);
        G4.a aVar41 = G4.a.f713f;
        C0896n c0896n161 = BCObjectIdentifiers.snova_24_5_5_ssk;
        map36.put(aVar41, c0896n161);
        G4.a aVar42 = G4.a.f714g;
        C0896n c0896n162 = BCObjectIdentifiers.snova_24_5_5_esk;
        map36.put(aVar42, c0896n162);
        G4.a aVar43 = G4.a.f715h;
        C0896n c0896n163 = BCObjectIdentifiers.snova_24_5_5_shake_ssk;
        map36.put(aVar43, c0896n163);
        G4.a aVar44 = G4.a.i;
        C0896n c0896n164 = BCObjectIdentifiers.snova_24_5_5_shake_esk;
        map36.put(aVar44, c0896n164);
        G4.a aVar45 = G4.a.f716j;
        C0896n c0896n165 = BCObjectIdentifiers.snova_25_8_3_ssk;
        map36.put(aVar45, c0896n165);
        G4.a aVar46 = G4.a.f717k;
        C0896n c0896n166 = BCObjectIdentifiers.snova_25_8_3_esk;
        map36.put(aVar46, c0896n166);
        G4.a aVar47 = G4.a.f718l;
        C0896n c0896n167 = BCObjectIdentifiers.snova_25_8_3_shake_ssk;
        map36.put(aVar47, c0896n167);
        G4.a aVar48 = G4.a.f719m;
        C0896n c0896n168 = BCObjectIdentifiers.snova_25_8_3_shake_esk;
        map36.put(aVar48, c0896n168);
        G4.a aVar49 = G4.a.f720n;
        C0896n c0896n169 = BCObjectIdentifiers.snova_29_6_5_ssk;
        map36.put(aVar49, c0896n169);
        G4.a aVar50 = G4.a.f721o;
        C0896n c0896n170 = BCObjectIdentifiers.snova_29_6_5_esk;
        map36.put(aVar50, c0896n170);
        G4.a aVar51 = G4.a.f722p;
        C0896n c0896n171 = BCObjectIdentifiers.snova_29_6_5_shake_ssk;
        map36.put(aVar51, c0896n171);
        G4.a aVar52 = G4.a.q;
        C0896n c0896n172 = BCObjectIdentifiers.snova_29_6_5_shake_esk;
        map36.put(aVar52, c0896n172);
        G4.a aVar53 = G4.a.f723r;
        C0896n c0896n173 = BCObjectIdentifiers.snova_37_8_4_ssk;
        map36.put(aVar53, c0896n173);
        G4.a aVar54 = G4.a.f724s;
        C0896n c0896n174 = BCObjectIdentifiers.snova_37_8_4_esk;
        map36.put(aVar54, c0896n174);
        G4.a aVar55 = G4.a.f725t;
        C0896n c0896n175 = BCObjectIdentifiers.snova_37_8_4_shake_ssk;
        map36.put(aVar55, c0896n175);
        G4.a aVar56 = G4.a.u;
        C0896n c0896n176 = BCObjectIdentifiers.snova_37_8_4_shake_esk;
        map36.put(aVar56, c0896n176);
        G4.a aVar57 = G4.a.f726v;
        C0896n c0896n177 = BCObjectIdentifiers.snova_37_17_2_ssk;
        map36.put(aVar57, c0896n177);
        G4.a aVar58 = G4.a.f727w;
        C0896n c0896n178 = BCObjectIdentifiers.snova_37_17_2_esk;
        map36.put(aVar58, c0896n178);
        G4.a aVar59 = G4.a.x;
        C0896n c0896n179 = BCObjectIdentifiers.snova_37_17_2_shake_ssk;
        map36.put(aVar59, c0896n179);
        G4.a aVar60 = G4.a.y;
        C0896n c0896n180 = BCObjectIdentifiers.snova_37_17_2_shake_esk;
        map36.put(aVar60, c0896n180);
        G4.a aVar61 = G4.a.f728z;
        C0896n c0896n181 = BCObjectIdentifiers.snova_49_11_3_ssk;
        map36.put(aVar61, c0896n181);
        G4.a aVar62 = G4.a.f701A;
        C0896n c0896n182 = BCObjectIdentifiers.snova_49_11_3_esk;
        map36.put(aVar62, c0896n182);
        G4.a aVar63 = G4.a.f702B;
        C0896n c0896n183 = BCObjectIdentifiers.snova_49_11_3_shake_ssk;
        map36.put(aVar63, c0896n183);
        G4.a aVar64 = G4.a.C;
        C0896n c0896n184 = BCObjectIdentifiers.snova_49_11_3_shake_esk;
        map36.put(aVar64, c0896n184);
        G4.a aVar65 = G4.a.f703D;
        C0896n c0896n185 = BCObjectIdentifiers.snova_56_25_2_ssk;
        map36.put(aVar65, c0896n185);
        G4.a aVar66 = G4.a.E;
        C0896n c0896n186 = BCObjectIdentifiers.snova_56_25_2_esk;
        map36.put(aVar66, c0896n186);
        G4.a aVar67 = G4.a.f704F;
        C0896n c0896n187 = BCObjectIdentifiers.snova_56_25_2_shake_ssk;
        map36.put(aVar67, c0896n187);
        G4.a aVar68 = G4.a.f705G;
        C0896n c0896n188 = BCObjectIdentifiers.snova_56_25_2_shake_esk;
        map36.put(aVar68, c0896n188);
        G4.a aVar69 = G4.a.H;
        C0896n c0896n189 = BCObjectIdentifiers.snova_60_10_4_ssk;
        map36.put(aVar69, c0896n189);
        G4.a aVar70 = G4.a.I;
        C0896n c0896n190 = BCObjectIdentifiers.snova_60_10_4_esk;
        map36.put(aVar70, c0896n190);
        G4.a aVar71 = G4.a.J;
        C0896n c0896n191 = BCObjectIdentifiers.snova_60_10_4_shake_ssk;
        map36.put(aVar71, c0896n191);
        G4.a aVar72 = G4.a.f706K;
        C0896n c0896n192 = BCObjectIdentifiers.snova_60_10_4_shake_esk;
        map36.put(aVar72, c0896n192);
        G4.a aVar73 = G4.a.f707L;
        C0896n c0896n193 = BCObjectIdentifiers.snova_66_15_3_ssk;
        map36.put(aVar73, c0896n193);
        G4.a aVar74 = G4.a.f708M;
        C0896n c0896n194 = BCObjectIdentifiers.snova_66_15_3_esk;
        map36.put(aVar74, c0896n194);
        G4.a aVar75 = G4.a.f709N;
        C0896n c0896n195 = BCObjectIdentifiers.snova_66_15_3_shake_ssk;
        map36.put(aVar75, c0896n195);
        G4.a aVar76 = G4.a.f710O;
        C0896n c0896n196 = BCObjectIdentifiers.snova_66_15_3_shake_esk;
        map36.put(aVar76, c0896n196);
        G4.a aVar77 = G4.a.f711P;
        C0896n c0896n197 = BCObjectIdentifiers.snova_75_33_2_ssk;
        map36.put(aVar77, c0896n197);
        G4.a aVar78 = G4.a.f712Q;
        C0896n c0896n198 = BCObjectIdentifiers.snova_75_33_2_esk;
        map36.put(aVar78, c0896n198);
        G4.a aVar79 = G4.a.R;
        C0896n c0896n199 = BCObjectIdentifiers.snova_75_33_2_shake_ssk;
        map36.put(aVar79, c0896n199);
        G4.a aVar80 = G4.a.S;
        C0896n c0896n200 = BCObjectIdentifiers.snova_75_33_2_shake_esk;
        map36.put(aVar80, c0896n200);
        map37.put(c0896n157, aVar37);
        map37.put(c0896n158, aVar38);
        map37.put(c0896n159, aVar39);
        map37.put(c0896n160, aVar40);
        map37.put(c0896n161, aVar41);
        map37.put(c0896n162, aVar42);
        map37.put(c0896n163, aVar43);
        map37.put(c0896n164, aVar44);
        map37.put(c0896n165, aVar45);
        map37.put(c0896n166, aVar46);
        map37.put(c0896n167, aVar47);
        map37.put(c0896n168, aVar48);
        map37.put(c0896n169, aVar49);
        map37.put(c0896n170, aVar50);
        map37.put(c0896n171, aVar51);
        map37.put(c0896n172, aVar52);
        map37.put(c0896n173, aVar53);
        map37.put(c0896n174, aVar54);
        map37.put(c0896n175, aVar55);
        map37.put(c0896n176, aVar56);
        map37.put(c0896n177, aVar57);
        map37.put(c0896n178, aVar58);
        map37.put(c0896n179, aVar59);
        map37.put(c0896n180, aVar60);
        map37.put(c0896n181, aVar61);
        map37.put(c0896n182, aVar62);
        map37.put(c0896n183, aVar63);
        map37.put(c0896n184, aVar64);
        map37.put(c0896n185, aVar65);
        map37.put(c0896n186, aVar66);
        map37.put(c0896n187, aVar67);
        map37.put(c0896n188, aVar68);
        map37.put(c0896n189, aVar69);
        map37.put(c0896n190, aVar70);
        map37.put(c0896n191, aVar71);
        map37.put(c0896n192, aVar72);
        map37.put(c0896n193, aVar73);
        map37.put(c0896n194, aVar74);
        map37.put(c0896n195, aVar75);
        map37.put(c0896n196, aVar76);
        map37.put(c0896n197, aVar77);
        map37.put(c0896n198, aVar78);
        map37.put(c0896n199, aVar79);
        map37.put(c0896n200, aVar80);
    }

    public static H3.a a(String str) {
        if (str.equals("SHA-1")) {
            return new H3.a(OIWObjectIdentifiers.idSHA1, U.b);
        }
        if (str.equals("SHA-224")) {
            return new H3.a(NISTObjectIdentifiers.id_sha224);
        }
        if (str.equals("SHA-256")) {
            return new H3.a(NISTObjectIdentifiers.id_sha256);
        }
        if (str.equals("SHA-384")) {
            return new H3.a(NISTObjectIdentifiers.id_sha384);
        }
        if (str.equals("SHA-512")) {
            return new H3.a(NISTObjectIdentifiers.id_sha512);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: ".concat(str));
    }

    public static ExtendedDigest b(C0896n c0896n) {
        if (c0896n.f(NISTObjectIdentifiers.id_sha256)) {
            return new N3.c();
        }
        if (c0896n.f(NISTObjectIdentifiers.id_sha512)) {
            return new f();
        }
        if (c0896n.f(NISTObjectIdentifiers.id_shake128)) {
            return new g(128);
        }
        if (c0896n.f(NISTObjectIdentifiers.id_shake256)) {
            return new g(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + c0896n);
    }

    public static String c(C0896n c0896n) {
        if (c0896n.f(OIWObjectIdentifiers.idSHA1)) {
            return "SHA-1";
        }
        if (c0896n.f(NISTObjectIdentifiers.id_sha224)) {
            return "SHA-224";
        }
        if (c0896n.f(NISTObjectIdentifiers.id_sha256)) {
            return "SHA-256";
        }
        if (c0896n.f(NISTObjectIdentifiers.id_sha384)) {
            return "SHA-384";
        }
        if (c0896n.f(NISTObjectIdentifiers.id_sha512)) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + c0896n);
    }

    public static boolean d(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byteArrayInputStream.read();
        int i3 = byteArrayInputStream.read();
        if (i3 < 0) {
            i3 = -1;
        } else {
            int i4 = i3 & 127;
            if (i3 != i4) {
                i3 = 0;
                while (true) {
                    int i5 = i4 - 1;
                    if (i4 == 0) {
                        break;
                    }
                    i3 = (i3 << 8) + byteArrayInputStream.read();
                    i4 = i5;
                }
            }
        }
        return i3 != byteArrayInputStream.available();
    }

    public static AbstractC0899q e(byte[] bArr) {
        if (d(bArr)) {
            return null;
        }
        byte b2 = bArr[0];
        if (b2 == 48) {
            return AbstractC0902u.l(bArr);
        }
        if (b2 == 4) {
            return AbstractC0897o.j(bArr);
        }
        if ((b2 & 255) != 128) {
            return null;
        }
        return (AbstractC0897o) AbstractC0897o.b.g(H.l(bArr), false);
    }

    public static H3.a f(int i3) {
        if (i3 == 5) {
            return f808a;
        }
        if (i3 == 6) {
            return b;
        }
        throw new IllegalArgumentException(B2.b.c(i3, "unknown security category: "));
    }

    public static H3.a g(String str) {
        if (str.equals("SHA3-256")) {
            return c;
        }
        if (str.equals("SHA-512/256")) {
            return d;
        }
        throw new IllegalArgumentException("unknown tree digest: ".concat(str));
    }

    public static String h(o4.g gVar) {
        H3.a aVar = gVar.b;
        if (aVar.f747a.f(c.f747a)) {
            return "SHA3-256";
        }
        C0896n c0896n = d.f747a;
        C0896n c0896n2 = aVar.f747a;
        if (c0896n2.f(c0896n)) {
            return "SHA-512/256";
        }
        throw new IllegalArgumentException("unknown tree digest: " + c0896n2);
    }

    public static H3.a i(String str) {
        if (str.equals("SHA-256")) {
            return e;
        }
        if (str.equals("SHA-512")) {
            return f809f;
        }
        if (str.equals("SHAKE128")) {
            return f810g;
        }
        if (str.equals("SHAKE256")) {
            return f811h;
        }
        throw new IllegalArgumentException("unknown tree digest: ".concat(str));
    }
}
