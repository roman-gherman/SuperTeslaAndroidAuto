package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.gson.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0407a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f2991a;

    public C0407a(Field field) {
        Objects.requireNonNull(field);
        this.f2991a = field;
    }

    public final String toString() {
        return this.f2991a.toString();
    }
}
