package com.google.crypto.tink.proto;

import G0.EnumC0086s0;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface RsaSsaPssParamsOrBuilder extends MessageLiteOrBuilder {
    EnumC0086s0 getMgf1Hash();

    int getMgf1HashValue();

    int getSaltLength();

    EnumC0086s0 getSigHash();

    int getSigHashValue();
}
