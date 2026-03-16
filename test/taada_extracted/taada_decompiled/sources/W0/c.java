package w0;

import com.google.crypto.tink.subtle.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f4959a;
    public final int b;
    public final /* synthetic */ int c;

    public c(byte[] bArr, int i, int i3) throws InvalidKeyException {
        this.c = i3;
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f4959a = AbstractC0862a.c(bArr);
        this.b = i;
    }

    public final ByteBuffer a(int i, byte[] bArr) {
        int[] iArr;
        int[] iArrC = AbstractC0862a.c(bArr);
        switch (this.c) {
            case 0:
                if (iArrC.length != 3) {
                    throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArrC.length * 32)));
                }
                iArr = new int[16];
                int[] iArr2 = this.f4959a;
                int[] iArr3 = AbstractC0862a.f4957a;
                System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
                System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
                iArr[12] = i;
                System.arraycopy(iArrC, 0, iArr, 13, iArrC.length);
                break;
                break;
            default:
                if (iArrC.length != 6) {
                    throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArrC.length * 32)));
                }
                iArr = new int[16];
                int[] iArr4 = new int[16];
                int[] iArr5 = this.f4959a;
                int[] iArr6 = AbstractC0862a.f4957a;
                System.arraycopy(iArr6, 0, iArr4, 0, iArr6.length);
                System.arraycopy(iArr5, 0, iArr4, iArr6.length, 8);
                iArr4[12] = iArrC[0];
                iArr4[13] = iArrC[1];
                iArr4[14] = iArrC[2];
                iArr4[15] = iArrC[3];
                AbstractC0862a.b(iArr4);
                iArr4[4] = iArr4[12];
                iArr4[5] = iArr4[13];
                iArr4[6] = iArr4[14];
                iArr4[7] = iArr4[15];
                int[] iArrCopyOf = Arrays.copyOf(iArr4, 8);
                System.arraycopy(iArr6, 0, iArr, 0, iArr6.length);
                System.arraycopy(iArrCopyOf, 0, iArr, iArr6.length, 8);
                iArr[12] = i;
                iArr[13] = 0;
                iArr[14] = iArrC[4];
                iArr[15] = iArrC[5];
                break;
                break;
        }
        int[] iArr7 = (int[]) iArr.clone();
        AbstractC0862a.b(iArr7);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = iArr[i3] + iArr7[i3];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArr, 0, 16);
        return byteBufferOrder;
    }

    public final int b() {
        switch (this.c) {
            case 0:
                return 12;
            default:
                return 24;
        }
    }

    public final void c(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != b()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + b());
        }
        int iRemaining = byteBuffer2.remaining();
        int i = iRemaining / 64;
        int i3 = i + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            ByteBuffer byteBufferA = a(this.b + i4, bArr);
            if (i4 == i) {
                q.e(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                q.e(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }
}
