package com.android.billingclient.api;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.android.billingclient.api.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0260k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1845a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z5.b f1846f;

    public C0260k(JSONObject jSONObject) throws JSONException {
        this.f1845a = jSONObject.optString("formattedPrice");
        this.b = jSONObject.optLong("priceAmountMicros");
        this.c = jSONObject.optString("priceCurrencyCode");
        String strOptString = jSONObject.optString("offerIdToken");
        z5.b bVar = null;
        this.d = true == strOptString.isEmpty() ? null : strOptString;
        jSONObject.optString("offerId").getClass();
        jSONObject.optString("purchaseOptionId").getClass();
        jSONObject.optInt("offerType");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        com.google.android.gms.internal.play_billing.A.j(arrayList);
        if (jSONObject.has("fullPriceMicros")) {
            jSONObject.optLong("fullPriceMicros");
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.getInt("percentageDiscount");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
        if (jSONObjectOptJSONObject2 != null) {
            jSONObjectOptJSONObject2.getLong("startTimeMillis");
            jSONObjectOptJSONObject2.getLong("endTimeMillis");
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
        if (jSONObjectOptJSONObject3 != null) {
            jSONObjectOptJSONObject3.getInt("maximumQuantity");
            jSONObjectOptJSONObject3.getInt("remainingQuantity");
        }
        this.e = jSONObject.optString("serializedDocid");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
        if (jSONObjectOptJSONObject4 != null) {
            jSONObjectOptJSONObject4.getLong("preorderReleaseTimeMillis");
            jSONObjectOptJSONObject4.getLong("preorderPresaleEndTimeMillis");
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
        if (jSONObjectOptJSONObject5 != null) {
            jSONObjectOptJSONObject5.getString("rentalPeriod");
            jSONObjectOptJSONObject5.optString("rentalExpirationPeriod").getClass();
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("autoPayDetails");
        if (jSONObjectOptJSONObject6 != null) {
            bVar = new z5.b(3);
            jSONObjectOptJSONObject6.getString("type");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject6.optJSONArray("balanceThresholds");
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i3)));
                }
            }
            JSONArray jSONArray = jSONObjectOptJSONObject6.getJSONArray("pricingPhases");
            ArrayList arrayList3 = new ArrayList();
            if (jSONArray != null) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObjectOptJSONObject7 = jSONArray.optJSONObject(i4);
                    if (jSONObjectOptJSONObject7 != null) {
                        arrayList3.add(new l(jSONObjectOptJSONObject7));
                    }
                }
            }
        }
        this.f1846f = bVar;
    }
}
