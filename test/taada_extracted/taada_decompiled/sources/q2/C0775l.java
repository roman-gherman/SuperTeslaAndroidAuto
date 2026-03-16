package q2;

import a3.C0150m;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.C0712d;
import n2.EnumC0711c;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: q2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0775l extends AbstractC0774k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EnumC0719k f4598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final EnumC0711c f4599h;
    public final C0150m i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MemberScope f4600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set f4601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C0773j f4602l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0775l(DeclarationDescriptor declarationDescriptor, L2.f fVar, EnumC0719k enumC0719k, EnumC0711c enumC0711c, List list, SourceElement sourceElement, Z2.n nVar) {
        super(nVar, declarationDescriptor, fVar, sourceElement);
        if (declarationDescriptor == null) {
            c(0);
            throw null;
        }
        if (fVar == null) {
            c(1);
            throw null;
        }
        if (sourceElement == null) {
            c(5);
            throw null;
        }
        if (nVar == null) {
            c(6);
            throw null;
        }
        this.f4598g = enumC0719k;
        this.f4599h = enumC0711c;
        this.i = new C0150m(this, Collections.EMPTY_LIST, list, nVar);
    }

    public static /* synthetic */ void c(int i) {
        String str;
        int i3;
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
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
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // q2.AbstractC0762A
    public final MemberScope b(b3.d dVar) {
        MemberScope memberScope = this.f4600j;
        if (memberScope != null) {
            return memberScope;
        }
        c(13);
        throw null;
    }

    public final void e(MemberScope memberScope, Set set, C0773j c0773j) {
        this.f4600j = memberScope;
        this.f4601k = set;
        this.f4602l = c0773j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        Annotations.Companion.getClass();
        return o2.f.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getConstructors() {
        Set set = this.f4601k;
        if (set != null) {
            return set;
        }
        c(11);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final List getDeclaredTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        c(18);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final EnumC0711c getKind() {
        EnumC0711c enumC0711c = this.f4599h;
        if (enumC0711c != null) {
            return enumC0711c;
        }
        c(15);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final EnumC0719k getModality() {
        EnumC0719k enumC0719k = this.f4598g;
        if (enumC0719k != null) {
            return enumC0719k;
        }
        c(16);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final Collection getSealedSubclasses() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        c(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final MemberScope getStaticScope() {
        return U2.m.f1338a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        C0150m c0150m = this.i;
        if (c0150m != null) {
            return c0150m;
        }
        c(10);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.f4602l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final n2.z getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final AbstractC0714f getVisibility() {
        C0712d c0712d = AbstractC0713e.e;
        if (c0712d != null) {
            return c0712d;
        }
        c(17);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public final boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public final boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public final boolean isValue() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }
}
