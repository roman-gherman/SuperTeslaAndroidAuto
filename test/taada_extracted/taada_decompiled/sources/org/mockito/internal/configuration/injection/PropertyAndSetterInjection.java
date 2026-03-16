package org.mockito.internal.configuration.injection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import n5.a;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.injection.filter.MockCandidateFilter;
import org.mockito.internal.configuration.injection.filter.NameBasedCandidateFilter;
import org.mockito.internal.configuration.injection.filter.TerminalMockCandidateFilter;
import org.mockito.internal.configuration.injection.filter.TypeBasedCandidateFilter;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.util.collections.Sets;
import org.mockito.internal.util.reflection.FieldInitializationReport;
import org.mockito.internal.util.reflection.FieldInitializer;
import org.mockito.internal.util.reflection.SuperTypesLastSorter;

/* JADX INFO: loaded from: classes.dex */
public class PropertyAndSetterInjection extends MockInjectionStrategy {
    private final MockCandidateFilter mockCandidateFilter = new TypeBasedCandidateFilter(new NameBasedCandidateFilter(new TerminalMockCandidateFilter()));

    private FieldInitializationReport initializeInjectMocksField(Field field, Object obj) {
        try {
            return new FieldInitializer(obj, field).initialize();
        } catch (MockitoException e) {
            if (e.getCause() instanceof InvocationTargetException) {
                throw Reporter.fieldInitialisationThrewException(field, e.getCause().getCause());
            }
            throw Reporter.cannotInitializeForInjectMocksAnnotation(field.getName(), e.getMessage());
        }
    }

    private boolean injectMockCandidates(Class<?> cls, Object obj, Set<Object> set) {
        List<Field> listOrderedInstanceFieldsFrom = orderedInstanceFieldsFrom(cls);
        boolean zInjectMockCandidatesOnFields = injectMockCandidatesOnFields(set, obj, false, listOrderedInstanceFieldsFrom);
        return injectMockCandidatesOnFields(set, obj, zInjectMockCandidatesOnFields, listOrderedInstanceFieldsFrom) | zInjectMockCandidatesOnFields;
    }

    private boolean injectMockCandidatesOnFields(Set<Object> set, Object obj, boolean z6, List<Field> list) {
        Iterator<Field> it = list.iterator();
        while (it.hasNext()) {
            Object objThenInject = this.mockCandidateFilter.filterCandidate(set, it.next(), list, obj).thenInject();
            if (objThenInject != null) {
                set.remove(objThenInject);
                it.remove();
                z6 = true;
            }
        }
        return z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$orderedInstanceFieldsFrom$0(Field field) {
        return (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) ? false : true;
    }

    private List<Field> orderedInstanceFieldsFrom(Class<?> cls) {
        return SuperTypesLastSorter.sortSuperTypesLast((Collection) Arrays.stream(cls.getDeclaredFields()).filter(new a(2)).collect(Collectors.toList()));
    }

    @Override // org.mockito.internal.configuration.injection.MockInjectionStrategy
    public boolean processInjection(Field field, Object obj, Set<Object> set) {
        FieldInitializationReport fieldInitializationReportInitializeInjectMocksField = initializeInjectMocksField(field, obj);
        Object objFieldInstance = fieldInitializationReportInitializeInjectMocksField.fieldInstance();
        boolean zInjectMockCandidates = false;
        for (Class<?> clsFieldClass = fieldInitializationReportInitializeInjectMocksField.fieldClass(); clsFieldClass != Object.class; clsFieldClass = clsFieldClass.getSuperclass()) {
            zInjectMockCandidates |= injectMockCandidates(clsFieldClass, objFieldInstance, Sets.newMockSafeHashSet(set));
        }
        return zInjectMockCandidates;
    }
}
