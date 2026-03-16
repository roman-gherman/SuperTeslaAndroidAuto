package org.mockito.internal.creation.bytebuddy;

import java.util.Optional;
import java.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

/* JADX INFO: loaded from: classes.dex */
public class ByteBuddyMockMaker implements ClassCreatingMockMaker {
    private final SubclassByteBuddyMockMaker subclassByteBuddyMockMaker;

    public ByteBuddyMockMaker() {
        try {
            this.subclassByteBuddyMockMaker = new SubclassByteBuddyMockMaker();
        } catch (NoClassDefFoundError e) {
            Reporter.missingByteBuddyDependency(e);
            throw e;
        }
    }

    @Override // org.mockito.plugins.MockMaker
    public void clearAllCaches() {
        this.subclassByteBuddyMockMaker.clearAllCaches();
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> MockMaker.ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer) {
        return this.subclassByteBuddyMockMaker.createConstructionMock(cls, function, function2, mockInitializer);
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return (T) this.subclassByteBuddyMockMaker.createMock(mockCreationSettings, mockHandler);
    }

    @Override // org.mockito.internal.creation.bytebuddy.ClassCreatingMockMaker
    public <T> Class<? extends T> createMockType(MockCreationSettings<T> mockCreationSettings) {
        return this.subclassByteBuddyMockMaker.createMockType(mockCreationSettings);
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> Optional<T> createSpy(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, T t6) {
        return this.subclassByteBuddyMockMaker.createSpy(mockCreationSettings, mockHandler, t6);
    }

    @Override // org.mockito.plugins.MockMaker
    public <T> MockMaker.StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return this.subclassByteBuddyMockMaker.createStaticMock(cls, mockCreationSettings, mockHandler);
    }

    @Override // org.mockito.plugins.MockMaker
    public MockHandler getHandler(Object obj) {
        return this.subclassByteBuddyMockMaker.getHandler(obj);
    }

    @Override // org.mockito.plugins.MockMaker
    public MockMaker.TypeMockability isTypeMockable(Class<?> cls) {
        return this.subclassByteBuddyMockMaker.isTypeMockable(cls);
    }

    @Override // org.mockito.plugins.MockMaker
    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        this.subclassByteBuddyMockMaker.resetMock(obj, mockHandler, mockCreationSettings);
    }

    public ByteBuddyMockMaker(SubclassByteBuddyMockMaker subclassByteBuddyMockMaker) {
        this.subclassByteBuddyMockMaker = subclassByteBuddyMockMaker;
    }
}
