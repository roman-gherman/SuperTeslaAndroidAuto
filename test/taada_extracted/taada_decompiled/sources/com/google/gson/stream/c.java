package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f3054j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f3055k = new String[128];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f3056l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f3057a;
    public int[] b;
    public int c;
    public String d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3060h;
    public boolean i;

    static {
        for (int i = 0; i <= 31; i++) {
            f3055k[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f3055k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f3056l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        int[] iArr = new int[32];
        this.b = iArr;
        this.c = 0;
        if (iArr.length == 0) {
            this.b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.b;
        int i = this.c;
        this.c = i + 1;
        iArr2[i] = 6;
        this.e = ":";
        this.i = true;
        Objects.requireNonNull(writer, "out == null");
        this.f3057a = writer;
    }

    public final void a() throws IOException {
        int iJ = j();
        if (iJ == 1) {
            this.b[this.c - 1] = 2;
            h();
            return;
        }
        Writer writer = this.f3057a;
        if (iJ == 2) {
            writer.append(',');
            h();
        } else {
            if (iJ == 4) {
                writer.append((CharSequence) this.e);
                this.b[this.c - 1] = 5;
                return;
            }
            if (iJ != 6) {
                if (iJ != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f3058f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.b[this.c - 1] = 7;
        }
    }

    public void b() throws IOException {
        r();
        a();
        int i = this.c;
        int[] iArr = this.b;
        if (i == iArr.length) {
            this.b = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr2[i3] = 1;
        this.f3057a.write(91);
    }

    public void c() throws IOException {
        r();
        a();
        int i = this.c;
        int[] iArr = this.b;
        if (i == iArr.length) {
            this.b = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr2[i3] = 3;
        this.f3057a.write(123);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3057a.close();
        int i = this.c;
        if (i > 1 || (i == 1 && this.b[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.c = 0;
    }

    public final void d(int i, int i3, char c) throws IOException {
        int iJ = j();
        if (iJ != i3 && iJ != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3060h != null) {
            throw new IllegalStateException("Dangling name: " + this.f3060h);
        }
        this.c--;
        if (iJ == i3) {
            h();
        }
        this.f3057a.write(c);
    }

    public void e() throws IOException {
        d(1, 2, ']');
    }

    public void f() throws IOException {
        d(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3057a.flush();
    }

    public void g(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f3060h != null) {
            throw new IllegalStateException();
        }
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3060h = str;
    }

    public final void h() throws IOException {
        if (this.d == null) {
            return;
        }
        Writer writer = this.f3057a;
        writer.write(10);
        int i = this.c;
        for (int i3 = 1; i3 < i; i3++) {
            writer.write(this.d);
        }
    }

    public c i() throws IOException {
        if (this.f3060h != null) {
            if (!this.i) {
                this.f3060h = null;
                return this;
            }
            r();
        }
        a();
        this.f3057a.write("null");
        return this;
    }

    public final int j() {
        int i = this.c;
        if (i != 0) {
            return this.b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f3059g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.c.f3056l
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.c.f3055k
        L9:
            java.io.Writer r1 = r8.f3057a
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = r4
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.c.k(java.lang.String):void");
    }

    public void l(double d) throws IOException {
        r();
        if (this.f3058f || !(Double.isNaN(d) || Double.isInfinite(d))) {
            a();
            this.f3057a.append((CharSequence) Double.toString(d));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
    }

    public void m(long j6) throws IOException {
        r();
        a();
        this.f3057a.write(Long.toString(j6));
    }

    public void n(Boolean bool) throws IOException {
        if (bool == null) {
            i();
            return;
        }
        r();
        a();
        this.f3057a.write(bool.booleanValue() ? "true" : "false");
    }

    public void o(Number number) throws IOException {
        if (number == null) {
            i();
            return;
        }
        r();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (cls != Integer.class && cls != Long.class && cls != Double.class && cls != Float.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class && !f3054j.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f3058f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
        }
        a();
        this.f3057a.append((CharSequence) string);
    }

    public void p(String str) throws IOException {
        if (str == null) {
            i();
            return;
        }
        r();
        a();
        k(str);
    }

    public void q(boolean z6) throws IOException {
        r();
        a();
        this.f3057a.write(z6 ? "true" : "false");
    }

    public final void r() throws IOException {
        if (this.f3060h != null) {
            int iJ = j();
            if (iJ == 5) {
                this.f3057a.write(44);
            } else if (iJ != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            h();
            this.b[this.c - 1] = 4;
            k(this.f3060h);
            this.f3060h = null;
        }
    }
}
