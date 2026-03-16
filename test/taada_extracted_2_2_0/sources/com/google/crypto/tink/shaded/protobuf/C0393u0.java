package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0393u0 {
    public static final C0393u0 c = new C0393u0();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0400y f2920a = new C0400y();

    public final Schema a(Class cls) {
        T.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.b;
        Schema schemaCreateSchema = (Schema) concurrentHashMap.get(cls);
        if (schemaCreateSchema == null) {
            schemaCreateSchema = this.f2920a.createSchema(cls);
            Schema schema = (Schema) concurrentHashMap.putIfAbsent(cls, schemaCreateSchema);
            if (schema != null) {
                return schema;
            }
        }
        return schemaCreateSchema;
    }
}
