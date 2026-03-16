package a3;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: renamed from: a3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0148k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Annotations f1554a;

    public C0148k(Annotations annotations) {
        kotlin.jvm.internal.h.f(annotations, "annotations");
        this.f1554a = annotations;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0148k) {
            return kotlin.jvm.internal.h.a(((C0148k) obj).f1554a, this.f1554a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1554a.hashCode();
    }
}
