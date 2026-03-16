package com.google.android.datatransport;

import k.C0569b;

/* JADX INFO: loaded from: classes.dex */
public interface TransportFactory {
    @Deprecated
    <T> Transport<T> getTransport(String str, Class<T> cls, Transformer<T, byte[]> transformer);

    <T> Transport<T> getTransport(String str, Class<T> cls, C0569b c0569b, Transformer<T, byte[]> transformer);
}
