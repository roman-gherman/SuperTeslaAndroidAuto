package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0369i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0403z0 f2882a = new C0403z0();
    public static final A0 b = new A0();

    public static void a(byte b2, byte b6, byte b7, byte b8, char[] cArr, int i) throws V {
        if (!t(b6)) {
            if ((((b6 + 112) + (b2 << 28)) >> 30) == 0 && !t(b7) && !t(b8)) {
                int i3 = ((b2 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                cArr[i] = (char) ((i3 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i3 & 1023) + 56320);
                return;
            }
        }
        throw V.b();
    }

    public static void b(byte b2, byte b6, char[] cArr, int i) throws V {
        if (b2 < -62 || t(b6)) {
            throw V.b();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b6 & 63));
    }

    public static void c(byte b2, byte b6, byte b7, char[] cArr, int i) throws V {
        if (t(b6) || ((b2 == -32 && b6 < -96) || ((b2 == -19 && b6 >= -96) || t(b7)))) {
            throw V.b();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
    }

    public static int d(byte[] bArr, int i, C0367h c0367h) throws V {
        int iO = o(bArr, i, c0367h);
        int i3 = c0367h.f2880a;
        if (i3 < 0) {
            throw V.e();
        }
        if (i3 > bArr.length - iO) {
            throw V.g();
        }
        if (i3 == 0) {
            c0367h.c = AbstractC0381o.b;
            return iO;
        }
        c0367h.c = AbstractC0381o.c(bArr, iO, i3);
        return iO + i3;
    }

    public static int e(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static long f(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int g(Schema schema, int i, byte[] bArr, int i3, int i4, Internal$ProtobufList internal$ProtobufList, C0367h c0367h) throws V {
        Object objNewInstance = schema.newInstance();
        Schema schema2 = schema;
        byte[] bArr2 = bArr;
        int i5 = i4;
        C0367h c0367h2 = c0367h;
        int iV = v(objNewInstance, schema2, bArr2, i3, i5, c0367h2);
        schema2.makeImmutable(objNewInstance);
        c0367h2.c = objNewInstance;
        internal$ProtobufList.add(objNewInstance);
        while (iV < i5) {
            C0367h c0367h3 = c0367h2;
            int i6 = i5;
            int iO = o(bArr2, iV, c0367h3);
            if (i != c0367h3.f2880a) {
                break;
            }
            byte[] bArr3 = bArr2;
            Schema schema3 = schema2;
            Object objNewInstance2 = schema3.newInstance();
            iV = v(objNewInstance2, schema3, bArr3, iO, i6, c0367h3);
            schema2 = schema3;
            bArr2 = bArr3;
            i5 = i6;
            c0367h2 = c0367h3;
            schema2.makeImmutable(objNewInstance2);
            c0367h2.c = objNewInstance2;
            internal$ProtobufList.add(objNewInstance2);
        }
        return iV;
    }

    public static int h(byte[] bArr, int i, C0367h c0367h) throws V {
        int iO = o(bArr, i, c0367h);
        int i3 = c0367h.f2880a;
        if (i3 < 0) {
            throw V.e();
        }
        if (i3 == 0) {
            c0367h.c = "";
            return iO;
        }
        c0367h.c = new String(bArr, iO, i3, T.f2849a);
        return iO + i3;
    }

    public static int i(byte[] bArr, int i, C0367h c0367h) throws V {
        int iO = o(bArr, i, c0367h);
        int i3 = c0367h.f2880a;
        if (i3 < 0) {
            throw V.e();
        }
        if (i3 == 0) {
            c0367h.c = "";
            return iO;
        }
        c0367h.c = V0.f2851a.k(bArr, iO, i3);
        return iO + i3;
    }

    public static int j(int i, byte[] bArr, int i3, int i4, J0 j02, C0367h c0367h) throws V {
        if ((i >>> 3) == 0) {
            throw V.a();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            int iQ = q(bArr, i3, c0367h);
            j02.d(i, Long.valueOf(c0367h.b));
            return iQ;
        }
        if (i5 == 1) {
            j02.d(i, Long.valueOf(f(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iO = o(bArr, i3, c0367h);
            int i6 = c0367h.f2880a;
            if (i6 < 0) {
                throw V.e();
            }
            if (i6 > bArr.length - iO) {
                throw V.g();
            }
            if (i6 == 0) {
                j02.d(i, AbstractC0381o.b);
            } else {
                j02.d(i, AbstractC0381o.c(bArr, iO, i6));
            }
            return iO + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw V.a();
            }
            j02.d(i, Integer.valueOf(e(bArr, i3)));
            return i3 + 4;
        }
        J0 j0C = J0.c();
        int i7 = (i & (-8)) | 4;
        int i8 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int iO2 = o(bArr, i3, c0367h);
            i8 = c0367h.f2880a;
            if (i8 == i7) {
                i3 = iO2;
                break;
            }
            i3 = j(i8, bArr, iO2, i4, j0C, c0367h);
        }
        if (i3 > i4 || i8 != i7) {
            throw V.f();
        }
        j02.d(i, j0C);
        return i3;
    }

    public static String l(ByteBuffer byteBuffer, int i, int i3) throws V {
        if ((i | i3 | ((byteBuffer.limit() - i) - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i3)));
        }
        int i4 = i + i3;
        char[] cArr = new char[i3];
        int i5 = 0;
        while (i < i4) {
            byte b2 = byteBuffer.get(i);
            if (b2 < 0) {
                break;
            }
            i++;
            cArr[i5] = (char) b2;
            i5++;
        }
        int i6 = i5;
        while (i < i4) {
            int i7 = i + 1;
            byte b6 = byteBuffer.get(i);
            if (b6 >= 0) {
                int i8 = i6 + 1;
                cArr[i6] = (char) b6;
                int i9 = i7;
                while (i9 < i4) {
                    byte b7 = byteBuffer.get(i9);
                    if (b7 < 0) {
                        break;
                    }
                    i9++;
                    cArr[i8] = (char) b7;
                    i8++;
                }
                i6 = i8;
                i = i9;
            } else if (b6 < -32) {
                if (i7 >= i4) {
                    throw V.b();
                }
                i += 2;
                b(b6, byteBuffer.get(i7), cArr, i6);
                i6++;
            } else if (b6 < -16) {
                if (i7 >= i4 - 1) {
                    throw V.b();
                }
                int i10 = i + 2;
                i += 3;
                c(b6, byteBuffer.get(i7), byteBuffer.get(i10), cArr, i6);
                i6++;
            } else {
                if (i7 >= i4 - 2) {
                    throw V.b();
                }
                byte b8 = byteBuffer.get(i7);
                int i11 = i + 3;
                byte b9 = byteBuffer.get(i + 2);
                i += 4;
                a(b6, b8, b9, byteBuffer.get(i11), cArr, i6);
                i6 += 2;
            }
        }
        return new String(cArr, 0, i6);
    }

    public static int n(int i, byte[] bArr, int i3, C0367h c0367h) {
        int i4 = i & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            c0367h.f2880a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & 127) << 7);
        int i7 = i3 + 2;
        byte b6 = bArr[i5];
        if (b6 >= 0) {
            c0367h.f2880a = i6 | (b6 << 14);
            return i7;
        }
        int i8 = i6 | ((b6 & 127) << 14);
        int i9 = i3 + 3;
        byte b7 = bArr[i7];
        if (b7 >= 0) {
            c0367h.f2880a = i8 | (b7 << 21);
            return i9;
        }
        int i10 = i8 | ((b7 & 127) << 21);
        int i11 = i3 + 4;
        byte b8 = bArr[i9];
        if (b8 >= 0) {
            c0367h.f2880a = i10 | (b8 << 28);
            return i11;
        }
        int i12 = i10 | ((b8 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                c0367h.f2880a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int o(byte[] bArr, int i, C0367h c0367h) {
        int i3 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return n(b2, bArr, i3, c0367h);
        }
        c0367h.f2880a = b2;
        return i3;
    }

    public static int p(int i, byte[] bArr, int i3, int i4, Internal$ProtobufList internal$ProtobufList, C0367h c0367h) {
        S s3 = (S) internal$ProtobufList;
        int iO = o(bArr, i3, c0367h);
        s3.addInt(c0367h.f2880a);
        while (iO < i4) {
            int iO2 = o(bArr, iO, c0367h);
            if (i != c0367h.f2880a) {
                break;
            }
            iO = o(bArr, iO2, c0367h);
            s3.addInt(c0367h.f2880a);
        }
        return iO;
    }

    public static int q(byte[] bArr, int i, C0367h c0367h) {
        int i3 = i + 1;
        long j6 = bArr[i];
        if (j6 >= 0) {
            c0367h.b = j6;
            return i3;
        }
        int i4 = i + 2;
        byte b2 = bArr[i3];
        long j7 = (j6 & 127) | (((long) (b2 & 127)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b6 = bArr[i4];
            i5 += 7;
            j7 |= ((long) (b6 & 127)) << i5;
            b2 = b6;
            i4 = i6;
        }
        c0367h.b = j7;
        return i4;
    }

    public static String s(AbstractC0381o abstractC0381o) {
        StringBuilder sb = new StringBuilder(abstractC0381o.size());
        for (int i = 0; i < abstractC0381o.size(); i++) {
            byte bA = abstractC0381o.a(i);
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

    public static boolean t(byte b2) {
        return b2 > -65;
    }

    public static int v(Object obj, Schema schema, byte[] bArr, int i, int i3, C0367h c0367h) throws V {
        int iN = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            iN = n(i4, bArr, iN, c0367h);
            i4 = c0367h.f2880a;
        }
        int i5 = iN;
        if (i4 < 0 || i4 > i3 - i5) {
            throw V.g();
        }
        int i6 = i5 + i4;
        schema.mergeFrom(obj, bArr, i5, i6, c0367h);
        c0367h.c = obj;
        return i6;
    }

    public static int x(int i, byte[] bArr, int i3, int i4, C0367h c0367h) throws V {
        if ((i >>> 3) == 0) {
            throw V.a();
        }
        int i5 = i & 7;
        if (i5 == 0) {
            return q(bArr, i3, c0367h);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return o(bArr, i3, c0367h) + c0367h.f2880a;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw V.a();
        }
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = o(bArr, i3, c0367h);
            i7 = c0367h.f2880a;
            if (i7 == i6) {
                break;
            }
            i3 = x(i7, bArr, i3, i4, c0367h);
        }
        if (i3 > i4 || i7 != i6) {
            throw V.f();
        }
        return i3;
    }

    public abstract String k(byte[] bArr, int i, int i3);

    public abstract String m(ByteBuffer byteBuffer, int i, int i3);

    public abstract int r(int i, int i3, String str, byte[] bArr);

    public boolean u(byte[] bArr, int i, int i3) {
        return w(bArr, i, i3) == 0;
    }

    public abstract int w(byte[] bArr, int i, int i3);

    public abstract void y(byte[] bArr, int i, int i3);
}
