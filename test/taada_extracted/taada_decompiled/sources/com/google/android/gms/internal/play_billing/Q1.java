package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public enum Q1 {
    BROADCAST_ACTION_UNSPECIFIED(0),
    PURCHASES_UPDATED_ACTION(1),
    LOCAL_PURCHASES_UPDATED_ACTION(2),
    ALTERNATIVE_BILLING_ACTION(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2050a;

    Q1(int i) {
        this.f2050a = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f2050a);
    }
}
