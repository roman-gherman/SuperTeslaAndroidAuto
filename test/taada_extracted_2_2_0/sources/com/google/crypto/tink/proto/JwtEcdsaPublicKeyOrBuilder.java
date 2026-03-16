package com.google.crypto.tink.proto;

import G0.K0;
import G0.N0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface JwtEcdsaPublicKeyOrBuilder extends MessageLiteOrBuilder {
    K0 getAlgorithm();

    int getAlgorithmValue();

    N0 getCustomKid();

    int getVersion();

    AbstractC0381o getX();

    AbstractC0381o getY();

    boolean hasCustomKid();
}
