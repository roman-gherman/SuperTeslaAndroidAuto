package h2;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3453a;
    public final int b;

    public y0(ClassLoader classLoader) {
        this.f3453a = new WeakReference(classLoader);
        this.b = System.identityHashCode(classLoader);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof y0) && this.f3453a.get() == ((y0) obj).f3453a.get();
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        String string;
        ClassLoader classLoader = (ClassLoader) this.f3453a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
