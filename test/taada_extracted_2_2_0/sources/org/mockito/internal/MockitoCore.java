package org.mockito.internal;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.mockito.InOrder;
import org.mockito.MockSettings;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.MockingDetails;
import org.mockito.exceptions.misusing.DoNotMockException;
import org.mockito.exceptions.misusing.NotAMockException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.MockSettingsImpl;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.invocation.finder.VerifiableInvocationsFinder;
import org.mockito.internal.listeners.VerificationStartedNotifier;
import org.mockito.internal.progress.MockingProgress;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.stubbing.DefaultLenientStubber;
import org.mockito.internal.stubbing.InvocationContainerImpl;
import org.mockito.internal.stubbing.OngoingStubbingImpl;
import org.mockito.internal.stubbing.StubberImpl;
import org.mockito.internal.util.DefaultMockingDetails;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.verification.MockAwareVerificationMode;
import org.mockito.internal.verification.VerificationDataImpl;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.internal.verification.api.VerificationDataInOrderImpl;
import org.mockito.invocation.Invocation;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.DoNotMockEnforcer;
import org.mockito.plugins.MockMaker;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.LenientStubber;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public class MockitoCore {
    private static final DoNotMockEnforcer DO_NOT_MOCK_ENFORCER = Plugins.getDoNotMockEnforcer();
    private static final Set<Class<?>> MOCKABLE_CLASSES = Collections.synchronizedSet(new HashSet());

    private void assertMocksNotEmpty(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw Reporter.mocksHaveToBePassedToVerifyNoMoreInteractions();
        }
    }

    private void assertNotStubOnlyMock(Object obj) {
        if (MockUtil.getMockHandler(obj).getMockSettings().isStubOnly()) {
            throw Reporter.stubPassedToVerify(obj);
        }
    }

    private void checkDoNotMockAnnotation(Class<?> cls, MockCreationSettings<?> mockCreationSettings) {
        checkDoNotMockAnnotationForType(cls);
        Iterator<Class<?>> it = mockCreationSettings.getExtraInterfaces().iterator();
        while (it.hasNext()) {
            checkDoNotMockAnnotationForType(it.next());
        }
    }

    private static void checkDoNotMockAnnotationForType(Class<?> cls) {
        if (cls == null || MOCKABLE_CLASSES.contains(cls)) {
            return;
        }
        String strCheckTypeForDoNotMockViolation = DO_NOT_MOCK_ENFORCER.checkTypeForDoNotMockViolation(cls);
        if (strCheckTypeForDoNotMockViolation != null) {
            throw new DoNotMockException(strCheckTypeForDoNotMockViolation);
        }
        checkDoNotMockAnnotationForType(cls.getSuperclass());
        for (Class<?> cls2 : cls.getInterfaces()) {
            checkDoNotMockAnnotationForType(cls2);
        }
        MOCKABLE_CLASSES.add(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MockCreationSettings lambda$mockConstruction$0(Function function, Class cls, MockedConstruction.Context context) {
        MockSettings mockSettings = (MockSettings) function.apply(context);
        if (!MockSettingsImpl.class.isInstance(mockSettings)) {
            throw new IllegalArgumentException("Unexpected implementation of '" + mockSettings.getClass().getCanonicalName() + "'\nAt the moment, you cannot provide your own implementations of that class.");
        }
        MockSettingsImpl mockSettingsImpl = (MockSettingsImpl) MockSettingsImpl.class.cast(mockSettings);
        String mockMaker = mockSettingsImpl.getMockMaker();
        if (mockMaker == null) {
            return mockSettingsImpl.build(cls);
        }
        throw new IllegalArgumentException(a.q("Unexpected MockMaker '", mockMaker, "'\nAt the moment, you cannot override the MockMaker for construction mocks."));
    }

    public void clearAllCaches() {
        MockUtil.clearAllCaches();
    }

    public <T> void clearInvocations(T... tArr) {
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.validateState();
        mockingProgress.reset();
        mockingProgress.resetOngoingStubbing();
        for (T t6 : tArr) {
            MockUtil.getInvocationContainer(t6).clearInvocations();
        }
    }

    public Invocation getLastInvocation() {
        return (Invocation) b.b(1, ((OngoingStubbingImpl) ThreadSafeMockingProgress.mockingProgress().pullOngoingStubbing()).getRegisteredInvocations());
    }

    public Object[] ignoreStubs(Object... objArr) {
        for (Object obj : objArr) {
            for (Invocation invocation : MockUtil.getInvocationContainer(obj).getInvocations()) {
                if (invocation.stubInfo() != null) {
                    invocation.ignoreForVerification();
                }
            }
        }
        return objArr;
    }

    public InOrder inOrder(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            throw Reporter.mocksHaveToBePassedWhenCreatingInOrder();
        }
        for (Object obj : objArr) {
            if (obj == null) {
                throw Reporter.nullPassedWhenCreatingInOrder();
            }
            if (!MockUtil.isMock(obj)) {
                throw Reporter.notAMockPassedWhenCreatingInOrder();
            }
            assertNotStubOnlyMock(obj);
        }
        return new InOrderImpl(Arrays.asList(objArr));
    }

    public LenientStubber lenient() {
        return new DefaultLenientStubber();
    }

    public <T> T mock(Class<T> cls, MockSettings mockSettings) {
        if (!(mockSettings instanceof MockSettingsImpl)) {
            throw new IllegalArgumentException("Unexpected implementation of '" + mockSettings.getClass().getCanonicalName() + "'\nAt the moment, you cannot provide your own implementations of that class.");
        }
        MockCreationSettings<?> mockCreationSettingsBuild = ((MockSettingsImpl) mockSettings).build(cls);
        checkDoNotMockAnnotation(mockCreationSettingsBuild.getTypeToMock(), mockCreationSettingsBuild);
        T t6 = (T) MockUtil.createMock(mockCreationSettingsBuild);
        ThreadSafeMockingProgress.mockingProgress().mockingStarted(t6, mockCreationSettingsBuild);
        return t6;
    }

    public <T> MockedConstruction<T> mockConstruction(Class<T> cls, Function<MockedConstruction.Context, ? extends MockSettings> function, MockedConstruction.MockInitializer<T> mockInitializer) {
        MockMaker.ConstructionMockControl constructionMockControlCreateConstructionMock = MockUtil.createConstructionMock(cls, new m5.a(0, function, cls), mockInitializer);
        constructionMockControlCreateConstructionMock.enable();
        return new MockedConstructionImpl(constructionMockControlCreateConstructionMock);
    }

    public <T> MockedStatic<T> mockStatic(Class<T> cls, MockSettings mockSettings) {
        if (!MockSettingsImpl.class.isInstance(mockSettings)) {
            throw new IllegalArgumentException("Unexpected implementation of '" + mockSettings.getClass().getCanonicalName() + "'\nAt the moment, you cannot provide your own implementations of that class.");
        }
        MockCreationSettings mockCreationSettingsBuildStatic = ((MockSettingsImpl) MockSettingsImpl.class.cast(mockSettings)).buildStatic(cls);
        MockMaker.StaticMockControl staticMockControlCreateStaticMock = MockUtil.createStaticMock(cls, mockCreationSettingsBuildStatic);
        staticMockControlCreateStaticMock.enable();
        ThreadSafeMockingProgress.mockingProgress().mockingStarted((Class<?>) cls, mockCreationSettingsBuildStatic);
        return new MockedStaticImpl(staticMockControlCreateStaticMock);
    }

    public MockingDetails mockingDetails(Object obj) {
        return new DefaultMockingDetails(obj);
    }

    public <T> void reset(T... tArr) {
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.validateState();
        mockingProgress.reset();
        mockingProgress.resetOngoingStubbing();
        for (T t6 : tArr) {
            MockUtil.resetMock(t6);
        }
    }

    public Stubber stubber() {
        return stubber(null);
    }

    public void validateMockitoUsage() {
        ThreadSafeMockingProgress.mockingProgress().validateState();
    }

    public <T> T verify(T t6, VerificationMode verificationMode) {
        if (t6 == null) {
            throw Reporter.nullPassedToVerify();
        }
        MockingDetails mockingDetails = mockingDetails(t6);
        if (!mockingDetails.isMock()) {
            throw Reporter.notAMockPassedToVerify(t6.getClass());
        }
        assertNotStubOnlyMock(t6);
        T t7 = (T) VerificationStartedNotifier.notifyVerificationStarted(mockingDetails.getMockHandler().getMockSettings().getVerificationStartedListeners(), mockingDetails);
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.verificationStarted(new MockAwareVerificationMode(t7, mockingProgress.maybeVerifyLazily(verificationMode), mockingProgress.verificationListeners()));
        return t7;
    }

    public void verifyNoInteractions(Object... objArr) {
        assertMocksNotEmpty(objArr);
        ThreadSafeMockingProgress.mockingProgress().validateState();
        for (Object obj : objArr) {
            if (obj == null) {
                throw Reporter.nullPassedToVerifyNoMoreInteractions();
            }
            try {
                InvocationContainerImpl invocationContainer = MockUtil.getInvocationContainer(obj);
                assertNotStubOnlyMock(obj);
                VerificationModeFactory.noInteractions().verify(new VerificationDataImpl(invocationContainer, null));
            } catch (NotAMockException unused) {
                throw Reporter.notAMockPassedToVerifyNoMoreInteractions();
            }
            throw Reporter.notAMockPassedToVerifyNoMoreInteractions();
        }
    }

    public void verifyNoMoreInteractions(Object... objArr) {
        assertMocksNotEmpty(objArr);
        ThreadSafeMockingProgress.mockingProgress().validateState();
        for (Object obj : objArr) {
            if (obj == null) {
                throw Reporter.nullPassedToVerifyNoMoreInteractions();
            }
            try {
                InvocationContainerImpl invocationContainer = MockUtil.getInvocationContainer(obj);
                assertNotStubOnlyMock(obj);
                VerificationModeFactory.noMoreInteractions().verify(new VerificationDataImpl(invocationContainer, null));
            } catch (NotAMockException unused) {
                throw Reporter.notAMockPassedToVerifyNoMoreInteractions();
            }
            throw Reporter.notAMockPassedToVerifyNoMoreInteractions();
        }
    }

    public void verifyNoMoreInteractionsInOrder(List<Object> list, InOrderContext inOrderContext) {
        ThreadSafeMockingProgress.mockingProgress().validateState();
        VerificationModeFactory.noMoreInteractions().verifyInOrder(new VerificationDataInOrderImpl(inOrderContext, VerifiableInvocationsFinder.find(list), null));
    }

    public <T> OngoingStubbing<T> when(T t6) {
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.stubbingStarted();
        OngoingStubbing<T> ongoingStubbing = (OngoingStubbing<T>) mockingProgress.pullOngoingStubbing();
        if (ongoingStubbing != null) {
            return ongoingStubbing;
        }
        mockingProgress.reset();
        throw Reporter.missingMethodInvocation();
    }

    public Stubber stubber(Strictness strictness) {
        MockingProgress mockingProgress = ThreadSafeMockingProgress.mockingProgress();
        mockingProgress.stubbingStarted();
        mockingProgress.resetOngoingStubbing();
        return new StubberImpl(strictness);
    }
}
