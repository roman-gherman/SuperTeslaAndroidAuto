package kotlin.text;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends o {
    public static Double u(String str) {
        kotlin.jvm.internal.h.f(str, "<this>");
        try {
            g gVar = h.f3948a;
            gVar.getClass();
            if (gVar.f3947a.matcher(str).matches()) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
