package com.google.crypto.tink.proto;

import G0.C0037a1;
import G0.X0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface JwtRsaSsaPssPublicKeyOrBuilder extends MessageLiteOrBuilder {
    X0 getAlgorithm();

    int getAlgorithmValue();

    C0037a1 getCustomKid();

    AbstractC0381o getE();

    AbstractC0381o getN();

    int getVersion();

    boolean hasCustomKid();
}
