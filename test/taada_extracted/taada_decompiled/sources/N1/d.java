package N1;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Error {
    public d() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String message, int i) {
        super(message);
        switch (i) {
            case 2:
                kotlin.jvm.internal.h.f(message, "message");
                super(message);
                break;
            default:
                kotlin.jvm.internal.h.f(message, "message");
                break;
        }
    }
}
