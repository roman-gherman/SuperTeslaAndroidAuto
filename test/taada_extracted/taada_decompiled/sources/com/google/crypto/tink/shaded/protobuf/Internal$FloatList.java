package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface Internal$FloatList extends Internal$ProtobufList<Float> {
    void addFloat(float f6);

    float getFloat(int i);

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    Internal$ProtobufList<Float> mutableCopyWithCapacity2(int i);

    float setFloat(int i, float f6);
}
