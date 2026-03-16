package B5;

import C5.d;
import org.slf4j.Marker;
import org.slf4j.event.LoggingEvent;

/* JADX INFO: loaded from: classes.dex */
public final class c implements LoggingEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f135a;
    public Marker b;
    public String c;
    public d d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object[] f137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f138h;
    public Throwable i;

    @Override // org.slf4j.event.LoggingEvent
    public final Object[] getArgumentArray() {
        return this.f137g;
    }

    @Override // org.slf4j.event.LoggingEvent
    public final b getLevel() {
        return this.f135a;
    }

    @Override // org.slf4j.event.LoggingEvent
    public final String getLoggerName() {
        return this.c;
    }

    @Override // org.slf4j.event.LoggingEvent
    public final Marker getMarker() {
        return this.b;
    }

    @Override // org.slf4j.event.LoggingEvent
    public final String getMessage() {
        return this.f136f;
    }

    @Override // org.slf4j.event.LoggingEvent
    public final String getThreadName() {
        return this.e;
    }

    @Override // org.slf4j.event.LoggingEvent
    public final Throwable getThrowable() {
        return this.i;
    }

    @Override // org.slf4j.event.LoggingEvent
    public final long getTimeStamp() {
        return this.f138h;
    }
}
