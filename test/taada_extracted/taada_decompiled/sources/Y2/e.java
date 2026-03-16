package y2;

import N2.q;
import a3.AbstractC0162z;
import g3.C0488e;
import g3.j;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.text.g;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;
import q2.C0783u;
import q2.L;
import q2.v;
import q2.w;
import z2.C0944d;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends L implements JavaCallableMemberDescriptor {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final C0933c f5138G = new C0933c();
    public static final C0934d H = new C0934d();
    public int E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final boolean f5139F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, L2.f fVar, EnumC0709a enumC0709a, SourceElement sourceElement, boolean z6) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations, fVar, enumC0709a, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations == null) {
            a(1);
            throw null;
        }
        if (fVar == null) {
            a(2);
            throw null;
        }
        if (enumC0709a == null) {
            a(3);
            throw null;
        }
        if (sourceElement == null) {
            a(4);
            throw null;
        }
        this.E = 0;
        this.f5139F = z6;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 13 || i == 18 || i == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 18 || i == 21) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 13) {
            objArr[1] = "initialize";
        } else if (i == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 21:
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 13 && i != 18 && i != 21) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static e v(DeclarationDescriptor declarationDescriptor, C0944d c0944d, L2.f fVar, JavaSourceElement javaSourceElement, boolean z6) {
        if (declarationDescriptor == null) {
            a(5);
            throw null;
        }
        if (fVar == null) {
            a(7);
            throw null;
        }
        if (javaSourceElement != null) {
            return new e(declarationDescriptor, null, c0944d, fVar, EnumC0709a.f4226a, javaSourceElement, z6);
        }
        a(8);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public final JavaCallableMemberDescriptor enhance(AbstractC0162z abstractC0162z, List list, AbstractC0162z abstractC0162z2, N1.e eVar) {
        w wVarK;
        if (list == null) {
            a(19);
            throw null;
        }
        if (abstractC0162z2 == null) {
            a(20);
            throw null;
        }
        ArrayList arrayListF = Z.f(list, getValueParameters(), this);
        if (abstractC0162z == null) {
            wVarK = null;
        } else {
            Annotations.Companion.getClass();
            wVarK = q.k(this, abstractC0162z, o2.f.b);
        }
        C0783u c0783uM = m(a3.Z.b);
        c0783uM.f4611g = arrayListF;
        c0783uM.f4614k = abstractC0162z2;
        c0783uM.i = wVarK;
        c0783uM.f4619p = true;
        c0783uM.f4618o = true;
        e eVar2 = (e) c0783uM.x.j(c0783uM);
        if (eVar != null) {
            eVar2.n((CallableDescriptor.UserDataKey) eVar.f1121a, eVar.b);
        }
        if (eVar2 != null) {
            return eVar2;
        }
        a(21);
        throw null;
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public final boolean hasSynthesizedParameterNames() {
        return com.google.protobuf.a.c(this.E);
    }

    @Override // q2.L, q2.v
    public final v i(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a) {
        if (declarationDescriptor == null) {
            a(14);
            throw null;
        }
        if (enumC0709a == null) {
            a(15);
            throw null;
        }
        if (annotations == null) {
            a(16);
            throw null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (fVar == null) {
            fVar = getName();
        }
        e eVar = new e(declarationDescriptor, simpleFunctionDescriptor, annotations, fVar, enumC0709a, sourceElement, this.f5139F);
        int i = this.E;
        boolean z6 = false;
        if (i != 1) {
            if (i == 2) {
                z6 = true;
            } else if (i != 3) {
                if (i != 4) {
                    throw null;
                }
                z6 = true;
            }
        }
        eVar.w(z6, com.google.protobuf.a.c(i));
        return eVar;
    }

    @Override // q2.L
    public final L u(w wVar, ReceiverParameterDescriptor receiverParameterDescriptor, List list, List list2, List list3, AbstractC0162z abstractC0162z, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, Map map) {
        C0488e c0488e;
        if (list == null) {
            a(9);
            throw null;
        }
        if (list2 == null) {
            a(10);
            throw null;
        }
        if (list3 == null) {
            a(11);
            throw null;
        }
        if (abstractC0714f == null) {
            a(12);
            throw null;
        }
        super.u(wVar, receiverParameterDescriptor, list, list2, list3, abstractC0162z, enumC0719k, abstractC0714f, map);
        for (j jVar : g3.v.b) {
            jVar.getClass();
            L2.f fVar = jVar.f3313a;
            if (fVar == null || h.a(getName(), fVar)) {
                g gVar = jVar.b;
                if (gVar != null) {
                    String strB = getName().b();
                    h.e(strB, "functionDescriptor.name.asString()");
                    if (!gVar.f3947a.matcher(strB).matches()) {
                        continue;
                    }
                }
                Collection collection = jVar.c;
                if (collection == null || collection.contains(getName())) {
                    Check[] checkArr = jVar.e;
                    int length = checkArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            c0488e = ((String) jVar.d.invoke(this)) != null ? new C0488e(false) : C0488e.c;
                        } else {
                            if (checkArr[i].invoke(this) != null) {
                                c0488e = new C0488e(false);
                                break;
                            }
                            i++;
                        }
                    }
                    this.f4634m = c0488e.f3309a;
                    return this;
                }
            }
        }
        c0488e = C0488e.b;
        this.f4634m = c0488e.f3309a;
        return this;
    }

    public final void w(boolean z6, boolean z7) {
        this.E = z6 ? z7 ? 4 : 2 : z7 ? 3 : 1;
    }
}
