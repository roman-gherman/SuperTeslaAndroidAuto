package com.google.android.material.datepicker;

import android.view.View;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class M implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2376a;
    public final /* synthetic */ O b;

    public M(O o6, int i) {
        this.b = o6;
        this.f2376a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialCalendar materialCalendar = this.b.f2407a;
        Month monthB = Month.b(this.f2376a, materialCalendar.f2377f.b);
        CalendarConstraints calendarConstraints = materialCalendar.d;
        Month month = calendarConstraints.f2361a;
        Calendar calendar = month.f2403a;
        Calendar calendar2 = monthB.f2403a;
        if (calendar2.compareTo(calendar) < 0) {
            monthB = month;
        } else {
            Month month2 = calendarConstraints.b;
            if (calendar2.compareTo(month2.f2403a) > 0) {
                monthB = month2;
            }
        }
        materialCalendar.c(monthB);
        materialCalendar.d(1);
    }
}
