package c3;

import java.util.Collection;
import java.util.List;
import k2.C0585d;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.C0720l;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ModuleDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1747a = new d();
    public static final L2.f b = L2.f.g("<Error module>");
    public static final u c = u.f3805a;
    public static final C0585d d;

    static {
        C0585d c0585d = C0585d.f3705g;
        d = C0585d.f3705g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor visitor, Object obj) {
        kotlin.jvm.internal.h.f(visitor, "visitor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        Annotations.Companion.getClass();
        return o2.f.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final k2.i getBuiltIns() {
        return d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final Object getCapability(C0720l capability) {
        kotlin.jvm.internal.h.f(capability, "capability");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final List getExpectedByModules() {
        return c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public final L2.f getName() {
        return b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final PackageViewDescriptor getPackage(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final Collection getSubPackagesOf(L2.c fqName, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final boolean shouldSeeInternalsOf(ModuleDescriptor targetModule) {
        kotlin.jvm.internal.h.f(targetModule, "targetModule");
        return false;
    }
}
