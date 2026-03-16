package q2;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends AbstractC0767d {
    public final /* synthetic */ int c = 0;
    public final DeclarationDescriptor d;
    public final ReceiverValue e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(ClassDescriptor classDescriptor) {
        super(o2.f.b, L2.h.d);
        if (classDescriptor == null) {
            a(0);
            throw null;
        }
        Annotations.Companion.getClass();
        this.d = classDescriptor;
        this.e = new V2.d(classDescriptor);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static /* synthetic */ void f(int i) {
        String str = (i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "value";
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = "name";
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i == 7) {
            objArr[1] = "getValue";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = "copy";
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getContainingDeclaration() {
        switch (this.c) {
            case 0:
                ClassDescriptor classDescriptor = (ClassDescriptor) this.d;
                if (classDescriptor != null) {
                    return classDescriptor;
                }
                a(2);
                throw null;
            default:
                DeclarationDescriptor declarationDescriptor = this.d;
                if (declarationDescriptor != null) {
                    return declarationDescriptor;
                }
                f(8);
                throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public final ReceiverValue getValue() {
        switch (this.c) {
            case 0:
                V2.d dVar = (V2.d) this.e;
                if (dVar != null) {
                    return dVar;
                }
                a(1);
                throw null;
            default:
                V2.a aVar = (V2.a) this.e;
                if (aVar != null) {
                    return aVar;
                }
                f(7);
                throw null;
        }
    }

    @Override // q2.AbstractC0777n
    public String toString() {
        switch (this.c) {
            case 0:
                return "class " + ((ClassDescriptor) this.d).getName() + "::this";
            default:
                return super.toString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(DeclarationDescriptor declarationDescriptor, V2.a aVar, Annotations annotations) {
        this(declarationDescriptor, aVar, annotations, L2.h.d);
        if (declarationDescriptor == null) {
            f(0);
            throw null;
        }
        if (annotations != null) {
        } else {
            f(2);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(DeclarationDescriptor declarationDescriptor, V2.a aVar, Annotations annotations, L2.f fVar) {
        super(annotations, fVar);
        if (declarationDescriptor == null) {
            f(3);
            throw null;
        }
        if (annotations == null) {
            f(5);
            throw null;
        }
        if (fVar != null) {
            this.d = declarationDescriptor;
            this.e = aVar;
            return;
        }
        f(6);
        throw null;
    }
}
