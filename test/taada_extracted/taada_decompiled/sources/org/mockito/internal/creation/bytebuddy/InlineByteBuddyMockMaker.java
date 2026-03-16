package org.mockito.internal.creation.bytebuddy;

import java.util.Optional;
import java.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.creation.instance.Instantiator;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.InlineMockMaker;
import org.mockito.plugins.MockMaker;

/* JADX INFO: loaded from: classes.dex */
public class InlineByteBuddyMockMaker implements ClassCreatingMockMaker, InlineMockMaker, Instantiator {
    private final InlineDelegateByteBuddyMockMaker inlineDelegateByteBuddyMockMaker;

    public InlineByteBuddyMockMaker() {
        try {
            this.inlineDelegateByteBuddyMockMaker = new InlineDelegateByteBuddyMockMaker();
        } catch (NoClassDefFoundError e) {
            Reporter.missingByteBuddyDependency(e);
            throw e;
        }
    }

    @Override // org.mockito.plugins.MockMaker
    public void clearAllCaches() {
        this.inlineDelegateByteBuddyMockMaker.clearAllCaches();
    }

    @Override // org.mockito.plugins.InlineMockMaker
    public void clearAllMocks() {
        this.inlineDelegateByteBuddyMockMaker.clearAllMocks();
    }

    @Override // org.mockito.plugins.InlineMockMaker
    public void clearMock(Object obj) {
        this.inlineDelegateByteBuddyMockMaker.clearMock(obj);
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> MockMaker.ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer) {
        return this.inlineDelegateByteBuddyMockMaker.createConstructionMock(cls, function, function2, mockInitializer);
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return (T) this.inlineDelegateByteBuddyMockMaker.createMock(mockCreationSettings, mockHandler);
    }

    @Override // org.mockito.internal.creation.bytebuddy.ClassCreatingMockMaker
    public <T> Class<? extends T> createMockType(MockCreationSettings<T> mockCreationSettings) {
        return this.inlineDelegateByteBuddyMockMaker.createMockType(mockCreationSettings);
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> Optional<T> createSpy(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, T t6) {
        return this.inlineDelegateByteBuddyMockMaker.createSpy(mockCreationSettings, mockHandler, t6);
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> MockMaker.StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return this.inlineDelegateByteBuddyMockMaker.createStaticMock(cls, mockCreationSettings, mockHandler);
    }

    @Override // org.mockito.plugins.MockMaker
    public MockHandler getHandler(Object obj) {
        return this.inlineDelegateByteBuddyMockMaker.getHandler(obj);
    }

    @Override // org.mockito.plugins.MockMaker
    public MockMaker.TypeMockability isTypeMockable(Class<?> cls) {
        return this.inlineDelegateByteBuddyMockMaker.isTypeMockable(cls);
    }

    @Override // org.mockito.creation.instance.Instantiator
    public <T> T newInstance(Class<T> cls) {
        return (T) this.inlineDelegateByteBuddyMockMaker.newInstance(cls);
    }

    @Override // org.mockito.plugins.MockMaker
    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        this.inlineDelegateByteBuddyMockMaker.resetMock(obj, mockHandler, mockCreationSettings);
    }

    public InlineByteBuddyMockMaker(InlineDelegateByteBuddyMockMaker inlineDelegateByteBuddyMockMaker) {
        this.inlineDelegateByteBuddyMockMaker = inlineDelegateByteBuddyMockMaker;
    }
}
