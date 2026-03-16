package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public enum z extends D {
    public z() {
        super("DOUBLE", 0);
    }

    @Override // com.google.gson.ToNumberStrategy
    public final Number readNumber(com.google.gson.stream.b bVar) {
        return Double.valueOf(bVar.n());
    }
}
