package org.mockito.internal.configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.ScopedMock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.plugins.AnnotationEngine;

/* JADX INFO: loaded from: classes.dex */
public class IndependentAnnotationEngine implements AnnotationEngine {
    private final Map<Class<? extends Annotation>, FieldAnnotationProcessor<?>> annotationProcessorMap = new HashMap();

    public IndependentAnnotationEngine() {
        registerAnnotationProcessor(Mock.class, new MockAnnotationProcessor());
        registerAnnotationProcessor(Captor.class, new CaptorAnnotationProcessor());
    }

    private Object createMockFor(Annotation annotation, Field field) {
        return forAnnotation(annotation).process(annotation, field);
    }

    private <A extends Annotation> FieldAnnotationProcessor<A> forAnnotation(A a6) {
        return this.annotationProcessorMap.containsKey(a6.annotationType()) ? (FieldAnnotationProcessor) this.annotationProcessorMap.get(a6.annotationType()) : (FieldAnnotationProcessor<A>) new FieldAnnotationProcessor<A>() { // from class: org.mockito.internal.configuration.IndependentAnnotationEngine.1
            /* JADX WARN: Incorrect types in method signature: (TA;Ljava/lang/reflect/Field;)Ljava/lang/Object; */
            @Override // org.mockito.internal.configuration.FieldAnnotationProcessor
            public Object process(Annotation annotation, Field field) {
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$process$0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ScopedMock) it.next()).closeOnDemand();
        }
    }

    private <A extends Annotation> void registerAnnotationProcessor(Class<A> cls, FieldAnnotationProcessor<A> fieldAnnotationProcessor) {
        this.annotationProcessorMap.put(cls, fieldAnnotationProcessor);
    }

    @Override // org.mockito.plugins.AnnotationEngine
    public AutoCloseable process(Class<?> cls, Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            boolean z6 = false;
            for (Annotation annotation : field.getAnnotations()) {
                Object objCreateMockFor = createMockFor(annotation, field);
                if (objCreateMockFor instanceof ScopedMock) {
                    arrayList.add((ScopedMock) objCreateMockFor);
                }
                if (objCreateMockFor != null) {
                    throwIfAlreadyAssigned(field, z6);
                    try {
                        Plugins.getMemberAccessor().set(field, obj, objCreateMockFor);
                        z6 = true;
                    } catch (Exception e) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((ScopedMock) it.next()).close();
                        }
                        throw new MockitoException("Problems setting field " + field.getName() + " annotated with " + annotation, e);
                    }
                }
            }
        }
        return new a(arrayList, 0);
    }

    public void throwIfAlreadyAssigned(Field field, boolean z6) {
        if (z6) {
            throw Reporter.moreThanOneAnnotationNotAllowed(field.getName());
        }
    }
}
