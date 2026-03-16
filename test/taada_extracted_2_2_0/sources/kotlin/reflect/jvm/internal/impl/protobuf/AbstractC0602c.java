package kotlin.reflect.jvm.internal.impl.protobuf;

import com.google.crypto.tink.shaded.protobuf.C0353a;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0602c implements Parser {
    static {
        int i = C0608i.b;
    }

    public static void a(MessageLite messageLite) throws r {
        C0.x xVar;
        if (messageLite == null || messageLite.isInitialized()) {
            return;
        }
        if (messageLite instanceof AbstractC0601b) {
            xVar = new C0.x();
        } else {
            xVar = new C0.x();
        }
        r rVar = new r(xVar.getMessage());
        rVar.f3875a = messageLite;
        throw rVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public final Object parseDelimitedFrom(InputStream inputStream, C0608i c0608i) throws r {
        MessageLite messageLite;
        try {
            int i = inputStream.read();
            if (i == -1) {
                messageLite = null;
            } else {
                if ((i & 128) != 0) {
                    i &= 127;
                    int i3 = 7;
                    while (true) {
                        if (i3 >= 32) {
                            while (i3 < 64) {
                                int i4 = inputStream.read();
                                if (i4 == -1) {
                                    throw r.a();
                                }
                                if ((i4 & 128) != 0) {
                                    i3 += 7;
                                }
                            }
                            throw new r("CodedInputStream encountered a malformed varint.");
                        }
                        int i5 = inputStream.read();
                        if (i5 == -1) {
                            throw r.a();
                        }
                        i |= (i5 & 127) << i3;
                        if ((i5 & 128) == 0) {
                            break;
                        }
                        i3 += 7;
                    }
                }
                C0605f c0605f = new C0605f(new C0353a(inputStream, i, 1));
                MessageLite messageLite2 = (MessageLite) parsePartialFrom(c0605f, c0608i);
                try {
                    c0605f.a(0);
                    messageLite = messageLite2;
                } catch (r e) {
                    e.f3875a = messageLite2;
                    throw e;
                }
            }
            a(messageLite);
            return messageLite;
        } catch (IOException e6) {
            throw new r(e6.getMessage());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public final Object parseFrom(InputStream inputStream, C0608i c0608i) throws r {
        C0605f c0605f = new C0605f(inputStream);
        MessageLite messageLite = (MessageLite) parsePartialFrom(c0605f, c0608i);
        try {
            c0605f.a(0);
            a(messageLite);
            return messageLite;
        } catch (r e) {
            e.f3875a = messageLite;
            throw e;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public final Object parseFrom(AbstractC0604e abstractC0604e, C0608i c0608i) throws r {
        C0605f c0605fH = abstractC0604e.h();
        MessageLite messageLite = (MessageLite) parsePartialFrom(c0605fH, c0608i);
        try {
            c0605fH.a(0);
            a(messageLite);
            return messageLite;
        } catch (r e) {
            e.f3875a = messageLite;
            throw e;
        }
    }
}
