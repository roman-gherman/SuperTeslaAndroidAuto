package n0;

import android.graphics.RectF;
import com.google.android.material.shape.CornerSize;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements CornerSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CornerSize f4163a;
    public final float b;

    public b(float f6, CornerSize cornerSize) {
        while (cornerSize instanceof b) {
            cornerSize = ((b) cornerSize).f4163a;
            f6 += ((b) cornerSize).b;
        }
        this.f4163a = cornerSize;
        this.b = f6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4163a.equals(bVar.f4163a) && this.b == bVar.b;
    }

    @Override // com.google.android.material.shape.CornerSize
    public final float getCornerSize(RectF rectF) {
        return Math.max(0.0f, this.f4163a.getCornerSize(rectF) + this.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4163a, Float.valueOf(this.b)});
    }
}
