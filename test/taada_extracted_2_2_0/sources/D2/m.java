package D2;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f258a = new e(h.b, false);
    public static final e b;
    public static final e c;
    public static final LinkedHashMap d;

    static {
        h hVar = h.c;
        b = new e(hVar, false);
        c = new e(hVar, true);
        String strConcat = "java/lang/".concat("Object");
        String strConcat2 = "java/util/function/".concat("Predicate");
        String strConcat3 = "java/util/function/".concat("Function");
        String strConcat4 = "java/util/function/".concat("Consumer");
        String strConcat5 = "java/util/function/".concat("BiFunction");
        String strConcat6 = "java/util/function/".concat("BiConsumer");
        String strConcat7 = "java/util/function/".concat("UnaryOperator");
        String strConcat8 = "java/util/".concat("stream/Stream");
        String strConcat9 = "java/util/".concat("Optional");
        B.g gVar = new B.g(4);
        new B.h(gVar, "java/util/".concat("Iterator")).e("forEachRemaining", new j(strConcat4, 0));
        new B.h(gVar, "java/lang/".concat("Iterable")).e("spliterator", new k(1));
        B.h hVar2 = new B.h(gVar, "java/util/".concat("Collection"));
        hVar2.e("removeIf", new j(strConcat2, 6));
        hVar2.e("stream", new j(strConcat8, 7));
        hVar2.e("parallelStream", new j(strConcat8, 8));
        new B.h(gVar, "java/util/".concat("List")).e("replaceAll", new j(strConcat7, 9));
        B.h hVar3 = new B.h(gVar, "java/util/".concat("Map"));
        hVar3.e("forEach", new j(strConcat6, 10));
        hVar3.e("putIfAbsent", new j(strConcat, 11));
        hVar3.e("replace", new j(strConcat, 12));
        hVar3.e("replace", new j(strConcat, 13));
        hVar3.e("replaceAll", new j(strConcat5, 14));
        hVar3.e("compute", new l(0, strConcat, strConcat5));
        hVar3.e("computeIfAbsent", new l(1, strConcat, strConcat3));
        hVar3.e("computeIfPresent", new l(2, strConcat, strConcat5));
        hVar3.e("merge", new l(3, strConcat, strConcat5));
        B.h hVar4 = new B.h(gVar, strConcat9);
        hVar4.e("empty", new j(strConcat9, 15));
        hVar4.e("of", new l(4, strConcat, strConcat9));
        hVar4.e("ofNullable", new l(5, strConcat, strConcat9));
        hVar4.e("get", new j(strConcat, 16));
        hVar4.e("ifPresent", new j(strConcat4, 17));
        new B.h(gVar, "java/lang/".concat("ref/Reference")).e("get", new j(strConcat, 18));
        new B.h(gVar, strConcat2).e("test", new j(strConcat, 19));
        new B.h(gVar, "java/util/function/".concat("BiPredicate")).e("test", new j(strConcat, 20));
        new B.h(gVar, strConcat4).e("accept", new j(strConcat, 1));
        new B.h(gVar, strConcat6).e("accept", new j(strConcat, 2));
        new B.h(gVar, strConcat3).e("apply", new j(strConcat, 3));
        new B.h(gVar, strConcat5).e("apply", new j(strConcat, 4));
        new B.h(gVar, "java/util/function/".concat("Supplier")).e("get", new j(strConcat, 5));
        d = (LinkedHashMap) gVar.b;
    }
}
