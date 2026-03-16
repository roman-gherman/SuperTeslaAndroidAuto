package androidx.test.internal.platform.reflect;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ReflectiveField<T> {
    private final String className;
    private Field field;
    private final String fieldName;
    private boolean initialized = false;

    public ReflectiveField(String str, String str2) {
        this.className = str;
        this.fieldName = str2;
    }

    private synchronized void initIfNecessary() {
        if (this.initialized) {
            return;
        }
        Field declaredField = Class.forName(this.className).getDeclaredField(this.fieldName);
        this.field = declaredField;
        declaredField.setAccessible(true);
        this.initialized = true;
    }

    public T get(Object obj) throws ReflectionException {
        try {
            initIfNecessary();
            return (T) this.field.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            throw new ReflectionException(e);
        }
    }
}
