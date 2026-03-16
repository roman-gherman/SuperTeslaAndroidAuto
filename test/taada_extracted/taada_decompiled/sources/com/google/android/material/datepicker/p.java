package com.google.android.material.datepicker;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class p implements MaterialCalendar.OnDayClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f2428a;

    public p(MaterialCalendar materialCalendar) {
        this.f2428a = materialCalendar;
    }

    @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
    public final void onDayClick(long j6) {
        MaterialCalendar materialCalendar = this.f2428a;
        if (materialCalendar.d.c.isValid(j6)) {
            materialCalendar.c.select(j6);
            Iterator it = materialCalendar.f2368a.iterator();
            while (it.hasNext()) {
                ((E) it.next()).b(materialCalendar.c.getSelection());
            }
            materialCalendar.f2380j.getAdapter().notifyDataSetChanged();
            RecyclerView recyclerView = materialCalendar.i;
            if (recyclerView != null) {
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
