package V1;

import C5.f;
import java.io.Serializable;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f1370a;

    public b(Enum[] entries) {
        h.f(entries, "entries");
        Class<?> componentType = entries.getClass().getComponentType();
        h.c(componentType);
        this.f1370a = componentType;
    }

    private final Object readResolve() {
        Object[] enumConstants = this.f1370a.getEnumConstants();
        h.e(enumConstants, "c.enumConstants");
        return f.w((Enum[]) enumConstants);
    }
}
