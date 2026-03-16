package q2;

import a3.AbstractC0162z;
import a3.C0148k;
import a3.C0150m;
import a3.W;
import a3.Z;
import a3.b0;
import a3.d0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import n2.AbstractC0714f;
import n2.C0717i;
import n2.C0721m;
import n2.EnumC0711c;
import n2.EnumC0719k;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends AbstractC0762A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0762A f4648a;
    public final Z b;
    public Z c;
    public ArrayList d;
    public ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0150m f4649f;

    public z(AbstractC0762A abstractC0762A, Z z6) {
        this.f4648a = abstractC0762A;
        this.b = z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void c(int r15) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.z.c(int):void");
    }

    @Override // q2.AbstractC0762A
    public final MemberScope a(W w5, b3.d dVar) {
        if (w5 == null) {
            c(5);
            throw null;
        }
        MemberScope memberScopeA = this.f4648a.a(w5, dVar);
        if (!this.b.f1542a.e()) {
            return new U2.q(memberScopeA, d());
        }
        if (memberScopeA != null) {
            return memberScopeA;
        }
        c(7);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, obj);
    }

    @Override // q2.AbstractC0762A
    public final MemberScope b(b3.d dVar) {
        MemberScope memberScopeB = this.f4648a.b(dVar);
        if (!this.b.f1542a.e()) {
            return new U2.q(memberScopeB, d());
        }
        if (memberScopeB != null) {
            return memberScopeB;
        }
        c(14);
        throw null;
    }

    public final Z d() {
        if (this.c == null) {
            Z z6 = this.b;
            if (z6.f1542a.e()) {
                this.c = z6;
            } else {
                List<TypeParameterDescriptor> parameters = this.f4648a.getTypeConstructor().getParameters();
                this.d = new ArrayList(parameters.size());
                this.c = E1.k.l0(parameters, z6.g(), this, this.d);
                ArrayList arrayList = this.d;
                kotlin.jvm.internal.h.f(arrayList, "<this>");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (!((TypeParameterDescriptor) obj).isCapturedFromOuterDeclaration()) {
                        arrayList2.add(obj);
                    }
                }
                this.e = arrayList2;
            }
        }
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        Annotations annotations = this.f4648a.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        c(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassDescriptor getCompanionObjectDescriptor() {
        return this.f4648a.getCompanionObjectDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.f4648a.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            arrayList.add(((ClassConstructorDescriptor) classConstructorDescriptor.newCopyBuilder().setOriginal(classConstructorDescriptor.getOriginal()).setModality(classConstructorDescriptor.getModality()).setVisibility(classConstructorDescriptor.getVisibility()).setKind(classConstructorDescriptor.getKind()).setCopyOverrides(false).build()).substitute(d()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.f4648a.getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        c(22);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final List getContextReceivers() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        c(17);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final List getDeclaredTypeParameters() {
        d();
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            return arrayList;
        }
        c(30);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final a3.F getDefaultType() {
        a3.M mB;
        List listE = b0.e(getTypeConstructor().getParameters());
        Annotations annotations = getAnnotations();
        if (annotations.isEmpty()) {
            a3.M.b.getClass();
            mB = a3.M.c;
        } else {
            B.h hVar = a3.M.b;
            List listP = io.ktor.utils.io.Z.p(new C0148k(annotations));
            hVar.getClass();
            mB = B.h.b(listP);
        }
        return a3.C.d(mB, listE, getUnsubstitutedMemberScope(), getTypeConstructor(), false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final EnumC0711c getKind() {
        EnumC0711c kind = this.f4648a.getKind();
        if (kind != null) {
            return kind;
        }
        c(25);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getMemberScope(W w5) {
        if (w5 != null) {
            R2.e.i(N2.f.d(this));
            return a(w5, b3.c.f1699a);
        }
        c(10);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        EnumC0719k modality = this.f4648a.getModality();
        if (modality != null) {
            return modality;
        }
        c(26);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public final L2.f getName() {
        L2.f name = this.f4648a.getName();
        if (name != null) {
            return name;
        }
        c(20);
        throw null;
    }

    @Override // q2.AbstractC0762A, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ClassDescriptor getOriginal() {
        ClassDescriptor original = this.f4648a.getOriginal();
        if (original != null) {
            return original;
        }
        c(21);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.f4648a.getSealedSubclasses();
        if (sealedSubclasses != null) {
            return sealedSubclasses;
        }
        c(31);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public final SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        if (sourceElement != null) {
            return sourceElement;
        }
        c(29);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getStaticScope() {
        MemberScope staticScope = this.f4648a.getStaticScope();
        if (staticScope != null) {
            return staticScope;
        }
        c(15);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.f4648a.getTypeConstructor();
        if (this.b.f1542a.e()) {
            if (typeConstructor != null) {
                return typeConstructor;
            }
            c(0);
            throw null;
        }
        if (this.f4649f == null) {
            Z zD = d();
            Collection<AbstractC0162z> supertypes = typeConstructor.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            Iterator<AbstractC0162z> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(zD.j(it.next(), d0.INVARIANT));
            }
            this.f4649f = new C0150m(this, this.d, arrayList, Z2.n.e);
        }
        C0150m c0150m = this.f4649f;
        if (c0150m != null) {
            return c0150m;
        }
        c(1);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope unsubstitutedInnerClassesScope = this.f4648a.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope != null) {
            return unsubstitutedInnerClassesScope;
        }
        c(28);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getUnsubstitutedMemberScope() {
        R2.e.i(N2.f.d(this.f4648a));
        return b(b3.c.f1699a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.f4648a.getUnsubstitutedPrimaryConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final n2.z getValueClassRepresentation() {
        n2.z valueClassRepresentation = this.f4648a.getValueClassRepresentation();
        if (valueClassRepresentation == null) {
            return null;
        }
        boolean z6 = valueClassRepresentation instanceof C0717i;
        d0 d0Var = d0.INVARIANT;
        Z z7 = this.b;
        if (z6) {
            C0717i c0717i = (C0717i) valueClassRepresentation;
            a3.F f6 = (a3.F) c0717i.b;
            if (f6 != null && !z7.f1542a.e()) {
                f6 = (a3.F) d().j(f6, d0Var);
            }
            return new C0717i(c0717i.f4245a, f6);
        }
        if (!(valueClassRepresentation instanceof C0721m)) {
            throw new C0.x();
        }
        ArrayList<N1.e> arrayList = ((C0721m) valueClassRepresentation).f4249a;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayList));
        for (N1.e eVar : arrayList) {
            L2.f fVar = (L2.f) eVar.f1121a;
            a3.F f7 = (a3.F) ((SimpleTypeMarker) eVar.b);
            if (f7 != null && !z7.f1542a.e()) {
                f7 = (a3.F) d().j(f7, d0Var);
            }
            arrayList2.add(new N1.e(fVar, f7));
        }
        return new C0721m(arrayList2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        AbstractC0714f visibility = this.f4648a.getVisibility();
        if (visibility != null) {
            return visibility;
        }
        c(27);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        return this.f4648a.isActual();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isCompanionObject() {
        return this.f4648a.isCompanionObject();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isData() {
        return this.f4648a.isData();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExpect() {
        return this.f4648a.isExpect();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExternal() {
        return this.f4648a.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isFun() {
        return this.f4648a.isFun();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isInline() {
        return this.f4648a.isInline();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final boolean isInner() {
        return this.f4648a.isInner();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isValue() {
        return this.f4648a.isValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final DeclarationDescriptorNonRoot substitute(Z z6) {
        if (z6 != null) {
            return z6.f1542a.e() ? this : new z(this, Z.f(z6.g(), d().g()));
        }
        c(23);
        throw null;
    }
}
