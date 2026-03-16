package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0399x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f2925a;
    public static final K0 b;
    public static final K0 c;
    public static final K0 d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f2925a = cls;
        b = w(false);
        c = w(true);
        d = new K0();
    }

    public static void A(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBoolList(i, list, z6);
    }

    public static void B(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeDoubleList(i, list, z6);
    }

    public static void C(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeEnumList(i, list, z6);
    }

    public static void D(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed32List(i, list, z6);
    }

    public static void E(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed64List(i, list, z6);
    }

    public static void F(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFloatList(i, list, z6);
    }

    public static void G(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt32List(i, list, z6);
    }

    public static void H(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt64List(i, list, z6);
    }

    public static void I(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed32List(i, list, z6);
    }

    public static void J(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed64List(i, list, z6);
    }

    public static void K(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt32List(i, list, z6);
    }

    public static void L(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt64List(i, list, z6);
    }

    public static void M(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt32List(i, list, z6);
    }

    public static void N(int i, List list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt64List(i, list, z6);
    }

    public static int a(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iG = AbstractC0398x.G(i) * size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iG += AbstractC0398x.A((AbstractC0381o) list.get(i3));
        }
        return iG;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0398x.G(i) * size) + c(list);
    }

    public static int c(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof S)) {
            int iE = 0;
            while (i < size) {
                iE += AbstractC0398x.E(((Integer) list.get(i)).intValue());
                i++;
            }
            return iE;
        }
        S s3 = (S) list;
        int iE2 = 0;
        while (i < size) {
            iE2 += AbstractC0398x.E(s3.getInt(i));
            i++;
        }
        return iE2;
    }

    public static int d(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return AbstractC0398x.B(i) * size;
    }

    public static int e(List list) {
        return list.size() * 4;
    }

    public static int f(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return AbstractC0398x.C(i) * size;
    }

    public static int g(List list) {
        return list.size() * 8;
    }

    public static int h(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0398x.G(i) * size) + i(list);
    }

    public static int i(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof S)) {
            int iE = 0;
            while (i < size) {
                iE += AbstractC0398x.E(((Integer) list.get(i)).intValue());
                i++;
            }
            return iE;
        }
        S s3 = (S) list;
        int iE2 = 0;
        while (i < size) {
            iE2 += AbstractC0398x.E(s3.getInt(i));
            i++;
        }
        return iE2;
    }

    public static int j(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (AbstractC0398x.G(i) * list.size()) + k(list);
    }

    public static int k(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof AbstractC0360d0)) {
            int iJ = 0;
            while (i < size) {
                iJ += AbstractC0398x.J(((Long) list.get(i)).longValue());
                i++;
            }
            return iJ;
        }
        AbstractC0360d0 abstractC0360d0 = (AbstractC0360d0) list;
        int iJ2 = 0;
        while (i < size) {
            iJ2 += AbstractC0398x.J(abstractC0360d0.getLong(i));
            i++;
        }
        return iJ2;
    }

    public static int l(int i, List list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iG = AbstractC0398x.G(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            int iA = ((AbstractC0357c) ((MessageLite) list.get(i3))).a(schema);
            iG += AbstractC0398x.I(iA) + iA;
        }
        return iG;
    }

    public static int m(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0398x.G(i) * size) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof S)) {
            int I = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                I += AbstractC0398x.I((iIntValue >> 31) ^ (iIntValue << 1));
                i++;
            }
            return I;
        }
        S s3 = (S) list;
        int I5 = 0;
        while (i < size) {
            int i3 = s3.getInt(i);
            I5 += AbstractC0398x.I((i3 >> 31) ^ (i3 << 1));
            i++;
        }
        return I5;
    }

    public static int o(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0398x.G(i) * size) + p(list);
    }

    public static int p(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof AbstractC0360d0)) {
            int iJ = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iJ += AbstractC0398x.J((jLongValue >> 63) ^ (jLongValue << 1));
                i++;
            }
            return iJ;
        }
        AbstractC0360d0 abstractC0360d0 = (AbstractC0360d0) list;
        int iJ2 = 0;
        while (i < size) {
            long j6 = abstractC0360d0.getLong(i);
            iJ2 += AbstractC0398x.J((j6 >> 63) ^ (j6 << 1));
            i++;
        }
        return iJ2;
    }

    public static int q(int i, List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int iG = AbstractC0398x.G(i) * size;
        if (!(list instanceof LazyStringList)) {
            while (i3 < size) {
                Object obj = list.get(i3);
                iG = (obj instanceof AbstractC0381o ? AbstractC0398x.A((AbstractC0381o) obj) : AbstractC0398x.F((String) obj)) + iG;
                i3++;
            }
            return iG;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        while (i3 < size) {
            Object raw = lazyStringList.getRaw(i3);
            iG = (raw instanceof AbstractC0381o ? AbstractC0398x.A((AbstractC0381o) raw) : AbstractC0398x.F((String) raw)) + iG;
            i3++;
        }
        return iG;
    }

    public static int r(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0398x.G(i) * size) + s(list);
    }

    public static int s(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof S)) {
            int I = 0;
            while (i < size) {
                I += AbstractC0398x.I(((Integer) list.get(i)).intValue());
                i++;
            }
            return I;
        }
        S s3 = (S) list;
        int I5 = 0;
        while (i < size) {
            I5 += AbstractC0398x.I(s3.getInt(i));
            i++;
        }
        return I5;
    }

    public static int t(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (AbstractC0398x.G(i) * size) + u(list);
    }

    public static int u(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof AbstractC0360d0)) {
            int iJ = 0;
            while (i < size) {
                iJ += AbstractC0398x.J(((Long) list.get(i)).longValue());
                i++;
            }
            return iJ;
        }
        AbstractC0360d0 abstractC0360d0 = (AbstractC0360d0) list;
        int iJ2 = 0;
        while (i < size) {
            iJ2 += AbstractC0398x.J(abstractC0360d0.getLong(i));
            i++;
        }
        return iJ2;
    }

    public static Object v(Object obj, int i, List list, Internal$EnumVerifier internal$EnumVerifier, Object obj2, K0 k02) {
        if (internal$EnumVerifier == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!internal$EnumVerifier.isInRange(iIntValue)) {
                    obj2 = z(obj, i, iIntValue, obj2, k02);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Integer num = (Integer) list.get(i4);
            int iIntValue2 = num.intValue();
            if (internal$EnumVerifier.isInRange(iIntValue2)) {
                if (i4 != i3) {
                    list.set(i3, num);
                }
                i3++;
            } else {
                obj2 = z(obj, i, iIntValue2, obj2, k02);
            }
        }
        if (i3 != size) {
            list.subList(i3, size).clear();
        }
        return obj2;
    }

    public static K0 w(boolean z6) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (K0) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z6));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void x(K0 k02, Object obj, Object obj2) {
        k02.getClass();
        Q q = (Q) obj;
        J0 j02 = q.unknownFields;
        J0 j03 = ((Q) obj2).unknownFields;
        J0 j04 = J0.f2833f;
        if (!j04.equals(j03)) {
            if (j04.equals(j02)) {
                int i = j02.f2834a + j03.f2834a;
                int[] iArrCopyOf = Arrays.copyOf(j02.b, i);
                System.arraycopy(j03.b, 0, iArrCopyOf, j02.f2834a, j03.f2834a);
                Object[] objArrCopyOf = Arrays.copyOf(j02.c, i);
                System.arraycopy(j03.c, 0, objArrCopyOf, j02.f2834a, j03.f2834a);
                j02 = new J0(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                j02.getClass();
                if (!j03.equals(j04)) {
                    if (!j02.e) {
                        throw new UnsupportedOperationException();
                    }
                    int i3 = j02.f2834a + j03.f2834a;
                    j02.a(i3);
                    System.arraycopy(j03.b, 0, j02.b, j02.f2834a, j03.f2834a);
                    System.arraycopy(j03.c, 0, j02.c, j02.f2834a, j03.f2834a);
                    j02.f2834a = i3;
                }
            }
        }
        q.unknownFields = j02;
    }

    public static boolean y(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object z(Object obj, int i, int i3, Object obj2, K0 k02) {
        if (obj2 == null) {
            k02.getClass();
            obj2 = K0.a(obj);
        }
        k02.getClass();
        ((J0) obj2).d(i << 3, Long.valueOf(i3));
        return obj2;
    }
}
