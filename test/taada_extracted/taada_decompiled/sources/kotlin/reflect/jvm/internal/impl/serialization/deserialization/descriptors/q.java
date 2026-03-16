package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import C0.x;
import G2.U;
import G2.Y;
import G2.Z;
import a3.AbstractC0162z;
import a3.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import n2.v;
import q2.AbstractC0766c;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends AbstractC0766c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final X2.i f3937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Z f3938l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f3939m;

    /* JADX WARN: Illegal instructions before constructor call */
    public q(X2.i c, Z z6, int i) {
        d0 d0Var;
        kotlin.jvm.internal.h.f(c, "c");
        X2.g gVar = c.f1433a;
        StorageManager storageManager = gVar.f1418a;
        Annotations.Companion.getClass();
        o2.e eVar = o2.f.b;
        L2.f fVarI = kotlin.reflect.l.I(c.b, z6.e);
        Y y = z6.f530g;
        kotlin.jvm.internal.h.e(y, "proto.variance");
        int iOrdinal = y.ordinal();
        if (iOrdinal == 0) {
            d0Var = d0.IN_VARIANCE;
        } else if (iOrdinal == 1) {
            d0Var = d0.OUT_VARIANCE;
        } else {
            if (iOrdinal != 2) {
                throw new x();
            }
            d0Var = d0.INVARIANT;
        }
        d0 d0Var2 = d0Var;
        super(storageManager, c.c, eVar, fVarI, d0Var2, z6.f529f, i, SourceElement.NO_SOURCE, v.b);
        this.f3937k = c;
        this.f3938l = z6;
        this.f3939m = new a(gVar.f1418a, new k(this, 4));
    }

    @Override // o2.AbstractC0737a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        return this.f3939m;
    }

    @Override // q2.AbstractC0772i
    public final void h(AbstractC0162z type) {
        kotlin.jvm.internal.h.f(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.ArrayList] */
    @Override // q2.AbstractC0772i
    public final List i() {
        X2.i iVar = this.f3937k;
        I2.f fVar = iVar.d;
        Z z6 = this.f3938l;
        kotlin.jvm.internal.h.f(z6, "<this>");
        List list = z6.f531h;
        boolean zIsEmpty = list.isEmpty();
        ?? arrayList = list;
        if (zIsEmpty) {
            arrayList = 0;
        }
        if (arrayList == 0) {
            List<Integer> upperBoundIdList = z6.i;
            kotlin.jvm.internal.h.e(upperBoundIdList, "upperBoundIdList");
            arrayList = new ArrayList(kotlin.collections.o.D(upperBoundIdList));
            for (Integer it : upperBoundIdList) {
                kotlin.jvm.internal.h.e(it, "it");
                arrayList.add(fVar.a(it.intValue()));
            }
        }
        if (arrayList.isEmpty()) {
            return io.ktor.utils.io.Z.p(R2.e.e(this).n());
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(iVar.f1436h.f((U) it2.next()));
        }
        return arrayList2;
    }
}
