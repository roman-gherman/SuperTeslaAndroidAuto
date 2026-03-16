package com.google.android.material.transformation;

import B.h;
import W.a;
import W.c;
import W.d;
import W.e;
import W.f;
import W.g;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import b0.C0228b;
import com.google.android.material.circularreveal.CircularRevealWidget;
import e0.C0422a;
import fr.sd.taada.R;
import java.util.ArrayList;
import s0.C0807a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;
    public final RectF d;
    public final RectF e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f2760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2762h;

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f2760f = new int[2];
    }

    public static Pair c(float f6, float f7, boolean z6, h hVar) {
        g gVarC;
        g gVarC2;
        if (f6 == 0.0f || f7 == 0.0f) {
            gVarC = ((f) hVar.b).c("translationXLinear");
            gVarC2 = ((f) hVar.b).c("translationYLinear");
        } else if ((!z6 || f7 >= 0.0f) && (z6 || f7 <= 0.0f)) {
            gVarC = ((f) hVar.b).c("translationXCurveDownwards");
            gVarC2 = ((f) hVar.b).c("translationYCurveDownwards");
        } else {
            gVarC = ((f) hVar.b).c("translationXCurveUpwards");
            gVarC2 = ((f) hVar.b).c("translationYCurveUpwards");
        }
        return new Pair(gVarC, gVarC2);
    }

    public static float f(h hVar, g gVar, float f6) {
        long j6 = gVar.f1384a;
        g gVarC = ((f) hVar.b).c("expansion");
        return a.a(f6, 0.0f, gVar.b().getInterpolation((((gVarC.f1384a + gVarC.b) + 17) - j6) / gVar.b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet b(View view, View view2, boolean z6, boolean z7) {
        ObjectAnimator objectAnimatorOfFloat;
        int i;
        float f6;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ObjectAnimator objectAnimatorOfFloat4;
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2;
        h hVarH = h(view2.getContext(), z6);
        if (z6) {
            this.f2761g = view.getTranslationX();
            this.f2762h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z6) {
            if (!z7) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        ((f) hVarH.b).c("elevation").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        RectF rectF = this.d;
        float fD = d(view, view2, (W.h) hVarH.c);
        float fE = e(view, view2, (W.h) hVarH.c);
        Pair pairC = c(fD, fE, z6, hVarH);
        g gVar = (g) pairC.first;
        g gVar2 = (g) pairC.second;
        RectF rectF2 = this.e;
        if (z6) {
            i = 0;
            if (!z7) {
                view2.setTranslationX(-fD);
                view2.setTranslationY(-fE);
            }
            f6 = 0.0f;
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            float f7 = f(hVarH, gVar, -fD);
            float f8 = f(hVarH, gVar2, -fE);
            Rect rect = this.c;
            view2.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            g(view2, rectF2);
            rectF2.offset(f7, f8);
            rectF2.intersect(rectF);
            rectF.set(rectF2);
            objectAnimatorOfFloat3 = objectAnimatorOfFloat6;
            objectAnimatorOfFloat2 = objectAnimatorOfFloat5;
        } else {
            i = 0;
            f6 = 0.0f;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fD);
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fE);
        }
        gVar.a(objectAnimatorOfFloat2);
        gVar2.a(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat3);
        rectF.width();
        rectF.height();
        float fD2 = d(view, view2, (W.h) hVarH.c);
        float fE2 = e(view, view2, (W.h) hVarH.c);
        Pair pairC2 = c(fD2, fE2, z6, hVarH);
        g gVar3 = (g) pairC2.first;
        g gVar4 = (g) pairC2.second;
        Property property = View.TRANSLATION_X;
        if (!z6) {
            fD2 = this.f2761g;
        }
        float[] fArr = new float[1];
        fArr[i] = fD2;
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        if (!z6) {
            fE2 = this.f2762h;
        }
        float[] fArr2 = new float[1];
        fArr2[i] = fE2;
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        gVar3.a(objectAnimatorOfFloat7);
        gVar4.a(objectAnimatorOfFloat8);
        arrayList.add(objectAnimatorOfFloat7);
        arrayList.add(objectAnimatorOfFloat8);
        boolean z8 = view2 instanceof CircularRevealWidget;
        if (z8 && (view instanceof ImageView)) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z6) {
                    if (!z7) {
                        drawable.setAlpha(255);
                    }
                    objectAnimatorOfInt2 = ObjectAnimator.ofInt(drawable, e.f1382a, i);
                } else {
                    objectAnimatorOfInt2 = ObjectAnimator.ofInt(drawable, e.f1382a, 255);
                }
                objectAnimatorOfInt2.addUpdateListener(new C0228b(view2, 3));
                ((f) hVarH.b).c("iconFade").a(objectAnimatorOfInt2);
                arrayList.add(objectAnimatorOfInt2);
                arrayList2.add(new b(circularRevealWidget, drawable));
            }
        }
        if (z8) {
            W.h hVar = (W.h) hVarH.c;
            g(view, rectF);
            rectF.offset(this.f2761g, this.f2762h);
            g(view2, rectF2);
            rectF2.offset(-d(view, view2, hVar), f6);
            rectF.centerX();
            W.h hVar2 = (W.h) hVarH.c;
            g(view, rectF);
            rectF.offset(this.f2761g, this.f2762h);
            g(view2, rectF2);
            rectF2.offset(0.0f, -e(view, view2, hVar2));
            rectF.centerY();
            throw new ClassCastException();
        }
        if (z8) {
            CircularRevealWidget circularRevealWidget2 = (CircularRevealWidget) view2;
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : i;
            int i3 = 16777215 & colorForState;
            if (z6) {
                if (!z7) {
                    circularRevealWidget2.setCircularRevealScrimColor(colorForState);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(circularRevealWidget2, C0422a.f3128a, i3);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(circularRevealWidget2, C0422a.f3128a, colorForState);
            }
            objectAnimatorOfInt.setEvaluator(c.f1380a);
            ((f) hVarH.b).c(TypedValues.Custom.S_COLOR).a(objectAnimatorOfInt);
            arrayList.add(objectAnimatorOfInt);
        }
        boolean z9 = view2 instanceof ViewGroup;
        if (z9) {
            View viewFindViewById = view2.findViewById(R.id.mtrl_child_content_container);
            ViewGroup viewGroup = null;
            if (viewFindViewById != null) {
                if (viewFindViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) viewFindViewById;
                }
            } else if (z9) {
                viewGroup = (ViewGroup) view2;
            }
            if (viewGroup != null) {
                if (z6) {
                    if (!z7) {
                        d.f1381a.set(viewGroup, Float.valueOf(f6));
                    }
                    d dVar = d.f1381a;
                    float[] fArr3 = new float[1];
                    fArr3[i] = 1.0f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, dVar, fArr3);
                } else {
                    d dVar2 = d.f1381a;
                    float[] fArr4 = new float[1];
                    fArr4[i] = f6;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, dVar2, fArr4);
                }
                ((f) hVarH.b).c("contentFade").a(objectAnimatorOfFloat4);
                arrayList.add(objectAnimatorOfFloat4);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        W.b.a(animatorSet, arrayList);
        animatorSet.addListener(new C0807a(z6, view2, view));
        int size = arrayList2.size();
        for (int i4 = i; i4 < size; i4++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i4));
        }
        return animatorSet;
    }

    public final float d(View view, View view2, W.h hVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        g(view, rectF);
        rectF.offset(this.f2761g, this.f2762h);
        g(view2, rectF2);
        hVar.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float e(View view, View view2, W.h hVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        g(view, rectF);
        rectF.offset(this.f2761g, this.f2762h);
        g(view2, rectF2);
        hVar.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void g(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f2760f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract h h(Context context, boolean z6);

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f2760f = new int[2];
    }
}
