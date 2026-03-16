package org.mockito.internal.handler;

import org.mockito.internal.creation.settings.CreationSettings;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.internal.invocation.MatchersBinder;
import org.mockito.internal.listeners.StubbingLookupNotifier;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.stubbing.InvocationContainerImpl;
import org.mockito.internal.stubbing.OngoingStubbingImpl;
import org.mockito.internal.stubbing.StubbedInvocationMatcher;
import org.mockito.internal.stubbing.answers.DefaultAnswerValidator;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.verification.MockAwareVerificationMode;
import org.mockito.internal.verification.VerificationDataImpl;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationContainer;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public class MockHandlerImpl<T> implements MockHandler<T> {
    private static final long serialVersionUID = -2917871070982574165L;
    InvocationContainerImpl invocationContainer;
    MatchersBinder matchersBinder;
    private final MockCreationSettings<T> mockSettings;

    public MockHandlerImpl(MockCreationSettings<T> mockCreationSettings) {
        this.matchersBinder = new MatchersBinder();
        this.mockSettings = mockCreationSettings;
        this.matchersBinder = new MatchersBinder();
        this.invocationContainer = new InvocationContainerImpl(mockCreationSettings);
    }

    @Override // org.mockito.invocation.MockHandler
    public InvocationContainer getInvocationContainer() {
        return this.invocationContainer;
    }

    @Override // org.mockito.invocation.MockHandler
    public MockCreationSettings<T> getMockSettings() {
        return this.mockSettings;
    }

    @Override // org.mockito.invocation.MockHandler
    public Object handle(Invocation invocation) {
        if (this.invocationContainer.hasAnswersForStubbing()) {
            this.invocationContainer.setMethodForStubbing(this.matchersBinder.bindMatchers(ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage(), invocation));
            return null;
        }
        VerificationMode verificationModePullVerificationMode = ThreadSafeMockingProgress.mockingProgress().pullVerificationMode();
        InvocationMatcher invocationMatcherBindMatchers = this.matchersBinder.bindMatchers(ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage(), invocation);
        ThreadSafeMockingProgress.mockingProgress().validateState();
        if (verificationModePullVerificationMode != null) {
            if (MockUtil.areSameMocks(((MockAwareVerificationMode) verificationModePullVerificationMode).getMock(), invocation.getMock())) {
                verificationModePullVerificationMode.verify(new VerificationDataImpl(this.invocationContainer, invocationMatcherBindMatchers));
                return null;
            }
            ThreadSafeMockingProgress.mockingProgress().verificationStarted(verificationModePullVerificationMode);
        }
        this.invocationContainer.setInvocationForPotentialStubbing(invocationMatcherBindMatchers);
        OngoingStubbingImpl ongoingStubbingImpl = new OngoingStubbingImpl(this.invocationContainer);
        ThreadSafeMockingProgress.mockingProgress().reportOngoingStubbing(ongoingStubbingImpl);
        StubbedInvocationMatcher stubbedInvocationMatcherFindAnswerFor = this.invocationContainer.findAnswerFor(invocation);
        StubbingLookupNotifier.notifyStubbedAnswerLookup(invocation, stubbedInvocationMatcherFindAnswerFor, this.invocationContainer.getStubbingsAscending(), (CreationSettings) this.mockSettings);
        if (stubbedInvocationMatcherFindAnswerFor != null) {
            stubbedInvocationMatcherFindAnswerFor.captureArgumentsFrom(invocation);
            try {
                return stubbedInvocationMatcherFindAnswerFor.answer(invocation);
            } finally {
                ThreadSafeMockingProgress.mockingProgress().reportOngoingStubbing(ongoingStubbingImpl);
            }
        }
        try {
            Object objAnswer = this.mockSettings.getDefaultAnswer().answer(invocation);
            DefaultAnswerValidator.validateReturnValueFor(invocation, objAnswer);
            return objAnswer;
        } finally {
            this.invocationContainer.resetInvocationForPotentialStubbing(invocationMatcherBindMatchers);
        }
    }
}
