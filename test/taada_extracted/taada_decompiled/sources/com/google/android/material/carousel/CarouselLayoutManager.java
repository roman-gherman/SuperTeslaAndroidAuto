package com.google.android.material.carousel;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;
import fr.sd.taada.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2290a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f2292g;
    public final c d = new c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2293h = 0;
    public final i e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f2291f = null;

    public CarouselLayoutManager() {
        requestLayout();
    }

    public static B.h h(List list, float f6, boolean z6) {
        float f7 = Float.MAX_VALUE;
        int i = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        float f8 = -3.4028235E38f;
        float f9 = Float.MAX_VALUE;
        float f10 = Float.MAX_VALUE;
        for (int i6 = 0; i6 < list.size(); i6++) {
            e eVar = (e) list.get(i6);
            float f11 = z6 ? eVar.b : eVar.f2300a;
            float fAbs = Math.abs(f11 - f6);
            if (f11 <= f6 && fAbs <= f7) {
                i = i6;
                f7 = fAbs;
            }
            if (f11 > f6 && fAbs <= f9) {
                i4 = i6;
                f9 = fAbs;
            }
            if (f11 <= f10) {
                i3 = i6;
                f10 = f11;
            }
            if (f11 > f8) {
                i5 = i6;
                f8 = f11;
            }
        }
        if (i == -1) {
            i = i3;
        }
        if (i4 == -1) {
            i4 = i5;
        }
        return new B.h((e) list.get(i), (e) list.get(i4));
    }

    public final int a(int i, int i3) {
        return i() ? i - i3 : i + i3;
    }

    public final void b(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iE = e(i);
        while (i < state.getItemCount()) {
            b bVarL = l(recycler, iE, i);
            float f6 = bVarL.b;
            B.h hVar = bVarL.c;
            if (j(f6, hVar)) {
                return;
            }
            iE = a(iE, (int) this.f2292g.f2301a);
            if (!k(f6, hVar)) {
                View view = bVarL.f2295a;
                float f7 = this.f2292g.f2301a / 2.0f;
                addView(view, -1);
                layoutDecoratedWithMargins(view, (int) (f6 - f7), getPaddingTop(), (int) (f6 + f7), getHeight() - getPaddingBottom());
            }
            i++;
        }
    }

    public final void c(RecyclerView.Recycler recycler, int i) {
        int iE = e(i);
        while (i >= 0) {
            b bVarL = l(recycler, iE, i);
            float f6 = bVarL.b;
            B.h hVar = bVarL.c;
            if (k(f6, hVar)) {
                return;
            }
            int i3 = (int) this.f2292g.f2301a;
            iE = i() ? iE + i3 : iE - i3;
            if (!j(f6, hVar)) {
                View view = bVarL.f2295a;
                float f7 = this.f2292g.f2301a / 2.0f;
                addView(view, 0);
                layoutDecoratedWithMargins(view, (int) (f6 - f7), getPaddingTop(), (int) (f6 + f7), getHeight() - getPaddingBottom());
            }
            i--;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        return (int) this.f2291f.f2302a.f2301a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.f2290a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.c - this.b;
    }

    public final float d(View view, float f6, B.h hVar) {
        e eVar = (e) hVar.b;
        float f7 = eVar.b;
        e eVar2 = (e) hVar.c;
        float f8 = eVar2.b;
        float f9 = eVar.f2300a;
        float f10 = eVar2.f2300a;
        float fB = W.a.b(f7, f8, f9, f10, f6);
        if (eVar2 != this.f2292g.b() && eVar != this.f2292g.d()) {
            return fB;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return (((1.0f - eVar2.c) + ((((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) / this.f2292g.f2301a)) * (f6 - f10)) + fB;
    }

    public final int e(int i) {
        return a((i() ? getWidth() : 0) - this.f2290a, (int) (this.f2292g.f2301a * i));
    }

    public final void f(RecyclerView.Recycler recycler, RecyclerView.State state) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Rect rect = new Rect();
            super.getDecoratedBoundsWithMargins(childAt, rect);
            float fCenterX = rect.centerX();
            if (!k(fCenterX, h(this.f2292g.b, fCenterX, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            Rect rect2 = new Rect();
            super.getDecoratedBoundsWithMargins(childAt2, rect2);
            float fCenterX2 = rect2.centerX();
            if (!j(fCenterX2, h(this.f2292g.b, fCenterX2, true))) {
                break;
            } else {
                removeAndRecycleView(childAt2, recycler);
            }
        }
        if (getChildCount() == 0) {
            c(recycler, this.f2293h - 1);
            b(this.f2293h, recycler, state);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            c(recycler, position - 1);
            b(position2 + 1, recycler, state);
        }
    }

    public final int g(f fVar, int i) {
        boolean zI = i();
        float f6 = fVar.f2301a;
        if (zI) {
            return (int) (((getWidth() - fVar.c().f2300a) - (i * f6)) - (f6 / 2.0f));
        }
        return (int) ((f6 / 2.0f) + ((i * f6) - fVar.a().f2300a));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterX = rect.centerX();
        B.h hVarH = h(this.f2292g.b, fCenterX, true);
        e eVar = (e) hVarH.b;
        float f6 = eVar.d;
        e eVar2 = (e) hVarH.c;
        float fWidth = (rect.width() - W.a.b(f6, eVar2.d, eVar.b, eVar2.b, fCenterX)) / 2.0f;
        rect.set((int) (rect.left + fWidth), rect.top, (int) (rect.right - fWidth), rect.bottom);
    }

    public final boolean i() {
        return getLayoutDirection() == 1;
    }

    public final boolean j(float f6, B.h hVar) {
        e eVar = (e) hVar.b;
        float f7 = eVar.d;
        e eVar2 = (e) hVar.c;
        float fB = W.a.b(f7, eVar2.d, eVar.b, eVar2.b, f6);
        int i = (int) f6;
        int i3 = (int) (fB / 2.0f);
        int i4 = i() ? i + i3 : i - i3;
        return i() ? i4 < 0 : i4 > getWidth();
    }

    public final boolean k(float f6, B.h hVar) {
        e eVar = (e) hVar.b;
        float f7 = eVar.d;
        e eVar2 = (e) hVar.c;
        int iA = a((int) f6, (int) (W.a.b(f7, eVar2.d, eVar.b, eVar2.b, f6) / 2.0f));
        return i() ? iA > getWidth() : iA < 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b l(RecyclerView.Recycler recycler, float f6, int i) {
        float f7 = this.f2292g.f2301a / 2.0f;
        View viewForPosition = recycler.getViewForPosition(i);
        measureChildWithMargins(viewForPosition, 0, 0);
        float fA = a((int) f6, (int) f7);
        B.h hVarH = h(this.f2292g.b, fA, false);
        float fD = d(viewForPosition, fA, hVarH);
        if (viewForPosition instanceof Maskable) {
            e eVar = (e) hVarH.b;
            float f8 = eVar.c;
            e eVar2 = (e) hVarH.c;
            ((Maskable) viewForPosition).setMaskXPercentage(W.a.b(f8, eVar2.c, eVar.f2300a, eVar2.f2300a, fA));
        }
        b bVar = new b();
        bVar.f2295a = viewForPosition;
        bVar.b = fD;
        bVar.c = hVarH;
        return bVar;
    }

    public final void m() {
        int i = this.c;
        int i3 = this.b;
        if (i <= i3) {
            this.f2292g = i() ? (f) B2.b.b(1, this.f2291f.c) : (f) B2.b.b(1, this.f2291f.b);
        } else {
            g gVar = this.f2291f;
            float f6 = this.f2290a;
            float f7 = i3;
            float f8 = i;
            float f9 = gVar.f2303f + f7;
            float f10 = f8 - gVar.f2304g;
            this.f2292g = f6 < f9 ? g.b(gVar.b, W.a.b(1.0f, 0.0f, f7, f9, f6), gVar.d) : f6 > f10 ? g.b(gVar.c, W.a.b(0.0f, 1.0f, f10, f8, f6), gVar.e) : gVar.f2302a;
        }
        List list = this.f2292g.b;
        c cVar = this.d;
        cVar.getClass();
        cVar.b = Collections.unmodifiableList(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void measureChildWithMargins(View view, int i, int i3) {
        if (!(view instanceof Maskable)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i4 = rect.left + rect.right + i;
        int i5 = rect.top + rect.bottom + i3;
        g gVar = this.f2291f;
        view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i4, (int) (gVar != null ? gVar.f2302a.f2301a : ((ViewGroup.MarginLayoutParams) layoutParams).width), true), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z6;
        boolean z7;
        int i;
        float f6;
        float f7;
        int i3;
        f fVar;
        float f8;
        float f9;
        h hVar;
        List list;
        int i4;
        int i5;
        int i6;
        if (state.getItemCount() <= 0) {
            removeAndRecycleAllViews(recycler);
            this.f2293h = 0;
            return;
        }
        boolean zI = i();
        boolean z8 = this.f2291f == null;
        if (z8) {
            View viewForPosition = recycler.getViewForPosition(0);
            measureChildWithMargins(viewForPosition, 0, 0);
            this.e.getClass();
            float containerWidth = getContainerWidth();
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
            float f10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            float dimension = viewForPosition.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_min) + f10;
            float dimension2 = viewForPosition.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_max) + f10;
            f6 = 1.0f;
            float measuredWidth = viewForPosition.getMeasuredWidth();
            f7 = 2.0f;
            float fMin = Math.min(measuredWidth + f10, containerWidth);
            float fClamp = MathUtils.clamp((measuredWidth / 3.0f) + f10, viewForPosition.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_min) + f10, viewForPosition.getContext().getResources().getDimension(R.dimen.m3_carousel_small_item_size_max) + f10);
            float f11 = (fMin + fClamp) / 2.0f;
            int[] iArr = i.b;
            int[] iArr2 = i.c;
            int i7 = Integer.MIN_VALUE;
            int i8 = 1;
            for (int i9 = 0; i9 < 2; i9++) {
                int i10 = iArr2[i9];
                if (i10 > i7) {
                    i7 = i10;
                }
            }
            float f12 = containerWidth - (i7 * f11);
            z6 = zI;
            int iMax = (int) Math.max(1.0d, Math.floor((f12 - ((iArr[0] > Integer.MIN_VALUE ? r6 : Integer.MIN_VALUE) * dimension2)) / fMin));
            int iCeil = (int) Math.ceil(containerWidth / fMin);
            int i11 = (iCeil - iMax) + 1;
            int[] iArr3 = new int[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                iArr3[i12] = iCeil - i12;
            }
            h hVar2 = null;
            int i13 = 0;
            int i14 = 1;
            loop2: while (true) {
                if (i13 >= i11) {
                    z7 = z8;
                    f8 = f10;
                    f9 = 0.0f;
                    hVar = hVar2;
                    break;
                }
                int i15 = iArr3[i13];
                int i16 = i11;
                int i17 = 0;
                f9 = 0.0f;
                while (i17 < 2) {
                    int i18 = iArr2[i17];
                    int i19 = i17;
                    z7 = z8;
                    h hVar3 = hVar2;
                    int i20 = 0;
                    for (int i21 = i8; i20 < i21; i21 = 1) {
                        f8 = f10;
                        int i22 = i14;
                        float f13 = dimension2;
                        float f14 = containerWidth;
                        h hVar4 = new h(i22, fClamp, dimension, f13, iArr[i20], f11, i18, fMin, i15, f14);
                        float f15 = hVar4.f2308h;
                        int i23 = i20;
                        if (hVar3 == null || f15 < hVar3.f2308h) {
                            if (f15 == 0.0f) {
                                hVar = hVar4;
                                break loop2;
                            }
                            hVar3 = hVar4;
                        }
                        i14 = i22 + 1;
                        i20 = i23 + 1;
                        f10 = f8;
                        dimension2 = f13;
                        containerWidth = f14;
                    }
                    i17 = i19 + 1;
                    hVar2 = hVar3;
                    z8 = z7;
                    i8 = 1;
                    dimension2 = dimension2;
                    containerWidth = containerWidth;
                }
                i13++;
                containerWidth = containerWidth;
                i11 = i16;
                z8 = z8;
                i8 = 1;
            }
            float dimension3 = viewForPosition.getContext().getResources().getDimension(R.dimen.m3_carousel_gone_size) + f8;
            float f16 = dimension3 / 2.0f;
            float f17 = f9 - f16;
            float f18 = (hVar.f2306f / 2.0f) + f9;
            int i24 = hVar.f2307g;
            float fMax = Math.max(0, i24 - 1);
            float f19 = hVar.f2306f;
            float f20 = (fMax * f19) + f18;
            float f21 = (f19 / 2.0f) + f20;
            int i25 = hVar.d;
            if (i25 > 0) {
                f20 = (hVar.e / 2.0f) + f21;
            }
            if (i25 > 0) {
                f21 = (hVar.e / 2.0f) + f20;
            }
            int i26 = hVar.c;
            float f22 = i26 > 0 ? (hVar.b / 2.0f) + f21 : f20;
            float containerWidth2 = getContainerWidth() + f16;
            float f23 = hVar.f2306f;
            float f24 = 1.0f - ((dimension3 - f8) / (f23 - f8));
            float f25 = 1.0f - ((hVar.b - f8) / (f23 - f8));
            float f26 = f8;
            float f27 = 1.0f - ((hVar.e - f26) / (f23 - f26));
            d dVar = new d(f23);
            dVar.a(f17, f24, dimension3, false);
            float f28 = hVar.f2306f;
            if (i24 > 0 && f28 > f9) {
                int i27 = 0;
                while (i27 < i24) {
                    dVar.a((i27 * f28) + f18, f9, f28, true);
                    i27++;
                    i24 = i24;
                    f9 = 0.0f;
                }
            }
            if (i25 > 0) {
                dVar.a(f20, f27, hVar.e, false);
            }
            if (i26 > 0) {
                float f29 = hVar.b;
                if (i26 > 0 && f29 > 0.0f) {
                    for (int i28 = 0; i28 < i26; i28++) {
                        dVar.a((i28 * f29) + f22, f25, f29, false);
                    }
                }
            }
            dVar.a(containerWidth2, f24, dimension3, false);
            f fVarB = dVar.b();
            if (z6) {
                d dVar2 = new d(fVarB.f2301a);
                float f30 = fVarB.b().b - (fVarB.b().d / 2.0f);
                List list2 = fVarB.b;
                int size = list2.size() - 1;
                while (size >= 0) {
                    e eVar = (e) list2.get(size);
                    float f31 = eVar.d;
                    dVar2.a((f31 / 2.0f) + f30, eVar.c, f31, size >= fVarB.c && size <= fVarB.d);
                    f30 += eVar.d;
                    size--;
                }
                fVarB = dVar2.b();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(fVarB);
            int i29 = 0;
            while (true) {
                list = fVarB.b;
                if (i29 >= list.size()) {
                    i4 = -1;
                    break;
                } else {
                    if (((e) list.get(i29)).b >= 0.0f) {
                        i4 = i29;
                        break;
                    }
                    i29++;
                }
            }
            float f32 = fVarB.a().b - (fVarB.a().d / 2.0f);
            int i30 = fVarB.d;
            int i31 = fVarB.c;
            if (f32 > 0.0f && fVarB.a() != fVarB.b() && i4 != -1) {
                int i32 = (i31 - 1) - i4;
                float f33 = fVarB.b().b - (fVarB.b().d / 2.0f);
                for (int i33 = 0; i33 <= i32; i33++) {
                    f fVar2 = (f) androidx.constraintlayout.core.motion.a.g(1, arrayList);
                    int size2 = list.size() - 1;
                    int i34 = (i4 + i33) - 1;
                    if (i34 >= 0) {
                        float f34 = ((e) list.get(i34)).c;
                        int size3 = fVar2.d;
                        while (true) {
                            List list3 = fVar2.b;
                            if (size3 >= list3.size()) {
                                size3 = list3.size() - 1;
                                break;
                            } else if (f34 == ((e) list3.get(size3)).c) {
                                break;
                            } else {
                                size3++;
                            }
                        }
                        size2 = size3 - 1;
                    }
                    arrayList.add(g.c(fVar2, i4, size2, f33, (i31 - i33) - 1, (i30 - i33) - 1));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(fVarB);
            int size4 = list.size() - 1;
            while (true) {
                if (size4 < 0) {
                    i5 = -1;
                    break;
                } else {
                    if (((e) list.get(size4)).b <= getContainerWidth()) {
                        i5 = size4;
                        break;
                    }
                    size4--;
                }
            }
            if ((fVarB.c().d / 2.0f) + fVarB.c().b >= getContainerWidth() || fVarB.c() == fVarB.d()) {
                i = -1;
            } else {
                i = -1;
                if (i5 != -1) {
                    int i35 = i5 - i30;
                    float f35 = fVarB.b().b - (fVarB.b().d / 2.0f);
                    for (int i36 = 0; i36 < i35; i36++) {
                        f fVar3 = (f) androidx.constraintlayout.core.motion.a.g(1, arrayList2);
                        int i37 = (i5 - i36) + 1;
                        if (i37 < list.size()) {
                            float f36 = ((e) list.get(i37)).c;
                            int i38 = fVar3.c - 1;
                            while (true) {
                                if (i38 < 0) {
                                    i38 = 0;
                                    break;
                                } else if (f36 == ((e) fVar3.b.get(i38)).c) {
                                    break;
                                } else {
                                    i38--;
                                }
                            }
                            i6 = i38 + 1;
                        } else {
                            i6 = 0;
                        }
                        arrayList2.add(g.c(fVar3, i5, i6, f35, i31 + i36 + 1, i30 + i36 + 1));
                    }
                }
            }
            this.f2291f = new g(fVarB, arrayList, arrayList2);
        } else {
            z6 = zI;
            z7 = z8;
            i = -1;
            f6 = 1.0f;
            f7 = 2.0f;
        }
        g gVar = this.f2291f;
        boolean zI2 = i();
        f fVar4 = zI2 ? (f) B2.b.b(1, gVar.c) : (f) B2.b.b(1, gVar.b);
        e eVarC = zI2 ? fVar4.c() : fVar4.a();
        int paddingStart = getPaddingStart();
        if (zI2) {
            i = 1;
        }
        float f37 = paddingStart * i;
        int i39 = (int) eVarC.f2300a;
        int i40 = (int) (fVar4.f2301a / f7);
        int width = (int) ((f37 + (i() ? getWidth() : 0)) - (i() ? i39 + i40 : i39 - i40));
        g gVar2 = this.f2291f;
        boolean zI3 = i();
        if (zI3) {
            i3 = 1;
            fVar = (f) B2.b.b(1, gVar2.b);
        } else {
            i3 = 1;
            fVar = (f) B2.b.b(1, gVar2.c);
        }
        e eVarA = zI3 ? fVar.a() : fVar.c();
        float itemCount = (((state.getItemCount() - i3) * fVar.f2301a) + getPaddingEnd()) * (zI3 ? -1.0f : f6);
        float width2 = eVarA.f2300a - (i() ? getWidth() : 0);
        int width3 = Math.abs(width2) > Math.abs(itemCount) ? 0 : (int) ((itemCount - width2) + ((i() ? 0 : getWidth()) - eVarA.f2300a));
        int i41 = z6 ? width3 : width;
        this.b = i41;
        if (z6) {
            width3 = width;
        }
        this.c = width3;
        if (z7) {
            this.f2290a = width;
        } else {
            int i42 = this.f2290a;
            this.f2290a = (i42 < i41 ? i41 - i42 : i42 > width3 ? width3 - i42 : 0) + i42;
        }
        this.f2293h = MathUtils.clamp(this.f2293h, 0, state.getItemCount());
        m();
        detachAndScrapAttachedViews(recycler);
        f(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.f2293h = 0;
        } else {
            this.f2293h = getPosition(getChildAt(0));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z6, boolean z7) {
        g gVar = this.f2291f;
        if (gVar == null) {
            return false;
        }
        int iG = g(gVar.f2302a, getPosition(view)) - this.f2290a;
        if (z7 || iG == 0) {
            return false;
        }
        recyclerView.scrollBy(iG, 0);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        int i3 = this.f2290a;
        int i4 = this.b;
        int i5 = this.c;
        int i6 = i3 + i;
        if (i6 < i4) {
            i = i4 - i3;
        } else if (i6 > i5) {
            i = i5 - i3;
        }
        this.f2290a = i3 + i;
        m();
        float f6 = this.f2292g.f2301a / 2.0f;
        int iE = e(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            float fA = a(iE, (int) f6);
            B.h hVarH = h(this.f2292g.b, fA, false);
            float fD = d(childAt, fA, hVarH);
            if (childAt instanceof Maskable) {
                e eVar = (e) hVarH.b;
                float f7 = eVar.c;
                e eVar2 = (e) hVarH.c;
                ((Maskable) childAt).setMaskXPercentage(W.a.b(f7, eVar2.c, eVar.f2300a, eVar2.f2300a, fA));
            }
            super.getDecoratedBoundsWithMargins(childAt, rect);
            childAt.offsetLeftAndRight((int) (fD - (rect.left + f6)));
            iE = a(iE, (int) this.f2292g.f2301a);
        }
        f(recycler, state);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i) {
        g gVar = this.f2291f;
        if (gVar == null) {
            return;
        }
        this.f2290a = g(gVar.f2302a, i);
        this.f2293h = MathUtils.clamp(i, 0, Math.max(0, getItemCount() - 1));
        m();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.setTargetPosition(i);
        startSmoothScroll(aVar);
    }
}
