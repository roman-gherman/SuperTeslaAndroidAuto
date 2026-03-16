package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class r implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f2711a;

    public r(t tVar) {
        this.f2711a = tVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j6) {
        t tVar = this.f2711a;
        t.a(tVar, i < 0 ? tVar.f2713a.getSelectedItem() : tVar.getAdapter().getItem(i));
        AdapterView.OnItemClickListener onItemClickListener = tVar.getOnItemClickListener();
        ListPopupWindow listPopupWindow = tVar.f2713a;
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                view = listPopupWindow.getSelectedView();
                i = listPopupWindow.getSelectedItemPosition();
                j6 = listPopupWindow.getSelectedItemId();
            }
            onItemClickListener.onItemClick(listPopupWindow.getListView(), view, i, j6);
        }
        listPopupWindow.dismiss();
    }
}
