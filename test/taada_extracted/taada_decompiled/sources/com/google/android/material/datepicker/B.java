package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes.dex */
public final class B implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f2359a;
    public final /* synthetic */ D b;

    public B(D d, MaterialCalendarGridView materialCalendarGridView) {
        this.b = d;
        this.f2359a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j6) {
        MaterialCalendarGridView materialCalendarGridView = this.f2359a;
        A a6 = materialCalendarGridView.a();
        if (i < a6.a() || i > a6.c()) {
            return;
        }
        D d = this.b;
        d.d.onDayClick(materialCalendarGridView.a().getItem(i).longValue());
    }
}
