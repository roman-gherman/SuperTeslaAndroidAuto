package com.google.crypto.tink.proto;

import G0.C0094w0;
import G0.r;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface AesCtrHmacAeadKeyOrBuilder extends MessageLiteOrBuilder {
    r getAesCtrKey();

    C0094w0 getHmacKey();

    int getVersion();

    boolean hasAesCtrKey();

    boolean hasHmacKey();
}
