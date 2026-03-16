package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import fr.sd.taada.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import k0.AbstractC0572b;

/* JADX INFO: loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new z(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f2411a;
    public Long b;
    public SimpleDateFormat c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int getDefaultThemeResId(Context context) {
        return AbstractC0572b.c(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName()).data;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String getError() {
        if (TextUtils.isEmpty(this.f2411a)) {
            return null;
        }
        return this.f2411a.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Collection getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l6 = this.b;
        if (l6 != null) {
            arrayList.add(l6);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Collection getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Long getSelection() {
        return this.b;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String getSelectionContentDescription(Context context) {
        Resources resources = context.getResources();
        Long l6 = this.b;
        return resources.getString(R.string.mtrl_picker_announce_current_selection, l6 == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : kotlin.reflect.l.J(l6.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l6 = this.b;
        return l6 == null ? resources.getString(R.string.mtrl_picker_date_header_unselected) : resources.getString(R.string.mtrl_picker_date_header_selected, kotlin.reflect.l.J(l6.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean isSelectionComplete() {
        return this.b != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, E e) {
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_date);
        textInputLayout.setErrorAccessibilityLiveRegion(0);
        EditText editText = textInputLayout.getEditText();
        if (com.google.android.material.internal.f.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatD = this.c;
        boolean z6 = simpleDateFormatD != null;
        if (!z6) {
            simpleDateFormatD = L.d();
        }
        SimpleDateFormat simpleDateFormat = simpleDateFormatD;
        String pattern = z6 ? simpleDateFormat.toPattern() : L.e(viewInflate.getResources(), simpleDateFormat);
        textInputLayout.setPlaceholderText(pattern);
        Long l6 = this.b;
        if (l6 != null) {
            editText.setText(simpleDateFormat.format(l6));
        }
        editText.addTextChangedListener(new H(this, pattern, simpleDateFormat, textInputLayout, calendarConstraints, e, textInputLayout));
        DateSelector.showKeyboardWithAutoHideBehavior(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void select(long j6) {
        this.b = Long.valueOf(j6);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void setSelection(Long l6) {
        Long l7 = l6;
        this.b = l7 == null ? null : Long.valueOf(L.a(l7.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void setTextInputFormat(SimpleDateFormat simpleDateFormat) {
        this.c = simpleDateFormat;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.b);
    }
}
