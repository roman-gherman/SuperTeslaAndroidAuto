package n0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.shape.CornerSize;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public io.ktor.utils.io.jvm.javaio.q f4200a = new h();
    public io.ktor.utils.io.jvm.javaio.q b = new h();
    public io.ktor.utils.io.jvm.javaio.q c = new h();
    public io.ktor.utils.io.jvm.javaio.q d = new h();
    public CornerSize e = new C0695a(0.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CornerSize f4201f = new C0695a(0.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CornerSize f4202g = new C0695a(0.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CornerSize f4203h = new C0695a(0.0f);
    public d i = new d(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f4204j = new d(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f4205k = new d(0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f4206l = new d(0);

    public static i a(Context context, int i, int i3, C0695a c0695a) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i3 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i3);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(V.a.f1348B);
        try {
            int i4 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i5 = typedArrayObtainStyledAttributes.getInt(3, i4);
            int i6 = typedArrayObtainStyledAttributes.getInt(4, i4);
            int i7 = typedArrayObtainStyledAttributes.getInt(2, i4);
            int i8 = typedArrayObtainStyledAttributes.getInt(1, i4);
            CornerSize cornerSizeC = c(typedArrayObtainStyledAttributes, 5, c0695a);
            CornerSize cornerSizeC2 = c(typedArrayObtainStyledAttributes, 8, cornerSizeC);
            CornerSize cornerSizeC3 = c(typedArrayObtainStyledAttributes, 9, cornerSizeC);
            CornerSize cornerSizeC4 = c(typedArrayObtainStyledAttributes, 7, cornerSizeC);
            CornerSize cornerSizeC5 = c(typedArrayObtainStyledAttributes, 6, cornerSizeC);
            i iVar = new i();
            io.ktor.utils.io.jvm.javaio.q qVarF = k1.j.f(i5);
            iVar.f4193a = qVarF;
            i.b(qVarF);
            iVar.e = cornerSizeC2;
            io.ktor.utils.io.jvm.javaio.q qVarF2 = k1.j.f(i6);
            iVar.b = qVarF2;
            i.b(qVarF2);
            iVar.f4194f = cornerSizeC3;
            io.ktor.utils.io.jvm.javaio.q qVarF3 = k1.j.f(i7);
            iVar.c = qVarF3;
            i.b(qVarF3);
            iVar.f4195g = cornerSizeC4;
            io.ktor.utils.io.jvm.javaio.q qVarF4 = k1.j.f(i8);
            iVar.d = qVarF4;
            i.b(qVarF4);
            iVar.f4196h = cornerSizeC5;
            return iVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static i b(Context context, AttributeSet attributeSet, int i, int i3) {
        C0695a c0695a = new C0695a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V.a.f1365t, i, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, c0695a);
    }

    public static CornerSize c(TypedArray typedArray, int i, CornerSize cornerSize) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i3 = typedValuePeekValue.type;
            if (i3 == 5) {
                return new C0695a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i3 == 6) {
                return new g(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cornerSize;
    }

    public final boolean d(RectF rectF) {
        boolean z6 = this.f4206l.getClass().equals(d.class) && this.f4204j.getClass().equals(d.class) && this.i.getClass().equals(d.class) && this.f4205k.getClass().equals(d.class);
        float cornerSize = this.e.getCornerSize(rectF);
        return z6 && ((this.f4201f.getCornerSize(rectF) > cornerSize ? 1 : (this.f4201f.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.f4203h.getCornerSize(rectF) > cornerSize ? 1 : (this.f4203h.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.f4202g.getCornerSize(rectF) > cornerSize ? 1 : (this.f4202g.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0) && ((this.b instanceof h) && (this.f4200a instanceof h) && (this.c instanceof h) && (this.d instanceof h));
    }

    public final i e() {
        i iVar = new i();
        iVar.f4193a = this.f4200a;
        iVar.b = this.b;
        iVar.c = this.c;
        iVar.d = this.d;
        iVar.e = this.e;
        iVar.f4194f = this.f4201f;
        iVar.f4195g = this.f4202g;
        iVar.f4196h = this.f4203h;
        iVar.i = this.i;
        iVar.f4197j = this.f4204j;
        iVar.f4198k = this.f4205k;
        iVar.f4199l = this.f4206l;
        return iVar;
    }
}
