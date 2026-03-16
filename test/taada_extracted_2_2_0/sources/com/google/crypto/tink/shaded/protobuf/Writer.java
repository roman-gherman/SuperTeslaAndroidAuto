package com.google.crypto.tink.shaded.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface Writer {
    e1 fieldOrder();

    void writeBool(int i, boolean z6);

    void writeBoolList(int i, List<Boolean> list, boolean z6);

    void writeBytes(int i, AbstractC0381o abstractC0381o);

    void writeBytesList(int i, List<AbstractC0381o> list);

    void writeDouble(int i, double d);

    void writeDoubleList(int i, List<Double> list, boolean z6);

    @Deprecated
    void writeEndGroup(int i);

    void writeEnum(int i, int i3);

    void writeEnumList(int i, List<Integer> list, boolean z6);

    void writeFixed32(int i, int i3);

    void writeFixed32List(int i, List<Integer> list, boolean z6);

    void writeFixed64(int i, long j6);

    void writeFixed64List(int i, List<Long> list, boolean z6);

    void writeFloat(int i, float f6);

    void writeFloatList(int i, List<Float> list, boolean z6);

    @Deprecated
    void writeGroup(int i, Object obj);

    @Deprecated
    void writeGroup(int i, Object obj, Schema schema);

    @Deprecated
    void writeGroupList(int i, List<?> list);

    @Deprecated
    void writeGroupList(int i, List<?> list, Schema schema);

    void writeInt32(int i, int i3);

    void writeInt32List(int i, List<Integer> list, boolean z6);

    void writeInt64(int i, long j6);

    void writeInt64List(int i, List<Long> list, boolean z6);

    <K, V> void writeMap(int i, C0364f0 c0364f0, Map<K, V> map);

    void writeMessage(int i, Object obj);

    void writeMessage(int i, Object obj, Schema schema);

    void writeMessageList(int i, List<?> list);

    void writeMessageList(int i, List<?> list, Schema schema);

    void writeMessageSetItem(int i, Object obj);

    void writeSFixed32(int i, int i3);

    void writeSFixed32List(int i, List<Integer> list, boolean z6);

    void writeSFixed64(int i, long j6);

    void writeSFixed64List(int i, List<Long> list, boolean z6);

    void writeSInt32(int i, int i3);

    void writeSInt32List(int i, List<Integer> list, boolean z6);

    void writeSInt64(int i, long j6);

    void writeSInt64List(int i, List<Long> list, boolean z6);

    @Deprecated
    void writeStartGroup(int i);

    void writeString(int i, String str);

    void writeStringList(int i, List<String> list);

    void writeUInt32(int i, int i3);

    void writeUInt32List(int i, List<Integer> list, boolean z6);

    void writeUInt64(int i, long j6);

    void writeUInt64List(int i, List<Long> list, boolean z6);
}
