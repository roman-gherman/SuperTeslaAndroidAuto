package X2;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NameResolver f1448a;
    public final I2.f b;
    public final SourceElement c;

    public r(NameResolver nameResolver, I2.f fVar, SourceElement sourceElement) {
        this.f1448a = nameResolver;
        this.b = fVar;
        this.c = sourceElement;
    }

    public abstract L2.c a();

    public final String toString() {
        return getClass().getSimpleName() + ": " + a();
    }
}
