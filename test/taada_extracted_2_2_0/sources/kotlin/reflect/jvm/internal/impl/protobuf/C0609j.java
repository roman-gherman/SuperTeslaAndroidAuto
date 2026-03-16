package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0609j {
    public static final C0609j c = new C0609j(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f3869a = new A(16);
    public boolean b;

    public C0609j() {
    }

    public static int c(M m6, Object obj) {
        switch (m6.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                return 8;
            case 1:
                ((Float) obj).getClass();
                return 4;
            case 2:
                return C0606g.g(((Long) obj).longValue());
            case 3:
                return C0606g.g(((Long) obj).longValue());
            case 4:
                return C0606g.c(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                return 8;
            case 6:
                ((Integer) obj).getClass();
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                return 1;
            case 8:
                try {
                    byte[] bytes = ((String) obj).getBytes("UTF-8");
                    return C0606g.f(bytes.length) + bytes.length;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("UTF-8 not supported.", e);
                }
            case 9:
                return ((MessageLite) obj).getSerializedSize();
            case 10:
                return C0606g.e((MessageLite) obj);
            case 11:
                if (obj instanceof AbstractC0604e) {
                    AbstractC0604e abstractC0604e = (AbstractC0604e) obj;
                    return abstractC0604e.size() + C0606g.f(abstractC0604e.size());
                }
                byte[] bArr = (byte[]) obj;
                return C0606g.f(bArr.length) + bArr.length;
            case 12:
                return C0606g.f(((Integer) obj).intValue());
            case 13:
                return obj instanceof Internal$EnumLite ? C0606g.c(((Internal$EnumLite) obj).getNumber()) : C0606g.c(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                return 4;
            case 15:
                ((Long) obj).getClass();
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return C0606g.f((iIntValue >> 31) ^ (iIntValue << 1));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return C0606g.g((jLongValue >> 63) ^ (jLongValue << 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object obj) {
        int iH;
        int iC;
        M liteType = fieldSet$FieldDescriptorLite.getLiteType();
        int number = fieldSet$FieldDescriptorLite.getNumber();
        if (fieldSet$FieldDescriptorLite.isRepeated()) {
            int iC2 = 0;
            if (!fieldSet$FieldDescriptorLite.isPacked()) {
                for (Object obj2 : (List) obj) {
                    int iH2 = C0606g.h(number);
                    if (liteType == M.e) {
                        iH2 *= 2;
                    }
                    iC2 += c(liteType, obj2) + iH2;
                }
                return iC2;
            }
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iC2 += c(liteType, it.next());
            }
            iH = C0606g.h(number) + iC2;
            iC = C0606g.f(iC2);
        } else {
            iH = C0606g.h(number);
            if (liteType == M.e) {
                iH *= 2;
            }
            iC = c(liteType, obj);
        }
        return iC + iH;
    }

    public static boolean f(Map.Entry entry) {
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite) entry.getKey();
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() != N.MESSAGE) {
            return true;
        }
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            Object value = entry.getValue();
            if (value instanceof MessageLite) {
                return ((MessageLite) value).isInitialized();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!((MessageLite) it.next()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public static Object i(C0605f c0605f, M m6) {
        switch (m6.ordinal()) {
            case 0:
                return Double.valueOf(Double.longBitsToDouble(c0605f.j()));
            case 1:
                return Float.valueOf(Float.intBitsToFloat(c0605f.i()));
            case 2:
                return Long.valueOf(c0605f.l());
            case 3:
                return Long.valueOf(c0605f.l());
            case 4:
                return Integer.valueOf(c0605f.k());
            case 5:
                return Long.valueOf(c0605f.j());
            case 6:
                return Integer.valueOf(c0605f.i());
            case 7:
                return Boolean.valueOf(c0605f.l() != 0);
            case 8:
                int iK = c0605f.k();
                int i = c0605f.b;
                int i3 = c0605f.d;
                if (iK > i - i3 || iK <= 0) {
                    return iK == 0 ? "" : new String(c0605f.h(iK), "UTF-8");
                }
                String str = new String(c0605f.f3862a, i3, iK, "UTF-8");
                c0605f.d += iK;
                return str;
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return c0605f.e();
            case 12:
                return Integer.valueOf(c0605f.k());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(c0605f.i());
            case 15:
                return Long.valueOf(c0605f.j());
            case 16:
                int iK2 = c0605f.k();
                return Integer.valueOf((-(iK2 & 1)) ^ (iK2 >>> 1));
            case 17:
                long jL = c0605f.l();
                return Long.valueOf((-(jL & 1)) ^ (jL >>> 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void k(kotlin.reflect.jvm.internal.impl.protobuf.M r2, java.lang.Object r3) {
        /*
            r3.getClass()
            kotlin.reflect.jvm.internal.impl.protobuf.N r2 = r2.f3852a
            int r2 = r2.ordinal()
            r0 = 1
            r1 = 0
            switch(r2) {
                case 0: goto L36;
                case 1: goto L33;
                case 2: goto L30;
                case 3: goto L2d;
                case 4: goto L2a;
                case 5: goto L27;
                case 6: goto L1e;
                case 7: goto L12;
                case 8: goto Lf;
                default: goto Le;
            }
        Le:
            goto L38
        Lf:
            boolean r1 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            goto L38
        L12:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
            if (r2 == 0) goto L1b
            goto L1c
        L1b:
            r0 = r1
        L1c:
            r1 = r0
            goto L38
        L1e:
            boolean r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L1b
            goto L1c
        L27:
            boolean r1 = r3 instanceof java.lang.String
            goto L38
        L2a:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L38
        L2d:
            boolean r1 = r3 instanceof java.lang.Double
            goto L38
        L30:
            boolean r1 = r3 instanceof java.lang.Float
            goto L38
        L33:
            boolean r1 = r3 instanceof java.lang.Long
            goto L38
        L36:
            boolean r1 = r3 instanceof java.lang.Integer
        L38:
            if (r1 == 0) goto L3b
            return
        L3b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.C0609j.k(kotlin.reflect.jvm.internal.impl.protobuf.M, java.lang.Object):void");
    }

    public static void l(C0606g c0606g, M m6, Object obj) {
        switch (m6.ordinal()) {
            case 0:
                double dDoubleValue = ((Double) obj).doubleValue();
                c0606g.getClass();
                c0606g.u(Double.doubleToRawLongBits(dDoubleValue));
                break;
            case 1:
                float fFloatValue = ((Float) obj).floatValue();
                c0606g.getClass();
                c0606g.t(Float.floatToRawIntBits(fFloatValue));
                break;
            case 2:
                c0606g.w(((Long) obj).longValue());
                break;
            case 3:
                c0606g.w(((Long) obj).longValue());
                break;
            case 4:
                c0606g.n(((Integer) obj).intValue());
                break;
            case 5:
                c0606g.u(((Long) obj).longValue());
                break;
            case 6:
                c0606g.t(((Integer) obj).intValue());
                break;
            case 7:
                c0606g.q(((Boolean) obj).booleanValue() ? 1 : 0);
                break;
            case 8:
                c0606g.getClass();
                byte[] bytes = ((String) obj).getBytes("UTF-8");
                c0606g.v(bytes.length);
                c0606g.s(bytes);
                break;
            case 9:
                c0606g.getClass();
                ((MessageLite) obj).writeTo(c0606g);
                break;
            case 10:
                c0606g.p((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC0604e)) {
                    byte[] bArr = (byte[]) obj;
                    c0606g.getClass();
                    c0606g.v(bArr.length);
                    c0606g.s(bArr);
                } else {
                    AbstractC0604e abstractC0604e = (AbstractC0604e) obj;
                    c0606g.getClass();
                    c0606g.v(abstractC0604e.size());
                    c0606g.r(abstractC0604e);
                }
                break;
            case 12:
                c0606g.v(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof Internal$EnumLite)) {
                    c0606g.n(((Integer) obj).intValue());
                } else {
                    c0606g.n(((Internal$EnumLite) obj).getNumber());
                }
                break;
            case 14:
                c0606g.t(((Integer) obj).intValue());
                break;
            case 15:
                c0606g.u(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                c0606g.v((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                c0606g.w((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a(C0613n c0613n, Object obj) {
        List arrayList;
        if (!c0613n.c) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        k(c0613n.b, obj);
        A a6 = this.f3869a;
        Object obj2 = a6.get(c0613n);
        if (obj2 == null) {
            arrayList = new ArrayList();
            a6.put(c0613n, arrayList);
        } else {
            arrayList = (List) obj2;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C0609j clone() {
        A a6;
        C0609j c0609j = new C0609j();
        int i = 0;
        while (true) {
            a6 = this.f3869a;
            if (i >= a6.b.size()) {
                break;
            }
            Map.Entry entry = (Map.Entry) a6.b.get(i);
            c0609j.j((FieldSet$FieldDescriptorLite) entry.getKey(), entry.getValue());
            i++;
        }
        for (Map.Entry entry2 : a6.c()) {
            c0609j.j((FieldSet$FieldDescriptorLite) entry2.getKey(), entry2.getValue());
        }
        return c0609j;
    }

    public final boolean e() {
        int i = 0;
        while (true) {
            A a6 = this.f3869a;
            if (i >= a6.b.size()) {
                Iterator it = a6.c().iterator();
                while (it.hasNext()) {
                    if (!f((Map.Entry) it.next())) {
                    }
                }
                return true;
            }
            if (!f((Map.Entry) a6.b.get(i))) {
                break;
            }
            i++;
        }
        return false;
    }

    public final void g() {
        if (this.b) {
            return;
        }
        A a6 = this.f3869a;
        if (!a6.d) {
            for (int i = 0; i < a6.b.size(); i++) {
                Map.Entry entry = (Map.Entry) a6.b.get(i);
                if (((FieldSet$FieldDescriptorLite) entry.getKey()).isRepeated()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : a6.c()) {
                if (((FieldSet$FieldDescriptorLite) entry2.getKey()).isRepeated()) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        if (!a6.d) {
            a6.c = a6.c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(a6.c);
            a6.d = true;
        }
        this.b = true;
    }

    public final void h(Map.Entry entry) {
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        boolean zIsRepeated = fieldSet$FieldDescriptorLite.isRepeated();
        A a6 = this.f3869a;
        if (zIsRepeated) {
            Object arrayList = a6.get(fieldSet$FieldDescriptorLite);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            for (Object obj : (List) value) {
                List list = (List) arrayList;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    obj = bArr2;
                }
                list.add(obj);
            }
            a6.put(fieldSet$FieldDescriptorLite, arrayList);
            return;
        }
        if (fieldSet$FieldDescriptorLite.getLiteJavaType() != N.MESSAGE) {
            if (value instanceof byte[]) {
                byte[] bArr3 = (byte[]) value;
                byte[] bArr4 = new byte[bArr3.length];
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                value = bArr4;
            }
            a6.put(fieldSet$FieldDescriptorLite, value);
            return;
        }
        Object obj2 = a6.get(fieldSet$FieldDescriptorLite);
        if (obj2 != null) {
            a6.put(fieldSet$FieldDescriptorLite, fieldSet$FieldDescriptorLite.internalMergeFrom(((MessageLite) obj2).toBuilder(), (MessageLite) value).build());
            return;
        }
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        a6.put(fieldSet$FieldDescriptorLite, value);
    }

    public final void j(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, Object obj) {
        if (!fieldSet$FieldDescriptorLite.isRepeated()) {
            k(fieldSet$FieldDescriptorLite.getLiteType(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                k(fieldSet$FieldDescriptorLite.getLiteType(), it.next());
            }
            obj = arrayList;
        }
        this.f3869a.put(fieldSet$FieldDescriptorLite, obj);
    }

    public C0609j(int i) {
        g();
    }
}
