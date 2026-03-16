package org.mockito.internal.configuration.injection.filter;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.util.reflection.BeanPropertySetter;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public class TerminalMockCandidateFilter implements MockCandidateFilter {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$filterCandidate$0(Object obj, Field field, Object obj2, MemberAccessor memberAccessor) {
        try {
            if (new BeanPropertySetter(obj, field).set(obj2)) {
                return obj2;
            }
            memberAccessor.set(field, obj, obj2);
            return obj2;
        } catch (IllegalAccessException | RuntimeException e) {
            throw Reporter.cannotInjectDependency(field, obj2, e);
        }
    }

    @Override // org.mockito.internal.configuration.injection.filter.MockCandidateFilter
    public OngoingInjector filterCandidate(Collection<Object> collection, final Field field, List<Field> list, final Object obj) {
        if (collection.size() != 1) {
            return OngoingInjector.nop;
        }
        final Object next = collection.iterator().next();
        final MemberAccessor memberAccessor = Plugins.getMemberAccessor();
        return new OngoingInjector() { // from class: org.mockito.internal.configuration.injection.filter.a
            @Override // org.mockito.internal.configuration.injection.filter.OngoingInjector
            public final Object thenInject() {
                return TerminalMockCandidateFilter.lambda$filterCandidate$0(obj, field, next, memberAccessor);
            }
        };
    }
}
