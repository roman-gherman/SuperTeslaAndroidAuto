package g3;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f3322a = new u(1);

    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r7
            java.lang.String r0 = "$this$$receiver"
            kotlin.jvm.internal.h.f(r7, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r7.getDispatchReceiverParameter()
            if (r0 != 0) goto L11
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r7.getExtensionReceiverParameter()
        L11:
            java.util.List r1 = g3.v.b
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L7d
            a3.z r3 = r7.getReturnType()
            if (r3 == 0) goto L2d
            a3.z r4 = r0.getType()
            java.lang.String r5 = "receiver.type"
            kotlin.jvm.internal.h.e(r4, r5)
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r5 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
            boolean r3 = r5.isSubtypeOf(r3, r4)
            goto L2e
        L2d:
            r3 = r2
        L2e:
            if (r3 != 0) goto L7c
            kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r0 = r0.getValue()
            java.lang.String r3 = "receiver.value"
            kotlin.jvm.internal.h.e(r0, r3)
            boolean r3 = r0 instanceof V2.d
            if (r3 != 0) goto L3e
            goto L79
        L3e:
            V2.d r0 = (V2.d) r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r0.f1373a
            boolean r3 = r0.isExpect()
            if (r3 != 0) goto L49
            goto L79
        L49:
            L2.b r3 = R2.e.f(r0)
            if (r3 != 0) goto L50
            goto L79
        L50:
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r0 = R2.e.j(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = n2.AbstractC0718j.e(r0, r3)
            boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
            if (r3 == 0) goto L5f
            kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) r0
            goto L60
        L5f:
            r0 = r1
        L60:
            if (r0 != 0) goto L63
            goto L79
        L63:
            a3.z r7 = r7.getReturnType()
            if (r7 == 0) goto L79
            a3.F r0 = r0.getExpandedType()
            java.lang.String r3 = "superType"
            kotlin.jvm.internal.h.f(r0, r3)
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r3 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
            boolean r7 = r3.isSubtypeOf(r7, r0)
            goto L7a
        L79:
            r7 = r2
        L7a:
            if (r7 == 0) goto L7d
        L7c:
            r2 = 1
        L7d:
            if (r2 != 0) goto L82
            java.lang.String r7 = "receiver must be a supertype of the return type"
            return r7
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.u.invoke(java.lang.Object):java.lang.Object");
    }
}
