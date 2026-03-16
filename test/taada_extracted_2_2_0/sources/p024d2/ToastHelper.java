package p024d2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.widget.Toast;
import androidx.preference.PreferenceManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class ToastHelper {
    public static void m3593b(String str, Context context, boolean z6) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (z6 || !defaultSharedPreferences.getBoolean("disable_notifications", false)) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    public static void showToast(String str, Context context) {
        m3593b(str, context, false);
    }
}
