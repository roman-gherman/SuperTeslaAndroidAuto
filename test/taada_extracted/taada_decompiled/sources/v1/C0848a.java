package v1;

import io.ktor.utils.io.jvm.javaio.l;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: v1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0848a extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0848a f4924a = new C0848a(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        try {
            ThreadLocal threadLocal = l.f3607a;
            return l.class.getMethod("isParkingAllowed", new Class[0]);
        } catch (Throwable unused) {
            return null;
        }
    }
}
