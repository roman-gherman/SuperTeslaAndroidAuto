package androidx.fragment.app;

import N1.m;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs$CastExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001aQ\u0010\u000f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000126\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "requestKey", "Landroid/os/Bundle;", "result", "LN1/m;", "setFragmentResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Landroid/os/Bundle;)V", "clearFragmentResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bundle", ServiceSpecificExtraArgs$CastExtraArgs.LISTENER, "setFragmentResultListener", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "clearFragmentResultListener", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String requestKey) {
        kotlin.jvm.internal.h.f(fragment, "<this>");
        kotlin.jvm.internal.h.f(requestKey, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(requestKey);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String requestKey) {
        kotlin.jvm.internal.h.f(fragment, "<this>");
        kotlin.jvm.internal.h.f(requestKey, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(requestKey);
    }

    public static final void setFragmentResult(Fragment fragment, String requestKey, Bundle result) {
        kotlin.jvm.internal.h.f(fragment, "<this>");
        kotlin.jvm.internal.h.f(requestKey, "requestKey");
        kotlin.jvm.internal.h.f(result, "result");
        fragment.getParentFragmentManager().setFragmentResult(requestKey, result);
    }

    public static final void setFragmentResultListener(Fragment fragment, String requestKey, Function2<? super String, ? super Bundle, m> listener) {
        kotlin.jvm.internal.h.f(fragment, "<this>");
        kotlin.jvm.internal.h.f(requestKey, "requestKey");
        kotlin.jvm.internal.h.f(listener, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(requestKey, fragment, new R0.a(listener, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFragmentResultListener$lambda$0(Function2 tmp0, String p02, Bundle p12) {
        kotlin.jvm.internal.h.f(tmp0, "$tmp0");
        kotlin.jvm.internal.h.f(p02, "p0");
        kotlin.jvm.internal.h.f(p12, "p1");
        tmp0.mo5invoke(p02, p12);
    }
}
