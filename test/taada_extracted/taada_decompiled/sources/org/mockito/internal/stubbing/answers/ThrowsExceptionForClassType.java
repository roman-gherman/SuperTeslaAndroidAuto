package org.mockito.internal.stubbing.answers;

import java.io.Serializable;
import org.mockito.internal.configuration.plugins.Plugins;

/* JADX INFO: loaded from: classes.dex */
public class ThrowsExceptionForClassType extends AbstractThrowsException implements Serializable {
    private final Class<? extends Throwable> throwableClass;

    public ThrowsExceptionForClassType(Class<? extends Throwable> cls) {
        this.throwableClass = cls;
    }

    @Override // org.mockito.internal.stubbing.answers.AbstractThrowsException
    public Throwable getThrowable() {
        return (Throwable) Plugins.getInstantiatorProvider().getInstantiator(null).newInstance(this.throwableClass);
    }
}
