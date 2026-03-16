package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class J1 extends AbstractC0272d1 implements zzin {
    private static final J1 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private N1 zzh;

    static {
        J1 j12 = new J1();
        zzb = j12;
        AbstractC0272d1.j(J1.class, j12);
    }

    public static J1 m(byte[] bArr, X0 x02) throws C0284h1 {
        AbstractC0272d1 abstractC0272d1 = zzb;
        int length = bArr.length;
        if (length != 0) {
            AbstractC0272d1 abstractC0272d12 = (AbstractC0272d1) abstractC0272d1.d(4);
            try {
                zzix zzixVarA = C0316s1.c.a(abstractC0272d12.getClass());
                N0 n02 = new N0();
                x02.getClass();
                zzixVarA.zzh(abstractC0272d12, bArr, 0, length, n02);
                zzixVarA.zzf(abstractC0272d12);
                abstractC0272d1 = abstractC0272d12;
            } catch (C0284h1 e) {
                throw e;
            } catch (C0331x1 e6) {
                throw new C0284h1(e6.getMessage());
            } catch (IOException e7) {
                if (e7.getCause() instanceof C0284h1) {
                    throw ((C0284h1) e7.getCause());
                }
                throw new C0284h1(e7.getMessage(), e7);
            } catch (IndexOutOfBoundsException unused) {
                throw new C0284h1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
        }
        if (abstractC0272d1 == null || AbstractC0272d1.l(abstractC0272d1, true)) {
            return (J1) abstractC0272d1;
        }
        throw new C0284h1(new C0331x1().getMessage());
    }

    public static /* synthetic */ void n(J1 j12, N1 n12) {
        j12.zzh = n12;
        j12.zzd |= 2;
    }

    public static /* synthetic */ void o(J1 j12, int i) {
        j12.zzg = i - 1;
        j12.zzd |= 1;
    }

    public static I1 p() {
        return (I1) zzb.e();
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", J0.c, "zzh", W1.class});
        }
        if (i3 == 3) {
            return new J1();
        }
        if (i3 == 4) {
            return new I1(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
