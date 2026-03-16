package M2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;

/* JADX INFO: renamed from: M2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0131f extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0131f f1052a = new C0131f(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DescriptorRendererOptions withOptions = (DescriptorRendererOptions) obj;
        kotlin.jvm.internal.h.f(withOptions, "$this$withOptions");
        withOptions.setModifiers(kotlin.collections.w.f3806a);
        withOptions.setClassifierNamePolicy(C0127b.c);
        withOptions.setParameterNameRenderingPolicy(B.b);
        return N1.m.f1129a;
    }
}
