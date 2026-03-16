package fi.iki.elonen;

import a1.b;
import a1.c;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface NanoHTTPD$IHTTPSession {
    void execute();

    b getCookies();

    Map<String, String> getHeaders();

    InputStream getInputStream();

    c getMethod();

    Map<String, List<String>> getParameters();

    @Deprecated
    Map<String, String> getParms();

    String getQueryParameterString();

    String getRemoteHostName();

    String getRemoteIpAddress();

    String getUri();

    void parseBody(Map<String, String> map);
}
