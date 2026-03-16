package com.google.crypto.tink.proto;

import G0.A1;
import G0.EnumC0052f1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface KeysetInfo$KeyInfoOrBuilder extends MessageLiteOrBuilder {
    int getKeyId();

    A1 getOutputPrefixType();

    int getOutputPrefixTypeValue();

    EnumC0052f1 getStatus();

    int getStatusValue();

    String getTypeUrl();

    AbstractC0381o getTypeUrlBytes();
}
