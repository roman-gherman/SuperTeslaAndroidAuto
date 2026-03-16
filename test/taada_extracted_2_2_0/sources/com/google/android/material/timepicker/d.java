package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes.dex */
public class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2752a;

    public d(int i) {
        this.f2752a = i;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i3, Spanned spanned, int i4, int i5) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i4, i5, charSequence.subSequence(i, i3).toString());
            if (Integer.parseInt(sb.toString()) <= this.f2752a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
