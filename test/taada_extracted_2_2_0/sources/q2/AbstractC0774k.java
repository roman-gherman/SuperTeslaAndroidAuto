package q2;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: q2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0774k extends AbstractC0765b {
    public final DeclarationDescriptor e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SourceElement f4598f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0774k(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, L2.f fVar, SourceElement sourceElement) {
        super(storageManager, fVar);
        if (storageManager == null) {
            c(0);
            throw null;
        }
        if (declarationDescriptor == null) {
            c(1);
            throw null;
        }
        if (fVar == null) {
            c(2);
            throw null;
        }
        if (sourceElement == null) {
            c(3);
            throw null;
        }
        this.e = declarationDescriptor;
        this.f4598f = sourceElement;
    }

    public static /* synthetic */ void c(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.e;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        c(4);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public final SourceElement getSource() {
        SourceElement sourceElement = this.f4598f;
        if (sourceElement != null) {
            return sourceElement;
        }
        c(5);
        throw null;
    }

    public boolean isExternal() {
        return false;
    }
}
