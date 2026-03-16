package h2;

import a3.AbstractC0162z;
import c4.AbstractC0246d;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import t2.AbstractC0823e;

/* JADX INFO: renamed from: h2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0499b extends kotlin.jvm.internal.i implements Function1 {
    public static final C0499b b = new C0499b(1, 0);
    public static final C0499b c = new C0499b(1, 1);
    public static final C0499b d = new C0499b(1, 2);
    public static final C0499b e = new C0499b(1, 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0499b f3391f = new C0499b(1, 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0499b f3392g = new C0499b(1, 5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0499b f3393h = new C0499b(1, 6);
    public static final C0499b i = new C0499b(1, 7);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0499b f3394j = new C0499b(1, 8);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0499b f3395k = new C0499b(1, 9);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0499b f3396l = new C0499b(1, 10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0499b f3397m = new C0499b(1, 11);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3398a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0499b(int i3, int i4) {
        super(i3);
        this.f3398a = i4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        kotlin.collections.u uVar = kotlin.collections.u.f3805a;
        switch (this.f3398a) {
            case 0:
                Class it = (Class) obj;
                kotlin.jvm.internal.h.f(it, "it");
                return AbstractC0246d.C(AbstractC0500c.a(it), uVar, false, uVar);
            case 1:
                kotlin.jvm.internal.h.f((Class) obj, "it");
                return new ConcurrentHashMap();
            case 2:
                Class it2 = (Class) obj;
                kotlin.jvm.internal.h.f(it2, "it");
                return AbstractC0246d.C(AbstractC0500c.a(it2), uVar, true, uVar);
            case 3:
                Class it3 = (Class) obj;
                kotlin.jvm.internal.h.f(it3, "it");
                return new C0522z(it3);
            case 4:
                Class it4 = (Class) obj;
                kotlin.jvm.internal.h.f(it4, "it");
                return new S(it4);
            case 5:
                Class<?> returnType = ((Method) obj).getReturnType();
                kotlin.jvm.internal.h.e(returnType, "it.returnType");
                return AbstractC0823e.b(returnType);
            case 6:
                Class it5 = (Class) obj;
                kotlin.jvm.internal.h.e(it5, "it");
                return AbstractC0823e.b(it5);
            case 7:
                FunctionDescriptor descriptor = (FunctionDescriptor) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                return M2.n.c.k(descriptor) + " | " + v0.c(descriptor).c();
            case 8:
                PropertyDescriptor descriptor2 = (PropertyDescriptor) obj;
                kotlin.jvm.internal.h.f(descriptor2, "descriptor");
                return M2.n.c.k(descriptor2) + " | " + v0.b(descriptor2).c();
            case 9:
                M2.s sVar = u0.f3434a;
                AbstractC0162z type = ((ValueParameterDescriptor) obj).getType();
                kotlin.jvm.internal.h.e(type, "it.type");
                return u0.d(type);
            case 10:
                M2.s sVar2 = u0.f3434a;
                AbstractC0162z type2 = ((ValueParameterDescriptor) obj).getType();
                kotlin.jvm.internal.h.e(type2, "it.type");
                return u0.d(type2);
            default:
                Class it6 = (Class) obj;
                kotlin.jvm.internal.h.e(it6, "it");
                return AbstractC0823e.b(it6);
        }
    }
}
