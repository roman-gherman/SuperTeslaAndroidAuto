package m2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.E;
import kotlin.collections.s;

/* JADX INFO: renamed from: m2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0663o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f4099a = E.v(E2.f.e("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    public static final LinkedHashSet b;
    public static final LinkedHashSet c;
    public static final LinkedHashSet d;
    public static final LinkedHashSet e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LinkedHashSet f4100f;

    static {
        List<S2.b> listY = kotlin.collections.n.y(S2.b.BOOLEAN, S2.b.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (S2.b bVar : listY) {
            String strB = bVar.e().f().b();
            kotlin.jvm.internal.h.e(strB, "it.wrapperFqName.shortName().asString()");
            s.F(E2.f.d(strB, bVar.b + "Value()" + bVar.c()), linkedHashSet);
        }
        b = E.w(E.w(E.w(E.w(E.w(E.w(linkedHashSet, E2.f.e("List", "sort(Ljava/util/Comparator;)V")), E2.f.d("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), E2.f.d("Double", "isInfinite()Z", "isNaN()Z")), E2.f.d("Float", "isInfinite()Z", "isNaN()Z")), E2.f.d("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), E2.f.d("CharSequence", "isEmpty()Z"));
        c = E.w(E.w(E.w(E.w(E.w(E.w(E2.f.d("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), E2.f.e("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), E2.f.d("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), E2.f.d("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), E2.f.e("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), E2.f.e("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), E2.f.e("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        d = E.w(E.w(E2.f.e("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), E2.f.e("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), E2.f.e("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        S2.b bVar2 = S2.b.BOOLEAN;
        S2.b bVar3 = S2.b.BYTE;
        List listY2 = kotlin.collections.n.y(bVar2, bVar3, S2.b.DOUBLE, S2.b.FLOAT, bVar3, S2.b.INT, S2.b.LONG, S2.b.SHORT);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it = listY2.iterator();
        while (it.hasNext()) {
            String strB2 = ((S2.b) it.next()).e().f().b();
            kotlin.jvm.internal.h.e(strB2, "it.wrapperFqName.shortName().asString()");
            String[] strArrA = E2.f.a("Ljava/lang/String;");
            s.F(E2.f.d(strB2, (String[]) Arrays.copyOf(strArrA, strArrA.length)), linkedHashSet2);
        }
        String[] strArrA2 = E2.f.a("D");
        LinkedHashSet linkedHashSetW = E.w(linkedHashSet2, E2.f.d("Float", (String[]) Arrays.copyOf(strArrA2, strArrA2.length)));
        String[] strArrA3 = E2.f.a("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        e = E.w(linkedHashSetW, E2.f.d("String", (String[]) Arrays.copyOf(strArrA3, strArrA3.length)));
        String[] strArrA4 = E2.f.a("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f4100f = E2.f.d("Throwable", (String[]) Arrays.copyOf(strArrA4, strArrA4.length));
    }
}
