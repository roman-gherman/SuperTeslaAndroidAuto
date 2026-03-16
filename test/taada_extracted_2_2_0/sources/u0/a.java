package U0;

import B.g;
import R0.h;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends V0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1309a;
    public final Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1309a = i;
        this.b = obj;
    }

    public static boolean a() {
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.startsWith(EnvironmentCompat.MEDIA_UNKNOWN)) {
            return true;
        }
        String str2 = Build.MODEL;
        if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }

    @Override // com.tenjin.android.params.base.ParamProvider
    public final Map apply(Map map) {
        String str;
        String string;
        String simOperatorName;
        NetworkInfo activeNetworkInfo;
        String string2;
        Object obj = this.b;
        switch (this.f1309a) {
            case 0:
                String str2 = "";
                Context context = (Context) obj;
                map.put("bundle_id", context.getPackageName());
                map.put("platform", "Amazon".equals(Build.MANUFACTURER) ? "amazon" : "android");
                int iX = 0;
                try {
                    str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    str = "";
                }
                map.put("app_version", str);
                try {
                    string = Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException e6) {
                    e6.printStackTrace();
                    string = "";
                }
                map.put("app_version_code", string);
                map.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
                map.put("device", String.valueOf(Build.DEVICE));
                map.put("device_manufacturer", String.valueOf(Build.MANUFACTURER));
                map.put("device_model", String.valueOf(Build.MODEL));
                map.put("device_brand", String.valueOf(Build.BRAND));
                map.put("device_product", String.valueOf(Build.PRODUCT));
                AtomicBoolean atomicBoolean = h.f1257o;
                try {
                    String string3 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("TENJIN_APP_STORE");
                    iX = B2.b.x(string3 == null ? "" : string3.toLowerCase().replaceAll("\\s", ""));
                } catch (Exception e7) {
                    Log.e("SourceAppStoreGetter", "Unable to load app store type from manifest: " + e7.getMessage());
                }
                if (iX == 0) {
                    iX = 1;
                }
                B2.b.w(iX);
                map.put("source_app_store", B2.b.w(iX));
                map.put("screen_width", String.valueOf(context.getResources().getDisplayMetrics().widthPixels));
                map.put("screen_height", String.valueOf(context.getResources().getDisplayMetrics().heightPixels));
                map.put("language", context.getResources().getConfiguration().locale.getLanguage().toString());
                map.put("country", context.getResources().getConfiguration().locale.getCountry().toString());
                map.put("os_version_release", String.valueOf(Build.VERSION.RELEASE));
                map.put("build_id", String.valueOf(Build.ID));
                try {
                    simOperatorName = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
                } catch (Exception e8) {
                    e8.printStackTrace();
                    simOperatorName = "";
                }
                map.put("carrier", simOperatorName);
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                        if (activeNetworkInfo.getType() == 1) {
                            str2 = "wifi";
                        } else if (activeNetworkInfo.getType() == 0) {
                            str2 = "mobile";
                        }
                    }
                } catch (Exception unused) {
                }
                map.put("connection_type", str2);
                map.put("timezone", TimeZone.getDefault().getID());
                map.put("locale", Locale.getDefault().toString());
                if (a()) {
                    map.put("device_info", String.valueOf(a()));
                }
                break;
            default:
                String str3 = h.q;
                map.put("sdk_version", (str3 == null || str3.isEmpty()) ? "1.14.0" : "1.14.0-".concat(str3));
                g gVar = (g) obj;
                if (((SharedPreferences) gVar.b).contains("tenjinReferenceId")) {
                    string2 = gVar.getString("tenjinReferenceId", null);
                    gVar.remove("tenjinReferenceId");
                    gVar.putString("analyticsInstallationId", string2);
                } else {
                    string2 = gVar.getString("analyticsInstallationId", null);
                }
                if (string2 == null) {
                    string2 = UUID.randomUUID().toString();
                    gVar.putString("analyticsInstallationId", string2);
                }
                map.put("analytics_installation_id", string2);
                break;
        }
        return map;
    }
}
