package kotlin.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.B;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements KClass, ClassBasedDeclarationContainer {
    public static final Map b;
    public static final HashMap c;
    public static final LinkedHashMap d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3810a;

    static {
        List listY = kotlin.collections.n.y(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(listY));
        int i = 0;
        for (Object obj : listY) {
            int i3 = i + 1;
            if (i < 0) {
                kotlin.collections.n.C();
                throw null;
            }
            arrayList.add(new N1.e((Class) obj, Integer.valueOf(i)));
            i = i3;
        }
        b = kotlin.collections.A.L(arrayList);
        HashMap map = new HashMap();
        map.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        h.e(collectionValues, "primitiveFqNames.values");
        for (String kotlinName : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            h.e(kotlinName, "kotlinName");
            sb.append(kotlin.text.i.U(kotlinName, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
            sb.append("CompanionObject");
            map3.put(sb.toString(), kotlinName.concat(".Companion"));
        }
        for (Map.Entry entry : b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        c = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(B.F(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), kotlin.text.i.U((String) entry2.getValue(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
        }
        d = linkedHashMap;
    }

    public c(Class jClass) {
        h.f(jClass, "jClass");
        this.f3810a = jClass;
    }

    public static void a() {
        throw new N1.d();
    }

    @Override // kotlin.reflect.KClass
    public final boolean equals(Object obj) {
        return (obj instanceof c) && E1.k.I(this).equals(E1.k.I((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final Collection getConstructors() {
        a();
        throw null;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.f3810a;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    public final Collection getMembers() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final Collection getNestedClasses() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final Object getObjectInstance() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final String getQualifiedName() {
        String str;
        Class jClass = this.f3810a;
        h.f(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
            return null;
        }
        boolean zIsArray = jClass.isArray();
        HashMap map = c;
        if (!zIsArray) {
            String str2 = (String) map.get(jClass.getName());
            return str2 == null ? jClass.getCanonicalName() : str2;
        }
        Class<?> componentType = jClass.getComponentType();
        if (componentType.isPrimitive() && (str = (String) map.get(componentType.getName())) != null) {
            strConcat = str.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    @Override // kotlin.reflect.KClass
    public final List getSealedSubclasses() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final String getSimpleName() {
        String str;
        Class jClass = this.f3810a;
        h.f(jClass, "jClass");
        String strConcat = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (!jClass.isLocalClass()) {
            boolean zIsArray = jClass.isArray();
            LinkedHashMap linkedHashMap = d;
            if (!zIsArray) {
                String str2 = (String) linkedHashMap.get(jClass.getName());
                return str2 == null ? jClass.getSimpleName() : str2;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                strConcat = str.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = jClass.getSimpleName();
        Method enclosingMethod = jClass.getEnclosingMethod();
        if (enclosingMethod != null) {
            return kotlin.text.i.S(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return kotlin.text.i.T(simpleName);
        }
        return kotlin.text.i.S(simpleName, enclosingConstructor.getName() + '$', simpleName);
    }

    @Override // kotlin.reflect.KClass
    public final List getSupertypes() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final List getTypeParameters() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final kotlin.reflect.f getVisibility() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final int hashCode() {
        return E1.k.I(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isAbstract() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isCompanion() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isData() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isFinal() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isFun() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isInner() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isInstance(Object obj) {
        Class jClass = this.f3810a;
        h.f(jClass, "jClass");
        Map map = b;
        h.d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(jClass);
        if (num != null) {
            return z.e(num.intValue(), obj);
        }
        if (jClass.isPrimitive()) {
            jClass = E1.k.I(E1.k.K(jClass));
        }
        return jClass.isInstance(obj);
    }

    @Override // kotlin.reflect.KClass
    public final boolean isOpen() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isSealed() {
        a();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isValue() {
        a();
        throw null;
    }

    public final String toString() {
        return this.f3810a.toString() + " (Kotlin reflection is not available)";
    }
}
