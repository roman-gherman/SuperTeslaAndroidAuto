package com.google.android.gms.internal.play_billing;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.a1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0263a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2069a;

    public /* synthetic */ AbstractC0263a1(int i) {
        this.f2069a = i;
    }

    public static int A(byte[] bArr, int i, zzho zzhoVar, N0 n02) throws C0284h1 {
        C0275e1 c0275e1 = (C0275e1) zzhoVar;
        int iF = F(bArr, i, n02);
        int i3 = n02.f2046a + iF;
        while (iF < i3) {
            iF = F(bArr, iF, n02);
            c0275e1.c(n02.f2046a);
        }
        if (iF == i3) {
            return iF;
        }
        throw new C0284h1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static String B(int i, int i3, String str) {
        if (i < 0) {
            return e("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i3 >= 0) {
            return e("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(B2.b.c(i3, "negative size: "));
    }

    public static int D(int i, byte[] bArr, int i3, int i4, C0334y1 c0334y1, N0 n02) throws C0284h1 {
        if ((i >>> 3) == 0) {
            throw new C0284h1("Protocol message contained an invalid tag (zero).");
        }
        int i5 = i & 7;
        if (i5 == 0) {
            int I = I(bArr, i3, n02);
            c0334y1.c(i, Long.valueOf(n02.b));
            return I;
        }
        if (i5 == 1) {
            c0334y1.c(i, Long.valueOf(L(i3, bArr)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iF = F(bArr, i3, n02);
            int i6 = n02.f2046a;
            if (i6 < 0) {
                throw new C0284h1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i6 > bArr.length - iF) {
                throw new C0284h1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i6 == 0) {
                c0334y1.c(i, S0.b);
            } else {
                c0334y1.c(i, S0.e(bArr, iF, i6));
            }
            return iF + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw new C0284h1("Protocol message contained an invalid tag (zero).");
            }
            c0334y1.c(i, Integer.valueOf(m(i3, bArr)));
            return i3 + 4;
        }
        int i7 = (i & (-8)) | 4;
        C0334y1 c0334y1B = C0334y1.b();
        int i8 = n02.d + 1;
        n02.d = i8;
        if (i8 >= 100) {
            throw new C0284h1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int iF2 = F(bArr, i3, n02);
            int i10 = n02.f2046a;
            if (i10 == i7) {
                i9 = i10;
                i3 = iF2;
                break;
            }
            i3 = D(i10, bArr, iF2, i4, c0334y1B, n02);
            i9 = i10;
        }
        n02.d--;
        if (i3 > i4 || i9 != i7) {
            throw new C0284h1("Failed to parse the message.");
        }
        c0334y1.c(i, c0334y1B);
        return i3;
    }

    public static int F(byte[] bArr, int i, N0 n02) {
        int i3 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return G(b, bArr, i3, n02);
        }
        n02.f2046a = b;
        return i3;
    }

    public static int G(int i, byte[] bArr, int i3, N0 n02) {
        byte b = bArr[i3];
        int i4 = i3 + 1;
        int i5 = i & 127;
        if (b >= 0) {
            n02.f2046a = i5 | (b << 7);
            return i4;
        }
        int i6 = i5 | ((b & 127) << 7);
        int i7 = i3 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            n02.f2046a = i6 | (b2 << 14);
            return i7;
        }
        int i8 = i6 | ((b2 & 127) << 14);
        int i9 = i3 + 3;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            n02.f2046a = i8 | (b6 << 21);
            return i9;
        }
        int i10 = i8 | ((b6 & 127) << 21);
        int i11 = i3 + 4;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            n02.f2046a = i10 | (b7 << 28);
            return i11;
        }
        int i12 = i10 | ((b7 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                n02.f2046a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int H(int i, byte[] bArr, int i3, int i4, zzho zzhoVar, N0 n02) {
        C0275e1 c0275e1 = (C0275e1) zzhoVar;
        int iF = F(bArr, i3, n02);
        c0275e1.c(n02.f2046a);
        while (iF < i4) {
            int iF2 = F(bArr, iF, n02);
            if (i != n02.f2046a) {
                break;
            }
            iF = F(bArr, iF2, n02);
            c0275e1.c(n02.f2046a);
        }
        return iF;
    }

    public static int I(byte[] bArr, int i, N0 n02) {
        long j6 = bArr[i];
        int i3 = i + 1;
        if (j6 >= 0) {
            n02.b = j6;
            return i3;
        }
        int i4 = i + 2;
        byte b = bArr[i3];
        long j7 = (j6 & 127) | (((long) (b & 127)) << 7);
        int i5 = 7;
        while (b < 0) {
            int i6 = i4 + 1;
            byte b2 = bArr[i4];
            i5 += 7;
            j7 |= ((long) (b2 & 127)) << i5;
            b = b2;
            i4 = i6;
        }
        n02.b = j7;
        return i4;
    }

    public static int J(Object obj, zzix zzixVar, byte[] bArr, int i, int i3, int i4, N0 n02) throws C0284h1 {
        C0308p1 c0308p1 = (C0308p1) zzixVar;
        int i5 = n02.d + 1;
        n02.d = i5;
        if (i5 >= 100) {
            throw new C0284h1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iK = c0308p1.k(obj, bArr, i, i3, i4, n02);
        n02.d--;
        n02.c = obj;
        return iK;
    }

    public static int K(Object obj, zzix zzixVar, byte[] bArr, int i, int i3, N0 n02) throws C0284h1 {
        int iG = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            iG = G(i4, bArr, iG, n02);
            i4 = n02.f2046a;
        }
        int i5 = iG;
        if (i4 < 0 || i4 > i3 - i5) {
            throw new C0284h1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = n02.d + 1;
        n02.d = i6;
        if (i6 >= 100) {
            throw new C0284h1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i7 = i5 + i4;
        zzixVar.zzh(obj, bArr, i5, i7, n02);
        n02.d--;
        n02.c = obj;
        return i7;
    }

    public static long L(int i, byte[] bArr) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public static int a(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static int b(byte[] bArr, int i, N0 n02) throws C0284h1 {
        int iF = F(bArr, i, n02);
        int i3 = n02.f2046a;
        if (i3 < 0) {
            throw new C0284h1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 > bArr.length - iF) {
            throw new C0284h1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i3 == 0) {
            n02.c = S0.b;
            return iF;
        }
        n02.c = S0.e(bArr, iF, i3);
        return iF + i3;
    }

    public static String d(S0 s02) {
        StringBuilder sb = new StringBuilder(s02.c());
        for (int i = 0; i < s02.c(); i++) {
            byte bA = s02.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String e(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i = 0;
        int i3 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e) {
                    String strF = B2.b.f(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strF), (Throwable) e);
                    string = "<" + strF + " threw " + e.getClass().getName() + ">";
                }
            }
            objArr[i3] = string;
            i3++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i4 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i4)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i4, iIndexOf);
            sb.append(objArr[i]);
            i++;
            i4 = iIndexOf + 2;
        }
        sb.append((CharSequence) str, i4, str.length());
        if (i < length2) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i5 = i + 1; i5 < objArr.length; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void f(int i, int i3) {
        String strE;
        if (i < 0 || i >= i3) {
            if (i < 0) {
                strE = e("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i3 < 0) {
                    throw new IllegalArgumentException(B2.b.c(i3, "negative size: "));
                }
                strE = e("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strE);
        }
    }

    public static void g(int i, String str) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static boolean i(Comparator comparator, Collection collection) {
        Comparator comparator2;
        comparator.getClass();
        collection.getClass();
        if (collection instanceof SortedSet) {
            comparator2 = ((SortedSet) collection).comparator();
            if (comparator2 == null) {
                comparator2 = K.b;
            }
        } else {
            if (!(collection instanceof zzdu)) {
                return false;
            }
            comparator2 = ((zzdu) collection).comparator();
        }
        return comparator.equals(comparator2);
    }

    public static /* synthetic */ boolean j(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AbstractC0286i0 abstractC0286i0, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(abstractC0286i0, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(abstractC0286i0) != obj && atomicReferenceFieldUpdater.get(abstractC0286i0) != obj) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean k(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, j2 j2Var, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(j2Var, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(j2Var) != obj && atomicReferenceFieldUpdater.get(j2Var) != obj) {
                return false;
            }
        }
        return true;
    }

    public static int l(int i) {
        if (i == 90) {
            return 91;
        }
        if (i == 91) {
            return 92;
        }
        if (i == 93) {
            return 94;
        }
        if (i == 94) {
            return 95;
        }
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            case 14:
                return 15;
            case 15:
                return 16;
            case 16:
                return 17;
            case 17:
                return 18;
            case 18:
                return 19;
            case 19:
                return 20;
            case 20:
                return 21;
            case 21:
                return 22;
            case 22:
                return 23;
            case 23:
                return 24;
            case 24:
                return 25;
            case 25:
                return 26;
            case 26:
                return 27;
            case 27:
                return 28;
            case 28:
                return 29;
            case 29:
                return 30;
            case 30:
                return 31;
            case 31:
                return 32;
            case 32:
                return 33;
            case 33:
                return 34;
            case 34:
                return 35;
            case 35:
                return 36;
            case 36:
                return 37;
            case 37:
                return 38;
            case 38:
                return 39;
            case 39:
                return 40;
            case 40:
                return 41;
            case 41:
                return 42;
            case 42:
                return 43;
            case 43:
                return 44;
            case 44:
                return 45;
            case 45:
                return 46;
            case 46:
                return 47;
            case 47:
                return 48;
            case 48:
                return 49;
            case 49:
                return 50;
            case 50:
                return 51;
            case 51:
                return 52;
            case 52:
                return 53;
            case 53:
                return 54;
            case 54:
                return 55;
            case 55:
                return 56;
            case 56:
                return 57;
            case 57:
                return 58;
            case 58:
                return 59;
            case 59:
                return 60;
            case 60:
                return 61;
            case 61:
                return 62;
            case 62:
                return 63;
            case 63:
                return 64;
            case 64:
                return 65;
            case 65:
                return 66;
            case 66:
                return 67;
            case 67:
                return 68;
            case 68:
                return 69;
            case 69:
                return 70;
            case 70:
                return 71;
            case 71:
                return 72;
            case 72:
                return 73;
            case 73:
                return 74;
            case 74:
                return 75;
            case 75:
                return 76;
            case 76:
                return 77;
            case 77:
                return 78;
            case 78:
                return 79;
            case 79:
                return 80;
            default:
                switch (i) {
                    case 96:
                        return 97;
                    case 97:
                        return 98;
                    case 98:
                        return 99;
                    case 99:
                        return 100;
                    case 100:
                        return 101;
                    case 101:
                        return 102;
                    case 102:
                        return 103;
                    case 103:
                        return 104;
                    case 104:
                        return 105;
                    case 105:
                        return 106;
                    case 106:
                        return 107;
                    case 107:
                        return 108;
                    case 108:
                        return 109;
                    case 109:
                        return 110;
                    case 110:
                        return 111;
                    case 111:
                        return 112;
                    case 112:
                        return 113;
                    case 113:
                        return 114;
                    case 114:
                        return 115;
                    case 115:
                        return 116;
                    case 116:
                        return 117;
                    case 117:
                        return 118;
                    case 118:
                        return 119;
                    case 119:
                        return 120;
                    case 120:
                        return 121;
                    case 121:
                        return 122;
                    default:
                        return 0;
                }
        }
    }

    public static int m(int i, byte[] bArr) {
        int i3 = bArr[i] & 255;
        int i4 = bArr[i + 1] & 255;
        int i5 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public static X0 o() {
        String str;
        ClassLoader classLoader = AbstractC0263a1.class.getClassLoader();
        if (X0.class.equals(X0.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!X0.class.getPackage().equals(AbstractC0263a1.class.getPackage())) {
                throw new IllegalArgumentException(X0.class.getName());
            }
            str = X0.class.getPackage().getName() + ".BlazeGenerated" + X0.class.getSimpleName() + "Loader";
        }
        try {
            try {
                try {
                    try {
                        try {
                            androidx.constraintlayout.core.motion.a.v(Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0]));
                            throw null;
                        } catch (InstantiationException e) {
                            throw new IllegalStateException(e);
                        }
                    } catch (IllegalAccessException e6) {
                        throw new IllegalStateException(e6);
                    }
                } catch (NoSuchMethodException e7) {
                    throw new IllegalStateException(e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(e8);
                }
            } catch (ClassNotFoundException unused) {
                Iterator it = Arrays.asList(new AbstractC0263a1[0]).iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    try {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    } catch (ServiceConfigurationError e9) {
                        Logger.getLogger(V0.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(X0.class.getSimpleName()), (Throwable) e9);
                    }
                }
                if (arrayList.size() == 1) {
                    return (X0) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (X0) X0.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException(e10);
                } catch (NoSuchMethodException e11) {
                    throw new IllegalStateException(e11);
                } catch (InvocationTargetException e12) {
                    throw new IllegalStateException(e12);
                }
            }
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    public static void p(int i, int i3) {
        if (i < 0 || i > i3) {
            throw new IndexOutOfBoundsException(B(i, i3, "index"));
        }
    }

    public static int v(zzix zzixVar, int i, byte[] bArr, int i3, int i4, zzho zzhoVar, N0 n02) throws C0284h1 {
        Object objZze = zzixVar.zze();
        zzix zzixVar2 = zzixVar;
        byte[] bArr2 = bArr;
        int i5 = i4;
        N0 n03 = n02;
        int iK = K(objZze, zzixVar2, bArr2, i3, i5, n03);
        zzixVar2.zzf(objZze);
        n03.c = objZze;
        zzhoVar.add(objZze);
        while (iK < i5) {
            N0 n04 = n03;
            int i6 = i5;
            int iF = F(bArr2, iK, n04);
            if (i != n04.f2046a) {
                break;
            }
            byte[] bArr3 = bArr2;
            zzix zzixVar3 = zzixVar2;
            Object objZze2 = zzixVar3.zze();
            iK = K(objZze2, zzixVar3, bArr3, iF, i6, n04);
            zzixVar2 = zzixVar3;
            bArr2 = bArr3;
            i5 = i6;
            n03 = n04;
            zzixVar2.zzf(objZze2);
            n03.c = objZze2;
            zzhoVar.add(objZze2);
        }
        return iK;
    }

    public static void w(int i, int i3, int i4) {
        if (i < 0 || i3 < i || i3 > i4) {
            throw new IndexOutOfBoundsException((i < 0 || i > i4) ? B(i, i4, "start index") : (i3 < 0 || i3 > i4) ? B(i3, i4, "end index") : e("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i)));
        }
    }

    public static boolean x(byte b) {
        return b > -65;
    }

    public abstract boolean C(AbstractC0286i0 abstractC0286i0, Object obj, Object obj2);

    public abstract boolean E(AbstractC0286i0 abstractC0286i0, C0283h0 c0283h0, C0283h0 c0283h02);

    public abstract C0265b0 c(AbstractC0286i0 abstractC0286i0);

    public abstract void h(i2 i2Var, i2 i2Var2);

    public abstract C0283h0 n(AbstractC0286i0 abstractC0286i0);

    public abstract void q(i2 i2Var, Thread thread);

    public abstract void r(C0283h0 c0283h0, C0283h0 c0283h02);

    public abstract boolean s(j2 j2Var, C0328w1 c0328w1, C0328w1 c0328w12);

    public abstract void t(C0283h0 c0283h0, Thread thread);

    public String toString() {
        switch (this.f2069a) {
            case 6:
                return ((ScheduledFutureC0321u0) this).b.toString();
            default:
                return super.toString();
        }
    }

    public abstract boolean u(j2 j2Var, Object obj, Object obj2);

    public abstract boolean y(AbstractC0286i0 abstractC0286i0, C0265b0 c0265b0, C0265b0 c0265b02);

    public abstract boolean z(j2 j2Var, i2 i2Var, i2 i2Var2);
}
