package E4;

import L3.h;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SecureRandom {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f321a;
    public final byte[] b;

    public b(byte[] bArr, N3.b bVar) {
        if (bArr.length >= 48) {
            byte[] bArr2 = new byte[48];
            System.arraycopy(bArr, 0, bArr2, 0, 48);
            byte[] bArr3 = new byte[32];
            this.f321a = bArr3;
            byte[] bArr4 = new byte[16];
            this.b = bArr4;
            a(bArr2, bArr3, bArr4);
            return;
        }
        int length = 48 - bArr.length;
        int digestSize = bVar.getDigestSize();
        bVar.update(bArr, 0, bArr.length);
        byte[] bArr5 = new byte[digestSize];
        bVar.doFinal(bArr5, 0);
        if (length != digestSize) {
            if (length < digestSize) {
                byte[] bArr6 = new byte[length];
                System.arraycopy(bArr5, 0, bArr6, 0, Math.min(digestSize, length));
                bArr5 = bArr6;
            } else {
                byte[] bArrE = new byte[digestSize];
                System.arraycopy(bArr5, 0, bArrE, 0, Math.min(digestSize, digestSize));
                while (true) {
                    length -= digestSize;
                    if (length < digestSize) {
                        break;
                    }
                    bVar.update(bArr5, 0, digestSize);
                    bArr5 = new byte[digestSize];
                    bVar.doFinal(bArr5, 0);
                    bArrE = g5.c.e(bArrE, bArr5);
                }
                if (length > 0) {
                    bVar.update(bArr5, 0, digestSize);
                    byte[] bArr7 = new byte[digestSize];
                    bVar.doFinal(bArr7, 0);
                    int length2 = bArrE.length;
                    int i = length2 + length;
                    byte[] bArr8 = new byte[i];
                    System.arraycopy(bArrE, 0, bArr8, 0, Math.min(bArrE.length, i));
                    System.arraycopy(bArr7, 0, bArr8, length2, length);
                    bArr5 = bArr8;
                } else {
                    bArr5 = bArrE;
                }
            }
        }
        byte[] bArr9 = new byte[48];
        System.arraycopy(g5.c.e(bArr, bArr5), 0, bArr9, 0, 48);
        byte[] bArr10 = new byte[32];
        this.f321a = bArr10;
        byte[] bArr11 = new byte[16];
        this.b = bArr11;
        a(bArr9, bArr10, bArr11);
    }

    public static void a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[48];
        for (int i = 0; i < 3; i++) {
            int i3 = 15;
            while (true) {
                if (i3 >= 0) {
                    byte b = bArr3[i3];
                    if ((b & 255) != 255) {
                        bArr3[i3] = (byte) (b + 1);
                        break;
                    } else {
                        bArr3[i3] = 0;
                        i3--;
                    }
                }
            }
            b(bArr2, bArr3, bArr4, i * 16);
        }
        if (bArr != null) {
            for (int i4 = 0; i4 < 48; i4++) {
                bArr4[i4] = (byte) (bArr4[i4] ^ bArr[i4]);
            }
        }
        System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
        System.arraycopy(bArr4, 32, bArr3, 0, bArr3.length);
    }

    public static void b(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        try {
            org.bouncycastle.crypto.engines.a aVar = new org.bouncycastle.crypto.engines.a();
            aVar.b = null;
            h.a(new M3.a(256, (CipherParameters) null, L3.c.d));
            int length = bArr.length;
            Q3.e eVar = new Q3.e();
            byte[] bArr4 = new byte[length];
            eVar.f1239a = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, length);
            aVar.init(true, eVar);
            for (int i3 = 0; i3 != bArr2.length; i3 += 16) {
                aVar.processBlock(bArr2, i3, bArr3, i + i3);
            }
        } catch (Throwable th) {
            throw new IllegalStateException("drbg failure: " + th.getMessage(), th);
        }
    }

    @Override // java.security.SecureRandom, java.util.Random
    public final void nextBytes(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int length = bArr.length;
        int i = 0;
        while (length > 0) {
            int i3 = 15;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                byte[] bArr3 = this.b;
                byte b = bArr3[i3];
                if ((b & 255) != 255) {
                    bArr3[i3] = (byte) (b + 1);
                    break;
                } else {
                    bArr3[i3] = 0;
                    i3--;
                }
            }
            b(this.f321a, this.b, bArr2, 0);
            if (length > 15) {
                System.arraycopy(bArr2, 0, bArr, i, 16);
                i += 16;
                length -= 16;
            } else {
                System.arraycopy(bArr2, 0, bArr, i, length);
                length = 0;
            }
        }
        a(null, this.f321a, this.b);
    }
}
