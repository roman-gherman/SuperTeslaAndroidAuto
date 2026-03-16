package com.android.billingclient.api;

import com.android.dex.util.ByteInput;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.j2;
import com.google.android.gms.internal.play_billing.k2;
import com.google.android.gms.internal.play_billing.l2;
import com.google.android.gms.internal.play_billing.m2;
import g3.AbstractC0487d;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Xof;
import w3.C0896n;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements ByteInput, ReadOnlyProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1864a;
    public final Object b;

    public z(int i, C0896n c0896n) {
        if (c0896n == null) {
            throw new NullPointerException("digest == null");
        }
        this.b = J4.f.a(c0896n);
        this.f1864a = i;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.f1864a) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == 32) {
            return b(3, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong address length");
    }

    public byte[] b(int i, byte[] bArr, byte[] bArr2) {
        long j6 = i;
        int i3 = this.f1864a;
        byte[] bArrK0 = C5.f.k0(i3, j6);
        int length = bArrK0.length;
        ExtendedDigest extendedDigest = (ExtendedDigest) this.b;
        extendedDigest.update(bArrK0, 0, length);
        extendedDigest.update(bArr, 0, bArr.length);
        extendedDigest.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[i3];
        if (extendedDigest instanceof Xof) {
            ((Xof) extendedDigest).doFinal(bArr3, 0, i3);
            return bArr3;
        }
        extendedDigest.doFinal(bArr3, 0);
        return bArr3;
    }

    public void c(k2 k2Var) {
        D d = (D) this.b;
        int i = this.f1864a;
        d.getClass();
        try {
            if (d.f1803B == null) {
                throw null;
            }
            d.f1803B.zza(d.f1805z.getPackageName(), i != 2 ? i != 3 ? i != 6 ? i != 7 ? "QUERY_SKU_DETAILS_ASYNC" : "QUERY_PRODUCT_DETAILS_ASYNC" : "START_CONNECTION" : "ACKNOWLEDGE_PURCHASE" : "LAUNCH_BILLING_FLOW", new B(k2Var));
        } catch (Exception e) {
            d.B(107, 28, H.f1818s);
            AbstractC0289j0.g("BillingClientTesting", "An error occurred while retrieving billing override.", e);
            k2Var.d = true;
            m2 m2Var = k2Var.b;
            if (m2Var != null) {
                l2 l2Var = m2Var.b;
                l2Var.getClass();
                if (j2.f2094f.u(l2Var, null, 0)) {
                    j2.b(l2Var);
                    k2Var.f2099a = null;
                    k2Var.b = null;
                    k2Var.c = null;
                }
            }
        }
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public Object getValue(Object obj, KProperty property) {
        AbstractC0487d thisRef = (AbstractC0487d) obj;
        kotlin.jvm.internal.h.f(thisRef, "thisRef");
        kotlin.jvm.internal.h.f(property, "property");
        return thisRef.f3308a.get(this.f1864a);
    }

    @Override // com.android.dex.util.ByteInput
    public byte readByte() {
        int i = this.f1864a;
        this.f1864a = i + 1;
        return ((byte[]) this.b)[i];
    }

    public /* synthetic */ z(Object obj, int i) {
        this.b = obj;
        this.f1864a = i;
    }

    public z(ConnectionResult connectionResult, int i) {
        D.j.c(connectionResult);
        this.b = connectionResult;
        this.f1864a = i;
    }

    public z(byte... bArr) {
        this.b = bArr;
    }
}
