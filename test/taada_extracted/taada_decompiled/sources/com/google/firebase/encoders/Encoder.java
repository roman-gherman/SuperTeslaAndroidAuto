package com.google.firebase.encoders;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public interface Encoder<TValue, TContext> {
    void encode(TValue tvalue, TContext tcontext);
}
