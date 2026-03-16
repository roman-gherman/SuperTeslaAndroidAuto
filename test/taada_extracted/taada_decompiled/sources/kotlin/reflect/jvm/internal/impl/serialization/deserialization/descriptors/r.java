package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(StorageManager storageManager, Function0 function0) {
        super(storageManager, function0);
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean isEmpty() {
        return false;
    }
}
