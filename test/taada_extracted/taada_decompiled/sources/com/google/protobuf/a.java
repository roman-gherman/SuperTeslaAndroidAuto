package com.google.protobuf;

import B2.b;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import y0.AbstractC0928a;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {
    public static final boolean a(int i) {
        return !AbstractC0928a.a();
    }

    public static final boolean b(int i) {
        Boolean bool;
        if (AbstractC0928a.a()) {
            try {
                bool = (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
                AbstractC0928a.f5127a.info("Conscrypt is not available or does not support checking for FIPS build.");
                bool = Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean c(int i) {
        if (i == 1 || i == 2) {
            return false;
        }
        if (i == 3 || i == 4) {
            return true;
        }
        throw null;
    }

    public static int d(int i, int i3, int i4, int i5) {
        return CodedOutputStream.computeUInt32SizeNoTag(i) + i3 + i4 + i5;
    }

    public static int e(int i, int i3, Class cls) {
        return (cls.hashCode() + i) * i3;
    }

    public static int f(MethodDescription methodDescription, int i, int i3) {
        return (methodDescription.hashCode() + i) * i3;
    }

    public static int g(TypeDefinition typeDefinition, int i) {
        return typeDefinition.getStackSize().getSize() + i;
    }

    public static int h(TypeDescription.Generic generic, int i, int i3) {
        return (generic.hashCode() + i) * i3;
    }

    public static int i(TypeDescription typeDescription, int i, int i3) {
        return (typeDescription.hashCode() + i) * i3;
    }

    public static int j(ElementMatcher elementMatcher, int i, int i3) {
        return (elementMatcher.hashCode() + i) * i3;
    }

    public static Object k(Class cls, AnnotationValue annotationValue, Class cls2) {
        return annotationValue.load(cls.getClassLoader()).resolve(cls2);
    }

    public static String l(String str, MethodDescription methodDescription) {
        return str + methodDescription;
    }

    public static String m(String str, TypeDescription typeDescription) {
        return str + typeDescription;
    }

    public static String n(StringBuilder sb, ElementMatcher elementMatcher, String str) {
        sb.append(elementMatcher);
        sb.append(str);
        return sb.toString();
    }

    public static String o(TypeDescription typeDescription, String str) {
        return typeDescription + str;
    }

    public static /* synthetic */ void p(int i, String str) {
        if (i != 0) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(h.i(str));
        h.l(nullPointerException, h.class.getName());
        throw nullPointerException;
    }

    public static /* synthetic */ void q(int i, String str) {
        if (i != 0) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(b.e(str, " must not be null"));
        h.l(nullPointerException, h.class.getName());
        throw nullPointerException;
    }
}
