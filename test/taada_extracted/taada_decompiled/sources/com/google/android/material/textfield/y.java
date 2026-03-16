package com.google.android.material.textfield;

import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes.dex */
public final class y extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2725a;

    public y(TextInputLayout textInputLayout) {
        this.f2725a = textInputLayout;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        TextInputLayout textInputLayout = this.f2725a;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z6 = textInputLayout.f2636r0;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z7 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : "";
        v vVar = textInputLayout.b;
        View view2 = vVar.b;
        if (view2.getVisibility() == 0) {
            accessibilityNodeInfoCompat.setLabelFor(view2);
            accessibilityNodeInfoCompat.setTraversalAfter(view2);
        } else {
            accessibilityNodeInfoCompat.setTraversalAfter(vVar.d);
        }
        if (!zIsEmpty) {
            accessibilityNodeInfoCompat.setText(text);
        } else if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfoCompat.setText(string);
            if (!z6 && placeholderText != null) {
                accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            accessibilityNodeInfoCompat.setText(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfoCompat.setHintText(string);
            accessibilityNodeInfoCompat.setShowingHintText(zIsEmpty);
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
        if (z7) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfoCompat.setError(error);
        }
        View view3 = textInputLayout.f2621j.y;
        if (view3 != null) {
            accessibilityNodeInfoCompat.setLabelFor(view3);
        }
        textInputLayout.c.b().n(accessibilityNodeInfoCompat);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        this.f2725a.c.b().o(accessibilityEvent);
    }
}
