package com.google.crypto.tink.proto;

import G0.K1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface RsaSsaPssPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    AbstractC0381o getCrt();

    AbstractC0381o getD();

    AbstractC0381o getDp();

    AbstractC0381o getDq();

    AbstractC0381o getP();

    K1 getPublicKey();

    AbstractC0381o getQ();

    int getVersion();

    boolean hasPublicKey();
}
