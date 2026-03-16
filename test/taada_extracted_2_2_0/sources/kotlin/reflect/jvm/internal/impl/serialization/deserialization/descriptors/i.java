package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import A2.C0019a;
import G2.C0101a;
import G2.C0108h;
import G2.C0125z;
import G2.H;
import G2.U;
import G2.W;
import G2.k0;
import X2.y;
import a3.F;
import h2.C0517u;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import k3.C0590a;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import n2.C0712d;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3911a;
    public final /* synthetic */ j b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(j jVar, int i) {
        super(1);
        this.f3911a = i;
        this.b = jVar;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.Map] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Collection<C0125z> collectionF;
        Collection<H> collectionF2;
        U underlyingType;
        U expandedType;
        switch (this.f3911a) {
            case 0:
                L2.f it = (L2.f) obj;
                kotlin.jvm.internal.h.f(it, "it");
                j jVar = this.b;
                LinkedHashMap linkedHashMap = jVar.f3913a;
                C0101a PARSER = C0125z.f687v;
                kotlin.jvm.internal.h.e(PARSER, "PARSER");
                byte[] bArr = (byte[]) linkedHashMap.get(it);
                l lVar = jVar.i;
                if (bArr != null) {
                    C0517u c0517u = new C0517u(PARSER, new ByteArrayInputStream(bArr), lVar, 1);
                    collectionF = k3.m.F(new C0590a(new k3.j(c0517u, new C0019a(c0517u, 19))));
                } else {
                    collectionF = u.f3805a;
                }
                ArrayList arrayList = new ArrayList(collectionF.size());
                for (C0125z it2 : collectionF) {
                    X2.o oVar = lVar.f3918a.i;
                    kotlin.jvm.internal.h.e(it2, "it");
                    o oVarE = oVar.e(it2);
                    if (!lVar.k(oVarE)) {
                        oVarE = null;
                    }
                    if (oVarE != null) {
                        arrayList.add(oVarE);
                    }
                }
                lVar.c(it, arrayList);
                return j3.p.b(arrayList);
            case 1:
                L2.f it3 = (L2.f) obj;
                kotlin.jvm.internal.h.f(it3, "it");
                j jVar2 = this.b;
                LinkedHashMap linkedHashMap2 = jVar2.b;
                C0101a PARSER2 = H.f452v;
                kotlin.jvm.internal.h.e(PARSER2, "PARSER");
                byte[] bArr2 = (byte[]) linkedHashMap2.get(it3);
                l lVar2 = jVar2.i;
                if (bArr2 != null) {
                    C0517u c0517u2 = new C0517u(PARSER2, new ByteArrayInputStream(bArr2), lVar2, 1);
                    collectionF2 = k3.m.F(new C0590a(new k3.j(c0517u2, new C0019a(c0517u2, 19))));
                } else {
                    collectionF2 = u.f3805a;
                }
                ArrayList arrayList2 = new ArrayList(collectionF2.size());
                for (H it4 : collectionF2) {
                    X2.o oVar2 = lVar2.f3918a.i;
                    kotlin.jvm.internal.h.e(it4, "it");
                    arrayList2.add(oVar2.f(it4));
                }
                lVar2.d(it3, arrayList2);
                return j3.p.b(arrayList2);
            default:
                L2.f it5 = (L2.f) obj;
                kotlin.jvm.internal.h.f(it5, "it");
                j jVar3 = this.b;
                byte[] bArr3 = (byte[]) jVar3.c.get(it5);
                if (bArr3 != null) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr3);
                    l lVar3 = jVar3.i;
                    W proto = (W) W.f513p.parseDelimitedFrom(byteArrayInputStream, lVar3.f3918a.f1433a.f1428p);
                    if (proto != null) {
                        X2.o oVar3 = lVar3.f3918a.i;
                        oVar3.getClass();
                        kotlin.jvm.internal.h.f(proto, "proto");
                        o2.f fVar = Annotations.Companion;
                        List list = proto.f518k;
                        kotlin.jvm.internal.h.e(list, "proto.annotationList");
                        ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(list));
                        Iterator it6 = list.iterator();
                        while (true) {
                            boolean zHasNext = it6.hasNext();
                            X2.i iVar = oVar3.f1444a;
                            if (!zHasNext) {
                                fVar.getClass();
                                Annotations annotationsA = o2.f.a(arrayList3);
                                C0712d c0712dS = C5.f.s((k0) I2.e.d.c(proto.d));
                                StorageManager storageManager = iVar.f1433a.f1418a;
                                L2.f fVarI = kotlin.reflect.l.I(iVar.b, proto.e);
                                I2.f fVar2 = iVar.d;
                                p pVar = new p(storageManager, iVar.c, annotationsA, fVarI, c0712dS, proto, iVar.b, fVar2, iVar.e, iVar.f1435g);
                                List list2 = proto.f514f;
                                kotlin.jvm.internal.h.e(list2, "proto.typeParameterList");
                                y yVar = iVar.a(pVar, list2, iVar.b, iVar.d, iVar.e, iVar.f1434f).f1436h;
                                List listO0 = kotlin.collections.m.o0(yVar.f1457g.values());
                                int i = proto.c;
                                if ((i & 4) == 4) {
                                    underlyingType = proto.f515g;
                                    kotlin.jvm.internal.h.e(underlyingType, "underlyingType");
                                } else {
                                    if ((i & 8) != 8) {
                                        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias");
                                    }
                                    underlyingType = fVar2.a(proto.f516h);
                                }
                                F fC = yVar.c(underlyingType, false);
                                int i3 = proto.c;
                                if ((i3 & 16) == 16) {
                                    expandedType = proto.i;
                                    kotlin.jvm.internal.h.e(expandedType, "expandedType");
                                } else {
                                    if ((i3 & 32) != 32) {
                                        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias");
                                    }
                                    expandedType = fVar2.a(proto.f517j);
                                }
                                pVar.g(listO0, fC, yVar.c(expandedType, false));
                                return pVar;
                            }
                            C0108h it7 = (C0108h) it6.next();
                            kotlin.jvm.internal.h.e(it7, "it");
                            arrayList3.add(oVar3.b.c(it7, iVar.b));
                        }
                    }
                }
                return null;
        }
    }
}
