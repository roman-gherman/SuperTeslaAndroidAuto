package org.mockito.internal.debugging;

import org.mockito.invocation.Location;

/* JADX INFO: loaded from: classes.dex */
public final class LocationFactory {
    private static final Factory factory = createLocationFactory();

    public interface Factory {
        Location create(boolean z6);
    }

    public static final class Java8LocationFactory implements Factory {
        private Java8LocationFactory() {
        }

        @Override // org.mockito.internal.debugging.LocationFactory.Factory
        public Location create(boolean z6) {
            return new Java8LocationImpl(new Throwable(), z6);
        }
    }

    public static final class Java9PlusLocationFactory implements Factory {
        private Java9PlusLocationFactory() {
        }

        @Override // org.mockito.internal.debugging.LocationFactory.Factory
        public Location create(boolean z6) {
            return new Java9PlusLocationImpl(z6);
        }
    }

    private LocationFactory() {
    }

    public static Location create() {
        return create(false);
    }

    private static Factory createLocationFactory() {
        try {
            Class.forName("java.lang.StackWalker");
            return new Java9PlusLocationFactory();
        } catch (ClassNotFoundException unused) {
            return new Java8LocationFactory();
        }
    }

    public static Location create(boolean z6) {
        return factory.create(z6);
    }
}
