package org.mockito.session;

import org.mockito.MockitoSession;
import org.mockito.NotExtensible;
import org.mockito.quality.Strictness;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface MockitoSessionBuilder {
    MockitoSessionBuilder initMocks(Object obj);

    MockitoSessionBuilder initMocks(Object... objArr);

    MockitoSessionBuilder logger(MockitoSessionLogger mockitoSessionLogger);

    MockitoSessionBuilder name(String str);

    MockitoSession startMocking();

    MockitoSessionBuilder strictness(Strictness strictness);
}
