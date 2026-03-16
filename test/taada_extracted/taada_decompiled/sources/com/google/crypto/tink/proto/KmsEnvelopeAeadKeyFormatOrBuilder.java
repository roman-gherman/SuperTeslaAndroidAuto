package com.google.crypto.tink.proto;

import G0.C0058h1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface KmsEnvelopeAeadKeyFormatOrBuilder extends MessageLiteOrBuilder {
    C0058h1 getDekTemplate();

    String getKekUri();

    AbstractC0381o getKekUriBytes();

    boolean hasDekTemplate();
}
