package org.mockito.internal.util;

import org.mockito.plugins.MockitoLogger;

/* JADX INFO: loaded from: classes.dex */
public class ConsoleMockitoLogger implements MockitoLogger {
    @Override // org.mockito.plugins.MockitoLogger
    public void log(Object obj) {
        System.out.println(obj);
    }
}
