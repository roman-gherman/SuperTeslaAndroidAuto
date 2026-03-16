package com.google.android.material.datepicker;

/* JADX INFO: renamed from: com.google.android.material.datepicker.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0350m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2425a;
    public final /* synthetic */ MaterialCalendar b;

    public RunnableC0350m(MaterialCalendar materialCalendar, int i) {
        this.b = materialCalendar;
        this.f2425a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f2380j.smoothScrollToPosition(this.f2425a);
    }
}
