package K2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    static {
        String property;
        try {
            property = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            property = null;
        }
        "true".equals(property);
    }

    public static byte[] a(String[] strArr) {
        if (strArr == null) {
            Object[] objArr = new Object[3];
            objArr[0] = "data";
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
            switch (7) {
                case 1:
                case 3:
                case 6:
                case 8:
                case 10:
                case 12:
                case 14:
                    break;
                case 2:
                    objArr[2] = "encode8to7";
                    break;
                case 4:
                    objArr[2] = "addModuloByte";
                    break;
                case 5:
                    objArr[2] = "splitBytesToStringArray";
                    break;
                case 7:
                    objArr[2] = "decodeBytes";
                    break;
                case 9:
                    objArr[2] = "dropMarker";
                    break;
                case 11:
                    objArr[2] = "combineStringArrayIntoBytes";
                    break;
                case 13:
                    objArr[2] = "decode7to8";
                    break;
                default:
                    objArr[2] = "encodeBytes";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char cCharAt = strArr[0].charAt(0);
            if (cCharAt == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                strArr2[0] = strArr2[0].substring(1);
                int length = 0;
                for (String str : strArr2) {
                    length += str.length();
                }
                byte[] bArr = new byte[length];
                int i = 0;
                for (String str2 : strArr2) {
                    int length2 = str2.length();
                    int i3 = 0;
                    while (i3 < length2) {
                        bArr[i] = (byte) str2.charAt(i3);
                        i3++;
                        i++;
                    }
                }
                return bArr;
            }
            if (cCharAt == 65535) {
                strArr = (String[]) strArr.clone();
                strArr[0] = strArr[0].substring(1);
            }
        }
        int length3 = 0;
        for (String str3 : strArr) {
            length3 += str3.length();
        }
        byte[] bArr2 = new byte[length3];
        int i4 = 0;
        for (String str4 : strArr) {
            int length4 = str4.length();
            int i5 = 0;
            while (i5 < length4) {
                bArr2[i4] = (byte) str4.charAt(i5);
                i5++;
                i4++;
            }
        }
        for (int i6 = 0; i6 < length3; i6++) {
            bArr2[i6] = (byte) ((bArr2[i6] + 127) & 127);
        }
        int i7 = (length3 * 7) / 8;
        byte[] bArr3 = new byte[i7];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = i8 + 1;
            int i12 = i9 + 1;
            bArr3[i10] = (byte) (((bArr2[i8] & 255) >>> i9) + ((bArr2[i11] & ((1 << i12) - 1)) << (7 - i9)));
            if (i9 == 6) {
                i8 += 2;
                i9 = 0;
            } else {
                i8 = i11;
                i9 = i12;
            }
        }
        return bArr3;
    }
}
