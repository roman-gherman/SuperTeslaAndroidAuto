package com.google.crypto.tink.proto;

import G0.A1;
import G0.C0049e1;
import G0.EnumC0052f1;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface Keyset$KeyOrBuilder extends MessageLiteOrBuilder {
    C0049e1 getKeyData();

    int getKeyId();

    A1 getOutputPrefixType();

    int getOutputPrefixTypeValue();

    EnumC0052f1 getStatus();

    int getStatusValue();

    boolean hasKeyData();
}
