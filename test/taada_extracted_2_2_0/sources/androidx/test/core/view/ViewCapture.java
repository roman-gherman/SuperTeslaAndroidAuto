package androidx.test.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.test.core.internal.os.HandlerExecutor;
import androidx.test.platform.graphics.HardwareRendererCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\t\u0010\u0007\u001a!\u0010\r\u001a\u00020\f*\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a)\u0010\u0010\u001a\u00020\f*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a1\u0010\u0014\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0017\u001a\u00020\f*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroid/view/View;", "Landroid/app/Activity;", "getActivity", "(Landroid/view/View;)Landroid/app/Activity;", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroid/graphics/Bitmap;", "captureToBitmap", "(Landroid/view/View;)Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "forceRedraw", "Landroidx/concurrent/futures/ResolvableFuture;", "bitmapFuture", "LN1/m;", "generateBitmap", "(Landroid/view/View;Landroidx/concurrent/futures/ResolvableFuture;)V", "destBitmap", "generateBitmapFromDraw", "(Landroid/view/View;Landroid/graphics/Bitmap;Landroidx/concurrent/futures/ResolvableFuture;)V", "Landroid/view/Window;", "window", "generateBitmapFromPixelCopy", "(Landroid/view/View;Landroid/view/Window;Landroid/graphics/Bitmap;Landroidx/concurrent/futures/ResolvableFuture;)V", "Landroid/view/SurfaceView;", "generateBitmapFromSurfaceViewPixelCopy", "(Landroid/view/SurfaceView;Landroid/graphics/Bitmap;Landroidx/concurrent/futures/ResolvableFuture;)V", "androidx.test.core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewCapture {
    public static final ListenableFuture<Bitmap> captureToBitmap(final View view) {
        h.f(view, "<this>");
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        h.e(resolvableFutureCreate, "create()");
        final HandlerExecutor handlerExecutor = new HandlerExecutor(new Handler(Looper.getMainLooper()));
        if (!HardwareRendererCompat.isDrawingEnabled()) {
            HardwareRendererCompat.setDrawingEnabled(true);
            resolvableFutureCreate.addListener(new Runnable() { // from class: androidx.test.core.view.ViewCapture.captureToBitmap.1
                @Override // java.lang.Runnable
                public final void run() {
                    HardwareRendererCompat.setDrawingEnabled(false);
                }
            }, handlerExecutor);
        }
        handlerExecutor.execute(new Runnable() { // from class: androidx.test.core.view.ViewCapture.captureToBitmap.2
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFuture<Void> listenableFutureForceRedraw = ViewCapture.forceRedraw(view);
                final View view2 = view;
                final ResolvableFuture<Bitmap> resolvableFuture = resolvableFutureCreate;
                listenableFutureForceRedraw.addListener(new Runnable() { // from class: androidx.test.core.view.ViewCapture.captureToBitmap.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewCapture.generateBitmap(view2, resolvableFuture);
                    }
                }, handlerExecutor);
            }
        });
        return resolvableFutureCreate;
    }

    public static final ListenableFuture<Void> forceRedraw(final View view) {
        h.f(view, "<this>");
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        h.e(resolvableFutureCreate, "create()");
        if (Build.VERSION.SDK_INT < 29 || !view.isHardwareAccelerated()) {
            view.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() { // from class: androidx.test.core.view.ViewCapture.forceRedraw.2
                private boolean handled;

                public final boolean getHandled() {
                    return this.handled;
                }

                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    if (this.handled) {
                        return;
                    }
                    this.handled = true;
                    resolvableFutureCreate.set(null);
                    Handler handler = new Handler(Looper.getMainLooper());
                    final View view2 = view;
                    handler.post(new Runnable() { // from class: androidx.test.core.view.ViewCapture$forceRedraw$2$onDraw$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.getViewTreeObserver().removeOnDrawListener(this);
                        }
                    });
                }

                public final void setHandled(boolean z6) {
                    this.handled = z6;
                }
            });
        } else {
            view.getViewTreeObserver().registerFrameCommitCallback(new Runnable() { // from class: androidx.test.core.view.ViewCapture.forceRedraw.1
                @Override // java.lang.Runnable
                public final void run() {
                    resolvableFutureCreate.set(null);
                }
            });
        }
        view.invalidate();
        return resolvableFutureCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateBitmap(View view, ResolvableFuture<Bitmap> resolvableFuture) {
        if (resolvableFuture.isCancelled()) {
            return;
        }
        Bitmap destBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        if (view instanceof SurfaceView) {
            h.e(destBitmap, "destBitmap");
            generateBitmapFromSurfaceViewPixelCopy((SurfaceView) view, destBitmap, resolvableFuture);
            return;
        }
        Activity activity = getActivity(view);
        Window window = activity != null ? activity.getWindow() : null;
        if (window != null) {
            h.e(destBitmap, "destBitmap");
            generateBitmapFromPixelCopy(view, window, destBitmap, resolvableFuture);
        } else {
            h.e(destBitmap, "destBitmap");
            generateBitmapFromDraw(view, destBitmap, resolvableFuture);
        }
    }

    public static final void generateBitmapFromDraw(View view, Bitmap destBitmap, ResolvableFuture<Bitmap> bitmapFuture) {
        h.f(view, "<this>");
        h.f(destBitmap, "destBitmap");
        h.f(bitmapFuture, "bitmapFuture");
        destBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
        view.computeScroll();
        Canvas canvas = new Canvas(destBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        bitmapFuture.set(destBitmap);
    }

    private static final void generateBitmapFromPixelCopy(View view, Window window, Bitmap bitmap, ResolvableFuture<Bitmap> resolvableFuture) {
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i3 = iArr[1];
        WindowCapture.generateBitmapFromPixelCopy(window, new Rect(i, i3, view.getWidth() + i, view.getHeight() + i3), bitmap, resolvableFuture);
    }

    private static final void generateBitmapFromSurfaceViewPixelCopy(SurfaceView surfaceView, final Bitmap bitmap, final ResolvableFuture<Bitmap> resolvableFuture) {
        PixelCopy.request(surfaceView, (Rect) null, bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.test.core.view.ViewCapture$generateBitmapFromSurfaceViewPixelCopy$onCopyFinished$1
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                if (i == 0) {
                    resolvableFuture.set(bitmap);
                } else {
                    resolvableFuture.setException(new RuntimeException(String.format("PixelCopy failed: %d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1))));
                }
            }
        }, surfaceView.getHandler());
    }

    private static final Activity getActivity(View view) {
        Context context = view.getContext();
        h.e(context, "context");
        return getActivity$getActivity(context);
    }

    private static final Activity getActivity$getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        h.e(baseContext, "this.baseContext");
        return getActivity$getActivity(baseContext);
    }
}
