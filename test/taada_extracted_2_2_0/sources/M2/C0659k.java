package m2;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import q2.D;

/* JADX INFO: renamed from: m2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0659k extends D {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4094g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0659k(ModuleDescriptor module, L2.c fqName, int i) {
        super(module, fqName);
        this.f4094g = i;
        switch (i) {
            case 1:
                kotlin.jvm.internal.h.f(module, "module");
                kotlin.jvm.internal.h.f(fqName, "fqName");
                super(module, fqName);
                break;
            default:
                break;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public final /* bridge */ /* synthetic */ MemberScope getMemberScope() {
        switch (this.f4094g) {
        }
        return U2.m.f1338a;
    }
}
