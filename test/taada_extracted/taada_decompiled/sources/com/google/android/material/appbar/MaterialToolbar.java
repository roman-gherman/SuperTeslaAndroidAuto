package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.location.h;
import com.google.android.material.internal.o;
import com.google.android.material.internal.p;
import fr.sd.taada.R;
import java.util.ArrayList;
import java.util.Collections;
import k1.j;
import n0.f;
import r0.AbstractC0792a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ImageView.ScaleType[] f2183f = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f2184a;
    public boolean b;
    public boolean c;
    public ImageView.ScaleType d;
    public Boolean e;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(AbstractC0792a.a(context, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), attributeSet, R.attr.toolbarStyle);
        Context context2 = getContext();
        TypedArray typedArrayD = o.d(context2, attributeSet, V.a.f1367w, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayD.hasValue(2)) {
            setNavigationIconTint(typedArrayD.getColor(2, -1));
        }
        this.b = typedArrayD.getBoolean(4, false);
        this.c = typedArrayD.getBoolean(3, false);
        int i = typedArrayD.getInt(1, -1);
        if (i >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f2183f;
            if (i < scaleTypeArr.length) {
                this.d = scaleTypeArr[i];
            }
        }
        if (typedArrayD.hasValue(0)) {
            this.e = Boolean.valueOf(typedArrayD.getBoolean(0, false));
        }
        typedArrayD.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            f fVar = new f();
            fVar.k(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            fVar.i(context2);
            fVar.j(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, fVar);
        }
    }

    public final void a(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i3 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i3 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i3 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i3 - i, BasicMeasure.EXACTLY), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i3, textView.getBottom());
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.d;
    }

    public Integer getNavigationIconTint() {
        return this.f2184a;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void inflateMenu(int i) {
        Menu menu = getMenu();
        boolean z6 = menu instanceof MenuBuilder;
        if (z6) {
            ((MenuBuilder) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i);
        if (z6) {
            ((MenuBuilder) menu).startDispatchingItemsChanged();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof f) {
            j.q(this, (f) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i, int i3, int i4, int i5) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z6, i, i3, i4, i5);
        int i6 = 0;
        ImageView imageView2 = null;
        if (this.b || this.c) {
            ArrayList arrayListA = p.a(this, getTitle());
            boolean zIsEmpty = arrayListA.isEmpty();
            h hVar = p.f2506a;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListA, hVar);
            ArrayList arrayListA2 = p.a(this, getSubtitle());
            TextView textView2 = arrayListA2.isEmpty() ? null : (TextView) Collections.max(arrayListA2, hVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i7 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i8 = 0; i8 < getChildCount(); i8++) {
                    View childAt = getChildAt(i8);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i7 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i7 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.b && textView != null) {
                    a(textView, pair);
                }
                if (this.c && textView2 != null) {
                    a(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i6 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i6);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i6++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.e;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.d;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        Drawable background = getBackground();
        if (background instanceof f) {
            ((f) background).j(f6);
        }
    }

    public void setLogoAdjustViewBounds(boolean z6) {
        Boolean bool = this.e;
        if (bool == null || bool.booleanValue() != z6) {
            this.e = Boolean.valueOf(z6);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.d != scaleType) {
            this.d = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f2184a != null) {
            drawable = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTint(drawable, this.f2184a.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.f2184a = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z6) {
        if (this.c != z6) {
            this.c = z6;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z6) {
        if (this.b != z6) {
            this.b = z6;
            requestLayout();
        }
    }
}
