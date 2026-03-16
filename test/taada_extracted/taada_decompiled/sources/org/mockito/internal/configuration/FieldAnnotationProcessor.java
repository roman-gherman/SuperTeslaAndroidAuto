package org.mockito.internal.configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public interface FieldAnnotationProcessor<A extends Annotation> {
    Object process(A a6, Field field);
}
