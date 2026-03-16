package R0;

import C0.t;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import c4.AbstractC0246d;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1246a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f1249h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f1250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f1252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final X0.a f1253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ h f1254n;

    public e(h hVar, String str) {
        this.f1254n = hVar;
        this.c = "https://track.tenjin.com/v0/event";
        this.f1246a = "eventName";
        this.b = str;
        this.d = str;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) throws Throwable {
        String str = this.c;
        String str2 = this.f1251k;
        try {
            String str3 = this.d;
            if (str3 == null) {
                str3 = "";
            }
            Map map = this.f1252l;
            h hVar = this.f1254n;
            Map mapA = map == null ? h.a(hVar) : map;
            if (map == null) {
                try {
                    mapA.put(NotificationCompat.CATEGORY_EVENT, str3);
                } catch (Exception unused) {
                    return Boolean.FALSE;
                }
            }
            if (str.equals("https://track.tenjin.com/v0/purchase")) {
                mapA.put("currency", this.f1247f);
                mapA.put("product_id", this.e);
                mapA.put("quantity", String.valueOf(this.f1248g));
                mapA.put("price", String.valueOf(this.f1249h));
                String str4 = this.f1250j;
                if (str4 != null) {
                    mapA.put("signature", str4);
                }
                String str5 = this.i;
                if (str5 != null) {
                    mapA.put("receipt", str5);
                }
            }
            TextUtils.isEmpty(str2);
            StringBuilder sb = new StringBuilder();
            sb.append("Basic ");
            String str6 = hVar.f1261f;
            Context context = hVar.e;
            sb.append(Base64.encodeToString(str6.getBytes(), 10));
            String string = sb.toString();
            HashMap map2 = new HashMap();
            map2.put("Authorization", string);
            Pair pairO = AbstractC0246d.o(str, mapA, map2);
            t tVar = new t(context);
            SharedPreferences sharedPreferences = (SharedPreferences) tVar.d;
            boolean zBooleanValue = ((Boolean) pairO.first).booleanValue();
            X0.a aVar = this.f1253m;
            if (zBooleanValue && sharedPreferences.getBoolean("TENJIN_EVENT_CACHE_ENABLED", false) && aVar != null) {
                ((ExecutorService) tVar.c).execute(new X0.f(tVar, aVar, 0));
            } else if (!((Boolean) pairO.first).booleanValue() && ((Boolean) pairO.second).booleanValue() && sharedPreferences.getBoolean("TENJIN_EVENT_CACHE_ENABLED", false) && aVar == null) {
                X0.a aVar2 = new X0.a();
                aVar2.c = new Date();
                aVar2.d = str;
                aVar2.b = mapA;
                t tVar2 = new t(context);
                ((ExecutorService) tVar2.c).execute(new X0.g(tVar2, aVar2.b, new d(0, tVar2, aVar2), 0));
            }
            return (Boolean) pairO.first;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        String str;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        h hVar = this.f1254n;
        if (zBooleanValue || this.f1253m != null) {
            String str2 = this.b;
            hVar.u(str2);
            hVar.t(str2);
            return;
        }
        hVar.getClass();
        String str3 = this.f1246a;
        str3.getClass();
        str = this.d;
        switch (str3) {
            case "eventNameValue":
                hVar.h(str);
                break;
            case "eventNameTransactionData":
                hVar.g(this.e, this.f1247f, this.f1248g, this.f1249h, this.i, this.f1250j);
                break;
            case "eventNameIntValue":
                hVar.i(str);
                break;
            case "eventName":
                hVar.e(str);
                break;
            case "eventNameTransaction":
                hVar.f(this.e, this.f1247f, this.f1248g, this.f1249h);
                break;
        }
    }

    public e(h hVar, String str, int i) {
        this.f1254n = hVar;
        this.c = "https://track.tenjin.com/v0/event";
        this.f1246a = "eventNameValue";
        this.b = l.B(str);
        this.d = str;
    }

    public e(h hVar, String str, Object obj) {
        this.f1254n = hVar;
        this.c = "https://track.tenjin.com/v0/event";
        this.f1246a = "eventNameIntValue";
        this.b = l.A(0, str);
        this.d = str;
    }

    public e(h hVar, String str, String str2, int i, double d) {
        this.f1254n = hVar;
        this.c = "https://track.tenjin.com/v0/event";
        this.f1246a = "eventNameTransaction";
        this.b = l.D(str, str2, i, d);
        this.c = "https://track.tenjin.com/v0/purchase";
        this.e = str;
        this.f1247f = str2;
        this.f1248g = i;
        this.f1249h = d;
    }

    public e(h hVar, String str, String str2, int i, double d, String str3, String str4) {
        this.f1254n = hVar;
        this.c = "https://track.tenjin.com/v0/event";
        this.f1246a = "eventNameTransactionData";
        this.b = l.E(str, str2, i, d);
        this.c = "https://track.tenjin.com/v0/purchase";
        this.e = str;
        this.f1247f = str2;
        this.f1248g = i;
        this.f1249h = d;
        this.i = str3;
        this.f1250j = str4;
    }

    public e(h hVar, String str, B2.b bVar) {
        this.f1254n = hVar;
        this.c = "https://track.tenjin.com/v0/event";
        switch (str) {
            case "ironsource":
                this.f1246a = "eventAdImpressionDataIronSource";
                this.c = "https://track.tenjin.com/v0/ad_impressions/ironsource";
                break;
            case "hyperbid":
                this.f1246a = "eventAdImpressionDataHyperBid";
                this.c = "https://track.tenjin.com/v0/ad_impressions/hyperbid";
                break;
            case "cas":
                this.f1246a = "eventAdImpressionDataCAS";
                this.c = "https://track.tenjin.com/v0/ad_impressions/cas";
                break;
            case "admob":
                this.f1246a = "eventAdImpressionDataAdMob";
                this.c = "https://track.tenjin.com/v0/ad_impressions/admob";
                break;
            case "topon":
                this.f1246a = "eventAdImpressionDataTopOn";
                this.c = "https://track.tenjin.com/v0/ad_impressions/topon";
                break;
            case "applovin":
                this.f1246a = "eventAdImpressionDataAppLovin";
                this.c = "https://track.tenjin.com/v0/ad_impressions/max";
                break;
            case "tradplus":
                this.f1246a = "eventAdImpressionDataTradPlus";
                this.c = "https://track.tenjin.com/v0/ad_impressions/tradplus";
                break;
            default:
                this.f1246a = "eventAdImpressionData";
                this.c = "https://track.tenjin.com/v0/ad_impression";
                break;
        }
        this.f1251k = str;
        this.b = l.C(str, hVar.f1262g);
    }

    public e(h hVar, X0.a aVar) {
        this.f1254n = hVar;
        this.f1252l = aVar.b;
        this.c = aVar.d;
        this.f1253m = aVar;
        this.b = Integer.toString(aVar.f1405a);
    }
}
