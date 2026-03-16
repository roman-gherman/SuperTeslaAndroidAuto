package com.google.protobuf;

import B2.b;
import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* JADX INFO: renamed from: com.google.protobuf.MessageSchema$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i3, MessageLite messageLite, boolean z6, boolean z7, int[] iArr2, int i4, int i5, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i3;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z6;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z7;
        this.intArray = iArr2;
        this.checkInitializedCount = i4;
        this.repeatedFieldOffsetStart = i5;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t6, T t7, int i) {
        return isFieldPresent(t6, i) == isFieldPresent(t7, i);
    }

    private static <T> boolean booleanAt(T t6, long j6) {
        return UnsafeUtil.getBoolean(t6, j6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i3, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i4 = registers.int1;
        if (i4 < 0 || i4 > i3 - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i5 = iDecodeVarint32 + i4;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint32 < i5) {
            int iDecodeVarint322 = iDecodeVarint32 + 1;
            int i6 = bArr[iDecodeVarint32];
            if (i6 < 0) {
                iDecodeVarint322 = ArrayDecoders.decodeVarint32(i6, bArr, iDecodeVarint322, registers);
                i6 = registers.int1;
            }
            int i7 = iDecodeVarint322;
            int i8 = i6 >>> 3;
            int i9 = i6 & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == metadata.valueType.getWireType()) {
                    iDecodeVarint32 = decodeMapEntryValue(bArr, i7, i3, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint32 = ArrayDecoders.skipField(i6, bArr, i7, i3, registers);
                }
            } else if (i9 == metadata.keyType.getWireType()) {
                iDecodeVarint32 = decodeMapEntryValue(bArr, i7, i3, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint32 = ArrayDecoders.skipField(i6, bArr, i7, i3, registers);
            }
        }
        if (iDecodeVarint32 != i5) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i5;
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i3, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i3, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t6, long j6) {
        return UnsafeUtil.getDouble(t6, j6);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i3, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i3, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t6, long j6) {
        return UnsafeUtil.getFloat(t6, j6);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i) {
        int i3 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i3];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i3 + 1]);
        this.objects[i3] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t6) {
        int i;
        int i3;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        boolean z6;
        int iComputeSizeFixed32List;
        Unsafe unsafe = UNSAFE;
        int i4 = -1;
        int i5 = 0;
        int iD = 0;
        int i6 = 0;
        while (i5 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            int iNumberAt = numberAt(i5);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i = this.buffer[i5 + 2];
                int i7 = OFFSET_MASK & i;
                int i8 = 1 << (i >>> 20);
                if (i7 != i4) {
                    i6 = unsafe.getInt(t6, i7);
                    i4 = i7;
                }
                i3 = i8;
            } else {
                i = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i5 + 2] & OFFSET_MASK;
                i3 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            int i9 = i4;
            switch (iType) {
                case 0:
                    if ((i6 & i3) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if ((i6 & i3) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if ((i6 & i3) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if ((i6 & i3) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if ((i6 & i3) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if ((i6 & i3) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if ((i6 & i3) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i6 & i3) != 0) {
                        Object object = unsafe.getObject(t6, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iD = iComputeBytesSize + iD;
                    }
                    break;
                case 9:
                    if ((i6 & i3) != 0) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t6, jOffset), getMessageFieldSchema(i5));
                        iD += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 14:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i6 & i3) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t6, jOffset), getMessageFieldSchema(i5));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 19:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 20:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 21:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 22:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 23:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 24:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 25:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t6, jOffset));
                    iD += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t6, jOffset), getMessageFieldSchema(i5));
                    iD += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t6, jOffset));
                    iD += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 30:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 31:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 32:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 33:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 34:
                    z6 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t6, jOffset), false);
                    iD += iComputeSizeFixed32List;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeFixed64ListNoTag);
                        }
                        iD = a.d(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iD);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeFixed32ListNoTag);
                        }
                        iD = a.d(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iD);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeInt64ListNoTag);
                        }
                        iD = a.d(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iD);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeUInt64ListNoTag);
                        }
                        iD = a.d(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iD);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeInt32ListNoTag);
                        }
                        iD = a.d(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iD);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeFixed64ListNoTag2);
                        }
                        iD = a.d(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iD);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeFixed32ListNoTag2);
                        }
                        iD = a.d(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iD);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeBoolListNoTag);
                        }
                        iD = a.d(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iD);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeUInt32ListNoTag);
                        }
                        iD = a.d(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iD);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeEnumListNoTag);
                        }
                        iD = a.d(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iD);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeFixed32ListNoTag3);
                        }
                        iD = a.d(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iD);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeFixed64ListNoTag3);
                        }
                        iD = a.d(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iD);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeSInt32ListNoTag);
                        }
                        iD = a.d(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iD);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i, iComputeSizeSInt64ListNoTag);
                        }
                        iD = a.d(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iD);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t6, jOffset), getMessageFieldSchema(i5));
                    iD += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t6, jOffset), getMapFieldDefaultEntry(i5));
                    iD += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        Object object2 = unsafe.getObject(t6, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iD = iComputeBytesSize + iD;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t6, jOffset), getMessageFieldSchema(i5));
                        iD += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iD += iComputeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t6, jOffset));
                        iD += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t6, jOffset), getMessageFieldSchema(i5));
                        iD += iComputeBoolSize;
                    }
                    break;
            }
            i5 += 3;
            i4 = i9;
        }
        int unknownFieldsSerializedSize = iD + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t6);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t6).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t6) {
        int iComputeDoubleSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        Unsafe unsafe = UNSAFE;
        int iD = 0;
        for (int i = 0; i < this.buffer.length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            int i3 = (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i + 2] & OFFSET_MASK;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t6, i)) {
                        Object object = UnsafeUtil.getObject(t6, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iD = iComputeBytesSize + iD;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t6, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t6, jOffset), getMessageFieldSchema(i));
                        iD += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t6, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t6, jOffset), getMessageFieldSchema(i));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 19:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 20:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 21:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 22:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 23:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 24:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 25:
                    iComputeSizeMessage = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t6, jOffset));
                    iD += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t6, jOffset), getMessageFieldSchema(i));
                    iD += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t6, jOffset));
                    iD += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 30:
                    iComputeSizeMessage = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 31:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 32:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 33:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 34:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t6, jOffset), false);
                    iD += iComputeSizeMessage;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iD = a.d(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iD);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeFixed32ListNoTag);
                        }
                        iD = a.d(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iD);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeInt64ListNoTag);
                        }
                        iD = a.d(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iD);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeUInt64ListNoTag);
                        }
                        iD = a.d(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iD);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeInt32ListNoTag);
                        }
                        iD = a.d(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iD);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeFixed64ListNoTag2);
                        }
                        iD = a.d(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iD);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeFixed32ListNoTag2);
                        }
                        iD = a.d(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iD);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeBoolListNoTag);
                        }
                        iD = a.d(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iD);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeUInt32ListNoTag);
                        }
                        iD = a.d(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iD);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeEnumListNoTag);
                        }
                        iD = a.d(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iD);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeFixed32ListNoTag3);
                        }
                        iD = a.d(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iD);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeFixed64ListNoTag3);
                        }
                        iD = a.d(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iD);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeSInt32ListNoTag);
                        }
                        iD = a.d(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iD);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t6, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t6, i3, iComputeSizeSInt64ListNoTag);
                        }
                        iD = a.d(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iD);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t6, jOffset), getMessageFieldSchema(i));
                    iD += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t6, jOffset), getMapFieldDefaultEntry(i));
                    iD += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        Object object2 = UnsafeUtil.getObject(t6, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iD = iComputeBytesSize + iD;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t6, jOffset), getMessageFieldSchema(i));
                        iD += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t6, jOffset));
                        iD += iComputeDoubleSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t6, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t6, jOffset), getMessageFieldSchema(i));
                        iD += iComputeDoubleSize;
                    }
                    break;
            }
        }
        return iD + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t6);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t6) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t6));
    }

    private static <T> int intAt(T t6, long j6) {
        return UnsafeUtil.getInt(t6, j6);
    }

    private static boolean isEnforceUtf8(int i) {
        return (i & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t6, int i, int i3, int i4) {
        return this.proto3 ? isFieldPresent(t6, i) : (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i3) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!messageFieldSchema.isInitialized(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.Schema] */
    private boolean isMapInitialized(T t6, int i, int i3) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t6, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i3)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t6, T t7, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & OFFSET_MASK;
        return UnsafeUtil.getInt(t6, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t7, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t6, int i, int i3) {
        return UnsafeUtil.getInt(t6, (long) (presenceMaskAndOffsetAt(i3) & OFFSET_MASK)) == i;
    }

    private static boolean isRequired(int i) {
        return (i & REQUIRED_MASK) != 0;
    }

    private static List<?> listAt(Object obj, long j6) {
        return (List) UnsafeUtil.getObject(obj, j6);
    }

    private static <T> long longAt(T t6, long j6) {
        return UnsafeUtil.getLong(t6, j6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:334:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r0 = r14.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
    
        if (r0 >= r14.repeatedFieldOffsetStart) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0089, code lost:
    
        r7 = filterMapUnknownEnumValues(r9, r14.intArray[r0], r7, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        if (r7 == null) goto L334;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0638 A[LOOP:3: B:197:0x0634->B:199:0x0638, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x060f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05f4 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.protobuf.UnknownFieldSchema, com.google.protobuf.UnknownFieldSchema<UT, UB>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r15, com.google.protobuf.ExtensionSchema<ET> r16, T r17, com.google.protobuf.Reader r18, com.google.protobuf.ExtensionRegistryLite r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long jOffset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private void mergeMessage(T t6, T t7, int i) {
        long jOffset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t7, i)) {
            Object object = UnsafeUtil.getObject(t6, jOffset);
            Object object2 = UnsafeUtil.getObject(t7, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t6, jOffset, Internal.mergeMessage(object, object2));
                setFieldPresent(t6, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t6, jOffset, object2);
                setFieldPresent(t6, i);
            }
        }
    }

    private void mergeOneofMessage(T t6, T t7, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        int iNumberAt = numberAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        if (isOneofPresent(t7, iNumberAt, i)) {
            Object object = UnsafeUtil.getObject(t6, jOffset);
            Object object2 = UnsafeUtil.getObject(t7, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t6, jOffset, Internal.mergeMessage(object, object2));
                setOneofPresent(t6, iNumberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t6, jOffset, object2);
                setOneofPresent(t6, iNumberAt, i);
            }
        }
    }

    private void mergeSingleField(T t6, T t7, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putDouble(t6, jOffset, UnsafeUtil.getDouble(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 1:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putFloat(t6, jOffset, UnsafeUtil.getFloat(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 2:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 3:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 4:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 5:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 6:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 7:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putBoolean(t6, jOffset, UnsafeUtil.getBoolean(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 8:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putObject(t6, jOffset, UnsafeUtil.getObject(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 9:
                mergeMessage(t6, t7, i);
                break;
            case 10:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putObject(t6, jOffset, UnsafeUtil.getObject(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 11:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 12:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 13:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 14:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 15:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 16:
                if (isFieldPresent(t7, i)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i);
                }
                break;
            case 17:
                mergeMessage(t6, t7, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t6, t7, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t6, t7, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t7, iNumberAt, i)) {
                    UnsafeUtil.putObject(t6, jOffset, UnsafeUtil.getObject(t7, jOffset));
                    setOneofPresent(t6, iNumberAt, i);
                }
                break;
            case 60:
                mergeOneofMessage(t6, t7, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t7, iNumberAt, i)) {
                    UnsafeUtil.putObject(t6, jOffset, UnsafeUtil.getObject(t7, jOffset));
                    setOneofPresent(t6, iNumberAt, i);
                }
                break;
            case 68:
                mergeOneofMessage(t6, t7, i);
                break;
        }
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        boolean z6 = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i3 = 0;
        int i4 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i3++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i4++;
            }
        }
        int[] iArr2 = i3 > 0 ? new int[i3] : null;
        int[] iArr3 = i4 > 0 ? new int[i4] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i5 < fields.length) {
            FieldInfo fieldInfo2 = fields[i5];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i6, z6, objArr);
            if (i7 < checkInitialized.length && checkInitialized[i7] == fieldNumber3) {
                checkInitialized[i7] = i6;
                i7++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i8] = i6;
                i8++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    i = i6;
                    iArr3[i9] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i9++;
                }
                i5++;
                i6 = i + 3;
            }
            i = i6;
            i5++;
            i6 = i + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z6, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo r34, com.google.protobuf.NewInstanceSchema r35, com.google.protobuf.ListFieldSchema r36, com.google.protobuf.UnknownFieldSchema<?, ?> r37, com.google.protobuf.ExtensionSchema<?> r38, com.google.protobuf.MapFieldSchema r39) {
        /*
            Method dump skipped, instruction units count: 1033
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo, com.google.protobuf.NewInstanceSchema, com.google.protobuf.ListFieldSchema, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, com.google.protobuf.MapFieldSchema):com.google.protobuf.MessageSchema");
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return i & OFFSET_MASK;
    }

    private static <T> boolean oneofBooleanAt(T t6, long j6) {
        return ((Boolean) UnsafeUtil.getObject(t6, j6)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t6, long j6) {
        return ((Double) UnsafeUtil.getObject(t6, j6)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t6, long j6) {
        return ((Float) UnsafeUtil.getObject(t6, j6)).floatValue();
    }

    private static <T> int oneofIntAt(T t6, long j6) {
        return ((Integer) UnsafeUtil.getObject(t6, j6)).intValue();
    }

    private static <T> long oneofLongAt(T t6, long j6) {
        return ((Long) UnsafeUtil.getObject(t6, j6)).longValue();
    }

    private <K, V> int parseMapField(T t6, byte[] bArr, int i, int i3, int i4, long j6, ArrayDecoders.Registers registers) {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i4);
        Object object = unsafe.getObject(t6, j6);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t6, j6, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i3, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t6, byte[] bArr, int i, int i3, int i4, int i5, int i6, int i7, int i8, long j6, int i9, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Object object;
        Unsafe unsafe = UNSAFE;
        long j7 = this.buffer[i9 + 2] & OFFSET_MASK;
        switch (i8) {
            case 51:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(t6, j6, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i10 = i + 8;
                unsafe.putInt(t6, j7, i5);
                return i10;
            case 52:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(t6, j6, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i11 = i + 4;
                unsafe.putInt(t6, j7, i5);
                return i11;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t6, j6, Long.valueOf(registers.long1));
                unsafe.putInt(t6, j7, i5);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t6, j6, Integer.valueOf(registers.int1));
                unsafe.putInt(t6, j7, i5);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(t6, j6, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i12 = i + 8;
                unsafe.putInt(t6, j7, i5);
                return i12;
            case 57:
            case 64:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(t6, j6, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i13 = i + 4;
                unsafe.putInt(t6, j7, i5);
                return i13;
            case 58:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t6, j6, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t6, j7, i5);
                return iDecodeVarint642;
            case 59:
                if (i6 != 2) {
                    return i;
                }
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i14 = registers.int1;
                if (i14 == 0) {
                    unsafe.putObject(t6, j6, "");
                } else {
                    if ((i7 & ENFORCE_UTF8_MASK) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i14)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t6, j6, new String(bArr, iDecodeVarint322, i14, Internal.UTF_8));
                    iDecodeVarint322 += i14;
                }
                unsafe.putInt(t6, j7, i5);
                return iDecodeVarint322;
            case 60:
                if (i6 != 2) {
                    return i;
                }
                int iDecodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i9), bArr, i, i3, registers);
                object = unsafe.getInt(t6, j7) == i5 ? unsafe.getObject(t6, j6) : null;
                if (object == null) {
                    unsafe.putObject(t6, j6, registers.object1);
                } else {
                    unsafe.putObject(t6, j6, Internal.mergeMessage(object, registers.object1));
                }
                unsafe.putInt(t6, j7, i5);
                return iDecodeMessageField;
            case 61:
                if (i6 != 2) {
                    return i;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t6, j6, registers.object1);
                unsafe.putInt(t6, j7, i5);
                return iDecodeBytes;
            case 63:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i15 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i9);
                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i15)) {
                    getMutableUnknownFields(t6).storeField(i4, Long.valueOf(i15));
                    return iDecodeVarint323;
                }
                unsafe.putObject(t6, j6, Integer.valueOf(i15));
                unsafe.putInt(t6, j7, i5);
                return iDecodeVarint323;
            case 66:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t6, j6, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t6, j7, i5);
                return iDecodeVarint324;
            case 67:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t6, j6, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t6, j7, i5);
                return iDecodeVarint643;
            case 68:
                if (i6 == 3) {
                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i9), bArr, i, i3, (i4 & (-8)) | 4, registers);
                    object = unsafe.getInt(t6, j7) == i5 ? unsafe.getObject(t6, j6) : null;
                    if (object == null) {
                        unsafe.putObject(t6, j6, registers.object1);
                    } else {
                        unsafe.putObject(t6, j6, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t6, j7, i5);
                    return iDecodeGroupField;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0053. Please report as an issue. */
    private int parseProto3Message(T t6, byte[] bArr, int i, int i3, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe2;
        int iDecodeVarint64;
        int i7;
        int i8;
        int i9;
        MessageSchema<T> messageSchema = this;
        byte[] bArr2 = bArr;
        int i10 = i3;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe3 = UNSAFE;
        int i11 = -1;
        int iDecodeUnknownField = i;
        int i12 = -1;
        int i13 = 0;
        while (iDecodeUnknownField < i10) {
            int iDecodeVarint32 = iDecodeUnknownField + 1;
            int i14 = bArr2[iDecodeUnknownField];
            if (i14 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i14, bArr2, iDecodeVarint32, registers2);
                i14 = registers2.int1;
            }
            int i15 = iDecodeVarint32;
            int i16 = i14;
            int i17 = (i16 == true ? 1 : 0) >>> 3;
            int i18 = (i16 == true ? 1 : 0) & 7;
            int iPositionForFieldNumber = i17 > i12 ? messageSchema.positionForFieldNumber(i17, i13 / 3) : messageSchema.positionForFieldNumber(i17);
            if (iPositionForFieldNumber == i11) {
                unsafe = unsafe3;
                i4 = i15;
                i5 = i17;
                iPositionForFieldNumber = 0;
            } else {
                int i19 = messageSchema.buffer[iPositionForFieldNumber + 1];
                int iType = type(i19);
                long jOffset = offset(i19);
                if (iType <= 17) {
                    switch (iType) {
                        case 0:
                            i6 = i16 == true ? 1 : 0;
                            if (i18 == 1) {
                                UnsafeUtil.putDouble(t6, jOffset, ArrayDecoders.decodeDouble(bArr2, i15));
                                iDecodeUnknownField = i15 + 8;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe3;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 1:
                            i6 = i16 == true ? 1 : 0;
                            if (i18 == 5) {
                                UnsafeUtil.putFloat(t6, jOffset, ArrayDecoders.decodeFloat(bArr2, i15));
                                iDecodeUnknownField = i15 + 4;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe3;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 2:
                        case 3:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 != 0) {
                                unsafe = unsafe2;
                                i7 = i15;
                                i8 = i17;
                                i9 = i6;
                                i4 = i7;
                                i5 = i8;
                                i16 = i9;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i15, registers2);
                                unsafe3 = unsafe2;
                                unsafe3.putLong(t6, jOffset, registers2.long1);
                                iDecodeUnknownField = iDecodeVarint64;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            break;
                        case 4:
                        case 11:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i15, registers2);
                                unsafe2.putInt(t6, jOffset, registers2.int1);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 5:
                        case 14:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 1) {
                                unsafe2.putLong(t6, jOffset, ArrayDecoders.decodeFixed64(bArr2, i15));
                                unsafe2 = unsafe2;
                                iDecodeUnknownField = i15 + 8;
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 6:
                        case 13:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 5) {
                                unsafe2.putInt(t6, jOffset, ArrayDecoders.decodeFixed32(bArr2, i15));
                                iDecodeUnknownField = i15 + 4;
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 7:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr2, i15, registers2);
                                UnsafeUtil.putBoolean(t6, jOffset, registers2.long1 != 0);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 8:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 2) {
                                iDecodeUnknownField = (ENFORCE_UTF8_MASK & i19) == 0 ? ArrayDecoders.decodeString(bArr2, i15, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i15, registers2);
                                unsafe2.putObject(t6, jOffset, registers2.object1);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 9:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeMessageField(messageSchema.getMessageFieldSchema(iPositionForFieldNumber), bArr2, i15, i10, registers2);
                                Object object = unsafe2.getObject(t6, jOffset);
                                if (object == null) {
                                    unsafe2.putObject(t6, jOffset, registers2.object1);
                                } else {
                                    unsafe2.putObject(t6, jOffset, Internal.mergeMessage(object, registers2.object1));
                                }
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 10:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr2, i15, registers2);
                                unsafe2.putObject(t6, jOffset, registers2.object1);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 12:
                            unsafe2 = unsafe3;
                            if (i18 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i15, registers2);
                                unsafe2.putInt(t6, jOffset, registers2.int1);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i16 == true ? 1 : 0;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 15:
                            unsafe2 = unsafe3;
                            if (i18 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i15, registers2);
                                unsafe2.putInt(t6, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i16 == true ? 1 : 0;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 16:
                            if (i18 != 0) {
                                unsafe2 = unsafe3;
                                unsafe = unsafe2;
                                i7 = i15;
                                i8 = i17;
                                i9 = i16 == true ? 1 : 0;
                                i4 = i7;
                                i5 = i8;
                                i16 = i9;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i15, registers2);
                                unsafe3.putLong(t6, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                unsafe3 = unsafe3;
                                iDecodeUnknownField = iDecodeVarint64;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            break;
                        default:
                            unsafe = unsafe3;
                            i7 = i15;
                            i8 = i17;
                            i9 = i16 == true ? 1 : 0;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                    }
                } else {
                    i6 = i16 == true ? 1 : 0;
                    if (iType == 27) {
                        if (i18 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe3.getObject(t6, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe3.putObject(t6, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            unsafe = unsafe3;
                            iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(iPositionForFieldNumber), i6 == true ? 1 : 0, bArr2, i15, i10, protobufListMutableCopyWithCapacity2, registers2);
                            bArr2 = bArr;
                            i10 = i3;
                            registers2 = registers;
                            i12 = i17;
                        }
                        unsafe = unsafe3;
                        i7 = i15;
                        i8 = i17;
                        i9 = i6;
                        i4 = i7;
                        i5 = i8;
                        i16 = i9;
                    } else {
                        unsafe = unsafe3;
                        if (iType <= 49) {
                            int repeatedField = messageSchema.parseRepeatedField(t6, bArr, i15, i3, i6 == true ? 1 : 0, i17, i18, iPositionForFieldNumber, i19, iType, jOffset, registers);
                            i9 = i6 == true ? 1 : 0;
                            i8 = i17;
                            iPositionForFieldNumber = iPositionForFieldNumber;
                            if (repeatedField != i15) {
                                messageSchema = this;
                                i10 = i3;
                                registers2 = registers;
                                iDecodeUnknownField = repeatedField;
                                i12 = i8;
                                i13 = iPositionForFieldNumber;
                                unsafe3 = unsafe;
                                i11 = -1;
                                bArr2 = bArr;
                            } else {
                                i4 = repeatedField;
                                i5 = i8;
                                i16 = i9;
                            }
                        } else {
                            i8 = i17;
                            i9 = i6 == true ? 1 : 0;
                            i7 = i15;
                            if (iType == 50) {
                                if (i18 == 2) {
                                    int mapField = parseMapField(t6, bArr, i7, i3, iPositionForFieldNumber, jOffset, registers);
                                    if (mapField != i7) {
                                        messageSchema = this;
                                        bArr2 = bArr;
                                        i10 = i3;
                                        registers2 = registers;
                                        iDecodeUnknownField = mapField;
                                        i12 = i8;
                                    } else {
                                        i4 = mapField;
                                    }
                                } else {
                                    i4 = i7;
                                }
                                i5 = i8;
                                i16 = i9;
                            } else {
                                i5 = i8;
                                i16 = i9 == true ? 1 : 0;
                                int oneofField = parseOneofField(t6, bArr, i7, i3, i16 == true ? 1 : 0, i5, i18, i19, iType, jOffset, iPositionForFieldNumber, registers);
                                if (oneofField != i7) {
                                    messageSchema = this;
                                    i10 = i3;
                                    registers2 = registers;
                                    i12 = i5;
                                    iDecodeUnknownField = oneofField;
                                    i13 = iPositionForFieldNumber;
                                    unsafe3 = unsafe;
                                    i11 = -1;
                                    bArr2 = bArr;
                                } else {
                                    i4 = oneofField;
                                }
                            }
                        }
                    }
                    i13 = iPositionForFieldNumber;
                    unsafe3 = unsafe;
                }
                i11 = -1;
            }
            iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i16 == true ? 1 : 0, bArr, i4, i3, getMutableUnknownFields(t6), registers);
            messageSchema = this;
            bArr2 = bArr;
            registers2 = registers;
            i10 = i3;
            i12 = i5;
            i13 = iPositionForFieldNumber;
            unsafe3 = unsafe;
            i11 = -1;
        }
        if (iDecodeUnknownField == i10) {
            return iDecodeUnknownField;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private int parseRepeatedField(T t6, byte[] bArr, int i, int i3, int i4, int i5, int i6, int i7, long j6, int i8, long j7, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t6, j7);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t6, j7, protobufListMutableCopyWithCapacity2);
        }
        Internal.ProtobufList protobufList = protobufListMutableCopyWithCapacity2;
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList, registers);
                }
                if (i6 == 1) {
                    return ArrayDecoders.decodeDoubleList(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 19:
            case 36:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList, registers);
                }
                if (i6 == 5) {
                    return ArrayDecoders.decodeFloatList(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeVarint64List(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeVarint32List(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList, registers);
                }
                if (i6 == 1) {
                    return ArrayDecoders.decodeFixed64List(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList, registers);
                }
                if (i6 == 5) {
                    return ArrayDecoders.decodeFixed32List(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 25:
            case 42:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeBoolList(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 26:
                if (i6 == 2) {
                    return (j6 & 536870912) == 0 ? ArrayDecoders.decodeStringList(i4, bArr, i, i3, protobufList, registers) : ArrayDecoders.decodeStringListRequireUtf8(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 27:
                if (i6 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i7), i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 28:
                if (i6 == 2) {
                    return ArrayDecoders.decodeBytesList(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i4, bArr, i, i3, protobufList, registers);
                    }
                    return i;
                }
                iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t6;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i5, (List<Integer>) protobufList, getEnumFieldVerifier(i7), unknownFieldSetLite, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeSInt32List(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 34:
            case 48:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeSInt64List(i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            case 49:
                if (i6 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i7), i4, bArr, i, i3, protobufList, registers);
                }
                return i;
            default:
                return i;
        }
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j6, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j6), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, Reader reader) {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbM = b.m("Field ", str, " for ");
            androidx.constraintlayout.core.motion.a.u(cls, sbM, " not found. Known fields are ");
            sbM.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbM.toString());
        }
    }

    private void setFieldPresent(T t6, int i) {
        if (this.proto3) {
            return;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j6 = iPresenceMaskAndOffsetAt & OFFSET_MASK;
        UnsafeUtil.putInt(t6, j6, UnsafeUtil.getInt(t6, j6) | (1 << (iPresenceMaskAndOffsetAt >>> 20)));
    }

    private void setOneofPresent(T t6, int i, int i3) {
        UnsafeUtil.putInt(t6, presenceMaskAndOffsetAt(i3) & OFFSET_MASK, i);
    }

    private int slowPositionForFieldNumber(int i, int i3) {
        int length = (this.buffer.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int iNumberAt = numberAt(i5);
            if (i == iNumberAt) {
                return i5;
            }
            if (i < iNumberAt) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(com.google.protobuf.FieldInfo r8, int[] r9, int r10, boolean r11, java.lang.Object[] r12) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.storeFieldData(com.google.protobuf.FieldInfo, int[], int, boolean, java.lang.Object[]):void");
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto2(T r19, com.google.protobuf.Writer r20) {
        /*
            Method dump skipped, instruction units count: 1384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto3(T r13, com.google.protobuf.Writer r14) {
        /*
            Method dump skipped, instruction units count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(T r11, com.google.protobuf.Writer r12) {
        /*
            Method dump skipped, instruction units count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i3) {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i3)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t6, Writer writer) {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t6), writer);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t6, T t7) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t6, t7, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t6).equals(this.unknownFieldSchema.getFromMessage(t7))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t6).equals(this.extensionSchema.getExtensions(t7));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t6) {
        return this.proto3 ? getSerializedSizeProto3(t6) : getSerializedSizeProto2(t6);
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t6) {
        int i;
        int iHashLong;
        int i3;
        int iOneofIntAt;
        int length = this.buffer.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            int iNumberAt = numberAt(i5);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t6, jOffset)));
                    i4 = iHashLong + i;
                    break;
                case 1:
                    i = i4 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t6, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 2:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 3:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 4:
                    i3 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i4 = i3 + iOneofIntAt;
                    break;
                case 5:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 6:
                    i3 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i4 = i3 + iOneofIntAt;
                    break;
                case 7:
                    i = i4 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t6, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 8:
                    i = i4 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t6, jOffset)).hashCode();
                    i4 = iHashLong + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t6, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 10:
                    i = i4 * 53;
                    iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                    i4 = iHashLong + i;
                    break;
                case 11:
                    i3 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i4 = i3 + iOneofIntAt;
                    break;
                case 12:
                    i3 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i4 = i3 + iOneofIntAt;
                    break;
                case 13:
                    i3 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i4 = i3 + iOneofIntAt;
                    break;
                case 14:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 15:
                    i3 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i4 = i3 + iOneofIntAt;
                    break;
                case 16:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t6, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i4 * 53;
                    iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                    i4 = iHashLong + i;
                    break;
                case 50:
                    i = i4 * 53;
                    iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                    i4 = iHashLong + i;
                    break;
                case 51:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t6, jOffset)));
                        i4 = iHashLong + i;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t6, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i3 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i4 = i3 + iOneofIntAt;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i3 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i4 = i3 + iOneofIntAt;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t6, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t6, jOffset)).hashCode();
                        i4 = iHashLong + i;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                        i4 = iHashLong + i;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                        i4 = iHashLong + i;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i3 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i4 = i3 + iOneofIntAt;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i3 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i4 = i3 + iOneofIntAt;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i3 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i4 = i3 + iOneofIntAt;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i3 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i4 = i3 + iOneofIntAt;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t6, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                        i4 = iHashLong + i;
                    }
                    break;
            }
        }
        int iHashCode2 = this.unknownFieldSchema.getFromMessage(t6).hashCode() + (i4 * 53);
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t6).hashCode() : iHashCode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized(T r13) {
        /*
            r12 = this;
            r0 = -1
            r1 = 0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r12.checkInitializedCount
            r5 = 1
            if (r2 >= r4) goto L94
            int[] r4 = r12.intArray
            r4 = r4[r2]
            int r6 = r12.numberAt(r4)
            int r7 = r12.typeAndOffsetAt(r4)
            boolean r8 = r12.proto3
            if (r8 != 0) goto L31
            int[] r8 = r12.buffer
            int r9 = r4 + 2
            r8 = r8[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            int r8 = r8 >>> 20
            int r5 = r5 << r8
            if (r9 == r0) goto L32
            sun.misc.Unsafe r0 = com.google.protobuf.MessageSchema.UNSAFE
            long r10 = (long) r9
            int r3 = r0.getInt(r13, r10)
            r0 = r9
            goto L32
        L31:
            r5 = r1
        L32:
            boolean r8 = isRequired(r7)
            if (r8 == 0) goto L3f
            boolean r8 = r12.isFieldPresent(r13, r4, r3, r5)
            if (r8 != 0) goto L3f
            return r1
        L3f:
            int r8 = type(r7)
            r9 = 9
            if (r8 == r9) goto L7f
            r9 = 17
            if (r8 == r9) goto L7f
            r5 = 27
            if (r8 == r5) goto L78
            r5 = 60
            if (r8 == r5) goto L67
            r5 = 68
            if (r8 == r5) goto L67
            r5 = 49
            if (r8 == r5) goto L78
            r5 = 50
            if (r8 == r5) goto L60
            goto L90
        L60:
            boolean r4 = r12.isMapInitialized(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L67:
            boolean r5 = r12.isOneofPresent(r13, r6, r4)
            if (r5 == 0) goto L90
            com.google.protobuf.Schema r4 = r12.getMessageFieldSchema(r4)
            boolean r4 = isInitialized(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L78:
            boolean r4 = r12.isListInitialized(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L7f:
            boolean r5 = r12.isFieldPresent(r13, r4, r3, r5)
            if (r5 == 0) goto L90
            com.google.protobuf.Schema r4 = r12.getMessageFieldSchema(r4)
            boolean r4 = isInitialized(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L90:
            int r2 = r2 + 1
            goto L4
        L94:
            boolean r0 = r12.hasExtensions
            if (r0 == 0) goto La5
            com.google.protobuf.ExtensionSchema<?> r0 = r12.extensionSchema
            com.google.protobuf.FieldSet r13 = r0.getExtensions(r13)
            boolean r13 = r13.isInitialized()
            if (r13 != 0) goto La5
            return r1
        La5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.isInitialized(java.lang.Object):boolean");
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t6) {
        int i;
        int i3 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            if (i3 >= i) {
                break;
            }
            long jOffset = offset(typeAndOffsetAt(this.intArray[i3]));
            Object object = UnsafeUtil.getObject(t6, jOffset);
            if (object != null) {
                UnsafeUtil.putObject(t6, jOffset, this.mapFieldSchema.toImmutable(object));
            }
            i3++;
        }
        int length = this.intArray.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t6, this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t6);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t6);
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t6, T t7) {
        t7.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t6, t7, i);
        }
        if (this.proto3) {
            return;
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t6, t7);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t6, t7);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0090. Please report as an issue. */
    public int parseProto2Message(T t6, byte[] bArr, int i, int i3, int i4, ArrayDecoders.Registers registers) {
        T t7;
        Unsafe unsafe;
        MessageSchema<T> messageSchema;
        int i5;
        int i6;
        int i7;
        ArrayDecoders.Registers registers2;
        int i8;
        int i9;
        T t8;
        int iDecodeUnknownField;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        T t9;
        Unsafe unsafe2;
        byte[] bArr2;
        int i18;
        Unsafe unsafe3;
        byte[] bArr3;
        int iDecodeVarint32;
        int i19;
        int i20;
        byte[] bArr4;
        int iDecodeMessageField;
        MessageSchema<T> messageSchema2 = this;
        T t10 = t6;
        byte[] bArr5 = bArr;
        int i21 = i3;
        ArrayDecoders.Registers registers3 = registers;
        Unsafe unsafe4 = UNSAFE;
        int i22 = -1;
        int i23 = i;
        int i24 = -1;
        int i25 = -1;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            if (i23 < i21) {
                int iDecodeVarint322 = i23 + 1;
                int i29 = bArr5[i23];
                if (i29 < 0) {
                    iDecodeVarint322 = ArrayDecoders.decodeVarint32(i29, bArr5, iDecodeVarint322, registers3);
                    i29 = registers3.int1;
                }
                int i30 = iDecodeVarint322;
                i28 = i29;
                int i31 = (i28 == true ? 1 : 0) >>> 3;
                int i32 = (i28 == true ? 1 : 0) & 7;
                int iPositionForFieldNumber = i31 > i24 ? messageSchema2.positionForFieldNumber(i31, i26 / 3) : messageSchema2.positionForFieldNumber(i31);
                if (iPositionForFieldNumber == i22) {
                    i5 = i30;
                    unsafe = unsafe4;
                    i6 = i25;
                    i7 = i31;
                    registers2 = registers;
                    messageSchema = messageSchema2;
                    i8 = i28 == true ? 1 : 0;
                    i9 = 0;
                } else {
                    int i33 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i33);
                    int i34 = i25;
                    long jOffset = offset(i33);
                    if (iType <= 17) {
                        int i35 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i36 = 1 << (i35 >>> 20);
                        int i37 = i35 & OFFSET_MASK;
                        i7 = i31;
                        if (i37 != i34) {
                            i13 = iType;
                            if (i34 != -1) {
                                unsafe4.putInt(t10, i34, i27);
                            }
                            i15 = i37;
                            i14 = unsafe4.getInt(t10, i37);
                        } else {
                            i13 = iType;
                            i14 = i27;
                            i15 = i34;
                        }
                        switch (i13) {
                            case 0:
                                i16 = iPositionForFieldNumber;
                                i17 = i30;
                                registers2 = registers;
                                t9 = t10;
                                unsafe2 = unsafe4;
                                bArr2 = bArr;
                                if (i32 == 1) {
                                    UnsafeUtil.putDouble(t9, jOffset, ArrayDecoders.decodeDouble(bArr2, i17));
                                    i23 = i17 + 8;
                                    i18 = i14 | i36;
                                    i21 = i3;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i18;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t10 = t9;
                                    i22 = -1;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 1:
                                i16 = iPositionForFieldNumber;
                                i17 = i30;
                                registers2 = registers;
                                t9 = t10;
                                unsafe2 = unsafe4;
                                bArr2 = bArr;
                                if (i32 == 5) {
                                    UnsafeUtil.putFloat(t9, jOffset, ArrayDecoders.decodeFloat(bArr2, i17));
                                    i23 = i17 + 4;
                                    i18 = i14 | i36;
                                    i21 = i3;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i18;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t10 = t9;
                                    i22 = -1;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 2:
                            case 3:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i17 = i30;
                                bArr2 = bArr;
                                registers2 = registers;
                                if (i32 == 0) {
                                    int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i17, registers2);
                                    T t11 = t10;
                                    unsafe2 = unsafe3;
                                    unsafe2.putLong(t11, jOffset, registers2.long1);
                                    t9 = t11;
                                    i18 = i14 | i36;
                                    i21 = i3;
                                    i23 = iDecodeVarint64;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i18;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t10 = t9;
                                    i22 = -1;
                                } else {
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 4:
                            case 11:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i17 = i30;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr3, i17, registers2);
                                    unsafe3.putInt(t10, jOffset, registers2.int1);
                                    Unsafe unsafe5 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe5;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i3;
                                } else {
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 5:
                            case 14:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 1) {
                                    T t12 = t10;
                                    unsafe3.putLong(t12, jOffset, ArrayDecoders.decodeFixed64(bArr3, i30));
                                    unsafe3 = unsafe3;
                                    t10 = t12;
                                    iDecodeVarint32 = i30 + 8;
                                    Unsafe unsafe52 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe52;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i3;
                                } else {
                                    i17 = i30;
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 6:
                            case 13:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 5) {
                                    unsafe3.putInt(t10, jOffset, ArrayDecoders.decodeFixed32(bArr3, i19));
                                    iDecodeVarint32 = i19 + 4;
                                    Unsafe unsafe522 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe522;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i3;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 7:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint64(bArr3, i19, registers2);
                                    UnsafeUtil.putBoolean(t10, jOffset, registers2.long1 != 0);
                                    Unsafe unsafe5222 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe5222;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i3;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 8:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 2) {
                                    iDecodeVarint32 = (i33 & ENFORCE_UTF8_MASK) == 0 ? ArrayDecoders.decodeString(bArr3, i19, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr3, i19, registers2);
                                    unsafe3.putObject(t10, jOffset, registers2.object1);
                                    Unsafe unsafe52222 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe52222;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i3;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 9:
                                i20 = i21;
                                registers2 = registers;
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr4 = bArr;
                                if (i32 == 2) {
                                    iDecodeMessageField = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(i16), bArr4, i19, i20, registers2);
                                    if ((i14 & i36) == 0) {
                                        unsafe3.putObject(t10, jOffset, registers2.object1);
                                    } else {
                                        unsafe3.putObject(t10, jOffset, Internal.mergeMessage(unsafe3.getObject(t10, jOffset), registers2.object1));
                                    }
                                    Unsafe unsafe6 = unsafe3;
                                    i23 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe6;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i14 | i36;
                                    i21 = i20;
                                    i22 = -1;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 10:
                                i20 = i21;
                                registers2 = registers;
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr4 = bArr;
                                if (i32 == 2) {
                                    iDecodeMessageField = ArrayDecoders.decodeBytes(bArr4, i19, registers2);
                                    unsafe3.putObject(t10, jOffset, registers2.object1);
                                    Unsafe unsafe62 = unsafe3;
                                    i23 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe62;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i14 | i36;
                                    i21 = i20;
                                    i22 = -1;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 12:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr4 = bArr;
                                registers2 = registers;
                                i20 = i21;
                                if (i32 == 0) {
                                    iDecodeMessageField = ArrayDecoders.decodeVarint32(bArr4, i19, registers2);
                                    int i38 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i16);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i38)) {
                                        unsafe3.putInt(t10, jOffset, i38);
                                        Unsafe unsafe622 = unsafe3;
                                        i23 = iDecodeMessageField;
                                        bArr5 = bArr4;
                                        unsafe4 = unsafe622;
                                        registers3 = registers2;
                                        i25 = i15;
                                        i26 = i16;
                                        i24 = i7;
                                        i27 = i14 | i36;
                                        i21 = i20;
                                        i22 = -1;
                                    } else {
                                        getMutableUnknownFields(t10).storeField(i28 == true ? 1 : 0, Long.valueOf(i38));
                                        i23 = iDecodeMessageField;
                                        bArr5 = bArr4;
                                        unsafe4 = unsafe3;
                                        i21 = i20;
                                        registers3 = registers2;
                                        i25 = i15;
                                        i27 = i14;
                                        i26 = i16;
                                        i24 = i7;
                                        i22 = -1;
                                    }
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 15:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr4 = bArr;
                                registers2 = registers;
                                i20 = i21;
                                if (i32 == 0) {
                                    iDecodeMessageField = ArrayDecoders.decodeVarint32(bArr4, i19, registers2);
                                    unsafe3.putInt(t10, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    Unsafe unsafe6222 = unsafe3;
                                    i23 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe6222;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i14 | i36;
                                    i21 = i20;
                                    i22 = -1;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 16:
                                i16 = iPositionForFieldNumber;
                                i19 = i30;
                                if (i32 == 0) {
                                    int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i19, registers);
                                    T t13 = t10;
                                    Unsafe unsafe7 = unsafe4;
                                    unsafe7.putLong(t13, jOffset, CodedInputStream.decodeZigZag64(registers.long1));
                                    t10 = t13;
                                    int i39 = i15;
                                    i27 = i14 | i36;
                                    bArr5 = bArr;
                                    unsafe4 = unsafe7;
                                    i23 = iDecodeVarint642;
                                    registers3 = registers;
                                    i25 = i39;
                                    i21 = i3;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                } else {
                                    unsafe3 = unsafe4;
                                    registers2 = registers;
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 17:
                                if (i32 == 3) {
                                    int i40 = iPositionForFieldNumber;
                                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i30, i21, (i7 << 3) | 4, registers);
                                    if ((i14 & i36) == 0) {
                                        unsafe4.putObject(t10, jOffset, registers.object1);
                                    } else {
                                        unsafe4.putObject(t10, jOffset, Internal.mergeMessage(unsafe4.getObject(t10, jOffset), registers.object1));
                                    }
                                    i23 = iDecodeGroupField;
                                    bArr5 = bArr;
                                    registers3 = registers;
                                    i25 = i15;
                                    i26 = i40;
                                    i22 = -1;
                                    i21 = i3;
                                    i27 = i14 | i36;
                                    i24 = i7;
                                } else {
                                    i16 = iPositionForFieldNumber;
                                    registers2 = registers;
                                    unsafe2 = unsafe4;
                                    i17 = i30;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            default:
                                registers2 = registers;
                                i16 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i17 = i30;
                                messageSchema = messageSchema2;
                                unsafe = unsafe2;
                                i5 = i17;
                                i6 = i15;
                                i8 = i28 == true ? 1 : 0;
                                i27 = i14;
                                i9 = i16;
                                break;
                        }
                    } else {
                        int i41 = iPositionForFieldNumber;
                        i7 = i31;
                        T t14 = t10;
                        Unsafe unsafe8 = unsafe4;
                        i6 = i34;
                        if (iType == 27) {
                            if (i32 == 2) {
                                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe8.getObject(t14, jOffset);
                                if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                    int size = protobufListMutableCopyWithCapacity2.size();
                                    protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                    unsafe8.putObject(t14, jOffset, protobufListMutableCopyWithCapacity2);
                                }
                                unsafe4 = unsafe8;
                                int iDecodeMessageList = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i41), i28 == true ? 1 : 0, bArr, i30, i3, protobufListMutableCopyWithCapacity2, registers);
                                bArr5 = bArr;
                                i21 = i3;
                                registers3 = registers;
                                i23 = iDecodeMessageList;
                                t10 = t14;
                                i26 = i41;
                                i24 = i7;
                                i25 = i6;
                                i22 = -1;
                            } else {
                                unsafe = unsafe8;
                                i12 = i30;
                                i10 = i27;
                                i11 = i28 == true ? 1 : 0;
                                i9 = i41;
                                messageSchema = this;
                                registers2 = registers;
                                i5 = i12;
                                i8 = i11;
                            }
                        } else if (iType <= 49) {
                            unsafe = unsafe8;
                            i10 = i27;
                            int repeatedField = messageSchema2.parseRepeatedField(t6, bArr, i30, i3, i28 == true ? 1 : 0, i7, i32, i41, i33, iType, jOffset, registers);
                            i11 = i28 == true ? 1 : 0;
                            i9 = i41;
                            if (repeatedField != i30) {
                                messageSchema2 = this;
                                t10 = t6;
                                bArr5 = bArr;
                                i21 = i3;
                                i23 = repeatedField;
                                i26 = i9;
                                i27 = i10;
                                i24 = i7;
                                i25 = i6;
                                unsafe4 = unsafe;
                                registers3 = registers;
                                i28 = i11;
                                i22 = -1;
                            } else {
                                messageSchema = this;
                                registers2 = registers;
                                i5 = repeatedField;
                                i8 = i11;
                            }
                        } else {
                            unsafe = unsafe8;
                            i10 = i27;
                            i11 = i28 == true ? 1 : 0;
                            i9 = i41;
                            i12 = i30;
                            if (iType != 50) {
                                int oneofField = parseOneofField(t6, bArr, i12, i3, i11 == true ? 1 : 0, i7, i32, i33, iType, jOffset, i9, registers);
                                messageSchema = this;
                                i8 = i11 == true ? 1 : 0;
                                registers2 = registers;
                                if (oneofField != i12) {
                                    t10 = t6;
                                    bArr5 = bArr;
                                    i21 = i3;
                                    i23 = oneofField;
                                    registers3 = registers2;
                                    i26 = i9;
                                    i27 = i10;
                                    i24 = i7;
                                    i25 = i6;
                                    i22 = -1;
                                    i28 = i8;
                                    messageSchema2 = messageSchema;
                                    unsafe4 = unsafe;
                                } else {
                                    i5 = oneofField;
                                }
                            } else if (i32 == 2) {
                                int mapField = parseMapField(t6, bArr, i12, i3, i9, jOffset, registers);
                                if (mapField != i12) {
                                    messageSchema2 = this;
                                    t10 = t6;
                                    bArr5 = bArr;
                                    i21 = i3;
                                    registers3 = registers;
                                    i23 = mapField;
                                    i26 = i9;
                                    i27 = i10;
                                    i24 = i7;
                                    i25 = i6;
                                    unsafe4 = unsafe;
                                    i28 = i11;
                                    i22 = -1;
                                } else {
                                    messageSchema = this;
                                    registers2 = registers;
                                    i5 = mapField;
                                    i8 = i11;
                                }
                            } else {
                                messageSchema = this;
                                registers2 = registers;
                                i5 = i12;
                                i8 = i11;
                            }
                        }
                        i27 = i10;
                    }
                }
                if (i8 != i4 || i4 == 0) {
                    if (!messageSchema.hasExtensions || registers2.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) {
                        t8 = t6;
                        iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i8 == true ? 1 : 0, bArr, i5, i3, getMutableUnknownFields(t8), registers);
                        i21 = i3;
                    } else {
                        iDecodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i8 == true ? 1 : 0, bArr, i5, i3, t6, messageSchema.defaultInstance, messageSchema.unknownFieldSchema, registers2);
                        t8 = t6;
                        i21 = i3;
                    }
                    i23 = iDecodeUnknownField;
                    bArr5 = bArr;
                    registers3 = registers;
                    t10 = t8;
                    i26 = i9;
                    i24 = i7;
                    i25 = i6;
                    i22 = -1;
                    i28 = i8;
                    messageSchema2 = messageSchema;
                    unsafe4 = unsafe;
                } else {
                    t7 = t6;
                    i21 = i3;
                    i28 = i8 == true ? 1 : 0;
                    i23 = i5;
                    i25 = i6;
                }
            } else {
                t7 = t10;
                unsafe = unsafe4;
                messageSchema = messageSchema2;
            }
        }
        if (i25 != -1) {
            unsafe.putInt(t7, i25, i27);
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i42 = messageSchema.checkInitializedCount; i42 < messageSchema.repeatedFieldOffsetStart; i42++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t7, messageSchema.intArray[i42], unknownFieldSetLite, messageSchema.unknownFieldSchema);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t7, unknownFieldSetLite);
        }
        if (i4 == 0) {
            if (i23 != i21) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i23 > i21 || i28 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i23;
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t6, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t6, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t6, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t6, writer);
        }
    }

    private boolean isFieldPresent(T t6, int i) {
        if (this.proto3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    return UnsafeUtil.getDouble(t6, jOffset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(t6, jOffset) != 0.0f;
                case 2:
                    return UnsafeUtil.getLong(t6, jOffset) != 0;
                case 3:
                    return UnsafeUtil.getLong(t6, jOffset) != 0;
                case 4:
                    return UnsafeUtil.getInt(t6, jOffset) != 0;
                case 5:
                    return UnsafeUtil.getLong(t6, jOffset) != 0;
                case 6:
                    return UnsafeUtil.getInt(t6, jOffset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean(t6, jOffset);
                case 8:
                    Object object = UnsafeUtil.getObject(t6, jOffset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.getObject(t6, jOffset) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t6, jOffset));
                case 11:
                    return UnsafeUtil.getInt(t6, jOffset) != 0;
                case 12:
                    return UnsafeUtil.getInt(t6, jOffset) != 0;
                case 13:
                    return UnsafeUtil.getInt(t6, jOffset) != 0;
                case 14:
                    return UnsafeUtil.getLong(t6, jOffset) != 0;
                case 15:
                    return UnsafeUtil.getInt(t6, jOffset) != 0;
                case 16:
                    return UnsafeUtil.getLong(t6, jOffset) != 0;
                case 17:
                    return UnsafeUtil.getObject(t6, jOffset) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        return (UnsafeUtil.getInt(t6, (long) (iPresenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
    }

    private int positionForFieldNumber(int i, int i3) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i3);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t6, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t6, reader, extensionRegistryLite);
    }

    private boolean equals(T t6, T t7, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t6, t7, i) || Double.doubleToLongBits(UnsafeUtil.getDouble(t6, jOffset)) != Double.doubleToLongBits(UnsafeUtil.getDouble(t7, jOffset))) {
                }
                break;
            case 1:
                if (!arePresentForEquals(t6, t7, i) || Float.floatToIntBits(UnsafeUtil.getFloat(t6, jOffset)) != Float.floatToIntBits(UnsafeUtil.getFloat(t7, jOffset))) {
                }
                break;
            case 2:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getLong(t6, jOffset) != UnsafeUtil.getLong(t7, jOffset)) {
                }
                break;
            case 3:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getLong(t6, jOffset) != UnsafeUtil.getLong(t7, jOffset)) {
                }
                break;
            case 4:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getInt(t6, jOffset) != UnsafeUtil.getInt(t7, jOffset)) {
                }
                break;
            case 5:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getLong(t6, jOffset) != UnsafeUtil.getLong(t7, jOffset)) {
                }
                break;
            case 6:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getInt(t6, jOffset) != UnsafeUtil.getInt(t7, jOffset)) {
                }
                break;
            case 7:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getBoolean(t6, jOffset) != UnsafeUtil.getBoolean(t7, jOffset)) {
                }
                break;
            case 8:
                if (!arePresentForEquals(t6, t7, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset))) {
                }
                break;
            case 9:
                if (!arePresentForEquals(t6, t7, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset))) {
                }
                break;
            case 10:
                if (!arePresentForEquals(t6, t7, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset))) {
                }
                break;
            case 11:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getInt(t6, jOffset) != UnsafeUtil.getInt(t7, jOffset)) {
                }
                break;
            case 12:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getInt(t6, jOffset) != UnsafeUtil.getInt(t7, jOffset)) {
                }
                break;
            case 13:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getInt(t6, jOffset) != UnsafeUtil.getInt(t7, jOffset)) {
                }
                break;
            case 14:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getLong(t6, jOffset) != UnsafeUtil.getLong(t7, jOffset)) {
                }
                break;
            case 15:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getInt(t6, jOffset) != UnsafeUtil.getInt(t7, jOffset)) {
                }
                break;
            case 16:
                if (!arePresentForEquals(t6, t7, i) || UnsafeUtil.getLong(t6, jOffset) != UnsafeUtil.getLong(t7, jOffset)) {
                }
                break;
            case 17:
                if (!arePresentForEquals(t6, t7, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!isOneofCaseEqual(t6, t7, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset))) {
                }
                break;
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t6, byte[] bArr, int i, int i3, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        if (this.proto3) {
            parseProto3Message(t6, bArr, i, i3, registers);
        } else {
            parseProto2Message(t6, bArr, i, i3, 0, registers);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }
}
