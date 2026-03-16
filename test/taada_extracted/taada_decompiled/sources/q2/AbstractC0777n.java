package q2;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import net.bytebuddy.description.method.MethodDescription;
import o2.AbstractC0737a;

/* JADX INFO: renamed from: q2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0777n extends AbstractC0737a implements DeclarationDescriptor {
    public final L2.f b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0777n(Annotations annotations, L2.f fVar) {
        super(annotations);
        if (annotations == null) {
            a(0);
            throw null;
        }
        if (fVar == null) {
            a(1);
            throw null;
        }
        this.b = fVar;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (i != 5 && i != 6) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static String e(DeclarationDescriptor declarationDescriptor) {
        try {
            String str = M2.n.c.k(declarationDescriptor) + "[" + declarationDescriptor.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(declarationDescriptor)) + "]";
            if (str != null) {
                return str;
            }
            a(5);
            throw null;
        } catch (Throwable unused) {
            String str2 = declarationDescriptor.getClass().getSimpleName() + " " + declarationDescriptor.getName();
            if (str2 != null) {
                return str2;
            }
            a(6);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public final L2.f getName() {
        L2.f fVar = this.b;
        if (fVar != null) {
            return fVar;
        }
        a(2);
        throw null;
    }

    public DeclarationDescriptor getOriginal() {
        return this;
    }

    public String toString() {
        return e(this);
    }
}
