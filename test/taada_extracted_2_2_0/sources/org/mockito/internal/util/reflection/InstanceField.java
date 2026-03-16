package org.mockito.internal.util.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.util.Checks;

/* JADX INFO: loaded from: classes.dex */
public class InstanceField {
    private final Field field;
    private FieldReader fieldReader;
    private final Object instance;

    public InstanceField(Field field, Object obj) {
        this.field = (Field) Checks.checkNotNull(field, "field");
        this.instance = Checks.checkNotNull(obj, "instance");
    }

    private FieldReader reader() {
        if (this.fieldReader == null) {
            this.fieldReader = new FieldReader(this.instance, this.field);
        }
        return this.fieldReader;
    }

    public <A extends Annotation> A annotation(Class<A> cls) {
        return (A) this.field.getAnnotation(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            InstanceField instanceField = (InstanceField) obj;
            if (this.field.equals(instanceField.field) && this.instance.equals(instanceField.instance)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.instance.hashCode() + (this.field.hashCode() * 31);
    }

    public boolean isAnnotatedBy(Class<? extends Annotation> cls) {
        return this.field.isAnnotationPresent(cls);
    }

    public boolean isNull() {
        return reader().isNull();
    }

    public boolean isSynthetic() {
        return this.field.isSynthetic();
    }

    public Field jdkField() {
        return this.field;
    }

    public String name() {
        return this.field.getName();
    }

    public Object read() {
        return reader().read();
    }

    public void set(Object obj) {
        try {
            Plugins.getMemberAccessor().set(this.field, this.instance, obj);
        } catch (IllegalAccessException e) {
            throw new MockitoException("Access to " + this.field + " was denied", e);
        }
    }

    public String toString() {
        return name();
    }
}
