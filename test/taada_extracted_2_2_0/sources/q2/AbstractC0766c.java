package q2;

import a3.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: q2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0766c extends AbstractC0772i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0766c(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Annotations annotations, L2.f fVar, d0 d0Var, boolean z6, int i, SourceElement sourceElement, n2.v vVar) {
        super(storageManager, declarationDescriptor, annotations, fVar, d0Var, z6, i, sourceElement, vVar);
        if (storageManager == null) {
            a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
            a(1);
            throw null;
        }
        if (fVar == null) {
            a(3);
            throw null;
        }
        if (sourceElement == null) {
            a(5);
            throw null;
        }
        if (vVar != null) {
        } else {
            a(6);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // q2.AbstractC0777n
    public final String toString() {
        String str = "";
        String str2 = this.f4594f ? "reified " : "";
        if (getVariance() != d0.INVARIANT) {
            str = getVariance() + " ";
        }
        return str2 + str + getName();
    }
}
