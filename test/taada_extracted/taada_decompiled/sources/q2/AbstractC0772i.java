package q2;

import a3.AbstractC0162z;
import a3.d0;
import java.util.List;
import k2.C0588g;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: q2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0772i extends AbstractC0778o implements TypeParameterDescriptor {
    public final d0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NotNullLazyValue f4595h;
    public final NotNullLazyValue i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StorageManager f4596j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0772i(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Annotations annotations, L2.f fVar, d0 d0Var, boolean z6, int i, SourceElement sourceElement, n2.v vVar) {
        super(declarationDescriptor, annotations, fVar, sourceElement);
        if (storageManager == null) {
            a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
            a(1);
            throw null;
        }
        if (annotations == null) {
            a(2);
            throw null;
        }
        if (fVar == null) {
            a(3);
            throw null;
        }
        if (d0Var == null) {
            a(4);
            throw null;
        }
        if (sourceElement == null) {
            a(5);
            throw null;
        }
        if (vVar == null) {
            a(6);
            throw null;
        }
        this.e = d0Var;
        this.f4593f = z6;
        this.f4594g = i;
        this.f4595h = storageManager.createLazyValue(new C0769f(this, storageManager, vVar));
        this.i = storageManager.createLazyValue(new C0588g(1, this, fVar));
        this.f4596j = storageManager;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i3;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i3 = 2;
                break;
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
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
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return declarationDescriptorVisitor.visitTypeParameterDescriptor(this, obj);
    }

    @Override // q2.AbstractC0778o
    /* JADX INFO: renamed from: f */
    public final DeclarationDescriptorWithSource getOriginal() {
        return this;
    }

    public List g(List list) {
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final a3.F getDefaultType() {
        a3.F f6 = (a3.F) this.i.invoke();
        if (f6 != null) {
            return f6;
        }
        a(10);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final int getIndex() {
        return this.f4594g;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ClassifierDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final StorageManager getStorageManager() {
        StorageManager storageManager = this.f4596j;
        if (storageManager != null) {
            return storageManager;
        }
        a(14);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = (TypeConstructor) this.f4595h.invoke();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        a(9);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final List getUpperBounds() {
        List supertypes = ((C0771h) getTypeConstructor()).getSupertypes();
        if (supertypes != null) {
            return supertypes;
        }
        a(8);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final d0 getVariance() {
        d0 d0Var = this.e;
        if (d0Var != null) {
            return d0Var;
        }
        a(7);
        throw null;
    }

    public abstract void h(AbstractC0162z abstractC0162z);

    public abstract List i();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public final boolean isReified() {
        return this.f4593f;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getOriginal() {
        return this;
    }

    @Override // q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final TypeParameterDescriptor getOriginal() {
        return this;
    }
}
