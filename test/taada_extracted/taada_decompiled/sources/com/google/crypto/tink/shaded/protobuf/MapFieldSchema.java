package com.google.crypto.tink.shaded.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface MapFieldSchema {
    Map<?, ?> forMapData(Object obj);

    C0364f0 forMapMetadata(Object obj);

    Map<?, ?> forMutableMapData(Object obj);

    int getSerializedSize(int i, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    Object newMapField(Object obj);

    Object toImmutable(Object obj);
}
