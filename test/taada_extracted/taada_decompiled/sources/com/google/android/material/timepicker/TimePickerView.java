package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import fr.sd.taada.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f2747f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chip f2748a;
    public final Chip b;
    public final ClockHandView c;
    public final ClockFaceView d;
    public final MaterialButtonToggleGroup e;

    public interface OnDoubleTapListener {
        void onDoubleTap();
    }

    public interface OnPeriodChangeListener {
        void onPeriodChange(int i);
    }

    public interface OnSelectionChange {
        void onSelectionChanged(int i);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        i iVar = new i(this);
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.d = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.e = materialButtonToggleGroup;
        materialButtonToggleGroup.c.add(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.h
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup2, int i, boolean z6) {
                int i3 = TimePickerView.f2747f;
                this.f2755a.getClass();
            }
        });
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.f2748a = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.b = chip2;
        this.c = (ClockHandView) findViewById(R.id.material_clock_hand);
        k kVar = new k(new GestureDetector(getContext(), new j(this)));
        chip.setOnTouchListener(kVar);
        chip2.setOnTouchListener(kVar);
        chip.setTag(R.id.selection_type, 12);
        chip2.setTag(R.id.selection_type, 10);
        chip.setOnClickListener(iVar);
        chip2.setOnClickListener(iVar);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            this.b.sendAccessibilityEvent(8);
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public final void setActiveSelection(int i) {
        boolean z6 = i == 12;
        Chip chip = this.f2748a;
        chip.setChecked(z6);
        ViewCompat.setAccessibilityLiveRegion(chip, z6 ? 2 : 0);
        boolean z7 = i == 10;
        Chip chip2 = this.b;
        chip2.setChecked(z7);
        ViewCompat.setAccessibilityLiveRegion(chip2, z7 ? 2 : 0);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public final void setHandRotation(float f6) {
        this.c.b(f6);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public final void setValues(String[] strArr, int i) {
        this.d.setValues(strArr, i);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public final void updateTime(int i, int i3, int i4) {
        this.e.b(i == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button, true);
        Locale locale = getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(i4));
        String str2 = String.format(locale, "%02d", Integer.valueOf(i3));
        Chip chip = this.f2748a;
        if (!TextUtils.equals(chip.getText(), str)) {
            chip.setText(str);
        }
        Chip chip2 = this.b;
        if (TextUtils.equals(chip2.getText(), str2)) {
            return;
        }
        chip2.setText(str2);
    }
}
