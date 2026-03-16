package t2;

import java.lang.reflect.Field;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n extends kotlin.jvm.internal.e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f4811a = new n(1);

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        return kotlin.jvm.internal.w.f3817a.b(y.class);
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Field;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Field p02 = (Field) obj;
        kotlin.jvm.internal.h.f(p02, "p0");
        return new y(p02);
    }
}
