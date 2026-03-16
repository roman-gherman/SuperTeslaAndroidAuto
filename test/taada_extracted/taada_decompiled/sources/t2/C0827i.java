package t2;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;

/* JADX INFO: renamed from: t2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0827i extends AbstractC0825g implements JavaArrayAnnotationArgument {
    public final Object[] b;

    public C0827i(L2.f fVar, Object[] objArr) {
        super(fVar);
        this.b = objArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    public final List getElements() {
        Object[] objArr = this.b;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            kotlin.jvm.internal.h.c(obj);
            Class<?> cls = obj.getClass();
            List list = AbstractC0823e.f4804a;
            arrayList.add(Enum.class.isAssignableFrom(cls) ? new x(null, (Enum) obj) : obj instanceof Annotation ? new C0826h(null, (Annotation) obj) : obj instanceof Object[] ? new C0827i(null, (Object[]) obj) : obj instanceof Class ? new t(null, (Class) obj) : new z(null, obj));
        }
        return arrayList;
    }
}
