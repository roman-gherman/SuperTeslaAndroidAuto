package com.google.crypto.tink.proto;

import G0.E1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface RsaSsaPkcs1PublicKeyOrBuilder extends MessageLiteOrBuilder {
    AbstractC0381o getE();

    AbstractC0381o getN();

    E1 getParams();

    int getVersion();

    boolean hasParams();
}
