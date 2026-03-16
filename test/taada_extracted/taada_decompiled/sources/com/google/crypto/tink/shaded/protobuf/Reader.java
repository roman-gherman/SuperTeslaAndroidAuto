package com.google.crypto.tink.shaded.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface Reader {
    public static final int READ_DONE = Integer.MAX_VALUE;
    public static final int TAG_UNKNOWN = 0;

    int getFieldNumber();

    int getTag();

    <T> void mergeGroupField(T t6, Schema<T> schema, D d);

    <T> void mergeMessageField(T t6, Schema<T> schema, D d);

    boolean readBool();

    void readBoolList(List<Boolean> list);

    AbstractC0381o readBytes();

    void readBytesList(List<AbstractC0381o> list);

    double readDouble();

    void readDoubleList(List<Double> list);

    int readEnum();

    void readEnumList(List<Integer> list);

    int readFixed32();

    void readFixed32List(List<Integer> list);

    long readFixed64();

    void readFixed64List(List<Long> list);

    float readFloat();

    void readFloatList(List<Float> list);

    @Deprecated
    <T> T readGroup(Class<T> cls, D d);

    @Deprecated
    <T> T readGroupBySchemaWithCheck(Schema<T> schema, D d);

    @Deprecated
    <T> void readGroupList(List<T> list, Schema<T> schema, D d);

    @Deprecated
    <T> void readGroupList(List<T> list, Class<T> cls, D d);

    int readInt32();

    void readInt32List(List<Integer> list);

    long readInt64();

    void readInt64List(List<Long> list);

    <K, V> void readMap(Map<K, V> map, C0364f0 c0364f0, D d);

    <T> T readMessage(Class<T> cls, D d);

    <T> T readMessageBySchemaWithCheck(Schema<T> schema, D d);

    <T> void readMessageList(List<T> list, Schema<T> schema, D d);

    <T> void readMessageList(List<T> list, Class<T> cls, D d);

    int readSFixed32();

    void readSFixed32List(List<Integer> list);

    long readSFixed64();

    void readSFixed64List(List<Long> list);

    int readSInt32();

    void readSInt32List(List<Integer> list);

    long readSInt64();

    void readSInt64List(List<Long> list);

    String readString();

    void readStringList(List<String> list);

    void readStringListRequireUtf8(List<String> list);

    String readStringRequireUtf8();

    int readUInt32();

    void readUInt32List(List<Integer> list);

    long readUInt64();

    void readUInt64List(List<Long> list);

    boolean shouldDiscardUnknownFields();

    boolean skipField();
}
