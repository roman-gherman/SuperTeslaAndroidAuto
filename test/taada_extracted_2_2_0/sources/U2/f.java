package U2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final z.e c = new z.e(2);
    public static final int d;
    public static final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1322h;
    public static final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f1323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f1324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f1325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f f1326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f f1327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final f f1328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f f1329p;
    public static final f q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ArrayList f1330r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ArrayList f1331s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1332a;
    public final int b;

    static {
        e eVar;
        int i3 = d;
        int i4 = i3 << 1;
        e = i3;
        int i5 = i3 << 2;
        f1320f = i4;
        int i6 = i3 << 3;
        f1321g = i5;
        int i7 = i3 << 4;
        f1322h = i6;
        int i8 = i3 << 5;
        i = i7;
        f1323j = i8;
        d = i3 << 7;
        int i9 = (i3 << 6) - 1;
        f1324k = i9;
        int i10 = i3 | i4 | i5;
        f1325l = i10;
        f1326m = new f(i9);
        f1327n = new f(i7 | i8);
        new f(i3);
        new f(i4);
        new f(i5);
        f1328o = new f(i10);
        new f(i6);
        f1329p = new f(i7);
        q = new f(i8);
        new f(i4 | i7 | i8);
        Field[] fields = f.class.getFields();
        kotlin.jvm.internal.h.e(fields, "T::class.java.fields");
        ArrayList arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            e eVar2 = null;
            if (!it.hasNext()) {
                break;
            }
            Field field2 = (Field) it.next();
            Object obj = field2.get(null);
            f fVar = obj instanceof f ? (f) obj : null;
            if (fVar != null) {
                String name = field2.getName();
                kotlin.jvm.internal.h.e(name, "field.name");
                eVar2 = new e(fVar.b, name);
            }
            if (eVar2 != null) {
                arrayList2.add(eVar2);
            }
        }
        f1330r = arrayList2;
        Field[] fields2 = f.class.getFields();
        kotlin.jvm.internal.h.e(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (kotlin.jvm.internal.h.a(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            kotlin.jvm.internal.h.d(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                kotlin.jvm.internal.h.e(name2, "field.name");
                eVar = new e(iIntValue, name2);
            } else {
                eVar = null;
            }
            if (eVar != null) {
                arrayList5.add(eVar);
            }
        }
        f1331s = arrayList5;
    }

    public f(int i3, List excludes) {
        kotlin.jvm.internal.h.f(excludes, "excludes");
        this.f1332a = excludes;
        Iterator it = excludes.iterator();
        while (it.hasNext()) {
            i3 &= ~((d) it.next()).a();
        }
        this.b = i3;
    }

    public final boolean a(int i3) {
        return (i3 & this.b) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        f fVar = (f) obj;
        return kotlin.jvm.internal.h.a(this.f1332a, fVar.f1332a) && this.b == fVar.b;
    }

    public final int hashCode() {
        return (this.f1332a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        Object next;
        Iterator it = f1330r.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((e) next).f1319a == this.b) {
                break;
            }
        }
        e eVar = (e) next;
        String strV = eVar != null ? eVar.b : null;
        if (strV == null) {
            ArrayList<e> arrayList = f1331s;
            ArrayList arrayList2 = new ArrayList();
            for (e eVar2 : arrayList) {
                String str = a(eVar2.f1319a) ? eVar2.b : null;
                if (str != null) {
                    arrayList2.add(str);
                }
            }
            strV = kotlin.collections.m.V(arrayList2, " | ", null, null, null, 62);
        }
        StringBuilder sbM = B2.b.m("DescriptorKindFilter(", strV, ", ");
        sbM.append(this.f1332a);
        sbM.append(')');
        return sbM.toString();
    }

    public /* synthetic */ f(int i3) {
        this(i3, u.f3805a);
    }
}
