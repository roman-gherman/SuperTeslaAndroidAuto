package org.mockito.stubbing;

import org.mockito.NotExtensible;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface LenientStubber extends BaseStubber {
    <T> OngoingStubbing<T> when(T t6);
}
