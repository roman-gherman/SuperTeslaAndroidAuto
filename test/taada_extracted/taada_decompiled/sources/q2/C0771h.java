package q2;

import a3.AbstractC0147j;
import a3.AbstractC0162z;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: q2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0771h extends AbstractC0147j {
    public final n2.v c;
    public final /* synthetic */ AbstractC0772i d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0771h(AbstractC0772i abstractC0772i, StorageManager storageManager, n2.v vVar) {
        super(storageManager);
        if (storageManager == null) {
            i(0);
            throw null;
        }
        this.d = abstractC0772i;
        this.c = vVar;
    }

    public static /* synthetic */ void i(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                break;
            case 6:
                objArr[0] = "type";
                break;
            case 7:
                objArr[0] = "supertypes";
                break;
            case 9:
                objArr[0] = "classifier";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 1) {
            objArr[1] = "computeSupertypes";
        } else if (i == 2) {
            objArr[1] = "getParameters";
        } else if (i == 3) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 4) {
            objArr[1] = "getBuiltIns";
        } else if (i == 5) {
            objArr[1] = "getSupertypeLoopChecker";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        } else {
            objArr[1] = "processSupertypesWithoutCycles";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
                break;
            case 6:
                objArr[2] = "reportSupertypeLoopError";
                break;
            case 7:
                objArr[2] = "processSupertypesWithoutCycles";
                break;
            case 9:
                objArr[2] = "isSameClassifier";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // a3.AbstractC0147j
    public final Collection a() {
        List listI = this.d.i();
        if (listI != null) {
            return listI;
        }
        i(1);
        throw null;
    }

    @Override // a3.AbstractC0147j
    public final AbstractC0162z b() {
        return c3.j.c(c3.i.CYCLIC_UPPER_BOUNDS, new String[0]);
    }

    @Override // a3.AbstractC0147j
    public final SupertypeLoopChecker d() {
        n2.v vVar = this.c;
        if (vVar != null) {
            return vVar;
        }
        i(5);
        throw null;
    }

    @Override // a3.AbstractC0147j
    public final boolean f(ClassifierDescriptor classifierDescriptor) {
        if (!(classifierDescriptor instanceof TypeParameterDescriptor)) {
            return false;
        }
        AbstractC0772i a6 = this.d;
        kotlin.jvm.internal.h.f(a6, "a");
        return N2.d.f1134a.b(a6, (TypeParameterDescriptor) classifierDescriptor, true, N2.c.f1133a);
    }

    @Override // a3.AbstractC0147j
    public final List g(List list) {
        List listG = this.d.g(list);
        if (listG != null) {
            return listG;
        }
        i(8);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final k2.i getBuiltIns() {
        k2.i iVarE = R2.e.e(this.d);
        if (iVarE != null) {
            return iVarE;
        }
        i(4);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        AbstractC0772i abstractC0772i = this.d;
        if (abstractC0772i != null) {
            return abstractC0772i;
        }
        i(3);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        i(2);
        throw null;
    }

    @Override // a3.AbstractC0147j
    public final void h(AbstractC0162z abstractC0162z) {
        if (abstractC0162z != null) {
            this.d.h(abstractC0162z);
        } else {
            i(6);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return true;
    }

    public final String toString() {
        return this.d.getName().f962a;
    }
}
