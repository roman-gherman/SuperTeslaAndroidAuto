package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/core/os/BundleApi18ImplKt;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/os/Bundle;", "bundle", "", "key", "Landroid/os/IBinder;", "value", "LN1/m;", "putBinder", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/IBinder;)V", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BundleApi18ImplKt {
    public static final BundleApi18ImplKt INSTANCE = new BundleApi18ImplKt();

    private BundleApi18ImplKt() {
    }

    @JvmStatic
    public static final void putBinder(Bundle bundle, String key, IBinder value) {
        bundle.putBinder(key, value);
    }
}
