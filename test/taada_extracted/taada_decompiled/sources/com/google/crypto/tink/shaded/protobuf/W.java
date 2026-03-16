package com.google.crypto.tink.shaded.protobuf;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public enum W {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(AbstractC0381o.class, AbstractC0381o.b),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f2858a;

    W(Class cls, Serializable serializable) {
        this.f2858a = serializable;
    }
}
