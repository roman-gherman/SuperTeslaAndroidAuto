package org.mockito.internal.stubbing.defaultanswers;

import java.io.Serializable;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.internal.MockitoCore;
import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.stubbing.InvocationContainerImpl;
import org.mockito.internal.stubbing.StubbedInvocationMatcher;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.reflection.GenericMetadataSupport;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.mock.MockCreationSettings;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
public class ReturnsDeepStubs implements Answer<Object>, Serializable {
    private static final long serialVersionUID = -7105341425736035847L;

    public static class DeeplyStubbedAnswer implements Answer<Object>, Serializable {
        private final Object mock;

        public DeeplyStubbedAnswer(Object obj) {
            this.mock = obj;
        }

        @Override // org.mockito.stubbing.Answer
        public Object answer(InvocationOnMock invocationOnMock) {
            return this.mock;
        }
    }

    public static class LazyHolder {
        private static final MockitoCore MOCKITO_CORE = new MockitoCore();
        private static final ReturnsEmptyValues DELEGATE = new ReturnsEmptyValues();

        private LazyHolder() {
        }
    }

    public static class ReturnsDeepStubsSerializationFallback extends ReturnsDeepStubs implements Serializable {
        private final GenericMetadataSupport returnTypeGenericMetadata;

        public ReturnsDeepStubsSerializationFallback(GenericMetadataSupport genericMetadataSupport) {
            this.returnTypeGenericMetadata = genericMetadataSupport;
        }

        private Object writeReplace() {
            return Mockito.RETURNS_DEEP_STUBS;
        }

        @Override // org.mockito.internal.stubbing.defaultanswers.ReturnsDeepStubs
        public GenericMetadataSupport actualParameterizedType(Object obj) {
            return this.returnTypeGenericMetadata;
        }
    }

    private Object deepStub(InvocationOnMock invocationOnMock, GenericMetadataSupport genericMetadataSupport) {
        InvocationContainerImpl invocationContainer = MockUtil.getInvocationContainer(invocationOnMock.getMock());
        Answer answerFindStubbedAnswer = invocationContainer.findStubbedAnswer();
        if (answerFindStubbedAnswer != null) {
            return answerFindStubbedAnswer.answer(invocationOnMock);
        }
        StubbedInvocationMatcher stubbedInvocationMatcherRecordDeepStubAnswer = recordDeepStubAnswer(newDeepStubMock(genericMetadataSupport, invocationOnMock.getMock()), invocationContainer);
        stubbedInvocationMatcherRecordDeepStubAnswer.markStubUsed(stubbedInvocationMatcherRecordDeepStubAnswer.getInvocation());
        return stubbedInvocationMatcherRecordDeepStubAnswer.answer(invocationOnMock);
    }

    private static ReturnsEmptyValues delegate() {
        return LazyHolder.DELEGATE;
    }

    private static MockitoCore mockitoCore() {
        return LazyHolder.MOCKITO_CORE;
    }

    private Object newDeepStubMock(GenericMetadataSupport genericMetadataSupport, Object obj) {
        return mockitoCore().mock(genericMetadataSupport.rawType(), withSettingsUsing(genericMetadataSupport, MockUtil.getMockSettings(obj)));
    }

    private MockSettings propagateSerializationSettings(MockSettings mockSettings, MockCreationSettings mockCreationSettings) {
        return mockSettings.serializable(mockCreationSettings.getSerializableMode());
    }

    private StubbedInvocationMatcher recordDeepStubAnswer(Object obj, InvocationContainerImpl invocationContainerImpl) {
        return invocationContainerImpl.addAnswer(new DeeplyStubbedAnswer(obj), false, null);
    }

    private ReturnsDeepStubs returnsDeepStubsAnswerUsing(GenericMetadataSupport genericMetadataSupport) {
        return new ReturnsDeepStubsSerializationFallback(genericMetadataSupport);
    }

    private MockSettings withSettingsUsing(GenericMetadataSupport genericMetadataSupport, MockCreationSettings<?> mockCreationSettings) {
        return propagateSerializationSettings(genericMetadataSupport.hasRawExtraInterfaces() ? Mockito.withSettings().extraInterfaces(genericMetadataSupport.rawExtraInterfaces()) : Mockito.withSettings(), mockCreationSettings).defaultAnswer(returnsDeepStubsAnswerUsing(genericMetadataSupport)).mockMaker(mockCreationSettings.getMockMaker());
    }

    public GenericMetadataSupport actualParameterizedType(Object obj) {
        return GenericMetadataSupport.inferFrom(((CreationSettings) MockUtil.getMockHandler(obj).getMockSettings()).getTypeToMock());
    }

    @Override // org.mockito.stubbing.Answer
    public Object answer(InvocationOnMock invocationOnMock) {
        GenericMetadataSupport genericMetadataSupportResolveGenericReturnType = actualParameterizedType(invocationOnMock.getMock()).resolveGenericReturnType(invocationOnMock.getMethod());
        MockCreationSettings mockSettings = MockUtil.getMockSettings(invocationOnMock.getMock());
        Class<?> clsRawType = genericMetadataSupportResolveGenericReturnType.rawType();
        if (!MockUtil.typeMockabilityOf(clsRawType, mockSettings.getMockMaker()).mockable()) {
            return invocationOnMock.getMethod().getReturnType().equals(clsRawType) ? delegate().answer(invocationOnMock) : delegate().returnValueFor(clsRawType);
        }
        if (!clsRawType.equals(Object.class) || genericMetadataSupportResolveGenericReturnType.hasRawExtraInterfaces()) {
            return deepStub(invocationOnMock, genericMetadataSupportResolveGenericReturnType);
        }
        return null;
    }
}
