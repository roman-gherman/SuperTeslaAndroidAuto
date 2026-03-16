package O;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1176a;

    static {
        f1176a = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
