package R0;

import C0.t;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.CoroutineLiveDataKt;
import c4.AbstractC0246d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1255a;
    public final /* synthetic */ h b;

    public /* synthetic */ f(h hVar, int i) {
        this.f1255a = i;
        this.b = hVar;
    }

    public String a() throws Throwable {
        h hVar = this.b;
        Map mapA = h.a(hVar);
        mapA.put("api_key", hVar.f1261f);
        String strS = AbstractC0246d.S(mapA);
        if (strS != null) {
            HashMap map = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(strS);
                if (jSONObject.length() > 0) {
                    map.put("ad_network", jSONObject.optString("ad_network", null));
                    map.put("campaign_name", jSONObject.optString("campaign_name", null));
                    map.put("campaign_id", jSONObject.optString("campaign_id", null));
                    map.put("advertising_id", jSONObject.optString("advertising_id", null));
                    map.put("creative_name", jSONObject.optString("creative_name", null));
                    map.put("site_id", jSONObject.optString("site_id", null));
                    map.put("remote_campaign_id", jSONObject.optString("remote_campaign_id", null));
                    hVar.f1267m = map;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Handler(Looper.getMainLooper()).post(new b(hVar, 2));
        }
        return strS;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) throws Throwable {
        switch (this.f1255a) {
            case 0:
                int i = 0;
                String strA = null;
                while (i < 5) {
                    i++;
                    try {
                        t tVar = this.b.f1263h;
                        if (tVar == null ? false : ((AtomicBoolean) tVar.e).get()) {
                            strA = a();
                        }
                        if (strA == null || strA.replaceAll("[\\s]+", "").equals("{}")) {
                            Thread.sleep(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return null;
                    }
                    break;
                }
                break;
            default:
                h hVar = this.b;
                SharedPreferences sharedPreferences = hVar.e.getSharedPreferences("tenjinInstallPreferences", 0);
                boolean z6 = sharedPreferences.getBoolean("tenjinFirstLaunchKey", true);
                t tVar2 = hVar.f1263h;
                boolean z7 = tVar2 == null ? false : ((AtomicBoolean) tVar2.e).get();
                String str = hVar.f1261f;
                if (z7) {
                    if (z6) {
                        sharedPreferences.edit().putBoolean("tenjinFirstLaunchKey", false).commit();
                    }
                    Map mapA = h.a(hVar);
                    mapA.put("api_key", str);
                    String strS = AbstractC0246d.S(mapA);
                    if (strS != null) {
                        h.b(hVar, strS, z6);
                    }
                } else {
                    try {
                        Thread.sleep(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                        if (z6) {
                            sharedPreferences.edit().putBoolean("tenjinFirstLaunchKey", false).commit();
                        }
                        Map mapA2 = h.a(hVar);
                        mapA2.put("api_key", str);
                        String strS2 = AbstractC0246d.S(mapA2);
                        if (strS2 != null) {
                            h.b(hVar, strS2, z6);
                        }
                    } catch (InterruptedException e6) {
                        e6.printStackTrace();
                        return null;
                    }
                }
                break;
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        switch (this.f1255a) {
            case 0:
                h.c(this.b, (String) obj, "eventGetAttributionInfo");
                break;
            default:
                h.c(this.b, (String) obj, "eventGetDeeplink");
                break;
        }
    }
}
