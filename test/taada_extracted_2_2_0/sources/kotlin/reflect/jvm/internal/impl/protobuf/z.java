package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends AbstractC0604e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f3884h;
    public final int b;
    public final AbstractC0604e c;
    public final AbstractC0604e d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3886g = 0;

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i3 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i4 = i3 + i;
            i3 = i;
            i = i4;
        }
        arrayList.add(Integer.MAX_VALUE);
        f3884h = new int[arrayList.size()];
        int i5 = 0;
        while (true) {
            int[] iArr = f3884h;
            if (i5 >= iArr.length) {
                return;
            }
            iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
            i5++;
        }
    }

    public z(AbstractC0604e abstractC0604e, AbstractC0604e abstractC0604e2) {
        this.c = abstractC0604e;
        this.d = abstractC0604e2;
        int size = abstractC0604e.size();
        this.e = size;
        this.b = abstractC0604e2.size() + size;
        this.f3885f = Math.max(abstractC0604e.e(), abstractC0604e2.e()) + 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final void d(byte[] bArr, int i, int i3, int i4) {
        int i5 = i + i4;
        AbstractC0604e abstractC0604e = this.c;
        int i6 = this.e;
        if (i5 <= i6) {
            abstractC0604e.d(bArr, i, i3, i4);
            return;
        }
        AbstractC0604e abstractC0604e2 = this.d;
        if (i >= i6) {
            abstractC0604e2.d(bArr, i - i6, i3, i4);
            return;
        }
        int i7 = i6 - i;
        abstractC0604e.d(bArr, i, i3, i7);
        abstractC0604e2.d(bArr, 0, i3 + i7, i4 - i7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final int e() {
        return this.f3885f;
    }

    public final boolean equals(Object obj) {
        int iL;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0604e) {
            AbstractC0604e abstractC0604e = (AbstractC0604e) obj;
            int size = abstractC0604e.size();
            int i = this.b;
            if (i == size) {
                if (i == 0) {
                    return true;
                }
                if (this.f3886g == 0 || (iL = abstractC0604e.l()) == 0 || this.f3886g == iL) {
                    w wVar = new w(this);
                    u uVarA = wVar.next();
                    w wVar2 = new w(abstractC0604e);
                    u uVarA2 = wVar2.next();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        int length = uVarA.b.length - i3;
                        int length2 = uVarA2.b.length - i4;
                        int iMin = Math.min(length, length2);
                        if (!(i3 == 0 ? uVarA.p(uVarA2, i4, iMin) : uVarA2.p(uVarA, i3, iMin))) {
                            break;
                        }
                        i5 += iMin;
                        if (i5 >= i) {
                            if (i5 == i) {
                                return true;
                            }
                            throw new IllegalStateException();
                        }
                        if (iMin == length) {
                            uVarA = wVar.next();
                            i3 = 0;
                        } else {
                            i3 += iMin;
                        }
                        if (iMin == length2) {
                            uVarA2 = wVar2.next();
                            i4 = 0;
                        } else {
                            i4 += iMin;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final boolean f() {
        return this.b >= f3884h[this.f3885f];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final boolean g() {
        int iK = this.c.k(0, 0, this.e);
        AbstractC0604e abstractC0604e = this.d;
        return abstractC0604e.k(iK, 0, abstractC0604e.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final C0605f h() {
        return new C0605f(new y(this));
    }

    public final int hashCode() {
        int iJ = this.f3886g;
        if (iJ == 0) {
            int i = this.b;
            iJ = j(i, 0, i);
            if (iJ == 0) {
                iJ = 1;
            }
            this.f3886g = iJ;
        }
        return iJ;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new x(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final int j(int i, int i3, int i4) {
        int i5 = i3 + i4;
        AbstractC0604e abstractC0604e = this.c;
        int i6 = this.e;
        if (i5 <= i6) {
            return abstractC0604e.j(i, i3, i4);
        }
        AbstractC0604e abstractC0604e2 = this.d;
        if (i3 >= i6) {
            return abstractC0604e2.j(i, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return abstractC0604e2.j(abstractC0604e.j(i, i3, i7), 0, i4 - i7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final int k(int i, int i3, int i4) {
        int i5 = i3 + i4;
        AbstractC0604e abstractC0604e = this.c;
        int i6 = this.e;
        if (i5 <= i6) {
            return abstractC0604e.k(i, i3, i4);
        }
        AbstractC0604e abstractC0604e2 = this.d;
        if (i3 >= i6) {
            return abstractC0604e2.k(i, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return abstractC0604e2.k(abstractC0604e.k(i, i3, i7), 0, i4 - i7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final int l() {
        return this.f3886g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final String m() {
        byte[] bArr;
        int i = this.b;
        if (i == 0) {
            bArr = q.f3874a;
        } else {
            byte[] bArr2 = new byte[i];
            d(bArr2, 0, 0, i);
            bArr = bArr2;
        }
        return new String(bArr, "UTF-8");
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final void o(OutputStream outputStream, int i, int i3) {
        int i4 = i + i3;
        AbstractC0604e abstractC0604e = this.c;
        int i5 = this.e;
        if (i4 <= i5) {
            abstractC0604e.o(outputStream, i, i3);
            return;
        }
        AbstractC0604e abstractC0604e2 = this.d;
        if (i >= i5) {
            abstractC0604e2.o(outputStream, i - i5, i3);
            return;
        }
        int i6 = i5 - i;
        abstractC0604e.o(outputStream, i, i6);
        abstractC0604e2.o(outputStream, 0, i3 - i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
    public final int size() {
        return this.b;
    }
}
