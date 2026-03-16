package t2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.multidex.ClassPathElement;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

/* JADX INFO: renamed from: t2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0823e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f4805a;
    public static final Map b;
    public static final Map c;
    public static final Map d;

    static {
        int i = 0;
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        List<KClass> listY = kotlin.collections.n.y(xVar.b(Boolean.TYPE), xVar.b(Byte.TYPE), xVar.b(Character.TYPE), xVar.b(Double.TYPE), xVar.b(Float.TYPE), xVar.b(Integer.TYPE), xVar.b(Long.TYPE), xVar.b(Short.TYPE));
        f4805a = listY;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(listY));
        for (KClass kClass : listY) {
            arrayList.add(new N1.e(E1.k.I(kClass), E1.k.J(kClass)));
        }
        b = kotlin.collections.A.L(arrayList);
        List<KClass> list = f4805a;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(list));
        for (KClass kClass2 : list) {
            arrayList2.add(new N1.e(E1.k.J(kClass2), E1.k.I(kClass2)));
        }
        c = kotlin.collections.A.L(arrayList2);
        List listY2 = kotlin.collections.n.y(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(listY2));
        for (Object obj : listY2) {
            int i3 = i + 1;
            if (i < 0) {
                kotlin.collections.n.C();
                throw null;
            }
            arrayList3.add(new N1.e((Class) obj, Integer.valueOf(i)));
            i = i3;
        }
        d = kotlin.collections.A.L(arrayList3);
    }

    public static final L2.b a(Class cls) {
        L2.b bVarA;
        kotlin.jvm.internal.h.f(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.j(cls, "Can't compute ClassId for primitive type: "));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.j(cls, "Can't compute ClassId for array type: "));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null && cls.getSimpleName().length() != 0) {
            Class<?> declaringClass = cls.getDeclaringClass();
            return (declaringClass == null || (bVarA = a(declaringClass)) == null) ? L2.b.j(new L2.c(cls.getName())) : bVarA.d(L2.f.e(cls.getSimpleName()));
        }
        L2.c cVar = new L2.c(cls.getName());
        return new L2.b(cVar.e(), L2.c.j(cVar.f()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final String b(Class cls) {
        kotlin.jvm.internal.h.f(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                return kotlin.text.r.A(cls.getName(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR);
            }
            return "L" + kotlin.text.r.A(cls.getName(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    return "I";
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    return "V";
                }
                break;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    return "F";
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    return "S";
                }
                break;
        }
        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.j(cls, "Unsupported primitive type: "));
    }

    public static final List c(Type type) {
        kotlin.jvm.internal.h.f(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return kotlin.collections.u.f3805a;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return k3.m.F(k3.m.z(k3.m.B(type, C0821c.f4803a), C0822d.f4804a));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        kotlin.jvm.internal.h.e(actualTypeArguments, "actualTypeArguments");
        return kotlin.collections.j.L(actualTypeArguments);
    }

    public static final ClassLoader d(Class cls) {
        kotlin.jvm.internal.h.f(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        kotlin.jvm.internal.h.e(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }
}
