package org.mockito.configuration;

import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
public interface IMockitoConfiguration {
    boolean cleansStackTrace();

    boolean enableClassCache();

    Answer<Object> getDefaultAnswer();
}
