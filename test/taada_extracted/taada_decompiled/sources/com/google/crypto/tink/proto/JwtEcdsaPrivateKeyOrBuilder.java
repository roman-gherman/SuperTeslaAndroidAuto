package com.google.crypto.tink.proto;

import G0.O0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface JwtEcdsaPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    AbstractC0381o getKeyValue();

    O0 getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
