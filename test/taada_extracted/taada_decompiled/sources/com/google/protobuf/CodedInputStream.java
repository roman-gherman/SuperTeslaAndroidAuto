package com.google.protobuf;

import B2.b;
import com.google.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 100;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private void recomputeBufferSizeAfterLimit() {
            int i = this.limit + this.bufferSizeAfterLimit;
            this.limit = i;
            int i3 = i - this.startPos;
            int i4 = this.currentLimit;
            if (i3 <= i4) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i5 = i3 - i4;
            this.bufferSizeAfterLimit = i5;
            this.limit = i - i5;
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.buffer;
                int i3 = this.pos;
                this.pos = i3 + 1;
                if (bArr[i3] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z6) {
            this.enableAliasing = z6;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i + getTotalBytesRead();
            int i3 = this.currentLimit;
            if (totalBytesRead > i3) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i3;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.limit;
                int i3 = this.pos;
                if (rawVarint32 <= i - i3) {
                    ByteBuffer byteBufferWrap = (this.immutable || !this.enableAliasing) ? ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i3, i3 + rawVarint32)) : ByteBuffer.wrap(this.buffer, i3, rawVarint32).slice();
                    this.pos += rawVarint32;
                    return byteBufferWrap;
                }
            }
            if (rawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.limit;
                int i3 = this.pos;
                if (rawVarint32 <= i - i3) {
                    ByteString byteStringWrap = (this.immutable && this.enableAliasing) ? ByteString.wrap(this.buffer, i3, rawVarint32) : ByteString.copyFrom(this.buffer, i3, rawVarint32);
                    this.pos += rawVarint32;
                    return byteStringWrap;
                }
            }
            return rawVarint32 == 0 ? ByteString.EMPTY : ByteString.wrap(readRawBytes(rawVarint32));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i3 = this.recursionDepth;
            if (i3 >= this.recursionLimit) {
                throw InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth = i3 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (i == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws InvalidProtocolBufferException {
            if (i > 0) {
                int i3 = this.limit;
                int i4 = this.pos;
                if (i <= i3 - i4) {
                    int i5 = i + i4;
                    this.pos = i5;
                    return Arrays.copyOfRange(this.buffer, i4, i5);
                }
            }
            if (i > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (this.limit - i < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (this.limit - i < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i;
            int i3 = this.pos;
            int i4 = this.limit;
            if (i4 != i3) {
                byte[] bArr = this.buffer;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.pos = i5;
                    return b;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i3 + 2;
                    int i7 = (bArr[i5] << 7) ^ b;
                    if (i7 < 0) {
                        i = i7 ^ (-128);
                    } else {
                        int i8 = i3 + 3;
                        int i9 = (bArr[i6] << 14) ^ i7;
                        if (i9 >= 0) {
                            i = i9 ^ 16256;
                        } else {
                            int i10 = i3 + 4;
                            int i11 = i9 ^ (bArr[i8] << 21);
                            if (i11 < 0) {
                                i = (-2080896) ^ i11;
                            } else {
                                i8 = i3 + 5;
                                byte b2 = bArr[i10];
                                int i12 = (i11 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i10 = i3 + 6;
                                    if (bArr[i8] < 0) {
                                        i8 = i3 + 7;
                                        if (bArr[i10] < 0) {
                                            i10 = i3 + 8;
                                            if (bArr[i8] < 0) {
                                                i8 = i3 + 9;
                                                if (bArr[i10] < 0) {
                                                    int i13 = i3 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i6 = i13;
                                                        i = i12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i12;
                                }
                                i = i12;
                            }
                            i6 = i10;
                        }
                        i6 = i8;
                    }
                    this.pos = i6;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j6;
            long j7;
            long j8;
            int i = this.pos;
            int i3 = this.limit;
            if (i3 != i) {
                byte[] bArr = this.buffer;
                int i4 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.pos = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        j6 = i6 ^ (-128);
                    } else {
                        int i7 = i + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            j6 = i8 ^ 16256;
                            i5 = i7;
                        } else {
                            int i9 = i + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                long j9 = (-2080896) ^ i10;
                                i5 = i9;
                                j6 = j9;
                            } else {
                                long j10 = i10;
                                i5 = i + 5;
                                long j11 = j10 ^ (((long) bArr[i9]) << 28);
                                if (j11 >= 0) {
                                    j8 = 266354560;
                                } else {
                                    int i11 = i + 6;
                                    long j12 = j11 ^ (((long) bArr[i5]) << 35);
                                    if (j12 < 0) {
                                        j7 = -34093383808L;
                                    } else {
                                        i5 = i + 7;
                                        j11 = j12 ^ (((long) bArr[i11]) << 42);
                                        if (j11 >= 0) {
                                            j8 = 4363953127296L;
                                        } else {
                                            i11 = i + 8;
                                            j12 = j11 ^ (((long) bArr[i5]) << 49);
                                            if (j12 < 0) {
                                                j7 = -558586000294016L;
                                            } else {
                                                i5 = i + 9;
                                                long j13 = (j12 ^ (((long) bArr[i11]) << 56)) ^ 71499008037633920L;
                                                if (j13 < 0) {
                                                    int i12 = i + 10;
                                                    if (bArr[i5] >= 0) {
                                                        i5 = i12;
                                                    }
                                                }
                                                j6 = j13;
                                            }
                                        }
                                    }
                                    j6 = j12 ^ j7;
                                    i5 = i11;
                                }
                                j6 = j11 ^ j8;
                            }
                        }
                    }
                    this.pos = i5;
                    return j6;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j6 = 0;
            for (int i = 0; i < 64; i += 7) {
                byte rawByte = readRawByte();
                j6 |= ((long) (rawByte & 127)) << i;
                if ((rawByte & 128) == 0) {
                    return j6;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.limit;
                int i3 = this.pos;
                if (rawVarint32 <= i - i3) {
                    String str = new String(this.buffer, i3, rawVarint32, Internal.UTF_8);
                    this.pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.limit;
                int i3 = this.pos;
                if (rawVarint32 <= i - i3) {
                    String strDecodeUtf8 = Utf8.decodeUtf8(this.buffer, i3, rawVarint32);
                    this.pos += rawVarint32;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) throws InvalidProtocolBufferException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws InvalidProtocolBufferException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int i3 = this.limit;
                int i4 = this.pos;
                if (i <= i3 - i4) {
                    this.pos = i4 + i;
                    return;
                }
            }
            if (i >= 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private ArrayDecoder(byte[] bArr, int i, int i3, boolean z6) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i3 + i;
            this.pos = i;
            this.startPos = i;
            this.immutable = z6;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i3 = this.recursionDepth;
            if (i3 < this.recursionLimit) {
                this.recursionDepth = i3 + 1;
                T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return partialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int iPushLimit = pushLimit(rawVarint32);
                this.recursionDepth++;
                T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeRawVarint32(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private boolean immutable;
        private Iterable<ByteBuffer> input;
        private Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (!this.iterator.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void readRawBytesTo(byte[] bArr, int i, int i3) throws InvalidProtocolBufferException {
            if (i3 < 0 || i3 > remaining()) {
                if (i3 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i3 != 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                return;
            }
            int i4 = i3;
            while (i4 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = Math.min(i4, (int) currentRemaining());
                long j6 = iMin;
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, (i3 - i4) + i, j6);
                i4 -= iMin;
                this.currentByteBufferPos += j6;
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            int i = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i;
            int i3 = i - this.startOffset;
            int i4 = this.currentLimit;
            if (i3 <= i4) {
                this.bufferSizeAfterCurrentLimit = 0;
                return;
            }
            int i5 = i3 - i4;
            this.bufferSizeAfterCurrentLimit = i5;
            this.totalBufferSize = i - i5;
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(int i, int i3) {
            int iPosition = this.currentByteBuffer.position();
            int iLimit = this.currentByteBuffer.limit();
            try {
                try {
                    this.currentByteBuffer.position(i);
                    this.currentByteBuffer.limit(i3);
                    return this.currentByteBuffer.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                this.currentByteBuffer.position(iPosition);
                this.currentByteBuffer.limit(iLimit);
            }
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long jPosition = next.position();
            this.currentByteBufferPos = jPosition;
            this.currentByteBufferStartPos = jPosition;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long jAddressOffset = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = jAddressOffset;
            this.currentByteBufferPos += jAddressOffset;
            this.currentByteBufferStartPos += jAddressOffset;
            this.currentByteBufferLimit += jAddressOffset;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z6) {
            this.enableAliasing = z6;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i + getTotalBytesRead();
            int i3 = this.currentLimit;
            if (totalBytesRead > i3) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i3;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j6 = rawVarint32;
                if (j6 <= currentRemaining()) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[rawVarint32];
                        UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j6);
                        this.currentByteBufferPos += j6;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j7 = this.currentByteBufferPos + j6;
                    this.currentByteBufferPos = j7;
                    long j8 = this.currentAddress;
                    return slice((int) ((j7 - j8) - j6), (int) (j7 - j8));
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return ByteBuffer.wrap(bArr2);
            }
            if (rawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j6 = rawVarint32;
                long j7 = this.currentByteBufferLimit;
                long j8 = this.currentByteBufferPos;
                if (j6 <= j7 - j8) {
                    if (this.immutable && this.enableAliasing) {
                        int i = (int) (j8 - this.currentAddress);
                        ByteString byteStringWrap = ByteString.wrap(slice(i, rawVarint32 + i));
                        this.currentByteBufferPos += j6;
                        return byteStringWrap;
                    }
                    byte[] bArr = new byte[rawVarint32];
                    UnsafeUtil.copyMemory(j8, bArr, 0L, j6);
                    this.currentByteBufferPos += j6;
                    return ByteString.wrap(bArr);
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return ByteString.wrap(bArr2);
            }
            if (rawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i3 = this.recursionDepth;
            if (i3 >= this.recursionLimit) {
                throw InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth = i3 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j6 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j6;
            return UnsafeUtil.getByte(j6);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                long j6 = i;
                if (j6 <= currentRemaining()) {
                    byte[] bArr = new byte[i];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j6);
                    this.currentByteBufferPos += j6;
                    return bArr;
                }
            }
            if (i >= 0 && i <= remaining()) {
                byte[] bArr2 = new byte[i];
                readRawBytesTo(bArr2, 0, i);
                return bArr2;
            }
            if (i > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            if (currentRemaining() < 4) {
                return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
            }
            long j6 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + j6;
            return ((UnsafeUtil.getByte(j6 + 3) & 255) << 24) | (UnsafeUtil.getByte(j6) & 255) | ((UnsafeUtil.getByte(1 + j6) & 255) << 8) | ((UnsafeUtil.getByte(2 + j6) & 255) << 16);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            char c;
            long rawByte;
            byte rawByte2;
            if (currentRemaining() >= 8) {
                long j6 = this.currentByteBufferPos;
                this.currentByteBufferPos = 8 + j6;
                c = '8';
                rawByte = (((long) UnsafeUtil.getByte(j6)) & 255) | ((((long) UnsafeUtil.getByte(1 + j6)) & 255) << 8) | ((((long) UnsafeUtil.getByte(2 + j6)) & 255) << 16) | ((((long) UnsafeUtil.getByte(3 + j6)) & 255) << 24) | ((((long) UnsafeUtil.getByte(4 + j6)) & 255) << 32) | ((((long) UnsafeUtil.getByte(5 + j6)) & 255) << 40) | ((((long) UnsafeUtil.getByte(6 + j6)) & 255) << 48);
                rawByte2 = UnsafeUtil.getByte(j6 + 7);
            } else {
                c = '8';
                rawByte = (((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8) | ((((long) readRawByte()) & 255) << 16) | ((((long) readRawByte()) & 255) << 24) | ((((long) readRawByte()) & 255) << 32) | ((((long) readRawByte()) & 255) << 40) | ((((long) readRawByte()) & 255) << 48);
                rawByte2 = readRawByte();
            }
            return rawByte | ((((long) rawByte2) & 255) << c);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i;
            long j6 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j6) {
                long j7 = j6 + 1;
                byte b = UnsafeUtil.getByte(j6);
                if (b >= 0) {
                    this.currentByteBufferPos++;
                    return b;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j8 = 2 + j6;
                    int i3 = (UnsafeUtil.getByte(j7) << 7) ^ b;
                    if (i3 < 0) {
                        i = i3 ^ (-128);
                    } else {
                        long j9 = 3 + j6;
                        int i4 = (UnsafeUtil.getByte(j8) << 14) ^ i3;
                        if (i4 >= 0) {
                            i = i4 ^ 16256;
                        } else {
                            long j10 = 4 + j6;
                            int i5 = i4 ^ (UnsafeUtil.getByte(j9) << 21);
                            if (i5 < 0) {
                                i = (-2080896) ^ i5;
                            } else {
                                j9 = 5 + j6;
                                byte b2 = UnsafeUtil.getByte(j10);
                                int i6 = (i5 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    j10 = 6 + j6;
                                    if (UnsafeUtil.getByte(j9) < 0) {
                                        j9 = 7 + j6;
                                        if (UnsafeUtil.getByte(j10) < 0) {
                                            j10 = 8 + j6;
                                            if (UnsafeUtil.getByte(j9) < 0) {
                                                j9 = 9 + j6;
                                                if (UnsafeUtil.getByte(j10) < 0) {
                                                    long j11 = j6 + 10;
                                                    if (UnsafeUtil.getByte(j9) >= 0) {
                                                        i = i6;
                                                        j8 = j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i6;
                                }
                                i = i6;
                            }
                            j8 = j10;
                        }
                        j8 = j9;
                    }
                    this.currentByteBufferPos = j8;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j6;
            long j7;
            long j8;
            long j9 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j9) {
                long j10 = j9 + 1;
                byte b = UnsafeUtil.getByte(j9);
                if (b >= 0) {
                    this.currentByteBufferPos++;
                    return b;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j11 = 2 + j9;
                    int i = (UnsafeUtil.getByte(j10) << 7) ^ b;
                    if (i < 0) {
                        j6 = i ^ (-128);
                    } else {
                        long j12 = 3 + j9;
                        int i3 = (UnsafeUtil.getByte(j11) << 14) ^ i;
                        if (i3 >= 0) {
                            j6 = i3 ^ 16256;
                            j11 = j12;
                        } else {
                            long j13 = 4 + j9;
                            int i4 = i3 ^ (UnsafeUtil.getByte(j12) << 21);
                            if (i4 < 0) {
                                j6 = (-2080896) ^ i4;
                                j11 = j13;
                            } else {
                                long j14 = 5 + j9;
                                long j15 = (((long) UnsafeUtil.getByte(j13)) << 28) ^ ((long) i4);
                                if (j15 >= 0) {
                                    j8 = 266354560;
                                } else {
                                    long j16 = 6 + j9;
                                    long j17 = j15 ^ (((long) UnsafeUtil.getByte(j14)) << 35);
                                    if (j17 < 0) {
                                        j7 = -34093383808L;
                                    } else {
                                        j14 = 7 + j9;
                                        j15 = j17 ^ (((long) UnsafeUtil.getByte(j16)) << 42);
                                        if (j15 >= 0) {
                                            j8 = 4363953127296L;
                                        } else {
                                            j16 = 8 + j9;
                                            j17 = j15 ^ (((long) UnsafeUtil.getByte(j14)) << 49);
                                            if (j17 < 0) {
                                                j7 = -558586000294016L;
                                            } else {
                                                j14 = 9 + j9;
                                                long j18 = (j17 ^ (((long) UnsafeUtil.getByte(j16)) << 56)) ^ 71499008037633920L;
                                                if (j18 < 0) {
                                                    long j19 = j9 + 10;
                                                    if (UnsafeUtil.getByte(j14) >= 0) {
                                                        j11 = j19;
                                                        j6 = j18;
                                                    }
                                                } else {
                                                    j6 = j18;
                                                    j11 = j14;
                                                }
                                            }
                                        }
                                    }
                                    j6 = j7 ^ j17;
                                    j11 = j16;
                                }
                                j6 = j8 ^ j15;
                                j11 = j14;
                            }
                        }
                    }
                    this.currentByteBufferPos = j11;
                    return j6;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j6 = 0;
            for (int i = 0; i < 64; i += 7) {
                byte rawByte = readRawByte();
                j6 |= ((long) (rawByte & 127)) << i;
                if ((rawByte & 128) == 0) {
                    return j6;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j6 = rawVarint32;
                long j7 = this.currentByteBufferLimit;
                long j8 = this.currentByteBufferPos;
                if (j6 <= j7 - j8) {
                    byte[] bArr = new byte[rawVarint32];
                    UnsafeUtil.copyMemory(j8, bArr, 0L, j6);
                    String str = new String(bArr, Internal.UTF_8);
                    this.currentByteBufferPos += j6;
                    return str;
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return new String(bArr2, Internal.UTF_8);
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j6 = rawVarint32;
                long j7 = this.currentByteBufferLimit;
                long j8 = this.currentByteBufferPos;
                if (j6 <= j7 - j8) {
                    String strDecodeUtf8 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (j8 - this.currentByteBufferStartPos), rawVarint32);
                    this.currentByteBufferPos += j6;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32 >= 0 && rawVarint32 <= remaining()) {
                byte[] bArr = new byte[rawVarint32];
                readRawBytesTo(bArr, 0, rawVarint32);
                return Utf8.decodeUtf8(bArr, 0, rawVarint32);
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) throws InvalidProtocolBufferException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws InvalidProtocolBufferException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws InvalidProtocolBufferException {
            if (i < 0 || i > (((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                if (i >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            while (i > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = Math.min(i, (int) currentRemaining());
                i -= iMin;
                this.currentByteBufferPos += (long) iMin;
            }
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i, boolean z6) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i;
            this.input = iterable;
            this.iterator = iterable.iterator();
            this.immutable = z6;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i != 0) {
                tryGetNextByteBuffer();
                return;
            }
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0L;
            this.currentByteBufferStartPos = 0L;
            this.currentByteBufferLimit = 0L;
            this.currentAddress = 0L;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i3 = this.recursionDepth;
            if (i3 < this.recursionLimit) {
                this.recursionDepth = i3 + 1;
                T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return partialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int iPushLimit = pushLimit(rawVarint32);
                this.recursionDepth++;
                T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeRawVarint32(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        public interface RefillCallback {
            void onRefill();
        }

        public class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;

            private SkippedDataSink() {
                this.lastPos = StreamDecoder.this.pos;
            }

            public ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }

            @Override // com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }
        }

        private ByteString readBytesSlowPath(int i) throws IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i);
            if (rawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(rawBytesSlowPathOneChunk);
            }
            int i3 = this.pos;
            int i4 = this.bufferSize;
            int length = i4 - i3;
            this.totalBytesRetired += i4;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, i3, bArr, 0, length);
            for (byte[] bArr2 : rawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] readRawBytesSlowPath(int i, boolean z6) throws IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i);
            if (rawBytesSlowPathOneChunk != null) {
                return z6 ? (byte[]) rawBytesSlowPathOneChunk.clone() : rawBytesSlowPathOneChunk;
            }
            int i3 = this.pos;
            int i4 = this.bufferSize;
            int length = i4 - i3;
            this.totalBytesRetired += i4;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, i3, bArr, 0, length);
            for (byte[] bArr2 : rawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i) throws IOException {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i3 = this.totalBytesRetired;
            int i4 = this.pos;
            int i5 = i3 + i4 + i;
            if (i5 - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i6 = this.currentLimit;
            if (i5 > i6) {
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i7 = this.bufferSize - i4;
            int i8 = i - i7;
            if (i8 >= 4096 && i8 > this.input.available()) {
                return null;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i7);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            while (i7 < i) {
                int i9 = this.input.read(bArr, i7, i - i7);
                if (i9 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += i9;
                i7 += i9;
            }
            return bArr;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                int iMin = Math.min(i, 4096);
                byte[] bArr = new byte[iMin];
                int i3 = 0;
                while (i3 < iMin) {
                    int i4 = this.input.read(bArr, i3, iMin - i3);
                    if (i4 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += i4;
                    i3 += i4;
                }
                i -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i;
            int i3 = this.totalBytesRetired + i;
            int i4 = this.currentLimit;
            if (i3 <= i4) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i5 = i3 - i4;
            this.bufferSizeAfterLimit = i5;
            this.bufferSize = i - i5;
        }

        private void refillBuffer(int i) throws InvalidProtocolBufferException {
            if (tryRefillBuffer(i)) {
                return;
            }
            if (i <= (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }

        private void skipRawBytesSlowPath(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i3 = this.totalBytesRetired;
            int i4 = this.pos;
            int i5 = i3 + i4 + i;
            int i6 = this.currentLimit;
            if (i5 > i6) {
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i7 = 0;
            if (this.refillCallback == null) {
                this.totalBytesRetired = i3 + i4;
                int i8 = this.bufferSize - i4;
                this.bufferSize = 0;
                this.pos = 0;
                i7 = i8;
                while (i7 < i) {
                    try {
                        long j6 = i - i7;
                        long jSkip = this.input.skip(j6);
                        if (jSkip < 0 || jSkip > j6) {
                            throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                        }
                        if (jSkip == 0) {
                            break;
                        } else {
                            i7 += (int) jSkip;
                        }
                    } finally {
                        this.totalBytesRetired += i7;
                        recomputeBufferSizeAfterLimit();
                    }
                }
            }
            if (i7 >= i) {
                return;
            }
            int i9 = this.bufferSize;
            int i10 = i9 - this.pos;
            this.pos = i9;
            refillBuffer(1);
            while (true) {
                int i11 = i - i10;
                int i12 = this.bufferSize;
                if (i11 <= i12) {
                    this.pos = i11;
                    return;
                } else {
                    i10 += i12;
                    this.pos = i12;
                    refillBuffer(1);
                }
            }
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.buffer;
                int i3 = this.pos;
                this.pos = i3 + 1;
                if (bArr[i3] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int i) throws IOException {
            int i3 = this.pos;
            if (i3 + i <= this.bufferSize) {
                throw new IllegalStateException(b.d(i, "refillBuffer() called when ", " bytes were already available in buffer"));
            }
            int i4 = this.sizeLimit;
            int i5 = this.totalBytesRetired;
            if (i > (i4 - i5) - i3 || i5 + i3 + i > this.currentLimit) {
                return false;
            }
            RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            int i6 = this.pos;
            if (i6 > 0) {
                int i7 = this.bufferSize;
                if (i7 > i6) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i6, bArr, 0, i7 - i6);
                }
                this.totalBytesRetired += i6;
                this.bufferSize -= i6;
                this.pos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i8 = this.bufferSize;
            int i9 = inputStream.read(bArr2, i8, Math.min(bArr2.length - i8, (this.sizeLimit - this.totalBytesRetired) - i8));
            if (i9 == 0 || i9 < -1 || i9 > this.buffer.length) {
                throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + i9 + "\nThe InputStream implementation is buggy.");
            }
            if (i9 <= 0) {
                return false;
            }
            this.bufferSize += i9;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= i) {
                return true;
            }
            return tryRefillBuffer(i);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z6) {
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.totalBytesRetired + this.pos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i3 = this.totalBytesRetired + this.pos + i;
            int i4 = this.currentLimit;
            if (i3 > i4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i3;
            recomputeBufferSizeAfterLimit();
            return i4;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() {
            int rawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i3 = this.pos;
            if (rawVarint32 > i - i3 || rawVarint32 <= 0) {
                return readRawBytesSlowPath(rawVarint32, false);
            }
            byte[] bArrCopyOfRange = Arrays.copyOfRange(this.buffer, i3, i3 + rawVarint32);
            this.pos += rawVarint32;
            return bArrCopyOfRange;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int rawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i3 = this.pos;
            if (rawVarint32 > i - i3 || rawVarint32 <= 0) {
                return rawVarint32 == 0 ? Internal.EMPTY_BYTE_BUFFER : ByteBuffer.wrap(readRawBytesSlowPath(rawVarint32, true));
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i3, i3 + rawVarint32));
            this.pos += rawVarint32;
            return byteBufferWrap;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() {
            int rawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i3 = this.pos;
            if (rawVarint32 > i - i3 || rawVarint32 <= 0) {
                return rawVarint32 == 0 ? ByteString.EMPTY : readBytesSlowPath(rawVarint32);
            }
            ByteString byteStringCopyFrom = ByteString.copyFrom(this.buffer, i3, rawVarint32);
            this.pos += rawVarint32;
            return byteStringCopyFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i3 = this.recursionDepth;
            if (i3 >= this.recursionLimit) {
                throw InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth = i3 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) {
            int i3 = this.pos;
            if (i > this.bufferSize - i3 || i <= 0) {
                return readRawBytesSlowPath(i, false);
            }
            int i4 = i + i3;
            this.pos = i4;
            return Arrays.copyOfRange(this.buffer, i3, i4);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (this.bufferSize - i < 4) {
                refillBuffer(4);
                i = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            int i = this.pos;
            if (this.bufferSize - i < 8) {
                refillBuffer(8);
                i = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i;
            int i3 = this.pos;
            int i4 = this.bufferSize;
            if (i4 != i3) {
                byte[] bArr = this.buffer;
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (b >= 0) {
                    this.pos = i5;
                    return b;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i3 + 2;
                    int i7 = (bArr[i5] << 7) ^ b;
                    if (i7 < 0) {
                        i = i7 ^ (-128);
                    } else {
                        int i8 = i3 + 3;
                        int i9 = (bArr[i6] << 14) ^ i7;
                        if (i9 >= 0) {
                            i = i9 ^ 16256;
                        } else {
                            int i10 = i3 + 4;
                            int i11 = i9 ^ (bArr[i8] << 21);
                            if (i11 < 0) {
                                i = (-2080896) ^ i11;
                            } else {
                                i8 = i3 + 5;
                                byte b2 = bArr[i10];
                                int i12 = (i11 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i10 = i3 + 6;
                                    if (bArr[i8] < 0) {
                                        i8 = i3 + 7;
                                        if (bArr[i10] < 0) {
                                            i10 = i3 + 8;
                                            if (bArr[i8] < 0) {
                                                i8 = i3 + 9;
                                                if (bArr[i10] < 0) {
                                                    int i13 = i3 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i6 = i13;
                                                        i = i12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i12;
                                }
                                i = i12;
                            }
                            i6 = i10;
                        }
                        i6 = i8;
                    }
                    this.pos = i6;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j6;
            long j7;
            long j8;
            int i = this.pos;
            int i3 = this.bufferSize;
            if (i3 != i) {
                byte[] bArr = this.buffer;
                int i4 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.pos = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        j6 = i6 ^ (-128);
                    } else {
                        int i7 = i + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            j6 = i8 ^ 16256;
                            i5 = i7;
                        } else {
                            int i9 = i + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                long j9 = (-2080896) ^ i10;
                                i5 = i9;
                                j6 = j9;
                            } else {
                                long j10 = i10;
                                i5 = i + 5;
                                long j11 = j10 ^ (((long) bArr[i9]) << 28);
                                if (j11 >= 0) {
                                    j8 = 266354560;
                                } else {
                                    int i11 = i + 6;
                                    long j12 = j11 ^ (((long) bArr[i5]) << 35);
                                    if (j12 < 0) {
                                        j7 = -34093383808L;
                                    } else {
                                        i5 = i + 7;
                                        j11 = j12 ^ (((long) bArr[i11]) << 42);
                                        if (j11 >= 0) {
                                            j8 = 4363953127296L;
                                        } else {
                                            i11 = i + 8;
                                            j12 = j11 ^ (((long) bArr[i5]) << 49);
                                            if (j12 < 0) {
                                                j7 = -558586000294016L;
                                            } else {
                                                i5 = i + 9;
                                                long j13 = (j12 ^ (((long) bArr[i11]) << 56)) ^ 71499008037633920L;
                                                if (j13 < 0) {
                                                    int i12 = i + 10;
                                                    if (bArr[i5] >= 0) {
                                                        i5 = i12;
                                                    }
                                                }
                                                j6 = j13;
                                            }
                                        }
                                    }
                                    j6 = j12 ^ j7;
                                    i5 = i11;
                                }
                                j6 = j11 ^ j8;
                            }
                        }
                    }
                    this.pos = i5;
                    return j6;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j6 = 0;
            for (int i = 0; i < 64; i += 7) {
                byte rawByte = readRawByte();
                j6 |= ((long) (rawByte & 127)) << i;
                if ((rawByte & 128) == 0) {
                    return j6;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.bufferSize;
                int i3 = this.pos;
                if (rawVarint32 <= i - i3) {
                    String str = new String(this.buffer, i3, rawVarint32, Internal.UTF_8);
                    this.pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(rawVarint32, false), Internal.UTF_8);
            }
            refillBuffer(rawVarint32);
            String str2 = new String(this.buffer, this.pos, rawVarint32, Internal.UTF_8);
            this.pos += rawVarint32;
            return str2;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            byte[] rawBytesSlowPath;
            int rawVarint32 = readRawVarint32();
            int i = this.pos;
            int i3 = this.bufferSize;
            if (rawVarint32 <= i3 - i && rawVarint32 > 0) {
                rawBytesSlowPath = this.buffer;
                this.pos = i + rawVarint32;
            } else {
                if (rawVarint32 == 0) {
                    return "";
                }
                i = 0;
                if (rawVarint32 <= i3) {
                    refillBuffer(rawVarint32);
                    rawBytesSlowPath = this.buffer;
                    this.pos = rawVarint32;
                } else {
                    rawBytesSlowPath = readRawBytesSlowPath(rawVarint32, false);
                }
            }
            return Utf8.decodeUtf8(rawBytesSlowPath, i, rawVarint32);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) throws InvalidProtocolBufferException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws InvalidProtocolBufferException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws InvalidProtocolBufferException {
            int i3 = this.bufferSize;
            int i4 = this.pos;
            if (i > i3 - i4 || i < 0) {
                skipRawBytesSlowPath(i);
            } else {
                this.pos = i4 + i;
            }
        }

        private StreamDecoder(InputStream inputStream, int i) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i3 = this.recursionDepth;
            if (i3 < this.recursionLimit) {
                this.recursionDepth = i3 + 1;
                T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return partialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int iPushLimit = pushLimit(rawVarint32);
                this.recursionDepth++;
                T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeRawVarint32(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        private int bufferPos(long j6) {
            return (int) (j6 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long j6 = this.limit + ((long) this.bufferSizeAfterLimit);
            this.limit = j6;
            int i = (int) (j6 - this.startPos);
            int i3 = this.currentLimit;
            if (i <= i3) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i4 = i - i3;
            this.bufferSizeAfterLimit = i4;
            this.limit = j6 - ((long) i4);
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                long j6 = this.pos;
                this.pos = 1 + j6;
                if (UnsafeUtil.getByte(j6) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(long j6, long j7) {
            int iPosition = this.buffer.position();
            int iLimit = this.buffer.limit();
            try {
                try {
                    this.buffer.position(bufferPos(j6));
                    this.buffer.limit(bufferPos(j7));
                    return this.buffer.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                this.buffer.position(iPosition);
                this.buffer.limit(iLimit);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z6) {
            this.enableAliasing = z6;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i + getTotalBytesRead();
            int i3 = this.currentLimit;
            if (totalBytesRead > i3) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i3;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[rawVarint32];
                long j6 = rawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0L, j6);
                this.pos += j6;
                return ByteBuffer.wrap(bArr);
            }
            long j7 = this.pos;
            long j8 = rawVarint32;
            ByteBuffer byteBufferSlice = slice(j7, j7 + j8);
            this.pos += j8;
            return byteBufferSlice;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable && this.enableAliasing) {
                long j6 = this.pos;
                long j7 = rawVarint32;
                ByteBuffer byteBufferSlice = slice(j6, j6 + j7);
                this.pos += j7;
                return ByteString.wrap(byteBufferSlice);
            }
            byte[] bArr = new byte[rawVarint32];
            long j8 = rawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j8);
            this.pos += j8;
            return ByteString.wrap(bArr);
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i3 = this.recursionDepth;
            if (i3 >= this.recursionLimit) {
                throw InvalidProtocolBufferException.recursionLimitExceeded();
            }
            this.recursionDepth = i3 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth >= this.recursionLimit) {
                throw InvalidProtocolBufferException.recursionLimitExceeded();
            }
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(iPushLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            long j6 = this.pos;
            if (j6 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 1 + j6;
            return UnsafeUtil.getByte(j6);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws InvalidProtocolBufferException {
            if (i < 0 || i > remaining()) {
                if (i > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] bArr = new byte[i];
            long j6 = this.pos;
            long j7 = i;
            slice(j6, j6 + j7).get(bArr);
            this.pos += j7;
            return bArr;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            long j6 = this.pos;
            if (this.limit - j6 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 4 + j6;
            return ((UnsafeUtil.getByte(j6 + 3) & 255) << 24) | (UnsafeUtil.getByte(j6) & 255) | ((UnsafeUtil.getByte(1 + j6) & 255) << 8) | ((UnsafeUtil.getByte(2 + j6) & 255) << 16);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            long j6 = this.pos;
            if (this.limit - j6 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 8 + j6;
            return ((((long) UnsafeUtil.getByte(j6 + 7)) & 255) << 56) | (((long) UnsafeUtil.getByte(j6)) & 255) | ((((long) UnsafeUtil.getByte(1 + j6)) & 255) << 8) | ((((long) UnsafeUtil.getByte(2 + j6)) & 255) << 16) | ((((long) UnsafeUtil.getByte(3 + j6)) & 255) << 24) | ((((long) UnsafeUtil.getByte(4 + j6)) & 255) << 32) | ((((long) UnsafeUtil.getByte(5 + j6)) & 255) << 40) | ((((long) UnsafeUtil.getByte(6 + j6)) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r3) < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() {
            /*
                r9 = this;
                long r0 = r9.pos
                long r2 = r9.limit
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = com.google.protobuf.UnsafeUtil.getByte(r0)
                if (r4 < 0) goto L16
                r9.pos = r2
                return r4
            L16:
                long r5 = r9.limit
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = com.google.protobuf.UnsafeUtil.getByte(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.UnsafeUtil.getByte(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L41
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L3f:
                r5 = r3
                goto L98
            L41:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.UnsafeUtil.getByte(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.UnsafeUtil.getByte(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.UnsafeUtil.getByte(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.UnsafeUtil.getByte(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.UnsafeUtil.getByte(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = com.google.protobuf.UnsafeUtil.getByte(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.pos = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j6;
            long j7;
            long j8;
            int i;
            long j9 = this.pos;
            if (this.limit != j9) {
                long j10 = 1 + j9;
                byte b = UnsafeUtil.getByte(j9);
                if (b >= 0) {
                    this.pos = j10;
                    return b;
                }
                if (this.limit - j10 >= 9) {
                    long j11 = 2 + j9;
                    int i3 = (UnsafeUtil.getByte(j10) << 7) ^ b;
                    if (i3 >= 0) {
                        long j12 = 3 + j9;
                        int i4 = i3 ^ (UnsafeUtil.getByte(j11) << 14);
                        if (i4 >= 0) {
                            j6 = i4 ^ 16256;
                            j11 = j12;
                        } else {
                            j11 = 4 + j9;
                            int i5 = i4 ^ (UnsafeUtil.getByte(j12) << 21);
                            if (i5 < 0) {
                                i = (-2080896) ^ i5;
                            } else {
                                long j13 = 5 + j9;
                                long j14 = ((long) i5) ^ (((long) UnsafeUtil.getByte(j11)) << 28);
                                if (j14 >= 0) {
                                    j8 = 266354560;
                                } else {
                                    long j15 = 6 + j9;
                                    long j16 = j14 ^ (((long) UnsafeUtil.getByte(j13)) << 35);
                                    if (j16 < 0) {
                                        j7 = -34093383808L;
                                    } else {
                                        j13 = 7 + j9;
                                        j14 = j16 ^ (((long) UnsafeUtil.getByte(j15)) << 42);
                                        if (j14 >= 0) {
                                            j8 = 4363953127296L;
                                        } else {
                                            j15 = 8 + j9;
                                            j16 = j14 ^ (((long) UnsafeUtil.getByte(j13)) << 49);
                                            if (j16 < 0) {
                                                j7 = -558586000294016L;
                                            } else {
                                                long j17 = j9 + 9;
                                                long j18 = (j16 ^ (((long) UnsafeUtil.getByte(j15)) << 56)) ^ 71499008037633920L;
                                                if (j18 < 0) {
                                                    long j19 = j9 + 10;
                                                    if (UnsafeUtil.getByte(j17) >= 0) {
                                                        j11 = j19;
                                                        j6 = j18;
                                                    }
                                                } else {
                                                    j6 = j18;
                                                    j11 = j17;
                                                }
                                            }
                                        }
                                    }
                                    j6 = j7 ^ j16;
                                    j11 = j15;
                                }
                                j6 = j8 ^ j14;
                                j11 = j13;
                            }
                        }
                        this.pos = j11;
                        return j6;
                    }
                    i = i3 ^ (-128);
                    j6 = i;
                    this.pos = j11;
                    return j6;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j6 = 0;
            for (int i = 0; i < 64; i += 7) {
                byte rawByte = readRawByte();
                j6 |= ((long) (rawByte & 127)) << i;
                if ((rawByte & 128) == 0) {
                    return j6;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return "";
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[rawVarint32];
            long j6 = rawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j6);
            String str = new String(bArr, Internal.UTF_8);
            this.pos += j6;
            return str;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                String strDecodeUtf8 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), rawVarint32);
                this.pos += (long) rawVarint32;
                return strDecodeUtf8;
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.Builder builder) throws InvalidProtocolBufferException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws InvalidProtocolBufferException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws InvalidProtocolBufferException {
            if (i >= 0 && i <= remaining()) {
                this.pos += (long) i;
            } else {
                if (i >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z6) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = byteBuffer;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = jAddressOffset;
            this.limit = ((long) byteBuffer.limit()) + jAddressOffset;
            long jPosition = jAddressOffset + ((long) byteBuffer.position());
            this.pos = jPosition;
            this.startPos = jPosition;
            this.immutable = z6;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int i3 = this.recursionDepth;
            if (i3 < this.recursionLimit) {
                this.recursionDepth = i3 + 1;
                T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return partialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int iPushLimit = pushLimit(rawVarint32);
                this.recursionDepth++;
                T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeRawVarint32(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j6) {
        return (-(j6 & 1)) ^ (j6 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i3 = i & 127;
        int i4 = 7;
        while (i4 < 32) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i3 |= (i5 & 127) << i4;
            if ((i5 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        while (i4 < 64) {
            int i6 = inputStream.read();
            if (i6 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((i6 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public abstract void checkLastTagWas(int i);

    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean z6);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int i);

    public abstract int pushLimit(int i);

    public abstract boolean readBool();

    public abstract byte[] readByteArray();

    public abstract ByteBuffer readByteBuffer();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract byte readRawByte();

    public abstract byte[] readRawBytes(int i);

    public abstract int readRawLittleEndian32();

    public abstract long readRawLittleEndian64();

    public abstract int readRawVarint32();

    public abstract long readRawVarint64();

    public abstract long readRawVarint64SlowPath();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    @Deprecated
    public abstract void readUnknownGroup(int i, MessageLite.Builder builder);

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(b.c(i, "Recursion limit cannot be negative: "));
        }
        int i3 = this.recursionLimit;
        this.recursionLimit = i;
        return i3;
    }

    public final int setSizeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(b.c(i, "Size limit cannot be negative: "));
        }
        int i3 = this.sizeLimit;
        this.sizeLimit = i;
        return i3;
    }

    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int i);

    @Deprecated
    public abstract boolean skipField(int i, CodedOutputStream codedOutputStream);

    public abstract void skipMessage();

    public abstract void skipMessage(CodedOutputStream codedOutputStream);

    public abstract void skipRawBytes(int i);

    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    private CodedInputStream() {
        this.recursionLimit = 100;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i) {
        if (i > 0) {
            return inputStream == null ? newInstance(Internal.EMPTY_BYTE_ARRAY) : new StreamDecoder(inputStream, i);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance(new IterableByteBufferInputStream(iterable));
        }
        return newInstance(iterable, false);
    }

    public static int readRawVarint32(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return readRawVarint32(i, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable, boolean z6) {
        int i = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : iterable) {
            iRemaining += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                i |= 1;
            } else {
                i = byteBuffer.isDirect() ? i | 2 : i | 4;
            }
        }
        if (i == 2) {
            return new IterableDirectByteBufferDecoder(iterable, iRemaining, z6);
        }
        return newInstance(new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i3) {
        return newInstance(bArr, i, i3, false);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i3, boolean z6) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i, i3, z6);
        try {
            arrayDecoder.pushLimit(i3);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer, boolean z6) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), z6);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z6);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, iRemaining, true);
    }
}
