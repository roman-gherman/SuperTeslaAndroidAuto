package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialCalendar<S> extends F {
    public int b;
    public DateSelector c;
    public CalendarConstraints d;
    public DayViewDecorator e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Month f2377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C0341d f2379h;
    public RecyclerView i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f2380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f2381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f2382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f2383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f2384n;

    public interface OnDayClickListener {
        void onDayClick(long j6);
    }

    @Override // com.google.android.material.datepicker.F
    public final void b(x xVar) {
        this.f2368a.add(xVar);
    }

    public final void c(Month month) {
        D d = (D) this.f2380j.getAdapter();
        int iE = d.f2365a.f2361a.e(month);
        int iE2 = iE - d.f2365a.f2361a.e(this.f2377f);
        boolean z6 = Math.abs(iE2) > 3;
        boolean z7 = iE2 > 0;
        this.f2377f = month;
        if (z6 && z7) {
            this.f2380j.scrollToPosition(iE - 3);
            this.f2380j.post(new RunnableC0350m(this, iE));
        } else if (!z6) {
            this.f2380j.post(new RunnableC0350m(this, iE));
        } else {
            this.f2380j.scrollToPosition(iE + 3);
            this.f2380j.post(new RunnableC0350m(this, iE));
        }
    }

    public final void d(int i) {
        this.f2378g = i;
        if (i == 2) {
            this.i.getLayoutManager().scrollToPosition(this.f2377f.c - ((O) this.i.getAdapter()).f2407a.d.f2361a.c);
            this.f2383m.setVisibility(0);
            this.f2384n.setVisibility(8);
            this.f2381k.setVisibility(8);
            this.f2382l.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.f2383m.setVisibility(8);
            this.f2384n.setVisibility(0);
            this.f2381k.setVisibility(0);
            this.f2382l.setVisibility(0);
            c(this.f2377f);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt("THEME_RES_ID_KEY");
        this.c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f2377f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.b);
        this.f2379h = new C0341d(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.d.f2361a;
        if (MaterialDatePicker.d(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = fr.sd.taada.R.layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i = fr.sd.taada.R.layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(fr.sd.taada.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(fr.sd.taada.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(fr.sd.taada.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(fr.sd.taada.R.dimen.mtrl_calendar_days_of_week_height);
        int i4 = A.f2355g;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(fr.sd.taada.R.dimen.mtrl_calendar_month_vertical_padding) * (i4 - 1)) + (resources.getDimensionPixelSize(fr.sd.taada.R.dimen.mtrl_calendar_day_height) * i4) + resources.getDimensionPixelOffset(fr.sd.taada.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(fr.sd.taada.R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new C0351n(0));
        int i5 = this.d.e;
        gridView.setAdapter((ListAdapter) (i5 > 0 ? new C0348k(i5) : new C0348k()));
        gridView.setNumColumns(month.d);
        gridView.setEnabled(false);
        this.f2380j = (RecyclerView) viewInflate.findViewById(fr.sd.taada.R.id.mtrl_calendar_months);
        this.f2380j.setLayoutManager(new C0352o(this, getContext(), i3, i3));
        this.f2380j.setTag("MONTHS_VIEW_GROUP_TAG");
        D d = new D(contextThemeWrapper, this.c, this.d, this.e, new p(this));
        this.f2380j.setAdapter(d);
        int integer = contextThemeWrapper.getResources().getInteger(fr.sd.taada.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(fr.sd.taada.R.id.mtrl_calendar_year_selector_frame);
        this.i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.i.setAdapter(new O(this));
            this.i.addItemDecoration(new q(this));
        }
        if (viewInflate.findViewById(fr.sd.taada.R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(fr.sd.taada.R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(materialButton, new r(this, 0));
            View viewFindViewById = viewInflate.findViewById(fr.sd.taada.R.id.month_navigation_previous);
            this.f2381k = viewFindViewById;
            viewFindViewById.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById2 = viewInflate.findViewById(fr.sd.taada.R.id.month_navigation_next);
            this.f2382l = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f2383m = viewInflate.findViewById(fr.sd.taada.R.id.mtrl_calendar_year_selector_frame);
            this.f2384n = viewInflate.findViewById(fr.sd.taada.R.id.mtrl_calendar_day_selector_frame);
            d(1);
            materialButton.setText(this.f2377f.d());
            this.f2380j.addOnScrollListener(new s(this, d, materialButton));
            materialButton.setOnClickListener(new t(this, 0));
            this.f2382l.setOnClickListener(new u(this, d));
            this.f2381k.setOnClickListener(new ViewOnClickListenerC0349l(this, d));
        }
        if (!MaterialDatePicker.d(contextThemeWrapper, R.attr.windowFullscreen)) {
            new PagerSnapHelper().attachToRecyclerView(this.f2380j);
        }
        this.f2380j.scrollToPosition(d.f2365a.f2361a.e(this.f2377f));
        ViewCompat.setAccessibilityDelegate(this.f2380j, new C0351n(1));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f2377f);
    }
}
