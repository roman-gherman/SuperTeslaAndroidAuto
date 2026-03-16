package w2;

import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;

/* JADX INFO: renamed from: w2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0877k implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaCallableMemberDescriptor f5015a;

    public C0877k(JavaCallableMemberDescriptor target) {
        kotlin.jvm.internal.h.f(target, "target");
        this.f5015a = target;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0877k other = (C0877k) obj;
        kotlin.jvm.internal.h.f(other, "other");
        return f.s.a(2, 2);
    }
}
