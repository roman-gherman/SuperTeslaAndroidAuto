package k3;

import A2.C0022d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends o {
    public static final h A(Sequence sequence) {
        boolean z6 = sequence instanceof u;
        p iterator = p.b;
        if (!z6) {
            return new h(sequence, p.c, iterator);
        }
        u uVar = (u) sequence;
        kotlin.jvm.internal.h.f(iterator, "iterator");
        return new h(uVar.f3796a, uVar.b, iterator);
    }

    public static Sequence B(Object obj, Function1 nextFunction) {
        kotlin.jvm.internal.h.f(nextFunction, "nextFunction");
        return obj == null ? d.f3782a : new j(new C0022d(obj, 22), nextFunction);
    }

    public static Object C(Sequence sequence) {
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static u D(Sequence sequence, Function1 transform) {
        kotlin.jvm.internal.h.f(transform, "transform");
        return new u(sequence, transform);
    }

    public static f E(Sequence sequence, Function1 transform) {
        kotlin.jvm.internal.h.f(transform, "transform");
        return x(new u(sequence, transform), p.d);
    }

    public static List F(Sequence sequence) {
        kotlin.jvm.internal.h.f(sequence, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return kotlin.collections.n.B(arrayList);
    }

    public static Sequence u(Iterator it) {
        kotlin.jvm.internal.h.f(it, "<this>");
        return new C0590a(new n(it, 1));
    }

    public static int v(Sequence sequence) {
        Iterator it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    public static f w(Sequence sequence, Function1 predicate) {
        kotlin.jvm.internal.h.f(predicate, "predicate");
        return new f(sequence, true, predicate);
    }

    public static f x(Sequence sequence, Function1 predicate) {
        kotlin.jvm.internal.h.f(predicate, "predicate");
        return new f(sequence, false, predicate);
    }

    public static Object y(f fVar) {
        e eVar = new e(fVar);
        if (eVar.hasNext()) {
            return eVar.next();
        }
        return null;
    }

    public static h z(Sequence sequence, Function1 transform) {
        kotlin.jvm.internal.h.f(transform, "transform");
        return new h(sequence, transform, r.f3793a);
    }
}
