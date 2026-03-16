package com.google.crypto.tink.proto;

import G0.C0064j1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface RegistryConfigOrBuilder extends MessageLiteOrBuilder {
    String getConfigName();

    AbstractC0381o getConfigNameBytes();

    C0064j1 getEntry(int i);

    int getEntryCount();

    List<C0064j1> getEntryList();
}
