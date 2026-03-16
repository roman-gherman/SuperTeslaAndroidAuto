package w4;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f5082g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5083a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0896n f5084f;

    static {
        C0896n c0896n = NISTObjectIdentifiers.id_sha256;
        f fVar = new f(1, 32, 1, 265, 7, c0896n);
        f fVar2 = new f(2, 32, 2, 133, 6, c0896n);
        f fVar3 = new f(3, 32, 4, 67, 4, c0896n);
        f fVar4 = new f(4, 32, 8, 34, 0, c0896n);
        f fVar5 = new f(5, 24, 1, 200, 8, c0896n);
        f fVar6 = new f(6, 24, 2, 101, 6, c0896n);
        f fVar7 = new f(7, 24, 4, 51, 4, c0896n);
        f fVar8 = new f(8, 24, 8, 26, 0, c0896n);
        C0896n c0896n2 = NISTObjectIdentifiers.id_shake256_len;
        f fVar9 = new f(9, 32, 1, 265, 7, c0896n2);
        f fVar10 = new f(10, 32, 2, 133, 6, c0896n2);
        f fVar11 = new f(11, 32, 4, 67, 4, c0896n2);
        f fVar12 = new f(12, 32, 8, 34, 0, c0896n2);
        f fVar13 = new f(13, 24, 1, 200, 8, c0896n2);
        f fVar14 = new f(14, 24, 2, 101, 6, c0896n2);
        f fVar15 = new f(15, 24, 4, 51, 4, c0896n2);
        f fVar16 = new f(16, 24, 8, 26, 0, c0896n2);
        e eVar = new e();
        eVar.put(1, fVar);
        eVar.put(2, fVar2);
        eVar.put(3, fVar3);
        eVar.put(4, fVar4);
        eVar.put(5, fVar5);
        eVar.put(6, fVar6);
        eVar.put(7, fVar7);
        eVar.put(8, fVar8);
        eVar.put(9, fVar9);
        eVar.put(10, fVar10);
        eVar.put(11, fVar11);
        eVar.put(12, fVar12);
        eVar.put(13, fVar13);
        eVar.put(14, fVar14);
        eVar.put(15, fVar15);
        eVar.put(16, fVar16);
        f5082g = eVar;
    }

    public f(int i, int i3, int i4, int i5, int i6, C0896n c0896n) {
        this.f5083a = i;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f5084f = c0896n;
    }

    public static f a(int i) {
        return (f) f5082g.get(Integer.valueOf(i));
    }
}
