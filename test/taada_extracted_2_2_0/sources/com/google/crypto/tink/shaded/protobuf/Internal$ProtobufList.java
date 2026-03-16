package com.google.crypto.tink.shaded.protobuf;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public interface Internal$ProtobufList<E> extends List<E>, RandomAccess {
    boolean isModifiable();

    void makeImmutable();

    Internal$ProtobufList<E> mutableCopyWithCapacity(int i);
}
