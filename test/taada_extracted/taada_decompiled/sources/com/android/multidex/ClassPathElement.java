package com.android.multidex;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
interface ClassPathElement {
    public static final char SEPARATOR_CHAR = '/';

    void close();

    Iterable<String> list();

    InputStream open(String str);
}
