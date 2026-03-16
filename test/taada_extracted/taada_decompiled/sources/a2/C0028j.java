package A2;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: renamed from: A2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0028j implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return E1.k.n(R2.e.g((ClassDescriptor) obj).b(), R2.e.g((ClassDescriptor) obj2).b());
    }
}
