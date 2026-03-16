package R2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.w;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b extends kotlin.jvm.internal.e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1271a = new b(1);

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        return "declaresDefaultValue";
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        return w.f3817a.b(ValueParameterDescriptor.class);
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        return "declaresDefaultValue()Z";
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ValueParameterDescriptor p02 = (ValueParameterDescriptor) obj;
        h.f(p02, "p0");
        return Boolean.valueOf(p02.declaresDefaultValue());
    }
}
