package m0;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: renamed from: m0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0630a {
    public static final int[] i = new int[3];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f4020j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f4021k = new int[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f4022l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f4023a;
    public final Paint b;
    public final Paint c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f4025g = new Path();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f4026h;

    public C0630a(int i3) {
        Paint paint = new Paint();
        this.f4026h = paint;
        this.f4023a = new Paint();
        a(i3);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint2);
    }

    public final void a(int i3) {
        this.d = ColorUtils.setAlphaComponent(i3, 68);
        this.e = ColorUtils.setAlphaComponent(i3, 20);
        this.f4024f = ColorUtils.setAlphaComponent(i3, 0);
        this.f4023a.setColor(this.d);
    }
}
