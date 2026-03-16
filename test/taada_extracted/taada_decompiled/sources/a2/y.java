package A2;

import G2.C0120u;
import G2.U;
import a.AbstractC0132a;
import a3.AbstractC0147j;
import a3.AbstractC0162z;
import a3.C0143f;
import a3.c0;
import h2.C0499b;
import h2.l0;
import h2.m0;
import h2.n0;
import h2.v0;
import i2.C0530c;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import m2.C0649a;
import m2.C0655g;
import m2.C0657i;
import m2.C0661m;
import n2.AbstractC0718j;
import n2.EnumC0709a;
import n2.EnumC0711c;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;
import q2.C0763B;
import q2.C0775l;
import x2.C0915b;
import z2.C0941a;
import z2.C0945e;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f75a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(int i, Object obj, Object obj2) {
        super(0);
        this.f75a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Type inference failed for: r1v20, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r2v49, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        kotlin.reflect.d dVar;
        switch (this.f75a) {
            case 0:
                ((C0946f) this.b).f5203a.b.knownClassNamesInPackage(((z) this.c).f77n.e);
                return null;
            case 1:
                X2.i iVar = ((X2.y) this.b).f1455a;
                return iVar.f1433a.e.loadTypeAnnotations((U) this.c, iVar.b);
            case 2:
                b3.d dVar2 = ((C0143f) this.b).f1549a;
                List<AbstractC0162z> types = ((AbstractC0147j) this.c).getSupertypes();
                kotlin.jvm.internal.h.f(types, "types");
                ArrayList arrayList = new ArrayList(kotlin.collections.o.D(types));
                for (AbstractC0162z type : types) {
                    kotlin.jvm.internal.h.f(type, "type");
                    arrayList.add(type);
                }
                return arrayList;
            case 3:
                return ((b3.d) this.b).a((KotlinTypeMarker) ((a3.D) this.c).c.invoke());
            case 4:
                Iterable iterable = (List) ((b3.h) this.b).e.getValue();
                if (iterable == null) {
                    iterable = kotlin.collections.u.f3804a;
                }
                ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(iterable));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((c0) it.next()).e((b3.d) this.c));
                }
                return arrayList2;
            case 5:
                h2.F f6 = (h2.F) this.b;
                h2.D d = f6.f3366f;
                d.getClass();
                String str = (String) this.c;
                String signature = f6.f3367g;
                kotlin.jvm.internal.h.f(signature, "signature");
                Collection collectionO0 = str.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME) ? kotlin.collections.m.o0(d.c()) : d.d(L2.f.e(str));
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : collectionO0) {
                    if (kotlin.jvm.internal.h.a(v0.c((FunctionDescriptor) obj).c(), signature)) {
                        arrayList3.add(obj);
                    }
                }
                if (arrayList3.size() == 1) {
                    return (FunctionDescriptor) kotlin.collections.m.g0(arrayList3);
                }
                String strV = kotlin.collections.m.V(collectionO0, "\n", null, null, C0499b.i, 30);
                StringBuilder sb = new StringBuilder("Function '");
                sb.append(str);
                sb.append("' (JVM signature: ");
                sb.append(signature);
                sb.append(") not resolved in ");
                sb.append(d);
                sb.append(':');
                sb.append(strV.length() == 0 ? " no members found" : "\n".concat(strV));
                throw new N1.d(sb.toString(), 2);
            case 6:
                n0 n0Var = (n0) this.b;
                List listA = n0Var.f3422a.a();
                if (listA.isEmpty()) {
                    return kotlin.collections.u.f3804a;
                }
                Lazy lazyN = AbstractC0132a.N(2, new m0(n0Var, 0));
                ArrayList arrayList4 = new ArrayList(kotlin.collections.o.D(listA));
                int i = 0;
                for (Object obj2 : listA) {
                    int i3 = i + 1;
                    if (i < 0) {
                        kotlin.collections.n.C();
                        throw null;
                    }
                    TypeProjection typeProjection = (TypeProjection) obj2;
                    if (typeProjection.isStarProjection()) {
                        dVar = kotlin.reflect.d.c;
                    } else {
                        AbstractC0162z type2 = typeProjection.getType();
                        kotlin.jvm.internal.h.e(type2, "typeProjection.type");
                        n0 n0Var2 = new n0(type2, ((kotlin.jvm.internal.i) this.c) != null ? new l0(n0Var, i, lazyN) : null);
                        int iOrdinal = typeProjection.getProjectionKind().ordinal();
                        if (iOrdinal == 0) {
                            dVar = new kotlin.reflect.d(kotlin.reflect.e.f3823a, n0Var2);
                        } else if (iOrdinal == 1) {
                            dVar = new kotlin.reflect.d(kotlin.reflect.e.b, n0Var2);
                        } else {
                            if (iOrdinal != 2) {
                                throw new C0.x();
                            }
                            dVar = new kotlin.reflect.d(kotlin.reflect.e.c, n0Var2);
                        }
                    }
                    arrayList4.add(dVar);
                    i = i3;
                }
                return arrayList4;
            case 7:
                StringBuilder sb2 = new StringBuilder();
                sb2.append('@');
                sb2.append(((Class) this.b).getCanonicalName());
                kotlin.collections.m.U(((Map) this.c).entrySet(), sb2, ", ", "(", ")", C0530c.f3468a, 48);
                String string = sb2.toString();
                kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            case 8:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) this.b;
                return kotlin.collections.m.o0(gVar.f3899l.f1433a.e.loadEnumEntryAnnotations(gVar.f3908w, (C0120u) this.c));
            case 9:
                C0655g c0655g = (C0655g) this.b;
                Function1 function1 = c0655g.b;
                C0763B c0763b = c0655g.f4088a;
                DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) function1.invoke(c0763b);
                L2.f fVar = C0655g.f4086g;
                EnumC0719k enumC0719k = EnumC0719k.d;
                EnumC0711c enumC0711c = EnumC0711c.b;
                List listP = Z.p(c0763b.d.e());
                SourceElement sourceElement = SourceElement.NO_SOURCE;
                Z2.n nVar = (Z2.n) this.c;
                C0775l c0775l = new C0775l(declarationDescriptor, fVar, enumC0719k, enumC0711c, listP, sourceElement, nVar);
                c0775l.e(new C0649a(nVar, c0775l), kotlin.collections.w.f3806a, null);
                return c0775l;
            case 10:
                C0657i c0657i = (C0657i) this.b;
                C0763B builtInsModule = c0657i.k();
                kotlin.jvm.internal.h.e(builtInsModule, "builtInsModule");
                return new C0661m(builtInsModule, (Z2.n) this.c, new C0022d(c0657i, 26));
            case 11:
                C0661m c0661m = (C0661m) this.b;
                C0763B c0763b2 = c0661m.b().f4089a;
                C0655g.d.getClass();
                return AbstractC0718j.f(c0763b2, C0655g.f4087h, new C0.t((Z2.n) this.c, c0661m.b().f4089a)).getDefaultType();
            case 12:
                JavaResolverCache EMPTY = JavaResolverCache.EMPTY;
                kotlin.jvm.internal.h.e(EMPTY, "EMPTY");
                C0029k c0029k = (C0029k) this.b;
                C0946f c0946f = c0029k.f41j;
                C0941a c0941a = c0946f.f5203a;
                C0946f c0946f2 = new C0946f(new C0941a(c0941a.f5183a, c0941a.b, c0941a.c, c0941a.d, c0941a.e, c0941a.f5184f, EMPTY, c0941a.f5186h, c0941a.i, c0941a.f5187j, c0941a.f5188k, c0941a.f5189l, c0941a.f5190m, c0941a.f5191n, c0941a.f5192o, c0941a.f5193p, c0941a.q, c0941a.f5194r, c0941a.f5195s, c0941a.f5196t, c0941a.u, c0941a.f5197v, c0941a.f5198w), c0946f.b, c0946f.c);
                DeclarationDescriptor containingDeclaration = c0029k.getContainingDeclaration();
                kotlin.jvm.internal.h.e(containingDeclaration, "containingDeclaration");
                return new C0029k(c0946f2, containingDeclaration, c0029k.f40h, (ClassDescriptor) this.c);
            case 13:
                q2.O o6 = (q2.O) this.b;
                StorageManager storageManager = o6.E;
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) this.c;
                Annotations annotations = classConstructorDescriptor.getAnnotations();
                EnumC0709a kind = classConstructorDescriptor.getKind();
                kotlin.jvm.internal.h.e(kind, "underlyingConstructorDescriptor.kind");
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p pVar = o6.f4575F;
                SourceElement source = pVar.getSource();
                kotlin.jvm.internal.h.e(source, "typeAliasDescriptor.source");
                q2.O o7 = new q2.O(storageManager, o6.f4575F, classConstructorDescriptor, o6, annotations, kind, source);
                q2.O.I.getClass();
                a3.Z zD = pVar.getClassDescriptor() == null ? null : a3.Z.d(pVar.getExpandedType());
                if (zD == null) {
                    return null;
                }
                ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor.getDispatchReceiverParameter();
                ReceiverParameterDescriptor receiverParameterDescriptorSubstitute = dispatchReceiverParameter != null ? dispatchReceiverParameter.substitute(zD) : null;
                List<ReceiverParameterDescriptor> contextReceiverParameters = classConstructorDescriptor.getContextReceiverParameters();
                kotlin.jvm.internal.h.e(contextReceiverParameters, "underlyingConstructorDes…contextReceiverParameters");
                ArrayList arrayList5 = new ArrayList(kotlin.collections.o.D(contextReceiverParameters));
                Iterator<T> it2 = contextReceiverParameters.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(((ReceiverParameterDescriptor) it2.next()).substitute(zD));
                }
                List declaredTypeParameters = pVar.getDeclaredTypeParameters();
                List valueParameters = o6.getValueParameters();
                AbstractC0162z abstractC0162z = o6.f4629g;
                kotlin.jvm.internal.h.c(abstractC0162z);
                o7.l(null, receiverParameterDescriptorSubstitute, arrayList5, declaredTypeParameters, valueParameters, abstractC0162z, EnumC0719k.f4247a, pVar.e);
                return o7;
            case 14:
                a3.F defaultType = ((C0946f) this.b).f5203a.f5192o.d.i(((C0915b) this.c).f5111a).getDefaultType();
                kotlin.jvm.internal.h.e(defaultType, "c.module.builtIns.getBui…qName(fqName).defaultType");
                return defaultType;
            case 15:
                Annotations additionalAnnotations = ((ClassOrPackageFragmentDescriptor) this.c).getAnnotations();
                C0946f c0946f3 = (C0946f) this.b;
                kotlin.jvm.internal.h.f(c0946f3, "<this>");
                kotlin.jvm.internal.h.f(additionalAnnotations, "additionalAnnotations");
                return c0946f3.f5203a.q.b((w2.z) c0946f3.d.getValue(), additionalAnnotations);
            case 16:
                C0946f c0946f4 = (C0946f) this.b;
                kotlin.jvm.internal.h.f(c0946f4, "<this>");
                Annotations additionalAnnotations2 = (Annotations) this.c;
                kotlin.jvm.internal.h.f(additionalAnnotations2, "additionalAnnotations");
                return c0946f4.f5203a.q.b((w2.z) c0946f4.d.getValue(), additionalAnnotations2);
            default:
                return new t(((C0945e) this.b).f5202a, (JavaPackage) this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public y(n0 n0Var, Function0 function0) {
        super(0);
        this.f75a = 6;
        this.b = n0Var;
        this.c = (kotlin.jvm.internal.i) function0;
    }
}
