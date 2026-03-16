package w4;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static final e e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5101a;
    public final int b;
    public final int c;
    public final C0896n d;

    static {
        C0896n c0896n = NISTObjectIdentifiers.id_sha256;
        p pVar = new p(5, 32, 5, c0896n);
        p pVar2 = new p(6, 32, 10, c0896n);
        p pVar3 = new p(7, 32, 15, c0896n);
        p pVar4 = new p(8, 32, 20, c0896n);
        p pVar5 = new p(9, 32, 25, c0896n);
        p pVar6 = new p(10, 24, 5, c0896n);
        p pVar7 = new p(11, 24, 10, c0896n);
        p pVar8 = new p(12, 24, 15, c0896n);
        p pVar9 = new p(13, 24, 20, c0896n);
        p pVar10 = new p(14, 24, 25, c0896n);
        C0896n c0896n2 = NISTObjectIdentifiers.id_shake256_len;
        p pVar11 = new p(15, 32, 5, c0896n2);
        p pVar12 = new p(16, 32, 10, c0896n2);
        p pVar13 = new p(17, 32, 15, c0896n2);
        p pVar14 = new p(18, 32, 20, c0896n2);
        p pVar15 = new p(19, 32, 25, c0896n2);
        p pVar16 = new p(20, 24, 5, c0896n2);
        p pVar17 = new p(21, 24, 10, c0896n2);
        p pVar18 = new p(22, 24, 15, c0896n2);
        p pVar19 = new p(23, 24, 20, c0896n2);
        p pVar20 = new p(24, 24, 25, c0896n2);
        e eVar = new e();
        eVar.put(5, pVar);
        eVar.put(6, pVar2);
        eVar.put(7, pVar3);
        eVar.put(8, pVar4);
        eVar.put(9, pVar5);
        eVar.put(10, pVar6);
        eVar.put(11, pVar7);
        eVar.put(12, pVar8);
        eVar.put(13, pVar9);
        eVar.put(14, pVar10);
        eVar.put(15, pVar11);
        eVar.put(16, pVar12);
        eVar.put(17, pVar13);
        eVar.put(18, pVar14);
        eVar.put(19, pVar15);
        eVar.put(20, pVar16);
        eVar.put(21, pVar17);
        eVar.put(22, pVar18);
        eVar.put(23, pVar19);
        eVar.put(24, pVar20);
        e = eVar;
    }

    public p(int i, int i3, int i4, C0896n c0896n) {
        this.f5101a = i;
        this.b = i3;
        this.c = i4;
        this.d = c0896n;
    }
}
