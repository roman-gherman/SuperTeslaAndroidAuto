package org.mockito.internal.matchers;

import org.mockito.ArgumentMatcher;
import org.mockito.internal.debugging.LocationFactory;
import org.mockito.invocation.Location;

/* JADX INFO: loaded from: classes.dex */
public class LocalizedMatcher {
    private final Location location = LocationFactory.create();
    private final ArgumentMatcher<?> matcher;

    public LocalizedMatcher(ArgumentMatcher<?> argumentMatcher) {
        this.matcher = argumentMatcher;
    }

    public Location getLocation() {
        return this.location;
    }

    public ArgumentMatcher<?> getMatcher() {
        return this.matcher;
    }
}
