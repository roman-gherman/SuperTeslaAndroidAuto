package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class G0 extends AbstractC0272d1 implements zzin {
    private static final G0 zzb;
    private zzho zzd = C0319t1.e;

    static {
        G0 g0 = new G0();
        zzb = g0;
        AbstractC0272d1.j(G0.class, g0);
    }

    public static F0 m() {
        return (F0) zzb.e();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static void n(G0 g0, Iterable iterable) {
        zzho zzhoVar = g0.zzd;
        if (!zzhoVar.zzc()) {
            int size = zzhoVar.size();
            g0.zzd = zzhoVar.zzd(size + size);
        }
        zzho zzhoVar2 = g0.zzd;
        Charset charset = AbstractC0278f1.f2076a;
        iterable.getClass();
        if (iterable instanceof zzhy) {
            List listZza = ((zzhy) iterable).zza();
            zzhy zzhyVar = (zzhy) zzhoVar2;
            int size2 = zzhoVar2.size();
            for (Object obj : listZza) {
                if (obj == null) {
                    String strD = B2.b.d(zzhyVar.size() - size2, "Element at index ", " is null.");
                    int size3 = zzhyVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size2) {
                            throw new NullPointerException(strD);
                        }
                        zzhyVar.remove(size3);
                    }
                } else if (obj instanceof S0) {
                    zzhyVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    S0.e(bArr, 0, bArr.length);
                    zzhyVar.zzb();
                } else {
                    zzhyVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzit) {
            zzhoVar2.addAll((Collection<? extends E>) ((Collection) iterable));
            return;
        }
        if (iterable instanceof Collection) {
            int size4 = ((Collection) iterable).size();
            if (zzhoVar2 instanceof ArrayList) {
                ((ArrayList) zzhoVar2).ensureCapacity(zzhoVar2.size() + size4);
            }
            if (zzhoVar2 instanceof C0319t1) {
                C0319t1 c0319t1 = (C0319t1) zzhoVar2;
                int i = ((C0319t1) zzhoVar2).c + size4;
                int length = c0319t1.b.length;
                if (i > length) {
                    if (length != 0) {
                        while (length < i) {
                            length = Math.max(((length * 3) / 2) + 1, 10);
                        }
                        c0319t1.b = Arrays.copyOf(c0319t1.b, length);
                    } else {
                        c0319t1.b = new Object[Math.max(i, 10)];
                    }
                }
            }
        }
        int size5 = zzhoVar2.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    AbstractC0269c1.a(size5, zzhoVar2);
                    throw null;
                }
                zzhoVar2.add(obj2);
            }
            return;
        }
        List list = (List) iterable;
        int size6 = list.size();
        for (int i3 = 0; i3 < size6; i3++) {
            Object obj3 = list.get(i3);
            if (obj3 == null) {
                AbstractC0269c1.a(size5, zzhoVar2);
                throw null;
            }
            zzhoVar2.add(obj3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0272d1
    public final Object d(int i) {
        int i3 = i - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new C0322u1(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", E0.class});
        }
        if (i3 == 3) {
            return new G0();
        }
        if (i3 == 4) {
            return new F0(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
