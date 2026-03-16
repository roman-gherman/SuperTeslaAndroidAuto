package E1;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.q;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ObjectConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f291a;
    public String b;

    public /* synthetic */ h(int i) {
        this.f291a = i;
    }

    public static String c(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                Log.e("PlayCore", "Unable to format ".concat(String.valueOf(str2)), e);
                str2 = str2 + " [" + TextUtils.join(", ", objArr) + "]";
            }
        }
        return B2.b.f(str, " : ", str2);
    }

    public void a(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            c(this.b, str, objArr);
        }
    }

    public void b(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            Log.w("PlayCore", c(this.b, str, objArr));
        }
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f291a) {
            case 4:
                throw new q(this.b);
            case 5:
                throw new q(this.b);
            case 6:
                throw new q(this.b);
            case 7:
                throw new q(this.b);
            default:
                throw new q(this.b);
        }
    }

    public String toString() {
        switch (this.f291a) {
            case 0:
                return B2.b.h(new StringBuilder("Phase('"), this.b, "')");
            case 9:
                return androidx.constraintlayout.core.motion.a.s(new StringBuilder("<"), this.b, '>');
            default:
                return super.toString();
        }
    }

    public /* synthetic */ h(h hVar) {
        this.f291a = 3;
        this.b = hVar.b;
    }

    public /* synthetic */ h(String str, int i) {
        this.f291a = i;
        this.b = str;
    }

    public h(String str) {
        this.f291a = 10;
        this.b = ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ").concat(str);
    }
}
