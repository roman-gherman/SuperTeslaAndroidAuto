package i2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.jvm.internal.y;
import kotlin.reflect.jvm.internal.calls.BoundCaller;

/* JADX INFO: renamed from: i2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0531d extends r implements BoundCaller {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f3469f;

    /* JADX WARN: Illegal instructions before constructor call */
    public C0531d(Constructor constructor, Object obj, int i) {
        this.e = i;
        switch (i) {
            case 1:
                kotlin.jvm.internal.h.f(constructor, "constructor");
                Class declaringClass = constructor.getDeclaringClass();
                kotlin.jvm.internal.h.e(declaringClass, "constructor.declaringClass");
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                kotlin.jvm.internal.h.e(genericParameterTypes, "constructor.genericParameterTypes");
                super(constructor, declaringClass, null, genericParameterTypes);
                this.f3469f = obj;
                break;
            default:
                kotlin.jvm.internal.h.f(constructor, "constructor");
                Class declaringClass2 = constructor.getDeclaringClass();
                kotlin.jvm.internal.h.e(declaringClass2, "constructor.declaringClass");
                Type[] genericParameterTypes2 = constructor.getGenericParameterTypes();
                kotlin.jvm.internal.h.e(genericParameterTypes2, "constructor.genericParameterTypes");
                super(constructor, declaringClass2, null, (Type[]) (genericParameterTypes2.length <= 2 ? new Type[0] : kotlin.collections.j.x(genericParameterTypes2, 1, genericParameterTypes2.length - 1)));
                this.f3469f = obj;
                break;
        }
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Object call(Object[] args) {
        switch (this.e) {
            case 0:
                kotlin.jvm.internal.h.f(args, "args");
                kotlin.reflect.l.f(this, args);
                Constructor constructor = (Constructor) this.f3476a;
                y yVar = new y(3);
                yVar.a(this.f3469f);
                yVar.b(args);
                yVar.a(null);
                ArrayList arrayList = yVar.f3818a;
                return constructor.newInstance(arrayList.toArray(new Object[arrayList.size()]));
            default:
                kotlin.jvm.internal.h.f(args, "args");
                kotlin.reflect.l.f(this, args);
                Constructor constructor2 = (Constructor) this.f3476a;
                y yVar2 = new y(2);
                yVar2.a(this.f3469f);
                yVar2.b(args);
                ArrayList arrayList2 = yVar2.f3818a;
                return constructor2.newInstance(arrayList2.toArray(new Object[arrayList2.size()]));
        }
    }
}
