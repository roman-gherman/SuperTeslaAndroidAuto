package org.mockito.internal.configuration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.mockito.ScopedMock;
import org.mockito.internal.configuration.injection.scanner.InjectMocksScanner;
import org.mockito.internal.configuration.injection.scanner.MockScanner;
import org.mockito.internal.util.collections.Sets;
import org.mockito.plugins.AnnotationEngine;

/* JADX INFO: loaded from: classes.dex */
public class InjectingAnnotationEngine implements AnnotationEngine {
    private final AnnotationEngine delegate = new IndependentAnnotationEngine();
    private final AnnotationEngine spyAnnotationEngine = new SpyAnnotationEngine();

    private AutoCloseable injectCloseableMocks(Object obj) {
        HashSet hashSet = new HashSet();
        Set<Object> setNewMockSafeHashSet = Sets.newMockSafeHashSet(new Object[0]);
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            new InjectMocksScanner(superclass).addTo(hashSet);
            new MockScanner(obj, superclass).addPreparedMocks(setNewMockSafeHashSet);
            onInjection(obj, superclass, hashSet, setNewMockSafeHashSet);
        }
        new DefaultInjectionEngine().injectMocksOnFields(hashSet, setNewMockSafeHashSet, obj);
        return new a(setNewMockSafeHashSet, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$injectCloseableMocks$1(Set set) {
        for (Object obj : set) {
            if (obj instanceof ScopedMock) {
                ((ScopedMock) obj).closeOnDemand();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$process$0(List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((AutoCloseable) it.next()).close();
        }
    }

    private List<AutoCloseable> processIndependentAnnotations(Class<?> cls, Object obj) {
        ArrayList arrayList = new ArrayList();
        while (cls != Object.class) {
            arrayList.add(this.delegate.process(cls, obj));
            arrayList.add(this.spyAnnotationEngine.process(cls, obj));
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private List<AutoCloseable> processInjectMocks(Class<?> cls, Object obj) {
        ArrayList arrayList = new ArrayList();
        while (cls != Object.class) {
            arrayList.add(injectCloseableMocks(obj));
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    @Deprecated
    public void injectMocks(Object obj) {
        try {
            injectCloseableMocks(obj).close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void onInjection(Object obj, Class<?> cls, Set<Field> set, Set<Object> set2) {
    }

    @Override // org.mockito.plugins.AnnotationEngine
    public AutoCloseable process(Class<?> cls, Object obj) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(processIndependentAnnotations(obj.getClass(), obj));
        arrayList.addAll(processInjectMocks(obj.getClass(), obj));
        return new a(arrayList, 1);
    }
}
