package org.mockito.internal.stubbing.answers;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.ValidableAnswer;

/* JADX INFO: loaded from: classes.dex */
public class ReturnsArgumentAt implements Answer<Object>, ValidableAnswer, Serializable {
    public static final int LAST_ARGUMENT = -1;
    private static final long serialVersionUID = -589315085166295101L;
    private final int wantedArgumentPosition;

    public ReturnsArgumentAt(int i) {
        if (i != -1 && i < 0) {
            throw Reporter.invalidArgumentRangeAtIdentityAnswerCreationTime();
        }
        this.wantedArgumentPosition = i;
    }

    private Class<?> inferArgumentType(Invocation invocation, int i) {
        Class<?>[] parameterTypes = invocation.getMethod().getParameterTypes();
        if (!invocation.getMethod().isVarArgs()) {
            Class<?> cls = parameterTypes[i];
            Object argument = invocation.getArgument(i);
            return (cls.isPrimitive() || argument == null) ? cls : argument.getClass();
        }
        int length = parameterTypes.length - 1;
        if (i >= length && !wantedArgIndexIsVarargAndSameTypeAsReturnType(invocation)) {
            return parameterTypes[length].getComponentType();
        }
        return parameterTypes[i];
    }

    private int inferWantedArgumentPosition(InvocationOnMock invocationOnMock) {
        int i = this.wantedArgumentPosition;
        return i == -1 ? invocationOnMock.getArguments().length - 1 : i;
    }

    private int inferWantedRawArgumentPosition(InvocationOnMock invocationOnMock) {
        int i = this.wantedArgumentPosition;
        return i == -1 ? invocationOnMock.getRawArguments().length - 1 : i;
    }

    private void validateArgumentTypeCompatibility(Invocation invocation, int i) {
        InvocationInfo invocationInfo = new InvocationInfo(invocation);
        Class<?> clsInferArgumentType = inferArgumentType(invocation, i);
        if (!invocationInfo.isValidReturnType(clsInferArgumentType)) {
            throw Reporter.wrongTypeOfArgumentToReturn(invocation, invocationInfo.printMethodReturnType(), clsInferArgumentType, this.wantedArgumentPosition);
        }
    }

    private void validateIndexWithinInvocationRange(InvocationOnMock invocationOnMock, int i) {
        if (invocationOnMock.getArguments().length <= i) {
            int i3 = this.wantedArgumentPosition;
            throw Reporter.invalidArgumentPositionRangeAtInvocationTime(invocationOnMock, i3 == -1, i3);
        }
    }

    private void validateIndexWithinTheoreticalInvocationRange(InvocationOnMock invocationOnMock, int i) {
        if (wantedArgumentPositionIsValidForTheoreticalInvocation(invocationOnMock, i)) {
            return;
        }
        int i3 = this.wantedArgumentPosition;
        throw Reporter.invalidArgumentPositionRangeAtInvocationTime(invocationOnMock, i3 == -1, i3);
    }

    private boolean wantedArgIndexIsVarargAndSameTypeAsReturnType(InvocationOnMock invocationOnMock) {
        int iInferWantedRawArgumentPosition = inferWantedRawArgumentPosition(invocationOnMock);
        Method method = invocationOnMock.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();
        return method.isVarArgs() && iInferWantedRawArgumentPosition == parameterTypes.length - 1 && method.getReturnType().isAssignableFrom(parameterTypes[iInferWantedRawArgumentPosition]);
    }

    private boolean wantedArgumentPositionIsValidForTheoreticalInvocation(InvocationOnMock invocationOnMock, int i) {
        if (i < 0) {
            return false;
        }
        return invocationOnMock.getMethod().isVarArgs() || invocationOnMock.getArguments().length > i;
    }

    @Override // org.mockito.stubbing.Answer
    public Object answer(InvocationOnMock invocationOnMock) {
        if (wantedArgIndexIsVarargAndSameTypeAsReturnType(invocationOnMock)) {
            return invocationOnMock.getRawArguments()[invocationOnMock.getRawArguments().length - 1];
        }
        int iInferWantedArgumentPosition = inferWantedArgumentPosition(invocationOnMock);
        validateIndexWithinInvocationRange(invocationOnMock, iInferWantedArgumentPosition);
        return invocationOnMock.getArgument(iInferWantedArgumentPosition);
    }

    @Override // org.mockito.stubbing.ValidableAnswer
    public void validateFor(InvocationOnMock invocationOnMock) {
        Invocation invocation = (Invocation) invocationOnMock;
        int iInferWantedArgumentPosition = inferWantedArgumentPosition(invocation);
        validateIndexWithinTheoreticalInvocationRange(invocation, iInferWantedArgumentPosition);
        validateArgumentTypeCompatibility(invocation, iInferWantedArgumentPosition);
    }
}
