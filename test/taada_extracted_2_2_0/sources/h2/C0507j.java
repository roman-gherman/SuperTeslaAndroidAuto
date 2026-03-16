package h2;

import java.lang.reflect.Field;
import t2.AbstractC0823e;

/* JADX INFO: renamed from: h2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0507j extends s0 {
    public final Field b;

    public C0507j(Field field) {
        kotlin.jvm.internal.h.f(field, "field");
        this.b = field;
    }

    @Override // h2.s0
    public final String c() {
        StringBuilder sb = new StringBuilder();
        Field field = this.b;
        String name = field.getName();
        kotlin.jvm.internal.h.e(name, "field.name");
        sb.append(w2.C.a(name));
        sb.append("()");
        Class<?> type = field.getType();
        kotlin.jvm.internal.h.e(type, "field.type");
        sb.append(AbstractC0823e.b(type));
        return sb.toString();
    }
}
