package com.google.crypto.tink.internal;

import com.google.crypto.tink.b;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.n;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface KeySerializer$KeySerializationFunction<KeyT extends b, SerializationT extends Serialization> {
    SerializationT serializeKey(KeyT keyt, @Nullable n nVar);
}
