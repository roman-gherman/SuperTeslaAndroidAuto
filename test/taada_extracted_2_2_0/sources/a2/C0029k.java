package A2;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import n2.AbstractC0708K;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0711c;
import n2.EnumC0719k;
import q2.AbstractC0774k;
import z2.C0941a;
import z2.C0944d;
import z2.C0946f;

/* JADX INFO: renamed from: A2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0029k extends AbstractC0774k implements JavaClassDescriptor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0946f f39g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JavaClass f40h;
    public final ClassDescriptor i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0946f f41j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final N1.j f42k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final EnumC0711c f43l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final EnumC0719k f44m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AbstractC0708K f45n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f46o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C0027i f47p;
    public final r q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final n2.t f48r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final U2.i f49s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final N f50t;
    public final C0944d u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final NotNullLazyValue f51v;

    static {
        kotlin.collections.E.x("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0029k(C0946f outerContext, DeclarationDescriptor containingDeclaration, JavaClass jClass, ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.h.f(outerContext, "outerContext");
        kotlin.jvm.internal.h.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.h.f(jClass, "jClass");
        C0941a c0941a = outerContext.f5204a;
        super(c0941a.f5184a, containingDeclaration, jClass.getName(), c0941a.f5188j.source(jClass));
        this.f39g = outerContext;
        this.f40h = jClass;
        this.i = classDescriptor;
        C0946f c0946fC = Z.c(outerContext, this, jClass, 4);
        this.f41j = c0946fC;
        C0941a c0941a2 = c0946fC.f5204a;
        c0941a2.f5186g.recordClass(jClass, this);
        jClass.getLightClassOriginKind();
        this.f42k = AbstractC0132a.M(new C0026h(this, 2));
        this.f43l = jClass.isAnnotationType() ? EnumC0711c.e : jClass.isInterface() ? EnumC0711c.b : jClass.isEnum() ? EnumC0711c.c : EnumC0711c.f4229a;
        boolean zIsAnnotationType = jClass.isAnnotationType();
        EnumC0719k enumC0719k = EnumC0719k.f4248a;
        if (!zIsAnnotationType && !jClass.isEnum()) {
            boolean zIsSealed = jClass.isSealed();
            boolean z6 = jClass.isSealed() || jClass.isAbstract() || jClass.isInterface();
            boolean zIsFinal = jClass.isFinal();
            if (zIsSealed) {
                enumC0719k = EnumC0719k.b;
            } else if (z6) {
                enumC0719k = EnumC0719k.d;
            } else if (!zIsFinal) {
                enumC0719k = EnumC0719k.c;
            }
        }
        this.f44m = enumC0719k;
        this.f45n = jClass.getVisibility();
        this.f46o = (jClass.getOuterClass() == null || jClass.isStatic()) ? false : true;
        this.f47p = new C0027i(this);
        r rVar = new r(c0946fC, this, jClass, classDescriptor != null, null);
        this.q = rVar;
        n2.v vVar = n2.t.e;
        Z2.n storageManager = c0941a2.f5184a;
        c0941a2.u.getClass();
        b3.c cVar = b3.c.f1699a;
        C0019a c0019a = new C0019a(this, 1);
        vVar.getClass();
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        this.f48r = new n2.t(this, storageManager, c0019a, cVar);
        this.f49s = new U2.i(rVar);
        this.f50t = new N(c0946fC, jClass, this);
        this.u = b0.z(c0946fC, jClass);
        this.f51v = storageManager.createLazyValue(new C0026h(this, 1));
    }

    @Override // q2.AbstractC0762A
    public final MemberScope b(b3.d dVar) {
        n2.t tVar = this.f48r;
        tVar.getClass();
        R2.e.j(tVar.f4259a);
        return (r) ((MemberScope) AbstractC0246d.T(tVar.d, n2.t.f4258f[0]));
    }

    public final r e() {
        return (r) super.getUnsubstitutedMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getConstructors() {
        return (List) this.q.f61p.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final List getDeclaredTypeParameters() {
        return (List) this.f51v.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final EnumC0711c getKind() {
        return this.f43l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        return this.f44m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getSealedSubclasses() {
        if (this.f44m != EnumC0719k.b) {
            return kotlin.collections.u.f3805a;
        }
        B2.a aVarF0 = kotlin.reflect.l.f0(2, false, null, 7);
        Collection<JavaClassifierType> permittedTypes = this.f40h.getPermittedTypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = permittedTypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor declarationDescriptor = this.f41j.e.s((JavaClassifierType) it.next(), aVarF0).c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                arrayList.add(classDescriptor);
            }
        }
        return kotlin.collections.m.k0(arrayList, new C0028j());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getStaticScope() {
        return this.f50t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        return this.f47p;
    }

    @Override // q2.AbstractC0765b, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getUnsubstitutedInnerClassesScope() {
        return this.f49s;
    }

    @Override // q2.AbstractC0765b, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getUnsubstitutedMemberScope() {
        return (r) super.getUnsubstitutedMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final n2.z getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        C0712d c0712d = AbstractC0713e.f4233a;
        AbstractC0708K abstractC0708K = this.f45n;
        if (!kotlin.jvm.internal.h.a(abstractC0708K, c0712d) || this.f40h.getOuterClass() != null) {
            return w2.O.a(abstractC0708K);
        }
        C0712d c0712d2 = w2.t.f5022a;
        kotlin.jvm.internal.h.e(c0712d2, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
        return c0712d2;
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
        return this.f46o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isValue() {
        return false;
    }

    public final String toString() {
        return "Lazy Java class " + R2.e.h(this);
    }
}
