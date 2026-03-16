package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D f2433a;
    public final /* synthetic */ MaterialCalendar b;

    public u(MaterialCalendar materialCalendar, D d) {
        this.b = materialCalendar;
        this.f2433a = d;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialCalendar materialCalendar = this.b;
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) materialCalendar.f2380j.getLayoutManager()).findFirstVisibleItemPosition() + 1;
        if (iFindFirstVisibleItemPosition < materialCalendar.f2380j.getAdapter().getItemCount()) {
            Calendar calendarC = L.c(this.f2433a.f2365a.f2361a.f2403a);
            calendarC.add(2, iFindFirstVisibleItemPosition);
            materialCalendar.c(new Month(calendarC));
        }
    }
}
