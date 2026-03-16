package com.google.crypto.tink.proto;

import G0.I1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface RsaSsaPssKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getModulusSizeInBits();

    I1 getParams();

    AbstractC0381o getPublicExponent();

    boolean hasParams();
}
