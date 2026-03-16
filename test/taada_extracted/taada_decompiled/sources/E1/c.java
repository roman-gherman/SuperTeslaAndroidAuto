package E1;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f286a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, int i) {
        super(str);
        this.f286a = i;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        switch (this.f286a) {
            case 1:
                synchronized (this) {
                }
                return this;
            case 2:
                synchronized (this) {
                }
                return this;
            case 3:
                synchronized (this) {
                }
                return this;
            default:
                return super.fillInStackTrace();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String message) {
        super(message);
        this.f286a = 0;
        kotlin.jvm.internal.h.f(message, "message");
    }
}
