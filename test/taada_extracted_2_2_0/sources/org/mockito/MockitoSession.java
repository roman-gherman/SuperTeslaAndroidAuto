package org.mockito;

import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface MockitoSession {
    void finishMocking();

    void finishMocking(Throwable th);

    void setStrictness(Strictness strictness);
}
