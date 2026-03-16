package i2;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.calls.Caller;
import t2.AbstractC0823e;

/* JADX INFO: renamed from: i2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0528a implements Caller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3464a;
    public final ArrayList b;
    public final int c;
    public final List d;
    public final ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f3465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f3466g;

    public C0528a(Class jClass, ArrayList arrayList, int i, int i3, List methods) {
        boolean z6;
        kotlin.jvm.internal.h.f(jClass, "jClass");
        com.google.protobuf.a.p(i, "callMode");
        com.google.protobuf.a.p(i3, "origin");
        kotlin.jvm.internal.h.f(methods, "methods");
        this.f3464a = jClass;
        this.b = arrayList;
        this.c = i;
        this.d = methods;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(methods));
        Iterator it = methods.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Method) it.next()).getGenericReturnType());
        }
        this.e = arrayList2;
        List list = this.d;
        ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(list));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Class<?> it3 = ((Method) it2.next()).getReturnType();
            kotlin.jvm.internal.h.e(it3, "it");
            List list2 = AbstractC0823e.f4804a;
            Class<?> cls = (Class) AbstractC0823e.c.get(it3);
            if (cls != null) {
                it3 = cls;
            }
            arrayList3.add(it3);
        }
        this.f3465f = arrayList3;
        List list3 = this.d;
        ArrayList arrayList4 = new ArrayList(kotlin.collections.o.D(list3));
        Iterator it4 = list3.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((Method) it4.next()).getDefaultValue());
        }
        this.f3466g = arrayList4;
        if (this.c == 2 && i3 == 1) {
            ArrayList arrayList5 = this.b;
            kotlin.jvm.internal.h.f(arrayList5, "<this>");
            ArrayList arrayList6 = new ArrayList(kotlin.collections.o.D(arrayList5));
            boolean z7 = false;
            for (Object obj : arrayList5) {
                if (z7 || !kotlin.jvm.internal.h.a(obj, "value")) {
                    z6 = true;
                } else {
                    z7 = true;
                    z6 = false;
                }
                if (z6) {
                    arrayList6.add(obj);
                }
            }
            if (!arrayList6.isEmpty()) {
                throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object call(java.lang.Object[] r18) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C0528a.call(java.lang.Object[]):java.lang.Object");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final /* bridge */ /* synthetic */ Member getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final List getParameterTypes() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        return this.f3464a;
    }

    public /* synthetic */ C0528a(Class cls, ArrayList arrayList, int i) {
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
        }
        this(cls, arrayList, i, 2, arrayList2);
    }
}
