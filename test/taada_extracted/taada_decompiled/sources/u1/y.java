package u1;

import c4.AbstractC0246d;
import io.ktor.http.Parameters;
import io.ktor.utils.io.Z;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0835D f4877k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0832A f4878a;
    public String b;
    public int c;
    public boolean d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f4881h;
    public w i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public A2.B f4882j;

    static {
        y yVar = new y();
        z.b(yVar, "http://localhost");
        f4877k = yVar.b();
    }

    public y() {
        C0832A protocol = C0832A.c;
        kotlin.collections.u uVar = kotlin.collections.u.f3804a;
        Parameters.Companion.getClass();
        h hVar = h.f4863a;
        kotlin.jvm.internal.h.f(protocol, "protocol");
        this.f4878a = protocol;
        this.b = "";
        this.c = 0;
        this.d = false;
        this.e = null;
        this.f4879f = null;
        Set set = AbstractC0837b.f4858a;
        Charset charset = kotlin.text.a.f3942a;
        kotlin.jvm.internal.h.f(charset, "charset");
        StringBuilder sb = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kotlin.jvm.internal.h.e(charsetEncoderNewEncoder, "charset.newEncoder()");
        AbstractC0837b.g(AbstractC0246d.H(charsetEncoderNewEncoder, "", 0, "".length()), new t2.q(sb, 1));
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        this.f4880g = string;
        this.f4881h = new ArrayList(kotlin.collections.o.D(uVar));
        w wVarA = Z.a();
        k1.j.b(wVarA, hVar);
        this.i = wVarA;
        this.f4882j = new A2.B(wVarA);
    }

    public final void a() {
        if (this.b.length() <= 0 && !kotlin.jvm.internal.h.a(this.f4878a.f4845a, "file")) {
            C0835D c0835d = f4877k;
            this.b = c0835d.b;
            C0832A c0832a = this.f4878a;
            C0832A c0832a2 = C0832A.c;
            if (kotlin.jvm.internal.h.a(c0832a, C0832A.c)) {
                this.f4878a = c0835d.f4848a;
            }
            if (this.c == 0) {
                this.c = c0835d.c;
            }
        }
    }

    public final C0835D b() {
        a();
        C0832A c0832a = this.f4878a;
        String str = this.b;
        int i = this.c;
        List list = this.f4881h;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC0837b.d((String) it.next()));
        }
        Parameters parametersG = k1.j.g((w) this.f4882j.c);
        String strE = AbstractC0837b.e(this.f4880g, 0, 0, 15);
        String str2 = this.e;
        String strD = str2 != null ? AbstractC0837b.d(str2) : null;
        String str3 = this.f4879f;
        String strD2 = str3 != null ? AbstractC0837b.d(str3) : null;
        boolean z6 = this.d;
        a();
        StringBuilder sb = new StringBuilder(256);
        io.ktor.utils.io.internal.t.a(this, sb);
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "appendTo(StringBuilder(256)).toString()");
        return new C0835D(c0832a, str, i, arrayList, parametersG, strE, strD, strD2, z6, string);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(256);
        io.ktor.utils.io.internal.t.a(this, sb);
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "appendTo(StringBuilder(256)).toString()");
        return string;
    }
}
