package C0;

import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.H;
import w3.W;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f142a;
    public final Class b;

    public /* synthetic */ d(Class cls, int i) {
        this.f142a = i;
        this.b = cls;
    }

    public static void j(InputStream inputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i3 = inputStream.read(bArr, i, length - i);
            if (i3 == -1) {
                throw new GeneralSecurityException("Not enough pseudorandomness provided");
            }
            i += i3;
        }
    }

    public void a(AbstractC0899q abstractC0899q) {
        if (!this.b.isInstance(abstractC0899q)) {
            throw new IllegalStateException("unexpected object: ".concat(abstractC0899q.getClass().getName()));
        }
    }

    public abstract MessageLite b(MessageLite messageLite);

    public MessageLite c(MessageLite messageLite, InputStream inputStream) throws GeneralSecurityException {
        throw new GeneralSecurityException("deriveKey not implemented for key of type " + this.b);
    }

    public AbstractC0899q d(byte[] bArr) throws IOException {
        AbstractC0899q abstractC0899qG = AbstractC0899q.g(bArr);
        a(abstractC0899qG);
        return abstractC0899qG;
    }

    public AbstractC0899q e(AbstractC0902u abstractC0902u) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    public boolean equals(Object obj) {
        switch (this.f142a) {
            case 1:
                return this == obj;
            default:
                return super.equals(obj);
        }
    }

    public AbstractC0899q f(W w5) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    public AbstractC0899q g(H h3, boolean z6) {
        io.ktor.utils.io.internal.t.e(h3);
        AbstractC0899q abstractC0899qK = h3.k(z6, this);
        a(abstractC0899qK);
        return abstractC0899qK;
    }

    public Map h() {
        return Collections.EMPTY_MAP;
    }

    public abstract MessageLite i(AbstractC0381o abstractC0381o);

    public abstract void k(MessageLite messageLite);
}
