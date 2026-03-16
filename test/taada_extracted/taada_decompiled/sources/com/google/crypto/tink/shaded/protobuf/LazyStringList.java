package com.google.crypto.tink.shaded.protobuf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(AbstractC0381o abstractC0381o);

    void add(byte[] bArr);

    boolean addAllByteArray(Collection<byte[]> collection);

    boolean addAllByteString(Collection<? extends AbstractC0381o> collection);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int i);

    AbstractC0381o getByteString(int i);

    Object getRaw(int i);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList lazyStringList);

    void set(int i, AbstractC0381o abstractC0381o);

    void set(int i, byte[] bArr);
}
