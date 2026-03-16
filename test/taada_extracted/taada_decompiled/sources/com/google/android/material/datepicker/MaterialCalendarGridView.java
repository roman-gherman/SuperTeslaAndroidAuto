package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f2385a;
    public final boolean b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2385a = L.g(null);
        if (MaterialDatePicker.d(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(fr.sd.taada.R.id.cancel_button);
            setNextFocusRightId(fr.sd.taada.R.id.confirm_button);
        }
        this.b = MaterialDatePicker.d(getContext(), fr.sd.taada.R.attr.nestedScrollable);
        ViewCompat.setAccessibilityDelegate(this, new C0351n(2));
    }

    public final A a() {
        return (A) super.getAdapter();
    }

    public final View b(int i) {
        return getChildAt(i - getFirstVisiblePosition());
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (A) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((A) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iA;
        int width;
        int iA2;
        int width2;
        int i;
        int width3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        A a6 = (A) super.getAdapter();
        DateSelector dateSelector = a6.b;
        C0341d c0341d = a6.d;
        int iMax = Math.max(a6.a(), materialCalendarGridView.getFirstVisiblePosition());
        int iMin = Math.min(a6.c(), materialCalendarGridView.getLastVisiblePosition());
        Long lB = a6.getItem(iMax);
        Long lB2 = a6.getItem(iMin);
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            Long l6 = next.first;
            if (l6 != null) {
                if (next.second != null) {
                    Long l7 = l6;
                    long jLongValue = l7.longValue();
                    Long l8 = next.second;
                    long jLongValue2 = l8.longValue();
                    if (lB == null || lB2 == null || l7.longValue() > lB2.longValue() || l8.longValue() < lB.longValue()) {
                        materialCalendarGridView = this;
                        a6 = a6;
                        it = it;
                    } else {
                        boolean zB = com.google.android.material.internal.s.b(materialCalendarGridView);
                        long jLongValue3 = lB.longValue();
                        Calendar calendar = materialCalendarGridView.f2385a;
                        Month month = a6.f2357a;
                        if (jLongValue < jLongValue3) {
                            width = iMax % month.d == 0 ? 0 : !zB ? materialCalendarGridView.b(iMax - 1).getRight() : materialCalendarGridView.b(iMax - 1).getLeft();
                            iA = iMax;
                        } else {
                            calendar.setTimeInMillis(jLongValue);
                            iA = a6.a() + (calendar.get(5) - 1);
                            View viewB = materialCalendarGridView.b(iA);
                            width = (viewB.getWidth() / 2) + viewB.getLeft();
                        }
                        if (jLongValue2 > lB2.longValue()) {
                            width2 = (iMin + 1) % month.d == 0 ? materialCalendarGridView.getWidth() : !zB ? materialCalendarGridView.b(iMin).getRight() : materialCalendarGridView.b(iMin).getLeft();
                            iA2 = iMin;
                        } else {
                            calendar.setTimeInMillis(jLongValue2);
                            iA2 = a6.a() + (calendar.get(5) - 1);
                            View viewB2 = materialCalendarGridView.b(iA2);
                            width2 = (viewB2.getWidth() / 2) + viewB2.getLeft();
                        }
                        int itemId = (int) a6.getItemId(iA);
                        int itemId2 = (int) a6.getItemId(iA2);
                        while (itemId <= itemId2) {
                            int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                            A a7 = a6;
                            int numColumns2 = (materialCalendarGridView.getNumColumns() + numColumns) - 1;
                            View viewB3 = materialCalendarGridView.b(numColumns);
                            int top = viewB3.getTop() + c0341d.f2415a.f2413a.top;
                            Iterator<Pair<Long, Long>> it2 = it;
                            int bottom = viewB3.getBottom() - c0341d.f2415a.f2413a.bottom;
                            if (zB) {
                                int i3 = iA2 > numColumns2 ? 0 : width2;
                                int width4 = numColumns > iA ? getWidth() : width;
                                i = i3;
                                width3 = width4;
                            } else {
                                i = numColumns > iA ? 0 : width;
                                width3 = iA2 > numColumns2 ? getWidth() : width2;
                            }
                            canvas.drawRect(i, top, width3, bottom, c0341d.f2418h);
                            itemId++;
                            materialCalendarGridView = this;
                            a6 = a7;
                            it = it2;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z6, int i, Rect rect) {
        if (!z6) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(((A) super.getAdapter()).c());
        } else if (i == 130) {
            setSelection(((A) super.getAdapter()).a());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((A) super.getAdapter()).a()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((A) super.getAdapter()).a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i3) {
        if (!this.b) {
            super.onMeasure(i, i3);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((A) super.getAdapter()).a()) {
            super.setSelection(((A) super.getAdapter()).a());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (A) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof A)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), A.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
