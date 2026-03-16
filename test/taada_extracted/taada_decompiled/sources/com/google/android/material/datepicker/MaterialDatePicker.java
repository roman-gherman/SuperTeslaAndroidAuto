package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import f0.ViewOnTouchListenerC0439a;
import fr.sd.taada.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k0.AbstractC0572b;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialDatePicker<S> extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f2386a = new LinkedHashSet();
    public final LinkedHashSet b = new LinkedHashSet();
    public final LinkedHashSet c = new LinkedHashSet();
    public final LinkedHashSet d = new LinkedHashSet();
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DateSelector f2387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public F f2388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CalendarConstraints f2389h;
    public DayViewDecorator i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaterialCalendar f2390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f2392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f2396p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f2397r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f2398s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f2399t;
    public CheckableImageButton u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public n0.f f2400v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Button f2401w;
    public boolean x;
    public CharSequence y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f2402z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface InputMode {
    }

    public static int c(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Month month = new Month(L.f());
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        int i = month.d;
        return ((i - 1) * dimensionPixelOffset2) + (dimensionPixelSize * i) + (dimensionPixelOffset * 2);
    }

    public static boolean d(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0572b.c(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()).data, new int[]{i});
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z6;
    }

    public final DateSelector b() {
        if (this.f2387f == null) {
            this.f2387f = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f2387f;
    }

    public final void e() {
        Context contextRequireContext = requireContext();
        int defaultThemeResId = this.e;
        if (defaultThemeResId == 0) {
            defaultThemeResId = b().getDefaultThemeResId(contextRequireContext);
        }
        DateSelector dateSelectorB = b();
        CalendarConstraints calendarConstraints = this.f2389h;
        DayViewDecorator dayViewDecorator = this.i;
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", defaultThemeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelectorB);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.d);
        materialCalendar.setArguments(bundle);
        this.f2390j = materialCalendar;
        boolean z6 = this.u.f2439a;
        F f6 = materialCalendar;
        if (z6) {
            DateSelector dateSelectorB2 = b();
            CalendarConstraints calendarConstraints2 = this.f2389h;
            y yVar = new y();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", defaultThemeResId);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelectorB2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            yVar.setArguments(bundle2);
            f6 = yVar;
        }
        this.f2388g = f6;
        this.f2398s.setText((z6 && getResources().getConfiguration().orientation == 2) ? this.f2402z : this.y);
        String selectionDisplayString = b().getSelectionDisplayString(getContext());
        this.f2399t.setContentDescription(b().getSelectionContentDescription(requireContext()));
        this.f2399t.setText(selectionDisplayString);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.mtrl_calendar_frame, this.f2388g);
        fragmentTransactionBeginTransaction.commitNow();
        this.f2388g.b(new x(this, 0));
    }

    public final void f(CheckableImageButton checkableImageButton) {
        this.u.setContentDescription(this.u.f2439a ? checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f2387f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f2389h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.i = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f2391k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f2392l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f2394n = bundle.getInt("INPUT_MODE_KEY");
        this.f2395o = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f2396p = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.q = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f2397r = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        CharSequence text = this.f2392l;
        if (text == null) {
            text = requireContext().getResources().getText(this.f2391k);
        }
        this.y = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.f2402z = text;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Context contextRequireContext2 = requireContext();
        int defaultThemeResId = this.e;
        if (defaultThemeResId == 0) {
            defaultThemeResId = b().getDefaultThemeResId(contextRequireContext2);
        }
        Dialog dialog = new Dialog(contextRequireContext, defaultThemeResId);
        Context context = dialog.getContext();
        this.f2393m = d(context, android.R.attr.windowFullscreen);
        int i = AbstractC0572b.c(context, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName()).data;
        n0.f fVar = new n0.f(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.f2400v = fVar;
        fVar.i(context);
        this.f2400v.k(ColorStateList.valueOf(i));
        this.f2400v.j(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f2393m ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f2393m) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(c(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(c(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.f2399t = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.u = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.f2398s = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.u.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.u;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.u.setChecked(this.f2394n != 0);
        ViewCompat.setAccessibilityDelegate(this.u, null);
        f(this.u);
        this.u.setOnClickListener(new v(this, 2));
        this.f2401w = (Button) viewInflate.findViewById(R.id.confirm_button);
        if (b().isSelectionComplete()) {
            this.f2401w.setEnabled(true);
        } else {
            this.f2401w.setEnabled(false);
        }
        this.f2401w.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence = this.f2396p;
        if (charSequence != null) {
            this.f2401w.setText(charSequence);
        } else {
            int i = this.f2395o;
            if (i != 0) {
                this.f2401w.setText(i);
            }
        }
        this.f2401w.setOnClickListener(new v(this, 0));
        ViewCompat.setAccessibilityDelegate(this.f2401w, new r(this, 1));
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence2 = this.f2397r;
        if (charSequence2 != null) {
            button.setText(charSequence2);
        } else {
            int i3 = this.q;
            if (i3 != 0) {
                button.setText(i3);
            }
        }
        button.setOnClickListener(new v(this, 1));
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f2387f);
        CalendarConstraints calendarConstraints = this.f2389h;
        C0339b c0339b = new C0339b();
        int i = C0339b.c;
        int i3 = C0339b.c;
        c0339b.b = new DateValidatorPointForward(Long.MIN_VALUE);
        long j6 = calendarConstraints.f2361a.f2404f;
        long j7 = calendarConstraints.b.f2404f;
        c0339b.f2412a = Long.valueOf(calendarConstraints.d.f2404f);
        CalendarConstraints.DateValidator dateValidator = calendarConstraints.c;
        c0339b.b = dateValidator;
        MaterialCalendar materialCalendar = this.f2390j;
        Month month = materialCalendar == null ? null : materialCalendar.f2377f;
        if (month != null) {
            c0339b.f2412a = Long.valueOf(month.f2404f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidator);
        Month monthC = Month.c(j6);
        Month monthC2 = Month.c(j7);
        CalendarConstraints.DateValidator dateValidator2 = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l6 = c0339b.f2412a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(monthC, monthC2, dateValidator2, l6 != null ? Month.c(l6.longValue()) : null, calendarConstraints.e));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.i);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f2391k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f2392l);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f2395o);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f2396p);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.q);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f2397r);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f2393m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f2400v);
            if (!this.x) {
                View viewFindViewById = requireView().findViewById(R.id.fullscreen_header);
                Integer numValueOf = viewFindViewById.getBackground() instanceof ColorDrawable ? Integer.valueOf(((ColorDrawable) viewFindViewById.getBackground()).getColor()) : null;
                int i = Build.VERSION.SDK_INT;
                boolean z6 = false;
                boolean z7 = numValueOf == null || numValueOf.intValue() == 0;
                int iE = com.google.android.material.color.g.e(window.getContext(), android.R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
                if (z7) {
                    numValueOf = Integer.valueOf(iE);
                }
                WindowCompat.setDecorFitsSystemWindows(window, false);
                window.getContext();
                int alphaComponent = i < 27 ? ColorUtils.setAlphaComponent(com.google.android.material.color.g.e(window.getContext(), android.R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(alphaComponent);
                int iIntValue = numValueOf.intValue();
                WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(iIntValue != 0 && ColorUtils.calculateLuminance(iIntValue) > 0.5d);
                boolean z8 = iE != 0 && ColorUtils.calculateLuminance(iE) > 0.5d;
                if ((alphaComponent != 0 && ColorUtils.calculateLuminance(alphaComponent) > 0.5d) || (alphaComponent == 0 && z8)) {
                    z6 = true;
                }
                WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z6);
                ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new w(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
                this.x = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f2400v, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ViewOnTouchListenerC0439a(requireDialog(), rect));
        }
        e();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        this.f2388g.f2368a.clear();
        super.onStop();
    }
}
