package B5;

import C5.d;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f131a;
    public d b;
    public LinkedBlockingQueue c;

    public final void a(b bVar, Marker marker, String str, Object[] objArr, Throwable th) {
        c cVar = new c();
        cVar.f138h = System.currentTimeMillis();
        cVar.f135a = bVar;
        cVar.d = this.b;
        cVar.c = this.f131a;
        cVar.b = marker;
        cVar.f136f = str;
        cVar.e = Thread.currentThread().getName();
        cVar.f137g = objArr;
        cVar.i = th;
        this.c.add(cVar);
    }

    public final void b(b bVar, Marker marker, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            a(bVar, marker, str, new Object[]{obj}, (Throwable) obj2);
        } else {
            a(bVar, marker, str, new Object[]{obj, obj2}, null);
        }
    }

    public final void c(b bVar, Marker marker, String str, Object[] objArr) {
        Throwable th = null;
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                th = (Throwable) obj;
            }
        }
        Throwable th2 = th;
        if (th2 == null) {
            a(bVar, marker, str, objArr, null);
            return;
        }
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr2, 0, length);
        }
        a(bVar, marker, str, objArr2, th2);
    }

    public final void d(b bVar, Marker marker, String str, Object obj) {
        a(bVar, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str) {
        a(b.DEBUG, null, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
        a(b.ERROR, null, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.f131a;
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
        a(b.INFO, null, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
        a(b.TRACE, null, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
        a(b.WARN, null, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj) {
        d(b.DEBUG, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj) {
        d(b.ERROR, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj) {
        d(b.INFO, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj) {
        d(b.TRACE, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj) {
        d(b.WARN, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj, Object obj2) {
        b(b.DEBUG, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj, Object obj2) {
        b(b.ERROR, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj, Object obj2) {
        b(b.INFO, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj, Object obj2) {
        b(b.TRACE, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj, Object obj2) {
        b(b.WARN, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object... objArr) {
        c(b.DEBUG, null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object... objArr) {
        c(b.ERROR, null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object... objArr) {
        c(b.INFO, null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object... objArr) {
        c(b.TRACE, null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object... objArr) {
        c(b.WARN, null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
        a(b.DEBUG, null, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
        a(b.ERROR, null, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
        a(b.INFO, null, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
        a(b.TRACE, null, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
        a(b.WARN, null, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str) {
        a(b.DEBUG, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str) {
        a(b.ERROR, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str) {
        a(b.INFO, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str) {
        a(b.TRACE, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str) {
        a(b.WARN, marker, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj) {
        d(b.DEBUG, marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj) {
        d(b.ERROR, marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj) {
        d(b.INFO, marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj) {
        d(b.TRACE, marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj) {
        d(b.WARN, marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj, Object obj2) {
        b(b.DEBUG, marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj, Object obj2) {
        b(b.ERROR, marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj, Object obj2) {
        b(b.INFO, marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj, Object obj2) {
        b(b.TRACE, marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj, Object obj2) {
        b(b.WARN, marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object... objArr) {
        c(b.DEBUG, marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object... objArr) {
        c(b.ERROR, marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object... objArr) {
        c(b.INFO, marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object... objArr) {
        c(b.TRACE, marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object... objArr) {
        c(b.WARN, marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Throwable th) {
        a(b.DEBUG, marker, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Throwable th) {
        a(b.ERROR, marker, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Throwable th) {
        a(b.INFO, marker, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Throwable th) {
        a(b.TRACE, marker, str, null, th);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Throwable th) {
        a(b.WARN, marker, str, null, th);
    }
}
