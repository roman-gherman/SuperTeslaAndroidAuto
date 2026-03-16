package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface TypeOrBuilder extends MessageLiteOrBuilder {
    J getFields(int i);

    int getFieldsCount();

    List<J> getFieldsList();

    String getName();

    AbstractC0381o getNameBytes();

    String getOneofs(int i);

    AbstractC0381o getOneofsBytes(int i);

    int getOneofsCount();

    List<String> getOneofsList();

    C0389s0 getOptions(int i);

    int getOptionsCount();

    List<C0389s0> getOptionsList();

    E0 getSourceContext();

    H0 getSyntax();

    int getSyntaxValue();

    boolean hasSourceContext();
}
