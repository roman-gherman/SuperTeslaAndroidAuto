package T0;

import B2.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1300a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f1301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1303h;

    public a(String str) {
        this.e = 0;
        this.f1301f = 0.0d;
        this.f1300a = "eventName";
        this.b = str;
    }

    public a(String str, int i) {
        this.e = 0;
        this.f1301f = 0.0d;
        this.f1300a = "eventNameValue";
        this.b = str;
    }

    public a(String str, Object obj) {
        this.e = 0;
        this.f1301f = 0.0d;
        this.f1300a = "eventNameIntValue";
        this.b = str;
    }

    public a(String str, b bVar) {
        this.e = 0;
        this.f1301f = 0.0d;
        this.f1300a = "requestConversionUpdate";
        this.b = str;
    }

    public a(String str, String str2, int i, double d) {
        this.f1300a = "eventNameTransaction";
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f1301f = d;
    }

    public a(String str, String str2, int i, double d, String str3, String str4) {
        this.f1300a = "eventNameTransactionData";
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f1301f = d;
        this.f1302g = str3;
        this.f1303h = str4;
    }
}
