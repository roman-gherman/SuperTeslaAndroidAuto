package com.google.crypto.tink.proto;

import G0.C0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface HmacPrfKeyOrBuilder extends MessageLiteOrBuilder {
    AbstractC0381o getKeyValue();

    C0 getParams();

    int getVersion();

    boolean hasParams();
}
