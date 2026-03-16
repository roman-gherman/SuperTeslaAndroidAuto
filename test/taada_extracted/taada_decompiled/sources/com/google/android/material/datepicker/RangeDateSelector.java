package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.textfield.TextInputLayout;
import fr.sd.taada.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import k0.AbstractC0572b;

/* JADX INFO: loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new z(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f2408a;
    public String b;
    public Long c;
    public Long d;
    public Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f2409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SimpleDateFormat f2410g;

    public static void b(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, E e) {
        Long l6 = rangeDateSelector.e;
        if (l6 == null || rangeDateSelector.f2409f == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.b.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
            e.a();
        } else if (l6.longValue() <= rangeDateSelector.f2409f.longValue()) {
            Long l7 = rangeDateSelector.e;
            rangeDateSelector.c = l7;
            Long l8 = rangeDateSelector.f2409f;
            rangeDateSelector.d = l8;
            e.b(new Pair(l7, l8));
        } else {
            textInputLayout.setError(rangeDateSelector.b);
            textInputLayout2.setError(" ");
            e.a();
        }
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            rangeDateSelector.f2408a = textInputLayout.getError();
        } else if (TextUtils.isEmpty(textInputLayout2.getError())) {
            rangeDateSelector.f2408a = null;
        } else {
            rangeDateSelector.f2408a = textInputLayout2.getError();
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int getDefaultThemeResId(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return AbstractC0572b.c(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName()).data;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String getError() {
        if (TextUtils.isEmpty(this.f2408a)) {
            return null;
        }
        return this.f2408a.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Collection getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l6 = this.c;
        if (l6 != null) {
            arrayList.add(l6);
        }
        Long l7 = this.d;
        if (l7 != null) {
            arrayList.add(l7);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Collection getSelectedRanges() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.c, this.d));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Pair<Long, Long> getSelection() {
        return new Pair<>(this.c, this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.datepicker.DateSelector
    public final String getSelectionContentDescription(Context context) {
        Resources resources = context.getResources();
        Pair pairX = kotlin.reflect.l.x(this.c, this.d);
        F f6 = pairX.first;
        String string = f6 == 0 ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) f6;
        S s3 = pairX.second;
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, string, s3 == 0 ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) s3);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l6 = this.c;
        if (l6 == null && this.d == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l7 = this.d;
        if (l7 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, kotlin.reflect.l.y(l6.longValue()));
        }
        if (l6 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, kotlin.reflect.l.y(l7.longValue()));
        }
        Pair pairX = kotlin.reflect.l.x(l6, l7);
        return resources.getString(R.string.mtrl_picker_range_header_selected, pairX.first, pairX.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean isSelectionComplete() {
        Long l6 = this.c;
        return (l6 == null || this.d == null || l6.longValue() > this.d.longValue()) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, E e) {
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        textInputLayout.setErrorAccessibilityLiveRegion(0);
        textInputLayout2.setErrorAccessibilityLiveRegion(0);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.f.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.b = viewInflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatD = this.f2410g;
        boolean z6 = simpleDateFormatD != null;
        if (!z6) {
            simpleDateFormatD = L.d();
        }
        SimpleDateFormat simpleDateFormat = simpleDateFormatD;
        Long l6 = this.c;
        if (l6 != null) {
            editText.setText(simpleDateFormat.format(l6));
            this.e = this.c;
        }
        Long l7 = this.d;
        if (l7 != null) {
            editText2.setText(simpleDateFormat.format(l7));
            this.f2409f = this.d;
        }
        String pattern = z6 ? simpleDateFormat.toPattern() : L.e(viewInflate.getResources(), simpleDateFormat);
        textInputLayout.setPlaceholderText(pattern);
        textInputLayout2.setPlaceholderText(pattern);
        editText.addTextChangedListener(new G(this, pattern, simpleDateFormat, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, e, 0));
        editText2.addTextChangedListener(new G(this, pattern, simpleDateFormat, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, e, 1));
        DateSelector.showKeyboardWithAutoHideBehavior(editText, editText2);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void select(long j6) {
        Long l6 = this.c;
        if (l6 == null) {
            this.c = Long.valueOf(j6);
        } else if (this.d == null && l6.longValue() <= j6) {
            this.d = Long.valueOf(j6);
        } else {
            this.d = null;
            this.c = Long.valueOf(j6);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void setSelection(Pair<Long, Long> pair) {
        Pair<Long, Long> pair2 = pair;
        Long l6 = pair2.first;
        if (l6 != null && pair2.second != null) {
            Preconditions.checkArgument(l6.longValue() <= pair2.second.longValue());
        }
        Long l7 = pair2.first;
        this.c = l7 == null ? null : Long.valueOf(L.a(l7.longValue()));
        Long l8 = pair2.second;
        this.d = l8 != null ? Long.valueOf(L.a(l8.longValue())) : null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void setTextInputFormat(SimpleDateFormat simpleDateFormat) {
        this.f2410g = simpleDateFormat;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.c);
        parcel.writeValue(this.d);
    }
}
