package S1;

import N1.m;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements CoroutineContext, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f1280a;
    public final CoroutineContext.Element b;

    public e(CoroutineContext.Element element, CoroutineContext left) {
        h.f(left, "left");
        h.f(element, "element");
        this.f1280a = left;
        this.b = element;
    }

    private final Object writeReplace() {
        int iA = a();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[iA];
        t tVar = new t();
        fold(m.f1129a, new N2.b(1, coroutineContextArr, tVar));
        if (tVar.f3815a == iA) {
            return new c(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int a() {
        int i = 2;
        e eVar = this;
        while (true) {
            CoroutineContext coroutineContext = eVar.f1280a;
            eVar = coroutineContext instanceof e ? (e) coroutineContext : null;
            if (eVar == null) {
                return i;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.a() == a()) {
                e eVar2 = this;
                while (true) {
                    CoroutineContext.Element element = eVar2.b;
                    if (!h.a(eVar.get(element.getKey()), element)) {
                        zA = false;
                        break;
                    }
                    CoroutineContext coroutineContext = eVar2.f1280a;
                    if (!(coroutineContext instanceof e)) {
                        h.d(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext;
                        zA = h.a(eVar.get(element2.getKey()), element2);
                        break;
                    }
                    eVar2 = (e) coroutineContext;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 operation) {
        h.f(operation, "operation");
        return operation.mo5invoke(this.f1280a.fold(obj, operation), this.b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        h.f(key, "key");
        e eVar = this;
        while (true) {
            CoroutineContext.Element element = eVar.b.get(key);
            if (element != null) {
                return element;
            }
            CoroutineContext coroutineContext = eVar.f1280a;
            if (!(coroutineContext instanceof e)) {
                return coroutineContext.get(key);
            }
            eVar = (e) coroutineContext;
        }
    }

    public final int hashCode() {
        return this.b.hashCode() + this.f1280a.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        h.f(key, "key");
        CoroutineContext.Element element = this.b;
        CoroutineContext.Element element2 = element.get(key);
        CoroutineContext coroutineContext = this.f1280a;
        if (element2 != null) {
            return coroutineContext;
        }
        CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(key);
        return coroutineContextMinusKey == coroutineContext ? this : coroutineContextMinusKey == g.f1282a ? element : new e(element, coroutineContextMinusKey);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        h.f(context, "context");
        return context == g.f1282a ? this : (CoroutineContext) context.fold(this, d.c);
    }

    public final String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("["), (String) fold("", d.b), ']');
    }
}
