package com.google.crypto.tink.proto;

import G0.E1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface RsaSsaPkcs1KeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getModulusSizeInBits();

    E1 getParams();

    AbstractC0381o getPublicExponent();

    boolean hasParams();
}
