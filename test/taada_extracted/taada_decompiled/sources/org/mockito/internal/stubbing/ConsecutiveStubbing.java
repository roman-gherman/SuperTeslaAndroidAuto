package org.mockito.internal.stubbing;

import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

/* JADX INFO: loaded from: classes.dex */
public class ConsecutiveStubbing<T> extends BaseStubbing<T> {
    private final InvocationContainerImpl invocationContainer;

    public ConsecutiveStubbing(InvocationContainerImpl invocationContainerImpl) {
        super(invocationContainerImpl.invokedMock());
        this.invocationContainer = invocationContainerImpl;
    }

    @Override // org.mockito.stubbing.OngoingStubbing
    public OngoingStubbing<T> thenAnswer(Answer<?> answer) {
        this.invocationContainer.addConsecutiveAnswer(answer);
        return this;
    }
}
