package u1;

import com.android.multidex.ClassPathElement;
import java.util.List;
import java.util.Locale;
import org.slf4j.Marker;

/* JADX INFO: renamed from: u1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0840e extends V2.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0840e f4861f = new C0840e(Marker.ANY_MARKER, Marker.ANY_MARKER, kotlin.collections.u.f3804a);
    public final String d;
    public final String e;

    public C0840e(String str, String str2, String str3, List list) {
        super(str3, list);
        this.d = str;
        this.e = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0840e)) {
            return false;
        }
        C0840e c0840e = (C0840e) obj;
        return kotlin.text.r.x(this.d, c0840e.d) && kotlin.text.r.x(this.e, c0840e.e) && kotlin.jvm.internal.h.a((List) this.c, (List) c0840e.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(u1.C0840e r7) {
        /*
            r6 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.h.f(r7, r0)
            java.lang.String r0 = r7.d
            java.lang.String r1 = "*"
            boolean r2 = kotlin.jvm.internal.h.a(r0, r1)
            r3 = 0
            if (r2 != 0) goto L1a
            java.lang.String r2 = r6.d
            boolean r0 = kotlin.text.r.x(r0, r2)
            if (r0 != 0) goto L1a
            goto L8b
        L1a:
            java.lang.String r0 = r7.e
            boolean r2 = kotlin.jvm.internal.h.a(r0, r1)
            if (r2 != 0) goto L2b
            java.lang.String r2 = r6.e
            boolean r0 = kotlin.text.r.x(r0, r2)
            if (r0 != 0) goto L2b
            goto L8b
        L2b:
            java.lang.Object r7 = r7.c
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
        L33:
            boolean r0 = r7.hasNext()
            r2 = 1
            if (r0 == 0) goto L8c
            java.lang.Object r0 = r7.next()
            u1.j r0 = (u1.j) r0
            java.lang.String r4 = r0.f4865a
            boolean r5 = kotlin.jvm.internal.h.a(r4, r1)
            java.lang.String r0 = r0.b
            if (r5 == 0) goto L78
            boolean r4 = kotlin.jvm.internal.h.a(r0, r1)
            if (r4 == 0) goto L51
            goto L89
        L51:
            java.lang.Object r4 = r6.c
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L5f
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L5f
        L5d:
            r2 = r3
            goto L89
        L5f:
            java.util.Iterator r4 = r4.iterator()
        L63:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L5d
            java.lang.Object r5 = r4.next()
            u1.j r5 = (u1.j) r5
            java.lang.String r5 = r5.b
            boolean r5 = kotlin.text.r.x(r5, r0)
            if (r5 == 0) goto L63
            goto L89
        L78:
            java.lang.String r4 = r6.f(r4)
            boolean r5 = kotlin.jvm.internal.h.a(r0, r1)
            if (r5 == 0) goto L85
            if (r4 == 0) goto L5d
            goto L89
        L85:
            boolean r2 = kotlin.text.r.x(r4, r0)
        L89:
            if (r2 != 0) goto L33
        L8b:
            return r3
        L8c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.C0840e.g(u1.e):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (kotlin.text.r.x(r1.b, r6) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final u1.C0840e h(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.c
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            java.lang.String r2 = "charset"
            if (r1 == 0) goto L4f
            r3 = 1
            if (r1 == r3) goto L37
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L16
            goto L4f
        L16:
            java.util.Iterator r1 = r0.iterator()
        L1a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L4f
            java.lang.Object r3 = r1.next()
            u1.j r3 = (u1.j) r3
            java.lang.String r4 = r3.f4865a
            boolean r4 = kotlin.text.r.x(r4, r2)
            if (r4 == 0) goto L1a
            java.lang.String r3 = r3.b
            boolean r3 = kotlin.text.r.x(r3, r6)
            if (r3 == 0) goto L1a
            goto L4e
        L37:
            r1 = 0
            java.lang.Object r1 = r0.get(r1)
            u1.j r1 = (u1.j) r1
            java.lang.String r3 = r1.f4865a
            boolean r3 = kotlin.text.r.x(r3, r2)
            if (r3 == 0) goto L4f
            java.lang.String r1 = r1.b
            boolean r1 = kotlin.text.r.x(r1, r6)
            if (r1 == 0) goto L4f
        L4e:
            return r5
        L4f:
            u1.e r1 = new u1.e
            u1.j r3 = new u1.j
            r3.<init>(r2, r6)
            java.util.ArrayList r6 = kotlin.collections.m.d0(r3, r0)
            java.lang.String r0 = r5.e
            java.lang.Object r2 = r5.b
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = r5.d
            r1.<init>(r3, r0, r2, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.C0840e.h(java.lang.String):u1.e");
    }

    public final int hashCode() {
        Locale locale = Locale.ROOT;
        String lowerCase = this.d.toLowerCase(locale);
        kotlin.jvm.internal.h.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.e.toLowerCase(locale);
        kotlin.jvm.internal.h.e(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return (((List) this.c).hashCode() * 31) + lowerCase2.hashCode() + (iHashCode * 31) + iHashCode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0840e(String contentType, String contentSubtype, List parameters) {
        this(contentType, contentSubtype, contentType + ClassPathElement.SEPARATOR_CHAR + contentSubtype, parameters);
        kotlin.jvm.internal.h.f(contentType, "contentType");
        kotlin.jvm.internal.h.f(contentSubtype, "contentSubtype");
        kotlin.jvm.internal.h.f(parameters, "parameters");
    }
}
