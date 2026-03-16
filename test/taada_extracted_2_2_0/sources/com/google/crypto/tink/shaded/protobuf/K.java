package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0401y0 f2835a = new C0401y0(16);
    public boolean b;

    static {
        new K(0);
    }

    public K() {
    }

    public static int a(c1 c1Var, int i, Object obj) {
        int serializedSize;
        int I;
        int iJ = 1;
        int iG = AbstractC0398x.G(i);
        if (c1Var == c1.d) {
            iG *= 2;
        }
        switch (c1Var.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = AbstractC0398x.d;
                iJ = 8;
                return iJ + iG;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = AbstractC0398x.d;
                iJ = 4;
                return iJ + iG;
            case 2:
                iJ = AbstractC0398x.J(((Long) obj).longValue());
                return iJ + iG;
            case 3:
                iJ = AbstractC0398x.J(((Long) obj).longValue());
                return iJ + iG;
            case 4:
                iJ = AbstractC0398x.E(((Integer) obj).intValue());
                return iJ + iG;
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = AbstractC0398x.d;
                iJ = 8;
                return iJ + iG;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = AbstractC0398x.d;
                iJ = 4;
                return iJ + iG;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = AbstractC0398x.d;
                return iJ + iG;
            case 8:
                iJ = obj instanceof AbstractC0381o ? AbstractC0398x.A((AbstractC0381o) obj) : AbstractC0398x.F((String) obj);
                return iJ + iG;
            case 9:
                Logger logger6 = AbstractC0398x.d;
                iJ = ((MessageLite) obj).getSerializedSize();
                return iJ + iG;
            case 10:
                Logger logger7 = AbstractC0398x.d;
                serializedSize = ((MessageLite) obj).getSerializedSize();
                I = AbstractC0398x.I(serializedSize);
                iJ = I + serializedSize;
                return iJ + iG;
            case 11:
                if (obj instanceof AbstractC0381o) {
                    iJ = AbstractC0398x.A((AbstractC0381o) obj);
                    return iJ + iG;
                }
                Logger logger8 = AbstractC0398x.d;
                serializedSize = ((byte[]) obj).length;
                I = AbstractC0398x.I(serializedSize);
                iJ = I + serializedSize;
                return iJ + iG;
            case 12:
                iJ = AbstractC0398x.I(((Integer) obj).intValue());
                return iJ + iG;
            case 13:
                iJ = obj instanceof Internal$EnumLite ? AbstractC0398x.E(((Internal$EnumLite) obj).getNumber()) : AbstractC0398x.E(((Integer) obj).intValue());
                return iJ + iG;
            case 14:
                ((Integer) obj).getClass();
                Logger logger9 = AbstractC0398x.d;
                iJ = 4;
                return iJ + iG;
            case 15:
                ((Long) obj).getClass();
                Logger logger10 = AbstractC0398x.d;
                iJ = 8;
                return iJ + iG;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iJ = AbstractC0398x.I((iIntValue >> 31) ^ (iIntValue << 1));
                return iJ + iG;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iJ = AbstractC0398x.J((jLongValue >> 63) ^ (jLongValue << 1));
                return iJ + iG;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void d(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object obj) {
        fieldSet$FieldDescriptorLite.getLiteType();
        Charset charset = T.f2849a;
        obj.getClass();
        boolean z6 = true;
        switch (r0.f2867a) {
            case INT:
                z6 = obj instanceof Integer;
                break;
            case LONG:
                z6 = obj instanceof Long;
                break;
            case FLOAT:
                z6 = obj instanceof Float;
                break;
            case DOUBLE:
                z6 = obj instanceof Double;
                break;
            case BOOLEAN:
                z6 = obj instanceof Boolean;
                break;
            case STRING:
                z6 = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof AbstractC0381o) && !(obj instanceof byte[])) {
                    z6 = false;
                }
                break;
            case ENUM:
                if (!(obj instanceof Integer) && !(obj instanceof Internal$EnumLite)) {
                    z6 = false;
                }
                break;
            case MESSAGE:
                if (!(obj instanceof MessageLite)) {
                    z6 = false;
                }
                break;
            default:
                z6 = false;
                break;
        }
        if (!z6) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(fieldSet$FieldDescriptorLite.getNumber()), fieldSet$FieldDescriptorLite.getLiteType().f2867a, obj.getClass().getName()));
        }
    }

    public static void e(AbstractC0398x abstractC0398x, c1 c1Var, int i, Object obj) {
        if (c1Var == c1.d) {
            abstractC0398x.d0(i, 3);
            ((MessageLite) obj).writeTo(abstractC0398x);
            abstractC0398x.d0(i, 4);
        }
        abstractC0398x.d0(i, c1Var.b);
        switch (c1Var.ordinal()) {
            case 0:
                abstractC0398x.T(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                abstractC0398x.R(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                abstractC0398x.h0(((Long) obj).longValue());
                break;
            case 3:
                abstractC0398x.h0(((Long) obj).longValue());
                break;
            case 4:
                abstractC0398x.V(((Integer) obj).intValue());
                break;
            case 5:
                abstractC0398x.T(((Long) obj).longValue());
                break;
            case 6:
                abstractC0398x.R(((Integer) obj).intValue());
                break;
            case 7:
                abstractC0398x.L(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof AbstractC0381o)) {
                    abstractC0398x.c0((String) obj);
                } else {
                    abstractC0398x.P((AbstractC0381o) obj);
                }
                break;
            case 9:
                ((MessageLite) obj).writeTo(abstractC0398x);
                break;
            case 10:
                abstractC0398x.Y((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC0381o)) {
                    byte[] bArr = (byte[]) obj;
                    abstractC0398x.N(bArr.length, bArr);
                } else {
                    abstractC0398x.P((AbstractC0381o) obj);
                }
                break;
            case 12:
                abstractC0398x.f0(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof Internal$EnumLite)) {
                    abstractC0398x.V(((Integer) obj).intValue());
                } else {
                    abstractC0398x.V(((Internal$EnumLite) obj).getNumber());
                }
                break;
            case 14:
                abstractC0398x.R(((Integer) obj).intValue());
                break;
            case 15:
                abstractC0398x.T(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                abstractC0398x.f0((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                abstractC0398x.h0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void b() {
        C0401y0 c0401y0;
        if (this.b) {
            return;
        }
        int i = 0;
        while (true) {
            c0401y0 = this.f2835a;
            if (i >= c0401y0.b.size()) {
                break;
            }
            Map.Entry entryC = c0401y0.c(i);
            if (entryC.getValue() instanceof Q) {
                Q q = (Q) entryC.getValue();
                q.getClass();
                C0393u0 c0393u0 = C0393u0.c;
                c0393u0.getClass();
                c0393u0.a(q.getClass()).makeImmutable(q);
                q.k();
            }
            i++;
        }
        if (!c0401y0.d) {
            for (int i3 = 0; i3 < c0401y0.b.size(); i3++) {
                Map.Entry entryC2 = c0401y0.c(i3);
                if (((FieldSet$FieldDescriptorLite) entryC2.getKey()).isRepeated()) {
                    entryC2.setValue(Collections.unmodifiableList((List) entryC2.getValue()));
                }
            }
            for (Map.Entry entry : c0401y0.d()) {
                if (((FieldSet$FieldDescriptorLite) entry.getKey()).isRepeated()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        if (!c0401y0.d) {
            c0401y0.c = c0401y0.c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(c0401y0.c);
            c0401y0.f2929f = c0401y0.f2929f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(c0401y0.f2929f);
            c0401y0.d = true;
        }
        this.b = true;
    }

    public final void c(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object obj) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            d(fieldSet$FieldDescriptorLite, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d(fieldSet$FieldDescriptorLite, it.next());
            }
            obj = arrayList;
        }
        this.f2835a.put(fieldSet$FieldDescriptorLite, obj);
    }

    public final Object clone() {
        C0401y0 c0401y0;
        K k6 = new K();
        int i = 0;
        while (true) {
            c0401y0 = this.f2835a;
            if (i >= c0401y0.b.size()) {
                break;
            }
            Map.Entry entryC = c0401y0.c(i);
            k6.c((FieldSet$FieldDescriptorLite) entryC.getKey(), entryC.getValue());
            i++;
        }
        for (Map.Entry entry : c0401y0.d()) {
            k6.c((FieldSet$FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return k6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof K) {
            return this.f2835a.equals(((K) obj).f2835a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2835a.hashCode();
    }

    public K(int i) {
        b();
        b();
    }
}
