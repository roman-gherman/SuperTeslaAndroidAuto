package com.google.common.io;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
interface Closer$Suppressor {
    void suppress(Closeable closeable, Throwable th, Throwable th2);
}
