package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface Internal$IntList extends Internal$ProtobufList<Integer> {
    void addInt(int i);

    int getInt(int i);

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    Internal$ProtobufList<Integer> mutableCopyWithCapacity2(int i);

    int setInt(int i, int i3);
}
