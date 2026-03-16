package com.google.crypto.tink.internal;

import com.google.crypto.tink.i;
import com.google.crypto.tink.internal.Serialization;

/* JADX INFO: loaded from: classes.dex */
public interface ParametersSerializer$ParametersSerializationFunction<ParametersT extends i, SerializationT extends Serialization> {
    SerializationT serializeParameters(ParametersT parameterst);
}
