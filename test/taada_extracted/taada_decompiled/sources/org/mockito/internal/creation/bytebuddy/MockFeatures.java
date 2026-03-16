package org.mockito.internal.creation.bytebuddy;

import java.util.Collections;
import java.util.Set;
import org.mockito.mock.SerializableMode;
import org.mockito.stubbing.Answer;

/* JADX INFO: loaded from: classes.dex */
class MockFeatures<T> {
    final Answer defaultAnswer;
    final Set<Class<?>> interfaces;
    final Class<T> mockedType;
    final SerializableMode serializableMode;
    final boolean stripAnnotations;

    private MockFeatures(Class<T> cls, Set<Class<?>> set, SerializableMode serializableMode, boolean z6, Answer answer) {
        this.mockedType = cls;
        this.interfaces = Collections.unmodifiableSet(set);
        this.serializableMode = serializableMode;
        this.stripAnnotations = z6;
        this.defaultAnswer = answer;
    }

    public static <T> MockFeatures<T> withMockFeatures(Class<T> cls, Set<Class<?>> set, SerializableMode serializableMode, boolean z6, Answer answer) {
        return new MockFeatures<>(cls, set, serializableMode, z6, answer);
    }
}
