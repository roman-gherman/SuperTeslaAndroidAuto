package A;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class a extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public a(Status status) {
        int i = status.f1928a;
        String str = status.b;
        super(i + ": " + (str == null ? "" : str));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String message, int i) {
        super(message);
        switch (i) {
            case 7:
                kotlin.jvm.internal.h.f(message, "message");
                super(message);
                break;
            default:
                kotlin.jvm.internal.h.f(message, "message");
                break;
        }
    }
}
