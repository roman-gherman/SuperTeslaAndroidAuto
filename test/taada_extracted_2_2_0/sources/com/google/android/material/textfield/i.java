package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import c0.C0237a;
import c4.AbstractC0246d;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC0347j;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes.dex */
public final class i extends n {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f2661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f2662h;
    public final androidx.navigation.b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewOnFocusChangeListenerC0347j f2663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final R0.a f2664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AccessibilityManager f2669p;
    public ValueAnimator q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f2670r;

    public i(m mVar) {
        super(mVar);
        int i = 2;
        this.i = new androidx.navigation.b(this, i);
        this.f2663j = new ViewOnFocusChangeListenerC0347j(this, i);
        this.f2664k = new R0.a(this, 7);
        this.f2668o = LocationRequestCompat.PASSIVE_INTERVAL;
        this.f2660f = AbstractC0246d.x0(mVar.getContext(), R.attr.motionDurationShort3, 67);
        this.e = AbstractC0246d.x0(mVar.getContext(), R.attr.motionDurationShort3, 50);
        this.f2661g = AbstractC0246d.y0(mVar.getContext(), R.attr.motionEasingLinearInterpolator, W.a.f1379a);
    }

    @Override // com.google.android.material.textfield.n
    public final void a() {
        if (this.f2669p.isTouchExplorationEnabled() && C5.f.K(this.f2662h) && !this.d.hasFocus()) {
            this.f2662h.dismissDropDown();
        }
        this.f2662h.post(new androidx.constraintlayout.helper.widget.a(this, 7));
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener e() {
        return this.f2663j;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.i;
    }

    @Override // com.google.android.material.textfield.n
    public final AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f2664k;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean i(int i) {
        return i != 0;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean j() {
        return this.f2665l;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean l() {
        return this.f2667n;
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f2662h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                i iVar = this.f2658a;
                iVar.getClass();
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - iVar.f2668o;
                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                        iVar.f2666m = false;
                    }
                    iVar.u();
                    iVar.f2666m = true;
                    iVar.f2668o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.f2662h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.h
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                i iVar = this.f2659a;
                iVar.f2666m = true;
                iVar.f2668o = System.currentTimeMillis();
                iVar.t(false);
            }
        });
        this.f2662h.setThreshold(0);
        TextInputLayout textInputLayout = this.f2689a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!C5.f.K(editText) && this.f2669p.isTouchExplorationEnabled()) {
            ViewCompat.setImportantForAccessibility(this.d, 2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.n
    public final void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!C5.f.K(this.f2662h)) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText(null);
        }
    }

    @Override // com.google.android.material.textfield.n
    public final void o(AccessibilityEvent accessibilityEvent) {
        if (!this.f2669p.isEnabled() || C5.f.K(this.f2662h)) {
            return;
        }
        boolean z6 = accessibilityEvent.getEventType() == 32768 && this.f2667n && !this.f2662h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z6) {
            u();
            this.f2666m = true;
            this.f2668o = System.currentTimeMillis();
        }
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        int i = 1;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f2661g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f2660f);
        valueAnimatorOfFloat.addUpdateListener(new C0237a(this, i));
        this.f2670r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.e);
        valueAnimatorOfFloat2.addUpdateListener(new C0237a(this, i));
        this.q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new Z.a(this, 1));
        this.f2669p = (AccessibilityManager) this.c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.n
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.f2662h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f2662h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z6) {
        if (this.f2667n != z6) {
            this.f2667n = z6;
            this.f2670r.cancel();
            this.q.start();
        }
    }

    public final void u() {
        if (this.f2662h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f2668o;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.f2666m = false;
        }
        if (this.f2666m) {
            this.f2666m = false;
            return;
        }
        t(!this.f2667n);
        if (!this.f2667n) {
            this.f2662h.dismissDropDown();
        } else {
            this.f2662h.requestFocus();
            this.f2662h.showDropDown();
        }
    }
}
