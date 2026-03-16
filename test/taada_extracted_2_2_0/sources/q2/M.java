package q2;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends U2.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ModuleDescriptor f4575a;
    public final L2.c b;

    public M(ModuleDescriptor moduleDescriptor, L2.c fqName) {
        kotlin.jvm.internal.h.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        this.f4575a = moduleDescriptor;
        this.b = fqName;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        return kotlin.collections.w.f3807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
    
        if (r7.f1332a.contains(U2.c.f1318a) != false) goto L9;
     */
    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection getContributedDescriptors(U2.f r7, kotlin.jvm.functions.Function1 r8) {
        /*
            r6 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.h.f(r7, r0)
            java.lang.String r0 = "nameFilter"
            kotlin.jvm.internal.h.f(r8, r0)
            int r0 = U2.f.f1322h
            boolean r0 = r7.a(r0)
            kotlin.collections.u r1 = kotlin.collections.u.f3805a
            if (r0 != 0) goto L15
            goto L27
        L15:
            L2.c r0 = r6.b
            boolean r2 = r0.d()
            if (r2 == 0) goto L28
            U2.c r2 = U2.c.f1318a
            java.util.List r7 = r7.f1332a
            boolean r7 = r7.contains(r2)
            if (r7 == 0) goto L28
        L27:
            return r1
        L28:
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r7 = r6.f4575a
            java.util.Collection r1 = r7.getSubPackagesOf(r0, r8)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L3b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L78
            java.lang.Object r3 = r1.next()
            L2.c r3 = (L2.c) r3
            L2.f r3 = r3.f()
            java.lang.String r4 = "subFqName.shortName()"
            kotlin.jvm.internal.h.e(r3, r4)
            java.lang.Object r4 = r8.invoke(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L3b
            boolean r4 = r3.b
            r5 = 0
            if (r4 == 0) goto L62
            goto L72
        L62:
            L2.c r3 = r0.c(r3)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r3 = r7.getPackage(r3)
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L71
            goto L72
        L71:
            r5 = r3
        L72:
            if (r5 == 0) goto L3b
            r2.add(r5)
            goto L3b
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.M.getContributedDescriptors(U2.f, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    public final String toString() {
        return "subpackages of " + this.b + " from " + this.f4575a;
    }
}
