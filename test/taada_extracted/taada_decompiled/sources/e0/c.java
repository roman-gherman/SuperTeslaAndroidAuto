package E0;

import D0.l;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ChunkedMacVerification {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f283a = 0;
    public final I0.a b;
    public final ChunkedMacComputation c;

    public c(D0.a aVar, byte[] bArr) {
        this.c = new a(aVar);
        this.b = I0.a.a(bArr);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public final void update(ByteBuffer byteBuffer) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        switch (this.f283a) {
            case 0:
                ((a) this.c).update(byteBuffer);
                break;
            default:
                ((d) this.c).update(byteBuffer);
                break;
        }
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public final void verifyMac() throws GeneralSecurityException {
        switch (this.f283a) {
            case 0:
                if (!this.b.equals(I0.a.a(((a) this.c).computeMac()))) {
                    throw new GeneralSecurityException("invalid MAC");
                }
                return;
            default:
                if (!this.b.equals(I0.a.a(((d) this.c).computeMac()))) {
                    throw new GeneralSecurityException("invalid MAC");
                }
                return;
        }
    }

    public c(l lVar, byte[] bArr) {
        this.c = new d(lVar);
        this.b = I0.a.a(bArr);
    }
}
