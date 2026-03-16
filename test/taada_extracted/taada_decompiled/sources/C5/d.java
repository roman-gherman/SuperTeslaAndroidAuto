package C5;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.LoggingEvent;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f177a;
    public volatile Logger b;
    public Boolean c;
    public Method d;
    public B5.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedBlockingQueue f178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f179g;

    public d(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z6) {
        this.f177a = str;
        this.f178f = linkedBlockingQueue;
        this.f179g = z6;
    }

    public final Logger a() {
        if (this.b != null) {
            return this.b;
        }
        if (this.f179g) {
            return b.f176a;
        }
        if (this.e == null) {
            B5.a aVar = new B5.a();
            aVar.b = this;
            aVar.f131a = this.f177a;
            aVar.c = this.f178f;
            this.e = aVar;
        }
        return this.e;
    }

    public final boolean b() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.d = this.b.getClass().getMethod("log", LoggingEvent.class);
            this.c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.c = Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    @Override // org.slf4j.Logger
    public final void debug(String str) {
        a().debug(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && d.class == obj.getClass() && this.f177a.equals(((d) obj).f177a);
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
        a().error(str);
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.f177a;
    }

    public final int hashCode() {
        return this.f177a.hashCode();
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
        a().info(str);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return a().isDebugEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return a().isErrorEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return a().isInfoEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return a().isTraceEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return a().isWarnEnabled();
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
        a().trace(str);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
        a().warn(str);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj) {
        a().debug(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj) {
        a().error(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj) {
        a().info(str, obj);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled(Marker marker) {
        return a().isDebugEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled(Marker marker) {
        return a().isErrorEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled(Marker marker) {
        return a().isInfoEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled(Marker marker) {
        return a().isTraceEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled(Marker marker) {
        return a().isWarnEnabled(marker);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj) {
        a().trace(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj) {
        a().warn(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj, Object obj2) {
        a().debug(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj, Object obj2) {
        a().error(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj, Object obj2) {
        a().info(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj, Object obj2) {
        a().trace(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj, Object obj2) {
        a().warn(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object... objArr) {
        a().debug(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object... objArr) {
        a().error(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object... objArr) {
        a().info(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object... objArr) {
        a().trace(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object... objArr) {
        a().warn(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
        a().debug(str, th);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
        a().error(str, th);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
        a().info(str, th);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
        a().trace(str, th);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
        a().warn(str, th);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str) {
        a().debug(marker, str);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str) {
        a().error(marker, str);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str) {
        a().info(marker, str);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str) {
        a().trace(marker, str);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str) {
        a().warn(marker, str);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj) {
        a().debug(marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj) {
        a().error(marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj) {
        a().info(marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj) {
        a().trace(marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj) {
        a().warn(marker, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj, Object obj2) {
        a().debug(marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj, Object obj2) {
        a().error(marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj, Object obj2) {
        a().info(marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj, Object obj2) {
        a().trace(marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj, Object obj2) {
        a().warn(marker, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object... objArr) {
        a().debug(marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object... objArr) {
        a().error(marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object... objArr) {
        a().info(marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object... objArr) {
        a().trace(marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object... objArr) {
        a().warn(marker, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Throwable th) {
        a().debug(marker, str, th);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Throwable th) {
        a().error(marker, str, th);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Throwable th) {
        a().info(marker, str, th);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Throwable th) {
        a().trace(marker, str, th);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Throwable th) {
        a().warn(marker, str, th);
    }
}
