package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class s extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D f2431a;
    public final /* synthetic */ MaterialButton b;
    public final /* synthetic */ MaterialCalendar c;

    public s(MaterialCalendar materialCalendar, D d, MaterialButton materialButton) {
        this.c = materialCalendar;
        this.f2431a = d;
        this.b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i3) {
        MaterialCalendar materialCalendar = this.c;
        int iFindFirstVisibleItemPosition = i < 0 ? ((LinearLayoutManager) materialCalendar.f2380j.getLayoutManager()).findFirstVisibleItemPosition() : ((LinearLayoutManager) materialCalendar.f2380j.getLayoutManager()).findLastVisibleItemPosition();
        CalendarConstraints calendarConstraints = this.f2431a.f2365a;
        Calendar calendarC = L.c(calendarConstraints.f2361a.f2403a);
        calendarC.add(2, iFindFirstVisibleItemPosition);
        materialCalendar.f2377f = new Month(calendarC);
        Calendar calendarC2 = L.c(calendarConstraints.f2361a.f2403a);
        calendarC2.add(2, iFindFirstVisibleItemPosition);
        this.b.setText(new Month(calendarC2).d());
    }
}
