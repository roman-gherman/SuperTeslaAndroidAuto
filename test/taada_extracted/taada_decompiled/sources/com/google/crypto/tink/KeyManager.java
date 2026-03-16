package com.google.crypto.tink;

import G0.C0049e1;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLite;

/* JADX INFO: loaded from: classes.dex */
public interface KeyManager<P> {
    boolean doesSupport(String str);

    String getKeyType();

    P getPrimitive(MessageLite messageLite);

    P getPrimitive(AbstractC0381o abstractC0381o);

    Class<P> getPrimitiveClass();

    int getVersion();

    MessageLite newKey(MessageLite messageLite);

    MessageLite newKey(AbstractC0381o abstractC0381o);

    C0049e1 newKeyData(AbstractC0381o abstractC0381o);
}
