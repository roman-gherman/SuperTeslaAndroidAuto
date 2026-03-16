package fr.sd.taada.helpers;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.MultiSelectListPreference;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyListPreference extends MultiSelectListPreference {
    public EmptyListPreference(Context context) {
        super(context);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void onClick() {
        if (getEntries() == null) {
            return;
        }
        super.onClick();
    }

    public EmptyListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmptyListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EmptyListPreference(Context context, AttributeSet attributeSet, int i, int i3) {
        super(context, attributeSet, i, i3);
    }
}
