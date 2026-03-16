package com.google.gson.stream;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes.dex */
public class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f3044a;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f3049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f3050l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String[] f3052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f3053o;
    public boolean b = false;
    public final char[] c = new char[1024];
    public int d = 0;
    public int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3045f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3046g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3047h = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3051m = 1;

    static {
        a.f3043a = new a();
    }

    public b(Reader reader) {
        int[] iArr = new int[32];
        this.f3050l = iArr;
        iArr[0] = 6;
        this.f3052n = new String[32];
        this.f3053o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f3044a = reader;
    }

    public final void A() {
        char c;
        do {
            if (this.d >= this.e && !g(1)) {
                return;
            }
            int i = this.d;
            int i3 = i + 1;
            this.d = i3;
            c = this.c[i];
            if (c == '\n') {
                this.f3045f++;
                this.f3046g = i3;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        c();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B() throws com.google.gson.stream.d {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.d
            int r2 = r1 + r0
            int r3 = r4.e
            if (r2 >= r3) goto L51
            char[] r2 = r4.c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.c()
        L4b:
            int r1 = r4.d
            int r1 = r1 + r0
            r4.d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.d = r1
            r0 = 1
            boolean r0 = r4.g(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.b.B():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void C() throws IOException {
        int i = 0;
        do {
            int iD = this.f3047h;
            if (iD == 0) {
                iD = d();
            }
            switch (iD) {
                case 1:
                    x(3);
                    i++;
                    this.f3047h = 0;
                    break;
                case 2:
                    if (i == 0) {
                        this.f3052n[this.f3051m - 1] = null;
                    }
                    this.f3051m--;
                    i--;
                    this.f3047h = 0;
                    break;
                case 3:
                    x(1);
                    i++;
                    this.f3047h = 0;
                    break;
                case 4:
                    this.f3051m--;
                    i--;
                    this.f3047h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f3047h = 0;
                    break;
                case 8:
                    z('\'');
                    this.f3047h = 0;
                    break;
                case 9:
                    z('\"');
                    this.f3047h = 0;
                    break;
                case 10:
                    B();
                    this.f3047h = 0;
                    break;
                case 12:
                    z('\'');
                    if (i == 0) {
                        this.f3052n[this.f3051m - 1] = "<skipped>";
                    }
                    this.f3047h = 0;
                    break;
                case 13:
                    z('\"');
                    if (i == 0) {
                        this.f3052n[this.f3051m - 1] = "<skipped>";
                    }
                    this.f3047h = 0;
                    break;
                case 14:
                    B();
                    if (i == 0) {
                        this.f3052n[this.f3051m - 1] = "<skipped>";
                    }
                    this.f3047h = 0;
                    break;
                case 16:
                    this.d += this.f3048j;
                    this.f3047h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i > 0);
        int[] iArr = this.f3053o;
        int i3 = this.f3051m - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public final void D(String str) throws d {
        StringBuilder sbK = B2.b.k(str);
        sbK.append(l());
        throw new d(sbK.toString());
    }

    public void a() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 3) {
            x(1);
            this.f3053o[this.f3051m - 1] = 0;
            this.f3047h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
        }
    }

    public void b() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 1) {
            x(3);
            this.f3047h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
        }
    }

    public final void c() throws d {
        if (this.b) {
            return;
        }
        D("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3047h = 0;
        this.f3050l[0] = 8;
        this.f3051m = 1;
        this.f3044a.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:165:0x020f, code lost:
    
        if (k(r7) != false) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x017f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0267 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.b.d():int");
    }

    public void e() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
        }
        int i = this.f3051m;
        this.f3051m = i - 1;
        int[] iArr = this.f3053o;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f3047h = 0;
    }

    public void f() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
        }
        int i = this.f3051m;
        int i3 = i - 1;
        this.f3051m = i3;
        this.f3052n[i3] = null;
        int[] iArr = this.f3053o;
        int i4 = i - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f3047h = 0;
    }

    public final boolean g(int i) throws IOException {
        int i3;
        int i4;
        int i5 = this.f3046g;
        int i6 = this.d;
        this.f3046g = i5 - i6;
        int i7 = this.e;
        char[] cArr = this.c;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.e = 0;
        }
        this.d = 0;
        do {
            int i9 = this.e;
            int i10 = this.f3044a.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.e + i10;
            this.e = i3;
            if (this.f3045f == 0 && (i4 = this.f3046g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.d++;
                this.f3046g = i4 + 1;
                i++;
            }
        } while (i3 < i);
        return true;
    }

    public String getPath() {
        return h(false);
    }

    public final String h(boolean z6) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i3 = this.f3051m;
            if (i >= i3) {
                return sb.toString();
            }
            int i4 = this.f3050l[i];
            if (i4 == 1 || i4 == 2) {
                int i5 = this.f3053o[i];
                if (z6 && i5 > 0 && i == i3 - 1) {
                    i5--;
                }
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                sb.append(i5);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                String str = this.f3052n[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    public String i() {
        return h(true);
    }

    public boolean j() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        return (iD == 2 || iD == 4 || iD == 17) ? false : true;
    }

    public final boolean k(char c) throws d {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    final String l() {
        return " at line " + (this.f3045f + 1) + " column " + ((this.d - this.f3046g) + 1) + " path " + getPath();
    }

    public boolean m() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 5) {
            this.f3047h = 0;
            int[] iArr = this.f3053o;
            int i = this.f3051m - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iD != 6) {
            throw new IllegalStateException("Expected a boolean but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
        }
        this.f3047h = 0;
        int[] iArr2 = this.f3053o;
        int i3 = this.f3051m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    public double n() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            this.f3047h = 0;
            int[] iArr = this.f3053o;
            int i = this.f3051m - 1;
            iArr[i] = iArr[i] + 1;
            return this.i;
        }
        if (iD == 16) {
            this.f3049k = new String(this.c, this.d, this.f3048j);
            this.d += this.f3048j;
        } else if (iD == 8 || iD == 9) {
            this.f3049k = t(iD == 8 ? '\'' : '\"');
        } else if (iD == 10) {
            this.f3049k = v();
        } else if (iD != 11) {
            throw new IllegalStateException("Expected a double but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
        }
        this.f3047h = 11;
        double d = Double.parseDouble(this.f3049k);
        if (!this.b && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new d("JSON forbids NaN and infinities: " + d + l());
        }
        this.f3049k = null;
        this.f3047h = 0;
        int[] iArr2 = this.f3053o;
        int i3 = this.f3051m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d;
    }

    public int o() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            long j6 = this.i;
            int i = (int) j6;
            if (j6 != i) {
                throw new NumberFormatException("Expected an int but was " + this.i + l());
            }
            this.f3047h = 0;
            int[] iArr = this.f3053o;
            int i3 = this.f3051m - 1;
            iArr[i3] = iArr[i3] + 1;
            return i;
        }
        if (iD == 16) {
            this.f3049k = new String(this.c, this.d, this.f3048j);
            this.d += this.f3048j;
        } else {
            if (iD != 8 && iD != 9 && iD != 10) {
                throw new IllegalStateException("Expected an int but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
            }
            if (iD == 10) {
                this.f3049k = v();
            } else {
                this.f3049k = t(iD == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.f3049k);
                this.f3047h = 0;
                int[] iArr2 = this.f3053o;
                int i5 = this.f3051m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3047h = 11;
        double d = Double.parseDouble(this.f3049k);
        int i6 = (int) d;
        if (i6 != d) {
            throw new NumberFormatException("Expected an int but was " + this.f3049k + l());
        }
        this.f3049k = null;
        this.f3047h = 0;
        int[] iArr3 = this.f3053o;
        int i7 = this.f3051m - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public long p() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            this.f3047h = 0;
            int[] iArr = this.f3053o;
            int i = this.f3051m - 1;
            iArr[i] = iArr[i] + 1;
            return this.i;
        }
        if (iD == 16) {
            this.f3049k = new String(this.c, this.d, this.f3048j);
            this.d += this.f3048j;
        } else {
            if (iD != 8 && iD != 9 && iD != 10) {
                throw new IllegalStateException("Expected a long but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
            }
            if (iD == 10) {
                this.f3049k = v();
            } else {
                this.f3049k = t(iD == 8 ? '\'' : '\"');
            }
            try {
                long j6 = Long.parseLong(this.f3049k);
                this.f3047h = 0;
                int[] iArr2 = this.f3053o;
                int i3 = this.f3051m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j6;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3047h = 11;
        double d = Double.parseDouble(this.f3049k);
        long j7 = (long) d;
        if (j7 != d) {
            throw new NumberFormatException("Expected a long but was " + this.f3049k + l());
        }
        this.f3049k = null;
        this.f3047h = 0;
        int[] iArr3 = this.f3053o;
        int i4 = this.f3051m - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j7;
    }

    public String q() throws IOException {
        String strT;
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 14) {
            strT = v();
        } else if (iD == 12) {
            strT = t('\'');
        } else {
            if (iD != 13) {
                throw new IllegalStateException("Expected a name but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
            }
            strT = t('\"');
        }
        this.f3047h = 0;
        this.f3052n[this.f3051m - 1] = strT;
        return strT;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int r(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.b.r(boolean):int");
    }

    public void s() throws IOException {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 7) {
            throw new IllegalStateException("Expected null but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
        }
        this.f3047h = 0;
        int[] iArr = this.f3053o;
        int i = this.f3051m - 1;
        iArr[i] = iArr[i] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r10.d = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r1.append(r5, r3, r2 - r3);
        r10.d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String t(char r11) throws com.google.gson.stream.d {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.d
            int r3 = r10.e
        L6:
            r4 = r3
            r3 = r2
        L8:
            char[] r5 = r10.c
            r6 = 1
            r7 = 16
            if (r2 >= r4) goto L5b
            int r8 = r2 + 1
            char r2 = r5[r2]
            if (r2 != r11) goto L29
            r10.d = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L21
            java.lang.String r11 = new java.lang.String
            r11.<init>(r5, r3, r8)
            return r11
        L21:
            r1.append(r5, r3, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L29:
            r9 = 92
            if (r2 != r9) goto L4e
            r10.d = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L3f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r7)
            r1.<init>(r4)
        L3f:
            r1.append(r5, r3, r2)
            char r2 = r10.y()
            r1.append(r2)
            int r2 = r10.d
            int r3 = r10.e
            goto L6
        L4e:
            r5 = 10
            if (r2 != r5) goto L59
            int r2 = r10.f3045f
            int r2 = r2 + r6
            r10.f3045f = r2
            r10.f3046g = r8
        L59:
            r2 = r8
            goto L8
        L5b:
            if (r1 != 0) goto L6b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r7)
            r4.<init>(r1)
            r1 = r4
        L6b:
            int r4 = r2 - r3
            r1.append(r5, r3, r4)
            r10.d = r2
            boolean r2 = r10.g(r6)
            if (r2 == 0) goto L79
            goto L2
        L79:
            java.lang.String r11 = "Unterminated string"
            r10.D(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.b.t(char):java.lang.String");
    }

    public String toString() {
        return getClass().getSimpleName() + l();
    }

    public String u() throws IOException {
        String str;
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 10) {
            str = v();
        } else if (iD == 8) {
            str = t('\'');
        } else if (iD == 9) {
            str = t('\"');
        } else if (iD == 11) {
            str = this.f3049k;
            this.f3049k = null;
        } else if (iD == 15) {
            str = Long.toString(this.i);
        } else {
            if (iD != 16) {
                throw new IllegalStateException("Expected a string but was " + androidx.constraintlayout.core.motion.a.C(w()) + l());
            }
            str = new String(this.c, this.d, this.f3048j);
            this.d += this.f3048j;
        }
        this.f3047h = 0;
        int[] iArr = this.f3053o;
        int i = this.f3051m - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        c();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String v() throws com.google.gson.stream.d {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.d
            int r4 = r3 + r2
            int r5 = r7.e
            char[] r6 = r7.c
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.c()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.g(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.d
            r0.append(r6, r3, r2)
            int r3 = r7.d
            int r3 = r3 + r2
            r7.d = r3
            r2 = 1
            boolean r2 = r7.g(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.d
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.d
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.d
            int r2 = r2 + r1
            r7.d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.b.v():java.lang.String");
    }

    public int w() {
        int iD = this.f3047h;
        if (iD == 0) {
            iD = d();
        }
        switch (iD) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void x(int i) {
        int i3 = this.f3051m;
        int[] iArr = this.f3050l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f3050l = Arrays.copyOf(iArr, i4);
            this.f3053o = Arrays.copyOf(this.f3053o, i4);
            this.f3052n = (String[]) Arrays.copyOf(this.f3052n, i4);
        }
        int[] iArr2 = this.f3050l;
        int i5 = this.f3051m;
        this.f3051m = i5 + 1;
        iArr2[i5] = i;
    }

    public final char y() throws d {
        int i;
        if (this.d == this.e && !g(1)) {
            D("Unterminated escape sequence");
            throw null;
        }
        int i3 = this.d;
        int i4 = i3 + 1;
        this.d = i4;
        char[] cArr = this.c;
        char c = cArr[i3];
        if (c == '\n') {
            this.f3045f++;
            this.f3046g = i4;
            return c;
        }
        if (c == '\"' || c == '\'' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return '\r';
        }
        if (c == 't') {
            return '\t';
        }
        if (c != 'u') {
            D("Invalid escape sequence");
            throw null;
        }
        if (i3 + 5 > this.e && !g(4)) {
            D("Unterminated escape sequence");
            throw null;
        }
        int i5 = this.d;
        int i6 = i5 + 4;
        char c6 = 0;
        while (i5 < i6) {
            char c7 = cArr[i5];
            char c8 = (char) (c6 << 4);
            if (c7 >= '0' && c7 <= '9') {
                i = c7 - '0';
            } else if (c7 >= 'a' && c7 <= 'f') {
                i = c7 - 'W';
            } else {
                if (c7 < 'A' || c7 > 'F') {
                    throw new NumberFormatException("\\u".concat(new String(cArr, this.d, 4)));
                }
                i = c7 - '7';
            }
            c6 = (char) (i + c8);
            i5++;
        }
        this.d += 4;
        return c6;
    }

    public final void z(char c) throws d {
        do {
            int i = this.d;
            int i3 = this.e;
            while (i < i3) {
                int i4 = i + 1;
                char c6 = this.c[i];
                if (c6 == c) {
                    this.d = i4;
                    return;
                }
                if (c6 == '\\') {
                    this.d = i4;
                    y();
                    i = this.d;
                    i3 = this.e;
                } else {
                    if (c6 == '\n') {
                        this.f3045f++;
                        this.f3046g = i4;
                    }
                    i = i4;
                }
            }
            this.d = i;
        } while (g(1));
        D("Unterminated string");
        throw null;
    }
}
