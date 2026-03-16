package h5;

import h1.C0494b;
import java.io.Serializable;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3458a;
    public Serializable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, int i) {
        super(str);
        this.f3458a = i;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        switch (this.f3458a) {
            case 0:
                return (Exception) this.b;
            case 1:
                return (Exception) this.b;
            case 2:
                return (Exception) this.b;
            default:
                return super.getCause();
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        switch (this.f3458a) {
            case 3:
                return (String) this.b;
            default:
                return super.getMessage();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, Exception exc) {
        super(str);
        this.f3458a = 2;
        this.b = exc;
    }

    public a(C0494b call) {
        this.f3458a = 3;
        h.f(call, "call");
        this.b = "Response already received: " + call;
    }
}
