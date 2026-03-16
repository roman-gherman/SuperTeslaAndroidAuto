package f;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f3170A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f3171B;
    public int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f3172a;
    public final w b;
    public final w c;
    public final w d;
    public final w e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w f3173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f3174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f3175h;
    public final w i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f3176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final w f3177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final w f3178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w f3179m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final w f3180n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final w f3181o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final w f3182p;
    public final w q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final w f3183r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final w f3184s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final w f3185t;
    public final w[] u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3186v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3187w;
    public byte[] x;
    public int y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3188z;

    public x() {
        w wVar = new w(0);
        this.f3172a = wVar;
        w wVar2 = new w(1);
        this.b = wVar2;
        w wVar3 = new w(2);
        this.c = wVar3;
        w wVar4 = new w(3);
        this.d = wVar4;
        w wVar5 = new w(4);
        this.e = wVar5;
        w wVar6 = new w(5);
        this.f3173f = wVar6;
        w wVar7 = new w(6);
        this.f3174g = wVar7;
        w wVar8 = new w(7);
        this.f3175h = wVar8;
        w wVar9 = new w(8);
        this.i = wVar9;
        w wVar10 = new w(4096);
        this.f3176j = wVar10;
        w wVar11 = new w(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.f3177k = wVar11;
        w wVar12 = new w(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        this.f3178l = wVar12;
        w wVar13 = new w(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        this.f3179m = wVar13;
        w wVar14 = new w(8192);
        this.f3180n = wVar14;
        w wVar15 = new w(8193);
        this.f3181o = wVar15;
        w wVar16 = new w(8194);
        this.f3182p = wVar16;
        w wVar17 = new w(8195);
        this.q = wVar17;
        w wVar18 = new w(8196);
        this.f3183r = wVar18;
        w wVar19 = new w(FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE);
        this.f3184s = wVar19;
        w wVar20 = new w(8198);
        this.f3185t = wVar20;
        this.u = new w[]{wVar, wVar2, wVar3, wVar4, wVar5, wVar6, wVar7, wVar10, wVar8, wVar9, wVar11, wVar12, wVar13, wVar14, wVar15, wVar16, wVar17, wVar18, wVar19, wVar20};
        this.x = new byte[20];
    }

    public final void a() {
        int i = this.C + this.f3171B;
        w[] wVarArr = this.u;
        for (int length = wVarArr.length - 1; length >= 0; length--) {
            w wVar = wVarArr[length];
            int i3 = wVar.c;
            if (i3 != -1) {
                if (i3 > i) {
                    throw new n("Map is unsorted at " + wVar, null);
                }
                wVar.d = i - i3;
                i = i3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0100, code lost:
    
        throw new f.n(androidx.constraintlayout.core.motion.a.h(r6, new java.lang.StringBuilder("Unexpected map value for 0x")), null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(f.m r14) {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.b(f.m):void");
    }
}
