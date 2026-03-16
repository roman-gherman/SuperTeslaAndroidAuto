package l;

import B.g;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.i;
import com.google.android.datatransport.runtime.n;
import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.time.Clock;
import io.ktor.utils.io.b0;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k.C0569b;
import m.h;
import m.j;
import m.k;
import m.l;
import m.m;
import m.u;
import m.v;
import m.x;
import n.C0694a;
import n.e;

/* JADX INFO: loaded from: classes.dex */
public final class d implements TransportBackend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f3954a;
    public final ConnectivityManager b;
    public final Context c;
    public final URL d;
    public final Clock e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Clock f3955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3956g;

    public d(Context context, Clock clock, Clock clock2) {
        K0.d dVar = new K0.d();
        h.f3999a.configure(dVar);
        dVar.d = true;
        this.f3954a = new g(dVar, 8);
        this.c = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = a(C0614a.c);
        this.e = clock2;
        this.f3955f = clock;
        this.f3956g = 130000;
    }

    public static URL a(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.p("Invalid url: ", str), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0102  */
    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.datatransport.runtime.o decorate(com.google.android.datatransport.runtime.o r7) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l.d.decorate(com.google.android.datatransport.runtime.o):com.google.android.datatransport.runtime.o");
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public final e send(n.d dVar) {
        String str;
        Object objApply;
        Integer numValueOf;
        String str2;
        B0.a aVar;
        HashMap map = new HashMap();
        C0694a c0694a = (C0694a) dVar;
        for (o oVar : c0694a.f4158a) {
            String str3 = ((i) oVar).f1880a;
            if (map.containsKey(str3)) {
                ((List) map.get(str3)).add(oVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(oVar);
                map.put(str3, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            o oVar2 = (o) ((List) entry.getValue()).get(0);
            x xVar = x.f4019a;
            long time = this.f3955f.getTime();
            long time2 = this.e.getTime();
            k kVar = new k(new m.i(Integer.valueOf(oVar2.b("sdk-version")), oVar2.a("model"), oVar2.a("hardware"), oVar2.a("device"), oVar2.a("product"), oVar2.a("os-uild"), oVar2.a("manufacturer"), oVar2.a("fingerprint"), oVar2.a("locale"), oVar2.a("country"), oVar2.a("mcc_mnc"), oVar2.a("application_build")));
            try {
                str2 = null;
                numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                numValueOf = null;
                str2 = (String) entry.getKey();
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = ((List) entry.getValue()).iterator();
            while (it2.hasNext()) {
                o oVar3 = (o) it2.next();
                i iVar = (i) oVar3;
                n nVar = iVar.c;
                C0569b c0569b = nVar.f1888a;
                Iterator it3 = it;
                Iterator it4 = it2;
                boolean zEquals = c0569b.equals(new C0569b("proto"));
                byte[] bArr = nVar.b;
                if (zEquals) {
                    aVar = new B0.a();
                    aVar.e = bArr;
                } else if (c0569b.equals(new C0569b("json"))) {
                    String str4 = new String(bArr, Charset.forName("UTF-8"));
                    B0.a aVar2 = new B0.a();
                    aVar2.f115a = str4;
                    aVar = aVar2;
                } else {
                    String strConcat = "TRuntime.".concat("CctTransportBackend");
                    if (Log.isLoggable(strConcat, 5)) {
                        Log.w(strConcat, "Received event of unsupported encoding " + c0569b + ". Skipping...");
                    }
                    it = it3;
                    it2 = it4;
                }
                aVar.b = Long.valueOf(iVar.d);
                aVar.d = Long.valueOf(iVar.e);
                String str5 = (String) iVar.f1881f.get("tz-offset");
                aVar.f116f = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                aVar.f117g = new m.o((v) v.f4018a.get(oVar3.b("net-type")), (u) u.f4017a.get(oVar3.b("mobile-subtype")));
                Integer num = iVar.b;
                if (num != null) {
                    aVar.c = num;
                }
                String strE = ((Long) aVar.b) == null ? " eventTimeMs" : "";
                if (((Long) aVar.d) == null) {
                    strE = strE.concat(" eventUptimeMs");
                }
                if (((Long) aVar.f116f) == null) {
                    strE = B2.b.e(strE, " timezoneOffsetSeconds");
                }
                if (!strE.isEmpty()) {
                    throw new IllegalStateException("Missing required properties:".concat(strE));
                }
                arrayList3.add(new l(((Long) aVar.b).longValue(), (Integer) aVar.c, ((Long) aVar.d).longValue(), (byte[]) aVar.e, (String) aVar.f115a, ((Long) aVar.f116f).longValue(), (m.o) aVar.f117g));
                it = it3;
                it2 = it4;
            }
            arrayList2.add(new m(time, time2, kVar, numValueOf, str2, arrayList3));
            it = it;
        }
        j jVar = new j(arrayList2);
        byte[] bArr2 = c0694a.b;
        URL urlA = this.d;
        if (bArr2 != null) {
            try {
                C0614a c0614aA = C0614a.a(((C0694a) dVar).b);
                str = c0614aA.b;
                if (str == null) {
                    str = null;
                }
                String str6 = c0614aA.f3951a;
                if (str6 != null) {
                    urlA = a(str6);
                }
            } catch (IllegalArgumentException unused2) {
                return new n.b(3, -1L);
            }
        } else {
            str = null;
        }
        try {
            b bVar = new b(urlA, jVar, str);
            R0.a aVar3 = new R0.a(this, 10);
            int i = 5;
            do {
                objApply = aVar3.apply(bVar);
                URL url = ((c) objApply).b;
                if (url != null) {
                    b0.j(url, "CctTransportBackend", "Following redirect to: %s");
                    bVar = new b(url, bVar.b, bVar.c);
                } else {
                    bVar = null;
                }
                if (bVar == null) {
                    break;
                }
                i--;
            } while (i >= 1);
            c cVar = (c) objApply;
            int i3 = cVar.f3953a;
            if (i3 == 200) {
                return new n.b(1, cVar.c);
            }
            if (i3 < 500 && i3 != 404) {
                return i3 == 400 ? new n.b(4, -1L) : new n.b(3, -1L);
            }
            return new n.b(2, -1L);
        } catch (IOException e) {
            b0.k("CctTransportBackend", "Could not make request to the backend", e);
            return new n.b(2, -1L);
        }
    }
}
