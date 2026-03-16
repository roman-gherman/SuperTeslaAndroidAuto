package com.google.crypto.tink.internal;

import com.google.crypto.tink.b;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.n;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface KeyParser$KeyParsingFunction<SerializationT extends Serialization> {
    b parseKey(SerializationT serializationt, @Nullable n nVar);
}
