package B0;

import android.content.Context;
import android.preference.PreferenceManager;
import com.google.crypto.tink.e;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f118a;

    public b(a aVar) {
        Context context = (Context) aVar.b;
        String str = (String) aVar.f115a;
        String str2 = (String) aVar.c;
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            applicationContext.getSharedPreferences(str2, 0).edit();
        }
        this.f118a = (e) aVar.f117g;
    }
}
