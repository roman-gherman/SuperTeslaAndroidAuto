package a3;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: renamed from: a3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0151n implements TypeAttributeTranslator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0151n f1556a = new C0151n();

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator
    public final M toAttributes(Annotations annotations, TypeConstructor typeConstructor, DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.h.f(annotations, "annotations");
        if (annotations.isEmpty()) {
            M.b.getClass();
            return M.c;
        }
        B.h hVar = M.b;
        List listP = io.ktor.utils.io.Z.p(new C0148k(annotations));
        hVar.getClass();
        return B.h.b(listP);
    }
}
