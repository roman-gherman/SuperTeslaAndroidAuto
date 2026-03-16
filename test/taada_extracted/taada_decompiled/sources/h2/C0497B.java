package h2;

import kotlin.jvm.functions.Function2;
import n2.AbstractC0713e;
import n2.AbstractC0714f;

/* JADX INFO: renamed from: h2.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0497B extends kotlin.jvm.internal.i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0497B f3362a = new C0497B(2);

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        Integer numB = AbstractC0713e.b((AbstractC0714f) obj, (AbstractC0714f) obj2);
        return Integer.valueOf(numB == null ? 0 : numB.intValue());
    }
}
