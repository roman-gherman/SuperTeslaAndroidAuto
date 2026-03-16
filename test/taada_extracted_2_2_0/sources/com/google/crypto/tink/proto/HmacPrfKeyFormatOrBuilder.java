package com.google.crypto.tink.proto;

import G0.C0;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface HmacPrfKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    C0 getParams();

    int getVersion();

    boolean hasParams();
}
