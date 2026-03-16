package c3;

import io.ktor.utils.io.internal.t;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f1775a = new j();
    public static final d b = d.f1747a;
    public static final C0242a c = new C0242a(L2.f.g(String.format("<Error class: %s>", Arrays.copyOf(new Object[]{"unknown class"}, 1))));
    public static final g d = c(i.CYCLIC_SUPERTYPES, new String[0]);
    public static final g e = c(i.ERROR_PROPERTY_TYPE, new String[0]);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f1776f = t.p(new e());

    public static final f a(int i, boolean z6, String... formatParams) {
        com.google.protobuf.a.p(i, "kind");
        kotlin.jvm.internal.h.f(formatParams, "formatParams");
        if (!z6) {
            return new f(i, (String[]) Arrays.copyOf(formatParams, formatParams.length));
        }
        String[] formatParams2 = (String[]) Arrays.copyOf(formatParams, formatParams.length);
        kotlin.jvm.internal.h.f(formatParams2, "formatParams");
        return new k(i, (String[]) Arrays.copyOf(formatParams2, formatParams2.length));
    }

    public static final f b(int i, String... strArr) {
        com.google.protobuf.a.p(i, "kind");
        return a(i, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final g c(i kind, String... strArr) {
        kotlin.jvm.internal.h.f(kind, "kind");
        u uVar = u.f3804a;
        String[] formatParams = (String[]) Arrays.copyOf(strArr, strArr.length);
        kotlin.jvm.internal.h.f(formatParams, "formatParams");
        return e(kind, uVar, d(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static h d(i kind, String... formatParams) {
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(formatParams, "formatParams");
        return new h(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static g e(i kind, List list, TypeConstructor typeConstructor, String... formatParams) {
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(formatParams, "formatParams");
        return new g(typeConstructor, b(7, typeConstructor.toString()), kind, list, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final boolean f(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return (declarationDescriptor instanceof C0242a) || (declarationDescriptor.getContainingDeclaration() instanceof C0242a) || declarationDescriptor == b;
        }
        return false;
    }
}
