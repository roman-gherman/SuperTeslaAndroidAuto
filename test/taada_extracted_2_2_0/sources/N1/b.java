package N1;

import java.io.Serializable;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Lazy, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1119a;

    public b(Object obj) {
        this.f1119a = obj;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        return this.f1119a;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return true;
    }

    public final String toString() {
        return String.valueOf(this.f1119a);
    }
}
