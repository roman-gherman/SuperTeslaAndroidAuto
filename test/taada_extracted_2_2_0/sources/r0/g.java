package R0;

import android.os.AsyncTask;
import android.util.Base64;
import c4.AbstractC0246d;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1256a;
    public Map b;
    public final String c;
    public final /* synthetic */ h d;

    public g(h hVar, Integer num) {
        this.d = hVar;
        this.f1256a = num;
        this.c = l.A(num.intValue(), "requestConversionUpdate");
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) throws Throwable {
        boolean zN;
        h hVar = this.d;
        try {
            String str = "Basic " + Base64.encodeToString(hVar.f1261f.getBytes(), 10);
            HashMap map = new HashMap();
            map.put("Authorization", str);
            HashMap map2 = new HashMap();
            map2.put("conversion_value", this.f1256a.toString());
            Map mapQ = hVar.q(map2);
            this.b = mapQ;
            zN = AbstractC0246d.n("https://track.tenjin.com/v0/conversion-values", mapQ, map);
        } catch (Exception e) {
            e.printStackTrace();
            zN = false;
        }
        return Boolean.valueOf(zN);
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        String str = this.c;
        h hVar = this.d;
        if (zBooleanValue) {
            hVar.u(str);
        } else {
            hVar.e(str);
        }
    }
}
