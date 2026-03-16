package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i, boolean z6, V v6, MapEntryLite.Metadata<Boolean, V> metadata) {
        this.output.writeTag(i, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z6), v6));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z6), v6);
    }

    private <V> void writeDeterministicIntegerMap(int i, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = it.next().intValue();
            i3++;
        }
        Arrays.sort(iArr);
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            V v6 = map.get(Integer.valueOf(i5));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i5), v6));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i5), v6);
        }
    }

    private <V> void writeDeterministicLongMap(int i, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            jArr[i3] = it.next().longValue();
            i3++;
        }
        Arrays.sort(jArr);
        for (int i4 = 0; i4 < size; i4++) {
            long j6 = jArr[i4];
            V v6 = map.get(Long.valueOf(j6));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j6), v6));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j6), v6);
        }
    }

    private <K, V> void writeDeterministicMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v6 = map.get(Boolean.FALSE);
                if (v6 != null) {
                    writeDeterministicBooleanMapEntry(i, false, v6, metadata);
                }
                V v7 = map.get(Boolean.TRUE);
                if (v7 != null) {
                    writeDeterministicBooleanMapEntry(i, true, v7, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            strArr[i3] = it.next();
            i3++;
        }
        Arrays.sort(strArr);
        for (int i4 = 0; i4 < size; i4++) {
            String str = strArr[i4];
            V v6 = map.get(str);
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v6));
            MapEntryLite.writeTo(this.output, metadata, str, v6);
        }
    }

    private void writeLazyString(int i, Object obj) {
        if (obj instanceof String) {
            this.output.writeString(i, (String) obj);
        } else {
            this.output.writeBytes(i, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int i, boolean z6) {
        this.output.writeBool(i, z6);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int i, List<Boolean> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeBool(i, list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeBoolSizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(list.get(i4).booleanValue());
        }
        this.output.writeUInt32NoTag(iComputeBoolSizeNoTag);
        while (i3 < list.size()) {
            this.output.writeBoolNoTag(list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int i, ByteString byteString) {
        this.output.writeBytes(i, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int i, List<ByteString> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.output.writeBytes(i, list.get(i3));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int i, double d) {
        this.output.writeDouble(i, d);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int i, List<Double> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeDouble(i, list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeDoubleSizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(list.get(i4).doubleValue());
        }
        this.output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
        while (i3 < list.size()) {
            this.output.writeDoubleNoTag(list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeEndGroup(int i) {
        this.output.writeTag(i, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int i, int i3) {
        this.output.writeEnum(i, i3);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int i, List<Integer> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeEnum(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeEnumSizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(iComputeEnumSizeNoTag);
        while (i3 < list.size()) {
            this.output.writeEnumNoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int i, int i3) {
        this.output.writeFixed32(i, i3);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int i, List<Integer> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeFixed32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeFixed32SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeFixed32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int i, long j6) {
        this.output.writeFixed64(i, j6);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int i, List<Long> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeFixed64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeFixed64SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeFixed64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int i, float f6) {
        this.output.writeFloat(i, f6);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int i, List<Float> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeFloat(i, list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeFloatSizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(list.get(i4).floatValue());
        }
        this.output.writeUInt32NoTag(iComputeFloatSizeNoTag);
        while (i3 < list.size()) {
            this.output.writeFloatNoTag(list.get(i3).floatValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int i, Object obj) {
        this.output.writeGroup(i, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int i, List<?> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeGroup(i, list.get(i3));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int i, int i3) {
        this.output.writeInt32(i, i3);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int i, List<Integer> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeInt32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(iComputeInt32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeInt32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int i, long j6) {
        this.output.writeInt64(i, j6);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int i, List<Long> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeInt64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeInt64SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(iComputeInt64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeInt64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i, Object obj) {
        this.output.writeMessage(i, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i, List<?> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeMessage(i, list.get(i3));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i, Object obj) {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int i, int i3) {
        this.output.writeSFixed32(i, i3);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int i, List<Integer> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeSFixed32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeSFixed32SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeSFixed32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int i, long j6) {
        this.output.writeSFixed64(i, j6);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int i, List<Long> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeSFixed64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeSFixed64SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeSFixed64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int i, int i3) {
        this.output.writeSInt32(i, i3);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int i, List<Integer> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeSInt32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeSInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeSInt32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int i, long j6) {
        this.output.writeSInt64(i, j6);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int i, List<Long> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeSInt64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeSInt64SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeSInt64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeStartGroup(int i) {
        this.output.writeTag(i, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int i, String str) {
        this.output.writeString(i, str);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int i, List<String> list) {
        int i3 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i3 < list.size()) {
                this.output.writeString(i, list.get(i3));
                i3++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i3 < list.size()) {
                writeLazyString(i, lazyStringList.getRaw(i3));
                i3++;
            }
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int i, int i3) {
        this.output.writeUInt32(i, i3);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int i, List<Integer> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeUInt32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeUInt32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int i, long j6) {
        this.output.writeUInt64(i, j6);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int i, List<Long> list, boolean z6) {
        int i3 = 0;
        if (!z6) {
            while (i3 < list.size()) {
                this.output.writeUInt64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeUInt64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int i, Object obj, Schema schema) {
        this.output.writeGroup(i, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i, Object obj, Schema schema) {
        this.output.writeMessage(i, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int i, List<?> list, Schema schema) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeGroup(i, list.get(i3), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i, List<?> list, Schema schema) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeMessage(i, list.get(i3), schema);
        }
    }
}
