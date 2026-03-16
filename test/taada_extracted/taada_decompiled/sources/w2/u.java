package w2;

import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public final N2.g getContract() {
        return N2.g.f1136a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5  */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N2.h isOverridable(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r7, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r8, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9) {
        /*
            r6 = this;
            java.lang.String r0 = "superDescriptor"
            kotlin.jvm.internal.h.f(r7, r0)
            java.lang.String r0 = "subDescriptor"
            kotlin.jvm.internal.h.f(r8, r0)
            boolean r0 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            N2.h r1 = N2.h.b
            if (r0 == 0) goto La5
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r0 == 0) goto La5
            boolean r0 = k2.i.y(r8)
            if (r0 == 0) goto L1c
            goto La5
        L1c:
            int r0 = w2.C0874h.f5011l
            r0 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            L2.f r2 = r0.getName()
            java.lang.String r3 = "subDescriptor.name"
            kotlin.jvm.internal.h.e(r2, r3)
            boolean r2 = w2.C0874h.b(r2)
            if (r2 != 0) goto L42
            java.util.ArrayList r2 = w2.N.f4993a
            L2.f r2 = r0.getName()
            kotlin.jvm.internal.h.e(r2, r3)
            java.util.ArrayList r3 = w2.N.f4997j
            boolean r2 = r3.contains(r2)
            if (r2 != 0) goto L42
            goto La5
        L42:
            r2 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r2 = io.ktor.utils.io.b0.q(r2)
            boolean r3 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r3 == 0) goto L51
            r4 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            goto L52
        L51:
            r4 = 0
        L52:
            if (r4 == 0) goto L5f
            boolean r5 = r0.isHiddenToOvercomeSignatureClash()
            boolean r4 = r4.isHiddenToOvercomeSignatureClash()
            if (r5 != r4) goto L5f
            goto L68
        L5f:
            if (r2 == 0) goto Lab
            boolean r4 = r0.isHiddenToOvercomeSignatureClash()
            if (r4 != 0) goto L68
            goto Lab
        L68:
            boolean r4 = r9 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor
            if (r4 == 0) goto La5
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = r0.getInitialSignatureDescriptor()
            if (r4 == 0) goto L73
            goto La5
        L73:
            if (r2 == 0) goto La5
            boolean r9 = io.ktor.utils.io.b0.t(r9, r2)
            if (r9 == 0) goto L7c
            goto La5
        L7c:
            boolean r9 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r9 == 0) goto Lab
            if (r3 == 0) goto Lab
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r9 = w2.C0874h.a(r2)
            if (r9 == 0) goto Lab
            r9 = 2
            java.lang.String r0 = E1.k.o(r0, r9)
            r2 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = r2.getOriginal()
            java.lang.String r3 = "superDescriptor.original"
            kotlin.jvm.internal.h.e(r2, r3)
            java.lang.String r9 = E1.k.o(r2, r9)
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto Lab
        La5:
            boolean r7 = k1.j.h(r7, r8)
            if (r7 == 0) goto Lac
        Lab:
            return r1
        Lac:
            N2.h r7 = N2.h.c
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.u.isOverridable(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):N2.h");
    }
}
