package org.mockito;

import java.io.Serializable;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.StubbingLookupListener;
import org.mockito.listeners.VerificationStartedListener;
import org.mockito.mock.MockCreationSettings;
import org.mockito.mock.SerializableMode;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface MockSettings extends Serializable {
    <T> MockCreationSettings<T> build(Class<T> cls);

    <T> MockCreationSettings<T> buildStatic(Class<T> cls);

    MockSettings defaultAnswer(Answer answer);

    MockSettings extraInterfaces(Class<?>... clsArr);

    MockSettings invocationListeners(InvocationListener... invocationListenerArr);

    @Deprecated
    MockSettings lenient();

    MockSettings mockMaker(String str);

    MockSettings name(String str);

    MockSettings outerInstance(Object obj);

    MockSettings serializable();

    MockSettings serializable(SerializableMode serializableMode);

    MockSettings spiedInstance(Object obj);

    MockSettings strictness(Strictness strictness);

    MockSettings stubOnly();

    MockSettings stubbingLookupListeners(StubbingLookupListener... stubbingLookupListenerArr);

    MockSettings useConstructor(Object... objArr);

    MockSettings verboseLogging();

    MockSettings verificationStartedListeners(VerificationStartedListener... verificationStartedListenerArr);

    MockSettings withoutAnnotations();
}
