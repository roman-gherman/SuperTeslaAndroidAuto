package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class H extends AbstractC0346i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ E f2373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f2374h;
    public final /* synthetic */ SingleDateSelector i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(SingleDateSelector singleDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, E e, TextInputLayout textInputLayout2) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.i = singleDateSelector;
        this.f2373g = e;
        this.f2374h = textInputLayout2;
    }

    @Override // com.google.android.material.datepicker.AbstractC0346i
    public final void a() {
        this.i.f2411a = this.f2374h.getError();
        this.f2373g.a();
    }

    @Override // com.google.android.material.datepicker.AbstractC0346i
    public final void b(Long l6) {
        SingleDateSelector singleDateSelector = this.i;
        if (l6 == null) {
            singleDateSelector.b = null;
        } else {
            singleDateSelector.b = l6;
        }
        singleDateSelector.f2411a = null;
        this.f2373g.b(singleDateSelector.b);
    }
}
