package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

/* JADX INFO: loaded from: classes.dex */
public final class CstString extends TypedConstant {
    public static final CstString EMPTY_STRING = new CstString("");
    private final ByteArray bytes;
    private final String string;

    public CstString(String str) {
        if (str == null) {
            throw new NullPointerException("string == null");
        }
        this.string = str.intern();
        this.bytes = new ByteArray(stringToUtf8Bytes(str));
    }

    public static byte[] stringToUtf8Bytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[length * 3];
        int i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != 0 && cCharAt < 128) {
                bArr[i] = (byte) cCharAt;
                i++;
            } else if (cCharAt < 2048) {
                bArr[i] = (byte) (((cCharAt >> 6) & 31) | 192);
                bArr[i + 1] = (byte) ((cCharAt & '?') | 128);
                i += 2;
            } else {
                bArr[i] = (byte) (((cCharAt >> '\f') & 15) | 224);
                bArr[i + 1] = (byte) (((cCharAt >> 6) & 63) | 128);
                bArr[i + 2] = (byte) ((cCharAt & '?') | 128);
                i += 3;
            }
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    private static String throwBadUtf8(int i, int i3) {
        throw new IllegalArgumentException("bad utf-8 byte " + Hex.u1(i) + " at offset " + Hex.u4(i3));
    }

    public static String utf8BytesToString(ByteArray byteArray) {
        char c;
        int i;
        int size = byteArray.size();
        char[] cArr = new char[size];
        int i3 = 0;
        int i4 = 0;
        while (size > 0) {
            int unsignedByte = byteArray.getUnsignedByte(i4);
            switch (unsignedByte >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    size--;
                    if (unsignedByte == 0) {
                        return throwBadUtf8(unsignedByte, i4);
                    }
                    c = (char) unsignedByte;
                    i4++;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return throwBadUtf8(unsignedByte, i4);
                case 12:
                case 13:
                    size -= 2;
                    if (size < 0) {
                        return throwBadUtf8(unsignedByte, i4);
                    }
                    int i5 = i4 + 1;
                    int unsignedByte2 = byteArray.getUnsignedByte(i5);
                    if ((unsignedByte2 & 192) != 128) {
                        return throwBadUtf8(unsignedByte2, i5);
                    }
                    int i6 = ((unsignedByte & 31) << 6) | (unsignedByte2 & 63);
                    if (i6 != 0 && i6 < 128) {
                        return throwBadUtf8(unsignedByte2, i5);
                    }
                    c = (char) i6;
                    i4 += 2;
                    break;
                    break;
                case 14:
                    size -= 3;
                    if (size < 0) {
                        return throwBadUtf8(unsignedByte, i4);
                    }
                    int i7 = i4 + 1;
                    int unsignedByte3 = byteArray.getUnsignedByte(i7);
                    int i8 = unsignedByte3 & 192;
                    if (i8 != 128) {
                        return throwBadUtf8(unsignedByte3, i7);
                    }
                    int i9 = i4 + 2;
                    int unsignedByte4 = byteArray.getUnsignedByte(i9);
                    if (i8 == 128 && (i = ((unsignedByte & 15) << 12) | ((unsignedByte3 & 63) << 6) | (unsignedByte4 & 63)) >= 2048) {
                        c = (char) i;
                        i4 += 3;
                        break;
                    }
                    return throwBadUtf8(unsignedByte4, i9);
            }
            cArr[i3] = c;
            i3++;
        }
        return new String(cArr, 0, i3);
    }

    @Override // com.android.dx.rop.cst.Constant
    public int compareTo0(Constant constant) {
        return this.string.compareTo(((CstString) constant).string);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CstString) {
            return this.string.equals(((CstString) obj).string);
        }
        return false;
    }

    public ByteArray getBytes() {
        return this.bytes;
    }

    public String getString() {
        return this.string;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.STRING;
    }

    public int getUtf16Size() {
        return this.string.length();
    }

    public int getUtf8Size() {
        return this.bytes.size();
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    @Override // com.android.dx.rop.cst.Constant
    public boolean isCategory2() {
        return false;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        int length = this.string.length();
        StringBuilder sb = new StringBuilder((length * 3) / 2);
        int i = 0;
        while (i < length) {
            char cCharAt = this.string.charAt(i);
            if (cCharAt >= ' ' && cCharAt < 127) {
                if (cCharAt == '\'' || cCharAt == '\"' || cCharAt == '\\') {
                    sb.append('\\');
                }
                sb.append(cCharAt);
            } else if (cCharAt > 127) {
                sb.append("\\u");
                sb.append(Character.forDigit(cCharAt >> '\f', 16));
                sb.append(Character.forDigit((cCharAt >> '\b') & 15, 16));
                sb.append(Character.forDigit((cCharAt >> 4) & 15, 16));
                sb.append(Character.forDigit(cCharAt & 15, 16));
            } else if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt != '\r') {
                char cCharAt2 = i < length + (-1) ? this.string.charAt(i + 1) : (char) 0;
                boolean z6 = cCharAt2 >= '0' && cCharAt2 <= '7';
                sb.append('\\');
                for (int i3 = 6; i3 >= 0; i3 -= 3) {
                    char c = (char) (((cCharAt >> i3) & 7) + 48);
                    if (c != '0' || z6) {
                        sb.append(c);
                        z6 = true;
                    }
                }
                if (!z6) {
                    sb.append('0');
                }
            } else {
                sb.append("\\r");
            }
            i++;
        }
        return sb.toString();
    }

    public String toQuoted() {
        return "\"" + toHuman() + '\"';
    }

    public String toString() {
        return "string{\"" + toHuman() + "\"}";
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "utf8";
    }

    public String toQuoted(int i) {
        String str;
        String human = toHuman();
        if (human.length() <= i - 2) {
            str = "";
        } else {
            human = human.substring(0, i - 5);
            str = "...";
        }
        return "\"" + human + str + '\"';
    }

    public CstString(ByteArray byteArray) {
        if (byteArray != null) {
            this.bytes = byteArray;
            this.string = utf8BytesToString(byteArray).intern();
            return;
        }
        throw new NullPointerException("bytes == null");
    }
}
