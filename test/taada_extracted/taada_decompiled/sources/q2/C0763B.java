package q2;

import A2.C0019a;
import a.AbstractC0132a;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleNotifier;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import n2.AbstractC0718j;
import n2.C0720l;

/* JADX INFO: renamed from: q2.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0763B extends AbstractC0777n implements ModuleDescriptor {
    public final Z2.n c;
    public final k2.i d;
    public final Map e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PackageViewDescriptorFactory f4531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.protobuf.v f4532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PackageFragmentProvider f4533h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MemoizedFunctionToNotNull f4534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final N1.j f4535k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0763B(L2.f moduleName, Z2.n nVar, k2.i iVar, int i) {
        super(o2.f.b, moduleName);
        kotlin.collections.v vVar = kotlin.collections.v.f3805a;
        kotlin.jvm.internal.h.f(moduleName, "moduleName");
        Annotations.Companion.getClass();
        this.c = nVar;
        this.d = iVar;
        if (!moduleName.b) {
            throw new IllegalArgumentException("Module name must be special: " + moduleName);
        }
        this.e = vVar;
        PackageViewDescriptorFactory.Companion.getClass();
        PackageViewDescriptorFactory packageViewDescriptorFactory = (PackageViewDescriptorFactory) getCapability(E.b);
        this.f4531f = packageViewDescriptorFactory == null ? F.f4544a : packageViewDescriptorFactory;
        this.i = true;
        this.f4534j = nVar.createMemoizedFunction(new C0019a(this, 29));
        this.f4535k = AbstractC0132a.M(new k2.m(this, 2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor visitor, Object obj) {
        kotlin.jvm.internal.h.f(visitor, "visitor");
        return visitor.visitModuleDeclaration(this, obj);
    }

    public final void f() {
        N1.m mVar;
        if (this.i) {
            return;
        }
        InvalidModuleNotifier invalidModuleNotifier = (InvalidModuleNotifier) getCapability(AbstractC0718j.f4246a);
        if (invalidModuleNotifier != null) {
            invalidModuleNotifier.notifyModuleInvalidated(this);
            mVar = N1.m.f1129a;
        } else {
            mVar = null;
        }
        if (mVar != null) {
            return;
        }
        String message = "Accessing invalid module descriptor " + this;
        kotlin.jvm.internal.h.f(message, "message");
        throw new com.google.android.gms.tasks.a(message, 5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final k2.i getBuiltIns() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final Object getCapability(C0720l capability) {
        kotlin.jvm.internal.h.f(capability, "capability");
        Object obj = this.e.get(capability);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final List getExpectedByModules() {
        if (this.f4532g != null) {
            return kotlin.collections.u.f3804a;
        }
        StringBuilder sb = new StringBuilder("Dependencies of module ");
        String str = getName().f962a;
        kotlin.jvm.internal.h.e(str, "name.toString()");
        sb.append(str);
        sb.append(" were not set");
        throw new AssertionError(sb.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final PackageViewDescriptor getPackage(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        f();
        return (PackageViewDescriptor) this.f4534j.invoke(fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final Collection getSubPackagesOf(L2.c fqName, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        f();
        f();
        return ((C0776m) this.f4535k.getValue()).getSubPackagesOf(fqName, nameFilter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public final boolean shouldSeeInternalsOf(ModuleDescriptor targetModule) {
        kotlin.jvm.internal.h.f(targetModule, "targetModule");
        if (equals(targetModule)) {
            return true;
        }
        kotlin.jvm.internal.h.c(this.f4532g);
        if (kotlin.collections.m.L(targetModule, kotlin.collections.w.f3806a)) {
            return true;
        }
        getExpectedByModules();
        if (targetModule instanceof Void) {
        }
        return targetModule.getExpectedByModules().contains(this);
    }

    @Override // q2.AbstractC0777n
    public final String toString() {
        String strE = AbstractC0777n.e(this);
        return this.i ? strE : strE.concat(" !isValid");
    }
}
