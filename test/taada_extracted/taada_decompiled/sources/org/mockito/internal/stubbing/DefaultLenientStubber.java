package org.mockito.internal.stubbing;

import org.mockito.internal.MockitoCore;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.LenientStubber;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLenientStubber implements LenientStubber {
    private static final MockitoCore MOCKITO_CORE = new MockitoCore();

    private static Stubber stubber() {
        return MOCKITO_CORE.stubber(Strictness.LENIENT);
    }

    @Override // org.mockito.stubbing.BaseStubber
    public Stubber doAnswer(Answer answer) {
        return stubber().doAnswer(answer);
    }

    @Override // org.mockito.stubbing.BaseStubber
    public Stubber doCallRealMethod() {
        return stubber().doCallRealMethod();
    }

    @Override // org.mockito.stubbing.BaseStubber
    public Stubber doNothing() {
        return stubber().doNothing();
    }

    @Override // org.mockito.stubbing.BaseStubber
    public Stubber doReturn(Object obj) {
        return stubber().doReturn(obj);
    }

    @Override // org.mockito.stubbing.BaseStubber
    public Stubber doThrow(Throwable... thArr) {
        return stubber().doThrow(thArr);
    }

    @Override // org.mockito.stubbing.LenientStubber
    public <T> OngoingStubbing<T> when(T t6) {
        OngoingStubbingImpl ongoingStubbingImpl = (OngoingStubbingImpl) MOCKITO_CORE.when(t6);
        ongoingStubbingImpl.setStrictness(Strictness.LENIENT);
        return ongoingStubbingImpl;
    }

    @Override // org.mockito.stubbing.BaseStubber
    public Stubber doReturn(Object obj, Object... objArr) {
        return stubber().doReturn(obj, objArr);
    }

    @Override // org.mockito.stubbing.BaseStubber
    public Stubber doThrow(Class<? extends Throwable> cls) {
        return stubber().doThrow(cls);
    }

    @Override // org.mockito.stubbing.BaseStubber
    public Stubber doThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
        return stubber().doThrow(cls, clsArr);
    }
}
