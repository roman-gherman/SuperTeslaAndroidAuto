package io.ktor.http;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import u1.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001a\u0010\r\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0014\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001c\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0004R\u0014\u0010 \u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0004R\u0014\u0010$\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\nR\u0014\u0010&\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0004¨\u0006'"}, d2 = {"Lio/ktor/http/RequestConnectionPoint;", "", "", "getScheme", "()Ljava/lang/String;", "scheme", "getVersion", "version", "", "getPort", "()I", "getPort$annotations", "()V", "port", "getLocalPort", "localPort", "getServerPort", "serverPort", "getHost", "getHost$annotations", "host", "getLocalHost", "localHost", "getServerHost", "serverHost", "getLocalAddress", "localAddress", "getUri", "uri", "Lu1/r;", "getMethod", "()Lu1/r;", "method", "getRemoteHost", "remoteHost", "getRemotePort", "remotePort", "getRemoteAddress", "remoteAddress", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RequestConnectionPoint {
    @NotNull
    String getHost();

    @NotNull
    String getLocalAddress();

    @NotNull
    String getLocalHost();

    int getLocalPort();

    @NotNull
    r getMethod();

    int getPort();

    @NotNull
    String getRemoteAddress();

    @NotNull
    String getRemoteHost();

    int getRemotePort();

    @NotNull
    String getScheme();

    @NotNull
    String getServerHost();

    int getServerPort();

    @NotNull
    String getUri();

    @NotNull
    String getVersion();
}
