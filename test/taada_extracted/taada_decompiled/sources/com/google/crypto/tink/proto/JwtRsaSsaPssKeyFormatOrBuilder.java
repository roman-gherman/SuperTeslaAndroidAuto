package com.google.crypto.tink.proto;

import G0.X0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface JwtRsaSsaPssKeyFormatOrBuilder extends MessageLiteOrBuilder {
    X0 getAlgorithm();

    int getAlgorithmValue();

    int getModulusSizeInBits();

    AbstractC0381o getPublicExponent();

    int getVersion();
}
