package com.google.android.gms.location;

import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new Q.h(29);
    public static final h e = new h(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2141a;
    public final String b;
    public final List c;
    public final String d;

    public ActivityTransitionRequest(ArrayList arrayList, String str, ArrayList arrayList2, String str2) {
        j.d(arrayList, "transitions can't be null");
        j.a("transitions can't be empty.", arrayList.size() > 0);
        TreeSet treeSet = new TreeSet(e);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ActivityTransition activityTransition = (ActivityTransition) it.next();
            j.a(String.format("Found duplicated transition: %s.", activityTransition), treeSet.add(activityTransition));
        }
        this.f2141a = Collections.unmodifiableList(arrayList);
        this.b = str;
        this.c = arrayList2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList2);
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (j.f(this.f2141a, activityTransitionRequest.f2141a) && j.f(this.b, activityTransitionRequest.b) && j.f(this.d, activityTransitionRequest.d) && j.f(this.c, activityTransitionRequest.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f2141a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f2141a);
        String strValueOf2 = String.valueOf(this.c);
        int length = strValueOf.length();
        String str = this.b;
        int length2 = String.valueOf(str).length();
        int length3 = strValueOf2.length();
        String str2 = this.d;
        StringBuilder sb = new StringBuilder(length + 79 + length2 + length3 + String.valueOf(str2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(strValueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append("', mClients=");
        sb.append(strValueOf2);
        sb.append(", mAttributionTag=");
        sb.append(str2);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        j.c(parcel);
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.r0(parcel, 1, this.f2141a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.r0(parcel, 3, this.c);
        AbstractC0132a.n0(parcel, 4, this.d);
        AbstractC0132a.t0(parcel, iS0);
    }
}
