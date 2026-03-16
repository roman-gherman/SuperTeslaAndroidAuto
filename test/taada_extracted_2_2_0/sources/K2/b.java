package K2;

import E1.k;
import com.android.multidex.ClassPathElement;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.text.r;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f936a = m.V(n.y('k', 'o', Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL), 'l', 'i', 'n'), "", null, null, null, 62);
    public static final LinkedHashMap b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listY = n.y("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int iL = k.L(0, listY.size() - 1, 2);
        if (iL >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f936a;
                sb.append(str);
                sb.append(ClassPathElement.SEPARATOR_CHAR);
                sb.append((String) listY.get(i));
                int i3 = i + 1;
                linkedHashMap.put(sb.toString(), listY.get(i3));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(ClassPathElement.SEPARATOR_CHAR);
                linkedHashMap.put(B2.b.h(sb2, (String) listY.get(i), "Array"), "[" + ((String) listY.get(i3)));
                if (i == iL) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        linkedHashMap.put(f936a + "/Unit", "V");
        a(linkedHashMap, "Any", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : n.y("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : n.y("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, androidx.constraintlayout.core.motion.a.p("collections/", str3), "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i4 = 0; i4 < 23; i4++) {
            String strC = B2.b.c(i4, "Function");
            StringBuilder sb3 = new StringBuilder();
            String str4 = f936a;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i4);
            a(linkedHashMap, strC, sb3.toString());
            a(linkedHashMap, "reflect/KFunction" + i4, str4 + "/reflect/KFunction");
        }
        for (String str5 : n.y("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, B2.b.e(str5, ".Companion"), f936a + "/jvm/internal/" + str5 + "CompanionObject");
        }
        b = linkedHashMap;
    }

    public static final void a(LinkedHashMap linkedHashMap, String str, String str2) {
        linkedHashMap.put(f936a + ClassPathElement.SEPARATOR_CHAR + str, "L" + str2 + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    public static final String b(String classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        String str = (String) b.get(classId);
        if (str != null) {
            return str;
        }
        return "L" + r.A(classId, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '$') + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
    }
}
