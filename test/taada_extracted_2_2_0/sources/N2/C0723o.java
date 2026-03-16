package n2;

import a3.C0150m;
import a3.d0;
import e2.C0429e;
import e2.C0430f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import q2.AbstractC0774k;
import q2.P;

/* JADX INFO: renamed from: n2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0723o extends AbstractC0774k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f4253h;
    public final C0150m i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0723o(StorageManager storageManager, ClassOrPackageFragmentDescriptor container, L2.f fVar, boolean z6, int i) {
        super(storageManager, container, fVar, SourceElement.NO_SOURCE);
        kotlin.jvm.internal.h.f(container, "container");
        this.f4252g = z6;
        C0430f c0430fS0 = E1.k.s0(0, i);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(c0430fS0));
        C0429e it = c0430fS0.iterator();
        while (it.c) {
            int iNextInt = it.nextInt();
            Annotations.Companion.getClass();
            arrayList.add(P.k(this, d0.INVARIANT, L2.f.e("T" + iNextInt), iNextInt, storageManager));
        }
        this.f4253h = arrayList;
        this.i = new C0150m(this, AbstractC0718j.c(this), io.ktor.utils.io.internal.t.p(R2.e.j(this).getBuiltIns().e()), storageManager);
    }

    @Override // q2.AbstractC0762A
    public final MemberScope b(b3.d dVar) {
        return U2.m.f1338a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        Annotations.Companion.getClass();
        return o2.f.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getConstructors() {
        return kotlin.collections.w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final List getDeclaredTypeParameters() {
        return this.f4253h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final EnumC0711c getKind() {
        return EnumC0711c.f4229a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        return EnumC0719k.f4248a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getSealedSubclasses() {
        return kotlin.collections.u.f3805a;
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
    public final ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final z getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        C0712d PUBLIC = AbstractC0713e.e;
        kotlin.jvm.internal.h.e(PUBLIC, "PUBLIC");
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

    @Override // q2.AbstractC0774k, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
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
        return this.f4252g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isValue() {
        return false;
    }

    public final String toString() {
        return "class " + getName() + " (not found)";
    }
}
