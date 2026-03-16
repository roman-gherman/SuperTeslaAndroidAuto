package f0;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import b1.DialogInterfaceOnMultiChoiceClickListenerC0231a;
import com.google.android.material.internal.o;
import fr.sd.taada.R;
import k0.AbstractC0572b;
import n0.C0695a;
import n0.f;
import n0.i;
import r0.AbstractC0792a;

/* JADX INFO: renamed from: f0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0440b extends AlertDialog.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f3191a;
    public final Rect b;

    /* JADX WARN: Illegal instructions before constructor call */
    public C0440b(Context context) {
        TypedValue typedValueA = AbstractC0572b.a(context, R.attr.materialAlertDialogTheme);
        int i = typedValueA == null ? 0 : typedValueA.data;
        Context contextA = AbstractC0792a.a(context, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        contextA = i != 0 ? new ContextThemeWrapper(contextA, i) : contextA;
        TypedValue typedValueA2 = AbstractC0572b.a(context, R.attr.materialAlertDialogTheme);
        super(contextA, typedValueA2 == null ? 0 : typedValueA2.data);
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int[] iArr = V.a.f1357k;
        o.a(context2, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        o.b(context2, null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        if (context2.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.b = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        TypedValue typedValueC = AbstractC0572b.c(context2, R.attr.colorSurface, C0440b.class.getCanonicalName());
        int i3 = typedValueC.resourceId;
        int color = i3 != 0 ? ContextCompat.getColor(context2, i3) : typedValueC.data;
        f fVar = new f(context2, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        fVar.i(context2);
        fVar.k(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                i iVarE = fVar.f4177a.f4165a.e();
                iVarE.e = new C0695a(dimension);
                iVarE.f4194f = new C0695a(dimension);
                iVarE.f4195g = new C0695a(dimension);
                iVarE.f4196h = new C0695a(dimension);
                fVar.setShapeAppearanceModel(iVarE.a());
            }
        }
        this.f3191a = fVar;
    }

    public final C0440b a(boolean z6) {
        return (C0440b) super.setCancelable(z6);
    }

    public final C0440b b(int i) {
        return (C0440b) super.setMessage(i);
    }

    public final C0440b c(String str) {
        return (C0440b) super.setMessage(str);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog create() {
        AlertDialog alertDialogCreate = super.create();
        Window window = alertDialogCreate.getWindow();
        View decorView = window.getDecorView();
        f fVar = this.f3191a;
        if (fVar != null) {
            fVar.j(ViewCompat.getElevation(decorView));
        }
        Rect rect = this.b;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) fVar, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new ViewOnTouchListenerC0439a(alertDialogCreate, rect));
        return alertDialogCreate;
    }

    public final C0440b d(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterfaceOnMultiChoiceClickListenerC0231a dialogInterfaceOnMultiChoiceClickListenerC0231a) {
        return (C0440b) super.setMultiChoiceItems(charSequenceArr, zArr, dialogInterfaceOnMultiChoiceClickListenerC0231a);
    }

    public final C0440b e(int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setNegativeButton(i, onClickListener);
    }

    public final C0440b f(int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setNeutralButton(i, onClickListener);
    }

    public final C0440b g(int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setPositiveButton(i, onClickListener);
    }

    public final C0440b h(b1.b bVar) {
        return (C0440b) super.setPositiveButton("OK", bVar);
    }

    public final C0440b i(int i) {
        return (C0440b) super.setTitle(i);
    }

    public final C0440b j(View view) {
        return (C0440b) super.setView(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setAdapter(listAdapter, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setCancelable(boolean z6) {
        return (C0440b) super.setCancelable(z6);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
        return (C0440b) super.setCursor(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setCustomTitle(View view) {
        return (C0440b) super.setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setIcon(int i) {
        return (C0440b) super.setIcon(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setIconAttribute(int i) {
        return (C0440b) super.setIconAttribute(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setItems(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMessage(int i) {
        return (C0440b) super.setMessage(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (C0440b) super.setMultiChoiceItems(i, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setNegativeButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNegativeButtonIcon(Drawable drawable) {
        return (C0440b) super.setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setNeutralButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNeutralButtonIcon(Drawable drawable) {
        return (C0440b) super.setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return (C0440b) super.setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (C0440b) super.setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (C0440b) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (C0440b) super.setOnKeyListener(onKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setPositiveButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setPositiveButtonIcon(Drawable drawable) {
        return (C0440b) super.setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setSingleChoiceItems(int i, int i3, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setSingleChoiceItems(i, i3, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setTitle(int i) {
        return (C0440b) super.setTitle(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setView(int i) {
        return (C0440b) super.setView(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setIcon(Drawable drawable) {
        return (C0440b) super.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setItems(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMessage(CharSequence charSequence) {
        return (C0440b) super.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (C0440b) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setNegativeButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setNeutralButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setPositiveButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setSingleChoiceItems(cursor, i, str, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setTitle(CharSequence charSequence) {
        return (C0440b) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setView(View view) {
        return (C0440b) super.setView(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (C0440b) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setSingleChoiceItems(charSequenceArr, i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        return (C0440b) super.setSingleChoiceItems(listAdapter, i, onClickListener);
    }
}
