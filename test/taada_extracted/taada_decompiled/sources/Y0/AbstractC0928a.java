package y0;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: renamed from: y0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0928a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5127a = Logger.getLogger(AbstractC0928a.class.getName());
    public static final AtomicBoolean b = new AtomicBoolean(false);

    public static boolean a() {
        return b.get();
    }
}
