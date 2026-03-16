package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public String a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.c cVar = new com.google.gson.stream.c(stringWriter);
            cVar.f3058f = true;
            M0.v vVar = M0.y.f1025a;
            M0.u.d(cVar, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
