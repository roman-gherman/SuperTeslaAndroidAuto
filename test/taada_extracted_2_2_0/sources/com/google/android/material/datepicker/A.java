package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.Pair;
import fr.sd.taada.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class A extends BaseAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2355g = L.g(null).getMaximum(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f2356h = (L.g(null).getMaximum(7) + L.g(null).getMaximum(5)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Month f2357a;
    public final DateSelector b;
    public Collection c;
    public C0341d d;
    public final CalendarConstraints e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DayViewDecorator f2358f;

    public A(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f2357a = month;
        this.b = dateSelector;
        this.e = calendarConstraints;
        this.f2358f = dayViewDecorator;
        this.c = dateSelector.getSelectedDays();
    }

    public final int a() {
        int firstDayOfWeek = this.e.e;
        Month month = this.f2357a;
        Calendar calendar = month.f2403a;
        int i = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i3 = i - firstDayOfWeek;
        return i3 < 0 ? i3 + month.d : i3;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i) {
        if (i < a() || i > c()) {
            return null;
        }
        int iA = (i - a()) + 1;
        Calendar calendarC = L.c(this.f2357a.f2403a);
        calendarC.set(5, iA);
        return Long.valueOf(calendarC.getTimeInMillis());
    }

    public final int c() {
        return (a() + this.f2357a.e) - 1;
    }

    public final void d(TextView textView, long j6, int i) {
        boolean z6;
        boolean z7;
        C0340c c0340c;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        boolean z8 = false;
        boolean z9 = L.f().getTimeInMillis() == j6;
        DateSelector dateSelector = this.b;
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (true) {
            if (!it.hasNext()) {
                z6 = false;
                break;
            }
            Long l6 = it.next().first;
            if (l6 != null && l6.longValue() == j6) {
                z6 = true;
                break;
            }
        }
        Iterator<Pair<Long, Long>> it2 = dateSelector.getSelectedRanges().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z7 = false;
                break;
            }
            Long l7 = it2.next().second;
            if (l7 != null && l7.longValue() == j6) {
                z7 = true;
                break;
            }
        }
        Calendar calendarF = L.f();
        Calendar calendarG = L.g(null);
        calendarG.setTimeInMillis(j6);
        String str = calendarF.get(1) == calendarG.get(1) ? L.b("MMMEd", Locale.getDefault()).format(new Date(j6)) : L.b("yMMMEd", Locale.getDefault()).format(new Date(j6));
        if (z9) {
            str = String.format(context.getString(R.string.mtrl_picker_today_description), str);
        }
        if (z6) {
            str = String.format(context.getString(R.string.mtrl_picker_start_date_description), str);
        } else if (z7) {
            str = String.format(context.getString(R.string.mtrl_picker_end_date_description), str);
        }
        textView.setContentDescription(str);
        if (this.e.c.isValid(j6)) {
            textView.setEnabled(true);
            Iterator<Long> it3 = dateSelector.getSelectedDays().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (L.a(j6) == L.a(it3.next().longValue())) {
                    z8 = true;
                    break;
                }
            }
            textView.setSelected(z8);
            c0340c = z8 ? this.d.b : L.f().getTimeInMillis() == j6 ? this.d.c : this.d.f2415a;
        } else {
            textView.setEnabled(false);
            c0340c = this.d.f2417g;
        }
        if (this.f2358f == null || i == -1) {
            c0340c.b(textView);
            return;
        }
        int i3 = this.f2357a.c;
        c0340c.b(textView);
        textView.setCompoundDrawables(null, null, null, null);
        textView.setContentDescription(str);
    }

    public final void e(MaterialCalendarGridView materialCalendarGridView, long j6) {
        Month monthC = Month.c(j6);
        Month month = this.f2357a;
        if (monthC.equals(month)) {
            Calendar calendarC = L.c(month.f2403a);
            calendarC.setTimeInMillis(j6);
            int i = calendarC.get(5);
            d((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.a().a() + (i - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j6, i);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f2356h;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.f2357a.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            com.google.android.material.datepicker.d r1 = r5.d
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.d r1 = new com.google.android.material.datepicker.d
            r1.<init>(r0)
            r5.d = r1
        Lf:
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L27
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131492955(0x7f0c005b, float:1.8609377E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r7 = r5.a()
            int r7 = r6 - r7
            if (r7 < 0) goto L5d
            com.google.android.material.datepicker.Month r8 = r5.f2357a
            int r2 = r8.e
            if (r7 < r2) goto L36
            goto L5d
        L36:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L66
        L5d:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L66:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L6d
            return r0
        L6d:
            long r1 = r6.longValue()
            r5.d(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.A.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
