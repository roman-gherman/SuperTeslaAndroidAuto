package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface Schema<T> {
    boolean equals(T t6, T t7);

    int getSerializedSize(T t6);

    int hashCode(T t6);

    boolean isInitialized(T t6);

    void makeImmutable(T t6);

    void mergeFrom(T t6, Reader reader, D d);

    void mergeFrom(T t6, T t7);

    void mergeFrom(T t6, byte[] bArr, int i, int i3, C0367h c0367h);

    T newInstance();

    void writeTo(T t6, Writer writer);
}
