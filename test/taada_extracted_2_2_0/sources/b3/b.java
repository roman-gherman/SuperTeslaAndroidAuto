package b3;

import A2.C0031m;
import C0.x;
import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.C;
import a3.C0161y;
import a3.F;
import a3.c0;
import a3.d0;
import c4.AbstractC0246d;
import d3.EnumC0418b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1698a = new b();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [a3.y] */
    /* JADX WARN: Type inference failed for: r0v2, types: [a3.y] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static F b(F f6) {
        AbstractC0162z type;
        TypeConstructor typeConstructorC = f6.c();
        ?? r22 = 0;
        if (typeConstructorC instanceof O2.b) {
            O2.b bVar = (O2.b) typeConstructorC;
            TypeProjection typeProjection = bVar.f1190a;
            if (typeProjection.getProjectionKind() != d0.IN_VARIANCE) {
                typeProjection = null;
            }
            c0 c0VarF = (typeProjection == null || (type = typeProjection.getType()) == null) ? null : type.f();
            if (bVar.b == null) {
                Collection supertypes = bVar.getSupertypes();
                ArrayList arrayList = new ArrayList(kotlin.collections.o.D(supertypes));
                Iterator it = supertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AbstractC0162z) it.next()).f());
                }
                TypeProjection projection = bVar.f1190a;
                kotlin.jvm.internal.h.f(projection, "projection");
                bVar.b = new h(projection, new g(0, arrayList), (TypeParameterDescriptor) r22, 8);
            }
            EnumC0418b enumC0418b = EnumC0418b.f3119a;
            h hVar = bVar.b;
            kotlin.jvm.internal.h.c(hVar);
            return new f(enumC0418b, hVar, c0VarF, f6.b(), f6.d(), 32);
        }
        if (!(typeConstructorC instanceof C0161y) || !f6.d()) {
            return f6;
        }
        ?? r02 = (C0161y) typeConstructorC;
        LinkedHashSet linkedHashSet = r02.b;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(linkedHashSet));
        Iterator it2 = linkedHashSet.iterator();
        boolean z6 = false;
        while (it2.hasNext()) {
            arrayList2.add(AbstractC0246d.e0((AbstractC0162z) it2.next()));
            z6 = true;
        }
        if (z6) {
            AbstractC0162z abstractC0162z = r02.f1559a;
            c0 c0VarE0 = abstractC0162z != null ? AbstractC0246d.e0(abstractC0162z) : null;
            arrayList2.isEmpty();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList2);
            linkedHashSet2.hashCode();
            C0161y c0161y = new C0161y(linkedHashSet2);
            c0161y.f1559a = c0VarE0;
            r22 = c0161y;
        }
        if (r22 != 0) {
            r02 = r22;
        }
        return r02.a();
    }

    public final c0 a(KotlinTypeMarker type) {
        c0 c0VarA;
        kotlin.jvm.internal.h.f(type, "type");
        if (!(type instanceof AbstractC0162z)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        c0 c0VarF = ((AbstractC0162z) type).f();
        if (c0VarF instanceof F) {
            c0VarA = b((F) c0VarF);
        } else {
            if (!(c0VarF instanceof AbstractC0155s)) {
                throw new x();
            }
            AbstractC0155s abstractC0155s = (AbstractC0155s) c0VarF;
            F f6 = abstractC0155s.b;
            F fB = b(f6);
            F f7 = abstractC0155s.c;
            F fB2 = b(f7);
            c0VarA = (fB == f6 && fB2 == f7) ? c0VarF : C.a(fB, fB2);
        }
        C0031m c0031m = new C0031m(1, 3, this);
        AbstractC0162z abstractC0162zZ = kotlin.reflect.l.z(c0VarF);
        return kotlin.reflect.l.k0(c0VarA, abstractC0162zZ != null ? (AbstractC0162z) c0031m.invoke(abstractC0162zZ) : null);
    }
}
