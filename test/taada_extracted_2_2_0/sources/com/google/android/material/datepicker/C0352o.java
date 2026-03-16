package com.google.android.material.datepicker;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: com.google.android.material.datepicker.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0352o extends J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2427a;
    public final /* synthetic */ MaterialCalendar b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0352o(MaterialCalendar materialCalendar, Context context, int i, int i3) {
        super(context, i, false);
        this.b = materialCalendar;
        this.f2427a = i3;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        int i = this.f2427a;
        MaterialCalendar materialCalendar = this.b;
        if (i == 0) {
            iArr[0] = materialCalendar.f2380j.getWidth();
            iArr[1] = materialCalendar.f2380j.getWidth();
        } else {
            iArr[0] = materialCalendar.f2380j.getHeight();
            iArr[1] = materialCalendar.f2380j.getHeight();
        }
    }
}
