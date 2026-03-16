package j3;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.RandomAccess;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends AbstractList implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3670a;
    public Object b;

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        int i = this.f3670a;
        if (i == 0) {
            this.b = obj;
        } else if (i == 1) {
            this.b = new Object[]{this.b, obj};
        } else {
            Object[] objArr = (Object[]) this.b;
            int length = objArr.length;
            if (i >= length) {
                int iY = androidx.constraintlayout.core.motion.a.y(length, 3, 2, 1);
                int i3 = i + 1;
                if (iY < i3) {
                    iY = i3;
                }
                Object[] objArr2 = new Object[iY];
                this.b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f3670a] = obj;
        }
        this.f3670a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b = null;
        this.f3670a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i3;
        if (i >= 0 && i < (i3 = this.f3670a)) {
            return i3 == 1 ? this.b : ((Object[]) this.b)[i];
        }
        StringBuilder sbJ = B2.b.j(i, "Index: ", ", Size: ");
        sbJ.append(this.f3670a);
        throw new IndexOutOfBoundsException(sbJ.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        int i = this.f3670a;
        if (i == 0) {
            return h.f3668a;
        }
        if (i == 1) {
            return new i(this);
        }
        Iterator it = super.iterator();
        if (it != null) {
            return it;
        }
        a(3);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i3;
        Object obj;
        if (i < 0 || i >= (i3 = this.f3670a)) {
            StringBuilder sbJ = B2.b.j(i, "Index: ", ", Size: ");
            sbJ.append(this.f3670a);
            throw new IndexOutOfBoundsException(sbJ.toString());
        }
        if (i3 == 1) {
            obj = this.b;
            this.b = null;
        } else {
            Object[] objArr = (Object[]) this.b;
            Object obj2 = objArr[i];
            if (i3 == 2) {
                this.b = objArr[1 - i];
            } else {
                int i4 = (i3 - i) - 1;
                if (i4 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i4);
                }
                objArr[this.f3670a - 1] = null;
            }
            obj = obj2;
        }
        this.f3670a--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i3;
        if (i < 0 || i >= (i3 = this.f3670a)) {
            StringBuilder sbJ = B2.b.j(i, "Index: ", ", Size: ");
            sbJ.append(this.f3670a);
            throw new IndexOutOfBoundsException(sbJ.toString());
        }
        if (i3 == 1) {
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }
        Object[] objArr = (Object[]) this.b;
        Object obj3 = objArr[i];
        objArr[i] = obj;
        return obj3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3670a;
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        int i = this.f3670a;
        if (i >= 2) {
            Arrays.sort((Object[]) this.b, 0, i, comparator);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            a(4);
            throw null;
        }
        int length = objArr.length;
        int i = this.f3670a;
        if (i == 1) {
            if (length == 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = this.b;
                return objArr2;
            }
            objArr[0] = this.b;
        } else {
            if (length < i) {
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.b, i, objArr.getClass());
                if (objArrCopyOf != null) {
                    return objArrCopyOf;
                }
                a(6);
                throw null;
            }
            if (i != 0) {
                System.arraycopy(this.b, 0, objArr, 0, i);
            }
        }
        int i3 = this.f3670a;
        if (length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        if (i >= 0 && i <= (i3 = this.f3670a)) {
            if (i3 == 0) {
                this.b = obj;
            } else if (i3 == 1 && i == 0) {
                this.b = new Object[]{obj, this.b};
            } else {
                Object[] objArr = new Object[i3 + 1];
                if (i3 == 1) {
                    objArr[0] = this.b;
                } else {
                    Object[] objArr2 = (Object[]) this.b;
                    System.arraycopy(objArr2, 0, objArr, 0, i);
                    System.arraycopy(objArr2, i, objArr, i + 1, this.f3670a - i);
                }
                objArr[i] = obj;
                this.b = objArr;
            }
            this.f3670a++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbJ = B2.b.j(i, "Index: ", ", Size: ");
        sbJ.append(this.f3670a);
        throw new IndexOutOfBoundsException(sbJ.toString());
    }
}
