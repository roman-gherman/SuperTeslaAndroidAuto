package com.google.crypto.tink.proto;

import G0.C0045d0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface EcdsaPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    AbstractC0381o getKeyValue();

    C0045d0 getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
