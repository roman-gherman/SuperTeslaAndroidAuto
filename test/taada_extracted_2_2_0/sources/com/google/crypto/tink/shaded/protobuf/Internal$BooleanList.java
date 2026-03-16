package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public interface Internal$BooleanList extends Internal$ProtobufList<Boolean> {
    void addBoolean(boolean z6);

    boolean getBoolean(int i);

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList
    /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: merged with bridge method [inline-methods] */
    Internal$ProtobufList<Boolean> mutableCopyWithCapacity2(int i);

    boolean setBoolean(int i, boolean z6);
}
