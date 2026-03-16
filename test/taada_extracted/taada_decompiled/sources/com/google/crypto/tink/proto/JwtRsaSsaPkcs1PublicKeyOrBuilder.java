package com.google.crypto.tink.proto;

import G0.S0;
import G0.V0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface JwtRsaSsaPkcs1PublicKeyOrBuilder extends MessageLiteOrBuilder {
    S0 getAlgorithm();

    int getAlgorithmValue();

    V0 getCustomKid();

    AbstractC0381o getE();

    AbstractC0381o getN();

    int getVersion();

    boolean hasCustomKid();
}
