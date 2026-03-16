package com.google.crypto.tink.subtle;

import java.security.Provider;

/* JADX INFO: loaded from: classes.dex */
public interface EngineWrapper<T> {
    T getInstance(String str, Provider provider);
}
