package n0;

import android.graphics.RectF;
import com.google.android.material.shape.CornerSize;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g implements CornerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4192a;

    public g(float f6) {
        this.f4192a = f6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f4192a == ((g) obj).f4192a;
    }

    @Override // com.google.android.material.shape.CornerSize
    public final float getCornerSize(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f4192a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4192a)});
    }
}
