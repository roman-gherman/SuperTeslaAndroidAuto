package net.bytebuddy.jar.asm;

import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class TypePath {
    public static final int ARRAY_ELEMENT = 0;
    public static final int INNER_TYPE = 1;
    public static final int TYPE_ARGUMENT = 3;
    public static final int WILDCARD_BOUND = 2;
    private final byte[] typePathContainer;
    private final int typePathOffset;

    public TypePath(byte[] bArr, int i) {
        this.typePathContainer = bArr;
        this.typePathOffset = i;
    }

    public static TypePath fromString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        ByteVector byteVector = new ByteVector(length);
        byteVector.putByte(0);
        int i = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt == '[') {
                byteVector.put11(0, 0);
            } else if (cCharAt == '.') {
                byteVector.put11(1, 0);
            } else if (cCharAt == '*') {
                byteVector.put11(2, 0);
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    throw new IllegalArgumentException();
                }
                int i4 = cCharAt - '0';
                while (i3 < length) {
                    int i5 = i3 + 1;
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                        i4 = ((i4 * 10) + cCharAt2) - 48;
                        i3 = i5;
                    } else {
                        if (cCharAt2 != ';') {
                            throw new IllegalArgumentException();
                        }
                        i3 = i5;
                        byteVector.put11(3, i4);
                    }
                }
                byteVector.put11(3, i4);
            }
            i = i3;
        }
        byte[] bArr = byteVector.data;
        bArr[0] = (byte) (byteVector.length / 2);
        return new TypePath(bArr, 0);
    }

    public static void put(TypePath typePath, ByteVector byteVector) {
        if (typePath == null) {
            byteVector.putByte(0);
            return;
        }
        byte[] bArr = typePath.typePathContainer;
        int i = typePath.typePathOffset;
        byteVector.putByteArray(bArr, i, (bArr[i] * 2) + 1);
    }

    public int getLength() {
        return this.typePathContainer[this.typePathOffset];
    }

    public int getStep(int i) {
        return this.typePathContainer[(i * 2) + this.typePathOffset + 1];
    }

    public int getStepArgument(int i) {
        return this.typePathContainer[(i * 2) + this.typePathOffset + 2];
    }

    public String toString() {
        int length = getLength();
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            int step = getStep(i);
            if (step == 0) {
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            } else if (step == 1) {
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            } else if (step == 2) {
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
            } else {
                if (step != 3) {
                    throw new AssertionError();
                }
                sb.append(getStepArgument(i));
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
            }
        }
        return sb.toString();
    }
}
