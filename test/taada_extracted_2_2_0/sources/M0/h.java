package M0;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes.dex */
public final class h extends com.google.gson.stream.b {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final g f995t = new g();
    public static final Object u = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Object[] f996p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String[] f997r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f998s;

    @Override // com.google.gson.stream.b
    public final void C() {
        int iB = f.s.b(w());
        if (iB == 1) {
            e();
            return;
        }
        if (iB != 9) {
            if (iB == 3) {
                f();
                return;
            }
            if (iB == 4) {
                H(true);
                return;
            }
            J();
            int i = this.q;
            if (i > 0) {
                int[] iArr = this.f998s;
                int i3 = i - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    public final void E(int i) {
        if (w() == i) {
            return;
        }
        throw new IllegalStateException("Expected " + androidx.constraintlayout.core.motion.a.C(i) + " but was " + androidx.constraintlayout.core.motion.a.C(w()) + G());
    }

    public final String F(boolean z6) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i3 = this.q;
            if (i >= i3) {
                return sb.toString();
            }
            Object[] objArr = this.f996p;
            Object obj = objArr[i];
            if (obj instanceof com.google.gson.o) {
                i++;
                if (i < i3 && (objArr[i] instanceof Iterator)) {
                    int i4 = this.f998s[i];
                    if (z6 && i4 > 0 && (i == i3 - 1 || i == i3 - 2)) {
                        i4--;
                    }
                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                    sb.append(i4);
                    sb.append(']');
                }
            } else if ((obj instanceof com.google.gson.s) && (i = i + 1) < i3 && (objArr[i] instanceof Iterator)) {
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                String str = this.f997r[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    public final String G() {
        return " at path " + F(false);
    }

    public final String H(boolean z6) {
        E(5);
        Map.Entry entry = (Map.Entry) ((Iterator) I()).next();
        String str = (String) entry.getKey();
        this.f997r[this.q - 1] = z6 ? "<skipped>" : str;
        K(entry.getValue());
        return str;
    }

    public final Object I() {
        return this.f996p[this.q - 1];
    }

    public final Object J() {
        Object[] objArr = this.f996p;
        int i = this.q - 1;
        this.q = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final void K(Object obj) {
        int i = this.q;
        Object[] objArr = this.f996p;
        if (i == objArr.length) {
            int i3 = i * 2;
            this.f996p = Arrays.copyOf(objArr, i3);
            this.f998s = Arrays.copyOf(this.f998s, i3);
            this.f997r = (String[]) Arrays.copyOf(this.f997r, i3);
        }
        Object[] objArr2 = this.f996p;
        int i4 = this.q;
        this.q = i4 + 1;
        objArr2[i4] = obj;
    }

    @Override // com.google.gson.stream.b
    public final void a() {
        E(1);
        K(((com.google.gson.o) I()).f3039a.iterator());
        this.f998s[this.q - 1] = 0;
    }

    @Override // com.google.gson.stream.b
    public final void b() {
        E(3);
        K(((com.google.gson.internal.l) ((com.google.gson.s) I()).f3042a.entrySet()).iterator());
    }

    @Override // com.google.gson.stream.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f996p = new Object[]{u};
        this.q = 1;
    }

    @Override // com.google.gson.stream.b
    public final void e() {
        E(2);
        J();
        J();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.f998s;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.b
    public final void f() {
        E(4);
        this.f997r[this.q - 1] = null;
        J();
        J();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.f998s;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.b
    public final String getPath() {
        return F(false);
    }

    @Override // com.google.gson.stream.b
    public final String i() {
        return F(true);
    }

    @Override // com.google.gson.stream.b
    public final boolean j() {
        int iW = w();
        return (iW == 4 || iW == 2 || iW == 10) ? false : true;
    }

    @Override // com.google.gson.stream.b
    public final boolean m() {
        E(8);
        boolean zB = ((com.google.gson.v) J()).b();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.f998s;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return zB;
    }

    @Override // com.google.gson.stream.b
    public final double n() throws com.google.gson.stream.d {
        int iW = w();
        if (iW != 7 && iW != 6) {
            throw new IllegalStateException("Expected " + androidx.constraintlayout.core.motion.a.C(7) + " but was " + androidx.constraintlayout.core.motion.a.C(iW) + G());
        }
        com.google.gson.v vVar = (com.google.gson.v) I();
        double dDoubleValue = vVar.f3061a instanceof Number ? vVar.c().doubleValue() : Double.parseDouble(vVar.a());
        if (!this.b && (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue))) {
            throw new com.google.gson.stream.d("JSON forbids NaN and infinities: " + dDoubleValue);
        }
        J();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.f998s;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return dDoubleValue;
    }

    @Override // com.google.gson.stream.b
    public final int o() {
        int iW = w();
        if (iW != 7 && iW != 6) {
            throw new IllegalStateException("Expected " + androidx.constraintlayout.core.motion.a.C(7) + " but was " + androidx.constraintlayout.core.motion.a.C(iW) + G());
        }
        com.google.gson.v vVar = (com.google.gson.v) I();
        int iIntValue = vVar.f3061a instanceof Number ? vVar.c().intValue() : Integer.parseInt(vVar.a());
        J();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.f998s;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return iIntValue;
    }

    @Override // com.google.gson.stream.b
    public final long p() {
        int iW = w();
        if (iW != 7 && iW != 6) {
            throw new IllegalStateException("Expected " + androidx.constraintlayout.core.motion.a.C(7) + " but was " + androidx.constraintlayout.core.motion.a.C(iW) + G());
        }
        com.google.gson.v vVar = (com.google.gson.v) I();
        long jLongValue = vVar.f3061a instanceof Number ? vVar.c().longValue() : Long.parseLong(vVar.a());
        J();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.f998s;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return jLongValue;
    }

    @Override // com.google.gson.stream.b
    public final String q() {
        return H(false);
    }

    @Override // com.google.gson.stream.b
    public final void s() {
        E(9);
        J();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.f998s;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.b
    public final String toString() {
        return h.class.getSimpleName() + G();
    }

    @Override // com.google.gson.stream.b
    public final String u() {
        int iW = w();
        if (iW != 6 && iW != 7) {
            throw new IllegalStateException("Expected " + androidx.constraintlayout.core.motion.a.C(6) + " but was " + androidx.constraintlayout.core.motion.a.C(iW) + G());
        }
        String strA = ((com.google.gson.v) J()).a();
        int i = this.q;
        if (i > 0) {
            int[] iArr = this.f998s;
            int i3 = i - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return strA;
    }

    @Override // com.google.gson.stream.b
    public final int w() {
        if (this.q == 0) {
            return 10;
        }
        Object objI = I();
        if (objI instanceof Iterator) {
            boolean z6 = this.f996p[this.q - 2] instanceof com.google.gson.s;
            Iterator it = (Iterator) objI;
            if (!it.hasNext()) {
                return z6 ? 4 : 2;
            }
            if (z6) {
                return 5;
            }
            K(it.next());
            return w();
        }
        if (objI instanceof com.google.gson.s) {
            return 3;
        }
        if (objI instanceof com.google.gson.o) {
            return 1;
        }
        if (objI instanceof com.google.gson.v) {
            Serializable serializable = ((com.google.gson.v) objI).f3061a;
            if (serializable instanceof String) {
                return 6;
            }
            if (serializable instanceof Boolean) {
                return 8;
            }
            if (serializable instanceof Number) {
                return 7;
            }
            throw new AssertionError();
        }
        if (objI instanceof com.google.gson.r) {
            return 9;
        }
        if (objI == u) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new com.google.gson.stream.d("Custom JsonElement subclass " + objI.getClass().getName() + " is not supported");
    }
}
