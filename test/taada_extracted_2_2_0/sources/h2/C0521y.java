package h2;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: h2.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0521y extends kotlin.jvm.internal.e implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0521y f3453a = new C0521y(2);

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        return "loadProperty";
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        return kotlin.jvm.internal.w.f3818a.b(X2.o.class);
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        X2.o p02 = (X2.o) obj;
        G2.H p12 = (G2.H) obj2;
        kotlin.jvm.internal.h.f(p02, "p0");
        kotlin.jvm.internal.h.f(p12, "p1");
        return p02.f(p12);
    }
}
