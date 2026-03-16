package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import C0.t;
import G2.C0111k;
import G2.C0125z;
import G2.H;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.E;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3917a;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(Object obj, int i) {
        super(0);
        this.f3917a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3917a) {
            case 0:
                l lVar = (l) this.b;
                Set setG = lVar.g();
                if (setG == null) {
                    return null;
                }
                return E.w(E.w(lVar.f(), lVar.b.getTypeAliasNames()), setG);
            case 1:
                return (ArrayList) this.b;
            case 2:
                t tVar = (t) this.b;
                tVar.getClass();
                HashSet hashSet = new HashSet();
                g gVar = (g) tVar.e;
                Iterator it = gVar.f3902n.getSupertypes().iterator();
                while (it.hasNext()) {
                    for (DeclarationDescriptor declarationDescriptor : AbstractC0132a.y(((AbstractC0162z) it.next()).getMemberScope(), null, 3)) {
                        if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                            hashSet.add(declarationDescriptor.getName());
                        }
                    }
                }
                C0111k c0111k = gVar.e;
                List list = c0111k.q;
                kotlin.jvm.internal.h.e(list, "classProto.functionList");
                Iterator it2 = list.iterator();
                while (true) {
                    boolean zHasNext = it2.hasNext();
                    X2.i iVar = gVar.f3900l;
                    if (!zHasNext) {
                        List list2 = c0111k.f638r;
                        kotlin.jvm.internal.h.e(list2, "classProto.propertyList");
                        Iterator it3 = list2.iterator();
                        while (it3.hasNext()) {
                            hashSet.add(kotlin.reflect.l.I(iVar.b, ((H) it3.next()).f453f));
                        }
                        return E.w(hashSet, hashSet);
                    }
                    hashSet.add(kotlin.reflect.l.I(iVar.b, ((C0125z) it2.next()).f688f));
                }
                break;
            case 3:
                return kotlin.collections.m.s0((Iterable) ((kotlin.jvm.internal.i) this.b).invoke());
            default:
                q qVar = (q) this.b;
                X2.i iVar2 = qVar.f3938k;
                return kotlin.collections.m.o0(iVar2.f1433a.e.loadTypeParameterAnnotations(qVar.f3939l, iVar2.b));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(Function0 function0) {
        super(0);
        this.f3917a = 3;
        this.b = (kotlin.jvm.internal.i) function0;
    }
}
