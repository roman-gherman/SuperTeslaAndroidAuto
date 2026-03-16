package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.v1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0325v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0266b1 f2131a;

    static {
        C0316s1 c0316s1 = C0316s1.c;
        f2131a = new C0266b1(6);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0275e1)) {
            int iM = 0;
            while (i < size) {
                iM += V0.M(((Integer) list.get(i)).intValue());
                i++;
            }
            return iM;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        int iM2 = 0;
        while (i < size) {
            iM2 += V0.M(c0275e1.b(i));
            i++;
        }
        return iM2;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (V0.b0(i << 3) + 4) * size;
    }

    public static int d(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (V0.b0(i << 3) + 8) * size;
    }

    public static int e(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0275e1)) {
            int iM = 0;
            while (i < size) {
                iM += V0.M(((Integer) list.get(i)).intValue());
                i++;
            }
            return iM;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        int iM2 = 0;
        while (i < size) {
            iM2 += V0.M(c0275e1.b(i));
            i++;
        }
        return iM2;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM = 0;
        for (int i = 0; i < size; i++) {
            iM += V0.M(((Long) list.get(i)).longValue());
        }
        return iM;
    }

    public static int g(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0275e1)) {
            int iB0 = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iB0 += V0.b0((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iB0;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        int iB02 = 0;
        while (i < size) {
            int iB = c0275e1.b(i);
            iB02 += V0.b0((iB >> 31) ^ (iB + iB));
            i++;
        }
        return iB02;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iM += V0.M((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iM;
    }

    public static int i(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C0275e1)) {
            int iB0 = 0;
            while (i < size) {
                iB0 += V0.b0(((Integer) list.get(i)).intValue());
                i++;
            }
            return iB0;
        }
        C0275e1 c0275e1 = (C0275e1) list;
        int iB02 = 0;
        while (i < size) {
            iB02 += V0.b0(c0275e1.b(i));
            i++;
        }
        return iB02;
    }

    public static int j(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM = 0;
        for (int i = 0; i < size; i++) {
            iM += V0.M(((Long) list.get(i)).longValue());
        }
        return iM;
    }

    public static Object k(Object obj, int i, int i3, Object obj2) {
        Object obj3 = obj2;
        if (obj2 == null) {
            AbstractC0272d1 abstractC0272d1 = (AbstractC0272d1) obj;
            C0334y1 c0334y1 = abstractC0272d1.zzc;
            obj3 = c0334y1;
            if (c0334y1 == C0334y1.f2135f) {
                C0334y1 c0334y1B = C0334y1.b();
                abstractC0272d1.zzc = c0334y1B;
                obj3 = c0334y1B;
            }
        }
        ((C0334y1) obj3).c(i << 3, Long.valueOf(i3));
        return obj3;
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
    public static void l(Object obj, Object obj2) {
        AbstractC0272d1 abstractC0272d1 = (AbstractC0272d1) obj;
        C0334y1 c0334y1 = abstractC0272d1.zzc;
        C0334y1 c0334y12 = ((AbstractC0272d1) obj2).zzc;
        C0334y1 c0334y13 = C0334y1.f2135f;
        if (!c0334y13.equals(c0334y12)) {
            if (c0334y13.equals(c0334y1)) {
                int i = c0334y1.f2136a + c0334y12.f2136a;
                int[] iArrCopyOf = Arrays.copyOf(c0334y1.b, i);
                System.arraycopy(c0334y12.b, 0, iArrCopyOf, c0334y1.f2136a, c0334y12.f2136a);
                Object[] objArrCopyOf = Arrays.copyOf(c0334y1.c, i);
                System.arraycopy(c0334y12.c, 0, objArrCopyOf, c0334y1.f2136a, c0334y12.f2136a);
                c0334y1 = new C0334y1(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                c0334y1.getClass();
                if (!c0334y12.equals(c0334y13)) {
                    if (!c0334y1.e) {
                        throw new UnsupportedOperationException();
                    }
                    int i3 = c0334y1.f2136a + c0334y12.f2136a;
                    c0334y1.e(i3);
                    System.arraycopy(c0334y12.b, 0, c0334y1.b, c0334y1.f2136a, c0334y12.f2136a);
                    System.arraycopy(c0334y12.c, 0, c0334y1.c, c0334y1.f2136a, c0334y12.f2136a);
                    c0334y1.f2136a = i3;
                }
            }
        }
        abstractC0272d1.zzc = c0334y1;
    }
}
