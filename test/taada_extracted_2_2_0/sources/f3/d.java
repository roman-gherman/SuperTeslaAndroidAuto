package f3;

import a3.AbstractC0162z;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeParameterDescriptor f3195a;
    public final AbstractC0162z b;
    public final AbstractC0162z c;

    public d(TypeParameterDescriptor typeParameter, AbstractC0162z inProjection, AbstractC0162z outProjection) {
        h.f(typeParameter, "typeParameter");
        h.f(inProjection, "inProjection");
        h.f(outProjection, "outProjection");
        this.f3195a = typeParameter;
        this.b = inProjection;
        this.c = outProjection;
    }
}
