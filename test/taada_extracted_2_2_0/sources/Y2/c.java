package Y2;

import A2.C0019a;
import A2.C0022d;
import B.h;
import C0.t;
import G2.F;
import G2.M;
import G2.O;
import R2.e;
import X2.g;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import q2.D;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends D implements BuiltInsPackageFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StorageManager f1484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final H2.a f1485h;
    public final h i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f1486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public F f1487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m f1488l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(L2.c fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, F f6, H2.a aVar) {
        super(moduleDescriptor, fqName);
        kotlin.jvm.internal.h.f(fqName, "fqName");
        this.f1484g = storageManager;
        this.f1485h = aVar;
        O o6 = f6.d;
        kotlin.jvm.internal.h.e(o6, "proto.strings");
        M m6 = f6.e;
        kotlin.jvm.internal.h.e(m6, "proto.qualifiedNames");
        h hVar = new h(o6, m6);
        this.i = hVar;
        this.f1486j = new t(f6, hVar, aVar, new C0019a(this, 11));
        this.f1487k = f6;
    }

    public final void g(g components) {
        kotlin.jvm.internal.h.f(components, "components");
        F f6 = this.f1487k;
        if (f6 == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
        }
        this.f1487k = null;
        G2.D d = f6.f438f;
        kotlin.jvm.internal.h.e(d, "proto.`package`");
        this.f1488l = new m(this, d, this.i, this.f1485h, null, components, "scope of " + this, new C0022d(this, 9));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public final MemberScope getMemberScope() {
        m mVar = this.f1488l;
        if (mVar != null) {
            return mVar;
        }
        kotlin.jvm.internal.h.n("_memberScope");
        throw null;
    }

    @Override // q2.D, q2.AbstractC0777n
    public final String toString() {
        return "builtins package fragment for " + this.e + " from " + e.j(this);
    }
}
