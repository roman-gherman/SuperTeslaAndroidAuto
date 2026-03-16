package com.google.crypto.tink.internal;

import com.google.crypto.tink.i;
import com.google.crypto.tink.internal.Serialization;

/* JADX INFO: loaded from: classes.dex */
public interface ParametersParser$ParametersParsingFunction<SerializationT extends Serialization> {
    i parseParameters(SerializationT serializationt);
}
