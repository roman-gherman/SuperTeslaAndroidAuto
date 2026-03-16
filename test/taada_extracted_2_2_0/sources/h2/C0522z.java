package h2;

import a.AbstractC0132a;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import m2.C0652d;
import n2.AbstractC0714f;
import n2.EnumC0711c;
import n2.EnumC0719k;
import net.bytebuddy.pool.TypePool;
import t2.AbstractC0823e;
import v2.EnumC0851b;

/* JADX INFO: renamed from: h2.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0522z extends D implements KClass, KClassifierImpl, KTypeParameterOwnerImpl {
    public static final /* synthetic */ int d = 0;
    public final Class b;
    public final r0 c;

    public C0522z(Class jClass) {
        kotlin.jvm.internal.h.f(jClass, "jClass");
        this.b = jClass;
        this.c = new r0(new C0515s(this, 7));
    }

    @Override // h2.D
    public final Collection c() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == EnumC0711c.b || descriptor.getKind() == EnumC0711c.f4230f) {
            return kotlin.collections.u.f3805a;
        }
        Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        kotlin.jvm.internal.h.e(constructors, "descriptor.constructors");
        return constructors;
    }

    @Override // h2.D
    public final Collection d(L2.f fVar) {
        MemberScope memberScope = getDescriptor().getDefaultType().getMemberScope();
        EnumC0851b enumC0851b = EnumC0851b.b;
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = memberScope.getContributedFunctions(fVar, enumC0851b);
        MemberScope staticScope = getDescriptor().getStaticScope();
        kotlin.jvm.internal.h.e(staticScope, "descriptor.staticScope");
        return kotlin.collections.m.b0(staticScope.getContributedFunctions(fVar, enumC0851b), contributedFunctions);
    }

    @Override // h2.D
    public final PropertyDescriptor e(int i) {
        Class<?> declaringClass;
        Class cls = this.b;
        if (cls.getSimpleName().equals("DefaultImpls") && (declaringClass = cls.getDeclaringClass()) != null && declaringClass.isInterface()) {
            return ((C0522z) E1.k.K(declaringClass)).e(i);
        }
        ClassDescriptor descriptor = getDescriptor();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar = descriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) descriptor : null;
        if (gVar != null) {
            kotlin.reflect.jvm.internal.impl.protobuf.o classLocalVariable = J2.l.f868j;
            kotlin.jvm.internal.h.e(classLocalVariable, "classLocalVariable");
            G2.H h3 = (G2.H) AbstractC0132a.E(gVar.e, classLocalVariable, i);
            if (h3 != null) {
                X2.i iVar = gVar.f3900l;
                return (PropertyDescriptor) x0.f(this.b, h3, iVar.b, iVar.d, gVar.f3895f, C0521y.f3453a);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean equals(Object obj) {
        return (obj instanceof C0522z) && E1.k.I(this).equals(E1.k.I((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[1];
        Object objInvoke = c0519w.d.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-annotations>(...)");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KClass
    public final Collection getConstructors() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[4];
        Object objInvoke = c0519w.f3439g.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-constructors>(...)");
        return (Collection) objInvoke;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.b;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public final Collection getMembers() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[17];
        Object objInvoke = c0519w.f3449s.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-allMembers>(...)");
        return (Collection) objInvoke;
    }

    @Override // kotlin.reflect.KClass
    public final Collection getNestedClasses() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[5];
        Object objInvoke = c0519w.f3440h.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-nestedClasses>(...)");
        return (Collection) objInvoke;
    }

    @Override // kotlin.reflect.KClass
    public final Object getObjectInstance() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[6];
        return c0519w.i.invoke();
    }

    @Override // kotlin.reflect.KClass
    public final String getQualifiedName() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[3];
        return (String) c0519w.f3438f.invoke();
    }

    @Override // kotlin.reflect.KClass
    public final List getSealedSubclasses() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[9];
        Object objInvoke = c0519w.f3443l.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-sealedSubclasses>(...)");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KClass
    public final String getSimpleName() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[2];
        return (String) c0519w.e.invoke();
    }

    @Override // kotlin.reflect.KClass
    public final List getSupertypes() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[8];
        Object objInvoke = c0519w.f3442k.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-supertypes>(...)");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KClass
    public final List getTypeParameters() {
        C0519w c0519w = (C0519w) this.c.invoke();
        c0519w.getClass();
        KProperty kProperty = C0519w.f3437t[7];
        Object objInvoke = c0519w.f3441j.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-typeParameters>(...)");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KClass
    public final kotlin.reflect.f getVisibility() {
        AbstractC0714f visibility = getDescriptor().getVisibility();
        kotlin.jvm.internal.h.e(visibility, "descriptor.visibility");
        return x0.k(visibility);
    }

    @Override // h2.D
    public final Collection h(L2.f fVar) {
        MemberScope memberScope = getDescriptor().getDefaultType().getMemberScope();
        EnumC0851b enumC0851b = EnumC0851b.b;
        Collection<? extends PropertyDescriptor> contributedVariables = memberScope.getContributedVariables(fVar, enumC0851b);
        MemberScope staticScope = getDescriptor().getStaticScope();
        kotlin.jvm.internal.h.e(staticScope, "descriptor.staticScope");
        return kotlin.collections.m.b0(staticScope.getContributedVariables(fVar, enumC0851b), contributedVariables);
    }

    @Override // kotlin.reflect.KClass
    public final int hashCode() {
        return E1.k.I(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isAbstract() {
        return getDescriptor().getModality() == EnumC0719k.d;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isData() {
        return getDescriptor().isData();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isFinal() {
        return getDescriptor().getModality() == EnumC0719k.f4248a;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isFun() {
        return getDescriptor().isFun();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isInner() {
        return getDescriptor().isInner();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isInstance(Object obj) {
        List list = AbstractC0823e.f4805a;
        Class cls = this.b;
        kotlin.jvm.internal.h.f(cls, "<this>");
        Integer num = (Integer) AbstractC0823e.d.get(cls);
        if (num != null) {
            return kotlin.jvm.internal.z.e(num.intValue(), obj);
        }
        Class cls2 = (Class) AbstractC0823e.c.get(cls);
        if (cls2 != null) {
            cls = cls2;
        }
        return cls.isInstance(obj);
    }

    @Override // kotlin.reflect.KClass
    public final boolean isOpen() {
        return getDescriptor().getModality() == EnumC0719k.c;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isSealed() {
        return getDescriptor().getModality() == EnumC0719k.b;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isValue() {
        return getDescriptor().isValue();
    }

    public final L2.b n() {
        k2.k kVarD;
        L2.b bVar = v0.f3436a;
        Class klass = this.b;
        kotlin.jvm.internal.h.f(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            kotlin.jvm.internal.h.e(componentType, "klass.componentType");
            kVarD = componentType.isPrimitive() ? S2.b.b(componentType.getSimpleName()).d() : null;
            return kVarD != null ? new L2.b(k2.p.f3768k, kVarD.b) : L2.b.j(k2.o.f3748g.g());
        }
        if (klass.equals(Void.TYPE)) {
            return v0.f3436a;
        }
        kVarD = klass.isPrimitive() ? S2.b.b(klass.getSimpleName()).d() : null;
        if (kVarD != null) {
            return new L2.b(k2.p.f3768k, kVarD.f3721a);
        }
        L2.b bVarA = AbstractC0823e.a(klass);
        if (!bVarA.c) {
            String str = C0652d.f4075a;
            L2.b bVar2 = (L2.b) C0652d.f4078h.get(bVarA.b().i());
            if (bVar2 != null) {
                return bVar2;
            }
        }
        return bVarA;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final ClassDescriptor getDescriptor() {
        return ((C0519w) this.c.invoke()).a();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("class ");
        L2.b bVarN = n();
        L2.c cVarG = bVarN.g();
        kotlin.jvm.internal.h.e(cVarG, "classId.packageFqName");
        String strConcat = cVarG.d() ? "" : cVarG.b().concat(".");
        sb.append(strConcat + kotlin.text.r.A(bVarN.h().b(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '$'));
        return sb.toString();
    }
}
