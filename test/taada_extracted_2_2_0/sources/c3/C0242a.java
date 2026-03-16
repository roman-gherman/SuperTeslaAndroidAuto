package c3;

import Z2.n;
import a3.W;
import a3.Z;
import io.ktor.utils.io.internal.t;
import java.util.List;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import n2.AbstractC0713e;
import n2.EnumC0709a;
import n2.EnumC0711c;
import n2.EnumC0719k;
import q2.C0773j;
import q2.C0775l;

/* JADX INFO: renamed from: c3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0242a extends C0775l {
    /* JADX WARN: Illegal instructions before constructor call */
    public C0242a(L2.f fVar) {
        j jVar = j.f1775a;
        d dVar = j.b;
        EnumC0719k enumC0719k = EnumC0719k.c;
        EnumC0711c enumC0711c = EnumC0711c.f4229a;
        List list = u.f3805a;
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        super(dVar, fVar, enumC0719k, enumC0711c, list, sourceElement, n.e);
        Annotations.Companion.getClass();
        C0773j c0773j = new C0773j(this, null, o2.f.b, true, EnumC0709a.f4227a, sourceElement);
        c0773j.t(list, AbstractC0713e.d);
        String str = c0773j.getName().f962a;
        kotlin.jvm.internal.h.e(str, "errorConstructor.name.toString()");
        f fVarB = j.b(9, str, "");
        i iVar = i.ERROR_CLASS;
        c0773j.f4630g = new g(j.d(iVar, new String[0]), fVarB, iVar, list, false, new String[0]);
        e(fVarB, t.p(c0773j), c0773j);
    }

    @Override // q2.AbstractC0765b, q2.AbstractC0762A
    public final MemberScope a(W typeSubstitution, b3.d dVar) {
        kotlin.jvm.internal.h.f(typeSubstitution, "typeSubstitution");
        String str = getName().f962a;
        kotlin.jvm.internal.h.e(str, "name.toString()");
        return j.b(9, str, typeSubstitution.toString());
    }

    @Override // q2.AbstractC0765b
    /* JADX INFO: renamed from: d */
    public final ClassDescriptor substitute(Z substitutor) {
        kotlin.jvm.internal.h.f(substitutor, "substitutor");
        return this;
    }

    @Override // q2.AbstractC0765b, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final DeclarationDescriptorNonRoot substitute(Z substitutor) {
        kotlin.jvm.internal.h.f(substitutor, "substitutor");
        return this;
    }

    @Override // q2.C0775l
    public final String toString() {
        String strB = getName().b();
        kotlin.jvm.internal.h.e(strB, "name.asString()");
        return strB;
    }
}
