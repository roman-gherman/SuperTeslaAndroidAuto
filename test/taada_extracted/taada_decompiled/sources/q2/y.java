package q2;

import c4.AbstractC0246d;
import java.util.List;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends AbstractC0777n implements PackageViewDescriptor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f4645h;
    public final C0763B c;
    public final L2.c d;
    public final NotNullLazyValue e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NotNullLazyValue f4646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final U2.j f4647g;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3817a;
        f4645h = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(y.class), "fragments", "getFragments()Ljava/util/List;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(y.class), "empty", "getEmpty()Z"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(C0763B c0763b, L2.c cVar, StorageManager storageManager) {
        super(o2.f.b, cVar.g());
        Annotations.Companion.getClass();
        this.c = c0763b;
        this.d = cVar;
        this.e = storageManager.createLazyValue(new x(this, 1));
        this.f4646f = storageManager.createLazyValue(new x(this, 0));
        this.f4647g = new U2.j(storageManager, new x(this, 2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor visitor, Object obj) {
        kotlin.jvm.internal.h.f(visitor, "visitor");
        return visitor.visitPackageViewDescriptor(this, obj);
    }

    public final boolean equals(Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        if (packageViewDescriptor == null) {
            return false;
        }
        if (kotlin.jvm.internal.h.a(this.d, packageViewDescriptor.getFqName())) {
            if (kotlin.jvm.internal.h.a(this.c, packageViewDescriptor.getModule())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        L2.c cVar = this.d;
        if (cVar.d()) {
            return null;
        }
        L2.c cVarE = cVar.e();
        kotlin.jvm.internal.h.e(cVarE, "fqName.parent()");
        return this.c.getPackage(cVarE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public final L2.c getFqName() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public final List getFragments() {
        return (List) AbstractC0246d.T(this.e, f4645h[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public final MemberScope getMemberScope() {
        return this.f4647g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public final ModuleDescriptor getModule() {
        return this.c;
    }

    public final int hashCode() {
        return this.d.hashCode() + (this.c.hashCode() * 31);
    }

    @Override // o2.AbstractC0737a, io.ktor.util.StringValuesBuilder
    public final boolean isEmpty() {
        return ((Boolean) AbstractC0246d.T(this.f4646f, f4645h[1])).booleanValue();
    }
}
