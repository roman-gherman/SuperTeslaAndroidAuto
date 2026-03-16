package m2;

import A2.y;
import c4.AbstractC0246d;
import io.ktor.utils.io.internal.t;
import java.util.Collection;
import k2.p;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import q2.C0763B;
import q2.C0775l;

/* JADX INFO: renamed from: m2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0655g implements ClassDescriptorFactory {
    public static final C0653e d;
    public static final /* synthetic */ KProperty[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final L2.c f4085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final L2.f f4086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final L2.b f4087h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0763B f4088a;
    public final Function1 b;
    public final NotNullLazyValue c;

    static {
        x xVar = w.f3817a;
        e = new KProperty[]{xVar.f(new q(xVar.b(C0655g.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        d = new C0653e();
        f4085f = p.f3767k;
        L2.e eVar = k2.o.c;
        L2.f fVarF = eVar.f();
        kotlin.jvm.internal.h.e(fVarF, "cloneable.shortName()");
        f4086g = fVarF;
        f4087h = L2.b.j(eVar.g());
    }

    public C0655g(Z2.n nVar, C0763B c0763b) {
        C0654f computeContainingDeclaration = C0654f.f4084a;
        kotlin.jvm.internal.h.f(computeContainingDeclaration, "computeContainingDeclaration");
        this.f4088a = c0763b;
        this.b = computeContainingDeclaration;
        this.c = nVar.createLazyValue(new y(9, this, nVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final ClassDescriptor createClass(L2.b classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        if (!classId.equals(f4087h)) {
            return null;
        }
        return (C0775l) AbstractC0246d.T(this.c, e[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final Collection getAllContributedClassesIfPossible(L2.c packageFqName) {
        kotlin.jvm.internal.h.f(packageFqName, "packageFqName");
        if (!packageFqName.equals(f4085f)) {
            return kotlin.collections.w.f3806a;
        }
        return t.p((C0775l) AbstractC0246d.T(this.c, e[0]));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final boolean shouldCreateClass(L2.c packageFqName, L2.f name) {
        kotlin.jvm.internal.h.f(packageFqName, "packageFqName");
        kotlin.jvm.internal.h.f(name, "name");
        return name.equals(f4086g) && packageFqName.equals(f4085f);
    }
}
