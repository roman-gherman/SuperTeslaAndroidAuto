package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: renamed from: com.google.android.material.datepicker.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewOnFocusChangeListenerC0347j implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2422a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ViewOnFocusChangeListenerC0347j(Object obj, int i) {
        this.f2422a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z6) {
        switch (this.f2422a) {
            case 0:
                DateSelector.lambda$showKeyboardWithAutoHideBehavior$0((EditText[]) this.b, view, z6);
                break;
            case 1:
                com.google.android.material.textfield.c cVar = (com.google.android.material.textfield.c) this.b;
                cVar.t(cVar.u());
                break;
            default:
                com.google.android.material.textfield.i iVar = (com.google.android.material.textfield.i) this.b;
                iVar.f2665l = z6;
                iVar.q();
                if (!z6) {
                    iVar.t(false);
                    iVar.f2666m = false;
                }
                break;
        }
    }
}
