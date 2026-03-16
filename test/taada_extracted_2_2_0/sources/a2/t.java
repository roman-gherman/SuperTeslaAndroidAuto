package A2;

import io.ktor.utils.io.Z;
import io.ktor.utils.io.b0;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import z2.C0941a;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends q2.D {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f66o;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JavaPackage f67g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0946f f68h;
    public final K2.f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NotNullLazyValue f69j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0023e f70k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final NotNullLazyValue f71l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Annotations f72m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final NotNullLazyValue f73n;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        f66o = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(t.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(t.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public t(C0946f outerContext, JavaPackage javaPackage) {
        Annotations annotationsZ;
        kotlin.jvm.internal.h.f(outerContext, "outerContext");
        C0941a c0941a = outerContext.f5204a;
        super(c0941a.f5193o, javaPackage.getFqName());
        this.f67g = javaPackage;
        C0946f c0946fC = Z.c(outerContext, this, null, 6);
        this.f68h = c0946fC;
        this.i = j3.p.g(c0941a.d.c().c);
        C0941a c0941a2 = c0946fC.f5204a;
        Z2.n nVar = c0941a2.f5184a;
        this.f69j = nVar.createLazyValue(new s(this, 0));
        this.f70k = new C0023e(c0946fC, javaPackage, this);
        this.f71l = nVar.createRecursionTolerantLazyValue(new s(this, 2), kotlin.collections.u.f3805a);
        if (c0941a2.f5198v.c) {
            Annotations.Companion.getClass();
            annotationsZ = o2.f.b;
        } else {
            annotationsZ = b0.z(c0946fC, javaPackage);
        }
        this.f72m = annotationsZ;
        this.f73n = nVar.createLazyValue(new s(this, 1));
    }

    @Override // o2.AbstractC0737a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        return this.f72m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public final MemberScope getMemberScope() {
        return this.f70k;
    }

    @Override // q2.D, q2.AbstractC0778o, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public final SourceElement getSource() {
        return new E2.n(this);
    }

    @Override // q2.D, q2.AbstractC0777n
    public final String toString() {
        return "Lazy Java package fragment: " + this.e + " of module " + this.f68h.f5204a.f5193o;
    }
}
