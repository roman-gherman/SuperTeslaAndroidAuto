package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import fr.sd.taada.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.material.datepicker.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0348k extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f2423a;
    public final int b;
    public final int c;

    public C0348k() {
        Calendar calendarG = L.g(null);
        this.f2423a = calendarG;
        this.b = calendarG.getMaximum(7);
        this.c = calendarG.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int i3 = this.b;
        if (i >= i3) {
            return null;
        }
        int i4 = i + this.c;
        if (i4 > i3) {
            i4 -= i3;
        }
        return Integer.valueOf(i4);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i3 = i + this.c;
        int i4 = this.b;
        if (i3 > i4) {
            i3 -= i4;
        }
        Calendar calendar = this.f2423a;
        calendar.set(7, i3);
        textView.setText(calendar.getDisplayName(7, 4, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public C0348k(int i) {
        Calendar calendarG = L.g(null);
        this.f2423a = calendarG;
        this.b = calendarG.getMaximum(7);
        this.c = i;
    }
}
