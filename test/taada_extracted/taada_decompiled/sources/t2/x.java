package t2;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends AbstractC0825g implements JavaEnumValueAnnotationArgument {
    public final Enum b;

    public x(L2.f fVar, Enum r22) {
        super(fVar);
        this.b = r22;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    public final L2.f getEntryName() {
        return L2.f.e(this.b.name());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    public final L2.b getEnumClassId() {
        Class<?> enumClass = this.b.getClass();
        if (!enumClass.isEnum()) {
            enumClass = enumClass.getEnclosingClass();
        }
        kotlin.jvm.internal.h.e(enumClass, "enumClass");
        return AbstractC0823e.a(enumClass);
    }
}
