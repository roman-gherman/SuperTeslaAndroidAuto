package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
interface KeyManagerRegistry$KeyManagerContainer {
    Class<?> getImplementingClass();

    <P> KeyManager<P> getKeyManager(Class<P> cls);

    KeyManager<?> getUntypedKeyManager();

    MessageLite parseKey(AbstractC0381o abstractC0381o);

    Class<?> publicKeyManagerClassOrNull();

    Set<Class<?>> supportedPrimitives();
}
