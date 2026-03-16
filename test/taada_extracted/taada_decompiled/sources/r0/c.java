package R0;

import C0.t;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Base64;
import c4.AbstractC0246d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f1244a;
    public final /* synthetic */ h b;

    public c(h hVar) {
        this.b = hVar;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        Boolean boolValueOf;
        boolean zN = false;
        try {
            String str = "Basic " + Base64.encodeToString(this.b.f1261f.getBytes(), 10);
            HashMap map = new HashMap();
            map.put("Authorization", str);
            t tVar = this.b.f1263h;
            if (tVar != null) {
                ((AtomicBoolean) tVar.e).get();
            }
            synchronized (this.b.c) {
                Map mapA = h.a(this.b);
                this.f1244a = mapA;
                zN = AbstractC0246d.n("https://track.tenjin.com/v0/event", mapA, map);
                boolValueOf = Boolean.valueOf(zN);
            }
            return boolValueOf;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.valueOf(zN);
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Map map;
        Boolean bool = (Boolean) obj;
        if (bool.booleanValue() && (map = this.f1244a) != null && map.containsKey("referrer")) {
            SharedPreferences sharedPreferences = this.b.e.getSharedPreferences("tenjinInstallPreferences", 0);
            if (!sharedPreferences.getBoolean("tenjinInstallReferrerSent", false)) {
                sharedPreferences.edit().putBoolean("tenjinInstallReferrerSent", true).apply();
            }
        }
        AtomicBoolean atomicBoolean = h.f1258p;
        synchronized (atomicBoolean) {
            atomicBoolean.set(bool.booleanValue());
        }
        this.b.f1268n = null;
        if (bool.booleanValue()) {
            h hVar = this.b;
            synchronized (hVar.f1266l) {
                try {
                    Iterator it = hVar.f1266l.entrySet().iterator();
                    while (it.hasNext()) {
                        T0.a aVar = (T0.a) ((Map.Entry) it.next()).getValue();
                        String str = aVar.f1300a;
                        if (str.equals("eventName")) {
                            hVar.t(aVar.b);
                            hVar.l(aVar.b);
                        } else if (str.equals("eventNameValue")) {
                            hVar.t(l.B(aVar.b));
                            hVar.m(aVar.b);
                        } else if (str.equals("eventNameIntValue")) {
                            hVar.t(l.A(0, aVar.b));
                            hVar.n(aVar.b);
                        } else if (str.equals("eventNameTransaction")) {
                            hVar.t(l.D(aVar.c, aVar.d, aVar.e, aVar.f1301f));
                            hVar.w(aVar.c, aVar.d, aVar.e, aVar.f1301f);
                        } else if (str.equals("eventNameTransactionData")) {
                            hVar.t(l.E(aVar.c, aVar.d, aVar.e, aVar.f1301f));
                            hVar.x(aVar.c, aVar.d, aVar.e, aVar.f1301f, aVar.f1302g, aVar.f1303h);
                        } else {
                            if (str.equals("eventNameTransactionAmazon")) {
                                String str2 = aVar.c;
                                String str3 = aVar.d;
                                int i = aVar.e;
                                double d = aVar.f1301f;
                                String str4 = aVar.f1302g;
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append(".");
                                sb.append(str3);
                                sb.append(".");
                                sb.append(Integer.toString(i));
                                sb.append(".");
                                sb.append(Double.toString(d));
                                hVar.t(B2.b.h(sb, ".null.null.", str4));
                                throw null;
                            }
                            if (str.equals("eventGetDeeplink")) {
                                hVar.t("eventGetDeeplink");
                                hVar.o("eventGetDeeplink");
                            } else if (str.equals("eventGetAttributionInfo")) {
                                hVar.t("eventGetAttributionInfo");
                                hVar.o("eventGetAttributionInfo");
                            } else if (str.equals("eventAdImpressionDataAppLovin")) {
                                hVar.t(l.C(null, hVar.f1262g));
                                if (hVar.s()) {
                                    hVar.k("applovin");
                                }
                            } else if (str.equals("eventAdImpressionDataIronSource")) {
                                hVar.t(l.C(null, hVar.f1262g));
                                if (hVar.s()) {
                                    hVar.k("ironsource");
                                }
                            } else if (str.equals("eventAdImpressionDataHyperBid")) {
                                hVar.t(l.C(null, hVar.f1262g));
                                if (hVar.s()) {
                                    hVar.k("hyperbid");
                                }
                            } else if (str.equals("eventAdImpressionDataAdMob")) {
                                hVar.t(l.C(null, hVar.f1262g));
                                if (hVar.s()) {
                                    hVar.k("admob");
                                }
                            } else if (str.equals("eventAdImpressionDataTopOn")) {
                                hVar.t(l.C(null, hVar.f1262g));
                                if (hVar.s()) {
                                    hVar.k("topon");
                                }
                            } else {
                                str.equals("eventAdImpressionData");
                                if (str.equals("requestConversionUpdate")) {
                                    hVar.t(aVar.b);
                                    hVar.y();
                                }
                            }
                        }
                    }
                    hVar.f1266l.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
