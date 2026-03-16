package org.mockito.stubbing;

import org.mockito.NotExtensible;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface OngoingStubbing<T> {
    <M> M getMock();

    OngoingStubbing<T> then(Answer<?> answer);

    OngoingStubbing<T> thenAnswer(Answer<?> answer);

    OngoingStubbing<T> thenCallRealMethod();

    OngoingStubbing<T> thenReturn(T t6);

    OngoingStubbing<T> thenReturn(T t6, T... tArr);

    OngoingStubbing<T> thenThrow(Class<? extends Throwable> cls);

    OngoingStubbing<T> thenThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr);

    OngoingStubbing<T> thenThrow(Throwable... thArr);
}
