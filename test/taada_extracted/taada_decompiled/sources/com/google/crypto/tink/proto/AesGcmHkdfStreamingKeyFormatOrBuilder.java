package com.google.crypto.tink.proto;

import G0.H;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface AesGcmHkdfStreamingKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    H getParams();

    int getVersion();

    boolean hasParams();
}
