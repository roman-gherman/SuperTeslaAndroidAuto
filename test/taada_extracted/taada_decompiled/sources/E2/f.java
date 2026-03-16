package E2;

import C0.x;
import G2.U;
import a3.AbstractC0162z;
import a3.C;
import a3.F;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements FlexibleTypeDeserializer, JvmTypeFactory, PackagePartProvider, TypeMappingConfiguration, JavaModuleAnnotationsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f302a = new f();
    public static final f b = new f();
    public static final f c = new f();
    public static final f d = new f();

    public static String[] a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static k b(String representation) {
        S2.b bVar;
        kotlin.jvm.internal.h.f(representation, "representation");
        char cCharAt = representation.charAt(0);
        S2.b[] bVarArrValues = S2.b.values();
        int length = bVarArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                bVar = null;
                break;
            }
            bVar = bVarArrValues[i];
            if (bVar.c().charAt(0) == cCharAt) {
                break;
            }
            i++;
        }
        if (bVar != null) {
            return new j(bVar);
        }
        if (cCharAt == 'V') {
            return new j(null);
        }
        if (cCharAt == '[') {
            String strSubstring = representation.substring(1);
            kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            return new h(b(strSubstring));
        }
        if (cCharAt == 'L' && representation.length() > 0) {
            io.ktor.utils.io.jvm.javaio.q.h(representation.charAt(kotlin.text.i.F(representation)), TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, false);
        }
        String strSubstring2 = representation.substring(1, representation.length() - 1);
        kotlin.jvm.internal.h.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return new i(strSubstring2);
    }

    public static LinkedHashSet c(String internalName, String... signatures) {
        kotlin.jvm.internal.h.f(internalName, "internalName");
        kotlin.jvm.internal.h.f(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str);
        }
        return linkedHashSet;
    }

    public static LinkedHashSet d(String str, String... signatures) {
        kotlin.jvm.internal.h.f(signatures, "signatures");
        return c("java/lang/".concat(str), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public static LinkedHashSet e(String str, String... strArr) {
        return c("java/util/".concat(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static String f(k type) {
        String strC;
        kotlin.jvm.internal.h.f(type, "type");
        if (type instanceof h) {
            return "[" + f(((h) type).i);
        }
        if (type instanceof j) {
            S2.b bVar = ((j) type).i;
            return (bVar == null || (strC = bVar.c()) == null) ? "V" : strC;
        }
        if (type instanceof i) {
            return androidx.constraintlayout.core.motion.a.s(new StringBuilder("L"), ((i) type).i, TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        }
        throw new x();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public Object boxType(Object obj) {
        S2.b bVar;
        k possiblyPrimitiveType = (k) obj;
        kotlin.jvm.internal.h.f(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (!(possiblyPrimitiveType instanceof j) || (bVar = ((j) possiblyPrimitiveType).i) == null) {
            return possiblyPrimitiveType;
        }
        String strE = S2.a.c(bVar.e()).e();
        kotlin.jvm.internal.h.e(strE, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return new i(strE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public AbstractC0162z commonSupertype(Collection types) {
        kotlin.jvm.internal.h.f(types, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: ".concat(kotlin.collections.m.V(types, null, null, null, null, 63)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    public AbstractC0162z create(U proto, String flexibleId, F lowerBound, F upperBound) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(flexibleId, "flexibleId");
        kotlin.jvm.internal.h.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.h.f(upperBound, "upperBound");
        return !flexibleId.equals("kotlin.jvm.PlatformType") ? c3.j.c(c3.i.ERROR_FLEXIBLE_TYPE, flexibleId, lowerBound.toString(), upperBound.toString()) : proto.e(J2.l.f866g) ? new B2.h(lowerBound, upperBound) : C.a(lowerBound, upperBound);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ Object createFromString(String str) {
        return b(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public Object createObjectType(String internalName) {
        kotlin.jvm.internal.h.f(internalName, "internalName");
        return new i(internalName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public Object createPrimitiveType(k2.k primitiveType) {
        kotlin.jvm.internal.h.f(primitiveType, "primitiveType");
        switch (primitiveType) {
            case BOOLEAN:
                return k.f304a;
            case CHAR:
                return k.b;
            case BYTE:
                return k.c;
            case SHORT:
                return k.d;
            case INT:
                return k.e;
            case FLOAT:
                return k.f305f;
            case LONG:
                return k.f306g;
            case DOUBLE:
                return k.f307h;
            default:
                throw new x();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
    public List findPackageParts(String packageFqName) {
        kotlin.jvm.internal.h.f(packageFqName, "packageFqName");
        return u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider
    public List getAnnotationsForModuleOwnerOfClass(L2.b classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public Object getJavaLangClassType() {
        return new i(TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public Object getPredefinedTypeForClass(ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public AbstractC0162z preprocessType(AbstractC0162z kotlinType) {
        kotlin.jvm.internal.h.f(kotlinType, "kotlinType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public void processErrorType(AbstractC0162z kotlinType, ClassDescriptor descriptor) {
        kotlin.jvm.internal.h.f(kotlinType, "kotlinType");
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ String toString(Object obj) {
        return f((k) obj);
    }
}
