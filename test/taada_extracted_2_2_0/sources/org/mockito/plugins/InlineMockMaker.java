package org.mockito.plugins;

/* JADX INFO: loaded from: classes.dex */
public interface InlineMockMaker extends MockMaker {
    void clearAllMocks();

    void clearMock(Object obj);
}
