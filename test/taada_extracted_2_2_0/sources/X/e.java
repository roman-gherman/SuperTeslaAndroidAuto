package X;

import android.view.View;
import z4.C0948a;
import z4.f;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1404a = 0;
    public int b;
    public int c;
    public final Object d;

    public e(C0948a c0948a) {
        int i = c0948a.b;
        this.b = i;
        this.c = c0948a.c;
        this.d = new M3.a[i];
        for (int i3 = 0; i3 < this.b; i3++) {
            ((M3.a[]) this.d)[i3] = new M3.a(c0948a);
        }
    }

    public void a() {
        for (int i = 0; i < this.b; i++) {
            M3.a aVar = ((M3.a[]) this.d)[i];
            short[] sArr = new short[256];
            System.arraycopy((short[]) aVar.d, 0, sArr, 0, 256);
            int i3 = 1;
            for (int i4 = 128; i4 >= 2; i4 >>= 1) {
                int i5 = 0;
                while (i5 < 256) {
                    int i6 = i3 + 1;
                    short s3 = f.f5216a[i3];
                    int i7 = i5;
                    while (i7 < i5 + i4) {
                        int i8 = i7 + i4;
                        short sB = f.b(sArr[i8] * s3);
                        sArr[i8] = (short) (sArr[i7] - sB);
                        sArr[i7] = (short) (sArr[i7] + sB);
                        i7++;
                    }
                    i5 = i7 + i4;
                    i3 = i6;
                }
            }
            aVar.d = sArr;
            aVar.n();
        }
    }

    public byte[] b() {
        byte[] bArr = new byte[this.c];
        for (int i = 0; i < this.b; i++) {
            M3.a aVar = ((M3.a[]) this.d)[i];
            byte[] bArr2 = new byte[384];
            for (int i3 = 0; i3 < 256; i3++) {
                short s3 = (short) (r7[i3] - 3329);
                ((short[]) aVar.d)[i3] = (short) (s3 + ((s3 >> 15) & 3329));
            }
            for (int i4 = 0; i4 < 128; i4++) {
                int i5 = i4 * 2;
                short[] sArr = (short[]) aVar.d;
                short s6 = sArr[i5];
                short s7 = sArr[i5 + 1];
                int i6 = i4 * 3;
                bArr2[i6] = (byte) s6;
                bArr2[i6 + 1] = (byte) ((s6 >> 8) | (s7 << 4));
                bArr2[i6 + 2] = (byte) (s7 >> 4);
            }
            aVar.getClass();
            System.arraycopy(bArr2, 0, bArr, i * 384, 384);
        }
        return bArr;
    }

    public String toString() {
        switch (this.f1404a) {
            case 1:
                StringBuffer stringBuffer = new StringBuffer("[");
                int i = 0;
                while (true) {
                    int i3 = this.b;
                    if (i >= i3) {
                        stringBuffer.append("]");
                        return stringBuffer.toString();
                    }
                    stringBuffer.append(((M3.a[]) this.d)[i].toString());
                    if (i != i3 - 1) {
                        stringBuffer.append(", ");
                    }
                    i++;
                }
                break;
            default:
                return super.toString();
        }
    }

    public e(View view) {
        this.d = view;
    }
}
