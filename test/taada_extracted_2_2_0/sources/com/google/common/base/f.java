package com.google.common.base;

import a.AbstractC0132a;
import c4.AbstractC0246d;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.utility.JavaConstant;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static final a c;
    public static final b d;
    public static final c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f2769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ f[] f2770g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0132a f2771a;
    public final String b;

    static {
        a aVar = new a("LOWER_HYPHEN", 0, new h(SignatureVisitor.SUPER), "-");
        c = aVar;
        b bVar = new b("LOWER_UNDERSCORE", 1, new h('_'), JavaConstant.Dynamic.DEFAULT_NAME);
        d = bVar;
        c cVar = new c("LOWER_CAMEL", 2, new AbstractC0132a() { // from class: com.google.common.base.g
            public final char b = 'A';
            public final char c = 'Z';

            @Override // a.AbstractC0132a
            public final boolean T(char c6) {
                return this.b <= c6 && c6 <= this.c;
            }

            public final String toString() {
                return "CharMatcher.inRange('" + AbstractC0132a.a(this.b) + "', '" + AbstractC0132a.a(this.c) + "')";
            }
        }, "");
        e = cVar;
        d dVar = new d("UPPER_CAMEL", 3, new AbstractC0132a() { // from class: com.google.common.base.g
            public final char b = 'A';
            public final char c = 'Z';

            @Override // a.AbstractC0132a
            public final boolean T(char c6) {
                return this.b <= c6 && c6 <= this.c;
            }

            public final String toString() {
                return "CharMatcher.inRange('" + AbstractC0132a.a(this.b) + "', '" + AbstractC0132a.a(this.c) + "')";
            }
        }, "");
        e eVar = new e("UPPER_UNDERSCORE", 4, new h('_'), JavaConstant.Dynamic.DEFAULT_NAME);
        f2769f = eVar;
        f2770g = new f[]{aVar, bVar, cVar, dVar, eVar};
    }

    public f(String str, int i, AbstractC0132a abstractC0132a, String str2) {
        this.f2771a = abstractC0132a;
        this.b = str2;
    }

    public static String a(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt ^ ' ');
        }
        sb.append(cCharAt);
        sb.append(AbstractC0246d.J0(str.substring(1)));
        return sb.toString();
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f2770g.clone();
    }

    public String b(f fVar, String str) {
        StringBuilder sb = null;
        int length = 0;
        int iG = -1;
        while (true) {
            iG = this.f2771a.G(str, iG + 1);
            if (iG == -1) {
                break;
            }
            String str2 = this.b;
            if (length == 0) {
                sb = new StringBuilder((str2.length() * 4) + str.length());
                sb.append(fVar.c(str.substring(length, iG)));
            } else {
                sb.append(fVar.d(str.substring(length, iG)));
            }
            sb.append(fVar.b);
            length = str2.length() + iG;
        }
        if (length == 0) {
            return fVar.c(str);
        }
        sb.append(fVar.d(str.substring(length)));
        return sb.toString();
    }

    public String c(String str) {
        return d(str);
    }

    public abstract String d(String str);
}
