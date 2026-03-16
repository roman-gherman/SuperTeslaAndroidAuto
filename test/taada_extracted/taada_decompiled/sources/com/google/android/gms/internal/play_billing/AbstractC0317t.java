package com.google.android.gms.internal.play_billing;

import java.io.Serializable;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0317t implements Comparable, Serializable {
    public abstract int a(AbstractC0317t abstractC0317t);

    public abstract void b(StringBuilder sb);

    public abstract void c(StringBuilder sb);

    public final boolean equals(Object obj) {
        if (!(obj instanceof AbstractC0317t)) {
            return false;
        }
        try {
            return a((AbstractC0317t) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public abstract int hashCode();
}
