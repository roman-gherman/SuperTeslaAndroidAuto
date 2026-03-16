package com.google.crypto.tink.proto;

import G0.P0;
import G0.R0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface JwtHmacKeyOrBuilder extends MessageLiteOrBuilder {
    P0 getAlgorithm();

    int getAlgorithmValue();

    R0 getCustomKid();

    AbstractC0381o getKeyValue();

    int getVersion();

    boolean hasCustomKid();
}
