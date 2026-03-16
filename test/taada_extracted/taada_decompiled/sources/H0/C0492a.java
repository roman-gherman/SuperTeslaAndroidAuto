package h0;

import android.content.Context;
import com.google.android.material.color.g;
import fr.sd.taada.R;
import k0.AbstractC0572b;

/* JADX INFO: renamed from: h0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0492a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3349f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3350a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public C0492a(Context context) {
        boolean zB = AbstractC0572b.b(context, R.attr.elevationOverlayEnabled, false);
        int iE = g.e(context, R.attr.elevationOverlayColor, 0);
        int iE2 = g.e(context, R.attr.elevationOverlayAccentColor, 0);
        int iE3 = g.e(context, R.attr.colorSurface, 0);
        float f6 = context.getResources().getDisplayMetrics().density;
        this.f3350a = zB;
        this.b = iE;
        this.c = iE2;
        this.d = iE3;
        this.e = f6;
    }
}
