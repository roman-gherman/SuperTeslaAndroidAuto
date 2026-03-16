package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface Internal$DoubleList extends Internal$ProtobufList<Double> {
    void addDouble(double d);

    double getDouble(int i);

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity */
    Internal$ProtobufList<Double> mutableCopyWithCapacity2(int i);

    double setDouble(int i, double d);
}
