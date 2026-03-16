package q2;

import a3.W;
import a3.Z;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: q2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0765b extends AbstractC0762A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.f f4590a;
    public final NotNullLazyValue b;
    public final NotNullLazyValue c;
    public final NotNullLazyValue d;

    public AbstractC0765b(StorageManager storageManager, L2.f fVar) {
        if (storageManager == null) {
            c(0);
            throw null;
        }
        if (fVar == null) {
            c(1);
            throw null;
        }
        this.f4590a = fVar;
        this.b = storageManager.createLazyValue(new C0764a(this, 0));
        this.c = storageManager.createLazyValue(new C0764a(this, 1));
        this.d = storageManager.createLazyValue(new C0764a(this, 2));
    }

    public static /* synthetic */ void c(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14 || i == 16 || i == 17 || i == 19 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14 || i == 16 || i == 17 || i == 19 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i == 9 || i == 12 || i == 14 || i == 16) {
            objArr[1] = "getMemberScope";
        } else if (i == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 19) {
            objArr[1] = "substitute";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 9 && i != 12 && i != 14 && i != 16 && i != 17 && i != 19 && i != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // q2.AbstractC0762A
    public MemberScope a(W w5, b3.d dVar) {
        if (w5 == null) {
            c(10);
            throw null;
        }
        if (!w5.e()) {
            return new U2.q(b(dVar), Z.e(w5));
        }
        MemberScope memberScopeB = b(dVar);
        if (memberScopeB != null) {
            return memberScopeB;
        }
        c(12);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final Object accept(DeclarationDescriptorVisitor declarationDescriptorVisitor, Object obj) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ClassDescriptor substitute(Z z6) {
        if (z6 != null) {
            return z6.f1542a.e() ? this : new z(this, z6);
        }
        c(18);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List getContextReceivers() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        c(6);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final a3.F getDefaultType() {
        a3.F f6 = (a3.F) this.b.invoke();
        if (f6 != null) {
            return f6;
        }
        c(20);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getMemberScope(W w5) {
        if (w5 == null) {
            c(15);
            throw null;
        }
        R2.e.i(N2.f.d(this));
        MemberScope memberScopeA = a(w5, b3.c.f1699a);
        if (memberScopeA != null) {
            return memberScopeA;
        }
        c(16);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public final L2.f getName() {
        L2.f fVar = this.f4590a;
        if (fVar != null) {
            return fVar;
        }
        c(2);
        throw null;
    }

    @Override // q2.AbstractC0762A, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ClassifierDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor) this.d.invoke();
        if (receiverParameterDescriptor != null) {
            return receiverParameterDescriptor;
        }
        c(5);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope memberScope = (MemberScope) this.c.invoke();
        if (memberScope != null) {
            return memberScope;
        }
        c(4);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedMemberScope() {
        R2.e.i(N2.f.d(this));
        MemberScope memberScopeB = b(b3.c.f1699a);
        if (memberScopeB != null) {
            return memberScopeB;
        }
        c(17);
        throw null;
    }

    @Override // q2.AbstractC0762A, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final DeclarationDescriptor getOriginal() {
        return this;
    }

    @Override // q2.AbstractC0762A, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public final ClassDescriptor getOriginal() {
        return this;
    }
}
