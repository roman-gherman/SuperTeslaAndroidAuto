package f3;

import a3.K;
import a3.S;
import a3.d0;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends S {
    @Override // a3.S
    public final TypeProjection g(TypeConstructor key) {
        h.f(key, "key");
        CapturedTypeConstructor capturedTypeConstructor = key instanceof CapturedTypeConstructor ? (CapturedTypeConstructor) key : null;
        if (capturedTypeConstructor == null) {
            return null;
        }
        if (capturedTypeConstructor.getProjection().isStarProjection()) {
            return new K(capturedTypeConstructor.getProjection().getType(), d0.OUT_VARIANCE);
        }
        return capturedTypeConstructor.getProjection();
    }
}
