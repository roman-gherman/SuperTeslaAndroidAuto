package u1;

import kotlin.jvm.functions.Function1;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: renamed from: u1.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0833B extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0833B f4846a = new C0833B(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1.e it = (N1.e) obj;
        kotlin.jvm.internal.h.f(it, "it");
        String str = (String) it.f1121a;
        Object obj2 = it.b;
        if (obj2 == null) {
            return str;
        }
        return str + SignatureVisitor.INSTANCEOF + String.valueOf(obj2);
    }
}
