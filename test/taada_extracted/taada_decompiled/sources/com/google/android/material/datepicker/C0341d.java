package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import fr.sd.taada.R;
import k0.AbstractC0572b;
import k0.AbstractC0573c;

/* JADX INFO: renamed from: com.google.android.material.datepicker.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0341d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0340c f2415a;
    public final C0340c b;
    public final C0340c c;
    public final C0340c d;
    public final C0340c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0340c f2416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0340c f2417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f2418h;

    public C0341d(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0572b.c(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()).data, V.a.f1361o);
        this.f2415a = C0340c.a(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        this.f2417g = C0340c.a(context, typedArrayObtainStyledAttributes.getResourceId(1, 0));
        this.b = C0340c.a(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        this.c = C0340c.a(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
        ColorStateList colorStateListA = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 6);
        this.d = C0340c.a(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
        this.e = C0340c.a(context, typedArrayObtainStyledAttributes.getResourceId(7, 0));
        this.f2416f = C0340c.a(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        Paint paint = new Paint();
        this.f2418h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
