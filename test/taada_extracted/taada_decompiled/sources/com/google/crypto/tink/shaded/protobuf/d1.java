package com.google.crypto.tink.shaded.protobuf;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public enum d1 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(AbstractC0381o.b),
    ENUM(null),
    MESSAGE(null);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f2874a;

    d1(Serializable serializable) {
        this.f2874a = serializable;
    }
}
