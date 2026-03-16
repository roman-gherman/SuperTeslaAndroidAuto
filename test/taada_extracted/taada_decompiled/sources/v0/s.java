package v0;

import G0.C0058h1;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Aead {
    public static final byte[] c = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0058h1 f4920a;
    public final Aead b;

    public s(C0058h1 c0058h1, Aead aead) {
        this.f4920a = c0058h1;
        this.b = aead;
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = byteBufferWrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            byteBufferWrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            byte[] bArrDecrypt = this.b.decrypt(bArr3, c);
            String typeUrl = this.f4920a.getTypeUrl();
            AtomicReference atomicReference = com.google.crypto.tink.m.f2804a;
            C0379n c0379n = AbstractC0381o.b;
            return ((Aead) com.google.crypto.tink.m.c(typeUrl, AbstractC0381o.c(bArrDecrypt, 0, bArrDecrypt.length), Aead.class)).decrypt(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e) {
            e = e;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e6) {
            e = e6;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e7) {
            e = e7;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(byte[] bArr, byte[] bArr2) {
        MessageLite messageLiteNewKey;
        C0058h1 c0058h1 = this.f4920a;
        AtomicReference atomicReference = com.google.crypto.tink.m.f2804a;
        synchronized (com.google.crypto.tink.m.class) {
            KeyManager keyManagerD = com.google.crypto.tink.m.d(c0058h1.getTypeUrl());
            if (!((Boolean) com.google.crypto.tink.m.c.get(c0058h1.getTypeUrl())).booleanValue()) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + c0058h1.getTypeUrl());
            }
            messageLiteNewKey = keyManagerD.newKey(c0058h1.getValue());
        }
        byte[] byteArray = messageLiteNewKey.toByteArray();
        byte[] bArrEncrypt = this.b.encrypt(byteArray, c);
        String typeUrl = this.f4920a.getTypeUrl();
        C0379n c0379n = AbstractC0381o.b;
        byte[] bArrEncrypt2 = ((Aead) com.google.crypto.tink.m.c(typeUrl, AbstractC0381o.c(byteArray, 0, byteArray.length), Aead.class)).encrypt(bArr, bArr2);
        return ByteBuffer.allocate(bArrEncrypt.length + 4 + bArrEncrypt2.length).putInt(bArrEncrypt.length).put(bArrEncrypt).put(bArrEncrypt2).array();
    }
}
