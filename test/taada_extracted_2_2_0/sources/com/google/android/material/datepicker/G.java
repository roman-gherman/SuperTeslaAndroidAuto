package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class G extends AbstractC0346i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f2370h;
    public final /* synthetic */ TextInputLayout i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ E f2371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RangeDateSelector f2372k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G(RangeDateSelector rangeDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, E e, int i) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f2369g = i;
        this.f2372k = rangeDateSelector;
        this.f2370h = textInputLayout2;
        this.i = textInputLayout3;
        this.f2371j = e;
    }

    @Override // com.google.android.material.datepicker.AbstractC0346i
    public final void a() {
        switch (this.f2369g) {
            case 0:
                RangeDateSelector rangeDateSelector = this.f2372k;
                rangeDateSelector.e = null;
                RangeDateSelector.b(rangeDateSelector, this.f2370h, this.i, this.f2371j);
                break;
            default:
                RangeDateSelector rangeDateSelector2 = this.f2372k;
                rangeDateSelector2.f2409f = null;
                RangeDateSelector.b(rangeDateSelector2, this.f2370h, this.i, this.f2371j);
                break;
        }
    }

    @Override // com.google.android.material.datepicker.AbstractC0346i
    public final void b(Long l6) {
        switch (this.f2369g) {
            case 0:
                RangeDateSelector rangeDateSelector = this.f2372k;
                rangeDateSelector.e = l6;
                RangeDateSelector.b(rangeDateSelector, this.f2370h, this.i, this.f2371j);
                break;
            default:
                RangeDateSelector rangeDateSelector2 = this.f2372k;
                rangeDateSelector2.f2409f = l6;
                RangeDateSelector.b(rangeDateSelector2, this.f2370h, this.i, this.f2371j);
                break;
        }
    }
}
