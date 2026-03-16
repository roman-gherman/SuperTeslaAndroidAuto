package q2;

import a3.AbstractC0162z;
import a3.Z;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0714f;
import n2.EnumC0709a;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public class L extends v implements SimpleFunctionDescriptor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, L2.f fVar, EnumC0709a enumC0709a, SourceElement sourceElement) {
        super(fVar, declarationDescriptor, simpleFunctionDescriptor, sourceElement, annotations, enumC0709a);
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
        if (sourceElement != null) {
        } else {
            a(4);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 13 || i == 18 || i == 23 || i == 24 || i == 29 || i == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 18 || i == 23 || i == 24 || i == 29 || i == 30) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 27:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 26:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 28:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case 21:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 17:
            case 22:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 14:
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 25:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 13 || i == 18 || i == 23) {
            objArr[1] = "initialize";
        } else if (i == 24) {
            objArr[1] = "getOriginal";
        } else if (i == 29) {
            objArr[1] = "copy";
        } else if (i != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                break;
            case 25:
            case 26:
            case 27:
            case 28:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 13 && i != 18 && i != 23 && i != 24 && i != 29 && i != 30) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static L r(ClassDescriptor classDescriptor, L2.f fVar, EnumC0709a enumC0709a, SourceElement sourceElement) {
        o2.e eVar = o2.f.b;
        if (classDescriptor == null) {
            a(5);
            throw null;
        }
        if (fVar == null) {
            a(7);
            throw null;
        }
        if (sourceElement != null) {
            return new L(classDescriptor, null, eVar, fVar, enumC0709a, sourceElement);
        }
        a(9);
        throw null;
    }

    @Override // q2.v
    public v i(L2.f fVar, DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, SourceElement sourceElement, Annotations annotations, EnumC0709a enumC0709a) {
        if (declarationDescriptor == null) {
            a(25);
            throw null;
        }
        if (enumC0709a == null) {
            a(26);
            throw null;
        }
        if (annotations == null) {
            a(27);
            throw null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (fVar == null) {
            fVar = getName();
        }
        return new L(declarationDescriptor, simpleFunctionDescriptor, annotations, fVar, enumC0709a, sourceElement);
    }

    @Override // q2.v, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor
    public FunctionDescriptor.CopyBuilder newCopyBuilder() {
        return m(Z.b);
    }

    @Override // q2.v, q2.AbstractC0778o, q2.AbstractC0777n, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final SimpleFunctionDescriptor getOriginal() {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) super.getOriginal();
        if (simpleFunctionDescriptor != null) {
            return simpleFunctionDescriptor;
        }
        a(24);
        throw null;
    }

    @Override // q2.v
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final L l(w wVar, ReceiverParameterDescriptor receiverParameterDescriptor, List list, List list2, List list3, AbstractC0162z abstractC0162z, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f) {
        if (list == null) {
            a(14);
            throw null;
        }
        if (list2 == null) {
            a(15);
            throw null;
        }
        if (list3 == null) {
            a(16);
            throw null;
        }
        if (abstractC0714f != null) {
            return u(wVar, receiverParameterDescriptor, list, list2, list3, abstractC0162z, enumC0719k, abstractC0714f, null);
        }
        a(17);
        throw null;
    }

    public L u(w wVar, ReceiverParameterDescriptor receiverParameterDescriptor, List list, List list2, List list3, AbstractC0162z abstractC0162z, EnumC0719k enumC0719k, AbstractC0714f abstractC0714f, Map map) {
        if (list == null) {
            a(19);
            throw null;
        }
        if (list2 == null) {
            a(20);
            throw null;
        }
        if (list3 == null) {
            a(21);
            throw null;
        }
        if (abstractC0714f == null) {
            a(22);
            throw null;
        }
        super.l(wVar, receiverParameterDescriptor, list, list2, list3, abstractC0162z, enumC0719k, abstractC0714f);
        if (map != null && !map.isEmpty()) {
            this.f4628D = new LinkedHashMap(map);
        }
        return this;
    }
}
