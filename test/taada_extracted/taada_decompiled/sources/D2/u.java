package D2;

import A2.C0019a;
import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.F;
import a3.b0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import w2.C0870d;
import w2.EnumC0868b;
import w2.z;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DeclarationDescriptorNonRoot f265a;
    public final boolean b;
    public final C0946f c;
    public final EnumC0868b d;
    public final boolean e;

    public u(DeclarationDescriptorNonRoot declarationDescriptorNonRoot, boolean z6, C0946f containerContext, EnumC0868b enumC0868b, boolean z7) {
        kotlin.jvm.internal.h.f(containerContext, "containerContext");
        this.f265a = declarationDescriptorNonRoot;
        this.b = z6;
        this.c = containerContext;
        this.d = enumC0868b;
        this.e = z7;
    }

    public static void a(Object obj, ArrayList arrayList, C0019a c0019a) {
        arrayList.add(obj);
        Iterable iterable = (Iterable) c0019a.invoke(obj);
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next(), arrayList, c0019a);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Iterable, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static D2.i c(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.h.f(r4, r0)
            boolean r1 = r4 instanceof A2.P
            if (r1 != 0) goto Lb
            goto Lbf
        Lb:
            java.util.List r4 = b3.e.D(r4)
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L17
            goto Lbf
        L17:
            java.util.Iterator r1 = r4.iterator()
        L1b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lbf
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r2
            boolean r2 = b3.e.N(r2)
            if (r2 != 0) goto L1b
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L34
            goto L4c
        L34:
            java.util.Iterator r1 = r4.iterator()
        L38:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L4c
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r2
            D2.h r2 = e(r2)
            if (r2 == 0) goto L38
            r1 = r4
            goto L92
        L4c:
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L53
            goto Lbf
        L53:
            java.util.Iterator r1 = r4.iterator()
        L57:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lbf
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r2
            kotlin.jvm.internal.h.f(r2, r0)
            a3.z r2 = (a3.AbstractC0162z) r2
            a3.z r2 = kotlin.reflect.l.z(r2)
            if (r2 == 0) goto L57
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r4.iterator()
        L77:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L92
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            kotlin.jvm.internal.h.f(r3, r0)
            a3.z r3 = (a3.AbstractC0162z) r3
            a3.z r3 = kotlin.reflect.l.z(r3)
            if (r3 == 0) goto L77
            r1.add(r3)
            goto L77
        L92:
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L99
            goto Lb2
        L99:
            java.util.Iterator r0 = r1.iterator()
        L9d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lb2
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r2
            boolean r2 = b3.e.T(r2)
            if (r2 != 0) goto L9d
            D2.h r0 = D2.h.c
            goto Lb4
        Lb2:
            D2.h r0 = D2.h.b
        Lb4:
            D2.i r2 = new D2.i
            if (r1 == r4) goto Lba
            r4 = 1
            goto Lbb
        Lba:
            r4 = 0
        Lbb:
            r2.<init>(r0, r4)
            return r2
        Lbf:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: D2.u.c(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker):D2.i");
    }

    public static L2.e d(F f6) {
        c3.g gVar = b0.f1543a;
        ClassifierDescriptor declarationDescriptor = f6.c().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor != null) {
            return N2.f.g(classDescriptor);
        }
        return null;
    }

    public static h e(KotlinTypeMarker kotlinTypeMarker) {
        F fJ;
        F fJ2;
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        AbstractC0155s abstractC0155sH = b3.e.h(kotlinTypeMarker);
        if (abstractC0155sH == null || (fJ = b3.e.b0(abstractC0155sH)) == null) {
            fJ = b3.e.j(kotlinTypeMarker);
            kotlin.jvm.internal.h.c(fJ);
        }
        if (b3.e.R(fJ)) {
            return h.b;
        }
        AbstractC0155s abstractC0155sH2 = b3.e.h(kotlinTypeMarker);
        if (abstractC0155sH2 == null || (fJ2 = b3.e.m0(abstractC0155sH2)) == null) {
            fJ2 = b3.e.j(kotlinTypeMarker);
            kotlin.jvm.internal.h.c(fJ2);
        }
        if (b3.e.R(fJ2)) {
            return null;
        }
        return h.c;
    }

    public final C0870d b() {
        return this.c.f5203a.q;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.Lazy] */
    public final ArrayList f(KotlinTypeMarker kotlinTypeMarker) {
        z zVar = (z) this.c.d.getValue();
        C0870d c0870dB = b();
        kotlin.jvm.internal.h.f(kotlinTypeMarker, "<this>");
        a aVar = new a(kotlinTypeMarker, c0870dB.b(zVar, ((AbstractC0162z) kotlinTypeMarker).getAnnotations()), null);
        C0019a c0019a = new C0019a(this, 3);
        ArrayList arrayList = new ArrayList(1);
        a(aVar, arrayList, c0019a);
        return arrayList;
    }
}
