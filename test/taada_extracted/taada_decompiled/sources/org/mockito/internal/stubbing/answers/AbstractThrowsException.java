package org.mockito.internal.stubbing.answers;

import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.ValidableAnswer;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractThrowsException implements Answer<Object>, ValidableAnswer {
    private final ConditionalStackTraceFilter filter = new ConditionalStackTraceFilter();

    @Override // org.mockito.stubbing.Answer
    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
        Throwable thFillInStackTrace;
        Throwable throwable = getThrowable();
        if (throwable == null) {
            throw new IllegalStateException("throwable is null: you shall not call #answer if #validateFor fails!");
        }
        if (MockUtil.isMock(throwable) || (thFillInStackTrace = throwable.fillInStackTrace()) == null) {
            throw throwable;
        }
        this.filter.filter(thFillInStackTrace);
        throw thFillInStackTrace;
    }

    public abstract Throwable getThrowable();

    @Override // org.mockito.stubbing.ValidableAnswer
    public void validateFor(InvocationOnMock invocationOnMock) {
        Throwable throwable = getThrowable();
        if (throwable == null) {
            throw Reporter.cannotStubWithNullThrowable();
        }
        if (!(throwable instanceof RuntimeException) && !(throwable instanceof Error) && !new InvocationInfo(invocationOnMock).isValidException(throwable)) {
            throw Reporter.checkedExceptionInvalid(throwable);
        }
    }
}
