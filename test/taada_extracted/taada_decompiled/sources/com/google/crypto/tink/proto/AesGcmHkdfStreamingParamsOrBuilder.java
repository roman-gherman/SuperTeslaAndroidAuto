package com.google.crypto.tink.proto;

import G0.EnumC0086s0;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface AesGcmHkdfStreamingParamsOrBuilder extends MessageLiteOrBuilder {
    int getCiphertextSegmentSize();

    int getDerivedKeySize();

    EnumC0086s0 getHkdfHashType();

    int getHkdfHashTypeValue();
}
