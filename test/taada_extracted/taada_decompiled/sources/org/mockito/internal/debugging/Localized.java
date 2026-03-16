package org.mockito.internal.debugging;

import org.mockito.invocation.Location;

/* JADX INFO: loaded from: classes.dex */
public class Localized<T> {
    private final Location location = LocationFactory.create();
    private final T object;

    public Localized(T t6) {
        this.object = t6;
    }

    public Location getLocation() {
        return this.location;
    }

    public T getObject() {
        return this.object;
    }
}
