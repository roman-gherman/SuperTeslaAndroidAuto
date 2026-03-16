package fr.sd.taada.utils;

import android.util.Log;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class CurrencyFormatter {
    private static final String TAG = "CurrencyFormatter";

    private CurrencyFormatter() {
    }

    public static String format(double d, String str) {
        try {
            Currency currency = Currency.getInstance(str);
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(getLocaleForCurrency(str));
            currencyInstance.setCurrency(currency);
            return currencyInstance.format(d);
        } catch (Exception e) {
            Log.w(TAG, "Currency formatting failed for " + str, e);
            return String.format(Locale.US, "%.2f %s", Double.valueOf(d), str);
        }
    }

    private static Locale getLocaleForCurrency(String str) {
        if (str == null) {
            return Locale.getDefault();
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        switch (upperCase) {
        }
        return Locale.getDefault();
    }
}
