package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.zzej;
import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class A implements zzej, Prf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1800a;
    public final Object b;
    public final Object c;
    public final Object d;

    public A(D d, int i, Consumer consumer, Runnable runnable) {
        this.f1800a = i;
        this.b = consumer;
        this.c = runnable;
        this.d = d;
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] bArr, int i) throws InvalidAlgorithmParameterException {
        if (i > this.f1800a) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        com.google.crypto.tink.subtle.t tVar = (com.google.crypto.tink.subtle.t) this.b;
        ((Mac) tVar.get()).update(bArr);
        return Arrays.copyOf(((Mac) tVar.get()).doFinal(), i);
    }

    @Override // com.google.android.gms.internal.play_billing.zzej
    public void zza(Throwable th) {
        boolean z6 = th instanceof TimeoutException;
        D d = (D) this.d;
        if (z6) {
            d.B(114, 28, H.f1818s);
            AbstractC0289j0.g("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            d.B(107, 28, H.f1818s);
            AbstractC0289j0.g("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        ((Runnable) this.c).run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzej
    public void zzb(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() <= 0) {
            ((Runnable) this.c).run();
            return;
        }
        int iIntValue = num.intValue();
        D d = (D) this.d;
        d.getClass();
        C0257h c0257hA = H.a(iIntValue, "Billing override value was set by a license tester.");
        d.B(105, this.f1800a, c0257hA);
        ((Consumer) this.b).accept(c0257hA);
    }

    public A(w4.f fVar, byte[] bArr, int i, byte[] bArr2) {
        this.b = fVar;
        this.c = bArr;
        this.f1800a = i;
        this.d = bArr2;
    }

    public A(String str, SecretKeySpec secretKeySpec) throws GeneralSecurityException {
        com.google.crypto.tink.subtle.t tVar = new com.google.crypto.tink.subtle.t(this);
        this.b = tVar;
        if (com.google.protobuf.a.b(2)) {
            this.c = str;
            this.d = secretKeySpec;
            if (secretKeySpec.getEncoded().length >= 16) {
                switch (str) {
                    case "HMACSHA1":
                        this.f1800a = 20;
                        break;
                    case "HMACSHA224":
                        this.f1800a = 28;
                        break;
                    case "HMACSHA256":
                        this.f1800a = 32;
                        break;
                    case "HMACSHA384":
                        this.f1800a = 48;
                        break;
                    case "HMACSHA512":
                        this.f1800a = 64;
                        break;
                    default:
                        throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(str));
                }
                tVar.get();
                return;
            }
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    public A(List list) {
        int i;
        this.f1800a = ((com.google.android.material.color.a) B2.b.b(1, list)).c + 1;
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(Short.valueOf(((com.google.android.material.color.a) it.next()).c));
        }
        this.c = new int[this.f1800a];
        short s3 = 0;
        while (true) {
            i = this.f1800a;
            if (s3 >= i) {
                break;
            }
            if (hashSet.contains(Short.valueOf(s3))) {
                ((int[]) this.c)[s3] = 1073741824;
            }
            s3 = (short) (s3 + 1);
        }
        this.b = new com.google.android.material.color.d((short) 514, (short) 16, (i * 4) + 16);
        Y0.b bVar = new Y0.b();
        byte[] bArr = new byte[64];
        bVar.c = bArr;
        bVar.f1478a = i;
        bArr[0] = 64;
        bVar.e = new com.google.android.material.color.e[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            ((com.google.android.material.color.e[]) bVar.e)[i3] = new com.google.android.material.color.e(i3, ((com.google.android.material.color.a) list.get(i3)).e);
        }
        bVar.d = new int[i];
        int i4 = 0;
        for (short s6 = 0; s6 < i; s6 = (short) (s6 + 1)) {
            if (hashSet.contains(Short.valueOf(s6))) {
                ((int[]) bVar.d)[s6] = i4;
                i4 += 16;
            } else {
                ((int[]) bVar.d)[s6] = -1;
            }
        }
        bVar.b = new com.google.android.material.color.d((short) 513, (short) 84, (((com.google.android.material.color.e[]) bVar.e).length * 16) + (((int[]) bVar.d).length * 4) + 84);
        this.d = bVar;
    }
}
