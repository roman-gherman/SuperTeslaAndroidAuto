package a3;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: renamed from: a3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0139b extends AbstractC0147j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0139b(StorageManager storageManager) {
        super(storageManager);
        if (storageManager != null) {
        } else {
            i(0);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void i(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto Lc
            if (r9 == r1) goto Lc
            if (r9 == r0) goto Lc
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        Le:
            r4 = 2
            if (r9 == r2) goto L17
            if (r9 == r1) goto L17
            if (r9 == r0) goto L17
            r5 = r1
            goto L18
        L17:
            r5 = r4
        L18:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L2f
            if (r9 == r4) goto L2a
            if (r9 == r1) goto L2f
            if (r9 == r0) goto L2f
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L31
        L2a:
            java.lang.String r8 = "classifier"
            r5[r7] = r8
            goto L31
        L2f:
            r5[r7] = r6
        L31:
            if (r9 == r2) goto L3f
            if (r9 == r1) goto L3a
            if (r9 == r0) goto L3a
            r5[r2] = r6
            goto L43
        L3a:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L43
        L3f:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L43:
            if (r9 == r2) goto L54
            if (r9 == r4) goto L50
            if (r9 == r1) goto L54
            if (r9 == r0) goto L54
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L54
        L50:
            java.lang.String r6 = "isSameClassifier"
            r5[r4] = r6
        L54:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L64
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.AbstractC0139b.i(int):void");
    }

    @Override // a3.AbstractC0147j
    public final AbstractC0162z b() {
        ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            k2.i.a(107);
            throw null;
        }
        L2.f fVar = k2.i.f3710f;
        if (k2.i.b(declarationDescriptor, k2.o.f3743a) || k2.i.b(declarationDescriptor, k2.o.b)) {
            return null;
        }
        return getBuiltIns().e();
    }

    @Override // a3.AbstractC0147j
    public final Collection c() {
        DeclarationDescriptor containingDeclaration = getDeclarationDescriptor().getContainingDeclaration();
        if (containingDeclaration instanceof ClassDescriptor) {
            j3.j jVar = new j3.j();
            ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
            jVar.add(classDescriptor.getDefaultType());
            classDescriptor.getCompanionObjectDescriptor();
            return jVar;
        }
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        i(3);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072 A[RETURN] */
    @Override // a3.AbstractC0147j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            r1 = 0
            if (r0 == 0) goto L73
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r5.getDeclarationDescriptor()
            java.lang.String r2 = "first"
            kotlin.jvm.internal.h.f(r0, r2)
            L2.f r2 = r0.getName()
            L2.f r3 = r6.getName()
            boolean r2 = kotlin.jvm.internal.h.a(r2, r3)
            r3 = 1
            if (r2 != 0) goto L1f
        L1d:
            r6 = r1
            goto L70
        L1f:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r0.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r6.getContainingDeclaration()
        L27:
            if (r0 == 0) goto L51
            if (r6 == 0) goto L51
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
            if (r2 == 0) goto L32
            boolean r6 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
            goto L70
        L32:
            boolean r2 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
            if (r2 == 0) goto L37
            goto L1d
        L37:
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r2 == 0) goto L53
            boolean r2 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r2 == 0) goto L1d
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r0
            L2.c r0 = r0.getFqName()
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r6
            L2.c r6 = r6.getFqName()
            boolean r6 = kotlin.jvm.internal.h.a(r0, r6)
            if (r6 == 0) goto L1d
        L51:
            r6 = r3
            goto L70
        L53:
            boolean r2 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r2 == 0) goto L58
            goto L1d
        L58:
            L2.f r2 = r0.getName()
            L2.f r4 = r6.getName()
            boolean r2 = kotlin.jvm.internal.h.a(r2, r4)
            if (r2 != 0) goto L67
            goto L1d
        L67:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r0.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r6.getContainingDeclaration()
            goto L27
        L70:
            if (r6 == 0) goto L73
            return r3
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.AbstractC0139b.f(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor):boolean");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final k2.i getBuiltIns() {
        k2.i iVarE = R2.e.e(getDeclarationDescriptor());
        if (iVarE != null) {
            return iVarE;
        }
        i(1);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public abstract ClassDescriptor getDeclarationDescriptor();
}
