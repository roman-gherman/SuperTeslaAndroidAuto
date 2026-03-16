package org.mockito.internal.stubbing.answers;

import org.mockito.internal.exceptions.Reporter;
import org.mockito.invocation.InvocationOnMock;

/* JADX INFO: loaded from: classes.dex */
public abstract class DefaultAnswerValidator {
    public static void validateReturnValueFor(InvocationOnMock invocationOnMock, Object obj) {
        InvocationInfo invocationInfo = new InvocationInfo(invocationOnMock);
        if (obj != null && !invocationInfo.isValidReturnType(obj.getClass())) {
            throw Reporter.wrongTypeReturnedByDefaultAnswer(invocationOnMock.getMock(), invocationInfo.printMethodReturnType(), obj.getClass().getSimpleName(), invocationInfo.getMethodName());
        }
    }
}
