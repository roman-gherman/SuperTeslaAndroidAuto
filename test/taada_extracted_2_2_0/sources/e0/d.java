package E0;

import D0.f;
import D0.l;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.subtle.p;
import com.google.crypto.tink.subtle.q;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class d implements ChunkedMacComputation {
    public static final byte[] d = {0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Mac f284a;
    public final l b;
    public boolean c = false;

    public d(l lVar) throws InvalidKeyException {
        Mac mac = (Mac) p.c.a("HMAC" + lVar.f243a.d);
        this.f284a = mac;
        mac.init(new SecretKeySpec(((I0.a) lVar.b.b).b(), "HMAC"));
        this.b = lVar;
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public final byte[] computeMac() {
        if (this.c) {
            throw new IllegalStateException("Cannot compute after already computing the MAC tag. Please create a new object.");
        }
        l lVar = this.b;
        if (lVar.f243a.c == f.f235n) {
            update(ByteBuffer.wrap(d));
        }
        this.c = true;
        return q.b(lVar.c.b(), Arrays.copyOf(this.f284a.doFinal(), lVar.f243a.b));
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public final void update(ByteBuffer byteBuffer) {
        if (this.c) {
            throw new IllegalStateException("Cannot update after computing the MAC tag. Please create a new object.");
        }
        this.f284a.update(byteBuffer);
    }
}
