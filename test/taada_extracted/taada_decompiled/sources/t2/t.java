package t2;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends AbstractC0825g implements JavaClassObjectAnnotationArgument {
    public final Class b;

    public t(L2.f fVar, Class cls) {
        super(fVar);
        this.b = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument
    public final JavaType getReferencedType() {
        Class cls = this.b;
        return cls.isPrimitive() ? new D(cls) : ((cls instanceof GenericArrayType) || cls.isArray()) ? new j(cls) : cls instanceof WildcardType ? new I((WildcardType) cls) : new u(cls);
    }
}
