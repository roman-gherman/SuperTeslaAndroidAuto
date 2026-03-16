package a3;

import A2.C0019a;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;

/* JADX INFO: renamed from: a3.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0161y implements TypeConstructor, IntersectionTypeConstructorMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0162z f1559a;
    public final LinkedHashSet b;
    public final int c;

    public C0161y(AbstractCollection typesToIntersect) {
        kotlin.jvm.internal.h.f(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet linkedHashSet = new LinkedHashSet(typesToIntersect);
        this.b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    public final F a() {
        M.b.getClass();
        return C.e(M.c, this, kotlin.collections.u.f3804a, false, kotlin.reflect.l.m("member scope for intersection type", this.b), new C0019a(this, 12));
    }

    public final String b(Function1 getProperTypeRelatedToStringify) {
        kotlin.jvm.internal.h.f(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return kotlin.collections.m.V(kotlin.collections.m.k0(this.b, new C0159w(getProperTypeRelatedToStringify, 0)), " & ", "{", "}", new C0019a(getProperTypeRelatedToStringify, 13), 24);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final C0161y refine(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        LinkedHashSet linkedHashSet = this.b;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(linkedHashSet));
        Iterator it = linkedHashSet.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            arrayList.add(((AbstractC0162z) it.next()).e(kotlinTypeRefiner));
            z6 = true;
        }
        C0161y c0161y = null;
        if (z6) {
            AbstractC0162z abstractC0162z = this.f1559a;
            AbstractC0162z abstractC0162zH = abstractC0162z != null ? abstractC0162z.e(kotlinTypeRefiner) : null;
            C0161y c0161y2 = new C0161y(new C0161y(arrayList).b);
            c0161y2.f1559a = abstractC0162zH;
            c0161y = c0161y2;
        }
        return c0161y == null ? this : c0161y;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0161y) {
            return kotlin.jvm.internal.h.a(this.b, ((C0161y) obj).b);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final k2.i getBuiltIns() {
        k2.i builtIns = ((AbstractC0162z) this.b.iterator().next()).c().getBuiltIns();
        kotlin.jvm.internal.h.e(builtIns, "intersectedTypes.iterato…xt().constructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        return kotlin.collections.u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final Collection getSupertypes() {
        return this.b;
    }

    public final int hashCode() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return false;
    }

    public final String toString() {
        return b(C0160x.f1558a);
    }
}
