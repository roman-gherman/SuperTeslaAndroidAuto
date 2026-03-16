package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
public final class d extends n {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(m mVar, int i) {
        super(mVar);
        this.e = i;
    }

    @Override // com.google.android.material.textfield.n
    public void r() {
        switch (this.e) {
            case 0:
                m mVar = this.b;
                mVar.f2683o = null;
                CheckableImageButton checkableImageButton = mVar.f2676g;
                checkableImageButton.setOnLongClickListener(null);
                E1.k.i0(checkableImageButton, null);
                break;
        }
    }
}
