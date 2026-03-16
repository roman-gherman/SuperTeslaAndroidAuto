package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/core/view/Api16Impl;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/view/View;", "view", "Ljava/lang/Runnable;", "action", "", "delayInMillis", "LN1/m;", "postOnAnimationDelayed", "(Landroid/view/View;Ljava/lang/Runnable;J)V", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api16Impl {
    public static final Api16Impl INSTANCE = new Api16Impl();

    private Api16Impl() {
    }

    @JvmStatic
    public static final void postOnAnimationDelayed(View view, Runnable action, long delayInMillis) {
        view.postOnAnimationDelayed(action, delayInMillis);
    }
}
