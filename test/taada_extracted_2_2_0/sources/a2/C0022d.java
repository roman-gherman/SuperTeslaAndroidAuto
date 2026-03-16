package A2;

import a.AbstractC0132a;
import a3.AbstractC0147j;
import a3.AbstractC0162z;
import a3.C0144g;
import a3.W;
import a3.Z;
import c4.AbstractC0246d;
import h2.n0;
import h2.o0;
import h2.p0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlinx.coroutines.CoroutineExceptionHandler;
import m2.C0656h;
import m2.C0657i;
import m3.C0688w;
import m3.t0;
import q2.AbstractC0765b;
import q2.Q;

/* JADX INFO: renamed from: A2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0022d extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f31a;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0022d(Object obj, int i) {
        super(0);
        this.f31a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v48, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r5v22, types: [N2.o] */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlin.collections.u] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws IllegalAccessException {
        ?? arrayList;
        switch (this.f31a) {
            case 0:
                C0023e c0023e = (C0023e) this.b;
                t tVar = c0023e.b;
                tVar.getClass();
                Collection collectionValues = ((Map) AbstractC0246d.T(tVar.f69j, t.f66o[0])).values();
                ArrayList arrayList2 = new ArrayList();
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m mVarA = c0023e.f32a.f5204a.d.a(c0023e.b, (KotlinJvmBinaryClass) it.next());
                    if (mVarA != null) {
                        arrayList2.add(mVarA);
                    }
                }
                return (MemberScope[]) AbstractC0246d.d0(arrayList2).toArray(new MemberScope[0]);
            case 1:
                M2.p changeOptions = M2.p.f1062a;
                M2.s sVar = (M2.s) this.b;
                sVar.getClass();
                kotlin.jvm.internal.h.f(changeOptions, "changeOptions");
                M2.x xVar = sVar.d;
                M2.x xVar2 = new M2.x();
                Field[] declaredFields = M2.x.class.getDeclaredFields();
                kotlin.jvm.internal.h.e(declaredFields, "this::class.java.declaredFields");
                int length = declaredFields.length;
                int i = 0;
                int i3 = 0;
                while (i3 < length) {
                    Field field = declaredFields[i3];
                    if ((field.getModifiers() & 8) == 0) {
                        field.setAccessible(true);
                        Object obj = field.get(xVar);
                        M2.v vVar = obj instanceof M2.v ? (M2.v) obj : null;
                        if (vVar != null) {
                            String name = field.getName();
                            kotlin.jvm.internal.h.e(name, "field.name");
                            kotlin.text.r.C(name, "is");
                            KClass kClassB = kotlin.jvm.internal.w.f3818a.b(M2.x.class);
                            String name2 = field.getName();
                            StringBuilder sb = new StringBuilder("get");
                            String name3 = field.getName();
                            kotlin.jvm.internal.h.e(name3, "field.name");
                            if (name3.length() > 0) {
                                char upperCase = Character.toUpperCase(name3.charAt(i));
                                String strSubstring = name3.substring(1);
                                kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                                name3 = upperCase + strSubstring;
                            }
                            sb.append(name3);
                            new kotlin.jvm.internal.q(kClassB, name2, sb.toString());
                            field.set(xVar2, new M2.v(vVar.f1078a, xVar2));
                        }
                    }
                    i3++;
                    i = 0;
                }
                changeOptions.invoke(xVar2);
                xVar2.f1095a = true;
                return new M2.s(xVar2);
            case 2:
                AbstractC0162z type = ((TypeProjection) this.b).getType();
                kotlin.jvm.internal.h.e(type, "this@createCapturedIfNeeded.type");
                return type;
            case 3:
                ((P2.m) this.b).getClass();
                throw null;
            case 4:
                U2.h hVar = (U2.h) this.b;
                List listA = hVar.a();
                ArrayList arrayList3 = new ArrayList(3);
                AbstractC0765b abstractC0765b = hVar.f1333a;
                Collection<AbstractC0162z> supertypes = abstractC0765b.getTypeConstructor().getSupertypes();
                kotlin.jvm.internal.h.e(supertypes, "containingClass.typeConstructor.supertypes");
                ArrayList arrayList4 = new ArrayList();
                Iterator it2 = supertypes.iterator();
                while (it2.hasNext()) {
                    kotlin.collections.s.F(AbstractC0132a.y(((AbstractC0162z) it2.next()).getMemberScope(), null, 3), arrayList4);
                }
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : arrayList4) {
                    if (obj2 instanceof CallableMemberDescriptor) {
                        arrayList5.add(obj2);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj3 : arrayList5) {
                    L2.f name4 = ((CallableMemberDescriptor) obj3).getName();
                    Object arrayList6 = linkedHashMap.get(name4);
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList();
                        linkedHashMap.put(name4, arrayList6);
                    }
                    ((List) arrayList6).add(obj3);
                }
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    L2.f fVar = (L2.f) entry.getKey();
                    List list = (List) entry.getValue();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Object obj4 : list) {
                        Boolean boolValueOf = Boolean.valueOf(((CallableMemberDescriptor) obj4) instanceof FunctionDescriptor);
                        Object arrayList7 = linkedHashMap2.get(boolValueOf);
                        if (arrayList7 == null) {
                            arrayList7 = new ArrayList();
                            linkedHashMap2.put(boolValueOf, arrayList7);
                        }
                        ((List) arrayList7).add(obj4);
                    }
                    for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                        boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                        List list2 = (List) entry2.getValue();
                        ?? r52 = N2.o.c;
                        if (zBooleanValue) {
                            arrayList = new ArrayList();
                            for (Object obj5 : listA) {
                                if (kotlin.jvm.internal.h.a(((FunctionDescriptor) obj5).getName(), fVar)) {
                                    arrayList.add(obj5);
                                }
                            }
                        } else {
                            arrayList = kotlin.collections.u.f3805a;
                        }
                        r52.h(fVar, list2, arrayList, abstractC0765b, new U2.g(arrayList3, hVar));
                    }
                }
                return kotlin.collections.m.b0(j3.p.b(arrayList3), listA);
            case 5:
                MemberScope memberScope = (MemberScope) ((Function0) this.b).invoke();
                return memberScope instanceof U2.j ? ((U2.j) memberScope).a() : memberScope;
            case 6:
                U2.q qVar = (U2.q) this.b;
                return qVar.a(AbstractC0132a.y(qVar.f1341a, null, 3));
            case 7:
                W wG = ((Z) this.b).g();
                wG.getClass();
                return Z.e(wG);
            case 8:
                return (Enum[]) this.b;
            case 9:
                Set setKeySet = ((LinkedHashMap) ((Y2.c) this.b).f1486j.e).keySet();
                ArrayList arrayList8 = new ArrayList();
                for (Object obj6 : setKeySet) {
                    L2.b bVar = (L2.b) obj6;
                    if (bVar.b.e().d() && !X2.e.c.contains(bVar)) {
                        arrayList8.add(obj6);
                    }
                }
                ArrayList arrayList9 = new ArrayList(kotlin.collections.o.D(arrayList8));
                Iterator it3 = arrayList8.iterator();
                while (it3.hasNext()) {
                    arrayList9.add(((L2.b) it3.next()).i());
                }
                return arrayList9;
            case 10:
                return new C0144g(((AbstractC0147j) this.b).a());
            case 11:
                return E1.k.j0((TypeParameterDescriptor) ((a3.K) this.b).b);
            case 12:
                return c3.j.c(c3.i.CANNOT_COMPUTE_ERASED_BOUND, ((B.h) this.b).toString());
            case 13:
                Function0 function0 = ((b3.h) this.b).b;
                if (function0 != null) {
                    return (List) function0.invoke();
                }
                return null;
            case 14:
                return "This collections cannot be empty! input types: ".concat(kotlin.collections.m.V((LinkedHashSet) this.b, null, null, null, null, 63));
            case 15:
                return p0.a(((h2.D) this.b).getJClass());
            case 16:
                return new h2.G((h2.H) this.b);
            case 17:
                return new h2.I((h2.J) this.b);
            case 18:
                return new h2.K((h2.L) this.b);
            case 19:
                List<AbstractC0162z> upperBounds = ((o0) this.b).f3425a.getUpperBounds();
                kotlin.jvm.internal.h.e(upperBounds, "descriptor.upperBounds");
                ArrayList arrayList10 = new ArrayList(kotlin.collections.o.D(upperBounds));
                Iterator it4 = upperBounds.iterator();
                while (it4.hasNext()) {
                    arrayList10.add(new n0((AbstractC0162z) it4.next(), null));
                }
                return arrayList10;
            case 20:
                int iHashCode = 0;
                for (Map.Entry entry3 : ((Map) this.b).entrySet()) {
                    String str = (String) entry3.getKey();
                    Object value = entry3.getValue();
                    iHashCode += (value instanceof boolean[] ? Arrays.hashCode((boolean[]) value) : value instanceof char[] ? Arrays.hashCode((char[]) value) : value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value instanceof short[] ? Arrays.hashCode((short[]) value) : value instanceof int[] ? Arrays.hashCode((int[]) value) : value instanceof float[] ? Arrays.hashCode((float[]) value) : value instanceof long[] ? Arrays.hashCode((long[]) value) : value instanceof double[] ? Arrays.hashCode((double[]) value) : value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode()) ^ (str.hashCode() * 127);
                }
                return Integer.valueOf(iHashCode);
            case 21:
                return kotlin.coroutines.a.d(new t0(null), new z1.g(CoroutineExceptionHandler.Key)).plus(((j1.e) this.b).f3651a).plus(new C0688w("ktor-android-context"));
            case 22:
                return this.b;
            case 23:
                return kotlin.jvm.internal.h.j((Object[]) this.b);
            case 24:
                return ((List) this.b).iterator();
            case 25:
                return Boolean.valueOf(((m1.v) this.b).c);
            case 26:
                C0657i c0657i = (C0657i) this.b;
                k2.m mVar = c0657i.f4091g;
                if (mVar == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                C0656h c0656h = (C0656h) mVar.invoke();
                c0657i.f4091g = null;
                return c0656h;
            case 27:
                n2.t tVar2 = (n2.t) this.b;
                return (MemberScope) tVar2.b.invoke(tVar2.c);
            case 28:
                o2.h hVar2 = (o2.h) this.b;
                return hVar2.f4291a.i(hVar2.b).getDefaultType();
            default:
                return (List) ((Q) this.b).f4580l.getValue();
        }
    }
}
