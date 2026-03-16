package org.mockito.internal.creation.instance;

import org.mockito.creation.instance.Instantiator;
import org.mockito.internal.configuration.GlobalConfiguration;
import r5.b;

/* JADX INFO: loaded from: classes.dex */
class ObjenesisInstantiator implements Instantiator {
    private final b objenesis = new b(new GlobalConfiguration().enableClassCache());

    @Override // org.mockito.creation.instance.Instantiator
    public <T> T newInstance(Class<T> cls) {
        return (T) this.objenesis.newInstance(cls);
    }
}
