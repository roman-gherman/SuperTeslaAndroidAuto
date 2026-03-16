package b0;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;

/* JADX INFO: renamed from: b0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0229c implements ViewUtils$OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1690a;
    public final /* synthetic */ BottomSheetBehavior b;

    public C0229c(BottomSheetBehavior bottomSheetBehavior, boolean z6) {
        this.b = bottomSheetBehavior;
        this.f1690a = z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
    @Override // com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r11, androidx.core.view.WindowInsetsCompat r12, com.google.android.material.internal.r r13) {
        /*
            r10 = this;
            int r0 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
            androidx.core.graphics.Insets r0 = r12.getInsets(r0)
            int r1 = androidx.core.view.WindowInsetsCompat.Type.mandatorySystemGestures()
            androidx.core.graphics.Insets r1 = r12.getInsets(r1)
            int r2 = r0.top
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = r10.b
            r3.f2252w = r2
            boolean r2 = com.google.android.material.internal.s.b(r11)
            int r4 = r11.getPaddingBottom()
            int r5 = r11.getPaddingLeft()
            int r6 = r11.getPaddingRight()
            boolean r7 = r3.f2246o
            if (r7 == 0) goto L33
            int r4 = r12.getSystemWindowInsetBottom()
            r3.f2251v = r4
            int r7 = r13.d
            int r4 = r4 + r7
        L33:
            boolean r7 = r3.f2247p
            if (r7 == 0) goto L41
            if (r2 == 0) goto L3c
            int r5 = r13.c
            goto L3e
        L3c:
            int r5 = r13.f2507a
        L3e:
            int r7 = r0.left
            int r5 = r5 + r7
        L41:
            boolean r7 = r3.q
            if (r7 == 0) goto L50
            if (r2 == 0) goto L4a
            int r13 = r13.f2507a
            goto L4c
        L4a:
            int r13 = r13.c
        L4c:
            int r2 = r0.right
            int r6 = r13 + r2
        L50:
            android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
            boolean r2 = r3.f2249s
            r7 = 1
            if (r2 == 0) goto L65
            int r2 = r13.leftMargin
            int r8 = r0.left
            if (r2 == r8) goto L65
            r13.leftMargin = r8
            r2 = r7
            goto L66
        L65:
            r2 = 0
        L66:
            boolean r8 = r3.f2250t
            if (r8 == 0) goto L73
            int r8 = r13.rightMargin
            int r9 = r0.right
            if (r8 == r9) goto L73
            r13.rightMargin = r9
            r2 = r7
        L73:
            boolean r8 = r3.u
            if (r8 == 0) goto L80
            int r8 = r13.topMargin
            int r0 = r0.top
            if (r8 == r0) goto L80
            r13.topMargin = r0
            goto L81
        L80:
            r7 = r2
        L81:
            if (r7 == 0) goto L86
            r11.setLayoutParams(r13)
        L86:
            int r13 = r11.getPaddingTop()
            r11.setPadding(r5, r13, r6, r4)
            boolean r11 = r10.f1690a
            if (r11 == 0) goto L95
            int r13 = r1.bottom
            r3.f2244m = r13
        L95:
            boolean r13 = r3.f2246o
            if (r13 != 0) goto L9d
            if (r11 == 0) goto L9c
            goto L9d
        L9c:
            return r12
        L9d:
            r3.o()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.C0229c.onApplyWindowInsets(android.view.View, androidx.core.view.WindowInsetsCompat, com.google.android.material.internal.r):androidx.core.view.WindowInsetsCompat");
    }
}
