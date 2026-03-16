package y2;

import D2.x;
import N2.q;
import a3.AbstractC0162z;
import a3.b0;
import java.util.List;
import k2.i;
import k2.t;
import kotlin.collections.u;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;
import o2.g;
import q2.I;
import q2.J;
import q2.K;
import q2.w;
import w2.D;
import z2.C0944d;

/* JADX INFO: loaded from: classes2.dex */
public class f extends I implements JavaCallableMemberDescriptor {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final boolean f5141A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final N1.e f5142B;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(DeclarationDescriptor declarationDescriptor, Annotations annotations, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, boolean z6, L2.f fVar, SourceElement sourceElement, PropertyDescriptor propertyDescriptor, EnumC0709a enumC0709a, boolean z7, N1.e eVar) {
        super(declarationDescriptor, propertyDescriptor, annotations, enumC0719k, abstractC0714f, z6, fVar, enumC0709a, sourceElement, false, false, false, false, false);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations == null) {
            a(1);
            throw null;
        }
        if (enumC0719k == null) {
            a(2);
            throw null;
        }
        if (abstractC0714f == null) {
            a(3);
            throw null;
        }
        if (fVar == null) {
            a(4);
            throw null;
        }
        if (sourceElement == null) {
            a(5);
            throw null;
        }
        if (enumC0709a == null) {
            a(6);
            throw null;
        }
        this.f5141A = z7;
        this.f5142B = eVar;
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 21 ? 3 : 2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 21) {
            throw new IllegalStateException(str2);
        }
    }

    public static f n(DeclarationDescriptor declarationDescriptor, C0944d c0944d, AbstractC0714f abstractC0714f, boolean z6, L2.f fVar, JavaSourceElement javaSourceElement, boolean z7) {
        EnumC0719k enumC0719k = EnumC0719k.f4248a;
        if (declarationDescriptor == null) {
            a(7);
            throw null;
        }
        if (fVar == null) {
            a(11);
            throw null;
        }
        if (javaSourceElement != null) {
            return new f(declarationDescriptor, c0944d, enumC0719k, abstractC0714f, z6, fVar, javaSourceElement, null, EnumC0709a.f4227a, z7, null);
        }
        a(12);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.i] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public final JavaCallableMemberDescriptor enhance(AbstractC0162z abstractC0162z, List list, AbstractC0162z abstractC0162z2, N1.e eVar) {
        J j6;
        K k6;
        w wVarK = null;
        if (list == null) {
            a(19);
            throw null;
        }
        if (abstractC0162z2 == null) {
            a(20);
            throw null;
        }
        PropertyDescriptor original = getOriginal() == this ? null : getOriginal();
        f fVar = new f(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), this.f4586f, getName(), getSource(), original, getKind(), this.f5141A, eVar);
        J j7 = this.f4569w;
        if (j7 != null) {
            J j8 = new J(fVar, j7.getAnnotations(), j7.getModality(), j7.getVisibility(), j7.e, j7.f4546f, j7.i, getKind(), original == null ? null : original.getGetter(), j7.getSource());
            j8.f4551l = j7.f4551l;
            j8.f4571m = abstractC0162z2;
            j6 = j8;
        } else {
            j6 = null;
        }
        K k7 = this.x;
        if (k7 != null) {
            k6 = new K(fVar, k7.getAnnotations(), k7.getModality(), k7.getVisibility(), k7.e, k7.f4546f, k7.i, getKind(), original == null ? null : original.getSetter(), k7.getSource());
            k6.f4551l = k6.f4551l;
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) k7.getValueParameters().get(0);
            if (valueParameterDescriptor == null) {
                K.a(6);
                throw null;
            }
            k6.f4573m = valueParameterDescriptor;
        } else {
            k6 = null;
        }
        fVar.k(j6, k6, this.y, this.f4570z);
        ?? r42 = this.f4588h;
        if (r42 != 0) {
            fVar.g(this.f4587g, r42);
        }
        fVar.setOverriddenDescriptors(getOverriddenDescriptors());
        if (abstractC0162z != null) {
            Annotations.Companion.getClass();
            wVarK = q.k(this, abstractC0162z, o2.f.b);
        }
        fVar.m(abstractC0162z2, getTypeParameters(), this.f4567t, wVarK, u.f3805a);
        return fVar;
    }

    @Override // q2.I, q2.T, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final Object getUserData(CallableDescriptor.UserDataKey userDataKey) {
        N1.e eVar = this.f5142B;
        if (eVar == null || !((CallableDescriptor.UserDataKey) eVar.f1121a).equals(userDataKey)) {
            return null;
        }
        return eVar.b;
    }

    @Override // q2.T, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // q2.I, q2.T, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final boolean isConst() {
        AbstractC0162z type = getType();
        if (!this.f5141A) {
            return false;
        }
        h.f(type, "type");
        if (((!i.F(type) && !t.a(type)) || b0.f(type)) && !i.G(type)) {
            return false;
        }
        g gVar = x.f268a;
        L2.c ENHANCED_NULLABILITY_ANNOTATION = D.f4974p;
        h.e(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return !b3.e.G(type, ENHANCED_NULLABILITY_ANNOTATION) || i.G(type);
    }

    @Override // q2.I
    public final I j(DeclarationDescriptor declarationDescriptor, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, PropertyDescriptor propertyDescriptor, EnumC0709a enumC0709a, L2.f fVar, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(13);
            throw null;
        }
        if (enumC0719k == null) {
            a(14);
            throw null;
        }
        if (abstractC0714f == null) {
            a(15);
            throw null;
        }
        if (enumC0709a == null) {
            a(16);
            throw null;
        }
        if (fVar == null) {
            a(17);
            throw null;
        }
        return new f(declarationDescriptor, getAnnotations(), enumC0719k, abstractC0714f, this.f4586f, fVar, sourceElement, propertyDescriptor, enumC0709a, this.f5141A, this.f5142B);
    }

    @Override // q2.I
    public final void l(AbstractC0162z abstractC0162z) {
    }
}
