package org.mockito.internal.util.reflection;

/* JADX INFO: loaded from: classes.dex */
public class FieldInitializationReport {
    private final Object fieldInstance;
    private final boolean wasInitialized;
    private final boolean wasInitializedUsingConstructorArgs;

    public FieldInitializationReport(Object obj, boolean z6, boolean z7) {
        this.fieldInstance = obj;
        this.wasInitialized = z6;
        this.wasInitializedUsingConstructorArgs = z7;
    }

    public Class<?> fieldClass() {
        Object obj = this.fieldInstance;
        if (obj != null) {
            return obj.getClass();
        }
        return null;
    }

    public Object fieldInstance() {
        return this.fieldInstance;
    }

    public boolean fieldWasInitialized() {
        return this.wasInitialized;
    }

    public boolean fieldWasInitializedUsingContructorArgs() {
        return this.wasInitializedUsingConstructorArgs;
    }
}
