package r4;

import io.ktor.utils.io.jvm.javaio.q;
import kotlin.reflect.l;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends q {
    public final /* synthetic */ int b;

    public /* synthetic */ e(int i) {
        this.b = i;
    }

    @Override // io.ktor.utils.io.jvm.javaio.q
    public final short k(short s3) {
        switch (this.b) {
            case 0:
                short sL = l(s(s3), s3);
                short sL2 = l(s(s(sL)), sL);
                return s(l(s(l(s(s(l(s(s(s(s(sL2)))), sL2))), sL)), s3));
            default:
                short sU = u(s3, s3);
                short sT = t(sU, sU);
                return u(t(r(l.r(r(l.r(t(r(l.r(r(l.r(sT)))), sT))))), sT), (short) 1);
        }
    }

    @Override // io.ktor.utils.io.jvm.javaio.q
    public final short l(short s3, short s6) {
        switch (this.b) {
            case 0:
                int i = (s6 & 1) * s3;
                for (int i3 = 1; i3 < 12; i3++) {
                    i ^= ((1 << i3) & s6) * s3;
                }
                return r(i);
            default:
                int i4 = (s6 & 1) * s3;
                for (int i5 = 1; i5 < 13; i5++) {
                    i4 ^= ((1 << i5) & s6) * s3;
                }
                return r(i4);
        }
    }

    public final short r(int i) {
        switch (this.b) {
            case 0:
                return (short) ((i >>> 21) ^ ((((i & 4095) ^ (i >>> 12)) ^ ((2093056 & i) >>> 9)) ^ ((14680064 & i) >>> 18)));
            default:
                int i3 = i & 8191;
                int i4 = i >>> 13;
                int i5 = ((i4 << 4) ^ (i4 << 3)) ^ (i4 << 1);
                int i6 = i5 >>> 13;
                return (short) ((((i4 ^ i3) ^ i6) ^ (i5 & 8191)) ^ (((i6 << 4) ^ (i6 << 3)) ^ (i6 << 1)));
        }
    }

    public short s(short s3) {
        return r(l.r(s3));
    }

    public short t(short s3, short s6) {
        long j6 = s3;
        long j7 = s6;
        long j8 = (j7 << 18) * (64 & j6);
        long j9 = j6 ^ (j6 << 21);
        long j10 = ((j7 << 15) * (j9 & 8589934624L)) ^ (((((j8 ^ ((268435457 & j9) * j7)) ^ ((j7 << 3) * (536870914 & j9))) ^ ((j7 << 6) * (1073741828 & j9))) ^ ((j7 << 9) * (2147483656L & j9))) ^ ((j7 << 12) * (4294967312L & j9)));
        long j11 = 2305834213120671744L & j10;
        long j12 = j10 ^ ((j11 >>> 26) ^ (((j11 >>> 18) ^ (j11 >>> 20)) ^ (j11 >>> 24)));
        long j13 = 8796025913344L & j12;
        return r(((int) (j12 ^ ((j13 >>> 26) ^ (((j13 >>> 18) ^ (j13 >>> 20)) ^ (j13 >>> 24))))) & 67108863);
    }

    public short u(short s3, short s6) {
        long j6 = s3;
        long j7 = s6;
        long j8 = (j7 << 6) * (64 & j6);
        long j9 = j6 ^ (j6 << 7);
        long j10 = ((j7 << 5) * (j9 & 524320)) ^ (((((j8 ^ ((16385 & j9) * j7)) ^ ((j7 << 1) * (32770 & j9))) ^ ((j7 << 2) * (65540 & j9))) ^ ((j7 << 3) * (131080 & j9))) ^ ((j7 << 4) * (262160 & j9)));
        long j11 = 137371844608L & j10;
        return r(((int) (j10 ^ ((j11 >>> 26) ^ (((j11 >>> 18) ^ (j11 >>> 20)) ^ (j11 >>> 24))))) & 67108863);
    }
}
