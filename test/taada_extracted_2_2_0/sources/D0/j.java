package D0;

import com.google.crypto.tink.mac.ChunkedMacVerification;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class j implements ChunkedMacVerification {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f241a;

    public j(ArrayList arrayList) {
        this.f241a = arrayList;
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public final void update(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.mark();
        for (ChunkedMacVerification chunkedMacVerification : this.f241a) {
            byteBufferDuplicate.reset();
            chunkedMacVerification.update(byteBufferDuplicate);
        }
        byteBuffer.position(byteBuffer.limit());
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public final void verifyMac() throws GeneralSecurityException {
        GeneralSecurityException generalSecurityException = new GeneralSecurityException("MAC verification failed for all suitable keys in keyset");
        Iterator it = this.f241a.iterator();
        while (it.hasNext()) {
            try {
                ((ChunkedMacVerification) it.next()).verifyMac();
                return;
            } catch (GeneralSecurityException e) {
                generalSecurityException.addSuppressed(e);
            }
        }
        throw generalSecurityException;
    }
}
