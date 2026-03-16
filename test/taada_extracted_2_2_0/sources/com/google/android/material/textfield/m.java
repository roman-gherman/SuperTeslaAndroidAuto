package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import fr.sd.taada.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k0.AbstractC0573c;

/* JADX INFO: loaded from: classes.dex */
public final class m extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2674a;
    public final FrameLayout b;
    public final CheckableImageButton c;
    public ColorStateList d;
    public PorterDuff.Mode e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f2675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CheckableImageButton f2676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final N3.h f2677h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f2678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f2679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f2680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView.ScaleType f2682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnLongClickListener f2683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f2684p;
    public final AppCompatTextView q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2685r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public EditText f2686s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AccessibilityManager f2687t;
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j f2688v;

    public m(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.i = 0;
        this.f2678j = new LinkedHashSet();
        this.f2688v = new j(this);
        k kVar = new k(this);
        this.f2687t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f2674a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f2676g = checkableImageButtonA2;
        this.f2677h = new N3.h(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.q = appCompatTextView;
        if (tintTypedArray.hasValue(36)) {
            this.d = AbstractC0573c.b(getContext(), tintTypedArray, 36);
        }
        if (tintTypedArray.hasValue(37)) {
            this.e = com.google.android.material.internal.s.c(tintTypedArray.getInt(37, -1), null);
        }
        if (tintTypedArray.hasValue(35)) {
            h(tintTypedArray.getDrawable(35));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(checkableImageButtonA, 2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setFocusable(false);
        if (!tintTypedArray.hasValue(51)) {
            if (tintTypedArray.hasValue(30)) {
                this.f2679k = AbstractC0573c.b(getContext(), tintTypedArray, 30);
            }
            if (tintTypedArray.hasValue(31)) {
                this.f2680l = com.google.android.material.internal.s.c(tintTypedArray.getInt(31, -1), null);
            }
        }
        if (tintTypedArray.hasValue(28)) {
            f(tintTypedArray.getInt(28, 0));
            if (tintTypedArray.hasValue(25) && checkableImageButtonA2.getContentDescription() != (text = tintTypedArray.getText(25))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(tintTypedArray.getBoolean(24, true));
        } else if (tintTypedArray.hasValue(51)) {
            if (tintTypedArray.hasValue(52)) {
                this.f2679k = AbstractC0573c.b(getContext(), tintTypedArray, 52);
            }
            if (tintTypedArray.hasValue(53)) {
                this.f2680l = com.google.android.material.internal.s.c(tintTypedArray.getInt(53, -1), null);
            }
            f(tintTypedArray.getBoolean(51, false) ? 1 : 0);
            CharSequence text2 = tintTypedArray.getText(49);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = tintTypedArray.getDimensionPixelSize(27, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f2681m) {
            this.f2681m = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (tintTypedArray.hasValue(29)) {
            ImageView.ScaleType scaleTypeQ = E1.k.q(tintTypedArray.getInt(29, -1));
            this.f2682n = scaleTypeQ;
            checkableImageButtonA2.setScaleType(scaleTypeQ);
            checkableImageButtonA.setScaleType(scaleTypeQ);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(appCompatTextView, 1);
        TextViewCompat.setTextAppearance(appCompatTextView, tintTypedArray.getResourceId(70, 0));
        if (tintTypedArray.hasValue(71)) {
            appCompatTextView.setTextColor(tintTypedArray.getColorStateList(71));
        }
        CharSequence text3 = tintTypedArray.getText(69);
        this.f2684p = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        m();
        frameLayout.addView(checkableImageButtonA2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f2613c0.add(kVar);
        if (textInputLayout.d != null) {
            kVar.onEditTextAttached(textInputLayout);
        }
        addOnAttachStateChangeListener(new l(this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (AbstractC0573c.d(getContext())) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public final n b() {
        n dVar;
        int i = this.i;
        N3.h hVar = this.f2677h;
        SparseArray sparseArray = (SparseArray) hVar.c;
        n nVar = (n) sparseArray.get(i);
        if (nVar != null) {
            return nVar;
        }
        m mVar = (m) hVar.d;
        if (i == -1) {
            dVar = new d(mVar, 0);
        } else if (i == 0) {
            dVar = new d(mVar, 1);
        } else if (i == 1) {
            dVar = new u(mVar, hVar.b);
        } else if (i == 2) {
            dVar = new c(mVar);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(B2.b.c(i, "Invalid end icon mode: "));
            }
            dVar = new i(mVar);
        }
        sparseArray.append(i, dVar);
        return dVar;
    }

    public final boolean c() {
        return this.b.getVisibility() == 0 && this.f2676g.getVisibility() == 0;
    }

    public final boolean d() {
        return this.c.getVisibility() == 0;
    }

    public final void e(boolean z6) {
        boolean z7;
        boolean zIsActivated;
        boolean z8;
        n nVarB = b();
        boolean zK = nVarB.k();
        CheckableImageButton checkableImageButton = this.f2676g;
        boolean z9 = true;
        if (!zK || (z8 = checkableImageButton.f2439a) == nVarB.l()) {
            z7 = false;
        } else {
            checkableImageButton.setChecked(!z8);
            z7 = true;
        }
        if (!(nVarB instanceof i) || (zIsActivated = checkableImageButton.isActivated()) == nVarB.j()) {
            z9 = z7;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z6 || z9) {
            E1.k.c0(this.f2674a, checkableImageButton, this.f2679k);
        }
    }

    public final void f(int i) {
        TextInputLayout textInputLayout;
        if (this.i == i) {
            return;
        }
        n nVarB = b();
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.u;
        AccessibilityManager accessibilityManager = this.f2687t;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
        }
        this.u = null;
        nVarB.s();
        int i3 = this.i;
        this.i = i;
        Iterator it = this.f2678j.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            textInputLayout = this.f2674a;
            if (!zHasNext) {
                break;
            } else {
                ((TextInputLayout.OnEndIconChangedListener) it.next()).onEndIconChanged(textInputLayout, i3);
            }
        }
        g(i != 0);
        n nVarB2 = b();
        int iD = this.f2677h.f1170a;
        if (iD == 0) {
            iD = nVarB2.d();
        }
        Drawable drawable = iD != 0 ? AppCompatResources.getDrawable(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.f2676g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            E1.k.g(textInputLayout, checkableImageButton, this.f2679k, this.f2680l);
            E1.k.c0(textInputLayout, checkableImageButton, this.f2679k);
        }
        int iC = nVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(nVarB2.k());
        if (!nVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        nVarB2.r();
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = nVarB2.h();
        this.u = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null && ViewCompat.isAttachedToWindow(this)) {
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(accessibilityManager, this.u);
        }
        View.OnClickListener onClickListenerF = nVarB2.f();
        View.OnLongClickListener onLongClickListener = this.f2683o;
        checkableImageButton.setOnClickListener(onClickListenerF);
        E1.k.i0(checkableImageButton, onLongClickListener);
        EditText editText = this.f2686s;
        if (editText != null) {
            nVarB2.m(editText);
            i(nVarB2);
        }
        E1.k.g(textInputLayout, checkableImageButton, this.f2679k, this.f2680l);
        e(true);
    }

    public final void g(boolean z6) {
        if (c() != z6) {
            this.f2676g.setVisibility(z6 ? 0 : 8);
            j();
            l();
            this.f2674a.p();
        }
    }

    public final void h(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.c;
        checkableImageButton.setImageDrawable(drawable);
        k();
        E1.k.g(this.f2674a, checkableImageButton, this.d, this.e);
    }

    public final void i(n nVar) {
        if (this.f2686s == null) {
            return;
        }
        if (nVar.e() != null) {
            this.f2686s.setOnFocusChangeListener(nVar.e());
        }
        if (nVar.g() != null) {
            this.f2676g.setOnFocusChangeListener(nVar.g());
        }
    }

    public final void j() {
        this.b.setVisibility((this.f2676g.getVisibility() != 0 || d()) ? 8 : 0);
        setVisibility((c() || d() || ((this.f2684p == null || this.f2685r) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void k() {
        CheckableImageButton checkableImageButton = this.c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f2674a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f2621j.q && textInputLayout.m()) ? 0 : 8);
        j();
        l();
        if (this.i != 0) {
            return;
        }
        textInputLayout.p();
    }

    public final void l() {
        TextInputLayout textInputLayout = this.f2674a;
        if (textInputLayout.d == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.q, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.d.getPaddingTop(), (c() || d()) ? 0 : ViewCompat.getPaddingEnd(textInputLayout.d), textInputLayout.d.getPaddingBottom());
    }

    public final void m() {
        AppCompatTextView appCompatTextView = this.q;
        int visibility = appCompatTextView.getVisibility();
        int i = (this.f2684p == null || this.f2685r) ? 8 : 0;
        if (visibility != i) {
            b().p(i == 0);
        }
        j();
        appCompatTextView.setVisibility(i);
        this.f2674a.p();
    }
}
