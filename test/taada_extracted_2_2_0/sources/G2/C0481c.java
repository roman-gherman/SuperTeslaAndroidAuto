package g2;

import G2.C0125z;
import X2.o;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.w;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: g2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0481c extends e implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0481c f3304a = new C0481c(2);

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        return "loadFunction";
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        return w.f3818a.b(o.class);
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        o p02 = (o) obj;
        C0125z p12 = (C0125z) obj2;
        h.f(p02, "p0");
        h.f(p12, "p1");
        return p02.e(p12);
    }
}
