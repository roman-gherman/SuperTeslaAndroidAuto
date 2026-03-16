package c4;

import net.bytebuddy.agent.VirtualMachine;

/* JADX INFO: loaded from: classes2.dex */
public class k implements Cloneable {
    public static final short[] b = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, VirtualMachine.ForOpenJ9.Dispatcher.ForJnaPosixEnvironment.PosixLibrary.SEM_UNDO, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    public static final byte[] c = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f1799a;

    public k(int i) {
        this.f1799a = new long[i];
    }

    public static void a(int i, int i3, int i4, long[] jArr, long[] jArr2) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i + i5;
            jArr[i6] = jArr[i6] ^ jArr2[i3 + i5];
        }
    }

    public static long c(long[] jArr, int i, long[] jArr2, int i3, int i4, int i5) {
        int i6 = 64 - i5;
        long j6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            long j7 = jArr2[i3 + i7];
            int i8 = i + i7;
            jArr[i8] = (j6 | (j7 << i5)) ^ jArr[i8];
            j6 = j7 >>> i6;
        }
        return j6;
    }

    public static int d(long j6) {
        int i;
        int i3 = 32;
        int i4 = (int) (j6 >>> 32);
        if (i4 == 0) {
            i4 = (int) j6;
            i3 = 0;
        }
        int i5 = i4 >>> 16;
        byte[] bArr = c;
        if (i5 == 0) {
            int i6 = i4 >>> 8;
            i = i6 == 0 ? bArr[i4] : bArr[i6] + 8;
        } else {
            int i7 = i4 >>> 24;
            i = i7 == 0 ? bArr[i5] + 16 : bArr[i7] + 24;
        }
        return i3 + i;
    }

    public static void g(long[] jArr, int i) {
        int i3 = i >>> 6;
        jArr[i3] = (1 << (i & 63)) ^ jArr[i3];
    }

    public static void h(int i, int i3, int i4, long[] jArr, long[] jArr2) {
        int i5 = i4 >>> 6;
        int i6 = i4 & 63;
        int i7 = i3;
        if (i6 == 0) {
            a(i5, i, i7, jArr, jArr2);
            return;
        }
        int i8 = i5 + 1;
        int i9 = 64 - i6;
        int i10 = 64 - i9;
        long j6 = 0;
        while (true) {
            i7--;
            if (i7 < 0) {
                jArr[i5] = jArr[i5] ^ j6;
                return;
            }
            long j7 = jArr2[i + i7];
            int i11 = i8 + i7;
            jArr[i11] = (j6 | (j7 >>> i9)) ^ jArr[i11];
            j6 = j7 << i10;
        }
    }

    public static void i(long[] jArr, int i, long j6) {
        int i3 = i >>> 6;
        int i4 = i & 63;
        if (i4 == 0) {
            jArr[i3] = jArr[i3] ^ j6;
            return;
        }
        jArr[i3] = jArr[i3] ^ (j6 << i4);
        long j7 = j6 >>> (64 - i4);
        if (j7 != 0) {
            int i5 = i3 + 1;
            jArr[i5] = j7 ^ jArr[i5];
        }
    }

    public static long k(int i) {
        short[] sArr = b;
        int i3 = sArr[i & 255] | (sArr[(i >>> 8) & 255] << 16);
        return (((long) i3) & 4294967295L) | ((((long) ((sArr[i >>> 24] << 16) | sArr[(i >>> 16) & 255])) & 4294967295L) << 32);
    }

    public static int l(long[] jArr, int i, int i3, int[] iArr) {
        int i4 = (i3 + 63) >>> 6;
        if (i < i4) {
            return i;
        }
        int i5 = i << 6;
        int iMin = Math.min(i5, (i3 << 1) - 1);
        int i6 = i5 - iMin;
        while (i6 >= 64) {
            i--;
            i6 -= 64;
        }
        int length = iArr.length;
        int i7 = iArr[length - 1];
        int i8 = length > 1 ? iArr[length - 2] : 0;
        int iMax = Math.max(i3, i7 + 64);
        int iMin2 = (Math.min(iMin - iMax, i3 - i8) + i6) >> 6;
        if (iMin2 > 1) {
            int i9 = i - iMin2;
            iMin = i9 << 6;
            int i10 = iMin - i3;
            int length2 = iArr.length;
            while (true) {
                length2--;
                if (length2 < 0) {
                    break;
                }
                h(i9, i - i9, iArr[length2] + i10, jArr, jArr);
            }
            h(i9, i - i9, i10, jArr, jArr);
            while (i > i9) {
                i--;
                jArr[i] = 0;
            }
        }
        if (iMin > iMax) {
            int i11 = iMax >>> 6;
            while (true) {
                i--;
                if (i <= i11) {
                    break;
                }
                long j6 = jArr[i];
                if (j6 != 0) {
                    jArr[i] = 0;
                    int i12 = (i << 6) - i3;
                    int length3 = iArr.length;
                    while (true) {
                        length3--;
                        if (length3 < 0) {
                            break;
                        }
                        i(jArr, iArr[length3] + i12, j6);
                    }
                    i(jArr, i12, j6);
                }
            }
            int i13 = iMax & 63;
            long j7 = jArr[i11];
            long j8 = j7 >>> i13;
            if (j8 != 0) {
                jArr[i11] = j7 ^ (j8 << i13);
                int i14 = iMax - i3;
                int length4 = iArr.length;
                while (true) {
                    length4--;
                    if (length4 < 0) {
                        break;
                    }
                    i(jArr, iArr[length4] + i14, j8);
                }
                i(jArr, i14, j8);
            }
        } else {
            iMax = iMin;
        }
        if (iMax > i3) {
            while (true) {
                iMax--;
                if (iMax < i3) {
                    break;
                }
                if (((1 << (iMax & 63)) & jArr[iMax >>> 6]) != 0) {
                    g(jArr, iMax);
                    int i15 = iMax - i3;
                    int length5 = iArr.length;
                    while (true) {
                        length5--;
                        if (length5 < 0) {
                            break;
                        }
                        g(jArr, iArr[length5] + i15);
                    }
                    g(jArr, i15);
                }
            }
        }
        return i4;
    }

    public static void m(long[] jArr, int i, long[] jArr2, int i3, int i4, int i5) {
        int i6 = 64 - i5;
        long j6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            long j7 = jArr[i + i7];
            jArr2[i3 + i7] = j6 | (j7 << i5);
            j6 = j7 >>> i6;
        }
    }

    public final void b(k kVar, int i, int i3) {
        int i4 = (i + 63) >>> 6;
        int i5 = i3 >>> 6;
        int i6 = i3 & 63;
        if (i6 == 0) {
            a(i5, 0, i4, this.f1799a, kVar.f1799a);
            return;
        }
        long jC = c(this.f1799a, i5, kVar.f1799a, 0, i4, i6);
        if (jC != 0) {
            long[] jArr = this.f1799a;
            int i7 = i4 + i5;
            jArr[i7] = jC ^ jArr[i7];
        }
    }

    public final Object clone() {
        long[] jArr = this.f1799a;
        long[] jArr2 = jArr == null ? null : (long[]) jArr.clone();
        k kVar = new k();
        kVar.f1799a = jArr2;
        return kVar;
    }

    public final int e() {
        int length = this.f1799a.length;
        while (length != 0) {
            length--;
            long j6 = this.f1799a[length];
            if (j6 != 0) {
                return d(j6) + (length << 6);
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        int iJ = j();
        if (kVar.j() != iJ) {
            return false;
        }
        for (int i = 0; i < iJ; i++) {
            if (this.f1799a[i] != kVar.f1799a[i]) {
                return false;
            }
        }
        return true;
    }

    public final int f(int i) {
        int i3 = (i + 62) >>> 6;
        while (i3 != 0) {
            i3--;
            long j6 = this.f1799a[i3];
            if (j6 != 0) {
                return d(j6) + (i3 << 6);
            }
        }
        return 0;
    }

    public final int hashCode() {
        int iJ = j();
        int i = 1;
        for (int i3 = 0; i3 < iJ; i3++) {
            long j6 = this.f1799a[i3];
            i = (((i * 31) ^ ((int) j6)) * 31) ^ ((int) (j6 >>> 32));
        }
        return i;
    }

    public final int j() {
        long[] jArr = this.f1799a;
        int iMin = Math.min(jArr.length, jArr.length);
        if (iMin >= 1) {
            if (jArr[0] != 0) {
                while (true) {
                    int i = iMin - 1;
                    if (jArr[i] != 0) {
                        return iMin;
                    }
                    iMin = i;
                }
            } else {
                while (true) {
                    int i3 = iMin - 1;
                    if (jArr[i3] != 0) {
                        return iMin;
                    }
                    if (i3 <= 0) {
                        break;
                    }
                    iMin = i3;
                }
            }
        }
        return 0;
    }

    public final String toString() {
        int iJ = j();
        if (iJ == 0) {
            return "0";
        }
        int i = iJ - 1;
        StringBuffer stringBuffer = new StringBuffer(Long.toBinaryString(this.f1799a[i]));
        while (true) {
            i--;
            if (i < 0) {
                return stringBuffer.toString();
            }
            String binaryString = Long.toBinaryString(this.f1799a[i]);
            int length = binaryString.length();
            if (length < 64) {
                stringBuffer.append("0000000000000000000000000000000000000000000000000000000000000000".substring(length));
            }
            stringBuffer.append(binaryString);
        }
    }

    public k(long[] jArr, int i) {
        if (i == jArr.length) {
            this.f1799a = jArr;
            return;
        }
        long[] jArr2 = new long[i];
        this.f1799a = jArr2;
        System.arraycopy(jArr, 0, jArr2, 0, i);
    }
}
