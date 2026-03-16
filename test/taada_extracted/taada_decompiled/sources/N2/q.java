package N2;

import A2.C0019a;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import a3.C;
import a3.F;
import a3.M;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import n2.AbstractC0718j;
import n2.C0712d;
import n2.C0720l;
import n2.EnumC0709a;
import n2.EnumC0711c;
import n2.EnumC0719k;
import q2.AbstractC0765b;
import q2.I;
import q2.J;
import q2.K;
import q2.L;
import q2.S;
import q2.w;
import v2.EnumC0851b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0720l f1144a = new C0720l("ResolutionAnchorProvider");

    public static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 23 || i == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 23 || i == 25) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 31:
            case 33:
            case 35:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
            case 26:
                objArr[0] = "enumClass";
                break;
            case 27:
            case 28:
            case 29:
                objArr[0] = "descriptor";
                break;
            case 30:
            case 32:
            case 34:
                objArr[0] = "owner";
                break;
        }
        if (i == 12) {
            objArr[1] = "createSetter";
        } else if (i == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "createEnumEntriesProperty";
                break;
            case 27:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 28:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 29:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 30:
            case 31:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 32:
            case 33:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case 34:
            case 35:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 23 && i != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static final void c(ClassDescriptor classDescriptor, LinkedHashSet linkedHashSet, MemberScope memberScope, boolean z6) {
        for (DeclarationDescriptor declarationDescriptor : AbstractC0132a.y(memberScope, U2.f.f1328o, 2)) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
                if (classDescriptor2.isExpect()) {
                    L2.f name = classDescriptor2.getName();
                    kotlin.jvm.internal.h.e(name, "descriptor.name");
                    ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(name, EnumC0851b.d);
                    classDescriptor2 = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : contributedClassifier instanceof TypeAliasDescriptor ? ((TypeAliasDescriptor) contributedClassifier).getClassDescriptor() : null;
                }
                if (classDescriptor2 == null) {
                    continue;
                } else {
                    if (classDescriptor == null) {
                        f.a(27);
                        throw null;
                    }
                    int i = f.f1135a;
                    Iterator<AbstractC0162z> it = classDescriptor2.getTypeConstructor().getSupertypes().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (f.p(it.next(), classDescriptor.getOriginal())) {
                                linkedHashSet.add(classDescriptor2);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z6) {
                        MemberScope unsubstitutedInnerClassesScope = classDescriptor2.getUnsubstitutedInnerClassesScope();
                        kotlin.jvm.internal.h.e(unsubstitutedInnerClassesScope, "refinedDescriptor.unsubstitutedInnerClassesScope");
                        c(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, z6);
                    }
                }
            }
        }
    }

    public static w e(CallableDescriptor callableDescriptor, AbstractC0162z abstractC0162z, L2.f fVar, Annotations annotations, int i) {
        if (annotations == null) {
            a(33);
            throw null;
        }
        if (abstractC0162z == null) {
            return null;
        }
        V2.b bVar = new V2.b(callableDescriptor, abstractC0162z, fVar, null);
        kotlin.text.g gVar = L2.g.f963a;
        return new w(callableDescriptor, bVar, annotations, L2.f.e("_context_receiver_" + i));
    }

    public static J f(PropertyDescriptor propertyDescriptor, Annotations annotations) {
        return l(propertyDescriptor, annotations, true, propertyDescriptor.getSource());
    }

    public static K g(PropertyDescriptor propertyDescriptor, Annotations annotations) {
        o2.e eVar = o2.f.b;
        SourceElement source = propertyDescriptor.getSource();
        if (source != null) {
            return m(propertyDescriptor, annotations, eVar, true, propertyDescriptor.getVisibility(), source);
        }
        a(6);
        throw null;
    }

    public static I h(AbstractC0765b abstractC0765b) {
        if (abstractC0765b == null) {
            a(26);
            throw null;
        }
        ClassDescriptor classDescriptorD = AbstractC0718j.d(f.d(abstractC0765b), L2.i.f980t);
        if (classDescriptorD == null) {
            return null;
        }
        Annotations.Companion.getClass();
        o2.e eVar = o2.f.b;
        EnumC0719k enumC0719k = EnumC0719k.f4247a;
        C0712d c0712d = AbstractC0713e.e;
        L2.f fVar = k2.p.b;
        EnumC0709a enumC0709a = EnumC0709a.d;
        I i = I.i(abstractC0765b, enumC0719k, c0712d, false, fVar, enumC0709a, abstractC0765b.getSource());
        J j6 = new J(i, eVar, enumC0719k, c0712d, false, false, false, enumC0709a, null, abstractC0765b.getSource());
        i.k(j6, null, null, null);
        M.b.getClass();
        M attributes = M.c;
        TypeConstructor constructor = classDescriptorD.getTypeConstructor();
        List arguments = Collections.singletonList(new a3.K(abstractC0765b.getDefaultType()));
        int i3 = C.f1530a;
        kotlin.jvm.internal.h.f(attributes, "attributes");
        kotlin.jvm.internal.h.f(constructor, "constructor");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        F fC = C.c(attributes, arguments, constructor, false);
        List list = Collections.EMPTY_LIST;
        i.m(fC, list, null, null, list);
        j6.i(i.getReturnType());
        return i;
    }

    public static L i(AbstractC0765b abstractC0765b) {
        if (abstractC0765b == null) {
            a(24);
            throw null;
        }
        Annotations.Companion.getClass();
        o2.e eVar = o2.f.b;
        L lR = L.r(abstractC0765b, k2.p.c, EnumC0709a.d, abstractC0765b.getSource());
        S s3 = new S(lR, null, 0, eVar, L2.f.e("value"), R2.e.e(abstractC0765b).t(), false, false, false, null, abstractC0765b.getSource());
        List list = Collections.EMPTY_LIST;
        return lR.l(null, null, list, list, Collections.singletonList(s3), abstractC0765b.getDefaultType(), EnumC0719k.f4247a, AbstractC0713e.e);
    }

    public static L j(AbstractC0765b abstractC0765b) {
        if (abstractC0765b == null) {
            a(22);
            throw null;
        }
        Annotations.Companion.getClass();
        L lR = L.r(abstractC0765b, k2.p.f3762a, EnumC0709a.d, abstractC0765b.getSource());
        List list = Collections.EMPTY_LIST;
        return lR.l(null, null, list, list, list, R2.e.e(abstractC0765b).g(abstractC0765b.getDefaultType()), EnumC0719k.f4247a, AbstractC0713e.e);
    }

    public static w k(CallableDescriptor callableDescriptor, AbstractC0162z abstractC0162z, Annotations annotations) {
        if (abstractC0162z == null) {
            return null;
        }
        return new w(callableDescriptor, new V2.c(callableDescriptor, abstractC0162z, null), annotations);
    }

    public static J l(PropertyDescriptor propertyDescriptor, Annotations annotations, boolean z6, SourceElement sourceElement) {
        if (annotations == null) {
            a(18);
            throw null;
        }
        if (sourceElement != null) {
            return new J(propertyDescriptor, annotations, propertyDescriptor.getModality(), propertyDescriptor.getVisibility(), z6, false, false, EnumC0709a.f4226a, null, sourceElement);
        }
        a(19);
        throw null;
    }

    public static K m(PropertyDescriptor propertyDescriptor, Annotations annotations, Annotations annotations2, boolean z6, AbstractC0714f abstractC0714f, SourceElement sourceElement) {
        if (annotations == null) {
            a(8);
            throw null;
        }
        if (annotations2 == null) {
            a(9);
            throw null;
        }
        if (abstractC0714f == null) {
            a(10);
            throw null;
        }
        if (sourceElement == null) {
            a(11);
            throw null;
        }
        K k6 = new K(propertyDescriptor, annotations, propertyDescriptor.getModality(), abstractC0714f, z6, false, false, EnumC0709a.f4226a, null, sourceElement);
        k6.f4572m = K.h(k6, propertyDescriptor.getType(), annotations2);
        return k6;
    }

    public static boolean n(FunctionDescriptor functionDescriptor) {
        return functionDescriptor.getKind() == EnumC0709a.d && f.n(functionDescriptor.getContainingDeclaration(), EnumC0711c.c);
    }

    public static final Collection o(Collection collection, Function1 descriptorByHandle) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        kotlin.jvm.internal.h.f(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        j3.m mVar = new j3.m();
        while (!linkedList.isEmpty()) {
            Object objP = kotlin.collections.m.P(linkedList);
            j3.m mVar2 = new j3.m();
            ArrayList arrayListG = o.g(objP, linkedList, descriptorByHandle, new C0019a(mVar2, 6));
            if (arrayListG.size() == 1 && mVar2.isEmpty()) {
                Object objF0 = kotlin.collections.m.f0(arrayListG);
                kotlin.jvm.internal.h.e(objF0, "overridableGroup.single()");
                mVar.add(objF0);
            } else {
                Object objS = o.s(arrayListG, descriptorByHandle);
                CallableDescriptor callableDescriptor = (CallableDescriptor) descriptorByHandle.invoke(objS);
                for (Object it : arrayListG) {
                    kotlin.jvm.internal.h.e(it, "it");
                    if (!o.k(callableDescriptor, (CallableDescriptor) descriptorByHandle.invoke(it))) {
                        mVar2.add(it);
                    }
                }
                if (!mVar2.isEmpty()) {
                    mVar.addAll(mVar2);
                }
                mVar.add(objS);
            }
        }
        return mVar;
    }

    public abstract void b(CallableMemberDescriptor callableMemberDescriptor);

    public abstract void d(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public void p(CallableMemberDescriptor member, Collection collection) {
        kotlin.jvm.internal.h.f(member, "member");
        member.setOverriddenDescriptors(collection);
    }
}
