package com.google.common.io;

/* JADX INFO: loaded from: classes.dex */
public interface ByteProcessor<T> {
    T getResult();

    boolean processBytes(byte[] bArr, int i, int i3);
}
