package com.google.protobuf;

import fr.sd.taada.proto.KeyCode;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b, byte b2, byte b6, byte b7, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b2)) {
                if ((((b2 + 112) + (b << 28)) >> 30) == 0 && !isNotTrailingByte(b6) && !isNotTrailingByte(b7)) {
                    int iTrailingByteValue = ((b & 7) << 18) | (trailingByteValue(b2) << 12) | (trailingByteValue(b6) << 6) | trailingByteValue(b7);
                    cArr[i] = highSurrogate(iTrailingByteValue);
                    cArr[i + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b, byte b2, byte b6, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || isNotTrailingByte(b6)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & 15) << 12) | (trailingByteValue(b2) << 6) | trailingByteValue(b6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b, byte b2, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b < -62 || isNotTrailingByte(b2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & 31) << 6) | trailingByteValue(b2));
        }

        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & 1023) + 56320);
        }

        private static int trailingByteValue(byte b) {
            return b & 63;
        }
    }

    public static abstract class Processor {
        public final String decodeUtf8(ByteBuffer byteBuffer, int i, int i3) {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i3);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i, i3) : decodeUtf8Default(byteBuffer, i, i3);
        }

        public abstract String decodeUtf8(byte[] bArr, int i, int i3);

        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i3) throws InvalidProtocolBufferException {
            if ((i | i3 | ((byteBuffer.limit() - i) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i3)));
            }
            int i4 = i + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i < i4) {
                byte b = byteBuffer.get(i);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b2 = byteBuffer.get(i);
                if (DecodeUtil.isOneByte(b2)) {
                    int i8 = i6 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i6);
                    int i9 = i7;
                    while (i9 < i4) {
                        byte b6 = byteBuffer.get(i9);
                        if (!DecodeUtil.isOneByte(b6)) {
                            break;
                        }
                        i9++;
                        DecodeUtil.handleOneByte(b6, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    i = i9;
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b2, byteBuffer.get(i7), cArr, i6);
                    i6++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i10 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b2, byteBuffer.get(i7), byteBuffer.get(i10), cArr, i6);
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b7 = byteBuffer.get(i7);
                    int i11 = i + 3;
                    byte b8 = byteBuffer.get(i + 2);
                    i += 4;
                    DecodeUtil.handleFourBytes(b2, b7, b8, byteBuffer.get(i11), cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i3);

        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i3);

        public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        public final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i;
            int length = charSequence.length();
            int iPosition = byteBuffer.position();
            int i3 = 0;
            while (i3 < length) {
                try {
                    char cCharAt = charSequence.charAt(i3);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i3, (byte) cCharAt);
                    i3++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (Math.max(i3, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                }
            }
            if (i3 == length) {
                byteBuffer.position(iPosition + i3);
                return;
            }
            iPosition += i3;
            while (i3 < length) {
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt2 < 128) {
                    byteBuffer.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i4 = iPosition + 1;
                    try {
                        byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        byteBuffer.put(i4, (byte) ((cCharAt2 & '?') | 128));
                        iPosition = i4;
                    } catch (IndexOutOfBoundsException unused2) {
                        iPosition = i4;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (Math.max(i3, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                    }
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i5 = i3 + 1;
                        if (i5 != length) {
                            try {
                                char cCharAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i6 = iPosition + 1;
                                    try {
                                        byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE));
                                        i = iPosition + 2;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        iPosition = i6;
                                        i3 = i5;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (Math.max(i3, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                                    }
                                    try {
                                        byteBuffer.put(i6, (byte) (((codePoint >>> 12) & 63) | 128));
                                        iPosition += 3;
                                        byteBuffer.put(i, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                        i3 = i5;
                                    } catch (IndexOutOfBoundsException unused4) {
                                        i3 = i5;
                                        iPosition = i;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (Math.max(i3, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                                    }
                                } else {
                                    i3 = i5;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new UnpairedSurrogateException(i3, length);
                    }
                    int i7 = iPosition + 1;
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                    iPosition += 2;
                    byteBuffer.put(i7, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
                }
                i3++;
                iPosition++;
            }
            byteBuffer.position(iPosition);
        }

        public abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        public final boolean isValidUtf8(byte[] bArr, int i, int i3) {
            return partialIsValidUtf8(0, bArr, i, i3) == 0;
        }

        public final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i3, int i4) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? partialIsValidUtf8Direct(i, byteBuffer, i3, i4) : partialIsValidUtf8Default(i, byteBuffer, i3, i4);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return partialIsValidUtf8(i, byteBuffer.array(), i3 + iArrayOffset, iArrayOffset + i4);
        }

        public abstract int partialIsValidUtf8(int i, byte[] bArr, int i3, int i4);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = com.google.protobuf.Utf8.access$000(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = com.google.protobuf.Utf8.access$000(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = com.google.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i3, int i4);

        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i3) {
            return partialIsValidUtf8(0, byteBuffer, i, i3) == 0;
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i3) {
            int iEstimateConsecutiveAscii = i + Utf8.estimateConsecutiveAscii(byteBuffer, i, i3);
            while (iEstimateConsecutiveAscii < i3) {
                int i4 = iEstimateConsecutiveAscii + 1;
                byte b = byteBuffer.get(iEstimateConsecutiveAscii);
                if (b >= 0) {
                    iEstimateConsecutiveAscii = i4;
                } else if (b < -32) {
                    if (i4 >= i3) {
                        return b;
                    }
                    if (b < -62 || byteBuffer.get(i4) > -65) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 2;
                } else {
                    if (b >= -16) {
                        if (i4 >= i3 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b, i4, i3 - i4);
                        }
                        int i5 = iEstimateConsecutiveAscii + 2;
                        byte b2 = byteBuffer.get(i4);
                        if (b2 <= -65) {
                            if ((((b2 + 112) + (b << 28)) >> 30) == 0) {
                                int i6 = iEstimateConsecutiveAscii + 3;
                                if (byteBuffer.get(i5) <= -65) {
                                    iEstimateConsecutiveAscii += 4;
                                    if (byteBuffer.get(i6) > -65) {
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    if (i4 >= i3 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b, i4, i3 - i4);
                    }
                    int i7 = iEstimateConsecutiveAscii + 2;
                    byte b6 = byteBuffer.get(i4);
                    if (b6 > -65 || ((b == -32 && b6 < -96) || ((b == -19 && b6 >= -96) || byteBuffer.get(i7) > -65))) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i3) {
            super(androidx.constraintlayout.core.motion.a.n("Unpaired surrogate at index ", i, " of ", i3));
        }
    }

    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j6, int i) {
            int i3 = 0;
            if (i < 16) {
                return 0;
            }
            while (i3 < i) {
                long j7 = 1 + j6;
                if (UnsafeUtil.getByte(bArr, j6) < 0) {
                    return i3;
                }
                i3++;
                j6 = j7;
            }
            return i;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j6, int i3) {
            if (i3 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i3 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j6));
            }
            if (i3 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j6), UnsafeUtil.getByte(bArr, j6 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i3) throws InvalidProtocolBufferException {
            if ((i | i3 | ((bArr.length - i) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i3)));
            }
            int i4 = i + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i < i4) {
                byte b = UnsafeUtil.getByte(bArr, i);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b2 = UnsafeUtil.getByte(bArr, i);
                if (DecodeUtil.isOneByte(b2)) {
                    int i8 = i6 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i6);
                    while (i7 < i4) {
                        byte b6 = UnsafeUtil.getByte(bArr, i7);
                        if (!DecodeUtil.isOneByte(b6)) {
                            break;
                        }
                        i7++;
                        DecodeUtil.handleOneByte(b6, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    i = i7;
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(bArr, i7), cArr, i6);
                    i6++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i9 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(bArr, i7), UnsafeUtil.getByte(bArr, i9), cArr, i6);
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b7 = UnsafeUtil.getByte(bArr, i7);
                    int i10 = i + 3;
                    byte b8 = UnsafeUtil.getByte(bArr, i + 2);
                    i += 4;
                    DecodeUtil.handleFourBytes(b2, b7, b8, UnsafeUtil.getByte(bArr, i10), cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i3) throws InvalidProtocolBufferException {
            if ((i | i3 | ((byteBuffer.limit() - i) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i3)));
            }
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i);
            long j6 = ((long) i3) + jAddressOffset;
            char[] cArr = new char[i3];
            int i4 = 0;
            while (jAddressOffset < j6) {
                byte b = UnsafeUtil.getByte(jAddressOffset);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                jAddressOffset++;
                DecodeUtil.handleOneByte(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (jAddressOffset < j6) {
                long j7 = jAddressOffset + 1;
                byte b2 = UnsafeUtil.getByte(jAddressOffset);
                if (DecodeUtil.isOneByte(b2)) {
                    int i6 = i5 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i5);
                    long j8 = j7;
                    while (j8 < j6) {
                        byte b6 = UnsafeUtil.getByte(j8);
                        if (!DecodeUtil.isOneByte(b6)) {
                            break;
                        }
                        j8++;
                        DecodeUtil.handleOneByte(b6, cArr, i6);
                        i6++;
                    }
                    i5 = i6;
                    jAddressOffset = j8;
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (j7 >= j6) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    jAddressOffset += 2;
                    DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(j7), cArr, i5);
                    i5++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (j7 >= j6 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j9 = 2 + jAddressOffset;
                    jAddressOffset += 3;
                    DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(j7), UnsafeUtil.getByte(j9), cArr, i5);
                    i5++;
                } else {
                    if (j7 >= j6 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b7 = UnsafeUtil.getByte(j7);
                    long j10 = jAddressOffset + 3;
                    byte b8 = UnsafeUtil.getByte(2 + jAddressOffset);
                    jAddressOffset += 4;
                    DecodeUtil.handleFourBytes(b2, b7, b8, UnsafeUtil.getByte(j10), cArr, i5);
                    i5 += 2;
                }
            }
            return new String(cArr, 0, i5);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i3) {
            long j6;
            long j7;
            long j8;
            int i4;
            char cCharAt;
            long j9 = i;
            long j10 = ((long) i3) + j9;
            int length = charSequence.length();
            if (length > i3 || bArr.length - i3 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i3));
            }
            int i5 = 0;
            while (true) {
                j6 = 1;
                if (i5 >= length || (cCharAt = charSequence.charAt(i5)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j9, (byte) cCharAt);
                i5++;
                j9 = 1 + j9;
            }
            if (i5 == length) {
                return (int) j9;
            }
            while (i5 < length) {
                char cCharAt2 = charSequence.charAt(i5);
                if (cCharAt2 < 128 && j9 < j10) {
                    UnsafeUtil.putByte(bArr, j9, (byte) cCharAt2);
                    j8 = j10;
                    j7 = j6;
                    j9 += j6;
                } else if (cCharAt2 >= 2048 || j9 > j10 - 2) {
                    j7 = j6;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j9 > j10 - 3) {
                        j8 = j10;
                        if (j9 > j8 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                throw new UnpairedSurrogateException(i5, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j9);
                        }
                        int i6 = i5 + 1;
                        if (i6 != length) {
                            char cCharAt3 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                UnsafeUtil.putByte(bArr, j9, (byte) ((codePoint >>> 18) | KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE));
                                UnsafeUtil.putByte(bArr, j9 + j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = j9 + 3;
                                UnsafeUtil.putByte(bArr, j9 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j9 += 4;
                                UnsafeUtil.putByte(bArr, j11, (byte) ((codePoint & 63) | 128));
                                i5 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        throw new UnpairedSurrogateException(i5 - 1, length);
                    }
                    UnsafeUtil.putByte(bArr, j9, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j12 = j9 + 2;
                    j8 = j10;
                    UnsafeUtil.putByte(bArr, j9 + j7, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    j9 += 3;
                    UnsafeUtil.putByte(bArr, j12, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    j7 = j6;
                    long j13 = j9 + j7;
                    UnsafeUtil.putByte(bArr, j9, (byte) ((cCharAt2 >>> 6) | 960));
                    j9 += 2;
                    UnsafeUtil.putByte(bArr, j13, (byte) ((cCharAt2 & '?') | 128));
                    j8 = j10;
                }
                i5++;
                j6 = j7;
                j10 = j8;
            }
            return (int) j9;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j6;
            char c;
            long j7;
            long j8;
            long j9;
            int i;
            char c6;
            char cCharAt;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long jPosition = ((long) byteBuffer.position()) + jAddressOffset;
            long jLimit = ((long) byteBuffer.limit()) + jAddressOffset;
            int length = charSequence.length();
            if (length > jLimit - jPosition) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i3 = 0;
            while (true) {
                j6 = 1;
                c = 128;
                if (i3 >= length || (cCharAt = charSequence.charAt(i3)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(jPosition, (byte) cCharAt);
                i3++;
                jPosition = 1 + jPosition;
            }
            if (i3 == length) {
                byteBuffer.position((int) (jPosition - jAddressOffset));
                return;
            }
            while (i3 < length) {
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt2 >= c || jPosition >= jLimit) {
                    j7 = j6;
                    if (cCharAt2 < 2048 && jPosition <= jLimit - 2) {
                        long j10 = jPosition + j7;
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        jPosition += 2;
                        UnsafeUtil.putByte(j10, (byte) ((cCharAt2 & '?') | 128));
                        j8 = jAddressOffset;
                        j9 = jLimit;
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            j8 = jAddressOffset;
                            j9 = jLimit;
                            if (jPosition > j9 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i = i3 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i)))) {
                                    throw new UnpairedSurrogateException(i3, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jPosition);
                            }
                            int i4 = i3 + 1;
                            if (i4 != length) {
                                char cCharAt3 = charSequence.charAt(i4);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    UnsafeUtil.putByte(jPosition, (byte) ((codePoint >>> 18) | KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE));
                                    c6 = 128;
                                    UnsafeUtil.putByte(jPosition + j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j11 = jPosition + 3;
                                    UnsafeUtil.putByte(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    UnsafeUtil.putByte(j11, (byte) ((codePoint & 63) | 128));
                                    i3 = i4;
                                } else {
                                    i3 = i4;
                                }
                            }
                            throw new UnpairedSurrogateException(i3 - 1, length);
                        }
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                        j8 = jAddressOffset;
                        long j12 = jPosition + 2;
                        j9 = jLimit;
                        UnsafeUtil.putByte(jPosition + j7, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        jPosition += 3;
                        UnsafeUtil.putByte(j12, (byte) ((cCharAt2 & '?') | 128));
                    }
                    c6 = 128;
                } else {
                    UnsafeUtil.putByte(jPosition, (byte) cCharAt2);
                    j8 = jAddressOffset;
                    j9 = jLimit;
                    c6 = c;
                    jPosition += j6;
                    j7 = j6;
                }
                i3++;
                c = c6;
                j6 = j7;
                jAddressOffset = j8;
                jLimit = j9;
            }
            byteBuffer.position((int) (jPosition - jAddressOffset));
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r11, byte[] r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.length
                int r1 = r1 - r14
                r0 = r0 | r1
                if (r0 < 0) goto La8
                long r0 = (long) r13
                long r13 = (long) r14
                if (r11 == 0) goto La1
                int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
                if (r2 < 0) goto L10
                return r11
            L10:
                byte r2 = (byte) r11
                r3 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r2 >= r3) goto L2a
                r11 = -62
                if (r2 < r11) goto L29
                long r6 = r6 + r0
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r5) goto L26
                goto L29
            L26:
                r0 = r6
                goto La1
            L29:
                return r4
            L2a:
                r8 = -16
                if (r2 >= r8) goto L5e
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L44
                long r8 = r0 + r6
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L43
                int r11 = com.google.protobuf.Utf8.access$000(r2, r11)
                return r11
            L43:
                r0 = r8
            L44:
                if (r11 > r5) goto L5d
                r8 = -96
                if (r2 != r3) goto L4c
                if (r11 < r8) goto L5d
            L4c:
                r3 = -19
                if (r2 != r3) goto L52
                if (r11 >= r8) goto L5d
            L52:
                long r2 = r0 + r6
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r5) goto L5b
                goto L5d
            L5b:
                r0 = r2
                goto La1
            L5d:
                return r4
            L5e:
                int r3 = r11 >> 8
                int r3 = ~r3
                byte r3 = (byte) r3
                if (r3 != 0) goto L76
                long r8 = r0 + r6
                byte r3 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                int r11 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r11 < 0) goto L73
                int r11 = com.google.protobuf.Utf8.access$000(r2, r3)
                return r11
            L73:
                r11 = 0
                r0 = r8
                goto L79
            L76:
                int r11 = r11 >> 16
                byte r11 = (byte) r11
            L79:
                if (r11 != 0) goto L8b
                long r8 = r0 + r6
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L8a
                int r11 = com.google.protobuf.Utf8.access$100(r2, r3, r11)
                return r11
            L8a:
                r0 = r8
            L8b:
                if (r3 > r5) goto La0
                int r2 = r2 << 28
                int r3 = r3 + 112
                int r3 = r3 + r2
                int r2 = r3 >> 30
                if (r2 != 0) goto La0
                if (r11 > r5) goto La0
                long r2 = r0 + r6
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r12, r0)
                if (r11 <= r5) goto L5b
            La0:
                return r4
            La1:
                long r13 = r13 - r0
                int r11 = (int) r13
                int r11 = partialIsValidUtf8(r12, r0, r11)
                return r11
            La8:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                int r12 = r12.length
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                java.lang.Object[] r12 = new java.lang.Object[]{r12, r13, r14}
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r13, r12)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L57;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8Direct(int r10, java.nio.ByteBuffer r11, int r12, int r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long j6, int i) {
            if (i < 16) {
                return 0;
            }
            int i3 = 8 - (((int) j6) & 7);
            int i4 = i3;
            while (i4 > 0) {
                long j7 = 1 + j6;
                if (UnsafeUtil.getByte(j6) < 0) {
                    return i3 - i4;
                }
                i4--;
                j6 = j7;
            }
            int i5 = i - i3;
            while (i5 >= 8 && (UnsafeUtil.getLong(j6) & Utf8.ASCII_MASK_LONG) == 0) {
                j6 += 8;
                i5 -= 8;
            }
            return i - i5;
        }

        private static int unsafeIncompleteStateFor(long j6, int i, int i3) {
            if (i3 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i3 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j6));
            }
            if (i3 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j6), UnsafeUtil.getByte(j6 + 1));
            }
            throw new AssertionError();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(byte[] r10, long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(long r10, int r12) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = com.google.protobuf.UnsafeUtil.getByte(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    private Utf8() {
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int i, int i3) {
        return processor.decodeUtf8(byteBuffer, i, i3);
    }

    public static int encode(CharSequence charSequence, byte[] bArr, int i, int i3) {
        return processor.encodeUtf8(charSequence, bArr, i, i3);
    }

    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i3 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i3 += (127 - cCharAt) >>> 31;
            } else {
                i3 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i, int i3) {
        int i4 = i3 - 7;
        int i5 = i;
        while (i5 < i4 && (byteBuffer.getLong(i5) & ASCII_MASK_LONG) == 0) {
            i5 += 8;
        }
        return i5 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static int partialIsValidUtf8(int i, byte[] bArr, int i3, int i4) {
        return processor.partialIsValidUtf8(i, bArr, i3, i4);
    }

    public static String decodeUtf8(byte[] bArr, int i, int i3) {
        return processor.decodeUtf8(bArr, i, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i3) {
        if (i > -12 || i3 > -65) {
            return -1;
        }
        return i ^ (i3 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i3) {
        return processor.isValidUtf8(bArr, i, i3);
    }

    public static int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i3, int i4) {
        return processor.partialIsValidUtf8(i, byteBuffer, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i3, int i4) {
        if (i > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i ^ (i3 << 8)) ^ (i4 << 16);
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i, int i3) {
        byte b = bArr[i - 1];
        int i4 = i3 - i;
        if (i4 == 0) {
            return incompleteStateFor(b);
        }
        if (i4 == 1) {
            return incompleteStateFor(b, bArr[i]);
        }
        if (i4 == 2) {
            return incompleteStateFor(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i, int i3, int i4) {
        if (i4 == 0) {
            return incompleteStateFor(i);
        }
        if (i4 == 1) {
            return incompleteStateFor(i, byteBuffer.get(i3));
        }
        if (i4 == 2) {
            return incompleteStateFor(i, byteBuffer.get(i3), byteBuffer.get(i3 + 1));
        }
        throw new AssertionError();
    }

    public static final class SafeProcessor extends Processor {
        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i3) {
            while (i < i3) {
                int i4 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i4 >= i3) {
                            return b;
                        }
                        if (b >= -62) {
                            i += 2;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b < -16) {
                        if (i4 >= i3 - 1) {
                            return Utf8.incompleteStateFor(bArr, i4, i3);
                        }
                        int i5 = i + 2;
                        byte b2 = bArr[i4];
                        if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                            i += 3;
                            if (bArr[i5] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i4 >= i3 - 2) {
                        return Utf8.incompleteStateFor(bArr, i4, i3);
                    }
                    int i6 = i + 2;
                    byte b6 = bArr[i4];
                    if (b6 <= -65) {
                        if ((((b6 + 112) + (b << 28)) >> 30) == 0) {
                            int i7 = i + 3;
                            if (bArr[i6] <= -65) {
                                i += 4;
                                if (bArr[i7] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i = i4;
            }
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i3) throws InvalidProtocolBufferException {
            if ((i | i3 | ((bArr.length - i) - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i3)));
            }
            int i4 = i + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i < i4) {
                byte b = bArr[i];
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b2 = bArr[i];
                if (DecodeUtil.isOneByte(b2)) {
                    int i8 = i6 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i6);
                    int i9 = i7;
                    while (i9 < i4) {
                        byte b6 = bArr[i9];
                        if (!DecodeUtil.isOneByte(b6)) {
                            break;
                        }
                        i9++;
                        DecodeUtil.handleOneByte(b6, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    i = i9;
                } else if (DecodeUtil.isTwoBytes(b2)) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b2, bArr[i7], cArr, i6);
                    i6++;
                } else if (DecodeUtil.isThreeBytes(b2)) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i10 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b2, bArr[i7], bArr[i10], cArr, i6);
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b7 = bArr[i7];
                    int i11 = i + 3;
                    byte b8 = bArr[i + 2];
                    i += 4;
                    DecodeUtil.handleFourBytes(b2, b7, b8, bArr[i11], cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i3) {
            return decodeUtf8Default(byteBuffer, i, i3);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i3) {
            int i4;
            int i5;
            char cCharAt;
            int length = charSequence.length();
            int i6 = i3 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (cCharAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) cCharAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char cCharAt2 = charSequence.charAt(i7);
                if (cCharAt2 < 128 && i8 < i6) {
                    bArr[i8] = (byte) cCharAt2;
                    i8++;
                } else if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                    i8 += 2;
                    bArr[i9] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                        if (i8 > i6 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                throw new UnpairedSurrogateException(i7, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                        }
                        int i10 = i7 + 1;
                        if (i10 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i10);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i8] = (byte) ((codePoint >>> 18) | KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE);
                                bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i11 = i8 + 3;
                                bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i8 += 4;
                                bArr[i11] = (byte) ((codePoint & 63) | 128);
                                i7 = i10;
                            } else {
                                i7 = i10;
                            }
                        }
                        throw new UnpairedSurrogateException(i7 - 1, length);
                    }
                    bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i12 = i8 + 2;
                    bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i8 += 3;
                    bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
                }
                i7++;
            }
            return i8;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = com.google.protobuf.Utf8.access$000(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = com.google.protobuf.Utf8.access$000(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = com.google.protobuf.Utf8.access$100(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i3, int i4) {
            return partialIsValidUtf8Default(i, byteBuffer, i3, i4);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i, int i3) {
            while (i < i3 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i3) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i3);
        }
    }
}
