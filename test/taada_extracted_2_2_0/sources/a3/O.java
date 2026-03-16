package a3;

import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class O extends P {
    public static final O b = new O(0);
    public static final O c = new O(1);
    public static final O d = new O(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1535a;

    public /* synthetic */ O(int i) {
        this.f1535a = i;
    }

    @Override // a3.P
    public final SimpleTypeMarker a(Q state, KotlinTypeMarker type) {
        switch (this.f1535a) {
            case 0:
                kotlin.jvm.internal.h.f(state, "state");
                kotlin.jvm.internal.h.f(type, "type");
                return state.c.lowerBoundIfFlexible(type);
            case 1:
                kotlin.jvm.internal.h.f(state, "state");
                kotlin.jvm.internal.h.f(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            default:
                kotlin.jvm.internal.h.f(state, "state");
                kotlin.jvm.internal.h.f(type, "type");
                return state.c.upperBoundIfFlexible(type);
        }
    }
}
