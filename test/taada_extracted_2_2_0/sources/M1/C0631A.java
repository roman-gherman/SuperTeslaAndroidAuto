package m1;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: renamed from: m1.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0631A {
    public static final C0632a d = new C0632a(3);
    public static final z1.a e = new z1.a("HttpPlainText");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Charset f4027a;
    public final Charset b;
    public final String c;

    public C0631A(LinkedHashSet charsets, LinkedHashMap charsetQuality, Charset responseCharsetFallback) {
        kotlin.jvm.internal.h.f(charsets, "charsets");
        kotlin.jvm.internal.h.f(charsetQuality, "charsetQuality");
        kotlin.jvm.internal.h.f(responseCharsetFallback, "responseCharsetFallback");
        this.f4027a = responseCharsetFallback;
        List<N1.e> listK0 = kotlin.collections.m.k0(kotlin.collections.A.K(charsetQuality), new com.google.android.gms.location.h(8));
        ArrayList arrayList = new ArrayList();
        for (Object obj : charsets) {
            if (!charsetQuality.containsKey((Charset) obj)) {
                arrayList.add(obj);
            }
        }
        List<Charset> listK02 = kotlin.collections.m.k0(arrayList, new com.google.android.gms.location.h(7));
        StringBuilder sb = new StringBuilder();
        for (Charset charset : listK02) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(H1.a.c(charset));
        }
        for (N1.e eVar : listK0) {
            Charset charset2 = (Charset) eVar.f1121a;
            float fFloatValue = ((Number) eVar.b).floatValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            double d6 = fFloatValue;
            if (0.0d > d6 || d6 > 1.0d) {
                throw new IllegalStateException("Check failed.");
            }
            float f6 = 100 * fFloatValue;
            if (Float.isNaN(f6)) {
                throw new IllegalArgumentException("Cannot round NaN value.");
            }
            sb.append(H1.a.c(charset2) + ";q=" + (((double) Math.round(f6)) / 100.0d));
        }
        if (sb.length() == 0) {
            sb.append(H1.a.c(this.f4027a));
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        this.c = string;
        Charset charset3 = (Charset) kotlin.collections.m.R(listK02);
        if (charset3 == null) {
            N1.e eVar2 = (N1.e) kotlin.collections.m.R(listK0);
            charset3 = eVar2 != null ? (Charset) eVar2.f1121a : null;
            if (charset3 == null) {
                charset3 = kotlin.text.a.f3943a;
            }
        }
        this.b = charset3;
    }
}
