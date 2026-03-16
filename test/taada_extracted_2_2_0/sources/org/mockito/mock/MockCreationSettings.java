package org.mockito.mock;

import java.util.List;
import java.util.Set;
import org.mockito.NotExtensible;
import org.mockito.listeners.InvocationListener;
import org.mockito.listeners.StubbingLookupListener;
import org.mockito.listeners.VerificationStartedListener;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
@NotExtensible
public interface MockCreationSettings<T> {
    Object[] getConstructorArgs();

    Answer<?> getDefaultAnswer();

    Set<Class<?>> getExtraInterfaces();

    List<InvocationListener> getInvocationListeners();

    String getMockMaker();

    MockName getMockName();

    Object getOuterClassInstance();

    SerializableMode getSerializableMode();

    Object getSpiedInstance();

    Strictness getStrictness();

    List<StubbingLookupListener> getStubbingLookupListeners();

    Class<T> getTypeToMock();

    List<VerificationStartedListener> getVerificationStartedListeners();

    @Deprecated
    boolean isLenient();

    boolean isSerializable();

    boolean isStripAnnotations();

    boolean isStubOnly();

    boolean isUsingConstructor();
}
