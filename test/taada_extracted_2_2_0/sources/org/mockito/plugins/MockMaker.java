package org.mockito.plugins;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;

/* JADX INFO: loaded from: classes.dex */
public interface MockMaker {

    public interface ConstructionMockControl<T> {
        void disable();

        void enable();

        List<T> getMocks();

        Class<T> getType();
    }

    public interface StaticMockControl<T> {
        void disable();

        void enable();

        Class<T> getType();
    }

    public interface TypeMockability {
        boolean mockable();

        String nonMockableReason();
    }

    default void clearAllCaches() {
    }

    default <T> ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer) {
        throw new MockitoException(StringUtil.join("The used MockMaker " + getClass().getSimpleName() + " does not support the creation of construction mocks", "", "Mockito's inline mock maker supports construction mocks based on the Instrumentation API.", "You can simply enable this mock mode, by placing the 'mockito-inline' artifact where you are currently using 'mockito-core'.", "Note that Mockito's inline mock maker is not supported on Android."));
    }

    <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler);

    default <T> Optional<T> createSpy(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, T t6) {
        return Optional.empty();
    }

    default <T> StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        throw new MockitoException(StringUtil.join("The used MockMaker " + getClass().getSimpleName() + " does not support the creation of static mocks", "", "Mockito's inline mock maker supports static mocks based on the Instrumentation API.", "You can simply enable this mock mode, by placing the 'mockito-inline' artifact where you are currently using 'mockito-core'.", "Note that Mockito's inline mock maker is not supported on Android."));
    }

    MockHandler getHandler(Object obj);

    TypeMockability isTypeMockable(Class<?> cls);

    void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings);
}
