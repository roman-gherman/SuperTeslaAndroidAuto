package org.mockito;

import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.VerificationMode;

/* JADX INFO: loaded from: classes.dex */
public class BDDMockito extends Mockito {

    public interface BDDMyOngoingStubbing<T> {
        <M> M getMock();

        BDDMyOngoingStubbing<T> will(Answer<?> answer);

        BDDMyOngoingStubbing<T> willAnswer(Answer<?> answer);

        BDDMyOngoingStubbing<T> willCallRealMethod();

        BDDMyOngoingStubbing<T> willReturn(T t6);

        BDDMyOngoingStubbing<T> willReturn(T t6, T... tArr);

        BDDMyOngoingStubbing<T> willThrow(Class<? extends Throwable> cls);

        BDDMyOngoingStubbing<T> willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr);

        BDDMyOngoingStubbing<T> willThrow(Throwable... thArr);
    }

    public static class BDDOngoingStubbingImpl<T> implements BDDMyOngoingStubbing<T> {
        private final OngoingStubbing<T> mockitoOngoingStubbing;

        public BDDOngoingStubbingImpl(OngoingStubbing<T> ongoingStubbing) {
            this.mockitoOngoingStubbing = ongoingStubbing;
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public <M> M getMock() {
            return (M) this.mockitoOngoingStubbing.getMock();
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public BDDMyOngoingStubbing<T> will(Answer<?> answer) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.then(answer));
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public BDDMyOngoingStubbing<T> willAnswer(Answer<?> answer) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenAnswer(answer));
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public BDDMyOngoingStubbing<T> willCallRealMethod() {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenCallRealMethod());
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public BDDMyOngoingStubbing<T> willReturn(T t6) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenReturn(t6));
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public BDDMyOngoingStubbing<T> willThrow(Throwable... thArr) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenThrow(thArr));
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public BDDMyOngoingStubbing<T> willReturn(T t6, T... tArr) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenReturn(t6, tArr));
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public BDDMyOngoingStubbing<T> willThrow(Class<? extends Throwable> cls) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenThrow(cls));
        }

        @Override // org.mockito.BDDMockito.BDDMyOngoingStubbing
        public BDDMyOngoingStubbing<T> willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
            return new BDDOngoingStubbingImpl(this.mockitoOngoingStubbing.thenThrow(cls, clsArr));
        }
    }

    public interface BDDStubber {
        <T> T given(T t6);

        BDDStubber will(Answer<?> answer);

        BDDStubber willAnswer(Answer<?> answer);

        BDDStubber willCallRealMethod();

        BDDStubber willDoNothing();

        BDDStubber willReturn(Object obj);

        BDDStubber willReturn(Object obj, Object... objArr);

        BDDStubber willThrow(Class<? extends Throwable> cls);

        BDDStubber willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr);

        BDDStubber willThrow(Throwable... thArr);
    }

    public static class BDDStubberImpl implements BDDStubber {
        private final Stubber mockitoStubber;

        public BDDStubberImpl(Stubber stubber) {
            this.mockitoStubber = stubber;
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public <T> T given(T t6) {
            return (T) this.mockitoStubber.when(t6);
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber will(Answer<?> answer) {
            return new BDDStubberImpl(this.mockitoStubber.doAnswer(answer));
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber willAnswer(Answer<?> answer) {
            return new BDDStubberImpl(this.mockitoStubber.doAnswer(answer));
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber willCallRealMethod() {
            return new BDDStubberImpl(this.mockitoStubber.doCallRealMethod());
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber willDoNothing() {
            return new BDDStubberImpl(this.mockitoStubber.doNothing());
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber willReturn(Object obj) {
            return new BDDStubberImpl(this.mockitoStubber.doReturn(obj));
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber willThrow(Throwable... thArr) {
            return new BDDStubberImpl(this.mockitoStubber.doThrow(thArr));
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber willReturn(Object obj, Object... objArr) {
            return new BDDStubberImpl(this.mockitoStubber.doReturn(obj).doReturn(objArr));
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber willThrow(Class<? extends Throwable> cls) {
            return new BDDStubberImpl(this.mockitoStubber.doThrow(cls));
        }

        @Override // org.mockito.BDDMockito.BDDStubber
        public BDDStubber willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
            return new BDDStubberImpl(this.mockitoStubber.doThrow(cls, clsArr));
        }
    }

    public interface Then<T> {
        T should();

        T should(InOrder inOrder);

        T should(InOrder inOrder, VerificationMode verificationMode);

        T should(VerificationMode verificationMode);

        void shouldHaveNoInteractions();

        void shouldHaveNoMoreInteractions();
    }

    public static class ThenImpl<T> implements Then<T> {
        private final T mock;

        public ThenImpl(T t6) {
            this.mock = t6;
        }

        @Override // org.mockito.BDDMockito.Then
        public T should() {
            return (T) Mockito.verify(this.mock);
        }

        @Override // org.mockito.BDDMockito.Then
        public void shouldHaveNoInteractions() {
            Mockito.verifyNoInteractions(this.mock);
        }

        @Override // org.mockito.BDDMockito.Then
        public void shouldHaveNoMoreInteractions() {
            Mockito.verifyNoMoreInteractions(this.mock);
        }

        @Override // org.mockito.BDDMockito.Then
        public T should(VerificationMode verificationMode) {
            return (T) Mockito.verify(this.mock, verificationMode);
        }

        @Override // org.mockito.BDDMockito.Then
        public T should(InOrder inOrder) {
            return (T) inOrder.verify(this.mock);
        }

        @Override // org.mockito.BDDMockito.Then
        public T should(InOrder inOrder, VerificationMode verificationMode) {
            return (T) inOrder.verify(this.mock, verificationMode);
        }
    }

    public static <T> BDDMyOngoingStubbing<T> given(T t6) {
        return new BDDOngoingStubbingImpl(Mockito.when(t6));
    }

    public static <T> Then<T> then(T t6) {
        return new ThenImpl(t6);
    }

    public static BDDStubber will(Answer<?> answer) {
        return new BDDStubberImpl(Mockito.doAnswer(answer));
    }

    public static BDDStubber willAnswer(Answer<?> answer) {
        return new BDDStubberImpl(Mockito.doAnswer(answer));
    }

    public static BDDStubber willCallRealMethod() {
        return new BDDStubberImpl(Mockito.doCallRealMethod());
    }

    public static BDDStubber willDoNothing() {
        return new BDDStubberImpl(Mockito.doNothing());
    }

    public static BDDStubber willReturn(Object obj) {
        return new BDDStubberImpl(Mockito.doReturn(obj));
    }

    public static BDDStubber willThrow(Throwable... thArr) {
        return new BDDStubberImpl(Mockito.doThrow(thArr));
    }

    public static BDDStubber willReturn(Object obj, Object... objArr) {
        return new BDDStubberImpl(Mockito.doReturn(obj, objArr));
    }

    public static BDDStubber willThrow(Class<? extends Throwable> cls) {
        return new BDDStubberImpl(Mockito.doThrow(cls));
    }

    public static BDDStubber willThrow(Class<? extends Throwable> cls, Class<? extends Throwable>... clsArr) {
        return new BDDStubberImpl(Mockito.doThrow(cls, clsArr));
    }
}
