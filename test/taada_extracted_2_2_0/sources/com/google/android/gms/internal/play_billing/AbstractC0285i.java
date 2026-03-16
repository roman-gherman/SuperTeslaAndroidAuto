package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0285i implements zzdj {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdj) {
            return ((D) this).zzc().equals(((zzdj) obj).zzc());
        }
        return false;
    }

    public final int hashCode() {
        return ((D) this).zzc().hashCode();
    }

    public final String toString() {
        return ((D) this).zzc().toString();
    }
}
