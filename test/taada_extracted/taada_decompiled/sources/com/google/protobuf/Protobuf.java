package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        int schemaSize = 0;
        for (Schema<?> schema : this.schemaCache.values()) {
            if (schema instanceof MessageSchema) {
                schemaSize += ((MessageSchema) schema).getSchemaSize();
            }
        }
        return schemaSize;
    }

    public <T> boolean isInitialized(T t6) {
        return schemaFor(t6).isInitialized(t6);
    }

    public <T> void makeImmutable(T t6) {
        schemaFor(t6).makeImmutable(t6);
    }

    public <T> void mergeFrom(T t6, Reader reader) {
        mergeFrom(t6, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schemaCreateSchema = (Schema) this.schemaCache.get(cls);
        if (schemaCreateSchema == null) {
            schemaCreateSchema = this.schemaFactory.createSchema(cls);
            Schema<T> schema = (Schema<T>) registerSchema(cls, schemaCreateSchema);
            if (schema != null) {
                return schema;
            }
        }
        return schemaCreateSchema;
    }

    public <T> void writeTo(T t6, Writer writer) {
        schemaFor(t6).writeTo(t6, writer);
    }

    public <T> void mergeFrom(T t6, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        schemaFor(t6).mergeFrom(t6, reader, extensionRegistryLite);
    }

    public <T> Schema<T> schemaFor(T t6) {
        return schemaFor((Class) t6.getClass());
    }
}
