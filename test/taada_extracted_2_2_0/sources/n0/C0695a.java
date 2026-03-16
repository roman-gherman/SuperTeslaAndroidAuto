package n0;

import android.graphics.RectF;
import com.google.android.material.shape.CornerSize;
import java.util.Arrays;

/* JADX INFO: renamed from: n0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0695a implements CornerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4163a;

    public C0695a(float f6) {
        this.f4163a = f6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0695a) && this.f4163a == ((C0695a) obj).f4163a;
    }

    @Override // com.google.android.material.shape.CornerSize
    public final float getCornerSize(RectF rectF) {
        return this.f4163a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4163a)});
    }
}
