package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface Internal$LongList extends Internal$ProtobufList<Long> {
    void addLong(long j6);

    long getLong(int i);

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    Internal$ProtobufList<Long> mutableCopyWithCapacity2(int i);

    long setLong(int i, long j6);
}
