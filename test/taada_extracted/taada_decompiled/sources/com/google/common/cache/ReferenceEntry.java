package com.google.common.cache;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
interface ReferenceEntry<K, V> {
    long getAccessTime();

    int getHash();

    @NullableDecl
    K getKey();

    @NullableDecl
    ReferenceEntry<K, V> getNext();

    ReferenceEntry<K, V> getNextInAccessQueue();

    ReferenceEntry<K, V> getNextInWriteQueue();

    ReferenceEntry<K, V> getPreviousInAccessQueue();

    ReferenceEntry<K, V> getPreviousInWriteQueue();

    LocalCache$ValueReference<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long j6);

    void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry);

    void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry);

    void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry);

    void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry);

    void setValueReference(LocalCache$ValueReference<K, V> localCache$ValueReference);

    void setWriteTime(long j6);
}
