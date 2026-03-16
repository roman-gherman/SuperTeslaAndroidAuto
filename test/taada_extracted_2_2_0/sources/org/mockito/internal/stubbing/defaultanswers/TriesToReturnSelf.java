package org.mockito.internal.stubbing.defaultanswers;

import java.io.Serializable;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
public class TriesToReturnSelf implements Answer<Object>, Serializable {
    private final ReturnsEmptyValues defaultReturn = new ReturnsEmptyValues();

    @Override // org.mockito.stubbing.Answer
    public Object answer(InvocationOnMock invocationOnMock) {
        Class<?> returnType = invocationOnMock.getMethod().getReturnType();
        return (!returnType.isAssignableFrom(MockUtil.getMockHandler(invocationOnMock.getMock()).getMockSettings().getTypeToMock()) || returnType == Object.class) ? this.defaultReturn.returnValueFor(returnType) : invocationOnMock.getMock();
    }
}
