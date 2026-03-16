package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class n extends AbstractMap implements Serializable {
    public static final com.google.android.gms.location.h i = new com.google.android.gms.location.h(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f3010a;
    public final boolean b;
    public m c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f3011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f3012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f3013h;

    public n(boolean z6) {
        com.google.android.gms.location.h hVar = i;
        this.d = 0;
        this.e = 0;
        this.f3010a = hVar;
        this.b = z6;
        this.f3011f = new m(z6);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public final m a(Object obj, boolean z6) {
        int iCompareTo;
        m mVar;
        m mVar2 = this.c;
        com.google.android.gms.location.h hVar = i;
        Comparator comparator = this.f3010a;
        if (mVar2 != null) {
            Comparable comparable = comparator == hVar ? (Comparable) obj : null;
            while (true) {
                Object obj2 = mVar2.f3007f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return mVar2;
                }
                m mVar3 = iCompareTo < 0 ? mVar2.b : mVar2.c;
                if (mVar3 == null) {
                    break;
                }
                mVar2 = mVar3;
            }
        } else {
            iCompareTo = 0;
        }
        m mVar4 = mVar2;
        if (!z6) {
            return null;
        }
        m mVar5 = this.f3011f;
        if (mVar4 != null) {
            mVar = new m(this.b, mVar4, obj, mVar5, mVar5.e);
            if (iCompareTo < 0) {
                mVar4.b = mVar;
            } else {
                mVar4.c = mVar;
            }
            b(mVar4, true);
        } else {
            if (comparator == hVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            mVar = new m(this.b, mVar4, obj, mVar5, mVar5.e);
            this.c = mVar;
        }
        this.d++;
        this.e++;
        return mVar;
    }

    public final void b(m mVar, boolean z6) {
        while (mVar != null) {
            m mVar2 = mVar.b;
            m mVar3 = mVar.c;
            int i3 = mVar2 != null ? mVar2.i : 0;
            int i4 = mVar3 != null ? mVar3.i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                m mVar4 = mVar3.b;
                m mVar5 = mVar3.c;
                int i6 = (mVar4 != null ? mVar4.i : 0) - (mVar5 != null ? mVar5.i : 0);
                if (i6 == -1 || (i6 == 0 && !z6)) {
                    e(mVar);
                } else {
                    f(mVar3);
                    e(mVar);
                }
                if (z6) {
                    return;
                }
            } else if (i5 == 2) {
                m mVar6 = mVar2.b;
                m mVar7 = mVar2.c;
                int i7 = (mVar6 != null ? mVar6.i : 0) - (mVar7 != null ? mVar7.i : 0);
                if (i7 == 1 || (i7 == 0 && !z6)) {
                    f(mVar);
                } else {
                    e(mVar2);
                    f(mVar);
                }
                if (z6) {
                    return;
                }
            } else if (i5 == 0) {
                mVar.i = i3 + 1;
                if (z6) {
                    return;
                }
            } else {
                mVar.i = Math.max(i3, i4) + 1;
                if (!z6) {
                    return;
                }
            }
            mVar = mVar.f3006a;
        }
    }

    public final void c(m mVar, boolean z6) {
        m mVar2;
        m mVar3;
        int i3;
        if (z6) {
            m mVar4 = mVar.e;
            mVar4.d = mVar.d;
            mVar.d.e = mVar4;
        }
        m mVar5 = mVar.b;
        m mVar6 = mVar.c;
        m mVar7 = mVar.f3006a;
        int i4 = 0;
        if (mVar5 == null || mVar6 == null) {
            if (mVar5 != null) {
                d(mVar, mVar5);
                mVar.b = null;
            } else if (mVar6 != null) {
                d(mVar, mVar6);
                mVar.c = null;
            } else {
                d(mVar, null);
            }
            b(mVar7, false);
            this.d--;
            this.e++;
            return;
        }
        if (mVar5.i > mVar6.i) {
            m mVar8 = mVar5.c;
            while (true) {
                m mVar9 = mVar8;
                mVar3 = mVar5;
                mVar5 = mVar9;
                if (mVar5 == null) {
                    break;
                } else {
                    mVar8 = mVar5.c;
                }
            }
        } else {
            m mVar10 = mVar6.b;
            while (true) {
                mVar2 = mVar6;
                mVar6 = mVar10;
                if (mVar6 == null) {
                    break;
                } else {
                    mVar10 = mVar6.b;
                }
            }
            mVar3 = mVar2;
        }
        c(mVar3, false);
        m mVar11 = mVar.b;
        if (mVar11 != null) {
            i3 = mVar11.i;
            mVar3.b = mVar11;
            mVar11.f3006a = mVar3;
            mVar.b = null;
        } else {
            i3 = 0;
        }
        m mVar12 = mVar.c;
        if (mVar12 != null) {
            i4 = mVar12.i;
            mVar3.c = mVar12;
            mVar12.f3006a = mVar3;
            mVar.c = null;
        }
        mVar3.i = Math.max(i3, i4) + 1;
        d(mVar, mVar3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.c = null;
        this.d = 0;
        this.e++;
        m mVar = this.f3011f;
        mVar.e = mVar;
        mVar.d = mVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        m mVarA = null;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return mVarA != null;
    }

    public final void d(m mVar, m mVar2) {
        m mVar3 = mVar.f3006a;
        mVar.f3006a = null;
        if (mVar2 != null) {
            mVar2.f3006a = mVar3;
        }
        if (mVar3 == null) {
            this.c = mVar2;
        } else if (mVar3.b == mVar) {
            mVar3.b = mVar2;
        } else {
            mVar3.c = mVar2;
        }
    }

    public final void e(m mVar) {
        m mVar2 = mVar.b;
        m mVar3 = mVar.c;
        m mVar4 = mVar3.b;
        m mVar5 = mVar3.c;
        mVar.c = mVar4;
        if (mVar4 != null) {
            mVar4.f3006a = mVar;
        }
        d(mVar, mVar3);
        mVar3.b = mVar;
        mVar.f3006a = mVar3;
        int iMax = Math.max(mVar2 != null ? mVar2.i : 0, mVar4 != null ? mVar4.i : 0) + 1;
        mVar.i = iMax;
        mVar3.i = Math.max(iMax, mVar5 != null ? mVar5.i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        l lVar = this.f3012g;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 0);
        this.f3012g = lVar2;
        return lVar2;
    }

    public final void f(m mVar) {
        m mVar2 = mVar.b;
        m mVar3 = mVar.c;
        m mVar4 = mVar2.b;
        m mVar5 = mVar2.c;
        mVar.b = mVar5;
        if (mVar5 != null) {
            mVar5.f3006a = mVar;
        }
        d(mVar, mVar2);
        mVar2.c = mVar;
        mVar.f3006a = mVar2;
        int iMax = Math.max(mVar3 != null ? mVar3.i : 0, mVar5 != null ? mVar5.i : 0) + 1;
        mVar.i = iMax;
        mVar2.i = Math.max(iMax, mVar4 != null ? mVar4.i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        m mVarA;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
                mVarA = null;
            }
        } else {
            mVarA = null;
        }
        if (mVarA != null) {
            return mVarA.f3009h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        l lVar = this.f3013h;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 1);
        this.f3013h = lVar2;
        return lVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.b) {
            throw new NullPointerException("value == null");
        }
        m mVarA = a(obj, true);
        Object obj3 = mVarA.f3009h;
        mVarA.f3009h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m mVarA;
        if (obj != null) {
            try {
                mVarA = a(obj, false);
            } catch (ClassCastException unused) {
                mVarA = null;
            }
        } else {
            mVarA = null;
        }
        if (mVarA != null) {
            c(mVarA, true);
        }
        if (mVarA != null) {
            return mVarA.f3009h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.d;
    }
}
