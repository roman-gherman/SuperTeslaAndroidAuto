package org.mockito.internal.stubbing.defaultanswers;

import java.io.Serializable;
import org.mockito.Mockito;
import org.mockito.internal.creation.MockSettingsImpl;
import org.mockito.internal.stubbing.defaultanswers.RetrieveGenericsForDefaultAnswers;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
public class ReturnsMocks implements Answer<Object>, Serializable {
    private static final long serialVersionUID = -6755257986994634579L;
    private final Answer<Object> delegate = new ReturnsMoreEmptyValues();

    @Override // org.mockito.stubbing.Answer
    public Object answer(final InvocationOnMock invocationOnMock) {
        Object objAnswer = this.delegate.answer(invocationOnMock);
        return objAnswer != null ? objAnswer : RetrieveGenericsForDefaultAnswers.returnTypeForMockWithCorrectGenerics(invocationOnMock, new RetrieveGenericsForDefaultAnswers.AnswerCallback() { // from class: org.mockito.internal.stubbing.defaultanswers.ReturnsMocks.1
            @Override // org.mockito.internal.stubbing.defaultanswers.RetrieveGenericsForDefaultAnswers.AnswerCallback
            public Object apply(Class<?> cls) {
                if (cls == null) {
                    return null;
                }
                return Mockito.mock(cls, new MockSettingsImpl().defaultAnswer(ReturnsMocks.this).mockMaker(MockUtil.getMockSettings(invocationOnMock.getMock()).getMockMaker()));
            }
        });
    }
}
