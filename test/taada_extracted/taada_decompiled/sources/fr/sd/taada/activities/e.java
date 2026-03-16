package fr.sd.taada.activities;

import android.view.KeyEvent;
import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.MaterialCheckable;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3263a;
    public final /* synthetic */ KeyEvent.Callback b;

    public /* synthetic */ e(KeyEvent.Callback callback, int i) {
        this.f3263a = i;
        this.b = callback;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
        switch (this.f3263a) {
            case 0:
                ((LogActivity) this.b).lambda$setupEventListeners$0(compoundButton, z6);
                break;
            case 1:
                ((LogActivity) this.b).lambda$updateUI$1(compoundButton, z6);
                break;
            default:
                Chip chip = (Chip) this.b;
                MaterialCheckable.OnCheckedChangeListener onCheckedChangeListener = chip.f2330f;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(chip, z6);
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = chip.e;
                if (onCheckedChangeListener2 != null) {
                    onCheckedChangeListener2.onCheckedChanged(compoundButton, z6);
                }
                break;
        }
    }
}
