package androidx.core.animation;

import android.animation.Animator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs$CastExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/core/animation/Api19Impl;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator$AnimatorPauseListener;", ServiceSpecificExtraArgs$CastExtraArgs.LISTENER, "LN1/m;", "addPauseListener", "(Landroid/animation/Animator;Landroid/animation/Animator$AnimatorPauseListener;)V", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api19Impl {
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    @JvmStatic
    public static final void addPauseListener(Animator animator, Animator.AnimatorPauseListener listener) {
        animator.addPauseListener(listener);
    }
}
