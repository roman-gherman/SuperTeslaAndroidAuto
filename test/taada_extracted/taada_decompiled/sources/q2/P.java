package q2;

import a3.AbstractC0162z;
import a3.d0;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends AbstractC0772i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f4577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4578l;

    /* JADX WARN: Illegal instructions before constructor call */
    public P(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z6, d0 d0Var, L2.f fVar, int i, SourceElement sourceElement, StorageManager storageManager) {
        n2.v vVar = n2.v.b;
        if (declarationDescriptor == null) {
            a(19);
            throw null;
        }
        if (annotations == null) {
            a(20);
            throw null;
        }
        if (d0Var == null) {
            a(21);
            throw null;
        }
        if (fVar == null) {
            a(22);
            throw null;
        }
        if (sourceElement == null) {
            a(23);
            throw null;
        }
        if (storageManager == null) {
            a(25);
            throw null;
        }
        super(storageManager, declarationDescriptor, annotations, fVar, d0Var, z6, i, sourceElement, vVar);
        this.f4577k = new ArrayList(1);
        this.f4578l = false;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static P j(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z6, d0 d0Var, L2.f fVar, int i, SourceElement sourceElement, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(6);
            throw null;
        }
        if (annotations == null) {
            a(7);
            throw null;
        }
        if (d0Var == null) {
            a(8);
            throw null;
        }
        if (fVar == null) {
            a(9);
            throw null;
        }
        if (sourceElement == null) {
            a(10);
            throw null;
        }
        if (storageManager != null) {
            return new P(declarationDescriptor, annotations, z6, d0Var, fVar, i, sourceElement, storageManager);
        }
        a(11);
        throw null;
    }

    public static P k(AbstractC0765b abstractC0765b, d0 d0Var, L2.f fVar, int i, StorageManager storageManager) {
        o2.e eVar = o2.f.b;
        if (abstractC0765b == null) {
            a(0);
            throw null;
        }
        if (storageManager == null) {
            a(4);
            throw null;
        }
        P pJ = j(abstractC0765b, eVar, false, d0Var, fVar, i, SourceElement.NO_SOURCE, storageManager);
        a3.F fN = R2.e.e(abstractC0765b).n();
        if (pJ.f4578l) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + pJ.l());
        }
        if (!kotlin.reflect.l.O(fN)) {
            pJ.f4577k.add(fN);
        }
        if (!pJ.f4578l) {
            pJ.f4578l = true;
            return pJ;
        }
        throw new IllegalStateException("Type parameter descriptor is already initialized: " + pJ.l());
    }

    @Override // q2.AbstractC0772i
    public final void h(AbstractC0162z abstractC0162z) {
        if (abstractC0162z != null) {
            return;
        }
        a(27);
        throw null;
    }

    @Override // q2.AbstractC0772i
    public final List i() {
        if (!this.f4578l) {
            throw new IllegalStateException("Type parameter descriptor is not initialized: " + l());
        }
        ArrayList arrayList = this.f4577k;
        if (arrayList != null) {
            return arrayList;
        }
        a(28);
        throw null;
    }

    public final String l() {
        return getName() + " declared in " + N2.f.g(getContainingDeclaration());
    }
}
