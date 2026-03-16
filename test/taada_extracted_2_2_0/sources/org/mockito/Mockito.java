package org.mockito;

import D0.b;
import java.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.internal.MockitoCore;
import org.mockito.internal.creation.MockSettingsImpl;
import org.mockito.internal.framework.DefaultMockitoFramework;
import org.mockito.internal.session.DefaultMockitoSessionBuilder;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.session.MockitoSessionBuilder;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.LenientStubber;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.After;
import org.mockito.verification.Timeout;
import org.mockito.verification.VerificationAfterDelay;
import org.mockito.verification.VerificationMode;
import org.mockito.verification.VerificationWithTimeout;

/* JADX INFO: loaded from: classes.dex */
public class Mockito extends ArgumentMatchers {
    static final MockitoCore MOCKITO_CORE = new MockitoCore();
    public static final Answer<Object> RETURNS_DEFAULTS = Answers.RETURNS_DEFAULTS;
    public static final Answer<Object> RETURNS_SMART_NULLS = Answers.RETURNS_SMART_NULLS;
    public static final Answer<Object> RETURNS_MOCKS = Answers.RETURNS_MOCKS;
    public static final Answer<Object> RETURNS_DEEP_STUBS = Answers.RETURNS_DEEP_STUBS;
    public static final Answer<Object> CALLS_REAL_METHODS = Answers.CALLS_REAL_METHODS;
    public static final Answer<Object> RETURNS_SELF = Answers.RETURNS_SELF;

    public static VerificationAfterDelay after(long j6) {
        return new After(j6, VerificationModeFactory.times(1));
    }

    public static VerificationMode atLeast(int i) {
        return VerificationModeFactory.atLeast(i);
    }

    public static VerificationMode atLeastOnce() {
        return VerificationModeFactory.atLeastOnce();
    }

    public static VerificationMode atMost(int i) {
        return VerificationModeFactory.atMost(i);
    }

    public static VerificationMode atMostOnce() {
        return VerificationModeFactory.atMostOnce();
    }

    public static VerificationMode calls(int i) {
        return VerificationModeFactory.calls(i);
    }

    public static void clearAllCaches() {
        MOCKITO_CORE.clearAllCaches();
    }

    public static <T> void clearInvocations(T... tArr) {
        MOCKITO_CORE.clearInvocations(tArr);
    }

    public static VerificationMode description(String str) {
        return times(1).description(str);
    }

    public static Stubber doAnswer(Answer answer) {
        return MOCKITO_CORE.stubber().doAnswer(answer);
    }

    public static Stubber doCallRealMethod() {
        return MOCKITO_CORE.stubber().doCallRealMethod();
    }

    public static Stubber doNothing() {
        return MOCKITO_CORE.stubber().doNothing();
    }

    public static Stubber doReturn(Object obj) {
        return MOCKITO_CORE.stubber().doReturn(obj);
    }

    public static Stubber doThrow(Throwable... thArr) {
        return MOCKITO_CORE.stubber().doThrow(thArr);
    }

    public static MockitoFramework framework() {
        return new DefaultMockitoFramework();
    }

    private static <T> Class<T> getClassOf(T[] tArr) {
        return (Class<T>) tArr.getClass().getComponentType();
    }

    public static Object[] ignoreStubs(Object... objArr) {
        return MOCKITO_CORE.ignoreStubs(objArr);
    }

