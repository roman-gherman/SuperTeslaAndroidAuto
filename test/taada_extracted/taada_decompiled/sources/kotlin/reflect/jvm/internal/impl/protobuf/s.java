package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends AbstractList implements RandomAccess, LazyStringList {
    public static final H b = new H(new s());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3875a;

    public s() {
        this.f3875a = new ArrayList();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        this.f3875a.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f3875a.size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f3875a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ArrayList arrayList = this.f3875a;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC0604e) {
            AbstractC0604e abstractC0604e = (AbstractC0604e) obj;
            String strN = abstractC0604e.n();
            if (abstractC0604e.g()) {
                arrayList.set(i, strN);
            }
            return strN;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = q.f3873a;
        try {
            String str = new String(bArr, "UTF-8");
            if (D.c(bArr, 0, bArr.length) == 0) {
                arrayList.set(i, str);
            }
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public final AbstractC0604e getByteString(int i) {
        AbstractC0604e uVar;
        ArrayList arrayList = this.f3875a;
        Object obj = arrayList.get(i);
        if (obj instanceof AbstractC0604e) {
            uVar = (AbstractC0604e) obj;
        } else if (obj instanceof String) {
            try {
                uVar = new u(((String) obj).getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported?", e);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            uVar = new u(bArr2);
        }
        if (uVar != obj) {
            arrayList.set(i, uVar);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f3875a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public final LazyStringList getUnmodifiableView() {
        return new H(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        Object objRemove = this.f3875a.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (objRemove instanceof AbstractC0604e) {
            return ((AbstractC0604e) objRemove).n();
        }
        byte[] bArr = (byte[]) objRemove;
        byte[] bArr2 = q.f3873a;
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Object obj2 = this.f3875a.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof AbstractC0604e) {
            return ((AbstractC0604e) obj2).n();
        }
        byte[] bArr = (byte[]) obj2;
        byte[] bArr2 = q.f3873a;
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3875a.size();
    }

    public s(LazyStringList lazyStringList) {
        this.f3875a = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f3875a.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public final void add(AbstractC0604e abstractC0604e) {
        this.f3875a.add(abstractC0604e);
        ((AbstractList) this).modCount++;
    }
}
