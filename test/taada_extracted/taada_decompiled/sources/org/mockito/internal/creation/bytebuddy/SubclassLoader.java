package org.mockito.internal.creation.bytebuddy;

import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;

/* JADX INFO: loaded from: classes.dex */
public interface SubclassLoader {
    boolean isDisrespectingOpenness();

    ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z6);
}
