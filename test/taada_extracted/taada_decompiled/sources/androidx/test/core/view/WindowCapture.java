package androidx.test.core.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.test.core.internal.os.HandlerExecutor;
import androidx.test.platform.graphics.HardwareRendererCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\n\u001a\u00020\t*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\r\u001a\u00020\t*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/view/Window;", "Landroid/graphics/Rect;", "boundsInWindow", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroid/graphics/Bitmap;", "captureRegionToBitmap", "(Landroid/view/Window;Landroid/graphics/Rect;)Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/concurrent/futures/ResolvableFuture;", "bitmapFuture", "LN1/m;", "generateBitmap", "(Landroid/view/Window;Landroid/graphics/Rect;Landroidx/concurrent/futures/ResolvableFuture;)V", "destBitmap", "generateBitmapFromPixelCopy", "(Landroid/view/Window;Landroid/graphics/Rect;Landroid/graphics/Bitmap;Landroidx/concurrent/futures/ResolvableFuture;)V", "androidx.test.core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WindowCapture {
    public static final ListenableFuture<Bitmap> captureRegionToBitmap(final Window window, final Rect rect) {
        h.f(window, "<this>");
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        h.e(resolvableFutureCreate, "create()");
        final HandlerExecutor handlerExecutor = new HandlerExecutor(new Handler(Looper.getMainLooper()));
        if (!HardwareRendererCompat.isDrawingEnabled()) {
            HardwareRendererCompat.setDrawingEnabled(true);
            resolvableFutureCreate.addListener(new Runnable() { // from class: androidx.test.core.view.WindowCapture.captureRegionToBitmap.1
                @Override // java.lang.Runnable
                public final void run() {
                    HardwareRendererCompat.setDrawingEnabled(false);
                }
            }, handlerExecutor);
        }
        handlerExecutor.execute(new Runnable() { // from class: androidx.test.core.view.WindowCapture.captureRegionToBitmap.2
            @Override // java.lang.Runnable
            public final void run() {
                View decorView = window.getDecorView();
                h.e(decorView, "decorView");
                ListenableFuture<Void> listenableFutureForceRedraw = ViewCapture.forceRedraw(decorView);
                final Window window2 = window;
                final Rect rect2 = rect;
                final ResolvableFuture<Bitmap> resolvableFuture = resolvableFutureCreate;
                listenableFutureForceRedraw.addListener(new Runnable() { // from class: androidx.test.core.view.WindowCapture.captureRegionToBitmap.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindowCapture.generateBitmap(window2, rect2, resolvableFuture);
                    }
                }, handlerExecutor);
            }
        });
        return resolvableFutureCreate;
    }

    public static /* synthetic */ ListenableFuture captureRegionToBitmap$default(Window window, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return captureRegionToBitmap(window, rect);
    }

    public static final void generateBitmap(Window window, Rect rect, ResolvableFuture<Bitmap> bitmapFuture) {
        h.f(window, "<this>");
        h.f(bitmapFuture, "bitmapFuture");
        Bitmap destBitmap = Bitmap.createBitmap(rect != null ? rect.width() : window.getDecorView().getWidth(), rect != null ? rect.height() : window.getDecorView().getHeight(), Bitmap.Config.ARGB_8888);
        h.e(destBitmap, "destBitmap");
        generateBitmapFromPixelCopy(window, rect, destBitmap, bitmapFuture);
    }

    public static /* synthetic */ void generateBitmap$default(Window window, Rect rect, ResolvableFuture resolvableFuture, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        generateBitmap(window, rect, resolvableFuture);
    }

    public static final void generateBitmapFromPixelCopy(Window window, Rect rect, final Bitmap destBitmap, final ResolvableFuture<Bitmap> bitmapFuture) {
        h.f(window, "<this>");
        h.f(destBitmap, "destBitmap");
        h.f(bitmapFuture, "bitmapFuture");
        PixelCopy.request(window, rect, destBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.test.core.view.WindowCapture$generateBitmapFromPixelCopy$onCopyFinished$1
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                if (i == 0) {
                    bitmapFuture.set(destBitmap);
                } else {
                    bitmapFuture.setException(new RuntimeException(String.format("PixelCopy failed: %d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1))));
                }
            }
        }, new Handler(Looper.getMainLooper()));
    }

    public static /* synthetic */ void generateBitmapFromPixelCopy$default(Window window, Rect rect, Bitmap bitmap, ResolvableFuture resolvableFuture, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        generateBitmapFromPixelCopy(window, rect, bitmap, resolvableFuture);
    }
}
