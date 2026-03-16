package l2;

import a3.AbstractC0162z;
import a3.Z;
import g3.w;
import io.ktor.utils.io.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.o;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.EnumC0709a;
import q2.C0783u;
import q2.L;
import q2.v;

/* JADX INFO: renamed from: l2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0623g extends L {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0623g(DeclarationDescriptor declarationDescriptor, C0623g c0623g, EnumC0709a enumC0709a, boolean z6) {
        super(declarationDescriptor, c0623g, o2.f.b, w.f3325g, enumC0709a, SourceElement.NO_SOURCE);
        Annotations.Companion.getClass();
        this.f4634m = true;
        this.f4641v = z6;
        this.f4642w = false;
    }

    @Override // q2.L, q2.v
    public final v i(L2.f fVar, DeclarationDescriptor newOwner, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a kind) {
        h.f(newOwner, "newOwner");
        h.f(kind, "kind");
        h.f(annotations, "annotations");
        return new C0623g(newOwner, (C0623g) functionDescriptor, kind, this.f4641v);
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExternal() {
        return false;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public final boolean isTailrec() {
        return false;
    }

    @Override // q2.v
    public final v j(C0783u c0783u) {
        L2.f fVar;
        C0623g c0623g = (C0623g) super.j(c0783u);
        if (c0623g == null) {
            return null;
        }
        List valueParameters = c0623g.getValueParameters();
        h.e(valueParameters, "substituted.valueParameters");
        if (valueParameters.isEmpty()) {
            return c0623g;
        }
        Iterator it = valueParameters.iterator();
        while (it.hasNext()) {
            AbstractC0162z type = ((ValueParameterDescriptor) it.next()).getType();
            h.e(type, "it.type");
            if (b0.l(type) != null) {
                List valueParameters2 = c0623g.getValueParameters();
                h.e(valueParameters2, "substituted.valueParameters");
                ArrayList arrayList = new ArrayList(o.D(valueParameters2));
                Iterator it2 = valueParameters2.iterator();
                while (it2.hasNext()) {
                    AbstractC0162z type2 = ((ValueParameterDescriptor) it2.next()).getType();
                    h.e(type2, "it.type");
                    arrayList.add(b0.l(type2));
                }
                int size = c0623g.getValueParameters().size() - arrayList.size();
                boolean z6 = true;
                if (size == 0) {
                    List valueParameters3 = c0623g.getValueParameters();
                    h.e(valueParameters3, "valueParameters");
                    ArrayList<N1.e> arrayListU0 = m.u0(arrayList, valueParameters3);
                    if (arrayListU0.isEmpty()) {
                        return c0623g;
                    }
                    for (N1.e eVar : arrayListU0) {
                        if (!h.a((L2.f) eVar.f1121a, ((ValueParameterDescriptor) eVar.b).getName())) {
                        }
                    }
                    return c0623g;
                }
                List<ValueParameterDescriptor> valueParameters4 = c0623g.getValueParameters();
                h.e(valueParameters4, "valueParameters");
                ArrayList arrayList2 = new ArrayList(o.D(valueParameters4));
                for (ValueParameterDescriptor valueParameterDescriptor : valueParameters4) {
                    L2.f name = valueParameterDescriptor.getName();
                    h.e(name, "it.name");
                    int index = valueParameterDescriptor.getIndex();
                    int i = index - size;
                    if (i >= 0 && (fVar = (L2.f) arrayList.get(i)) != null) {
                        name = fVar;
                    }
                    arrayList2.add(valueParameterDescriptor.copy(c0623g, name, index));
                }
                C0783u c0783uM = c0623g.m(Z.b);
                if (arrayList.isEmpty()) {
                    z6 = false;
                } else {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        if (((L2.f) it3.next()) == null) {
                            break;
                        }
                    }
                    z6 = false;
                }
                c0783uM.f4623v = Boolean.valueOf(z6);
                c0783uM.f4611g = arrayList2;
                c0783uM.e = c0623g.getOriginal();
                v vVarJ = super.j(c0783uM);
                h.c(vVarJ);
                return vVarJ;
            }
        }
        return c0623g;
    }
}
