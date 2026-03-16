package J4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient C0.t f873a;
    public final int b;
    public final ArrayList c;
    public final int d;
    public final ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TreeMap f874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Stack f875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TreeMap f876h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient int f878k;

    public a(C0.t tVar, int i, int i3, int i4) {
        this.f873a = tVar;
        this.b = i;
        this.f878k = i4;
        this.d = i3;
        if (i3 <= i && i3 >= 2) {
            int i5 = i - i3;
            if (i5 % 2 == 0) {
                this.e = new ArrayList();
                this.f874f = new TreeMap();
                this.f875g = new Stack();
                this.c = new ArrayList();
                for (int i6 = 0; i6 < i5; i6++) {
                    this.c.add(new c(i6));
                }
                this.f876h = new TreeMap();
                this.i = 0;
                this.f877j = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iAvailable = objectInputStream.available();
        int i = this.b;
        this.f878k = iAvailable != 0 ? objectInputStream.readInt() : (1 << i) - 1;
        int i3 = this.f878k;
        if (i3 > (1 << i) - 1 || this.i > i3 + 1 || objectInputStream.available() != 0) {
            throw new IOException("inconsistent BDS data detected");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f878k);
    }

    public final void a(byte[] bArr, byte[] bArr2, k kVar) {
        k kVar2;
        int i;
        k kVar3 = kVar;
        i iVar = new i(0);
        int i3 = kVar3.f895a;
        iVar.c = i3;
        long j6 = kVar3.b;
        iVar.b = j6;
        j jVar = new j(iVar);
        g gVar = new g();
        gVar.c = i3;
        gVar.b = j6;
        h hVar = new h(gVar);
        int i4 = 0;
        while (true) {
            int i5 = this.b;
            int i6 = 1 << i5;
            Stack stack = this.f875g;
            if (i4 >= i6) {
                return;
            }
            i iVar2 = new i(1);
            iVar2.c = kVar3.f895a;
            iVar2.b = kVar3.b;
            iVar2.e = i4;
            iVar2.f887f = kVar3.f891f;
            iVar2.f888g = kVar3.f892g;
            iVar2.d = kVar3.d;
            k kVar4 = new k(iVar2);
            C0.t tVar = this.f873a;
            tVar.j(tVar.i(bArr2, kVar4), bArr);
            B.g gVarH = tVar.h(kVar4);
            i iVar3 = new i(0);
            iVar3.c = jVar.f895a;
            iVar3.b = jVar.b;
            iVar3.e = i4;
            iVar3.f887f = jVar.f889f;
            iVar3.f888g = jVar.f890g;
            iVar3.d = jVar.d;
            jVar = new j(iVar3);
            s sVarP = kotlin.reflect.l.P(tVar, gVarH, jVar);
            g gVar2 = new g();
            gVar2.c = hVar.f895a;
            gVar2.b = hVar.b;
            gVar2.f885f = i4;
            gVar2.d = hVar.d;
            hVar = new h(gVar2);
            while (!stack.isEmpty()) {
                int i7 = ((s) stack.peek()).f905a;
                int i8 = sVarP.f905a;
                if (i7 == i8) {
                    int i9 = i4 / (1 << i8);
                    if (i9 == 1) {
                        this.e.add(sVarP);
                    }
                    int i10 = this.d;
                    int i11 = sVarP.f905a;
                    if (i9 == 3) {
                        if (i11 < i5 - i10) {
                            c cVar = (c) this.c.get(i11);
                            cVar.f880a = sVarP;
                            cVar.c = i11;
                            kVar2 = kVar4;
                            if (i11 == cVar.b) {
                                cVar.f881f = true;
                            }
                        } else {
                            kVar2 = kVar4;
                        }
                        i = 3;
                    } else {
                        kVar2 = kVar4;
                        i = 3;
                    }
                    if (i9 >= i && (i9 & 1) == 1 && i11 >= i5 - i10 && i11 <= i5 - 2) {
                        Integer numValueOf = Integer.valueOf(i11);
                        TreeMap treeMap = this.f874f;
                        if (treeMap.get(numValueOf) == null) {
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(sVarP);
                            treeMap.put(Integer.valueOf(i11), linkedList);
                        } else {
                            ((LinkedList) treeMap.get(Integer.valueOf(i11))).add(sVarP);
                        }
                    }
                    g gVar3 = new g();
                    gVar3.c = hVar.f895a;
                    gVar3.b = hVar.b;
                    gVar3.e = hVar.e;
                    gVar3.f885f = (hVar.f886f - 1) / 2;
                    gVar3.d = hVar.d;
                    h hVar2 = new h(gVar3);
                    s sVarS = kotlin.reflect.l.S(tVar, (s) stack.pop(), sVarP, hVar2);
                    sVarP = new s(sVarS.f905a + 1, C5.f.j(sVarS.b));
                    g gVar4 = new g();
                    gVar4.c = hVar2.f895a;
                    gVar4.b = hVar2.b;
                    gVar4.e = hVar2.e + 1;
                    gVar4.f885f = hVar2.f886f;
                    gVar4.d = hVar2.d;
                    hVar = new h(gVar4);
                    kVar4 = kVar2;
                }
            }
            stack.push(sVarP);
            i4++;
            kVar3 = kVar4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    public final void b(byte[] bArr, byte[] bArr2, k kVar) {
        int i;
        boolean z6;
        k kVar2;
        ArrayList arrayList;
        Stack stack;
        int i3;
        int i4;
        int i5;
        int i6;
        long j6;
        int i7;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        k kVar3 = kVar;
        if (this.f877j) {
            throw new IllegalStateException("index already used");
        }
        int i8 = this.i;
        if (i8 > this.f878k - 1) {
            throw new IllegalStateException("index out of bounds");
        }
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i = this.b;
            if (i10 >= i) {
                i10 = 0;
                break;
            } else if (((i8 >> i10) & 1) == 0) {
                break;
            } else {
                i10++;
            }
        }
        int i11 = (this.i >> (i10 + 1)) & 1;
        TreeMap treeMap = this.f876h;
        ArrayList arrayList2 = this.e;
        if (i11 == 0 && i10 < i - 1) {
            treeMap.put(Integer.valueOf(i10), arrayList2.get(i10));
        }
        ArrayList<c> arrayList3 = this.c;
        int i12 = this.d;
        C0.t tVar = this.f873a;
        int i13 = kVar3.f895a;
        long j7 = kVar3.b;
        boolean z7 = true;
        if (i10 == 0) {
            i iVar = new i(1);
            iVar.c = i13;
            iVar.b = j7;
            iVar.e = this.i;
            iVar.f887f = kVar3.f891f;
            iVar.f888g = kVar3.f892g;
            iVar.d = kVar3.d;
            kVar3 = new k(iVar);
            tVar.j(tVar.i(bArr4, kVar3), bArr3);
            B.g gVarH = tVar.h(kVar3);
            i iVar2 = new i(0);
            iVar2.c = i13;
            iVar2.b = j7;
            iVar2.e = this.i;
            iVar2.f887f = 0;
            iVar2.f888g = 0;
            iVar2.d = 0;
            arrayList2.set(0, kotlin.reflect.l.P(tVar, gVarH, new j(iVar2)));
        } else {
            g gVar = new g();
            gVar.c = i13;
            gVar.b = j7;
            int i14 = i10 - 1;
            gVar.e = i14;
            gVar.f885f = this.i >> i10;
            gVar.d = 0;
            h hVar = new h(gVar);
            tVar.j(tVar.i(bArr4, kVar3), bArr3);
            s sVarS = kotlin.reflect.l.S(tVar, (s) arrayList2.get(i14), (s) treeMap.get(Integer.valueOf(i14)), hVar);
            arrayList2.set(i10, new s(sVarS.f905a + 1, C5.f.j(sVarS.b)));
            treeMap.remove(Integer.valueOf(i14));
            for (int i15 = 0; i15 < i10; i15++) {
                arrayList2.set(i15, i15 < i - i12 ? ((c) arrayList3.get(i15)).f880a : ((LinkedList) this.f874f.get(Integer.valueOf(i15))).removeFirst());
            }
            int iMin = Math.min(i10, i - i12);
            int i16 = 0;
            while (i16 < iMin) {
                int i17 = (((z7 ? 1 : 0) << i16) * 3) + this.i + 1;
                if (i17 < ((z7 ? 1 : 0) << i)) {
                    c cVar = (c) arrayList3.get(i16);
                    cVar.f880a = null;
                    cVar.c = cVar.b;
                    cVar.d = i17;
                    z6 = z7 ? 1 : 0;
                    cVar.e = z6;
                    cVar.f881f = false;
                } else {
                    z6 = z7 ? 1 : 0;
                }
                i16++;
                z7 = z6;
            }
        }
        for (?? r10 = z7; i9 < ((i - i12) >> r10); r10 = 1) {
            c cVar2 = null;
            for (c cVar3 : arrayList3) {
                if (!cVar3.f881f && cVar3.e && (cVar2 == null || cVar3.b() < cVar2.b() || (cVar3.b() == cVar2.b() && cVar3.d < cVar2.d))) {
                    cVar2 = cVar3;
                }
            }
            if (cVar2 == null) {
                kVar2 = kVar3;
                arrayList = arrayList3;
            } else {
                if (cVar2.f881f || !cVar2.e) {
                    throw new IllegalStateException("finished or not initialized");
                }
                i iVar3 = new i(1);
                iVar3.c = kVar3.f895a;
                iVar3.b = kVar3.b;
                iVar3.e = cVar2.d;
                iVar3.f887f = kVar3.f891f;
                iVar3.f888g = kVar3.f892g;
                iVar3.d = kVar3.d;
                k kVar4 = new k(iVar3);
                i iVar4 = new i(0);
                int i18 = kVar4.f895a;
                iVar4.c = i18;
                long j8 = kVar4.b;
                iVar4.b = j8;
                iVar4.e = cVar2.d;
                j jVar = new j(iVar4);
                g gVar2 = new g();
                gVar2.c = i18;
                gVar2.b = j8;
                gVar2.f885f = cVar2.d;
                h hVar2 = new h(gVar2);
                tVar.j(tVar.i(bArr4, kVar4), bArr3);
                s sVarP = kotlin.reflect.l.P(tVar, tVar.h(kVar4), jVar);
                while (true) {
                    stack = this.f875g;
                    boolean zIsEmpty = stack.isEmpty();
                    i3 = cVar2.b;
                    i4 = hVar2.d;
                    i5 = hVar2.f886f;
                    i6 = hVar2.e;
                    kVar2 = kVar3;
                    j6 = hVar2.b;
                    i7 = hVar2.f895a;
                    if (zIsEmpty) {
                        arrayList = arrayList3;
                        break;
                    }
                    arrayList = arrayList3;
                    if (((s) stack.peek()).f905a != sVarP.f905a || ((s) stack.peek()).f905a == i3) {
                        break;
                    }
                    g gVar3 = new g();
                    gVar3.c = i7;
                    gVar3.b = j6;
                    gVar3.e = i6;
                    gVar3.f885f = (i5 - 1) / 2;
                    gVar3.d = i4;
                    h hVar3 = new h(gVar3);
                    s sVarS2 = kotlin.reflect.l.S(tVar, (s) stack.pop(), sVarP, hVar3);
                    sVarP = new s(sVarS2.f905a + 1, C5.f.j(sVarS2.b));
                    g gVar4 = new g();
                    gVar4.c = hVar3.f895a;
                    gVar4.b = hVar3.b;
                    gVar4.e = hVar3.e + 1;
                    gVar4.f885f = hVar3.f886f;
                    gVar4.d = hVar3.d;
                    hVar2 = new h(gVar4);
                    kVar3 = kVar2;
                    arrayList3 = arrayList;
                }
                s sVar = cVar2.f880a;
                if (sVar == null) {
                    cVar2.f880a = sVarP;
                } else {
                    if (sVar.f905a == sVarP.f905a) {
                        g gVar5 = new g();
                        gVar5.c = i7;
                        gVar5.b = j6;
                        gVar5.e = i6;
                        gVar5.f885f = (i5 - 1) / 2;
                        gVar5.d = i4;
                        h hVar4 = new h(gVar5);
                        sVarP = new s(cVar2.f880a.f905a + 1, C5.f.j(kotlin.reflect.l.S(tVar, cVar2.f880a, sVarP, hVar4).b));
                        cVar2.f880a = sVarP;
                        g gVar6 = new g();
                        gVar6.c = hVar4.f895a;
                        gVar6.b = hVar4.b;
                        gVar6.e = hVar4.e + 1;
                        gVar6.f885f = hVar4.f886f;
                        gVar6.d = hVar4.d;
                        new h(gVar6);
                    } else {
                        stack.push(sVarP);
                    }
                }
                if (cVar2.f880a.f905a == i3) {
                    cVar2.f881f = true;
                } else {
                    cVar2.c = sVarP.f905a;
                    cVar2.d++;
                }
            }
            i9++;
            bArr3 = bArr;
            bArr4 = bArr2;
            kVar3 = kVar2;
            arrayList3 = arrayList;
        }
        this.i++;
    }

    public final void c() {
        if (this.e == null) {
            throw new IllegalStateException("authenticationPath == null");
        }
        if (this.f874f == null) {
            throw new IllegalStateException("retain == null");
        }
        if (this.f875g == null) {
            throw new IllegalStateException("stack == null");
        }
        if (this.c == null) {
            throw new IllegalStateException("treeHashInstances == null");
        }
        if (this.f876h == null) {
            throw new IllegalStateException("keep == null");
        }
        if (!C5.f.L(this.b, this.i)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    public a(a aVar) {
        this.f873a = new C0.t((m) aVar.f873a.b);
        this.b = aVar.b;
        this.d = aVar.d;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.addAll(aVar.e);
        this.f874f = new TreeMap();
        for (Integer num : aVar.f874f.keySet()) {
            this.f874f.put(num, (LinkedList) ((LinkedList) aVar.f874f.get(num)).clone());
        }
        Stack stack = new Stack();
        this.f875g = stack;
        stack.addAll(aVar.f875g);
        this.c = new ArrayList();
        Iterator it = aVar.c.iterator();
        while (it.hasNext()) {
            this.c.add(((c) it.next()).clone());
        }
        this.f876h = new TreeMap((Map) aVar.f876h);
        this.i = aVar.i;
        this.f878k = aVar.f878k;
        this.f877j = aVar.f877j;
    }

    public a(a aVar, int i, C0896n c0896n) {
        this.f873a = new C0.t(new m(c0896n));
        this.b = aVar.b;
        this.d = aVar.d;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.addAll(aVar.e);
        this.f874f = new TreeMap();
        for (Integer num : aVar.f874f.keySet()) {
            this.f874f.put(num, (LinkedList) ((LinkedList) aVar.f874f.get(num)).clone());
        }
        Stack stack = new Stack();
        this.f875g = stack;
        stack.addAll(aVar.f875g);
        this.c = new ArrayList();
        Iterator it = aVar.c.iterator();
        while (it.hasNext()) {
            this.c.add(((c) it.next()).clone());
        }
        this.f876h = new TreeMap((Map) aVar.f876h);
        this.i = aVar.i;
        this.f878k = i;
        this.f877j = aVar.f877j;
        c();
    }

    public a(a aVar, C0896n c0896n) {
        this.f873a = new C0.t(new m(c0896n));
        this.b = aVar.b;
        this.d = aVar.d;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.addAll(aVar.e);
        this.f874f = new TreeMap();
        for (Integer num : aVar.f874f.keySet()) {
            this.f874f.put(num, (LinkedList) ((LinkedList) aVar.f874f.get(num)).clone());
        }
        Stack stack = new Stack();
        this.f875g = stack;
        stack.addAll(aVar.f875g);
        this.c = new ArrayList();
        Iterator it = aVar.c.iterator();
        while (it.hasNext()) {
            this.c.add(((c) it.next()).clone());
        }
        this.f876h = new TreeMap((Map) aVar.f876h);
        this.i = aVar.i;
        this.f878k = aVar.f878k;
        this.f877j = aVar.f877j;
        c();
    }

    public a(a aVar, byte[] bArr, byte[] bArr2, k kVar) {
        this.f873a = new C0.t((m) aVar.f873a.b);
        this.b = aVar.b;
        this.d = aVar.d;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.addAll(aVar.e);
        this.f874f = new TreeMap();
        for (Integer num : aVar.f874f.keySet()) {
            this.f874f.put(num, (LinkedList) ((LinkedList) aVar.f874f.get(num)).clone());
        }
        Stack stack = new Stack();
        this.f875g = stack;
        stack.addAll(aVar.f875g);
        this.c = new ArrayList();
        Iterator it = aVar.c.iterator();
        while (it.hasNext()) {
            this.c.add(((c) it.next()).clone());
        }
        this.f876h = new TreeMap((Map) aVar.f876h);
        this.i = aVar.i;
        this.f878k = aVar.f878k;
        this.f877j = false;
        b(bArr, bArr2, kVar);
    }

    public a(t tVar, int i, int i3) {
        this(new C0.t(tVar.f909h), tVar.b, tVar.c, i3);
        this.f878k = i;
        this.i = i3;
        this.f877j = true;
    }

    public a(t tVar, byte[] bArr, byte[] bArr2, k kVar) {
        C0.t tVar2 = new C0.t(tVar.f909h);
        int i = tVar.b;
        this(tVar2, i, tVar.c, (1 << i) - 1);
        a(bArr, bArr2, kVar);
    }
}
