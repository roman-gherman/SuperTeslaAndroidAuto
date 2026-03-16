package E0;

import D0.l;
import D0.q;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ChunkedMac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f282a = 0;
    public final q b;

    public b(D0.a aVar) throws GeneralSecurityException {
        if (!com.google.protobuf.a.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        this.b = aVar;
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public final ChunkedMacComputation createComputation() {
        switch (this.f282a) {
            case 0:
                return new a((D0.a) this.b);
            default:
                return new d((l) this.b);
        }
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public final ChunkedMacVerification createVerification(byte[] bArr) throws GeneralSecurityException {
        switch (this.f282a) {
            case 0:
                int length = bArr.length;
                D0.a aVar = (D0.a) this.b;
                I0.a aVar2 = aVar.c;
                byte[] bArr2 = aVar2.f749a;
                if (length < bArr2.length) {
                    throw new GeneralSecurityException("Tag too short");
                }
                if (aVar2.equals(new I0.a(bArr, bArr2.length))) {
                    return new c(aVar, bArr);
                }
                throw new GeneralSecurityException("Wrong tag prefix");
            default:
                int length2 = bArr.length;
                l lVar = (l) this.b;
                I0.a aVar3 = lVar.c;
                byte[] bArr3 = aVar3.f749a;
                if (length2 < bArr3.length) {
                    throw new GeneralSecurityException("Tag too short");
                }
                if (aVar3.equals(new I0.a(bArr, bArr3.length))) {
                    return new c(lVar, bArr);
                }
                throw new GeneralSecurityException("Wrong tag prefix");
        }
    }

    public b(l lVar) throws GeneralSecurityException {
        if (com.google.protobuf.a.b(2)) {
            this.b = lVar;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
