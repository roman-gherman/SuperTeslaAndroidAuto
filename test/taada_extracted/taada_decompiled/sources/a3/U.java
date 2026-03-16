package a3;

import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public abstract class U implements TypeProjection {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeProjection)) {
            return false;
        }
        TypeProjection typeProjection = (TypeProjection) obj;
        return isStarProjection() == typeProjection.isStarProjection() && getProjectionKind() == typeProjection.getProjectionKind() && getType().equals(typeProjection.getType());
    }

    public final int hashCode() {
        int iHashCode = getProjectionKind().hashCode();
        if (b0.m(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }

    public final String toString() {
        if (isStarProjection()) {
            return Marker.ANY_MARKER;
        }
        if (getProjectionKind() == d0.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + " " + getType();
    }
}
