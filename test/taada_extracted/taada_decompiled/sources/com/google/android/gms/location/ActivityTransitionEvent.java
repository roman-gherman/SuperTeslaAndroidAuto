package com.google.android.gms.location;

import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new Q.h(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2140a;
    public final int b;
    public final long c;

    public ActivityTransitionEvent(int i, int i3, long j6) {
        boolean z6 = false;
        if (i3 >= 0 && i3 <= 1) {
            z6 = true;
        }
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i3);
        sb.append(" is not valid.");
        j.a(sb.toString(), z6);
        this.f2140a = i;
        this.b = i3;
        this.c = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f2140a == activityTransitionEvent.f2140a && this.b == activityTransitionEvent.b && this.c == activityTransitionEvent.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2140a), Integer.valueOf(this.b), Long.valueOf(this.c)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("ActivityType ");
        sb2.append(this.f2140a);
        sb.append(sb2.toString());
        sb.append(" ");
        StringBuilder sb3 = new StringBuilder(26);
        sb3.append("TransitionType ");
        sb3.append(this.b);
        sb.append(sb3.toString());
        sb.append(" ");
        StringBuilder sb4 = new StringBuilder(41);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(this.c);
        sb.append(sb4.toString());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        j.c(parcel);
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2140a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.u0(parcel, 3, 8);
        parcel.writeLong(this.c);
        AbstractC0132a.t0(parcel, iS0);
    }
}
