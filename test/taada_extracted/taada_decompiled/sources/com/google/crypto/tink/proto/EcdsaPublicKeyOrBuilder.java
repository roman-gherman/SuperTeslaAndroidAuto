package com.google.crypto.tink.proto;

import G0.C0039b0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface EcdsaPublicKeyOrBuilder extends MessageLiteOrBuilder {
    C0039b0 getParams();

    int getVersion();

    AbstractC0381o getX();

    AbstractC0381o getY();

    boolean hasParams();
}
