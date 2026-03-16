package org.mockito.internal.invocation;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.mockito.ArgumentMatcher;

/* JADX INFO: loaded from: classes.dex */
public class TypeSafeMatching implements ArgumentMatcherAction {
    private static final ArgumentMatcherAction TYPE_SAFE_MATCHING_ACTION = new TypeSafeMatching();
    private static final ConcurrentMap<Class<?>, Class<?>> argumentTypeCache = new ConcurrentHashMap();

    private TypeSafeMatching() {
    }

    private static Class<?> getArgumentType(ArgumentMatcher<?> argumentMatcher) {
        Class<?> cls = argumentMatcher.getClass();
        ConcurrentMap<Class<?>, Class<?>> concurrentMap = argumentTypeCache;
        Class<?> cls2 = concurrentMap.get(cls);
        return cls2 != null ? cls2 : concurrentMap.computeIfAbsent(cls, new a(argumentMatcher, 0));
    }

    private static Class<?> getArgumentTypeUncached(ArgumentMatcher<?> argumentMatcher) {
        for (Method method : argumentMatcher.getClass().getMethods()) {
            if (isMatchesMethod(method)) {
                return method.getParameterTypes()[0];
            }
        }
        throw new NoSuchMethodError("Method 'matches(T)' not found in ArgumentMatcher: " + argumentMatcher + " !\r\n Please file a bug with this stack trace at: https://github.com/mockito/mockito/issues/new ");
    }

    private static boolean isCompatible(ArgumentMatcher<?> argumentMatcher, Object obj) {
        if (obj == null) {
            return true;
        }
        return getArgumentType(argumentMatcher).isInstance(obj);
    }

    private static boolean isMatchesMethod(Method method) {
        if (method.getParameterTypes().length == 1 && !method.isBridge()) {
            return "matches".equals(method.getName());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$getArgumentType$0(ArgumentMatcher argumentMatcher, Class cls) {
        return getArgumentTypeUncached(argumentMatcher);
    }

    public static ArgumentMatcherAction matchesTypeSafe() {
        return TYPE_SAFE_MATCHING_ACTION;
    }

    @Override // org.mockito.internal.invocation.ArgumentMatcherAction
    public boolean apply(ArgumentMatcher argumentMatcher, Object obj) {
        return isCompatible(argumentMatcher, obj) && argumentMatcher.matches(obj);
    }
}
