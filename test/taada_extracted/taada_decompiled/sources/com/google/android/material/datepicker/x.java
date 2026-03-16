package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class x extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2436a;
    public final /* synthetic */ Fragment b;

    public /* synthetic */ x(Fragment fragment, int i) {
        this.f2436a = i;
        this.b = fragment;
    }

    @Override // com.google.android.material.datepicker.E
    public final void a() {
        switch (this.f2436a) {
            case 0:
                ((MaterialDatePicker) this.b).f2401w.setEnabled(false);
                break;
            default:
                Iterator it = ((y) this.b).f2368a.iterator();
                while (it.hasNext()) {
                    ((E) it.next()).a();
                }
                break;
        }
    }

    @Override // com.google.android.material.datepicker.E
    public final void b(Object obj) {
        switch (this.f2436a) {
            case 0:
                MaterialDatePicker materialDatePicker = (MaterialDatePicker) this.b;
                String selectionDisplayString = materialDatePicker.b().getSelectionDisplayString(materialDatePicker.getContext());
                materialDatePicker.f2399t.setContentDescription(materialDatePicker.b().getSelectionContentDescription(materialDatePicker.requireContext()));
                materialDatePicker.f2399t.setText(selectionDisplayString);
                materialDatePicker.f2401w.setEnabled(materialDatePicker.b().isSelectionComplete());
                break;
            default:
                Iterator it = ((y) this.b).f2368a.iterator();
                while (it.hasNext()) {
                    ((E) it.next()).b(obj);
                }
                break;
        }
    }
}
