package t2;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends AbstractC0825g implements JavaLiteralAnnotationArgument {
    public final Object b;

    public z(L2.f fVar, Object obj) {
        super(fVar);
        this.b = obj;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument
    public final Object getValue() {
        return this.b;
    }
}