    public static InOrder inOrder(Object... objArr) {
        return MOCKITO_CORE.inOrder(objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MockSettings lambda$mockConstruction$2(MockedConstruction.Context context) {
        return withSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$mockConstruction$3(Object obj, MockedConstruction.Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MockSettings lambda$mockConstruction$4(MockSettings mockSettings, MockedConstruction.Context context) {
        return mockSettings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$mockConstruction$5(Object obj, MockedConstruction.Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MockSettings lambda$mockConstruction$6(MockSettings mockSettings, MockedConstruction.Context context) {
        return mockSettings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MockSettings lambda$mockConstructionWithAnswer$0(Answer[] answerArr, Answer answer, MockedConstruction.Context context) {
        return (context.getCount() == 1 || answerArr.length == 0) ? withSettings().defaultAnswer(answer) : context.getCount() > answerArr.length ? withSettings().defaultAnswer(answerArr[answerArr.length - 1]) : withSettings().defaultAnswer(answerArr[context.getCount() - 2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$mockConstructionWithAnswer$1(Object obj, MockedConstruction.Context context) {
    }

    public static LenientStubber lenient() {
        return MOCKITO_CORE.lenient();
    }

    public static <T> T mock(T... tArr) {
        if (tArr.length <= 0) {
            return (T) mock(getClassOf(tArr), withSettings());
        }
        throw new IllegalArgumentException("Please don't pass any values here. Java will detect class automagically.");
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls) {
        return mockConstruction(cls, new o5.a(3), new b(22));
    }

    public static <T> MockedConstruction<T> mockConstructionWithAnswer(Class<T> cls, Answer answer, Answer... answerArr) {
        return mockConstruction(cls, new m5.a(1, answerArr, answer), new b(21));
    }

    public static <T> MockedStatic<T> mockStatic(Class<T> cls) {
        return mockStatic(cls, withSettings());
    }

    public static MockingDetails mockingDetails(Object obj) {
        return MOCKITO_CORE.mockingDetails(obj);
    }

    public static MockitoSessionBuilder mockitoSession() {
        return new DefaultMockitoSessionBuilder();
    }

    public static VerificationMode never() {
        return times(0);
    }

    public static VerificationMode only() {
        return VerificationModeFactory.only();
    }

    public static <T> void reset(T... tArr) {
        MOCKITO_CORE.reset(tArr);
    }

    public static <T> T spy(T t6) {
        return (T) MOCKITO_CORE.mock(t6.getClass(), withSettings().spiedInstance(t6).defaultAnswer(CALLS_REAL_METHODS));
    }

    public static VerificationWithTimeout timeout(long j6) {
        return new Timeout(j6, VerificationModeFactory.times(1));
    }

    public static VerificationMode times(int i) {
        return VerificationModeFactory.times(i);
    }

    public static void validateMockitoUsage() {
        MOCKITO_CORE.validateMockitoUsage();
    }

    public static <T> T verify(T t6) {
        return (T) MOCKITO_CORE.verify(t6, times(1));
    }

    public static void verifyNoInteractions(Object... objArr) {
        MOCKITO_CORE.verifyNoInteractions(objArr);
    }

    public static void verifyNoMoreInteractions(Object... objArr) {
        MOCKITO_CORE.verifyNoMoreInteractions(objArr);
    }

    public static <T> OngoingStubbing<T> when(T t6) {
        return MOCKITO_CORE.when(t6);
    }

    public static MockSettings withSettings() {
        return new MockSettingsImpl().defaultAnswer(RETURNS_DEFAULTS);
    }

    public static Stubber doReturn(Object obj, Object... objArr) {
        return MOCKITO_CORE.stubber().doReturn(obj, objArr);
    }

    public static Stubber doThrow(Class<? extends Throwable> cls) {
        return MOCKITO_CORE.stubber().doThrow(cls);
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, MockedConstruction.MockInitializer<T> mockInitializer) {
        return mockConstruction(cls, withSettings(), mockInitializer);
    }

    public static <T> MockedStatic<T> mockStatic(Class<T> cls, Answer answer) {
        return mockStatic(cls, withSettings().defaultAnswer(answer));
    }

    public static <T> T verify(T t6, VerificationMode verificationMode) {
        return (T) MOCKITO_CORE.verify(t6, verificationMode);
    }

    public static Stubber doThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
        return MOCKITO_CORE.stubber().doThrow(cls, clsArr);
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, MockSettings mockSettings) {
        return mockConstruction(cls, new a(mockSettings, 1));
    }

    public static <T> MockedStatic<T> mockStatic(Class<T> cls, String str) {
        return mockStatic(cls, withSettings().name(str));
    }

    public static <T> T mock(Class<T> cls) {
        return (T) mock(cls, withSettings());
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, Function<MockedConstruction.Context, MockSettings> function) {
        return mockConstruction(cls, function, new b(23));
    }

    public static <T> MockedStatic<T> mockStatic(Class<T> cls, MockSettings mockSettings) {
        return MOCKITO_CORE.mockStatic(cls, mockSettings);
    }

    public static <T> T mock(Class<T> cls, String str) {
        return (T) mock(cls, withSettings().name(str).defaultAnswer(RETURNS_DEFAULTS));
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, MockSettings mockSettings, MockedConstruction.MockInitializer<T> mockInitializer) {
        return mockConstruction(cls, new a(mockSettings, 0), mockInitializer);
    }

    public static <T> T spy(Class<T> cls) {
        return (T) MOCKITO_CORE.mock(cls, withSettings().useConstructor(new Object[0]).defaultAnswer(CALLS_REAL_METHODS));
    }

    public static <T> T mock(Class<T> cls, Answer answer) {
        return (T) mock(cls, withSettings().defaultAnswer(answer));
    }

    public static <T> MockedConstruction<T> mockConstruction(Class<T> cls, Function<MockedConstruction.Context, MockSettings> function, MockedConstruction.MockInitializer<T> mockInitializer) {
        return MOCKITO_CORE.mockConstruction(cls, function, mockInitializer);
    }

    public static <T> T mock(Class<T> cls, MockSettings mockSettings) {
        return (T) MOCKITO_CORE.mock(cls, mockSettings);
    }

    public static <T> T spy(T... tArr) {
        if (tArr.length <= 0) {
            return (T) spy(getClassOf(tArr));
        }
        throw new IllegalArgumentException("Please don't pass any values here. Java will detect class automagically.");
    }
}
