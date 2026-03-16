package org.mockito.internal.creation.bytebuddy;

/* JADX INFO: loaded from: classes.dex */
public interface ConstructionCallback {
    Object apply(Class<?> cls, Object obj, Object[] objArr, String[] strArr);
}
