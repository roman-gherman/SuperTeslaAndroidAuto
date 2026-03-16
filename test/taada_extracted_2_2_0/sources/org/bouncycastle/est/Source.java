package org.bouncycastle.est;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface Source<T> {
    void close();

    InputStream getInputStream();

    OutputStream getOutputStream();

    T getSession();
}
