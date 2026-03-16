package w2;

import a3.AbstractC0162z;
import a3.Z;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: w2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0880n implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public final N2.g getContract() {
        return N2.g.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public final N2.h isOverridable(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.h.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.h.f(subDescriptor, "subDescriptor");
        boolean z6 = subDescriptor instanceof y2.e;
        N2.h hVar = N2.h.c;
        if (z6) {
            y2.e eVar = (y2.e) subDescriptor;
            if (eVar.getTypeParameters().isEmpty()) {
                N2.n nVarI = N2.o.i(superDescriptor, subDescriptor);
                if ((nVarI != null ? nVarI.c() : 0) == 0) {
                    List valueParameters = eVar.getValueParameters();
                    kotlin.jvm.internal.h.e(valueParameters, "subDescriptor.valueParameters");
                    k3.u uVarD = k3.m.D(kotlin.collections.m.K(valueParameters), C0879m.f5017a);
                    AbstractC0162z abstractC0162z = eVar.f4630g;
                    kotlin.jvm.internal.h.c(abstractC0162z);
                    k3.h hVarA = k3.m.A(kotlin.collections.j.u(new Sequence[]{uVarD, kotlin.collections.j.u(new Object[]{abstractC0162z})}));
                    q2.w wVar = eVar.i;
                    k3.g gVar = new k3.g(k3.m.A(kotlin.collections.j.u(new Sequence[]{hVarA, kotlin.collections.m.K(kotlin.collections.n.z(wVar != null ? wVar.getType() : null))})));
                    while (true) {
                        if (gVar.a()) {
                            AbstractC0162z abstractC0162z2 = (AbstractC0162z) gVar.next();
                            if (!abstractC0162z2.a().isEmpty() && !(abstractC0162z2.f() instanceof B2.h)) {
                                break;
                            }
                        } else {
                            CallableDescriptor callableDescriptorSubstitute = superDescriptor.substitute(Z.e(new B2.f()));
                            if (callableDescriptorSubstitute != null) {
                                if (callableDescriptorSubstitute instanceof SimpleFunctionDescriptor) {
                                    SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) callableDescriptorSubstitute;
                                    List<TypeParameterDescriptor> typeParameters = simpleFunctionDescriptor.getTypeParameters();
                                    kotlin.jvm.internal.h.e(typeParameters, "erasedSuper.typeParameters");
                                    if (!typeParameters.isEmpty()) {
                                        callableDescriptorSubstitute = simpleFunctionDescriptor.newCopyBuilder().setTypeParameters(kotlin.collections.u.f3805a).build();
                                        kotlin.jvm.internal.h.c(callableDescriptorSubstitute);
                                    }
                                }
                                int iC = N2.o.c.n(callableDescriptorSubstitute, subDescriptor, false).c();
                                com.google.protobuf.a.q(iC, "DEFAULT.isOverridableByW…Descriptor, false).result");
                                if (AbstractC0878l.f5016a[f.s.b(iC)] == 1) {
                                    return N2.h.f1137a;
                                }
                            }
                        }
                    }
                }
            }
        }
        return hVar;
    }
}
