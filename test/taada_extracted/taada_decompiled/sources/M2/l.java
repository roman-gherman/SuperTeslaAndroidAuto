package M2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f1058a = new l(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DescriptorRendererOptions withOptions = (DescriptorRendererOptions) obj;
        kotlin.jvm.internal.h.f(withOptions, "$this$withOptions");
        withOptions.setClassifierNamePolicy(C0127b.c);
        withOptions.setParameterNameRenderingPolicy(B.b);
        return N1.m.f1129a;
    }
}
