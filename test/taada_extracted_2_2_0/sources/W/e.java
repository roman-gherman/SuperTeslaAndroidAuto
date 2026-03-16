package W;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e extends Property {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f1382a;

    static {
        e eVar = new e(Integer.class, "drawableAlphaCompat");
        new WeakHashMap();
        f1382a = eVar;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        return Integer.valueOf(((Drawable) obj).getAlpha());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ((Drawable) obj).setAlpha(((Integer) obj2).intValue());
    }
}
