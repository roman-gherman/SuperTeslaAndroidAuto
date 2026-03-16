package m2;

import A2.y;
import c4.AbstractC0246d;
import f.s;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import q2.C0763B;

/* JADX INFO: renamed from: m2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0657i extends k2.i {
    public static final /* synthetic */ KProperty[] i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k2.m f4091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NotNullLazyValue f4092h;

    static {
        x xVar = w.f3818a;
        i = new KProperty[]{xVar.f(new q(xVar.b(C0657i.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0657i(Z2.n nVar) {
        super(nVar);
        com.google.protobuf.a.p(1, "kind");
        this.f4092h = nVar.createLazyValue(new y(10, this, nVar));
        int iB = s.b(1);
        if (iB == 1) {
            c(false);
        } else {
            if (iB != 2) {
                return;
            }
            c(true);
        }
    }

    public final C0661m J() {
        return (C0661m) AbstractC0246d.T(this.f4092h, i[0]);
    }

    @Override // k2.i
    public final AdditionalClassPartsProvider d() {
        return J();
    }

    @Override // k2.i
    public final Iterable l() {
        Iterable iterableL = super.l();
        Z2.n nVar = this.e;
        C0763B builtInsModule = k();
        kotlin.jvm.internal.h.e(builtInsModule, "builtInsModule");
        return kotlin.collections.m.c0(new C0655g(nVar, builtInsModule), iterableL);
    }

    @Override // k2.i
    public final PlatformDependentDeclarationFilter o() {
        return J();
    }
}
