package x2;

import a3.AbstractC0162z;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;

/* JADX INFO: renamed from: x2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0921h implements JavaPropertyInitializerEvaluator, JavaResolverCache, SignaturePropagator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0921h f5118a = new C0921h();

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "member";
                break;
            case 2:
            case 4:
            case 6:
            case 8:
                objArr[0] = "descriptor";
                break;
            case 3:
                objArr[0] = "element";
                break;
            case 5:
                objArr[0] = "field";
                break;
            case 7:
                objArr[0] = "javaClass";
                break;
            default:
                objArr[0] = "fqName";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
        switch (i) {
            case 1:
            case 2:
                objArr[2] = "recordMethod";
                break;
            case 3:
            case 4:
                objArr[2] = "recordConstructor";
                break;
            case 5:
            case 6:
                objArr[2] = "recordField";
                break;
            case 7:
            case 8:
                objArr[2] = "recordClass";
                break;
            default:
                objArr[2] = "getClassResolvedFromSource";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static /* synthetic */ void b(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "owner";
                break;
            case 2:
                objArr[0] = "returnType";
                break;
            case 3:
                objArr[0] = "valueParameters";
                break;
            case 4:
                objArr[0] = "typeParameters";
                break;
            case 5:
                objArr[0] = "descriptor";
                break;
            case 6:
                objArr[0] = "signatureErrors";
                break;
            default:
                objArr[0] = "method";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
        if (i == 5 || i == 6) {
            objArr[2] = "reportSignatureErrors";
        } else {
            objArr[2] = "resolvePropagatedSignature";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache
    public ClassDescriptor getClassResolvedFromSource(L2.c cVar) {
        if (cVar != null) {
            return null;
        }
        a(0);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator
    public P2.g getInitializerConstant(JavaField field, PropertyDescriptor descriptor) {
        kotlin.jvm.internal.h.f(field, "field");
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache
    public void recordClass(JavaClass javaClass, ClassDescriptor classDescriptor) {
        if (javaClass == null) {
            a(7);
            throw null;
        }
        if (classDescriptor != null) {
            return;
        }
        a(8);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache
    public void recordConstructor(JavaElement javaElement, ConstructorDescriptor constructorDescriptor) {
        if (javaElement == null) {
            a(3);
            throw null;
        }
        if (constructorDescriptor != null) {
            return;
        }
        a(4);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache
    public void recordField(JavaField javaField, PropertyDescriptor propertyDescriptor) {
        if (javaField == null) {
            a(5);
            throw null;
        }
        if (propertyDescriptor != null) {
            return;
        }
        a(6);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache
    public void recordMethod(JavaMember javaMember, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        if (javaMember == null) {
            a(1);
            throw null;
        }
        if (simpleFunctionDescriptor != null) {
            return;
        }
        a(2);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
    public void reportSignatureErrors(CallableMemberDescriptor callableMemberDescriptor, List list) {
        if (callableMemberDescriptor == null) {
            b(5);
            throw null;
        }
        if (list != null) {
            throw new UnsupportedOperationException("Should not be called");
        }
        b(6);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
    public C0924k resolvePropagatedSignature(JavaMethod javaMethod, ClassDescriptor classDescriptor, AbstractC0162z abstractC0162z, AbstractC0162z abstractC0162z2, List list, List list2) {
        if (javaMethod == null) {
            b(0);
            throw null;
        }
        if (classDescriptor == null) {
            b(1);
            throw null;
        }
        if (abstractC0162z == null) {
            b(2);
            throw null;
        }
        if (list == null) {
            b(3);
            throw null;
        }
        if (list2 != null) {
            List list3 = Collections.EMPTY_LIST;
            return new C0924k(abstractC0162z, abstractC0162z2, list, list2);
        }
        b(4);
        throw null;
    }
}
