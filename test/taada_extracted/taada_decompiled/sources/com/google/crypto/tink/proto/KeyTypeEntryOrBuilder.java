package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface KeyTypeEntryOrBuilder extends MessageLiteOrBuilder {
    String getCatalogueName();

    AbstractC0381o getCatalogueNameBytes();

    int getKeyManagerVersion();

    boolean getNewKeyAllowed();

    String getPrimitiveName();

    AbstractC0381o getPrimitiveNameBytes();

    String getTypeUrl();

    AbstractC0381o getTypeUrlBytes();
}
