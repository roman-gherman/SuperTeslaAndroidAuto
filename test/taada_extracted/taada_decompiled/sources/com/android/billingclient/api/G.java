package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.I1;
import com.google.android.gms.internal.play_billing.J1;
import com.google.android.gms.internal.play_billing.K1;
import com.google.android.gms.internal.play_billing.L1;
import com.google.android.gms.internal.play_billing.M1;
import com.google.android.gms.internal.play_billing.N1;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class G {
    static {
        int i = zzch.zza;
    }

    public static String a(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String simpleName = exc.getClass().getSimpleName();
            String message = exc.getMessage();
            if (message == null) {
                message = "";
            }
            String str = simpleName + ":" + message;
            int i = AbstractC0289j0.f2092a;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static J1 b(int i, int i3, C0257h c0257h) {
        try {
            I1 i1P = J1.p();
            M1 m1Q = N1.q();
            int i4 = c0257h.f1844a;
            m1Q.d();
            N1.o((N1) m1Q.b, i4);
            String str = c0257h.b;
            m1Q.d();
            N1.n((N1) m1Q.b, str);
            m1Q.e(i);
            i1P.e(m1Q);
            i1P.d();
            J1.o((J1) i1P.b, i3);
            return (J1) i1P.b();
        } catch (Exception e) {
            AbstractC0289j0.g("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }

    public static J1 c(int i, int i3, C0257h c0257h, String str) {
        try {
            M1 m1Q = N1.q();
            int i4 = c0257h.f1844a;
            m1Q.d();
            N1.o((N1) m1Q.b, i4);
            String str2 = c0257h.b;
            m1Q.d();
            N1.n((N1) m1Q.b, str2);
            m1Q.e(i);
            if (str != null) {
                m1Q.d();
                N1.m((N1) m1Q.b, str);
            }
            I1 i1P = J1.p();
            i1P.e(m1Q);
            i1P.d();
            J1.o((J1) i1P.b, i3);
            return (J1) i1P.b();
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static L1 d(int i) {
        try {
            K1 k1O = L1.o();
            k1O.d();
            L1.n((L1) k1O.b, i);
            return (L1) k1O.b();
        } catch (Exception e) {
            AbstractC0289j0.g("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
