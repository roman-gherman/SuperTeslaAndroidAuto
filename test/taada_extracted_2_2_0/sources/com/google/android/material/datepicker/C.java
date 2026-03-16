package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes.dex */
public final class C extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f2360a;
    public final MaterialCalendarGridView b;

    public C(LinearLayout linearLayout, boolean z6) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f2360a = textView;
        ViewCompat.setAccessibilityHeading(textView, true);
        this.b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z6) {
            return;
        }
        textView.setVisibility(8);
    }
}
