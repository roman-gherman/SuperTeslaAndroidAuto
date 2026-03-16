package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.C0257h;
import com.android.billingclient.api.Purchase;
import org.json.JSONException;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0289j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2092a = Runtime.getRuntime().availableProcessors();

    public static int a(Bundle bundle, String str) {
        if (bundle == null) {
            f(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            e(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        f(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
        return 6;
    }

    public static void b(Bundle bundle, String str, long j6) {
        bundle.putString("playBillingLibraryVersion", str);
        bundle.putLong("billingClientSessionId", j6);
    }

    public static C0257h c(Intent intent, String str) {
        if (intent != null) {
            Z3.b bVarA = C0257h.a();
            bVarA.f1505a = a(intent.getExtras(), str);
            bVarA.b = d(intent.getExtras(), str);
            return bVarA.a();
        }
        f("BillingHelper", "Got null intent!");
        Z3.b bVarA2 = C0257h.a();
        bVarA2.f1505a = 6;
        bVarA2.b = "An internal error occurred.";
        return bVarA2.a();
    }

    public static String d(Bundle bundle, String str) {
        if (bundle == null) {
            f(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            e(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        f(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return "";
    }

    public static void e(String str, String str2) {
        if (!Log.isLoggable(str, 2) || str2.isEmpty()) {
            return;
        }
        int i = 40000;
        while (!str2.isEmpty() && i > 0) {
            int iMin = Math.min(str2.length(), Math.min(4000, i));
            str2.substring(0, iMin);
            str2 = str2.substring(iMin);
            i -= iMin;
        }
    }

    public static void f(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void g(String str, String str2, Throwable th) {
        try {
            if (Log.isLoggable(str, 5)) {
                if (th == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static Bundle h(C0257h c0257h, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", c0257h.f1844a);
        bundle.putString("DEBUG_MESSAGE", c0257h.b);
        bundle.putInt("LOG_REASON", i - 1);
        return bundle;
    }

    public static Purchase i(String str, String str2) {
        if (str == null || str2 == null) {
            e("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e) {
            f("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
            return null;
        }
    }
}
