package org.mockito.creation.instance;

import org.mockito.exceptions.base.MockitoException;

/* JADX INFO: loaded from: classes.dex */
public class InstantiationException extends MockitoException {
    public InstantiationException(String str) {
        super(str);
    }

    public InstantiationException(String str, Throwable th) {
        super(str, th);
    }
}
