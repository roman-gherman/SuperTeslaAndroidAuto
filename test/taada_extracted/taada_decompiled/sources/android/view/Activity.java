package android.view;

import N1.m;
import T1.a;
import android.view.View;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import p3.v;

/* JADX INFO: renamed from: androidx.activity.PipHintTrackerKt, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Landroid/app/Activity;", "Landroid/view/View;", "view", "LN1/m;", "trackPipAnimationHintView", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Activity {
    public static final Object trackPipAnimationHintView(final android.app.Activity activity, View view, Continuation<? super m> continuation) throws Throwable {
        Object objCollect = v.c(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new FlowCollector() { // from class: androidx.activity.PipHintTrackerKt.trackPipAnimationHintView.2
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((android.graphics.Rect) obj, (Continuation<? super m>) continuation2);
            }

            public final Object emit(android.graphics.Rect rect, Continuation<? super m> continuation2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return m.f1129a;
            }
        }, continuation);
        return objCollect == a.f1304a ? objCollect : m.f1129a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Rect trackPipAnimationHintView$positionInWindow(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
