package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MethodOrBuilder extends MessageLiteOrBuilder {
    String getName();

    AbstractC0381o getNameBytes();

    C0389s0 getOptions(int i);

    int getOptionsCount();

    List<C0389s0> getOptionsList();

    boolean getRequestStreaming();

    String getRequestTypeUrl();

    AbstractC0381o getRequestTypeUrlBytes();

    boolean getResponseStreaming();

    String getResponseTypeUrl();

    AbstractC0381o getResponseTypeUrlBytes();

    H0 getSyntax();

    int getSyntaxValue();
}
