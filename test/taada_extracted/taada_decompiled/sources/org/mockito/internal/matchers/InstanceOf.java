package org.mockito.internal.matchers;

import java.io.Serializable;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.util.Primitives;

/* JADX INFO: loaded from: classes.dex */
public class InstanceOf implements ArgumentMatcher<Object>, Serializable {
    final Class<?> clazz;
    private final String description;

    public static class VarArgAware extends InstanceOf implements VarargMatcher {
        public VarArgAware(Class<?> cls) {
            super(cls);
        }

        @Override // org.mockito.internal.matchers.InstanceOf, org.mockito.ArgumentMatcher
        public Class<?> type() {
            return this.clazz;
        }

        public VarArgAware(Class<?> cls, String str) {
            super(cls, str);
        }
    }

    public InstanceOf(Class<?> cls) {
        this(cls, "isA(" + cls.getCanonicalName() + ")");
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(Object obj) {
        if (obj != null) {
            return Primitives.isAssignableFromWrapper(obj.getClass(), this.clazz) || this.clazz.isAssignableFrom(obj.getClass());
        }
        return false;
    }

    public String toString() {
        return this.description;
    }

    @Override // org.mockito.ArgumentMatcher
    public Class<?> type() {
        return this.clazz;
    }

    public InstanceOf(Class<?> cls, String str) {
        this.clazz = cls;
        this.description = str;
    }
}
