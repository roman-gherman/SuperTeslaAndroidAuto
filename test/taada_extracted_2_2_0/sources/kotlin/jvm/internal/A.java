package kotlin.jvm.internal;

import A2.C0019a;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes2.dex */
public final class A implements KType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass f3809a;
    public final List b;

    public A(KClass classifier) {
        List arguments = Collections.EMPTY_LIST;
        h.f(classifier, "classifier");
        h.f(arguments, "arguments");
        this.f3809a = classifier;
        this.b = arguments;
    }

    public final String a(boolean z6) {
        String name;
        KClass kClass = this.f3809a;
        KClass kClass2 = kClass != null ? kClass : null;
        Class clsH = kClass2 != null ? E1.k.H(kClass2) : null;
        if (clsH == null) {
            name = kClass.toString();
        } else if (clsH.isArray()) {
            name = clsH.equals(boolean[].class) ? "kotlin.BooleanArray" : clsH.equals(char[].class) ? "kotlin.CharArray" : clsH.equals(byte[].class) ? "kotlin.ByteArray" : clsH.equals(short[].class) ? "kotlin.ShortArray" : clsH.equals(int[].class) ? "kotlin.IntArray" : clsH.equals(float[].class) ? "kotlin.FloatArray" : clsH.equals(long[].class) ? "kotlin.LongArray" : clsH.equals(double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
        } else if (z6 && clsH.isPrimitive()) {
            h.d(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = E1.k.I(kClass).getName();
        } else {
            name = clsH.getName();
        }
        List list = Collections.EMPTY_LIST;
        return B2.b.f(name, list.isEmpty() ? "" : kotlin.collections.m.V(list, ", ", "<", ">", new C0019a(this, 21), 24), "");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof A)) {
            return false;
        }
        if (!h.a(this.f3809a, ((A) obj).f3809a)) {
            return false;
        }
        List list = Collections.EMPTY_LIST;
        return h.a(list, list);
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        return kotlin.collections.u.f3805a;
    }

    @Override // kotlin.reflect.KType
    public final List getArguments() {
        return this.b;
    }

    @Override // kotlin.reflect.KType
    public final KClassifier getClassifier() {
        return this.f3809a;
    }

    public final int hashCode() {
        return Integer.hashCode(0) + androidx.constraintlayout.core.motion.a.d(Collections.EMPTY_LIST, this.f3809a.hashCode() * 31, 31);
    }

    @Override // kotlin.reflect.KType
    public final boolean isMarkedNullable() {
        return false;
    }

    public final String toString() {
        return a(false) + " (Kotlin reflection is not available)";
    }
}
