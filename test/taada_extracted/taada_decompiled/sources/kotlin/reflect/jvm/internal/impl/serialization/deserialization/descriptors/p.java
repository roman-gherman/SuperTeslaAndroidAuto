package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import A2.C0019a;
import G2.W;
import a.AbstractC0132a;
import a3.F;
import a3.Z;
import a3.b0;
import a3.d0;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0719k;
import q2.AbstractC0778o;
import q2.C0768e;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends AbstractC0778o implements DeserializedMemberDescriptor, TypeAliasDescriptor {
    public final C0712d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f3926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0768e f3927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StorageManager f3928h;
    public final W i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NameResolver f3929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final I2.f f3930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final I2.g f3931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final E2.g f3932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f3933n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public F f3934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public F f3935p;
    public List q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public F f3936r;

    /* JADX WARN: Illegal instructions before constructor call */
    public p(StorageManager storageManager, DeclarationDescriptor containingDeclaration, Annotations annotations, L2.f fVar, C0712d visibility, W proto, NameResolver nameResolver, I2.f typeTable, I2.g versionRequirementTable, E2.g gVar) {
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        kotlin.jvm.internal.h.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.h.f(visibility, "visibility");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        kotlin.jvm.internal.h.f(versionRequirementTable, "versionRequirementTable");
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
        super(containingDeclaration, annotations, fVar, NO_SOURCE);
        this.e = visibility;
        this.f3927g = new C0768e(this);
        this.f3928h = storageManager;
        this.i = proto;
        this.f3929j = nameResolver;
        this.f3930k = typeTable;
        this.f3931l = versionRequirementTable;
        this.f3932m = gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor visitor, Object obj) {
        kotlin.jvm.internal.h.f(visitor, "visitor");
        return visitor.visitTypeAliasDescriptor(this, obj);
    }

    @Override // q2.AbstractC0778o
    /* JADX INFO: renamed from: f */
    public final DeclarationDescriptorWithSource getOriginal() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.util.List r24, a3.F r25, a3.F r26) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p.g(java.util.List, a3.F, a3.F):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public final ClassDescriptor getClassDescriptor() {
        if (kotlin.reflect.l.O(getExpandedType())) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = getExpandedType().c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final DeserializedContainerSource getContainerSource() {
        return this.f3932m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final List getDeclaredTypeParameters() {
        List list = this.f3926f;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.h.n("declaredTypeParametersImpl");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final F getDefaultType() {
        F f6 = this.f3936r;
        if (f6 != null) {
            return f6;
        }
        kotlin.jvm.internal.h.n("defaultTypeImpl");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public final F getExpandedType() {
        F f6 = this.f3935p;
        if (f6 != null) {
            return f6;
        }
        kotlin.jvm.internal.h.n("expandedType");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        return EnumC0719k.f4247a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final NameResolver getNameResolver() {
        return this.f3929j;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ClassifierDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final MessageLite getProto() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        return this.f3927g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public final I2.f getTypeTable() {
        return this.f3930k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public final F getUnderlyingType() {
        F f6 = this.f3934o;
        if (f6 != null) {
            return f6;
        }
        kotlin.jvm.internal.h.n("underlyingType");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final boolean isInner() {
        return b0.d(getUnderlyingType(), new C0019a(this, 28), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public final DeclarationDescriptorNonRoot substitute(Z substitutor) {
        kotlin.jvm.internal.h.f(substitutor, "substitutor");
        if (substitutor.f1542a.e()) {
            return this;
        }
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        kotlin.jvm.internal.h.e(containingDeclaration, "containingDeclaration");
        Annotations annotations = getAnnotations();
        kotlin.jvm.internal.h.e(annotations, "annotations");
        L2.f name = getName();
        kotlin.jvm.internal.h.e(name, "name");
        p pVar = new p(this.f3928h, containingDeclaration, annotations, name, this.e, this.i, this.f3929j, this.f3930k, this.f3931l, this.f3932m);
        List declaredTypeParameters = getDeclaredTypeParameters();
        F underlyingType = getUnderlyingType();
        d0 d0Var = d0.INVARIANT;
        pVar.g(declaredTypeParameters, AbstractC0132a.h(substitutor.h(underlyingType, d0Var)), AbstractC0132a.h(substitutor.h(getExpandedType(), d0Var)));
        return pVar;
    }

    @Override // q2.AbstractC0777n
    public final String toString() {
        return "typealias " + getName().b();
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getOriginal() {
        return this;
    }
}
