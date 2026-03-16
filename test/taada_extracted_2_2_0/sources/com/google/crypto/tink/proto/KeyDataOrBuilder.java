package com.google.crypto.tink.proto;

import G0.EnumC0046d1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface KeyDataOrBuilder extends MessageLiteOrBuilder {
    EnumC0046d1 getKeyMaterialType();

    int getKeyMaterialTypeValue();

    String getTypeUrl();

    AbstractC0381o getTypeUrlBytes();

    AbstractC0381o getValue();
}
