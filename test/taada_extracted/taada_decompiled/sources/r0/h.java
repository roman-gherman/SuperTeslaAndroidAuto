package R0;

import C0.t;
import a.AbstractC0132a;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tenjin.android.Callback;
import com.tenjin.android.params.base.ParamProvider;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.reflect.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicBoolean f1257o = new AtomicBoolean(false);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicBoolean f1258p = new AtomicBoolean(false);
    public static final String q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static h f1259r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1260a;
    public final U0.d b;
    public final Object c;
    public final B.g d;
    public final Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t f1263h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f1264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f1265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f1266l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap f1267m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AsyncTask f1268n;

    static {
        new AtomicBoolean(false);
        q = "";
    }

    public h(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new U0.a(context, 0));
        arrayList.add(new U0.a(new B.g(context), 1));
        U0.d dVar = new U0.d();
        dVar.c = 5;
        dVar.f1312a = new String[0];
        dVar.b = new String[0];
        this.b = dVar;
        this.i = false;
        this.f1264j = 1000L;
        this.f1265k = Collections.synchronizedMap(new LinkedHashMap());
        this.f1266l = Collections.synchronizedMap(new LinkedHashMap());
        new HashMap();
        this.f1267m = new HashMap();
        this.f1268n = null;
        this.f1261f = str;
        this.c = new Object();
        this.f1262g = UUID.randomUUID().toString();
        this.d = new B.g(13);
        this.f1260a = arrayList;
        new Date().getTime();
        this.e = context.getApplicationContext();
    }

    public static Map a(h hVar) {
        hVar.getClass();
        return hVar.q(new HashMap());
    }

    public static void b(h hVar, String str, boolean z6) {
        hVar.getClass();
        AtomicBoolean atomicBoolean = f1257o;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                JSONArray jSONArrayNames = jSONObject.names();
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    map.put(jSONArrayNames.getString(i), jSONObject.getString(jSONArrayNames.getString(i)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        hVar.i = hVar.e.getSharedPreferences("tenjinInstallPreferences", 0).getBoolean("tenjinInstallReferrerSent", false);
        if (map.get("ad_network") != null) {
            hVar.i = !Objects.equals(map.get("ad_network"), "organic");
        }
        new Handler(Looper.getMainLooper()).post(new b(hVar, z6));
    }

    public static void c(h hVar, String str, String str2) {
        hVar.getClass();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (new JSONObject(str).length() > 0) {
                    hVar.u(str2);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        hVar.d(str2);
    }

    public static h p(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        if (f1259r == null) {
            f1259r = new h(context, str);
        }
        h hVar = f1259r;
        Context context2 = hVar.e;
        t tVar = new t(context2, new B.g(context2));
        hVar.f1263h = tVar;
        tVar.d = new B.g(hVar, 12);
        b bVar = new b(hVar, 0);
        if (AbstractC0132a.f1522a == null) {
            Z0.a aVar = new Z0.a("TenjinSDKThread", 10);
            aVar.start();
            AbstractC0132a.f1522a = aVar;
        }
        AbstractC0132a.f1522a.post(bVar);
        return f1259r;
    }

    public final void d(String str) {
        synchronized (this.f1266l) {
            try {
                if (!this.f1266l.containsKey(str)) {
                    throw new UnsupportedOperationException("Missing callback implementation");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e(String str) {
        synchronized (this.f1266l) {
            try {
                if (this.f1266l.containsKey(str)) {
                    return false;
                }
                this.f1266l.put(str, new T0.a(str));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean f(String str, String str2, int i, double d) {
        synchronized (this.f1266l) {
            try {
                String strD = l.D(str, str2, i, d);
                if (this.f1266l.containsKey(strD)) {
                    return false;
                }
                this.f1266l.put(strD, new T0.a(str, str2, i, d));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean g(String str, String str2, int i, double d, String str3, String str4) {
        synchronized (this.f1266l) {
            try {
                String strE = l.E(str, str2, i, d);
                if (this.f1266l.containsKey(strE)) {
                    return false;
                }
                this.f1266l.put(strE, new T0.a(str, str2, i, d, str3, str4));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean h(String str) {
        synchronized (this.f1266l) {
            try {
                String strB = l.B(str);
                if (this.f1266l.containsKey(strB)) {
                    return false;
                }
                this.f1266l.put(strB, new T0.a(str, 0));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i(String str) {
        synchronized (this.f1266l) {
            try {
                String strA = l.A(0, str);
                if (this.f1266l.containsKey(strA)) {
                    return false;
                }
                this.f1266l.put(strA, new T0.a(str, (Object) null));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j() {
        if (v("connect") || this.f1268n != null) {
            return;
        }
        this.f1268n = new c(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void k(String str) {
        new e(this, str, (B2.b) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!v(str) || this.f1266l.containsKey(str)) {
            if (f1258p.get()) {
                r();
                new e(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                e(str);
                if (this.f1268n == null) {
                    j();
                }
            }
        }
    }

    public final void m(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(null)) {
            return;
        }
        String strB = l.B(str);
        if (!v(strB) || this.f1266l.containsKey(strB)) {
            if (f1258p.get()) {
                r();
                new e(this, str, 0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                h(str);
                if (this.f1268n == null) {
                    j();
                }
            }
        }
    }

    public final void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = l.A(0, str);
        if (!v(strA) || this.f1266l.containsKey(strA)) {
            if (f1258p.get()) {
                r();
                new e(this, str, (Object) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                i(str);
                if (this.f1268n == null) {
                    j();
                }
            }
        }
    }

    public final void o(String str) {
        int i = 0;
        if (v(str)) {
            return;
        }
        if (!f1258p.get()) {
            d(str);
            if (this.f1268n != null) {
                j();
                return;
            }
            return;
        }
        if (str.equals("eventGetDeeplink")) {
            new f(this, 1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Callback[0]);
        } else {
            if (!str.equals("eventGetAttributionInfo")) {
                throw new IllegalStateException("Unexpected event name in executing request with callback: ".concat(str));
            }
            new f(this, i).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Callback[0]);
        }
    }

    public final Map q(HashMap map) {
        Context context = this.e;
        try {
            Iterator it = this.f1260a.iterator();
            while (it.hasNext()) {
                ((ParamProvider) it.next()).apply(map);
            }
            map.put("session_id", this.f1262g);
            map.put("sent_at", String.valueOf(new Date().getTime()));
            map.put("customer_user_id", context.getSharedPreferences("tenjinInstallPreferences", 0).getString("customer_user_id", null));
            map.put("retry_enabled", Boolean.valueOf(((SharedPreferences) new t(context).d).getBoolean("TENJIN_EVENT_CACHE_ENABLED", false)).toString());
            return this.b.apply(map);
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }
    }

    public final void r() {
        t tVar = new t(this.e);
        if (((SharedPreferences) tVar.d).getBoolean("TENJIN_EVENT_CACHE_ENABLED", false)) {
            ((ExecutorService) tVar.c).execute(new X0.h(0, tVar, new a(this, 0)));
        }
    }

    public final boolean s() {
        Object obj = ((HashMap) this.d.b).get("__tjn_config_mopub_ilrd");
        return (obj instanceof Boolean ? (Boolean) obj : null).booleanValue();
    }

    public final boolean t(String str) {
        Map map = this.f1265k;
        if (!map.containsKey(str)) {
            return false;
        }
        map.remove(str);
        return true;
    }

    public final boolean u(String str) {
        Map map = this.f1266l;
        if (!map.containsKey(str)) {
            return false;
        }
        map.remove(str);
        return true;
    }

    public final boolean v(String str) {
        Map map = this.f1265k;
        if (!map.containsKey(str)) {
            map.put(str, Long.valueOf(new Date().getTime()));
            return false;
        }
        if (new Date().getTime() - ((Long) map.get(str)).longValue() < (str.equals("connect") ? 0L : this.f1264j)) {
            return true;
        }
        t(str);
        return false;
    }

    public final void w(String str, String str2, int i, double d) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !S0.a.d.contains(str2) || i <= 0 || v(l.D(str, str2, i, d))) {
            return;
        }
        if (f1258p.get()) {
            r();
            new e(this, str, str2, i, d).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            f(str, str2, i, d);
            if (this.f1268n == null) {
                j();
            }
        }
    }

    public final void x(String str, String str2, int i, double d, String str3, String str4) {
        try {
            String strEncode = URLEncoder.encode(str3, "UTF-8");
            String strEncode2 = URLEncoder.encode(str4, "UTF-8");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !S0.a.d.contains(str2) || i <= 0 || v(l.E(str, str2, i, d))) {
                return;
            }
            if (f1258p.get()) {
                r();
                new e(this, str, str2, i, d, strEncode, strEncode2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                g(str, str2, i, d, strEncode, strEncode2);
                if (this.f1268n == null) {
                    j();
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            w(str, str2, i, d);
        }
    }

    public final void y() {
        String strA = l.A(0, "requestConversionUpdate");
        if (!v(strA) || this.f1266l.containsKey(strA)) {
            if (f1258p.get()) {
                new g(this, 0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            synchronized (this.f1266l) {
                try {
                    String strA2 = l.A(0, "requestConversionUpdate");
                    if (!this.f1266l.containsKey(strA2)) {
                        this.f1266l.put(strA2, new T0.a(strA2, (B2.b) null));
                    }
                } finally {
                }
            }
            if (this.f1268n == null) {
                j();
            }
        }
    }
}
