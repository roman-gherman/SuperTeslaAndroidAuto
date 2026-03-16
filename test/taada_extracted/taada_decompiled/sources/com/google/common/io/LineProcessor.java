package com.google.common.io;

/* JADX INFO: loaded from: classes.dex */
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str);
}
