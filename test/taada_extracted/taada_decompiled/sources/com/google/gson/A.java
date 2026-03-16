package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public enum A extends D {
    public A() {
        super("LAZILY_PARSED_NUMBER", 1);
    }

    @Override // com.google.gson.ToNumberStrategy
    public final Number readNumber(com.google.gson.stream.b bVar) {
        return new com.google.gson.internal.j(bVar.u());
    }
}
