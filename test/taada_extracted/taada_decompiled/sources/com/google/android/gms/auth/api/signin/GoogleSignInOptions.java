package com.google.android.gms.auth.api.signin;

import a.AbstractC0132a;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api$ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1917a;
    public final ArrayList b;
    public final Account c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1920h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f1921j;

    static {
        Scope scope = new Scope(1, "profile");
        new Scope(1, NotificationCompat.CATEGORY_EMAIL);
        Scope scope2 = new Scope(1, "openid");
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        Scope scope4 = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new i(6);
    }

    public GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z6, boolean z7, boolean z8, String str, String str2, HashMap map, String str3) {
        this.f1917a = i;
        this.b = arrayList;
        this.c = account;
        this.d = z6;
        this.e = z7;
        this.f1918f = z8;
        this.f1919g = str;
        this.f1920h = str2;
        this.i = new ArrayList(map.values());
        this.f1921j = str3;
    }

    public final boolean equals(Object obj) {
        String str = this.f1919g;
        ArrayList arrayList = this.b;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            ArrayList arrayList2 = googleSignInOptions.b;
            String str2 = googleSignInOptions.f1919g;
            Account account = googleSignInOptions.c;
            if (this.i.isEmpty() && googleSignInOptions.i.isEmpty() && arrayList.size() == new ArrayList(arrayList2).size() && arrayList.containsAll(new ArrayList(arrayList2))) {
                Account account2 = this.c;
                if (account2 == null) {
                    if (account != null) {
                        return false;
                    }
                } else if (!account2.equals(account)) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        return false;
                    }
                } else if (!str.equals(str2)) {
                    return false;
                }
                if (this.f1918f == googleSignInOptions.f1918f && this.d == googleSignInOptions.d && this.e == googleSignInOptions.e) {
                    return TextUtils.equals(this.f1921j, googleSignInOptions.f1921j);
                }
                return false;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.b;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Scope) arrayList2.get(i)).b);
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + (1 * 31);
        Account account = this.c;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.f1919g;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.f1918f ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0);
        String str2 = this.f1921j;
        return (iHashCode3 * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1917a);
        AbstractC0132a.r0(parcel, 2, new ArrayList(this.b));
        AbstractC0132a.m0(parcel, 3, this.c, i);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d ? 1 : 0);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        AbstractC0132a.u0(parcel, 6, 4);
        parcel.writeInt(this.f1918f ? 1 : 0);
        AbstractC0132a.n0(parcel, 7, this.f1919g);
        AbstractC0132a.n0(parcel, 8, this.f1920h);
        AbstractC0132a.r0(parcel, 9, this.i);
        AbstractC0132a.n0(parcel, 10, this.f1921j);
        AbstractC0132a.t0(parcel, iS0);
    }
}
