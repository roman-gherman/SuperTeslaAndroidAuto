package com.google.crypto.tink.proto;

import G0.H;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface AesGcmHkdfStreamingKeyOrBuilder extends MessageLiteOrBuilder {
    AbstractC0381o getKeyValue();

    H getParams();

    int getVersion();

    boolean hasParams();
}
