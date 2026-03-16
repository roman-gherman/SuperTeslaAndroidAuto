package m2;

import A2.C0022d;
import A2.C0029k;
import A2.r;
import A2.y;
import a3.D;
import a3.F;
import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.internal.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import n2.AbstractC0714f;
import n2.AbstractC0718j;
import n2.C0712d;
import n2.EnumC0711c;
import n2.EnumC0719k;
import p2.AbstractC0757b;
import q2.C0763B;
import q2.C0775l;
import v2.EnumC0851b;

/* JADX INFO: renamed from: m2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0661m implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f4095g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0763B f4096a;
    public final NotNullLazyValue b;
    public final F c;
    public final NotNullLazyValue d;
    public final CacheWithNotNullValues e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NotNullLazyValue f4097f;

    static {
        x xVar = w.f3817a;
        f4095g = new KProperty[]{xVar.f(new q(xVar.b(C0661m.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), xVar.f(new q(xVar.b(C0661m.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), xVar.f(new q(xVar.b(C0661m.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public C0661m(C0763B c0763b, Z2.n nVar, C0022d c0022d) {
        this.f4096a = c0763b;
        this.b = nVar.createLazyValue(c0022d);
        C0775l c0775l = new C0775l(new C0659k(c0763b, new L2.c("java.io"), 0), L2.f.e("Serializable"), EnumC0719k.d, EnumC0711c.b, Z.p(new D(nVar, new C0660l(this, 0))), SourceElement.NO_SOURCE, nVar);
        c0775l.e(U2.m.f1338a, kotlin.collections.w.f3806a, null);
        F defaultType = c0775l.getDefaultType();
        kotlin.jvm.internal.h.e(defaultType, "mockSerializableClass.defaultType");
        this.c = defaultType;
        this.d = nVar.createLazyValue(new y(11, this, nVar));
        this.e = nVar.createCacheWithNotNullValues();
        this.f4097f = nVar.createLazyValue(new C0660l(this, 1));
    }

    public final C0029k a(ClassDescriptor classDescriptor) {
        L2.f fVar = k2.i.f3709f;
        if (k2.i.b(classDescriptor, k2.o.f3742a) || !k2.i.I(classDescriptor)) {
            return null;
        }
        L2.e eVarH = R2.e.h(classDescriptor);
        if (!eVarH.d()) {
            return null;
        }
        String str = C0652d.f4074a;
        L2.b bVarF = C0652d.f(eVarH);
        if (bVarF == null) {
            return null;
        }
        ClassDescriptor classDescriptorJ = AbstractC0718j.j(b().f4089a, bVarF.b());
        if (classDescriptorJ instanceof C0029k) {
            return (C0029k) classDescriptorJ;
        }
        return null;
    }

    public final C0656h b() {
        return (C0656h) AbstractC0246d.T(this.b, f4095g[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public final Collection getConstructors(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptorB;
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
        EnumC0711c kind = classDescriptor.getKind();
        EnumC0711c enumC0711c = EnumC0711c.f4228a;
        u uVar = u.f3804a;
        if (kind == enumC0711c) {
            b().getClass();
            C0029k c0029kA = a(classDescriptor);
            if (c0029kA != null && (classDescriptorB = C0653e.b(R2.e.g(c0029kA), C0650b.f4072g)) != null) {
                a3.Z zE = a3.Z.e(t.f(classDescriptorB, c0029kA));
                List list = (List) c0029kA.q.f61p.invoke();
                ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList();
                for (Object obj : list) {
                    ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) obj;
                    AbstractC0714f visibility = classConstructorDescriptor.getVisibility();
                    visibility.getClass();
                    if (((C0712d) visibility).f4231a.b) {
                        Collection<ClassConstructorDescriptor> constructors = classDescriptorB.getConstructors();
                        kotlin.jvm.internal.h.e(constructors, "defaultKotlinVersion.constructors");
                        if (!constructors.isEmpty()) {
                            for (ClassConstructorDescriptor it : constructors) {
                                kotlin.jvm.internal.h.e(it, "it");
                                if (N2.o.j(it, classConstructorDescriptor.substitute(zE)) == 1) {
                                    break;
                                }
                            }
                        }
                        if (classConstructorDescriptor.getValueParameters().size() == 1) {
                            List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                            kotlin.jvm.internal.h.e(valueParameters, "valueParameters");
                            ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) kotlin.collections.m.g0(valueParameters)).getType().c().getDeclarationDescriptor();
                            if (kotlin.jvm.internal.h.a(declarationDescriptor != null ? R2.e.h(declarationDescriptor) : null, R2.e.h(classDescriptor))) {
                            }
                        }
                        if (!k2.i.B(classConstructorDescriptor) && !C0663o.e.contains(C5.f.b0(c0029kA, E1.k.o(classConstructorDescriptor, 3)))) {
                            arrayList.add(obj);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayList));
                for (ClassConstructorDescriptor classConstructorDescriptor2 : arrayList) {
                    FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> copyBuilderNewCopyBuilder = classConstructorDescriptor2.newCopyBuilder();
                    copyBuilderNewCopyBuilder.setOwner(classDescriptor);
                    copyBuilderNewCopyBuilder.setReturnType(classDescriptor.getDefaultType());
                    copyBuilderNewCopyBuilder.setPreserveSourceElement();
                    copyBuilderNewCopyBuilder.setSubstitution(zE.g());
                    if (!C0663o.f4100f.contains(C5.f.b0(c0029kA, E1.k.o(classConstructorDescriptor2, 3)))) {
                        copyBuilderNewCopyBuilder.setAdditionalAnnotations((Annotations) AbstractC0246d.T(this.f4097f, f4095g[2]));
                    }
                    FunctionDescriptor functionDescriptorBuild = copyBuilderNewCopyBuilder.build();
                    kotlin.jvm.internal.h.d(functionDescriptorBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                    arrayList2.add((ClassConstructorDescriptor) functionDescriptorBuild);
                }
                return arrayList2;
            }
        }
        return uVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a5 A[EDGE_INSN: B:115:0x01a5->B:57:0x01a5 BREAK  A[LOOP:3: B:68:0x01d3->B:73:0x01f3]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x022b  */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection getFunctions(L2.f r17, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r18) {
        /*
            Method dump skipped, instruction units count: 743
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.C0661m.getFunctions(L2.f, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public final Collection getFunctionsNames(ClassDescriptor classDescriptor) {
        Set functionNames;
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
        b().getClass();
        kotlin.collections.w wVar = kotlin.collections.w.f3806a;
        C0029k c0029kA = a(classDescriptor);
        return (c0029kA == null || (functionNames = c0029kA.e().getFunctionNames()) == null) ? wVar : functionNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public final Collection getSupertypes(ClassDescriptor classDescriptor) {
        boolean zIsAssignableFrom = true;
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
        L2.e eVarH = R2.e.h(classDescriptor);
        LinkedHashSet linkedHashSet = C0663o.f4099a;
        L2.e eVar = k2.o.f3747g;
        boolean z6 = eVarH.equals(eVar) || k2.o.f3745c0.get(eVarH) != null;
        F f6 = this.c;
        if (z6) {
            F cloneableType = (F) AbstractC0246d.T(this.d, f4095g[1]);
            kotlin.jvm.internal.h.e(cloneableType, "cloneableType");
            return kotlin.collections.n.y(cloneableType, f6);
        }
        if (!eVarH.equals(eVar) && k2.o.f3745c0.get(eVarH) == null) {
            String str = C0652d.f4074a;
            L2.b bVarF = C0652d.f(eVarH);
            if (bVarF == null) {
                zIsAssignableFrom = false;
            } else {
                try {
                    zIsAssignableFrom = Serializable.class.isAssignableFrom(Class.forName(bVarF.b().b()));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
            }
        }
        return zIsAssignableFrom ? Z.p(f6) : u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public final boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
        kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
        C0029k c0029kA = a(classDescriptor);
        if (c0029kA == null || !functionDescriptor.getAnnotations().hasAnnotation(AbstractC0757b.f4472a)) {
            return true;
        }
        b().getClass();
        String strO = E1.k.o(functionDescriptor, 3);
        r rVarE = c0029kA.e();
        L2.f name = functionDescriptor.getName();
        kotlin.jvm.internal.h.e(name, "functionDescriptor.name");
        Collection contributedFunctions = rVarE.getContributedFunctions(name, EnumC0851b.f4933a);
        if (contributedFunctions != null && contributedFunctions.isEmpty()) {
            return false;
        }
        Iterator it = contributedFunctions.iterator();
        while (it.hasNext()) {
            if (E1.k.o((SimpleFunctionDescriptor) it.next(), 3).equals(strO)) {
                return true;
            }
        }
        return false;
    }
}
