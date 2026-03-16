package com.google.gson;

import java.lang.reflect.Field;

/* JADX INFO: renamed from: com.google.gson.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum C0408b extends i {
    public C0408b() {
        super("IDENTITY", 0);
    }

    @Override // com.google.gson.FieldNamingStrategy
    public final String translateName(Field field) {
        return field.getName();
    }
}
