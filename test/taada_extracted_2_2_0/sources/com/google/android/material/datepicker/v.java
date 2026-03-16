package com.google.android.material.datepicker;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class v implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2434a;
    public final /* synthetic */ MaterialDatePicker b;

    public /* synthetic */ v(MaterialDatePicker materialDatePicker, int i) {
        this.f2434a = i;
        this.b = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2434a) {
            case 0:
                MaterialDatePicker materialDatePicker = this.b;
                Iterator it = materialDatePicker.f2386a.iterator();
                while (it.hasNext()) {
                    ((MaterialPickerOnPositiveButtonClickListener) it.next()).onPositiveButtonClick(materialDatePicker.b().getSelection());
                }
                materialDatePicker.dismiss();
                break;
            case 1:
                MaterialDatePicker materialDatePicker2 = this.b;
                Iterator it2 = materialDatePicker2.b.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                materialDatePicker2.dismiss();
                break;
            default:
                MaterialDatePicker materialDatePicker3 = this.b;
                materialDatePicker3.f2401w.setEnabled(materialDatePicker3.b().isSelectionComplete());
                materialDatePicker3.u.toggle();
                materialDatePicker3.f(materialDatePicker3.u);
                materialDatePicker3.e();
                break;
        }
    }
}
