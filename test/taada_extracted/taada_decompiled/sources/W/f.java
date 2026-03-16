package W;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f1383a = new SimpleArrayMap();
    public final SimpleArrayMap b = new SimpleArrayMap();

    public static f a(Context context, int i) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return b(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return b(arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    public static f b(ArrayList arrayList) {
        f fVar = new f();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animator animator = (Animator) arrayList.get(i);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            fVar.b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.d;
            }
            g gVar = new g();
            gVar.d = 0;
            gVar.e = 1;
            gVar.f1384a = startDelay;
            gVar.b = duration;
            gVar.c = interpolator;
            gVar.d = objectAnimator.getRepeatCount();
            gVar.e = objectAnimator.getRepeatMode();
            fVar.f1383a.put(propertyName, gVar);
        }
        return fVar;
    }

    public final g c(String str) {
        SimpleArrayMap simpleArrayMap = this.f1383a;
        if (simpleArrayMap.get(str) != null) {
            return (g) simpleArrayMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return this.f1383a.equals(((f) obj).f1383a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1383a.hashCode();
    }

    public final String toString() {
        return "\n" + f.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f1383a + "}\n";
    }
}
