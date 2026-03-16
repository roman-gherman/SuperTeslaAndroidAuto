package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* JADX INFO: renamed from: com.google.android.material.datepicker.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0349l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D f2424a;
    public final /* synthetic */ MaterialCalendar b;

    public ViewOnClickListenerC0349l(MaterialCalendar materialCalendar, D d) {
        this.b = materialCalendar;
        this.f2424a = d;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialCalendar materialCalendar = this.b;
        int iFindLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar.f2380j.getLayoutManager()).findLastVisibleItemPosition() - 1;
        if (iFindLastVisibleItemPosition >= 0) {
            Calendar calendarC = L.c(this.f2424a.f2365a.f2361a.f2403a);
            calendarC.add(2, iFindLastVisibleItemPosition);
            materialCalendar.c(new Month(calendarC));
        }
    }
}
