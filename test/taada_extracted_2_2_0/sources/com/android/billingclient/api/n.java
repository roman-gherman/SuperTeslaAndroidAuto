package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1849a;
    public final JSONObject b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1852h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f1853j;

    public n(String str) {
        this.f1849a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.e = jSONObject.optString("title");
        this.f1850f = jSONObject.optString("name");
        jSONObject.optString("description");
        jSONObject.optString("packageDisplayName");
        jSONObject.optString("iconUrl");
        this.f1851g = jSONObject.optString("skuDetailsToken");
        this.f1852h = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(new m(jSONArrayOptJSONArray.getJSONObject(i)));
            }
            this.i = arrayList;
        } else {
            this.i = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArrayOptJSONArray2 = this.b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                arrayList2.add(new C0260k(jSONArrayOptJSONArray2.getJSONObject(i3)));
            }
            this.f1853j = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.f1853j = null;
        } else {
            arrayList2.add(new C0260k(jSONObjectOptJSONObject));
            this.f1853j = arrayList2;
        }
    }

    public final C0260k a() {
        ArrayList arrayList = this.f1853j;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (C0260k) arrayList.get(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            return TextUtils.equals(this.f1849a, ((n) obj).f1849a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1849a.hashCode();
    }

    public final String toString() {
        return "ProductDetails{jsonString='" + this.f1849a + "', parsedJson=" + this.b.toString() + ", productId='" + this.c + "', productType='" + this.d + "', title='" + this.e + "', productDetailsToken='" + this.f1851g + "', subscriptionOfferDetails=" + String.valueOf(this.i) + "}";
    }
}
