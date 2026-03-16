package u1;

import java.util.LinkedHashMap;
import java.util.List;
import org.java_websocket.WebSocketImpl;

/* JADX INFO: renamed from: u1.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0832A {
    public static final C0832A c;
    public static final LinkedHashMap d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4845a;
    public final int b;

    static {
        C0832A c0832a = new C0832A("http", 80);
        c = c0832a;
        List listY = kotlin.collections.n.y(c0832a, new C0832A("https", WebSocketImpl.DEFAULT_WSS_PORT), new C0832A("ws", 80), new C0832A("wss", WebSocketImpl.DEFAULT_WSS_PORT), new C0832A("socks", 1080));
        int iF = kotlin.collections.B.F(kotlin.collections.o.D(listY));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        for (Object obj : listY) {
            linkedHashMap.put(((C0832A) obj).f4845a, obj);
        }
        d = linkedHashMap;
    }

    public C0832A(String str, int i) {
        this.f4845a = str;
        this.b = i;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.toLowerCase(cCharAt) != cCharAt) {
                throw new IllegalArgumentException("All characters should be lower case");
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0832A)) {
            return false;
        }
        C0832A c0832a = (C0832A) obj;
        return this.f4845a.equals(c0832a.f4845a) && this.b == c0832a.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f4845a.hashCode() * 31);
    }

    public final String toString() {
        return "URLProtocol(name=" + this.f4845a + ", defaultPort=" + this.b + ')';
    }
}
