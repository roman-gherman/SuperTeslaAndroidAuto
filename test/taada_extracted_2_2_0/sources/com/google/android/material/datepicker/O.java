package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import fr.sd.taada.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class O extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCalendar f2407a;

    public O(MaterialCalendar materialCalendar) {
        this.f2407a = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f2407a.d.f2362f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        N n6 = (N) viewHolder;
        MaterialCalendar materialCalendar = this.f2407a;
        int i3 = materialCalendar.d.f2361a.c + i;
        n6.f2406a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i3)));
        TextView textView = n6.f2406a;
        Context context = textView.getContext();
        textView.setContentDescription(L.f().get(1) == i3 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i3)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i3)));
        C0341d c0341d = materialCalendar.f2379h;
        Calendar calendarF = L.f();
        C0340c c0340c = calendarF.get(1) == i3 ? c0341d.f2416f : c0341d.d;
        Iterator<Long> it = materialCalendar.c.getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarF.setTimeInMillis(it.next().longValue());
            if (calendarF.get(1) == i3) {
                c0340c = c0341d.e;
            }
        }
        c0340c.b(textView);
        textView.setOnClickListener(new M(this, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new N((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
