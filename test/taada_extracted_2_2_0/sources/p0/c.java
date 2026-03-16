package P0;

import java.sql.Date;
import java.sql.Timestamp;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f1197a;
    public static final b b;
    public static final b c;
    public static final M0.a d;
    public static final M0.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final M0.a f1198f;

    static {
        boolean z6;
        try {
            Class.forName("java.sql.Date");
            z6 = true;
        } catch (ClassNotFoundException unused) {
            z6 = false;
        }
        f1197a = z6;
        if (z6) {
            b = new b(Date.class, 0);
            c = new b(Timestamp.class, 1);
            d = a.c;
            e = a.d;
            f1198f = a.e;
            return;
        }
        b = null;
        c = null;
        d = null;
        e = null;
        f1198f = null;
    }
}
