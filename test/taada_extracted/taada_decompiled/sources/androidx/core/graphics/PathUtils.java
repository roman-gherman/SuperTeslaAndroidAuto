package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class PathUtils {

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float[] approximate(Path path, float f6) {
            return path.approximate(f6);
        }
    }

    private PathUtils() {
    }

    public static Collection<PathSegment> flatten(Path path) {
        return flatten(path, 0.5f);
    }

    public static Collection<PathSegment> flatten(Path path, float f6) {
        float[] fArrApproximate = Api26Impl.approximate(path, f6);
        int length = fArrApproximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 1; i < length; i++) {
            int i3 = i * 3;
            int i4 = (i - 1) * 3;
            float f7 = fArrApproximate[i3];
            float f8 = fArrApproximate[i3 + 1];
            float f9 = fArrApproximate[i3 + 2];
            float f10 = fArrApproximate[i4];
            float f11 = fArrApproximate[i4 + 1];
            float f12 = fArrApproximate[i4 + 2];
            if (f7 != f10 && (f8 != f11 || f9 != f12)) {
                arrayList.add(new PathSegment(new PointF(f11, f12), f10, new PointF(f8, f9), f7));
            }
        }
        return arrayList;
    }
}
