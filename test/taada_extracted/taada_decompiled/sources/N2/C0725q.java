package n2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;

/* JADX INFO: renamed from: n2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0725q extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0725q f4254a = new C0725q(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        PackageFragmentDescriptor it = (PackageFragmentDescriptor) obj;
        kotlin.jvm.internal.h.f(it, "it");
        return it.getFqName();
    }
}
