package y2;

import N2.q;
import a3.AbstractC0162z;
import io.ktor.utils.io.Z;
import java.util.List;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import n2.EnumC0709a;
import net.bytebuddy.description.method.MethodDescription;
import q2.C0773j;
import q2.v;
import q2.w;

/* JADX INFO: renamed from: y2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0931a extends C0773j implements JavaCallableMemberDescriptor {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public Boolean f5135F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public Boolean f5136G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0931a(ClassDescriptor classDescriptor, C0931a c0931a, Annotations annotations, boolean z6, EnumC0709a enumC0709a, SourceElement sourceElement) {
        super(classDescriptor, c0931a, annotations, z6, enumC0709a, sourceElement);
        if (classDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations == null) {
            a(1);
            throw null;
        }
        if (enumC0709a == null) {
            a(2);
            throw null;
        }
        if (sourceElement == null) {
            a(3);
            throw null;
        }
        this.f5135F = null;
        this.f5136G = null;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C0931a v(ClassDescriptor classDescriptor, Annotations annotations, boolean z6, JavaSourceElement javaSourceElement) {
        if (classDescriptor == null) {
            a(4);
            throw null;
        }
        if (javaSourceElement != null) {
            return new C0931a(classDescriptor, null, annotations, z6, EnumC0709a.f4226a, javaSourceElement);
        }
        a(6);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public final JavaCallableMemberDescriptor enhance(AbstractC0162z abstractC0162z, List list, AbstractC0162z abstractC0162z2, N1.e eVar) {
        w wVarK = null;
        if (list == null) {
            a(16);
            throw null;
        }
        if (abstractC0162z2 == null) {
            a(17);
            throw null;
        }
        C0931a c0931aW = w(getContainingDeclaration(), null, getKind(), getAnnotations(), getSource());
        if (abstractC0162z != null) {
            Annotations.Companion.getClass();
            wVarK = q.k(c0931aW, abstractC0162z, o2.f.b);
        }
        c0931aW.l(wVarK, this.f4631j, u.f3804a, getTypeParameters(), Z.f(list, getValueParameters(), c0931aW), abstractC0162z2, getModality(), getVisibility());
        if (eVar != null) {
            c0931aW.n((CallableDescriptor.UserDataKey) eVar.f1121a, eVar.b);
        }
        return c0931aW;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final boolean hasSynthesizedParameterNames() {
        return this.f5136G.booleanValue();
    }

    @Override // q2.C0773j, q2.v
    public final /* bridge */ /* synthetic */ v i(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a) {
        return w(declarationDescriptor, functionDescriptor, enumC0709a, annotations, sourceElement);
    }

    @Override // q2.v
    public final void o(boolean z6) {
        this.f5135F = Boolean.valueOf(z6);
    }

    @Override // q2.v
    public final void p(boolean z6) {
        this.f5136G = Boolean.valueOf(z6);
    }

    @Override // q2.C0773j
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ C0773j i(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a) {
        return w(declarationDescriptor, functionDescriptor, enumC0709a, annotations, sourceElement);
    }

    public final C0931a w(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, EnumC0709a enumC0709a, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(7);
            throw null;
        }
        if (enumC0709a == null) {
            a(8);
            throw null;
        }
        if (annotations == null) {
            a(9);
            throw null;
        }
        if (sourceElement == null) {
            a(10);
            throw null;
        }
        if (enumC0709a != EnumC0709a.f4226a && enumC0709a != EnumC0709a.d) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + declarationDescriptor + "\nkind: " + enumC0709a);
        }
        C0931a c0931a = new C0931a((ClassDescriptor) declarationDescriptor, (C0931a) functionDescriptor, annotations, this.E, enumC0709a, sourceElement);
        Boolean bool = this.f5135F;
        bool.getClass();
        c0931a.f5135F = bool;
        Boolean bool2 = this.f5136G;
        bool2.getClass();
        c0931a.f5136G = bool2;
        return c0931a;
    }
}
