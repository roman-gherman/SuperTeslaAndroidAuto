package a3;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import q2.AbstractC0762A;

/* JADX INFO: loaded from: classes2.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1530a = 0;

    static {
        int i = C0136A.f1528a;
    }

    public static final c0 a(F lowerBound, F upperBound) {
        kotlin.jvm.internal.h.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.h.f(upperBound, "upperBound");
        return lowerBound.equals(upperBound) ? lowerBound : new C0156t(lowerBound, upperBound);
    }

    public static final F b(M attributes, ClassDescriptor descriptor, List arguments) {
        kotlin.jvm.internal.h.f(attributes, "attributes");
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        kotlin.jvm.internal.h.e(typeConstructor, "descriptor.typeConstructor");
        return c(attributes, arguments, typeConstructor, false);
    }

    public static F c(M attributes, List arguments, TypeConstructor constructor, boolean z6) {
        MemberScope memberScopeM;
        AbstractC0762A abstractC0762A;
        MemberScope memberScopeA;
        MemberScope memberScope;
        kotlin.jvm.internal.h.f(attributes, "attributes");
        kotlin.jvm.internal.h.f(constructor, "constructor");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        if (attributes.isEmpty() && arguments.isEmpty() && !z6 && constructor.getDeclarationDescriptor() != null) {
            ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
            kotlin.jvm.internal.h.c(declarationDescriptor);
            F defaultType = declarationDescriptor.getDefaultType();
            kotlin.jvm.internal.h.e(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return defaultType;
        }
        ClassifierDescriptor declarationDescriptor2 = constructor.getDeclarationDescriptor();
        if (declarationDescriptor2 instanceof TypeParameterDescriptor) {
            memberScopeM = ((TypeParameterDescriptor) declarationDescriptor2).getDefaultType().getMemberScope();
        } else {
            if (declarationDescriptor2 instanceof ClassDescriptor) {
                R2.e.i(R2.e.j(declarationDescriptor2));
                b3.c cVar = b3.c.f1699a;
                if (arguments.isEmpty()) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor2;
                    kotlin.jvm.internal.h.f(classDescriptor, "<this>");
                    abstractC0762A = classDescriptor instanceof AbstractC0762A ? (AbstractC0762A) classDescriptor : null;
                    if (abstractC0762A == null || (memberScopeA = abstractC0762A.b(cVar)) == null) {
                        memberScopeM = classDescriptor.getUnsubstitutedMemberScope();
                        kotlin.jvm.internal.h.e(memberScopeM, "this.unsubstitutedMemberScope");
                    }
                    memberScope = memberScopeA;
                } else {
                    ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor2;
                    W wF = S.b.f(constructor, arguments);
                    kotlin.jvm.internal.h.f(classDescriptor2, "<this>");
                    abstractC0762A = classDescriptor2 instanceof AbstractC0762A ? (AbstractC0762A) classDescriptor2 : null;
                    if (abstractC0762A == null || (memberScopeA = abstractC0762A.a(wF, cVar)) == null) {
                        memberScopeM = classDescriptor2.getMemberScope(wF);
                        kotlin.jvm.internal.h.e(memberScopeM, "this.getMemberScope(\n   …ubstitution\n            )");
                    }
                    memberScope = memberScopeA;
                }
                return e(attributes, constructor, arguments, z6, memberScope, new A2.q(attributes, arguments, constructor, z6));
            }
            if (declarationDescriptor2 instanceof TypeAliasDescriptor) {
                String str = ((TypeAliasDescriptor) declarationDescriptor2).getName().f962a;
                kotlin.jvm.internal.h.e(str, "descriptor.name.toString()");
                memberScopeM = c3.j.a(4, true, str);
            } else {
                if (!(constructor instanceof C0161y)) {
                    throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor2 + " for constructor: " + constructor);
                }
                memberScopeM = kotlin.reflect.l.m("member scope for intersection type", ((C0161y) constructor).b);
            }
        }
        memberScope = memberScopeM;
        return e(attributes, constructor, arguments, z6, memberScope, new A2.q(attributes, arguments, constructor, z6));
    }

    public static final F d(M attributes, List arguments, MemberScope memberScope, TypeConstructor constructor, boolean z6) {
        kotlin.jvm.internal.h.f(attributes, "attributes");
        kotlin.jvm.internal.h.f(constructor, "constructor");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        kotlin.jvm.internal.h.f(memberScope, "memberScope");
        G g6 = new G(constructor, arguments, z6, memberScope, new C0137B(attributes, arguments, memberScope, constructor, z6));
        return attributes.isEmpty() ? g6 : new H(g6, attributes);
    }

    public static final F e(M attributes, TypeConstructor constructor, List arguments, boolean z6, MemberScope memberScope, Function1 function1) {
        kotlin.jvm.internal.h.f(attributes, "attributes");
        kotlin.jvm.internal.h.f(constructor, "constructor");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        kotlin.jvm.internal.h.f(memberScope, "memberScope");
        G g6 = new G(constructor, arguments, z6, memberScope, function1);
        return attributes.isEmpty() ? g6 : new H(g6, attributes);
    }
}
