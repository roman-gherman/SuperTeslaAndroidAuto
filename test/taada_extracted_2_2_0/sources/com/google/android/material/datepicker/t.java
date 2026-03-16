package com.google.android.material.datepicker;

import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2432a;
    public final /* synthetic */ Object b;

    public /* synthetic */ t(Object obj, int i) {
        this.f2432a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2432a) {
            case 0:
                MaterialCalendar materialCalendar = (MaterialCalendar) this.b;
                int i = materialCalendar.f2378g;
                if (i == 2) {
                    materialCalendar.d(1);
                } else if (i == 1) {
                    materialCalendar.d(2);
                }
                break;
            default:
                MenuItemImpl itemData = ((com.google.android.material.navigation.e) view).getItemData();
                a0.b bVar = (a0.b) this.b;
                if (!bVar.C.performItemAction(itemData, bVar.f2538B, 0)) {
                    itemData.setChecked(true);
                }
                break;
        }
    }
}
