package org.mockito;

import java.lang.reflect.Constructor;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MockedConstruction<T> extends ScopedMock {

    public interface Context {
        List<?> arguments();

        Constructor<?> constructor();

        int getCount();
    }

    public interface MockInitializer<T> {
        void prepare(T t6, Context context);
    }

    List<T> constructed();
}
