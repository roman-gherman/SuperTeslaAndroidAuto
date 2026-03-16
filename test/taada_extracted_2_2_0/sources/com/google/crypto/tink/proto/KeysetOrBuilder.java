package com.google.crypto.tink.proto;

import G0.C0073m1;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface KeysetOrBuilder extends MessageLiteOrBuilder {
    C0073m1 getKey(int i);

    int getKeyCount();

    List<C0073m1> getKeyList();

    int getPrimaryKeyId();
}
