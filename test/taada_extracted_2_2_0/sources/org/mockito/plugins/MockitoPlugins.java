package org.mockito.plugins;

/* JADX INFO: loaded from: classes.dex */
public interface MockitoPlugins {
    <T> T getDefaultPlugin(Class<T> cls);

    MockMaker getInlineMockMaker();
}
