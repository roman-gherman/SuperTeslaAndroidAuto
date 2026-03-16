package e0;

import android.util.Property;
import com.google.android.material.circularreveal.CircularRevealWidget;

/* JADX INFO: renamed from: e0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0422a extends Property {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0422a f3128a = new C0422a(Integer.class, "circularRevealScrimColor");

    @Override // android.util.Property
    public final Object get(Object obj) {
        return Integer.valueOf(((CircularRevealWidget) obj).getCircularRevealScrimColor());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((CircularRevealWidget) obj).setCircularRevealScrimColor(((Integer) obj2).intValue());
    }
}
