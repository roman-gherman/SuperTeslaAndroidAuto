package B2;

import A2.C0019a;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import a3.C;
import a3.F;
import a3.K;
import a3.M;
import a3.W;
import a3.d0;
import c3.j;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.List;
import k2.i;
import kotlin.collections.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends W {
    public static final a c = l.f0(2, false, null, 5).b(3);
    public static final a d = l.f0(2, false, null, 5).b(2);
    public final B.h b = new B.h(new z.e(1));

    @Override // a3.W
    public final TypeProjection d(AbstractC0162z abstractC0162z) {
        return new K(h(abstractC0162z, new a(2, false, false, null, 62)));
    }

    public final N1.e g(F f6, ClassDescriptor classDescriptor, a aVar) {
        if (f6.c().getParameters().isEmpty()) {
            return new N1.e(f6, Boolean.FALSE);
        }
        if (i.x(f6)) {
            TypeProjection typeProjection = (TypeProjection) f6.a().get(0);
            d0 projectionKind = typeProjection.getProjectionKind();
            AbstractC0162z type = typeProjection.getType();
            kotlin.jvm.internal.h.e(type, "componentTypeProjection.type");
            return new N1.e(C.c(f6.b(), Z.p(new K(h(type, aVar), projectionKind)), f6.c(), f6.d()), Boolean.FALSE);
        }
        if (l.O(f6)) {
            return new N1.e(j.c(c3.i.ERROR_RAW_TYPE, f6.c().toString()), Boolean.FALSE);
        }
        MemberScope memberScope = classDescriptor.getMemberScope(this);
        kotlin.jvm.internal.h.e(memberScope, "declaration.getMemberScope(this)");
        M mB = f6.b();
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        kotlin.jvm.internal.h.e(typeConstructor, "declaration.typeConstructor");
        List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
        kotlin.jvm.internal.h.e(parameters, "declaration.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(o.D(parameters));
        for (TypeParameterDescriptor parameter : parameters) {
            kotlin.jvm.internal.h.e(parameter, "parameter");
            B.h hVar = this.b;
            arrayList.add(z.e.a(parameter, aVar, hVar, hVar.i(parameter, aVar)));
        }
        return new N1.e(C.e(mB, typeConstructor, arrayList, f6.d(), memberScope, new C0019a(classDescriptor, this, f6, aVar)), Boolean.TRUE);
    }

    public final AbstractC0162z h(AbstractC0162z abstractC0162z, a aVar) {
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            aVar.getClass();
            return h(this.b.i((TypeParameterDescriptor) declarationDescriptor, a.a(aVar, 0, true, null, null, 59)), aVar);
        }
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            throw new IllegalStateException(("Unexpected declaration kind: " + declarationDescriptor).toString());
        }
        ClassifierDescriptor declarationDescriptor2 = AbstractC0132a.j0(abstractC0162z).c().getDeclarationDescriptor();
        if (declarationDescriptor2 instanceof ClassDescriptor) {
            N1.e eVarG = g(AbstractC0132a.Q(abstractC0162z), (ClassDescriptor) declarationDescriptor, c);
            F f6 = (F) eVarG.f1121a;
            boolean zBooleanValue = ((Boolean) eVarG.b).booleanValue();
            N1.e eVarG2 = g(AbstractC0132a.j0(abstractC0162z), (ClassDescriptor) declarationDescriptor2, d);
            F f7 = (F) eVarG2.f1121a;
            return (zBooleanValue || ((Boolean) eVarG2.b).booleanValue()) ? new h(f6, f7) : C.a(f6, f7);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + '\"').toString());
    }
}
