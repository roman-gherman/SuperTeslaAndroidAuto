package com.google.crypto.tink.shaded.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface StructOrBuilder extends MessageLiteOrBuilder {
    boolean containsFields(String str);

    @Deprecated
    Map<String, X0> getFields();

    int getFieldsCount();

    Map<String, X0> getFieldsMap();

    X0 getFieldsOrDefault(String str, X0 x02);

    X0 getFieldsOrThrow(String str);
}
