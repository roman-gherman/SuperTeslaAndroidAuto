package com.google.android.material.color;

import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2347a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f2348f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f2349g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f2350h = new ArrayList();
    public final ArrayList i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f2351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f2353l;

    public f(boolean z6, String... strArr) {
        byte[] bArr;
        this.f2351j = z6;
        int length = 0;
        for (String str : strArr) {
            if (this.f2351j) {
                byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
                byte length2 = (byte) bytes.length;
                int length3 = bytes.length;
                bArr = new byte[length3 + 3];
                System.arraycopy(bytes, 0, bArr, 2, length2);
                bArr[1] = length2;
                bArr[0] = length2;
                bArr[length3 + 2] = 0;
            } else {
                char[] charArray = str.toCharArray();
                int length4 = charArray.length * 2;
                bArr = new byte[length4 + 4];
                byte[] bArrH = g.h((short) charArray.length);
                bArr[0] = bArrH[0];
                bArr[1] = bArrH[1];
                for (int i = 0; i < charArray.length; i++) {
                    byte[] bArrC = g.c(charArray[i]);
                    int i3 = i * 2;
                    bArr[i3 + 2] = bArrC[0];
                    bArr[i3 + 3] = bArrC[1];
                }
                bArr[length4 + 2] = 0;
                bArr[length4 + 3] = 0;
            }
            Pair pair = new Pair(bArr, Collections.EMPTY_LIST);
            this.f2348f.add(Integer.valueOf(length));
            byte[] bArr2 = (byte[]) pair.first;
            length += bArr2.length;
            this.f2350h.add(bArr2);
            this.i.add((List) pair.second);
        }
        int size = 0;
        for (List list : this.i) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                this.f2348f.add(Integer.valueOf(length));
                throw null;
            }
            this.f2349g.add(Integer.valueOf(size));
            size += (list.size() * 12) + 4;
        }
        int i4 = length % 4;
        int i5 = i4 == 0 ? 0 : 4 - i4;
        this.f2352k = i5;
        int size2 = this.f2350h.size();
        this.b = size2;
        this.c = this.f2350h.size() - strArr.length;
        boolean z7 = this.f2350h.size() - strArr.length > 0;
        if (!z7) {
            this.f2349g.clear();
            this.i.clear();
        }
        int size3 = (this.f2349g.size() * 4) + (size2 * 4) + 28;
        this.d = size3;
        int i6 = length + i5;
        this.e = z7 ? size3 + i6 : 0;
        int i7 = size3 + i6 + (z7 ? size : 0);
        this.f2353l = i7;
        this.f2347a = new d((short) 1, (short) 28, i7);
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream) {
        this.f2347a.a(byteArrayOutputStream);
        byteArrayOutputStream.write(g.a(this.b));
        byteArrayOutputStream.write(g.a(this.c));
        byteArrayOutputStream.write(g.a(this.f2351j ? 256 : 0));
        byteArrayOutputStream.write(g.a(this.d));
        byteArrayOutputStream.write(g.a(this.e));
        Iterator it = this.f2348f.iterator();
        while (it.hasNext()) {
            byteArrayOutputStream.write(g.a(((Integer) it.next()).intValue()));
        }
        Iterator it2 = this.f2349g.iterator();
        while (it2.hasNext()) {
            byteArrayOutputStream.write(g.a(((Integer) it2.next()).intValue()));
        }
        Iterator it3 = this.f2350h.iterator();
        while (it3.hasNext()) {
            byteArrayOutputStream.write((byte[]) it3.next());
        }
        int i = this.f2352k;
        if (i > 0) {
            byteArrayOutputStream.write(new byte[i]);
        }
        Iterator it4 = this.i.iterator();
        while (it4.hasNext()) {
            Iterator it5 = ((List) it4.next()).iterator();
            if (it5.hasNext()) {
                it5.next().getClass();
                throw new ClassCastException();
            }
            byteArrayOutputStream.write(g.a(-1));
        }
    }
}
