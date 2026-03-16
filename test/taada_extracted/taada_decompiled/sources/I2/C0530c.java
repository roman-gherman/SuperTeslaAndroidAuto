package i2;

import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: renamed from: i2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0530c extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0530c f3468a = new C0530c(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String string;
        Map.Entry entry = (Map.Entry) obj;
        kotlin.jvm.internal.h.f(entry, "entry");
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            string = Arrays.toString((boolean[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else if (value instanceof char[]) {
            string = Arrays.toString((char[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else if (value instanceof byte[]) {
            string = Arrays.toString((byte[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else if (value instanceof short[]) {
            string = Arrays.toString((short[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else if (value instanceof int[]) {
            string = Arrays.toString((int[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else if (value instanceof float[]) {
            string = Arrays.toString((float[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else if (value instanceof long[]) {
            string = Arrays.toString((long[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else if (value instanceof double[]) {
            string = Arrays.toString((double[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else if (value instanceof Object[]) {
            string = Arrays.toString((Object[]) value);
            kotlin.jvm.internal.h.e(string, "toString(this)");
        } else {
            string = value.toString();
        }
        return str + SignatureVisitor.INSTANCEOF + string;
    }
}
