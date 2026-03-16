package i2;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.y;
import kotlin.reflect.jvm.internal.calls.Caller;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r implements Caller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Member f3476a;
    public final Type b;
    public final Class c;
    public final List d;

    public r(Member member, Type type, Class cls, Type[] typeArr) {
        List listL;
        this.f3476a = member;
        this.b = type;
        this.c = cls;
        if (cls != null) {
            y yVar = new y(2);
            yVar.a(cls);
            yVar.b(typeArr);
            ArrayList arrayList = yVar.f3818a;
            listL = kotlin.collections.n.y(arrayList.toArray(new Type[arrayList.size()]));
        } else {
            listL = kotlin.collections.j.L(typeArr);
        }
        this.d = listL;
    }

    public void a(Object[] objArr) {
        kotlin.reflect.l.f(this, objArr);
    }

    public final void b(Object obj) {
        if (obj == null || !this.f3476a.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Member getMember() {
        return this.f3476a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final List getParameterTypes() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        return this.b;
    }
}
