package com.google.crypto.tink.proto;

import G0.P0;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface JwtHmacKeyFormatOrBuilder extends MessageLiteOrBuilder {
    P0 getAlgorithm();

    int getAlgorithmValue();

    int getKeySize();

    int getVersion();
}
