package com.google.crypto.tink.proto;

import G0.q1;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface KeysetInfoOrBuilder extends MessageLiteOrBuilder {
    q1 getKeyInfo(int i);

    int getKeyInfoCount();

    List<q1> getKeyInfoList();

    int getPrimaryKeyId();
}
