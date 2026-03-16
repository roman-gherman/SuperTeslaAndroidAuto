package w3;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Z f5060a;
    public static final k0 b;

    static {
        Z z6 = new Z(1);
        z6.d = -1;
        f5060a = z6;
        k0 k0Var = new k0();
        k0Var.d = -1;
        b = k0Var;
    }

    public static Z a(C0886d c0886d) {
        if (c0886d.b < 1) {
            return f5060a;
        }
        Z z6 = new Z(c0886d, 1);
        z6.d = -1;
        return z6;
    }

    public static k0 b(C0886d c0886d) {
        if (c0886d.b < 1) {
            return b;
        }
        k0 k0Var = new k0(c0886d);
        k0Var.d = -1;
        return k0Var;
    }
}
