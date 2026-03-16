package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
    private static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    public static int computeSizeBoolList(int i, List<?> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z6) {
            return CodedOutputStream.computeBoolSize(i, true) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int i, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i3));
        }
        return iComputeTagSize;
    }

    public static int computeSizeEnumList(int i, List<Integer> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i) * size) + iComputeSizeEnumListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeEnumListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iComputeEnumSizeNoTag = 0;
            while (i < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i).intValue());
                i++;
            }
            return iComputeEnumSizeNoTag;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iComputeEnumSizeNoTag2 = 0;
        while (i < size) {
            iComputeEnumSizeNoTag2 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i));
            i++;
        }
        return iComputeEnumSizeNoTag2;
    }

    public static int computeSizeFixed32List(int i, List<?> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z6) {
            return CodedOutputStream.computeFixed32Size(i, 0) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 4) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int i, List<?> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z6) {
            return CodedOutputStream.computeFixed64Size(i, 0L) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 8) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int i, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(i, list.get(i3));
        }
        return iComputeGroupSize;
    }

    public static int computeSizeInt32List(int i, List<Integer> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i) * size) + iComputeSizeInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iComputeInt32SizeNoTag = 0;
            while (i < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
            return iComputeInt32SizeNoTag;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iComputeInt32SizeNoTag2 = 0;
        while (i < size) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i));
            i++;
        }
        return iComputeInt32SizeNoTag2;
    }

    public static int computeSizeInt64List(int i, List<Long> list, boolean z6) {
        if (list.size() == 0) {
            return 0;
        }
        int iComputeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z6) {
            return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
        }
        return (CodedOutputStream.computeTagSize(i) * list.size()) + iComputeSizeInt64ListNoTag;
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iComputeInt64SizeNoTag = 0;
            while (i < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
            return iComputeInt64SizeNoTag;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iComputeInt64SizeNoTag2 = 0;
        while (i < size) {
            iComputeInt64SizeNoTag2 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i));
            i++;
        }
        return iComputeInt64SizeNoTag2;
    }

    public static int computeSizeMessage(int i, Object obj, Schema schema) {
        return obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSize(i, (LazyFieldLite) obj) : CodedOutputStream.computeMessageSize(i, (MessageLite) obj, schema);
    }

    public static int computeSizeMessageList(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            iComputeTagSize = (obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj)) + iComputeTagSize;
        }
        return iComputeTagSize;
    }

    public static int computeSizeSInt32List(int i, List<Integer> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i) * size) + iComputeSizeSInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iComputeSInt32SizeNoTag = 0;
            while (i < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
            return iComputeSInt32SizeNoTag;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iComputeSInt32SizeNoTag2 = 0;
        while (i < size) {
            iComputeSInt32SizeNoTag2 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i));
            i++;
        }
        return iComputeSInt32SizeNoTag2;
    }

    public static int computeSizeSInt64List(int i, List<Long> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i) * size) + iComputeSizeSInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iComputeSInt64SizeNoTag = 0;
            while (i < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
            return iComputeSInt64SizeNoTag;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iComputeSInt64SizeNoTag2 = 0;
        while (i < size) {
            iComputeSInt64SizeNoTag2 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i));
            i++;
        }
        return iComputeSInt64SizeNoTag2;
    }

    public static int computeSizeStringList(int i, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i) * size;
        if (!(list instanceof LazyStringList)) {
            while (i3 < size) {
                Object obj = list.get(i3);
                iComputeTagSize = (obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj)) + iComputeTagSize;
                i3++;
            }
            return iComputeTagSize;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        while (i3 < size) {
            Object raw = lazyStringList.getRaw(i3);
            iComputeTagSize = (raw instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) raw) : CodedOutputStream.computeStringSizeNoTag((String) raw)) + iComputeTagSize;
            i3++;
        }
        return iComputeTagSize;
    }

    public static int computeSizeUInt32List(int i, List<Integer> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i) * size) + iComputeSizeUInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iComputeUInt32SizeNoTag = 0;
            while (i < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
            return iComputeUInt32SizeNoTag;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iComputeUInt32SizeNoTag2 = 0;
        while (i < size) {
            iComputeUInt32SizeNoTag2 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i));
            i++;
        }
        return iComputeUInt32SizeNoTag2;
    }

    public static int computeSizeUInt64List(int i, List<Long> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i) * size) + iComputeSizeUInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iComputeUInt64SizeNoTag = 0;
            while (i < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
            return iComputeUInt64SizeNoTag;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iComputeUInt64SizeNoTag2 = 0;
        while (i < size) {
            iComputeUInt64SizeNoTag2 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i));
            i++;
        }
        return iComputeUInt64SizeNoTag2;
    }

    public static <UT, UB> UB filterUnknownEnumList(int i, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (enumLiteMap.findValueByNumber(iIntValue) == null) {
                    ub = (UB) storeUnknownEnum(i, iIntValue, ub, unknownFieldSchema);
                    it.remove();
                }
            }
            return ub;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Integer num = list.get(i4);
            int iIntValue2 = num.intValue();
            if (enumLiteMap.findValueByNumber(iIntValue2) != null) {
                if (i4 != i3) {
                    list.set(i3, num);
                }
                i3++;
            } else {
                ub = (UB) storeUnknownEnum(i, iIntValue2, ub, unknownFieldSchema);
            }
        }
        if (i3 != size) {
            list.subList(i3, size).clear();
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        return GeneratedMessageV3.class;
    }

    public static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            java.lang.reflect.Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z6) {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z6));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        return UnknownFieldSetSchema.class;
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t6, T t7) {
        FieldSet<T> extensions = extensionSchema.getExtensions(t7);
        if (extensions.isEmpty()) {
            return;
        }
        extensionSchema.getMutableExtensions(t6).mergeFrom(extensions);
    }

    public static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t6, T t7, long j6) {
        UnsafeUtil.putObject(t6, j6, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(t6, j6), UnsafeUtil.getObject(t7, j6)));
    }

    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t6, T t7) {
        unknownFieldSchema.setToMessage(t6, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t6), unknownFieldSchema.getFromMessage(t7)));
    }

    public static UnknownFieldSchema<?, ?> proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean shouldUseTableSwitch(int i, int i3, int i4) {
        if (i3 < 40) {
            return true;
        }
        long j6 = ((long) i3) - ((long) i);
        long j7 = i4;
        return j6 + 10 <= ((j7 + 3) * 3) + ((2 * j7) + 3);
    }

    public static <UT, UB> UB storeUnknownEnum(int i, int i3, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.newBuilder();
        }
        unknownFieldSchema.addVarint(ub, i, i3);
        return ub;
    }

    public static String toCamelCase(String str, boolean z6) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ('a' > cCharAt || cCharAt > 'z') {
                if ('A' > cCharAt || cCharAt > 'Z') {
                    if ('0' <= cCharAt && cCharAt <= '9') {
                        sb.append(cCharAt);
                    }
                    z6 = true;
                } else if (i != 0 || z6) {
                    sb.append(cCharAt);
                } else {
                    sb.append((char) (cCharAt + ' '));
                }
            } else if (z6) {
                sb.append((char) (cCharAt - ' '));
            } else {
                sb.append(cCharAt);
            }
            z6 = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i, boolean z6, Writer writer) {
        if (z6) {
            writer.writeBool(i, true);
        }
    }

    public static void writeBoolList(int i, List<Boolean> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBoolList(i, list, z6);
    }

    public static void writeBytes(int i, ByteString byteString, Writer writer) {
        if (byteString == null || byteString.isEmpty()) {
            return;
        }
        writer.writeBytes(i, byteString);
    }

    public static void writeBytesList(int i, List<ByteString> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBytesList(i, list);
    }

    public static void writeDouble(int i, double d, Writer writer) {
        if (Double.compare(d, 0.0d) != 0) {
            writer.writeDouble(i, d);
        }
    }

    public static void writeDoubleList(int i, List<Double> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeDoubleList(i, list, z6);
    }

    public static void writeEnum(int i, int i3, Writer writer) {
        if (i3 != 0) {
            writer.writeEnum(i, i3);
        }
    }

    public static void writeEnumList(int i, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeEnumList(i, list, z6);
    }

    public static void writeFixed32(int i, int i3, Writer writer) {
        if (i3 != 0) {
            writer.writeFixed32(i, i3);
        }
    }

    public static void writeFixed32List(int i, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed32List(i, list, z6);
    }

    public static void writeFixed64(int i, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeFixed64(i, j6);
        }
    }

    public static void writeFixed64List(int i, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed64List(i, list, z6);
    }

    public static void writeFloat(int i, float f6, Writer writer) {
        if (Float.compare(f6, 0.0f) != 0) {
            writer.writeFloat(i, f6);
        }
    }

    public static void writeFloatList(int i, List<Float> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFloatList(i, list, z6);
    }

    public static void writeGroupList(int i, List<?> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i, list);
    }

    public static void writeInt32(int i, int i3, Writer writer) {
        if (i3 != 0) {
            writer.writeInt32(i, i3);
        }
    }

    public static void writeInt32List(int i, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt32List(i, list, z6);
    }

    public static void writeInt64(int i, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeInt64(i, j6);
        }
    }

    public static void writeInt64List(int i, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt64List(i, list, z6);
    }

    public static void writeLazyFieldList(int i, List<?> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            ((LazyFieldLite) it.next()).writeTo(writer, i);
        }
    }

    public static void writeMessage(int i, Object obj, Writer writer) {
        if (obj != null) {
            writer.writeMessage(i, obj);
        }
    }

    public static void writeMessageList(int i, List<?> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i, list);
    }

    public static void writeSFixed32(int i, int i3, Writer writer) {
        if (i3 != 0) {
            writer.writeSFixed32(i, i3);
        }
    }

    public static void writeSFixed32List(int i, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed32List(i, list, z6);
    }

    public static void writeSFixed64(int i, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeSFixed64(i, j6);
        }
    }

    public static void writeSFixed64List(int i, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed64List(i, list, z6);
    }

    public static void writeSInt32(int i, int i3, Writer writer) {
        if (i3 != 0) {
            writer.writeSInt32(i, i3);
        }
    }

    public static void writeSInt32List(int i, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt32List(i, list, z6);
    }

    public static void writeSInt64(int i, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeSInt64(i, j6);
        }
    }

    public static void writeSInt64List(int i, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt64List(i, list, z6);
    }

    public static void writeString(int i, Object obj, Writer writer) {
        if (obj instanceof String) {
            writeStringInternal(i, (String) obj, writer);
        } else {
            writeBytes(i, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int i, String str, Writer writer) {
        if (str == null || str.isEmpty()) {
            return;
        }
        writer.writeString(i, str);
    }

    public static void writeStringList(int i, List<String> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeStringList(i, list);
    }

    public static void writeUInt32(int i, int i3, Writer writer) {
        if (i3 != 0) {
            writer.writeUInt32(i, i3);
        }
    }

    public static void writeUInt32List(int i, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt32List(i, list, z6);
    }

    public static void writeUInt64(int i, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeUInt64(i, j6);
        }
    }

    public static void writeUInt64List(int i, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt64List(i, list, z6);
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static int computeSizeGroupList(int i, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(i, list.get(i3), schema);
        }
        return iComputeGroupSize;
    }

    public static void writeGroupList(int i, List<?> list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i, list, schema);
    }

    public static void writeMessageList(int i, List<?> list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i, list, schema);
    }

    public static int computeSizeMessageList(int i, List<?> list, Schema schema) {
        int iComputeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof LazyFieldLite) {
                iComputeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                iComputeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            iComputeTagSize = iComputeMessageSizeNoTag + iComputeTagSize;
        }
        return iComputeTagSize;
    }

    public static <UT, UB> UB filterUnknownEnumList(int i, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                Integer num = list.get(i4);
                int iIntValue = num.intValue();
                if (enumVerifier.isInRange(iIntValue)) {
                    if (i4 != i3) {
                        list.set(i3, num);
                    }
                    i3++;
                } else {
                    ub = (UB) storeUnknownEnum(i, iIntValue, ub, unknownFieldSchema);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!enumVerifier.isInRange(iIntValue2)) {
                ub = (UB) storeUnknownEnum(i, iIntValue2, ub, unknownFieldSchema);
                it.remove();
            }
        }
        return ub;
    }
}
