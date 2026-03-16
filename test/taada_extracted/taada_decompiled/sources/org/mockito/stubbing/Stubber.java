package org.mockito.stubbing;

import org.mockito.NotExtensible;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface Stubber extends BaseStubber {
    <T> T when(T t6);
}
