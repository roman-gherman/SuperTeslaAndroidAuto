package org.mockito.creation.instance;

/* JADX INFO: loaded from: classes.dex */
public interface Instantiator {
    <T> T newInstance(Class<T> cls);
}
