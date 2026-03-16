package com.google.crypto.tink.proto;

import G0.C0078o0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface Ed25519PrivateKeyOrBuilder extends MessageLiteOrBuilder {
    AbstractC0381o getKeyValue();

    C0078o0 getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
