package org.mockito.internal.creation.bytebuddy;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

/* JADX INFO: loaded from: classes.dex */
public interface BytecodeGenerator {
    static ElementMatcher<MethodDescription> isGroovyMethod(boolean z6) {
        ElementMatcher.Junction junctionOr = ElementMatchers.isDeclaredBy(ElementMatchers.named("groovy.lang.GroovyObjectSupport")).or(ElementMatchers.isAnnotatedWith(ElementMatchers.named("groovy.transform.Internal")));
        return z6 ? junctionOr.or(ElementMatchers.named("$getStaticMetaClass").and(ElementMatchers.returns(ElementMatchers.named("groovy.lang.MetaClass")))) : junctionOr;
    }

    default void clearAllCaches() {
    }

    <T> Class<? extends T> mockClass(MockFeatures<T> mockFeatures);

    void mockClassConstruction(Class<?> cls);

    void mockClassStatic(Class<?> cls);
}
