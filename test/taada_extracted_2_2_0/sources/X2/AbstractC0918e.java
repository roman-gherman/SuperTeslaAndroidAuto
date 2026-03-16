package x2;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.A;
import kotlin.collections.o;
import kotlin.collections.s;
import kotlin.collections.w;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import o2.l;

/* JADX INFO: renamed from: x2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0918e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5115a = A.I(new N1.e("PACKAGE", EnumSet.noneOf(l.class)), new N1.e("TYPE", EnumSet.of(l.CLASS, l.FILE)), new N1.e("ANNOTATION_TYPE", EnumSet.of(l.ANNOTATION_CLASS)), new N1.e("TYPE_PARAMETER", EnumSet.of(l.TYPE_PARAMETER)), new N1.e("FIELD", EnumSet.of(l.FIELD)), new N1.e("LOCAL_VARIABLE", EnumSet.of(l.LOCAL_VARIABLE)), new N1.e("PARAMETER", EnumSet.of(l.VALUE_PARAMETER)), new N1.e("CONSTRUCTOR", EnumSet.of(l.CONSTRUCTOR)), new N1.e("METHOD", EnumSet.of(l.FUNCTION, l.PROPERTY_GETTER, l.PROPERTY_SETTER)), new N1.e("TYPE_USE", EnumSet.of(l.TYPE)));
    public static final Object b = A.I(new N1.e("RUNTIME", o2.k.f4294a), new N1.e("CLASS", o2.k.b), new N1.e("SOURCE", o2.k.c));

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    public static P2.b a(List arguments) {
        kotlin.jvm.internal.h.f(arguments, "arguments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof JavaEnumValueAnnotationArgument) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            L2.f entryName = ((JavaEnumValueAnnotationArgument) it.next()).getEntryName();
            Iterable iterable = (EnumSet) f5115a.get(entryName != null ? entryName.b() : null);
            if (iterable == null) {
                iterable = w.f3807a;
            }
            s.F(iterable, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(o.D(arrayList2));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(new P2.i(L2.b.j(k2.o.u), L2.f.e(((l) it2.next()).name())));
        }
        return new P2.b(arrayList3, C0917d.f5114a);
    }
}
