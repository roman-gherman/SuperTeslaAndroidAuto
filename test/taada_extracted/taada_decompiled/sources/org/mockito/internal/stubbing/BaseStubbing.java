package org.mockito.internal.stubbing;

import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.mockito.internal.stubbing.answers.Returns;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.mockito.internal.stubbing.answers.ThrowsExceptionForClassType;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseStubbing<T> implements OngoingStubbing<T> {
    private final Object strongMockRef;

    public BaseStubbing(Object obj) {
        this.strongMockRef = obj;
    }

    private OngoingStubbing<T> thenThrow(Throwable th) {
        return thenAnswer(new ThrowsException(th));
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public <M> M getMock() {
        return (M) this.strongMockRef;
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public OngoingStubbing<T> then(Answer<?> answer) {
        return thenAnswer(answer);
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public OngoingStubbing<T> thenCallRealMethod() {
        return thenAnswer(new CallsRealMethods());
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public OngoingStubbing<T> thenReturn(T t6) {
        return thenAnswer(new Returns(t6));
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public OngoingStubbing<T> thenReturn(T t6, T... tArr) {
        OngoingStubbing<T> ongoingStubbingThenReturn = thenReturn(t6);
        if (tArr == null) {
            return ongoingStubbingThenReturn.thenReturn(null);
        }
        for (T t7 : tArr) {
            ongoingStubbingThenReturn = ongoingStubbingThenReturn.thenReturn(t7);
        }
        return ongoingStubbingThenReturn;
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public OngoingStubbing<T> thenThrow(Throwable... thArr) {
        OngoingStubbing<T> ongoingStubbingThenThrow = null;
        if (thArr == null) {
            return thenThrow((Throwable) null);
        }
        for (Throwable th : thArr) {
            ongoingStubbingThenThrow = ongoingStubbingThenThrow == null ? thenThrow(th) : ongoingStubbingThenThrow.thenThrow(th);
        }
        return ongoingStubbingThenThrow;
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public OngoingStubbing<T> thenThrow(Class<? extends Throwable> cls) {
        if (cls != null) {
            return thenAnswer(new ThrowsExceptionForClassType(cls));
        }
        ThreadSafeMockingProgress.mockingProgress().reset();
        throw Reporter.notAnException();
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public OngoingStubbing<T> thenThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
        if (clsArr == null) {
            return thenThrow((Class<? extends Throwable>) null);
        }
        OngoingStubbing<T> ongoingStubbingThenThrow = thenThrow(cls);
        for (Class<? extends Throwable> cls2 : clsArr) {
            ongoingStubbingThenThrow = ongoingStubbingThenThrow.thenThrow(cls2);
        }
        return ongoingStubbingThenThrow;
    }
}
