package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public enum J {
    RESPONSE_CODE_UNSPECIFIED(-999),
    /* JADX INFO: Fake field, exist only in values array */
    SERVICE_TIMEOUT(-3),
    /* JADX INFO: Fake field, exist only in values array */
    FEATURE_NOT_SUPPORTED(-2),
    /* JADX INFO: Fake field, exist only in values array */
    SERVICE_DISCONNECTED(-1),
    /* JADX INFO: Fake field, exist only in values array */
    OK(0),
    /* JADX INFO: Fake field, exist only in values array */
    USER_CANCELED(1),
    /* JADX INFO: Fake field, exist only in values array */
    SERVICE_UNAVAILABLE(2),
    /* JADX INFO: Fake field, exist only in values array */
    BILLING_UNAVAILABLE(3),
    /* JADX INFO: Fake field, exist only in values array */
    ITEM_UNAVAILABLE(4),
    /* JADX INFO: Fake field, exist only in values array */
    DEVELOPER_ERROR(5),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR(6),
    /* JADX INFO: Fake field, exist only in values array */
    ITEM_ALREADY_OWNED(7),
    /* JADX INFO: Fake field, exist only in values array */
    ITEM_NOT_OWNED(8),
    /* JADX INFO: Fake field, exist only in values array */
    EXPIRED_OFFER_TOKEN(11),
    /* JADX INFO: Fake field, exist only in values array */
    NETWORK_ERROR(12);

    public static final U c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2037a;

    static {
        M3.a aVar = new M3.a(3);
        aVar.d = new Object[8];
        aVar.b = 0;
        for (J j6 : values()) {
            Integer numValueOf = Integer.valueOf(j6.f2037a);
            int i = aVar.b + 1;
            Object[] objArr = (Object[]) aVar.d;
            int length = objArr.length;
            int i3 = i + i;
            if (i3 > length) {
                aVar.d = Arrays.copyOf(objArr, AbstractC0320u.b(length, i3));
            }
            Object[] objArr2 = (Object[]) aVar.d;
            int i4 = aVar.b;
            int i5 = i4 + i4;
            objArr2[i5] = numValueOf;
            objArr2[i5 + 1] = j6;
            aVar.b = i4 + 1;
        }
        B b = (B) aVar.c;
        if (b != null) {
            throw b.a();
        }
        U uA = U.a(aVar.b, (Object[]) aVar.d, aVar);
        B b2 = (B) aVar.c;
        if (b2 != null) {
            throw b2.a();
        }
        c = uA;
    }

    J(int i) {
        this.f2037a = i;
    }
}
