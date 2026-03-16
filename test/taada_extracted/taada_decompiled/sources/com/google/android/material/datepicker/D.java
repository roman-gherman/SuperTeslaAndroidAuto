package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import fr.sd.taada.R;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class D extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CalendarConstraints f2365a;
    public final DateSelector b;
    public final DayViewDecorator c;
    public final p d;
    public final int e;

    public D(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, p pVar) {
        Month month = calendarConstraints.f2361a;
        Month month2 = calendarConstraints.d;
        if (month.f2403a.compareTo(month2.f2403a) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (month2.f2403a.compareTo(calendarConstraints.b.f2403a) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.e = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * A.f2355g) + (MaterialDatePicker.d(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f2365a = calendarConstraints;
        this.b = dateSelector;
        this.c = dayViewDecorator;
        this.d = pVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f2365a.f2363g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        Calendar calendarC = L.c(this.f2365a.f2361a.f2403a);
        calendarC.add(2, i);
        return new Month(calendarC).f2403a.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        C c = (C) viewHolder;
        CalendarConstraints calendarConstraints = this.f2365a;
        Calendar calendarC = L.c(calendarConstraints.f2361a.f2403a);
        calendarC.add(2, i);
        Month month = new Month(calendarC);
        c.f2360a.setText(month.d());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) c.b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !month.equals(materialCalendarGridView.a().f2357a)) {
            A a6 = new A(month, this.b, calendarConstraints, this.c);
            materialCalendarGridView.setNumColumns(month.d);
            materialCalendarGridView.setAdapter((ListAdapter) a6);
        } else {
            materialCalendarGridView.invalidate();
            A a7 = materialCalendarGridView.a();
            Iterator it = a7.c.iterator();
            while (it.hasNext()) {
                a7.e(materialCalendarGridView, ((Long) it.next()).longValue());
            }
            DateSelector dateSelector = a7.b;
            if (dateSelector != null) {
                Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
                while (it2.hasNext()) {
                    a7.e(materialCalendarGridView, it2.next().longValue());
                }
                a7.c = dateSelector.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new B(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.d(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new C(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.e));
        return new C(linearLayout, true);
    }
}
