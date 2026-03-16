package org.mockito.internal.util.reflection;

import java.lang.reflect.Field;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public class FieldReader {
    final MemberAccessor accessor = Plugins.getMemberAccessor();
    final Field field;
    final Object target;

    public FieldReader(Object obj, Field field) {
        this.target = obj;
        this.field = field;
    }

    public boolean isNull() {
        return read() == null;
    }

    public Object read() {
        try {
            return this.accessor.get(this.field, this.target);
        } catch (Exception e) {
            throw new MockitoException("Cannot read state from field: " + this.field + ", on instance: " + this.target, e);
        }
    }
}
