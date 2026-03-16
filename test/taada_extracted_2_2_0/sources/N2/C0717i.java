package n2;

import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: renamed from: n2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0717i extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.f f4246a;
    public final SimpleTypeMarker b;

    public C0717i(L2.f fVar, SimpleTypeMarker underlyingType) {
        kotlin.jvm.internal.h.f(underlyingType, "underlyingType");
        this.f4246a = fVar;
        this.b = underlyingType;
    }

    public final String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.f4246a + ", underlyingType=" + this.b + ')';
    }
}
