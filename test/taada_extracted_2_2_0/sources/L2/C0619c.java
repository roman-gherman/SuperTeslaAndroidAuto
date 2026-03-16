package l2;

import N1.m;
import Z2.n;
import a3.d0;
import e2.C0429e;
import e2.C0430f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k2.p;
import kotlin.collections.o;
import kotlin.collections.u;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0711c;
import n2.EnumC0719k;
import n2.z;
import q2.AbstractC0765b;
import q2.P;

/* JADX INFO: renamed from: l2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0619c extends AbstractC0765b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final L2.b f3963l = new L2.b(p.f3768k, L2.f.e("Function"));

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final L2.b f3964m = new L2.b(p.f3766h, L2.f.e("KFunction"));
    public final n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BuiltInsPackageFragment f3965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EnumC0621e f3966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3967h;
    public final C0618b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0622f f3968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f3969k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0619c(n nVar, BuiltInsPackageFragment containingDeclaration, EnumC0621e enumC0621e, int i) {
        super(nVar, enumC0621e.a(i));
        h.f(containingDeclaration, "containingDeclaration");
        this.e = nVar;
        this.f3965f = containingDeclaration;
        this.f3966g = enumC0621e;
        this.f3967h = i;
        this.i = new C0618b(this);
        this.f3968j = new C0622f(nVar, this);
        ArrayList arrayList = new ArrayList();
        C0430f c0430f = new C0430f(1, i, 1);
        ArrayList arrayList2 = new ArrayList(o.D(c0430f));
        C0429e it = c0430f.iterator();
        while (it.c) {
            int iNextInt = it.nextInt();
            d0 d0Var = d0.IN_VARIANCE;
            String strC = B2.b.c(iNextInt, "P");
            Annotations.Companion.getClass();
            arrayList.add(P.k(this, d0Var, L2.f.e(strC), arrayList.size(), this.e));
            arrayList2.add(m.f1129a);
        }
        d0 d0Var2 = d0.OUT_VARIANCE;
        Annotations.Companion.getClass();
        arrayList.add(P.k(this, d0Var2, L2.f.e("R"), arrayList.size(), this.e));
        this.f3969k = kotlin.collections.m.o0(arrayList);
    }

    @Override // q2.AbstractC0762A
    public final MemberScope b(b3.d dVar) {
        return this.f3968j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        Annotations.Companion.getClass();
        return o2.f.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final /* bridge */ /* synthetic */ ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final /* bridge */ /* synthetic */ Collection getConstructors() {
        return u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        return this.f3965f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final List getDeclaredTypeParameters() {
        return this.f3969k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final EnumC0711c getKind() {
        return EnumC0711c.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        return EnumC0719k.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final /* bridge */ /* synthetic */ Collection getSealedSubclasses() {
        return u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public final SourceElement getSource() {
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        h.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final /* bridge */ /* synthetic */ MemberScope getStaticScope() {
        return U2.m.f1338a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final /* bridge */ /* synthetic */ ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final z getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        C0712d PUBLIC = AbstractC0713e.e;
        h.e(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isData() {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isValue() {
        return false;
    }

    public final String toString() {
        String strB = getName().b();
        h.e(strB, "name.asString()");
        return strB;
    }
}
